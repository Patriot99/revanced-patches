extension {
    name = "extensions/shared.rve"
}

android {
    namespace = "app.revanced.extension"
    compileSdk = 34

    defaultConfig {
        minSdk = 24
    }

    buildTypes {
        release {
            isMinifyEnabled = true
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

dependencies {
    compileOnly(libs.annotation)
    compileOnly(libs.preference)
    implementation(libs.collections4)
    implementation(libs.lang3)

    implementation(libs.okhttp)

    compileOnly(project(":extensions:shared:stub"))
}
