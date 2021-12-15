import org.jetbrains.kotlin.config.KotlinCompilerVersion


plugins {
    id("com.android.library")

    id("kotlin-android")
    id("kotlin-android-extensions")
    id("kotlin-kapt")
}

android {
    dataBinding.isEnabled = true

    compileSdkVersion(rootProject.extra["compileSdkVersion"] as Int)
    defaultConfig {
        minSdkVersion(rootProject.extra["minSdkVersion"] as Int)
        targetSdkVersion(rootProject.extra["targetSdkVersion"] as Int)

        versionCode = rootProject.extra["versionCode"] as Int
        versionName = rootProject.extra["versionName"] as String

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        buildConfigField("String", "hpiCloudUrl", "\"172.18.132.7\"")
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
}

dependencies {
    // Data & Domain Layer
    // Kotlin
    api("org.jetbrains.kotlin:kotlin-stdlib-jdk7:${KotlinCompilerVersion.VERSION}")
    api("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.0.1")
    api("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.0.0")

    // Logging
    api("com.jakewharton.timber:timber:4.7.1")

    // ReactiveX
    api("io.reactivex.rxjava2:rxjava:2.2.7")
    api("io.reactivex.rxjava2:rxandroid:2.1.1")
    api("io.reactivex.rxjava2:rxkotlin:2.3.0")

    // Server
    api("com.google.protobuf:protobuf-java:3.8.0")
    api("io.grpc:grpc-protobuf:1.21.0")
    api("io.grpc:grpc-okhttp:1.21.0")
    api("io.grpc:grpc-stub:1.21.0")
    api("de.hpi.cloud:hpi-cloud:0.0.2") {
        exclude(group = "io.grpc", module = "grpc-netty")
    }

    // DB
    api("androidx.room:room-runtime:2.2.0-alpha01")
    api("androidx.room:room-ktx:2.2.0-alpha01")
    api("androidx.room:room-rxjava2:2.2.0-alpha01")

    // Mapping
    api("com.google.code.gson:gson:2.8.5")

    // AndroidX
    api("androidx.appcompat:appcompat:1.0.2")
    api("androidx.core:core-ktx:1.1.0-rc01")
    api("androidx.annotation:annotation:1.1.0")
    api("androidx.lifecycle:lifecycle-extensions:2.0.0")
    api("androidx.lifecycle:lifecycle-reactivestreams-ktx:2.0.0")
    kapt("androidx.lifecycle:lifecycle-compiler:2.0.0")


    // Presentation Layer
    // Date and Time
    api("com.jakewharton.threetenabp:threetenabp:1.2.0")

    // Images
    api("com.github.bumptech.glide:glide:4.9.0")

    // AndroidX - UI
    api("androidx.cardview:cardview:1.0.0")
    api("androidx.recyclerview:recyclerview:1.0.0")
    api("androidx.constraintlayout:constraintlayout:1.1.3")

    // Material Design
    api("com.google.android.material:material:1.1.0-alpha07")
}
