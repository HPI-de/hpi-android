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
        getByName("debug") {
            applicationIdSuffix = ".debug"
        }
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    resourcePrefix("app_")
}

dependencies {
    implementation(project(":core"))
    implementation(project(":feedback"))
    implementation(project(":news"))

    implementation("androidx.multidex:multidex:2.0.1")
}

//apply(plugin = "com.google.gms.google-services")
