package com.example.interaktionsprototype3.data

import org.w3c.dom.Element
import org.w3c.dom.Node
import java.io.File
import javax.xml.parsers.DocumentBuilderFactory


object XMLReader {
    @JvmStatic
    fun main(args: Array<String>) {
        try {
            val xmlFile = File("C:/Users/julia/OneDrive/DTU/4. semester/project kursus/AndroidStudioProjects/InteraktionsPrototype3/app/src/main/assets/interactions")
            val factory = DocumentBuilderFactory.newInstance()
            val builder = factory.newDocumentBuilder()
            val document = builder.parse(xmlFile)

            // Optional: Normalize the XML structure
            document.documentElement.normalize()

            // Get the root element of the XML
            val rootElement = document.documentElement

            // Example: Read data from specific elements
            val nodeList = rootElement.getElementsByTagName("Paracetamol")
            for (i in 0 until nodeList.length) {
                val node = nodeList.item(i)
                if (node.nodeType == Node.ELEMENT_NODE) {
                    val element = node as Element
                    val value = element.textContent
                    println("Value: $value")
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}
