import org.gradle.api.artifacts.Dependency
import org.gradle.api.artifacts.dsl.DependencyHandler

object Versions {

    const val coreKtx = "1.13.1"
    const val appCompat = "1.7.0"
    const val androidMaterial = "1.12.0"
    const val constraintLayout = "2.1.4"

    const val dagger = "2.51.1"

    const val coroutines = "1.5.2"

    const val glide = "4.13.0"

    const val dataStore = "1.1.1"
    const val roomVersion = "2.6.1"

    const val lifecycleViewModel = "2.2.0"

}

object AndroidSdk {

    const val min = 24
    const val compile = 34
    const val target = compile
}

object Libraries {

    const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    const val androidMaterial = "com.google.android.material:material:${Versions.androidMaterial}"

    const val dagger = "com.google.dagger:dagger:${Versions.dagger}"
    const val kaptDaggerCompiler = "com.google.dagger:dagger-compiler:${Versions.dagger}"

    const val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
    const val coroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"

    const val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
    const val glideCompiler = "com.github.bumptech.glide:compiler:${Versions.glide}"
    const val dataStore = "androidx.datastore:datastore-preferences:${Versions.dataStore}"

    const val lifecycleViewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycleViewModel}"

    const val roomRuntime = "androidx.room:room-runtime:${Versions.roomVersion}"
    const val roomKtx = "androidx.room:room-ktx:$${Versions.roomVersion}"
    const val roomKaptCompiler = "androidx.room:room-compiler:${Versions.roomVersion}"
}

fun DependencyHandler.addCommonUiDependencies() {
    implementation(Libraries.coreKtx)
    implementation(Libraries.appCompat)
    implementation(Libraries.androidMaterial)
}

/**
 * Do not forget add kotlin("kapt") plugin into build.gradle.kts module
 */
fun DependencyHandler.addDaggerDependencies() {
    implementation(Libraries.dagger)
    kapt(Libraries.kaptDaggerCompiler)
}

fun DependencyHandler.addCoroutinesDependencies() {
    implementation(Libraries.coroutinesCore)
    implementation(Libraries.coroutinesAndroid)
}

/**
 * Do not forget add kotlin("kapt") plugin into build.gradle.kts module
 */
fun DependencyHandler.addGlideDependencies() {
    implementation(Libraries.glide)
    kapt(Libraries.glideCompiler)
}

fun DependencyHandler.addFeatureDependencies() {
    implementation(Libraries.lifecycleViewModel)
    addCommonUiDependencies()
    addDaggerDependencies()
    addCoroutinesDependencies()
    addGlideDependencies()
}

fun DependencyHandler.addRoomDependencies() {
    implementation(Libraries.roomRuntime)
    implementation(Libraries.roomKtx)
    kapt(Libraries.roomKaptCompiler)
}

private fun DependencyHandler.implementation(dependencyNotation: Any): Dependency? =
    add("implementation", dependencyNotation)

private fun DependencyHandler.kapt(dependencyNotation: Any): Dependency? =
    add("kapt", dependencyNotation)