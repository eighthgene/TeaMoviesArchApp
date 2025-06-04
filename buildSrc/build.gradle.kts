plugins {
  `kotlin-dsl`
}

repositories {
  mavenCentral()
  google()
  gradlePluginPortal()
}

gradlePlugin {
  plugins {
    register("MoviesPlugin") {
      id = "MoviesPlugin"
      implementationClass = "com.oleg.sokolov.plugin.MoviesPlugin"
    }
  }
}

dependencies {
  implementation(gradleApi())
  implementation(localGroovy())

  implementation(libs.gradle.plugin.buildtools)
  implementation(libs.gradle.plugin.kotlin)
  implementation(files(libs.javaClass.superclass.protectionDomain.codeSource.location))
}