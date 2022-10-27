plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {

    configCommon()

    defaultConfig {
        val domain = findProperty("DOMAIN") as String
        buildConfigField("String", "DOMAIN", domain)
    }

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

    implementation(project(mapOf("path" to ":style")))
//
    implementation(Google.Android.material)
    implementation(AndroidX.appCompat)
    implementation(AndroidX.core.ktx)
    implementation(AndroidX.activity.ktx)

    implementation(Square.retrofit2.converter.gson)

    useNavigation()

    implementation(DepUtils.dexter)
    implementation(DepUtils.dialogs)

    implementation(DepUtils.coil)
    implementation(DepUtils.coilBase)
    implementation(DepUtils.shimmer)
}