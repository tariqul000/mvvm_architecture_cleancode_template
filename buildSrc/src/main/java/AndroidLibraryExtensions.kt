import com.android.build.gradle.LibraryExtension

fun LibraryExtension.configCommon() {

    setSdkVersions()
    createBuildTypes()
    setJvmVersions()

    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        consumerProguardFile("consumer-rules.pro")
    }

}