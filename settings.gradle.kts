pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "KMP"
include(":androidApp")
include(":shared")
include(":feature:contacts")
include(":feature:isnearme")
include(":feature:isbirthday")
include(":feature:contactdetails")
include(":feature:favorites")
