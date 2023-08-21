package com.softartdev.notedelight.shared.date

import app.cash.sqldelight.ColumnAdapter
import kotlinx.datetime.Instant
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toInstant
import kotlinx.datetime.toLocalDateTime

class DateAdapter : ColumnAdapter<LocalDateTime, Long> {

    override fun encode(value: LocalDateTime): Long = value
        .toInstant(TimeZone.currentSystemDefault())
        .toEpochMilliseconds()

    override fun decode(databaseValue: Long): LocalDateTime = Instant
        .fromEpochMilliseconds(epochMilliseconds = databaseValue)
        .toLocalDateTime(TimeZone.currentSystemDefault())
}