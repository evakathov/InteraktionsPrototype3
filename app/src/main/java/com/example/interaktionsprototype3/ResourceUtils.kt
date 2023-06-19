package com.example.interaktionsprototype3

import android.content.Context
import androidx.annotation.RawRes

object ResourceUtils {
    fun getXmlResourceIdentifier(context: Context, resourceName: String): Int {
        return context.resources.getIdentifier(resourceName, "xml", context.packageName)
    }
}
