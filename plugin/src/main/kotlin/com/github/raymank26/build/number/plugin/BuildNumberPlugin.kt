package com.github.raymank26.build.number.plugin

import org.gradle.api.Plugin
import org.gradle.api.Project
import java.util.*

@Suppress("unused") // referenced in build.gradle.kts
class BuildNumberPlugin : Plugin<Project> {

    override fun apply(project: Project) {
        project.tasks.create("incrementBuildNumber") {
            it.doLast {
                updateBuildNumber(project) { lastVersion ->
                    lastVersion.copy(fix = (lastVersion.fix.toInt() + 1).toString())
                }
            }
        }

        project.tasks.create("refreshBuildNumber") {
            it.doLast {
                updateBuildNumber(project) { lastVersion -> lastVersion }
            }
        }

        project.tasks.create("createBuildNumber") {
            it.doLast {
                createBuildNumber(project, Version("0", "0", "1"))
            }
        }
    }

    private fun updateBuildNumber(project: Project, updateVersion: (Version) -> Version) {
        val buildNumberVersion = project.getBuildNumberVersion()
        val buildNumberParts = buildNumberVersion.split(".")
            .mapNotNull { it.toIntOrNull() }
        require(buildNumberParts.size == 3) {
            "Cannot parse build number by 3 parts, value = $buildNumberVersion"
        }
        val lastVersion = Version(
            major = buildNumberParts[0].toString(),
            minor = buildNumberParts[1].toString(),
            fix = buildNumberParts[2].toString()
        )
        createBuildNumber(project, updateVersion(lastVersion))
    }

    private fun createBuildNumber(project: Project, version: Version) {
        val prop = Properties()
        prop.setProperty("version", "${version.major}.${version.minor}.${version.fix}")
        project.file("build.number").writer().use { writer ->
            prop.store(writer, null)
        }
    }
}

private data class Version(val major: String, val minor: String, val fix: String)