plugins {
    id("MoviesPlugin")
    id("com.android.library")
}

dependencies {
    implementation(libs.jetbrains.coroutines.android)
    implementation(libs.jetbrains.coroutines.core)
}