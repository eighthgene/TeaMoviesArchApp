plugins {
    id("MoviesPlugin")
    id("com.android.library")
}

moviesPlugin {
    compose = true
}

dependencies {
    implementation(projects.sources.base.common)
    implementation(projects.sources.base.core)
    implementation(projects.sources.base.theme)
    implementation(projects.sources.base.tea)
    implementation(projects.sources.base.network)
    implementation(projects.sources.base.teaAndroid)

    implementation(projects.sources.api.genreApi)

    implementation(libs.jetbrains.coroutines.android)
    implementation(libs.jetbrains.coroutines.core)

    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.util)
    implementation(libs.androidx.compose.ui.preview)
    implementation(libs.androidx.compose.material)
    implementation(libs.androidx.compose.navigation)

    implementation(libs.koin.core)
    implementation(libs.koin.android)
    implementation(libs.koin.compose)
    implementation(libs.koin.navigation)

    implementation(libs.coil.compose)

    implementation(libs.accompanist.placeholder)

    implementation(libs.squareup.okhttp)
    implementation(libs.squareup.retrofit)
    implementation(libs.squareup.retrofit.gson)

    implementation(libs.threetenabp)

}