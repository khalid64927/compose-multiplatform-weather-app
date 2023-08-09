import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties
import com.codingfeline.buildkonfig.compiler.FieldSpec.Type.STRING
import org.jetbrains.compose.compose

plugins {
    alias(libs.plugins.org.jetbrains.kotlin.multiplatform.plugin)
    alias(libs.plugins.com.android.library.plugin)
    alias(libs.plugins.org.jetbrains.compose.plugin)
    alias(libs.plugins.org.jetbrains.kotlin.serialization.plugin)
    id("com.codingfeline.buildkonfig")
    id("com.squareup.sqldelight")
    id("dev.icerock.mobile.multiplatform-resources")
}

kotlin {
    android {
        compilations.all {
            kotlinOptions {
                jvmTarget = "17"
            }
        }
    }

    targets.withType(org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget::class.java).all {
        binaries.withType(org.jetbrains.kotlin.gradle.plugin.mpp.Framework::class.java).all {
            export(libs.dev.icerock.moko.mvvm.core.get())
        }
    }

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
            isStatic = true
            export(libs.dev.icerock.moko.resources)
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(compose.runtime)
                implementation(compose.foundation)
                implementation(compose.material3)
                implementation(compose.materialIconsExtended)
                @OptIn(org.jetbrains.compose.ExperimentalComposeLibrary::class)
                implementation(compose.components.resources)

                implementation(libs.bundles.sqldelight)
                implementation(libs.org.jetbrains.kotlinx.datetime)
                implementation(libs.bundles.ktor)
                implementation(libs.org.jetbrains.kotlinx.coroutines.core)
                implementation(libs.media.kamel.image)
                implementation(libs.bundles.voyager)
                implementation(libs.bundles.datastore)
                implementation(libs.io.insert.koin.core)
                api(libs.bundles.moko.mvvm)
                api(libs.bundles.moko.resources)
                api(libs.bundles.moko.permissions)
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))

                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
                implementation(libs.kotlinx.coroutines.test)
                // ktor
                implementation(libs.ktor.client.mock)


            }
        }
        val androidMain by getting {
            dependencies {
                implementation(libs.com.squareup.sqldelight.android.driver)
                implementation(libs.androidx.appcompat)
                implementation(libs.androidx.activity.compose)
                implementation(libs.io.ktor.client.android)
                implementation(libs.io.insert.koin.android)
                implementation(libs.com.google.android.gms.play.services.location)
                // TODO: check why preview is not working in androidMain
                implementation(compose.preview)



            }
        }
        val androidUnitTest by getting {
            dependencies {
                implementation(libs.mockk)
                // kotest
                implementation(libs.kotest.runner.junit5)
                implementation(libs.kotest.assertions.core)
                implementation(libs.kotest.property)

                // Compose
                implementation(compose("org.jetbrains.compose.ui:ui-test-junit4"))
                implementation(libs.junit.jupiter)
                implementation(libs.junit.vintage.engine)
            }
        }
        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting
        val iosMain by creating {
            dependencies {
                implementation(libs.com.squareup.sqldelight.native.driver)
                implementation(libs.io.ktor.client.darwin)
            }
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)
        }
        val iosX64Test by getting
        val iosArm64Test by getting
        val iosSimulatorArm64Test by getting
        val iosTest by creating {
            dependsOn(commonTest)
            iosX64Test.dependsOn(this)
            iosArm64Test.dependsOn(this)
            iosSimulatorArm64Test.dependsOn(this)
        }
    }
}

android {
    namespace = "com.rodrigoguerrero.myweather.android"
    compileSdk = 33
    defaultConfig {
        minSdk = 21
    }
    compileOptions {
        // For AGP 4.1+
        isCoreLibraryDesugaringEnabled = true
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

sqldelight {
    database("AppDatabase") {
        packageName = "com.rodrigoguerrero.mywheather.database"
        sourceFolders = listOf("sqldelight")
    }
}

dependencies {
    coreLibraryDesugaring(libs.desugar.jdk.libs)
    implementation(libs.androidx.core)
}

multiplatformResources {
    multiplatformResourcesPackage = "com.rodrigoguerrero.mywheather" // required
}

buildkonfig {
    packageName = "com.rodrigoguerrero.myweather"
    val apiKey: String = gradleLocalProperties(rootDir).getProperty("apiKey")

    require(apiKey.isNotEmpty()) {
        "Register your api key from https://www.weatherapi.com/ and place it in local.properties as `apiKey`"
    }
    defaultConfigs {
        buildConfigField(STRING, "API_KEY", apiKey)
    }

    defaultConfigs("uat"){
        buildConfigField(STRING, "FLAVOR", "uat")
    }

    defaultConfigs("production"){
        buildConfigField(STRING, "FLAVOR", "production")
    }
}
