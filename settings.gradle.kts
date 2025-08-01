rootProject.name = "DecomposeTdlibProject"
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    repositories {
        google {
            mavenContent {
                includeGroupAndSubgroups("androidx")
                includeGroupAndSubgroups("com.android")
                includeGroupAndSubgroups("com.google")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositories {
        google {
            mavenContent {
                includeGroupAndSubgroups("androidx")
                includeGroupAndSubgroups("com.android")
                includeGroupAndSubgroups("com.google")
            }
        }
        mavenCentral()
    }
}

include(":composeApp")
include(":tdlibFeatureModules:sharedTdlibFeature")
include(":tdlibFeatureModules:sharedTdlibFeatureApi")
include(":tdlibFeatureModules:messengerDynamicFeature")
include(":tdlibFeatureModules:tdlibFeatureAndroid")
