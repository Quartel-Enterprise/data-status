import com.vanniktech.maven.publish.SonatypeHost
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    kotlin("jvm") version "2.1.20"
    id("com.vanniktech.maven.publish") version "0.31.0"
}

group = "software.quare"
version = "0.2.0"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    testImplementation("com.google.truth:truth:1.4.4")
}

tasks.test {
    useJUnitPlatform()
}

tasks.compileKotlin {
    compilerOptions {
        jvmTarget.set(JvmTarget.JVM_21)
    }
}

tasks.compileTestKotlin {
    compilerOptions {
        jvmTarget.set(JvmTarget.JVM_21)
    }
}

kotlin {
    jvmToolchain(21)
}

java {
    withSourcesJar()
}

mavenPublishing {
    publishToMavenCentral(SonatypeHost.CENTRAL_PORTAL)

    signAllPublications()

    coordinates(group.toString(), "data-status", version.toString())

    pom {
        name = "Data Status"
        description = "A Kotlin library for handling data loading states in a type-safe way."
        inceptionYear = "2025"
        url = "https://github.com/Quartel-Enterprise/data-status"

        licenses {
            license {
                name = "The Apache License, Version 2.0"
                url = "https://www.apache.org/licenses/LICENSE-2.0.txt"
                distribution = "https://www.apache.org/licenses/LICENSE-2.0.txt"
            }
        }

        developers {
            developer {
                id.set("Quartel-Enterprise")
                name.set("Quartel Enterprise")
                email.set("quare.software@gmail.com")
            }
        }

        scm {
            connection.set("scm:git:github.com/Quartel-Enterprise/data-status.git")
            developerConnection.set("scm:git:ssh://github.com/Quartel-Enterprise/data-status.git")
            url.set("https://github.com/Quartel-Enterprise/data-status/tree/main")
        }
    }
}
