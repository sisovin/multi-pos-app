# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in D:\laragon\www\mobiles\multi-pos-app\app\build.gradle.kts.

# ProGuard rules for Jetpack Compose
-keep class androidx.compose.** { *; }

# ProGuard rules for Hilt
-keep class com.example.multipos.Hilt_MultiPosApplication { *; }
-keep class dagger.hilt.** { *; }
-keep class javax.inject.** { *; }
