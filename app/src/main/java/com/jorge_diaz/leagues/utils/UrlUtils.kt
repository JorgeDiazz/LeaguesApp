package com.jorge_diaz.leagues.utils

class UrlUtils {

    companion object {
        fun formatUrl(url: String): String {
            return if (!(url.startsWith("http://") || url.startsWith("https://"))) {
                "https://$url"
            } else url
        }
    }
}