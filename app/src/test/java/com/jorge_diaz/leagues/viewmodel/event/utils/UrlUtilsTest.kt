package com.jorge_diaz.leagues.viewmodel.event.utils

import com.jorge_diaz.leagues.utils.UrlUtils
import org.junit.Test

class UrlUtilsTest {

    @Test
    fun formatUrl_isCorrect() {
        val url1 = "www.realmadrid.com"
        val correctUrl1 = "https://www.realmadrid.com"

        assert(correctUrl1 == UrlUtils.formatUrl(url1))

        val url2 = "http://www.arsenal.com"
        val correctUrl2 = "http://www.arsenal.com"

        assert(correctUrl2 == UrlUtils.formatUrl(url2))

        val url3 = "https://www.thesportsdb.com"
        val correctUrl3 = "https://www.thesportsdb.com"

        assert(correctUrl3 == UrlUtils.formatUrl(url3))
    }
}