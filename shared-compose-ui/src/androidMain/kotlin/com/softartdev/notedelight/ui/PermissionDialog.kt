@file:OptIn(ExperimentalPermissionsApi::class)

package com.softartdev.notedelight.ui

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.MultiplePermissionsState
import com.google.accompanist.permissions.rememberMultiplePermissionsState
import com.softartdev.themepref.AlertDialog
import io.github.aakira.napier.Napier

@Composable
actual fun PermissionDialog(dismissCallback: () -> Unit) {
    val permissionState: MultiplePermissionsState = rememberMultiplePermissionsState(
        permissions = listOf(
            android.Manifest.permission.READ_EXTERNAL_STORAGE,
            android.Manifest.permission.WRITE_EXTERNAL_STORAGE,
            android.Manifest.permission.READ_MEDIA_IMAGES,
            android.Manifest.permission.READ_MEDIA_VIDEO,
            android.Manifest.permission.READ_MEDIA_AUDIO
        ), onPermissionsResult = { map: Map<String, Boolean> ->
            Napier.d("🦄 onPermissionsResult: $map")
        })
    val descriptionText = when {
        permissionState.allPermissionsGranted -> "All permissions granted"
        permissionState.shouldShowRationale -> "Storage is important for this app. Please grant the permission."
        else -> "Permission required for this feature to be available. Please grant the permission"
    }
    AlertDialog(
        onDismissRequest = dismissCallback,
        title = { Text("Permissions") },
        text = { Text(descriptionText) },
        confirmButton = {
            if (!permissionState.allPermissionsGranted) {
                Button(
                    onClick = permissionState::launchMultiplePermissionRequest
                ) {
                    Text("Request permission")
                }
            }
        },
        dismissButton = {
            Button(
                onClick = dismissCallback,
            ) {
                Text("Cancel")
            }
        }
    )
}