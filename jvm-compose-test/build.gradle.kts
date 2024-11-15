plugins {
    `java-library`
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.compose)
    alias(libs.plugins.compose.compiler)
}

java {
    toolchain { languageVersion.set(JavaLanguageVersion.of(libs.versions.jdk.get().toInt())) }
    sourceCompatibility = JavaVersion.toVersion(libs.versions.jdk.get().toInt())
    targetCompatibility = JavaVersion.toVersion(libs.versions.jdk.get().toInt())
}

dependencies {
    implementation(project(":shared"))
    implementation(project(":shared-compose-ui"))
    implementation(libs.androidx.lifecycle.common)
    implementation(libs.androidx.lifecycle.runtime)
    implementation(platform(libs.koin.bom))
    implementation(libs.koin.core)
    implementation(libs.turbine)
    implementation(compose.desktop.uiTestJUnit4)
    implementation(compose.desktop.currentOs)
}
