package com.jda.flyaccesskmp.core.camera

import androidx.compose.runtime.Composable

@Composable
expect fun CameraView(onPhotoCaptured: (ByteArray) -> Unit)