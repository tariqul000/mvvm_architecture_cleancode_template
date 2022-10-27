plugins {

    id("com.android.application")
    id("kotlin-android")
    id("kotlin-parcelize")
    id("kotlin-kapt")
    id("androidx.navigation.safeargs.kotlin")
    id("com.google.dagger.hilt.android")
    id("com.google.gms.google-services")
    id("com.google.firebase.crashlytics")

}

android {

    signingConfigs {
        create("release") {
            storeFile = file("/Users/tariqul/Library/OfficeProject/BTBTariqul/keystore/key")
            storePassword = "alet"
            keyAlias = "alet"
            keyPassword = "alet"
        }
    }
    configCommon()

    defaultConfig {
        applicationId = "com.simec.alet"
        versionCode = 10
        versionName = "1.0.10"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        ndk {
            abiFilters.addAll(arrayOf("armeabi-v7a", "arm64-v8a", "x86", "x86_64"))
        }
        resourceConfigurations.addAll(arrayOf("en", "bn"))
        signingConfig = signingConfigs.getByName("release")

    }


    buildTypes {
        release {

            val baseUrl = findProperty("PROD_BASE_URL") as String
            buildConfigField("String", "BASE_URL", baseUrl)

            isMinifyEnabled = false
            ndk {
                debugSymbolLevel = "FULL"
            }
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            applicationVariants.all {
                outputs.all {
                    if (name.contains("release"))
                        (this as com.android.build.gradle.internal.api.BaseVariantOutputImpl).outputFileName =
                            "${rootProject.name}_${defaultConfig.versionName}.apk"
                }
            }

        }
        debug {

//            val baseUrl = findProperty("DEV_BASE_URL") as String
            val baseUrl = findProperty("PROD_BASE_URL") as String
            buildConfigField("String", "BASE_URL", baseUrl)

            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            applicationVariants.all {
                outputs.all {
                    if (name.contains("debug"))
                        (this as com.android.build.gradle.internal.api.BaseVariantOutputImpl).outputFileName =
                            "${rootProject.name}_${defaultConfig.versionName}.apk"
                }
            }
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        viewBinding = true
    }
    bundle {
        language {
            enableSplit = false
        }
    }

}

kapt {
    correctErrorTypes = true
}

setupCommonDependencies()

dependencies {
    implementation("androidx.appcompat:appcompat:1.5.1")
    implementation("com.google.android.material:material:1.7.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    useNavigation()
    useRoom()
    useHilt()
    useFirebase()

    implementation("androidx.multidex:multidex:2.0.1")

    implementation(project(mapOf("path" to ":extensions")))
    implementation(project(mapOf("path" to ":style")))
    implementation(project(mapOf("path" to ":utilities")))

    implementation(Google.Android.material)

    implementation(AndroidX.appCompat)
    implementation(AndroidX.core.ktx)
    implementation(AndroidX.constraintLayout)


    implementation(AndroidX.lifecycle.runtimeKtx)
    implementation(AndroidX.lifecycle.liveDataKtx)
    implementation(AndroidX.lifecycle.viewModelKtx)
    implementation(AndroidX.lifecycle.commonJava8)
    implementation(AndroidX.work.runtime)

    implementation(AndroidX.fragment.ktx)
    implementation(AndroidX.activity.ktx)
    implementation(AndroidX.viewPager2)



    implementation(Square.okHttp3.okHttp)
    implementation(Square.okHttp3.loggingInterceptor)
    implementation(Square.retrofit2.retrofit)
    implementation(Square.retrofit2.adapter.rxJava2)
    implementation(Square.retrofit2.converter.gson)
    implementation(Square.retrofit2.converter.scalars)
    implementation(Square.okio)


    implementation(DepUtils.coil)
    implementation(DepUtils.coilBase)
    implementation(DepUtils.shimmer)
    implementation(DepUtils.dialogs)
    implementation(DepUtils.dexter)
    implementation(DepUtils.baseAdapter)

    implementation(Google.android.playServices.auth)
    implementation(DepUtils.otpView)
    implementation(DepUtils.pinEntryEditText)

    implementation(DepUtils.sdpAndroid)
    implementation(DepUtils.spinner)
    implementation(DepUtils.chromecastPlayer)
    implementation(DepUtils.countryCodePicker)
    implementation (DepUtils.searchableSpinner)


}