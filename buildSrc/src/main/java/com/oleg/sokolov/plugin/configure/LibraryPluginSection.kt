package com.oleg.sokolov.plugin.configure

import com.oleg.sokolov.plugin.internal.libraryExtension
import com.oleg.sokolov.plugin.internal.libs
import org.gradle.api.Project

internal fun Project.configureAndroidLibrary() = libraryExtension.run {
    plugins.apply("kotlin-android")

    defaultConfig {
        minSdk = libs.versions.minSdk.get().toInt()
        compileSdk = libs.versions.compileSdk.get().toInt()
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = true
        }

        debug {
            isMinifyEnabled = false
        }
    }
}