buildscript {
    extra.apply {
        set("compileSdkVersion", 28)
        set("minSdkVersion", 19)
        set("targetSdkVersion", 28)

        set("versionCode", 2)
        set("versionName", "0.0.2")
    }

    repositories {
        google()
        jcenter()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:3.3.0")
        classpath(kotlin("gradle-plugin", "1.3.20"))
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
