package com.oleg.sokolov.plugin.configure

import com.oleg.sokolov.application.provideVersionCode
import com.oleg.sokolov.application.provideVersionName
import com.oleg.sokolov.plugin.internal.applicationExtension
import com.oleg.sokolov.plugin.internal.libs
import org.gradle.api.Project

internal fun Project.configureAndroidApplication() = applicationExtension.run {
    plugins.apply("kotlin-android")

    defaultConfig {
        applicationId = "com.oleg.sokolov.movies.arch"
        compileSdk = libs.versions.compileSdk.get().toInt()
        minSdk = libs.versions.minSdk.get().toInt()
        versionCode = provideVersionCode()
        versionName = provideVersionName()
    }

    buildTypes {
        release {
            isDebuggable = false
            multiDexEnabled = false
            isMinifyEnabled = true
            proguardFiles(
                "proguard-rules.pro",
                getDefaultProguardFile("proguard-android-optimize.txt")
            )
        }

        debug {
            applicationIdSuffix = ".debug"
            versionNameSuffix = "-debug"

            isMinifyEnabled = false
            multiDexEnabled = true
        }
    }
}
