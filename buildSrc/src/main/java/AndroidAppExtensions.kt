import com.android.build.gradle.AppExtension

fun AppExtension.configCommon() {

    setSdkVersions()
    createBuildTypes()
    setJvmVersions()

    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        proguardFiles(
            getDefaultProguardFile("proguard-android-optimize.txt"),
            "proguard-rules.pro"
        )
    }

}