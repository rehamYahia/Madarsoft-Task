// Top-level build file where you can add configuration options common to all sub-projects/modules.

//buildscript {
//    repositories {
//        google()
//    }
//    dependencies {
//        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:2.8.5")
//        classpath ("org.jetbrains.kotlin:kotlin-gradle-plugin:1.9.0")
//    }
//}
//
//plugins {
//    alias(libs.plugins.androidApplication) apply false
//    alias(libs.plugins.jetbrainsKotlinAndroid) apply false
//}
buildscript {
    repositories {
        google()
    }
    dependencies {
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:2.5.3")
        classpath ("com.android.tools.build:gradle:8.3.2")

    }

}
plugins {
    id ("com.android.application") version "7.4.2" apply false
    id ("com.android.library") version "7.4.2" apply false
    id ("org.jetbrains.kotlin.android") version "1.8.0" apply false
    id("com.google.dagger.hilt.android") version "2.44" apply false
}