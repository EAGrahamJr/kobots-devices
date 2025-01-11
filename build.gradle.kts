plugins {
    kotlin("jvm") version "2.0.20"
    idea
//    id("org.jmailen.kotlinter") version "3.12.0"
    id("org.jetbrains.dokka") version "1.8.10"
    // ***NOTE*** semver is applied on push, so it's the _next_ version
    id("net.thauvin.erik.gradle.semver") version "1.0.4"
    id("crackers.buildstuff.library-publish") version "1.2.0"
}

repositories {
    mavenCentral()
    mavenLocal()
}

val DIOZERO_VER = "1.4.1"
group = "crackers.kobots"

dependencies {
    api("org.slf4j:slf4j-api:2.0.5")
    api("com.diozero:diozero-core:$DIOZERO_VER")

    // for adhoc testing
    testImplementation("com.diozero:diozero-provider-remote:$DIOZERO_VER")
    testImplementation("com.diozero:diozero-provider-mock:$DIOZERO_VER")

    testImplementation("io.kotest:kotest-runner-junit5:5.5.5")
    testImplementation("io.mockk:mockk:1.13.4")
    testImplementation("ch.qos.logback:logback-classic:1.5.13")
}

kotlin {
    jvmToolchain(17)
}

//kotlinter {
//    // ignore failures because the build re-formats it
//    ignoreFailures = true
//    disabledRules = arrayOf("no-wildcard-imports")
//}

tasks {
    build {
//        dependsOn("formatKotlin")
    }
    test {
        useJUnitPlatform()
    }
    javadoc {
        mustRunAfter("test")
    }
    // make docs
    dokkaJavadoc {
        mustRunAfter("javadoc")
        outputDirectory.set(file("$projectDir/build/docs"))
    }
    javadocJar {
        mustRunAfter("dokkaJavadoc")
        include("$projectDir/build/docs")
    }
    // jar docs
    register<Jar>("dokkaJavadocJar") {
        dependsOn(dokkaJavadoc)
        from(dokkaJavadoc.flatMap { it.outputDirectory })
        archiveClassifier.set("javadoc")
    }
    generateMetadataFileForLibraryPublication {
        mustRunAfter("dokkaJavadocJar")
    }
    create("depSize") {
        doLast {
            val depSize = configurations["compileClasspath"].files.sumOf { it.length() }
            logger.warn(">>> Dependencies size: ${depSize / 1024} KB")
        }
    }
}

defaultTasks("clean", "build", "dokkaJavadocJar", "libraryDistribution")
