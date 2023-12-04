import internal.ProjectInfoExtension
import internal.ProjectInfoTask
import org.gradle.api.Plugin
import org.gradle.api.Project

open class ProjectInfoPlugin: Plugin<Project> {
    override fun apply(target: Project) {
        val extension = target.extensions.create("infoConf", ProjectInfoExtension::class.java)
        with(target.tasks) {
            create("info", ProjectInfoTask::class.java) {
                it.group = "project info"
            }
        }
    }
}