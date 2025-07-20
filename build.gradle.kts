plugins {
    java
    alias(libs.plugins.frontend)
    alias(libs.plugins.lombok)
    id("io.github.bitfist.jcef-gradle-plugin")
}

group = "io.github.bitfist"
version = "0.0.1-SNAPSHOT"

repositories {
	mavenLocal()
    mavenCentral()
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
//    enableWebCommunication()
}

java {
    sourceCompatibility = JavaVersion.VERSION_21
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(sourceCompatibility.majorVersion))
    }
}

frontend {
    nodeInstallDirectory.set(file("$rootDir/.node"))
    nodeVersion.set(libs.versions.node.get())
    packageJsonDirectory.set(file("$rootDir/src/main/webapp"))
    assembleScript.set("run build --silent")
}

tasks.register<Copy>("copyUi") {
    group = "frontend"
    from("$projectDir/src/main/webapp/dist")
    into(layout.buildDirectory.dir("resources/main/ui"))

    dependsOn(tasks.named("assemble"))
}

// endregion

tasks.test {
    useJUnitPlatform()
}