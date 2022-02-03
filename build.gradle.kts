buildscript {
  repositories {
    google()
    jcenter()
    mavenCentral()
  }
  dependencies {
    classpath("com.android.tools.build:gradle:7.1.0")
    classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.21")
  }
}

allprojects {
  repositories {
    google()
    jcenter()
    mavenCentral()
  }
}

tasks.register("clean", Delete::class) {
  delete(rootProject.buildDir)
}
