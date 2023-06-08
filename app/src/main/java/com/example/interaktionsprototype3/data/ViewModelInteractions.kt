package com.example.interaktionsprototype3.data

import androidx.lifecycle.ViewModel
import java.io.InputStream

class ViewModelInteractions (private val interactionsRepository: InteractionsRepository) : ViewModel() {
    fun getInteractionsXmlData(): InputStream {
        return interactionsRepository.getInteractionsXmlInputStream()
    }
}
