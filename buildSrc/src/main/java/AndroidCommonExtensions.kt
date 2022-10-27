import com.android.build.gradle.BaseExtension
import org.gradle.api.JavaVersion
import org.gradle.api.plugins.ExtensionAware
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmOptions

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

fun BaseExtension.setJvmVersions() {
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    val kotlinJvmOptions = (this as ExtensionAware).extensions.getByName("kotlinOptions") as KotlinJvmOptions
    kotlinJvmOptions.jvmTarget = "11"
}
