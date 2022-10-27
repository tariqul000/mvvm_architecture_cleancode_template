plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {

    configCommon()

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    testOptions {
        unitTests.isIncludeAndroidResources = true
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }

    buildFeatures {
        viewBinding = true
    }
}

setupCommonDependencies()

dependencies {


    implementation(project(mapOf("path" to ":extensions")))
    implementation(project(mapOf("path" to ":style")))

    implementation(Google.Android.material)
    implementation(Google.android.playServices.auth)
    implementation(AndroidX.appCompat)
    implementation(AndroidX.core.ktx)
    implementation(AndroidX.activity.ktx)

    useNavigation()

    implementation(Square.okHttp3.okHttp)
    implementation(Square.okHttp3.loggingInterceptor)
    implementation(Square.retrofit2.retrofit)
    implementation(Square.retrofit2.adapter.rxJava2)
    implementation(Square.retrofit2.converter.gson)
    implementation(Square.okio)

    implementation(DepUtils.dexter)
    implementation(DepUtils.dialogs)
}