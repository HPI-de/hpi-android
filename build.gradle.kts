buildscript {
    repositories {
        google()
        jcenter()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:3.3.0")
        classpath(kotlin("gradle-plugin", "1.3.11"))
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
