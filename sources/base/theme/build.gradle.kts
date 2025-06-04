plugins {
    id("MoviesPlugin")
    id("com.android.library")
}

moviesPlugin {
    compose = true
}

dependencies {
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.material)
}