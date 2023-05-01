buildscript {
    dependencies {
        classpath("crackers.buildstuff:crackers-gradle-plugins:1.0.1")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.8.20-RC")
    }
}

plugins {
    kotlin("jvm") version "1.8.20"
    idea
    id("org.jmailen.kotlinter") version "3.12.0"
    id("library-publish") version "1.0.1"
    id("org.jetbrains.dokka") version "1.8.10"
}

repositories {
    mavenCentral()
    mavenLocal()
}

val DIOZERO_VER = "1.4.0"
group = "crackers.kobots"
version = "0.0.1"


dependencies {
    api("ch.qos.logback:logback-classic:1.4.0")
    api("com.diozero:diozero-core:$DIOZERO_VER")

    testImplementation("io.kotest:kotest-runner-junit5:5.5.4")
    testImplementation("io.mockk:mockk:1.13.3")
}

kotlin {
    jvmToolchain(17)
}

kotlinter {
    // ignore failures because the build re-formats it
    ignoreFailures = true
    disabledRules = arrayOf("no-wildcard-imports")
}


tasks {
    build {
        dependsOn("formatKotlin")
    }
    test {
        useJUnitPlatform()
    }
    // make docs
    dokkaGfm {
        outputDirectory.set(file("$projectDir/docs"))

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
}

defaultTasks("clean", "build", "dokkaJavadocJar", "libraryDistribution")
