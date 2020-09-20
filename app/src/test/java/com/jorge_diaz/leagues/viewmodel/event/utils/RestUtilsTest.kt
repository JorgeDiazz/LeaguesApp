package com.jorge_diaz.leagues.viewmodel.event.utils

import com.jorge_diaz.leagues.BuildConfig
import com.jorge_diaz.leagues.utils.RestUtils
import org.junit.Assert
import org.junit.Test

class RestUtilsTest {
    @Test
    fun API_KEY_constant_isCorrectAccordingToEnvironment() {
        if (BuildConfig.DEVELOPMENT_ENV) {
            Assert.assertEquals("1", RestUtils.API_KEY)
        } else {
            Assert.assertEquals("1234567890", RestUtils.API_KEY)
        }
    }
}