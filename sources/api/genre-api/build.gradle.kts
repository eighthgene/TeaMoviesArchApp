plugins {
    id("MoviesPlugin")
    id("com.android.library")
}

moviesPlugin {
    compose = true
}

dependencies {

    implementation(projects.sources.base.core)
    implementation(projects.sources.base.theme)

    implementation(libs.koin.core)

    implementation(libs.accompanist.flow.layout)

    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.preview)
    implementation(libs.androidx.compose.material)
}