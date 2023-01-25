plugins {
    kotlin("multiplatform")
    id("com.android.library")
}

kotlin {
    android()

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {

                implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.4.0")
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.4.1")
                implementation("io.insert-koin:koin-core:3.3.2")
                implementation("io.ktor:ktor-client-core:2.2.2")
                implementation("io.ktor:ktor-client-json:2.2.2")
                implementation("io.ktor:ktor-client-logging:2.2.2")
                implementation("io.ktor:ktor-client-serialization:2.2.2")
                implementation(kotlin("test"))

                // Util Network
                implementation("io.ktor:ktor-client-core:2.2.2")
                api("io.ktor:ktor-serialization-kotlinx-json:2.2.2")
                implementation("io.ktor:ktor-client-content-negotiation:2.2.2")
                implementation("io.ktor:ktor-client-cio:2.2.2")
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val androidMain by getting {
            dependencies {
                api("androidx.lifecycle:lifecycle-viewmodel-ktx:2.4.1")
                implementation("io.ktor:ktor-client-android:2.2.2")

                // Koin main features for Android
                implementation("io.insert-koin:koin-android:3.3.2")

                //Database
                val room_version = "2.5.0"
                implementation("androidx.room:room-runtime:$room_version")
                implementation("androidx.room:room-ktx:$room_version")
                implementation("androidx.room:room-paging:$room_version")


                // Util Networking
                implementation("io.ktor:ktor-client-android:2.2.2")

                // Util paging
                implementation("io.ktor:ktor-client-android:2.2.2")
                implementation("androidx.paging:paging-common:3.1.1")

            }
        }
        val androidTest by getting
        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting
        val iosMain by creating {
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)
            dependencies {
            }
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
    namespace = "com.jco.kmp"
    compileSdk = 32
    defaultConfig {
        minSdk = 21
        targetSdk = 32
    }
}
dependencies {
    implementation("androidx.lifecycle:lifecycle-viewmodel-savedstate:2.5.1")
}
