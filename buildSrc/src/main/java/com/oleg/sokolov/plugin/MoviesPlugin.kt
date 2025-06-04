package com.oleg.sokolov.plugin

import com.android.build.gradle.AppPlugin
import com.android.build.gradle.LibraryPlugin
import com.oleg.sokolov.plugin.configure.configureAndroidApplication
import com.oleg.sokolov.plugin.configure.configureAndroidLibrary
import com.oleg.sokolov.plugin.configure.configureBuildFeatures
import com.oleg.sokolov.plugin.internal.applicationExtension
import com.oleg.sokolov.plugin.internal.libraryExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.plugins.JavaPlugin
import org.gradle.kotlin.dsl.create


open class MoviesPlugin : Plugin<Project> {

  override fun apply(project: Project) {
    with(project) {
      plugins.all {
        when (this) {
          is JavaPlugin -> println("This is JavaPlugin")
          is LibraryPlugin -> configureAndroidLibrary()
          is AppPlugin -> configureAndroidApplication()
        }
      }
    }

    val pluginExtension = project.extensions.create<MoviesPluginExtension>("moviesPlugin")

    project.afterEvaluate {
      plugins.all {
        when (this) {
          is LibraryPlugin -> libraryExtension
            .configureBuildFeatures(
              project = project,
              pluginExtension = pluginExtension
            )
          is AppPlugin -> applicationExtension
            .configureBuildFeatures(
              project = project,
              pluginExtension = pluginExtension
            )
        }
      }
    }

  }
}