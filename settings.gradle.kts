/*
 * This file was generated by the Gradle 'init' task.
 *
 * The settings file is used to specify which projects to include in your build.
 * For more detailed information on multi-project builds, please refer to https://docs.gradle.org/8.6/userguide/multi_project_builds.html in the Gradle documentation.
 */

plugins {
    // Apply the foojay-resolver plugin to allow automatic download of JDKs
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.7.0"
}

rootProject.name = "structurizr-threagile-exporter"
include("lib")

dependencyResolutionManagement {
    versionCatalogs {
        create("libs") {
            plugin("kotlin", "org.jetbrains.kotlin.jvm").version("2.0.21")
            library("structurizr-export", "com.structurizr", "structurizr-export").version("1.19.0")
            library("structurizr-client", "com.structurizr", "structurizr-client").version("1.29.0")
        }
    }
}
