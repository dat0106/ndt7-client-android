package com.kts.network.ndt7.android

data class Settings(var hostname: String = "",
                    var port: Int = 0,
                    var accessToken: String = "",
                    var skipTlsCertificateVerification: Boolean = false,
                    var adaptive: Boolean = false,
                    var duration: Int =0,
                    var subTest: String = "") //ToDo for single client

