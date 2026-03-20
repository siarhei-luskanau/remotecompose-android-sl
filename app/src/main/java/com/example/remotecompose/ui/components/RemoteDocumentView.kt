package com.example.remotecompose.ui.components

import android.annotation.SuppressLint
import androidx.compose.remote.player.compose.ExperimentalRemotePlayerApi
import androidx.compose.remote.player.compose.RemoteDocumentPlayer
import androidx.compose.remote.player.core.RemoteDocument
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier

@SuppressLint("RestrictedApi")
@OptIn(ExperimentalRemotePlayerApi::class)
@Composable
fun RemoteDocumentView(
    documentBytes: ByteArray,
    modifier: Modifier = Modifier,
    contentKey: Any = documentBytes.contentHashCode(),
    onAction: (id: Int, metadata: String?) -> Unit = { _, _ -> },
) {
    val document = remember(contentKey) { RemoteDocument(documentBytes) }
    RemoteDocumentPlayer(
        document = document.document,
        documentWidth = document.width,
        documentHeight = document.height,
        modifier = modifier,
        onAction = onAction,
    )
}
