plugins {
    kotlin("jvm") version "1.3.72"
}

group = "dev.talkischeap"
version = "0.0.1-SNAPSHOT"

repositories {
    mavenLocal()
    mavenCentral()
}

val nioServerVersion = "0.0.1-SNAPSHOT"

dependencies {
    implementation(kotlin("stdlib"))
    implementation("dev.talkischeap", "nio-server", nioServerVersion)
}