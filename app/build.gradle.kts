import com.oleg.sokolov.ext.propertyInt
import org.jetbrains.kotlin.konan.file.File
import org.jetbrains.kotlin.konan.properties.Properties
import org.jetbrains.kotlin.konan.properties.loadProperties
import org.jetbrains.kotlin.konan.properties.saveToFile

plugins {
  id("MoviesPlugin")
  id("com.android.application")
}

moviesPlugin {
  buildConfigGeneration = true
  compose = true
}

android {

  buildTypes {
    release { }
    debug { }
  }

  gradle.taskGraph.whenReady {
    if (hasTask(":app:assembleDebug")) {
      autoIncrementBuildVersionNumber()
    }
  }

}


dependencies {

  implementation(projects.sources.base.common)
  implementation(projects.sources.base.tea)
  implementation(projects.sources.base.teaAndroid)
  implementation(projects.sources.base.theme)
  implementation(projects.sources.base.core)
  implementation(projects.sources.base.network)

  implementation(projects.sources.api.settingsApi)
  implementation(projects.sources.api.genreApi)

  implementation(projects.sources.feature.splash)
  implementation(projects.sources.feature.settings)
  implementation(projects.sources.feature.search)
  implementation(projects.sources.feature.genre)
  implementation(projects.sources.feature.popular)

  implementation(libs.androidx.compose.ui)
  implementation(libs.androidx.compose.ui.preview)
  implementation(libs.androidx.compose.material)
  implementation(libs.androidx.compose.ui.util)
  implementation(libs.androidx.compose.navigation)
  implementation(libs.androidx.datastore)
  implementation(libs.androidx.datastore.preferences)
  implementation(libs.androidx.core)
  implementation(libs.androidx.appcompat)
  implementation(libs.androidx.lifecycle.runtime.ktx)
  implementation(libs.androidx.lifecycle.viewmodel.compose)
  implementation(libs.androidx.core)
  implementation(libs.androidx.activity.compose)
  implementation(libs.androidx.palette)

  implementation(libs.google.gson)
  implementation(libs.google.material)

  implementation(libs.koin.core)
  implementation(libs.koin.android)
  implementation(libs.koin.compose)
  implementation(libs.koin.navigation)

  implementation(libs.coil.compose)
  implementation(libs.threetenabp)

  implementation(libs.squareup.okhttp)
  implementation(libs.squareup.retrofit)
  implementation(libs.squareup.retrofit.gson)

  implementation(libs.jetbrains.serialization.json)
  implementation(libs.jetbrains.coroutines.android)
  implementation(libs.jetbrains.coroutines.core)

  implementation(libs.accompanist.pager)
  implementation(libs.accompanist.pager.indicators)
  implementation(libs.accompanist.system.ui.controller)
  implementation(libs.accompanist.placeholder)
  implementation(libs.accompanist.flow.layout)

  testImplementation(libs.koin.test)
  testImplementation(libs.test.junit)
  androidTestImplementation(libs.test.junit.androidx)
  androidTestImplementation(libs.test.junit.compose)
  androidTestImplementation(libs.test.espresso)

  androidTestImplementation(libs.androidx.compose.ui.test)

}

fun autoIncrementBuildVersionNumber() {
  val properties: Properties = loadProperties("$rootDir/app/version.properties")

  val newVersion = properties.propertyInt("BUILD_VERSION").inc()

  if (newVersion == 1000) {
    val subVersion = properties.propertyInt("SUB_VERSION").inc()

    properties["SUB_VERSION"] = subVersion.toString()
    properties["BUILD_VERSION"] = 0.toString()
  } else {
    properties["BUILD_VERSION"] = newVersion.toString()
  }

  properties.saveToFile(File("$rootDir/app/version.properties"))
}