plugins {
    id("MoviesPlugin")
    id("com.android.library")
}

moviesPlugin {
    compose = true
}

dependencies {
    implementation(projects.sources.base.tea)

    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.lifecycle.viewmodel.compose)

    implementation(libs.androidx.compose.ui)
    
    implementation(libs.jetbrains.coroutines.android)
    implementation(libs.jetbrains.coroutines.core)

}