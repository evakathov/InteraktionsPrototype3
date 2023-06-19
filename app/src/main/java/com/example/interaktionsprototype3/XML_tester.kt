package com.example.interaktionsprototype3

import javax.xml.parsers.DocumentBuilderFactory
import java.io.File

fun printXMLTitle(filePath: String) {
    try {
        // Create a document builder factory
        val factory = DocumentBuilderFactory.newInstance()

        // Create a document builder
        val builder = factory.newDocumentBuilder()

        // Parse the XML file
        val file = File(filePath)
        val document = builder.parse(file)

        // Get the title element
        val titleElement = document.getElementsByTagName("title").item(0)

        // Get the title text
        val title = titleElement.textContent

        // Print the title
        println("Title: $title")
    } catch (e: Exception) {
        println("Error reading XML file: ${e.message}")
    }
}

