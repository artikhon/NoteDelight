package com.softartdev.notedelight.shared

import com.softartdev.notedelight.shared.database.DatabaseRepo
import kotlin.test.AfterTest
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertNotEquals

class JvmCipherUtilsTest {

    @BeforeTest
    fun setUp() {
    }

    @AfterTest
    fun tearDown() {
    }

    @Test
    fun getDatabaseState() {
        val exp = PlatformSQLiteState.ENCRYPTED
        val act = JvmCipherUtils.getDatabaseState(DatabaseRepo.DB_NAME)
        assertNotEquals(exp, act)
    }
}