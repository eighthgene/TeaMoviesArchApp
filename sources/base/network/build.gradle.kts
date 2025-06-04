plugins {
    id("MoviesPlugin")
    id("com.android.library")
}

dependencies {
    
    implementation(libs.koin.core)

    implementation(libs.squareup.okhttp)
    implementation(libs.squareup.retrofit)
    implementation(libs.squareup.retrofit.gson)
}