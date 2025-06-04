package com.oleg.sokolov.plugin.configure

import com.android.build.api.dsl.CommonExtension
import com.oleg.sokolov.plugin.MoviesPluginExtension
import com.oleg.sokolov.plugin.internal.libs
import org.gradle.api.Project

fun CommonExtension<*, *, *, *>.configureBuildFeatures(
    project: Project,
    pluginExtension: MoviesPluginExtension
) {
    buildFeatures {
        buildConfig = pluginExtension.buildConfigGeneration

        if (pluginExtension.compose) {
            compose = pluginExtension.compose

            composeOptions {
                kotlinCompilerExtensionVersion = project.libs.versions.compose.get()
            }
        }
    }

    if (pluginExtension.kotlinParcelize) {
        project.plugins.apply("kotlin-parcelize")
    }
}