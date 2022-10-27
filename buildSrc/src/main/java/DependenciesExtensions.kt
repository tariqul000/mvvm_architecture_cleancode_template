import org.gradle.kotlin.dsl.DependencyHandlerScope


fun DependencyHandlerScope.implementation(dependencyNotation: Any) {
    add("implementation", dependencyNotation)
}

fun DependencyHandlerScope.kapt(dependencyNotation: Any) {
    add("kapt", dependencyNotation)
}

fun DependencyHandlerScope.useNavigation() {
    implementation(AndroidX.navigation.commonKtx)
    implementation(AndroidX.navigation.fragmentKtx)
    implementation(AndroidX.navigation.uiKtx)
    implementation(AndroidX.navigation.runtimeKtx)
}

fun DependencyHandlerScope.useHilt() {
    implementation("com.google.dagger:hilt-android:2.43.2")
    kapt("com.google.dagger:hilt-compiler:2.43.2")
//    implementation("androidx.hilt:hilt-work:1.0.0")
//    implementation(AndroidX.hilt.work)
//    kapt("androidx.hilt:hilt-compiler:1.0.0")
}

fun DependencyHandlerScope.useFirebase(){
    implementation(platform(Google.firebase.bom))
    implementation(Google.firebase.authenticationKtx)
    implementation(Google.firebase.crashlyticsKtx)
//    implementation(Google.firebase.analyticsKtx)
}

fun DependencyHandlerScope.useRoom() {
    implementation(AndroidX.room.runtime)
    kapt(AndroidX.room.compiler)
    implementation(AndroidX.room.ktx)
}

fun DependencyHandlerScope.useExoplayer() {
    implementation(Exoplayer.player)
    implementation(Exoplayer.core)
    implementation(Exoplayer.dash)
    implementation(Exoplayer.smoothStreaming)
    implementation(Exoplayer.hls)
    implementation(Exoplayer.ui)
    implementation(Exoplayer.rtsp)
}
