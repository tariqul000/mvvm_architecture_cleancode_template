import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import java.util.Properties

plugins {

    id("com.android.application")
    id("kotlin-android")
    id("kotlin-parcelize")
    id("kotlin-kapt")
    id("androidx.navigation.safeargs.kotlin")
    id("com.google.dagger.hilt.android")
    id("com.google.gms.google-services")
    id("com.google.firebase.crashlytics")
    // id("com.github.triplet.play")
}

android {

    signingConfigs {
        create("release") {
          //  storeFile = file("/Users/tariqul/Library/OfficeProject/LIMS/app/keystore/lims123")
          //  storePassword = "lims123"
          //  keyAlias = "lims123"
          //  keyPassword = "lims123"
        }
    }
    configCommon()

    defaultConfig {
        applicationId = "com.irinfosys.glafitES"
        versionCode = 1
        versionName = "1.0.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        ndk {
            abiFilters.addAll(arrayOf("armeabi-v7a", "arm64-v8a", "x86", "x86_64"))
        }
        resourceConfigurations.addAll(arrayOf("en", "bn"))
        signingConfig = signingConfigs.getByName("release")


        val properties = Properties()
        properties.load(project.rootProject.file("local.properties").inputStream())
        buildConfigField("String", "BASIC_AUTH_USERNAME", "\"${properties.getProperty("BASIC_AUTH_USERNAME")}\"")
        buildConfigField("String", "BASIC_AUTH_PASSWORD", "\"${properties.getProperty("BASIC_AUTH_PASSWORD")}\"")

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

//           val baseUrl = findProperty("DEV_BASE_URL") as String
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

    dataBinding{
        enable = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17

    }

    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_17)
        }
    }
    java {
        toolchain {
            languageVersion.set(JavaLanguageVersion.of(17))
        }
    }

    buildFeatures {
        viewBinding = true
        buildConfig = true
    }
    namespace = "com.irinfosys.glafitES"
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

//play {
//    serviceAccountCredentials.set(file("pc-api-8713492255264378267-463-23e89a4b98ff.json"))
//}

dependencies {
    implementation("androidx.appcompat:appcompat:1.7.1")
    implementation("com.google.android.material:material:1.13.0")
    implementation("androidx.constraintlayout:constraintlayout:2.2.1")

    useNavigation()
    useRoom()
    useHilt()
    useFirebase()
    // For Card view
    implementation ("androidx.cardview:cardview:1.0.0")

    // Paging
    implementation ("androidx.paging:paging-runtime-ktx:3.3.6")

// Chart and graph library
    implementation ("com.github.blackfizz:eazegraph:1.2.5l@aar")
    implementation ("com.nineoldandroids:library:2.4.0")
    implementation ("com.github.PhilJay:MPAndroidChart:v3.1.0")
    implementation("androidx.multidex:multidex:2.0.1")
    implementation("com.github.acefalobi:android-stepper:0.3.0")
    implementation ("com.github.AnyChart:AnyChart-Android:1.1.5")
    implementation(project(mapOf("path" to ":extensions")))
    implementation(project(mapOf("path" to ":style")))
    implementation(project(mapOf("path" to ":utilities")))
    implementation("androidx.core:core-ktx:1.17.0")
    implementation ("com.github.bumptech.glide:glide:5.0.5")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.9.0")

    //Room Library
    implementation ("androidx.room:room-runtime:2.8.2")
    implementation ("androidx.room:room-ktx:2.8.2")
    kapt ("androidx.room:room-compiler:2.8.2")

    // Coroutines for asynchronous programming
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.10.2")
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.10.2")
    //implementation ("com.github.mhiew:android-pdf-viewer:3.2.0-beta.1")


    //pieChart
    implementation ("com.github.PhilJay:MPAndroidChart:v3.1.0")


    implementation(Google.Android.material)

    implementation(AndroidX.appCompat)
    implementation(AndroidX.core.ktx)
    implementation(AndroidX.constraintLayout)


    implementation(AndroidX.lifecycle.runtime.ktx)
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
    //implementation(DepUtils.otpView)
    implementation(DepUtils.pinEntryEditText)

    implementation(DepUtils.sdpAndroid)
    implementation(DepUtils.spinner)
    implementation(DepUtils.chromecastPlayer)
    implementation(DepUtils.countryCodePicker)
    implementation(DepUtils.searchableSpinner)
}