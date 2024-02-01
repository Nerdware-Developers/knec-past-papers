plugins {
    id("com.android.application")
    id("com.google.gms.google-services")
}

android {
    namespace = "com.nerdware.knecpastpapers"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.nerdware.knecpastpapers"
        minSdk = 24
        targetSdk = 34
        versionCode = 3
        versionName = "1.2"

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
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {

    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")

    implementation("com.squareup.okhttp3:okhttp:4.12.0")
    
    implementation ("org.jetbrains.kotlin:kotlin-stdlib:1.9.20")
    implementation ("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.9.10")

    implementation ("com.github.denzcoskun:ImageSlideshow:0.1.0")

    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("com.google.firebase:firebase-database-ktx:20.3.0")

    implementation ("com.google.firebase:firebase-firestore:24.10.1")
    implementation ("com.google.firebase:firebase-storage:20.3.0")
    implementation ("com.google.android.gms:play-services-ads:22.6.0")
    implementation("com.google.android.gms:play-services-ads:22.6.0")
    implementation("androidx.navigation:navigation-fragment:2.7.6")
    implementation("androidx.navigation:navigation-ui:2.7.6")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    implementation ("com.github.mhiew:android-pdf-viewer:3.2.0-beta.1")
}