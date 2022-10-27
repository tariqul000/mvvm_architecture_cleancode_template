// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
      mavenCentral()
        gradlePluginPortal()
        maven("https://oss.sonatype.org/content/repositories/snapshots/")
        maven("https://oss.sonatype.org/content/repositories/snapshots/")
        maven("https://jitpack.io")
    }

    dependencies {
        classpath("com.android.tools.build:gradle:7.3.1")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.7.10")
         classpath(Google.playServicesGradlePlugin) // Google Services plugin
        classpath(Google.firebase.crashlyticsGradlePlugin)
        classpath("com.google.dagger:hilt-android-gradle-plugin:2.43.2")
        classpath(AndroidX.navigation.safeArgsGradlePlugin)
        classpath("com.squareup:javapoet:1.13.0")
    }
}

plugins {
    // other plugins...
    id("com.google.dagger.hilt.android") version("2.43.2") apply false
  //  id("org.jetbrains.kotlin.android") version "1.7.20" apply false
    // id("org.jetbrains.kotlin.android") version "1.7.10" apply false
    // id("org.jetbrains.kotlin.android") version "1.7.10" apply false
}

allprojects {
    repositories {
       google()
       mavenCentral()
        maven("https://maven.localazy.com/repository/release/")
        maven("https://oss.sonatype.org/content/repositories/snapshots/")
        maven("https://jitpack.io")
    }
}

task("clean") {
    delete(rootProject.buildDir)
}
