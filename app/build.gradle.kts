plugins {
  id("com.android.application")
  kotlin("android")
}

android {
  compileSdk = 31
  defaultConfig {
    applicationId = "com.robertlevonyan.demo.dragndrop"
    minSdk = 23
    targetSdk = 31
    versionCode = 1
    versionName = "1.0"

    testInstrumentationRunner = "android.support.test.runner.AndroidJUnitRunner"
  }
  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
  }
  buildFeatures {
    viewBinding = true
  }
  kotlinOptions {
    jvmTarget = "11"
  }
  buildTypes {
    getByName("release") {
      isMinifyEnabled = false
      proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "$project.rootDir/tools/proguard-rules.pro")
    }
  }
}

dependencies {
  kotlin("stdlib")
  implementation("com.google.android.material:material:1.4.0")
  implementation("androidx.appcompat:appcompat:1.3.1")
  implementation("androidx.constraintlayout:constraintlayout:2.1.0")
  implementation("com.google.android:flexbox:2.0.1")
}
