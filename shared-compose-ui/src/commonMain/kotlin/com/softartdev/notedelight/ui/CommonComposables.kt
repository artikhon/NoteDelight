package com.softartdev.notedelight.ui

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.softartdev.notedelight.MR
import dev.icerock.moko.resources.compose.stringResource

@Composable
fun Loader() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxWidth().padding(20.dp)
    ) {
        CircularProgressIndicator()
    }
}

@Composable
fun Empty() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = stringResource(MR.strings.label_empty_result),
            style = MaterialTheme.typography.h5,
        )
        Spacer(modifier = Modifier.weight(0.5f))
        Text(
            text = stringResource(MR.strings.press_add_note),
            style = MaterialTheme.typography.subtitle1,
        )
        Spacer(modifier = Modifier.weight(3f))
    }
}

@Composable
fun Error(err: String) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxWidth().padding(20.dp)
    ) {
        Text(text = err, style = TextStyle(color = MaterialTheme.colors.error, fontWeight = FontWeight.Bold))
    }
}

@Preview
@Composable
fun PreviewLoader() = Loader()

@Preview
@Composable
fun PreviewEmpty() = Empty()

@Preview
@Composable
fun PreviewError() = Error(err = "Mock error")

@Preview
@Composable
fun PreviewCommons() = Column(modifier = Modifier.fillMaxWidth()) {
    PreviewLoader()

    Divider()

    PreviewEmpty()

    Divider()

    PreviewError()
}