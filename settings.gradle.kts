rootProject.name = "jcef-spring-boot-starter-example"

pluginManagement {

    val gitHubRepositories = mapOf(
        "jcef-gradle-plugin" to "https://maven.pkg.github.com/bitfist/jcef-gradle-plugin",
        "gradle-github-support" to "https://maven.pkg.github.com/bitfist/gradle-github-support"
    )

    repositories {
        mavenLocal()
        gitHubRepositories.forEach { (repoName, repoUrl) ->
            maven {
                name = repoName
                url = uri(repoUrl)
                credentials {
                    try {
                        username = settings.extra["GPR_USER"] as String?
                    } catch (exception: ExtraPropertiesExtension.UnknownPropertyException) {
                        username =
                            System.getenv("GITHUB_ACTOR") ?: throw IllegalArgumentException("GITHUB_ACTOR not set")
                    }
                    try {
                        password = settings.extra["GPR_KEY"] as String?
                    } catch (exception: ExtraPropertiesExtension.UnknownPropertyException) {
                        password =
                            System.getenv("GITHUB_TOKEN") ?: throw IllegalArgumentException("GITHUB_TOKEN not set")
                    }
                }
            }
        }
        gradlePluginPortal()
        mavenCentral()
    }
    plugins {
        id("io.github.bitfist.jcef") version "0.1.3"
        id("io.github.bitfist.github.repository") version "0.1.5"
    }
}