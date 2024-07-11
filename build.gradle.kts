// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
        maven("https://oss.sonatype.org/content/repositories/snapshots/")
        maven("https://oss.sonatype.org/content/repositories/snapshots/")
        maven("https://jitpack.io")
        maven("https://jcenter.bintray.com")
    }

    dependencies {
        classpath("com.android.tools.build:gradle:8.2.2")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.9.22")
        classpath(Google.playServicesGradlePlugin) // Google Services plugin
        classpath(Google.firebase.crashlyticsGradlePlugin)
        classpath("com.google.dagger:hilt-android-gradle-plugin:2.43.2")
        classpath(AndroidX.navigation.safeArgsGradlePlugin)
        classpath("com.squareup:javapoet:1.13.0")
        classpath("com.google.gms:google-services:4.4.0")
        classpath("com.google.firebase:firebase-appdistribution-gradle:4.0.1")
        //classpath("com.github.triplet.gradle:play-publisher:4.0.0-SNAPSHOT")

    }
}

plugins {
    // other plugins...
    id("com.google.dagger.hilt.android") version("2.43.2") apply false
}

allprojects {
    repositories {
        google()
        mavenCentral()
        maven("https://maven.localazy.com/repository/release/")
        maven("https://oss.sonatype.org/content/repositories/snapshots/")
        maven("https://jitpack.io")
        maven("https://jcenter.bintray.com")

    }
}

task("clean") {
    delete(rootProject.buildDir)
}
