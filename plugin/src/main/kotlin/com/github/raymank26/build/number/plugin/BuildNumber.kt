package com.github.raymank26.build.number.plugin

import org.gradle.api.Project
import java.util.*

private const val DEFAULT_VALUE = "unspecified"

fun Project.getBuildNumberVersion(): String {
    val prop = Properties()
    return try {
        file("build.number").reader().use { reader -> prop.load(reader) }
        prop.getProperty("version") ?: DEFAULT_VALUE
    } catch (e: Exception) {
        DEFAULT_VALUE
    }
}