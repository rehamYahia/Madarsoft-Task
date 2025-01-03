plugins {
    id ("com.android.application")
    id ("org.jetbrains.kotlin.android")
    id ("kotlin-kapt")
    id("com.google.dagger.hilt.android")
    id("androidx.navigation.safeargs")
    
}

android {
    namespace = "com.m.e.diaf.madarsofttask"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.m.e.diaf.madarsofttask"
        minSdk = 28
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        debug {
            isDebuggable = true
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    java {
        toolchain {
            languageVersion = JavaLanguageVersion.of(17)
        }
    }
    buildFeatures {
        viewBinding = true
        dataBinding = true
    }
}

dependencies {

//    implementation(libs.androidx.core.ktx)
//    implementation(libs.androidx.appcompat)
//    implementation(libs.material)
//    implementation(libs.androidx.activity)
//    implementation(libs.androidx.constraintlayout)
//    implementation(libs.androidx.room.common)
//    testImplementation(libs.junit)
//    androidTestImplementation(libs.androidx.junit)
//    androidTestImplementation(libs.androidx.espresso.core)

    implementation ("androidx.core:core-ktx:1.10.1")
    implementation ("androidx.appcompat:appcompat:1.6.1")
    implementation ("com.google.android.material:material:1.9.0")
    implementation ("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation ("com.tencent.wcdb:room:1.1-19")
    implementation ("com.android.car.ui:car-ui-lib:2.5.1")
    implementation ("androidx.fragment:fragment:1.6.1")
    testImplementation ("junit:junit:4.13.2")
    androidTestImplementation ("androidx.test.ext:junit:1.1.5")
    androidTestImplementation ("androidx.test.espresso:espresso-core:3.5.1")
    implementation ("androidx.activity:activity-ktx:1.8.0") // أو أحدث إصدار متوفر


    //retrofit2
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    //gson converter
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
    //recycler view
    implementation ("androidx.recyclerview:recyclerview:1.3.1")
    //card view
    implementation ("androidx.cardview:cardview:1.0.0")
    //material design
    implementation ("com.google.android.material:material:1.9.0")


    //navigation
    implementation("androidx.navigation:navigation-fragment-ktx:2.5.3")
    implementation("androidx.navigation:navigation-ui-ktx:2.5.3")
//    // Feature module Support
//    implementation("androidx.navigation:navigation-dynamic-features-fragment:$nav_version")
//    // Testing Navigation
//    androidTestImplementation("androidx.navigation:navigation-testing:$nav_version")

    //sdp
    implementation ("com.intuit.sdp:sdp-android:1.1.0")

    //hilt
    implementation("com.google.dagger:hilt-android:2.44")
    kapt("com.google.dagger:hilt-android-compiler:2.44")

    //coroutines
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.4")
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
    //room
    //noinspection GradleDependency
    implementation ("androidx.room:room-runtime:2.4.3")
    kapt ("androidx.room:room-compiler:2.4.3")
    //noinspection GradleDependency
    implementation ("androidx.room:room-ktx:2.4.3")

    //viewmodel
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.1")
    implementation ("androidx.activity:activity-ktx:1.7.2")

    // Glide
    implementation ("com.github.bumptech.glide:glide:4.15.1")
    annotationProcessor ("com.github.bumptech.glide:compiler:4.15.1")

    //easyPermission
    implementation ("pub.devrel:easypermissions:3.0.0")

    //material design
    implementation ("com.google.android.material:material:1.9.0")

    //coil
    implementation("io.coil-kt:coil:1.0.0-rc3")

}
kapt {
    javacOptions {
        // استخدام نفس الإصدار لـ kapt
        option("-source", "17")
        option("-target", "17")
    }
}

//kapt {
//    correctErrorTypes = true
//}

