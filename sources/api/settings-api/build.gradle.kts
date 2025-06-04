plugins {
    id("MoviesPlugin")
    id("com.android.library")
}

dependencies {

    implementation(projects.sources.base.core)

    implementation(libs.koin.core)

}