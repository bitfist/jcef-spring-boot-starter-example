import io.github.bitfist.github.repository.gitHub

plugins {
    java
    alias(libs.plugins.frontend)
    alias(libs.plugins.lombok)
    id("io.github.bitfist.jcef-gradle-plugin")
    id("io.github.bitfist.gradle-github-support.repository")
}

group = "io.github.bitfist"
version = "0.0.1-SNAPSHOT"

repositories {
	mavenLocal()
    mavenCentral()
    gitHub("bitfist/jcef-spring-boot-starter")
}

dependencies {
    // region Database
    implementation("org.springframework.boot:spring-boot-starter-jdbc")
    implementation(libs.sqlite)
    // endregion

    // region Test
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    // endregion
}

// region Build

springJcef {
    typescriptOutputPath.set(projectDir.resolve("src/main/webapp/src"))
}

java {
    sourceCompatibility = JavaVersion.VERSION_21
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(sourceCompatibility.majorVersion))
    }
}

frontend {
    nodeInstallDirectory.set(file("$rootDir/.gradle/node"))
    nodeVersion.set(libs.versions.node.get())
    packageJsonDirectory.set(file("$rootDir/src/main/webapp"))
    assembleScript.set("run build --silent")
}

tasks.register<Copy>("copyUi") {
    dependsOn(tasks.named("assemble"))
    from("$projectDir/src/main/webapp/dist")
    into(layout.buildDirectory.dir("resources/main/ui"))
}

// endregion

tasks.test {
    useJUnitPlatform()
}