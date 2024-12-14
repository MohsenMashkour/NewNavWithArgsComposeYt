package com.mohsenmashkour.newnavwithargscomposeyt

import android.net.Uri
import android.os.Bundle
import androidx.navigation.NavType
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

object CustomNavType {

    val LanguageType = object : NavType<Languages>(isNullableAllowed = false) {
        override fun get(bundle: Bundle, key: String): Languages? {
            return Json.decodeFromString(bundle.getString(key) ?: return null)
        }

        override fun parseValue(value: String): Languages {
            return Json.decodeFromString(Uri.decode(value))
        }

        override fun serializeAsValue(value: Languages): String {
            return Uri.encode(Json.encodeToString(value))
        }

        override fun put(bundle: Bundle, key: String, value: Languages) {
            bundle.putString(key, Json.encodeToString(value))
        }

    }
}