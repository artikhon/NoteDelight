package com.softartdev.notedelight.shared.database

import app.cash.sqldelight.db.SqlDriver
import com.softartdev.notedelight.shared.db.NoteDb
import com.softartdev.notedelight.shared.db.NoteQueries


abstract class DatabaseHolder {
    abstract val driver: SqlDriver
    abstract val noteDb: NoteDb
    abstract val noteQueries: NoteQueries

    abstract fun close()
}
