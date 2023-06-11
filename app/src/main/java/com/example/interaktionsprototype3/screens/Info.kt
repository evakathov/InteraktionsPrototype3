package com.example.interaktionsprototype3.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun InfoScreen() {
    val questionAnswerPairs = listOf(
        Pair("1. Hvilke interaktioner kan du finde?", "I denne database er lægemiddelinteraktion defineret som en ændring i enten farmakodynamikken og/eller farmakokinetikken af et lægemiddel forårsaget af samtidig behandling med et andet lægemiddel.\n" +
                "Interaktionsdatabasen medtager farmakodynamiske interaktioner, der ikke er umiddelbart indlysende additive (fx med forskellig virkningsmekanisme), og som kan have væsentlig klinisk betydning.\n" +
                "Andre faktorer, som interagerer med eller ændrer lægemiddelvirkningen så som næringsmidler (f.eks. fødemidler og kosttilskud) og nydelsesmidler (f.eks. alkohol og tobak), er ikke medtaget. Dog er medtaget lægemiddelinteraktioner med grapefrugtjuice, tranebærjuice og visse naturlægemidler."),
        Pair("2. Hvor stammer data fra?", "Interaktionsdatabasens primære evidensgrundlag er offentligt publicerede, peer-reviewed original interaktionslitteratur (kliniske studier udført på mennesker samt kasuistikker) publiceret i PubMed og Embase. Desuden er interaktioner hvor data er beskrevet i produktresuméer medtaget."),
        Pair("3. Hvad betyder symbolerne i interaktionsdatabasen?", "I Interaktionsdatabasen findes fem forskellige symboler:\n"
                + "\n" + "Det røde symbol (tommelfingeren, der peger nedad) betyder, at den pågældende præparatkombination bør undgås. Denne anbefaling bliver givet i tilfælde hvor det vurderes, at den kliniske betydning er udtalt, og hvor dosisjustering ikke er mulig, eller hvis der er ligeværdige alternativer til et eller begge af de interagerende stoffer. Det røde symbol vælges også i tilfælde, hvor der vurderes at være ringe dokumenteret effekt af et eller begge stoffer, (hvor anvendelse derfor ikke findes strengt nødvendig), f.eks. for visse naturlægemidler.\n"
                + "\n" + "Det gule symbol (den løftede pegefinger) betyder, at kombinationen kan anvendes under visse forholdsregler. Denne anbefaling gives i tilfælde, hvor det vurderes, at den kliniske betydning er moderat til udtalt, samtidig med at den negative kliniske effekt af interaktionen kan modvirkes, enten gennem ned- eller opjustering af dosis, eller ved at forskyde indtagelsestidspunktet for det ene præparat. Anbefalingen gives også, hvis det vurderes, at kombinationen kan anvendes under forudsætning af øget opmærksomhed på effekt og/eller bivirkninger.\n"
                + "\n"+ "Det grønne symbol (tommelfingeren, der peger opad) betyder, at kombinationen kan anvendes. Denne anbefaling gives i tilfælde, hvor det vurderes, at den kliniske betydning er uvæsentlig eller ikke tilstede. \n"
                + "\n" +"Det blå symbol (udråbstegnet) fremkommer i tilfælde, hvor der søges på et specifikt præparat eller en præparatkombination, som ikke findes beskrevet i Interaktionsdatabasen, men hvor der findes andre beskrevne interaktioner mellem stoffer i stofgruppen, som muligvis kan være relevante for søgningen. \n"
                + "\n"+ "Det grå symbol (spørgsmålstegnet) fremkommer i tilfælde, hvor der er søgt på et præparat eller en præparatkombination, som (endnu) ikke er beskrevet i Interaktionsdatabasen, og hvor der heller ikke findes beskrivelser af andre præparatkombinationer mellem de to stofgrupper. En manglende beskrivelse er ensbetydende med, at Lægemiddelstyrelsen ikke har kendskab til videnskabelige undersøgelser, der undersøger en interaktion mellem den pågældende præparatkombination, og heller ikke til kasuistiske beskrivelser af en mulig interaktion. Der kan også være tale om en kombination, hvor der ikke kan drages konklusioner på baggrund af nuværende viden."),
        Pair("4. Hvor ofte bliver databasen opdateret?", "Opdatering af databasens faglige indhold foregår via litteratursøgninger som leveres via Det Kongelige Bibliotek. Litteratursøgningerne er struktureret efter veldefinerede søgekriterier og bliver løbende evalueret. Endvidere foretages yderligere håndsøgning i referencelister som kvalitetssikring af litteratursøgningerne.\n" +
                "\n" +
                "Databasen bliver opdateret løbende.\n"),
        Pair("5. Hvem er ansvarlig for det faglige indhold i databasen?", "Lægemiddelstyrelsens enhed Regulatorisk & Generel Medicin står for opdatering og vedligehold af Interaktionsdatabasens indhold.\n" +
                "\n" +
                "Vedligehold og opdatering af databasen foretages af den faglige arbejdsgruppe, som består af 1 akademisk medarbejder og 2 studerende.\n" +
                "\n" +
                "Arbejdsgruppen samarbejder med en deltidsansat speciallæge i klinisk farmakologi omkring den kliniske vurdering af lægemiddelinteraktionerne."),
        Pair("6. Hvorfor er der uoverensstemmelse imellem oplysninger i interaktionsdatabasen og medicin.dk, henholdsvis produktinformationen?", "Interaktionsdatabasen er et opslagsværktøj, der beskriver evidensbaserede interaktioner, det vil sige interaktioner, der er dokumenteret ved publicerede kliniske studier og/eller kasuistikker. Der vil således kunne forekomme uoverensstemmelse mellem andre opslagsværker, som er opbygget efter andre principper og evidenskriterier."),
        Pair("7. Hvor lang tid går der fra et lægemiddel er markedsført til det er med i databasen?", "Der inkluderes kun interaktioner fra offentligt publicerede, peer-reviewed original interaktionslitteratur (kliniske studier udført på mennesker samt kasuistikker) publiceret i PubMed og Embase. Desuden er interaktioner hvor data er beskrevet i produktresuméer også medtaget. Det tilstræbes at databasen opdateres snarest efter publicering, men der kan forekomme forsinkelser."),
        Pair("8. Hvilke lægemidler kan jeg finde information om?", "Interaktionsdatabasen beskriver interaktioner for markedsførte lægemidler, naturlægemidler samt stærke vitaminer og mineraler. I interaktionsbeskrivelserne skelnes som udgangspunkt ikke mellem forskellige dispenseringsformer. For udvalgte lægemidler skelnes dog mellem dermatologiske og systemiske formuleringer. Handelsnavnene for stærke vitaminer og mineraler, naturlægemidler samt lægemidler som ikke figurerer på medicinpriser.dk (dvs. SAD præparater) kan ikke findes på interaktionsdatabasen."),
        Pair("9. Hvilke lægemidler kan jeg ikke finde information om?", "Interaktionsdatabasen omhandler ikke kosttilskud, vacciner, parenteral ernæring, elektrolytvæsker, lægemidler uden systemisk effekt og priktest (ALK)."),
        Pair("10. Kan jeg slå andet end lægemidler op?", "Ja, du kan slå både lægemidler, naturlægemidler, stærke vitaminer, mineraler og enkelte frugtjuice op."),
        Pair("11. Hvad er naturlægemidler?", "Naturlægemidler er en særlig gruppe lægemidler, der typisk indeholder tørrede planter eller plantedele, udtræk af planter eller andre naturligt forekommende bestanddele. Naturlægemidler er i lovgivningen defineret som \"lægemidler, hvis indholdsstoffer udelukkende er naturligt forekommende stoffer i koncentrationer, der ikke er væsentligt større end dem, hvori de forekommer i naturen\". Naturlægemidler skal godkendes af Lægemiddelstyrelsen inden de må sælges."),
        Pair("12. Hvad er stærke vitaminer og mineraler?", "Stærke vitaminer og mineraler er en gruppe lægemidler, hvis indholdsstoffer udelukkende er vitaminer og/eller mineraler, og hvor indholdet af vitamin eller mineral er væsentligt højere end det normale døgnbehov hos voksne mennesker. Stærke vitaminer og mineraler kan kun godkendes til at forebygge og helbrede såkaldte mangeltilstande (og altså ikke til at behandle sygdomme). Stærke vitaminer og mineraler må kun sælges i Danmark, hvis de er godkendt af Lægemiddelstyrelsen.\n"),
        Pair("13. Kan jeg søge på mere end to slags lægemidler/indholdsstoffer?", "Ja, du kan søge på så mange lægemidler/indholdsstoffer, du ønsker samtidig. Det gør du ved at bruge søgeboksen til højre på forsiden med overskriften ”Søg på flere præparater i kombination”. Her kan du tilføje flere felter med knappen nederst. Hvis du søger på kombinationer med mere end to slags lægemidler/indholdsstoffer, skal du være opmærksom på, at du ikke kun får ét resultat, men et antal 1+1 kombinationer. Et eksempel: Hvis du søger på samtidig brug af en p-pille, et blodtrykssænkende lægemiddel og et sovemiddel, får du 3 mulige resultater:\n" + "\n"+
                "   A: kombinationen af p-pille og blodtrykssænkende lægemiddel\n" + "\n"+
                "   B: kombinationen af p-pille og sovemiddel\n" + "\n"+
                "   C: kombinationen af blodtrykssænkende lægemiddel og sovemiddel\n" + "\n"+
                "Du får de parvise kombinationer, der er videnskabeligt undersøgt."),
        Pair("14. Skal jeg skrive dosis eller interval efter præparat/indholdsstof når jeg søger?", "Nej, du skal ikke angive dosis (500mg paracetamol) eller interval (2xdaglig), når du skal søge på et præparat eller indholdsstof. Det er kun selve præparatnavnet eller navnet på indholdsstoffet, du skal skrive. Vælg eventuelt bare navnet fra listen."),
        Pair("15. Hvorfor kan jeg ikke søge på præparatnavn for naturlægemidler?", "Det er desværre sådan, at der indtil videre kun kan søges på indholdsstof, når det gælder naturlægemidler."),
        Pair("16. Hvordan kan det være, at jeg får et resultat med flere indholdsstoffer?", "Dette sker, når du søger på et kombinationspræparat. Når du søger på et kombinationspræparat, får du præsenteret et resultat for hvert af disse indholdsstoffer."),
        Pair("17. Hvorfor får jeg kun en interaktion, når jeg søger på flere præparater/indholdsstoffer?", "Indholdet i databasen er resultatet af grundige vurderinger af videnskabelige artikler og konklusioner fra humane forsøg. Hvis du kun får én interaktion på trods af, at du har indtastet flere præparater eller indholdsstoffer, skyldes det, at der endnu ikke er beskrevet (eller fundet) interaktioner af de andre indholdsstoffer i den videnskabelige litteratur."),
        Pair("18. Hvor kan jeg læse mere om interaktionsdatabasen?", "På Lægemiddelstyrelsens hjemmeside, og i månedsbladet Rationel Farmakoterapi, juni 2015.")
    )

    Column (modifier = Modifier
        .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally )
    {
        Text(
            text = "Information",
            style = MaterialTheme.typography.h4,
            modifier = Modifier.padding(16.dp),

            )

        LazyColumn {
            items(questionAnswerPairs) { pair ->
                QuestionCard(pair.first, pair.second)
            }
        }
    }
}


@Composable
fun QuestionCard(question: String, answer: String) {
    var expanded by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .clickable { expanded = !expanded },
        elevation = 4.dp
    ) {
        Column {
            Text(
                text = question,
                style = MaterialTheme.typography.h6,
                modifier = Modifier.padding(16.dp)
            )

            if (expanded) {
                Text(
                    text = answer,
                    modifier = Modifier.padding(16.dp),
                    style = MaterialTheme.typography.body1
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun InfoScreenPreview() {
    InfoScreen()

}