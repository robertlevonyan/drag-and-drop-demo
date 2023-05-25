plugins {
  id("com.android.application")
  kotlin("android")
}

android {
  compileSdk = 33
  defaultConfig {
    applicationId = "com.robertlevonyan.demo.dragndrop"
    minSdk = 23
    targetSdk = 33
    versionCode = 1
    versionName = "1.0"

    testInstrumentationRunner = "android.support.test.runner.AndroidJUnitRunner"
  }
  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
  }
  buildFeatures {
    viewBinding = true
  }
  kotlinOptions {
    jvmTarget = "17"
  }
  buildTypes {
    getByName("release") {
      isMinifyEnabled = false
      proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "$project.rootDir/tools/proguard-rules.pro")
    }
  }
  namespace = "com.robertlevonyan.demo.dragndrop"
}

dependencies {
  kotlin("stdlib")
  implementation("com.google.android.material:material:1.9.0")
  implementation("androidx.appcompat:appcompat:1.6.1")
  implementation("androidx.constraintlayout:constraintlayout:2.1.4")
  implementation("com.google.android.flexbox:flexbox:3.0.0")
}
