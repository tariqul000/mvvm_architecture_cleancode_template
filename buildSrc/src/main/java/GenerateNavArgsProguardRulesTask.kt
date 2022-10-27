import org.gradle.api.DefaultTask
import org.gradle.api.file.FileTree
import org.gradle.api.tasks.*
import java.io.File
import javax.xml.parsers.DocumentBuilderFactory

@CacheableTask
abstract class GenerateNavArgsProguardRulesTask : DefaultTask() {

    companion object {
        private const val APP_NAMESPACE = "http://schemas.android.com/apk/res-auto"
    }

    @get:PathSensitive(PathSensitivity.RELATIVE)
    @get:InputFiles
    @get:SkipWhenEmpty
    val navigationGraphFiles: FileTree = project.fileTree("src/main/res/navigation") {
        include("*.xml")
    }

    private val isAppProject = project.plugins.hasPlugin("com.android.application")
    private val isLibraryProject = project.plugins.hasPlugin("com.android.library")

    @get:OutputFile
    val rulesFile: File by lazy {
        var ruleFileName: String? = null

        if (isAppProject) {
            ruleFileName = "proguard-rules.pro"
        }
        if (isLibraryProject) {
            ruleFileName = "consumer-rules.pro"
        }

        if (ruleFileName == null) {
            throw IllegalStateException("The generator must be used within android app or library module.")
        }

        File(project.projectDir, ruleFileName)
    }

    @Internal
    override fun getGroup() = "generate"

    @Internal
    override fun getDescription() = "Generates proguard rules for keeping names of classes used in navigation graph arguments"

    @TaskAction
    fun generateRules() {
        val prefix = "#region GenerateNavArgsProguardRulesTask"
        val suffix = "#endregion"
        val regex = "$prefix[\\s\\S]*?$suffix".toRegex()

        var rules = rulesFile.readText()
        if (!rules.contains(regex)) {
            rules +=
                "\n\n$prefix\n# Here is your rules.\n$suffix\n"
        }

        val documentBuilder = DocumentBuilderFactory.newInstance().apply { isNamespaceAware = true }.newDocumentBuilder()

        var generatedRules = ""

        navigationGraphFiles.forEach { inputFile ->
            val xmlDoc = documentBuilder.parse(inputFile)
            val arguments = xmlDoc.getElementsByTagName("argument")

            generatedRules += (0 until arguments.length)
                .asSequence()
                .mapNotNull { arguments.item(it).attributes.getNamedItemNS(APP_NAMESPACE, "argType")?.nodeValue }
                .filter { it.contains('.') }
                .toSet()
                .map { it.replace("[]", "") } // Array sign handle
                .map { it.replace("$", "\\$") } // Fix Regex Illegal group reference // https://stackoverflow.com/a/11913767/7033983
                .distinct()
                .map { "-keepnames class $it" }
                .joinToString("\n")
        }

        rulesFile.writeText(
            rules.replace(regex, "$prefix\n$generatedRules\n$suffix")
        )
    }
}