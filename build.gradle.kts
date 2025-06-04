buildscript {

  repositories {
    mavenCentral()
    google()
    gradlePluginPortal()
  }

  dependencies {
    classpath(libs.gradle.plugin.buildtools)
    classpath(libs.gradle.plugin.kotlin)
  }
}

tasks {
  registering(Delete::class) {
    delete(buildDir)
  }
}
