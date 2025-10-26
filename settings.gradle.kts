rootProject.name = "jcef-spring-boot-starter-example"

pluginManagement {

    repositories {
        mavenLocal()
        maven {
            name = "jcef-gradle-plugin"
            url = uri("https://maven.pkg.github.com/bitfist/jcef-gradle-plugin")
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
        gradlePluginPortal()
        mavenCentral()
    }
    plugins {
        id("io.github.bitfist.jcef-gradle-plugin") version "0.5.26"
    }
}