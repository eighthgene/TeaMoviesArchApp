enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

dependencyResolutionManagement {
  repositories {
    google()
    gradlePluginPortal()
    maven(url = "https://jitpack.io")
  }
}

rootProject.name = "MoviesArchApp"

include("app")

//base
include(":sources:base:tea")
include(":sources:base:tea-android")
include(":sources:base:common")
include(":sources:base:theme")
include(":sources:base:core")
include(":sources:base:network")

//feature api
include(":sources:api:settings-api")
include(":sources:api:genre-api")

//feature
include(":sources:feature:splash")
include(":sources:feature:settings")
include(":sources:feature:detail")
include(":sources:feature:search")
include(":sources:feature:genre")
include(":sources:feature:popular")
