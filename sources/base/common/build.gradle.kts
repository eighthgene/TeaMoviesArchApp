plugins {
    id("MoviesPlugin")
    id("com.android.library")
}

moviesPlugin {
    compose = true
}

dependencies {
    implementation(projects.sources.base.tea)

    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.util)
    implementation(libs.androidx.compose.ui.preview)
    implementation(libs.androidx.compose.material)
    implementation(libs.androidx.compose.navigation)

    implementation(libs.androidx.lifecycle.viewmodel.compose)
    implementation(libs.androidx.lifecycle.runtime.ktx)

    implementation(libs.androidx.palette)

    implementation(libs.threetenabp)

    implementation(libs.google.gson)

    implementation(libs.accompanist.pager)
    implementation(libs.accompanist.pager.indicators)


}