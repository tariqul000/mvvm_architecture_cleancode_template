import com.android.build.gradle.BaseExtension
import org.gradle.api.JavaVersion
import org.gradle.api.plugins.ExtensionAware
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.dsl.KotlinAndroidProjectExtension
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmCompilerOptions
import org.gradle.api.Project

fun BaseExtension.setSdkVersions() {
    compileSdkVersion(Versions.Android.sdk)
    defaultConfig {
        targetSdk = Versions.Android.sdk
        minSdk = Versions.Android.minSdk
    }
}

fun BaseExtension.createBuildTypes() {
    buildTypes {
        create("internal")
        create("alpha")
        create("beta")
        create("preview")
    }
}


//
//fun Project.setJvmVersions(android: CommonExtension<*, *, *, *>) {
//    // ✅ Configure Java compile options
//    android.compileOptions {
//        sourceCompatibility = JavaVersion.VERSION_11
//        targetCompatibility = JavaVersion.VERSION_11
//    }
//
//    // ✅ Configure Kotlin compiler options (new DSL)
//    extensions.findByType(KotlinAndroidProjectExtension::class.java)?.apply {
//        compilerOptions.jvmTarget.set(JvmTarget.JVM_11)
//    }
//}
