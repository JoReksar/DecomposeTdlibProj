package com.joreksar.decomposetdlibproject

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform