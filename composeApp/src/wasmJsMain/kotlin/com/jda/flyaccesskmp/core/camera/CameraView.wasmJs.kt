@file:Suppress("UNREACHABLE_CODE")

package com.jda.flyaccesskmp.core.camera

import androidx.compose.runtime.*
import kotlinx.browser.document
import org.w3c.dom.*
import kotlin.js.Promise
import kotlinx.browser.window


@Composable
actual fun CameraView(onPhotoCaptured: (ByteArray) -> Unit) {
    val videoRef = remember { mutableStateOf<HTMLVideoElement?>(null) }

    LaunchedEffect(Unit) {
        val stream = window.navigator.mediaDevices.getUserMedia(js("{ video: true }"))
        stream.then { mediaStream ->
            videoRef.value?.srcObject = mediaStream
        }.catch {
            console.log("Error al acceder a la cámara: ${it}")
        }
    }

    Video(attrs = {
        ref { videoElement ->
            videoRef.value = videoElement
            videoElement.autoplay = true
        }
    })

    Button(attrs = {
        onClick {
            videoRef.value?.let { videoElement ->
                val canvas = document.createElement("canvas") as HTMLCanvasElement
                canvas.width = videoElement.videoWidth
                canvas.height = videoElement.videoHeight
                val context = canvas.getContext("2d") as CanvasRenderingContext2D
                context.drawImage(videoElement, 0.0, 0.0)
                canvas.toBlob({ blob ->
                    val reader = FileReader()
                    reader.readAsArrayBuffer(blob!!)
                    reader.onloadend = {
                        val arrayBuffer = reader.result as ArrayBuffer
                        val byteArray = Int8Array(arrayBuffer).unsafeCast<ByteArray>()
                        onPhotoCaptured(byteArray)
                    }
                }, "image/jpeg")
            }
        }
    }) {
        Text("Capturar foto")
    }
}
