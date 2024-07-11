import org.gradle.api.Project
import org.gradle.kotlin.dsl.*
import com.android.build.gradle.BaseExtension
import org.gradle.api.plugins.ExtensionAware
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmOptions
import com.android.build.gradle.internal.tasks.factory.dependsOn

fun Project.setupCommonDependencies() {
    dependencies {
        val implementation by configurations
        val testImplementation by configurations
        val androidTestImplementation by configurations

       // testImplementation(AndroidX.test.ext.junitKtx)
      //  androidTestImplementation(AndroidX.test.ext.junitKtx)
        androidTestImplementation(AndroidX.test.runner)
        androidTestImplementation(AndroidX.test.espresso.core)
        androidTestImplementation(AndroidX.test.rules)

        implementation(
            fileTree(
                "dir" to "libs",
                "include" to listOf("*.jar")
            )
        )

//        implementation(Kotlin.stdlib.jdk8)
    }
}

/**
 * Fix Kotlin Module (eg: META-INF/library_debug.kotlin_module) Naming Duplication Problem.
 */
fun Project.fixKotlinModuleFileNameConflict() {
    val android = extensions.getByName("android")
    if (android is BaseExtension) {
        val kotlinJvmOptions = (android as ExtensionAware).extensions.getByName("kotlinOptions") as KotlinJvmOptions
        kotlinJvmOptions.freeCompilerArgs +=
            listOf("-module-name", path.replaceFirst(":", "")
                .replace(":", "-"))
    }
}

fun Project.generateNavArgsProguardRules() {
    tasks {
        named("preBuild")
            .dependsOn(
                register(
                    "generateNavArgsProguardRules",
                    GenerateNavArgsProguardRulesTask::class
                )
            )
    }
}