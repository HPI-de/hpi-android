buildscript {
    extra.apply {
        set("compileSdkVersion", 28)
        set("minSdkVersion", 21)
        set("targetSdkVersion", 28)

        set("versionCode", 2)
        set("versionName", "0.0.2")
    }

    repositories {
        google()
        jcenter()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:3.4.1")
        classpath(kotlin("gradle-plugin", "1.3.40"))
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:2.0.0")

        classpath("com.google.gms:google-services:4.2.0")
    }
}

allprojects {
    repositories {
        google()
        jcenter()
    }
}

tasks.register("clean", Delete::class.java) {
    delete(rootProject.buildDir)
}
