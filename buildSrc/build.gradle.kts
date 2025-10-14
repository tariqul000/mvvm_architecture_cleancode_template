plugins {
    `kotlin-dsl`
}

repositories {
    google()
    mavenCentral()
    gradlePluginPortal()
}

dependencies {
    implementation("de.fayard.refreshVersions:refreshVersions:0.60.6")
    // android gradle plugin, required by custom plugin
    implementation("com.android.tools.build:gradle:8.13.0")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:2.2.0")
    implementation("com.squareup:javapoet:1.13.0")
    implementation(gradleApi())
    implementation(localGroovy())
}