plugins {
    id("com.android.application")
    id("kotlin-android")
    id("dev.flutter.flutter-gradle-plugin")
}

android {
    namespace = "com.eskalasi.safeexam.safe_exam_app"
    compileSdk = flutter.compileSdkVersion

    defaultConfig {
        applicationId = "com.eskalasi.safeexam.safe_exam_app"
        minSdk = flutter.minSdkVersion
        targetSdk = flutter.targetSdkVersion
        versionCode = flutter.versionCode
        versionName = flutter.versionName
    }

    compileOptions {
        // WAJIB untuk plugin seperti flutter_local_notifications
        isCoreLibraryDesugaringEnabled = true

        // Java 17 (direkomendasikan Flutter terbaru)
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
    }

    buildTypes {
        getByName("release") {
            signingConfig = signingConfigs.getByName("debug")
        }
    }
}

flutter {
    source = "../.."
}

dependencies {
    // FIX UTAMA: upgrade dari 2.0.4 → minimal 2.1.4
    coreLibraryDesugaring("com.android.tools:desugar_jdk_libs:2.1.4")
}
