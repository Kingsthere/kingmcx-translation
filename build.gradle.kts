import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("java")
    `maven-publish`
    kotlin("jvm") version "1.8.10"
}

group = "net.kingmc"
version = "0.0.93"

repositories {
    mavenLocal()
    mavenCentral()
}

dependencies {
    implementation("net.kingmc.platform:common:0.0.93-SNAPSHOT")
    implementation("net.kingmc.platform:bukkit :0.0.93-SNAPSHOT")
    implementation("net.kingmc.modules:configuration:0.0.93-SNAPSHOT")
    implementation("net.kingmc.modules:persistence:0.0.93-SNAPSHOT")
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}