plugins {
    id("com.android.application")

    id("kotlin-android")
    id("kotlin-android-extensions")
    id("kotlin-kapt")
}

android {
    dataBinding.isEnabled = true

    compileSdkVersion(rootProject.extra["compileSdkVersion"] as Int)
    defaultConfig {
        applicationId = "de.hpi.android"

        minSdkVersion(rootProject.extra["minSdkVersion"] as Int)
        targetSdkVersion(rootProject.extra["targetSdkVersion"] as Int)

        versionCode = rootProject.extra["versionCode"] as Int
        versionName = rootProject.extra["versionName"] as String

        multiDexEnabled = true

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
}

dependencies {
    implementation(project(":core"))
    implementation(project(":post"))

    implementation("androidx.multidex:multidex:2.0.1")
}

configurations {
    all {
        exclude(group = "com.google.guava", module = "listenablefuture")
    }
}