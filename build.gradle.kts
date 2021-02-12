version = "1.0.0-SNAPSHOT"
group = "com.example"

plugins {
  base

  val kotlinVersion: String by System.getProperties()
  id("kotlinx-serialization") version kotlinVersion apply false

  kotlin("js") version kotlinVersion apply false
}

allprojects {
  /**
   * This task compiles the code to JS
   */
  tasks.withType<org.jetbrains.kotlin.gradle.dsl.KotlinJsCompile> {
    kotlinOptions {
      languageVersion = "1.5"
      apiVersion = "1.5"

      freeCompilerArgs = listOf("-progressive", "-Xinline-classes", "-Xir-property-lazy-initialization")

      allWarningsAsErrors = false
      suppressWarnings = true
      verbose = false

      kotlinOptions.metaInfo = true
      sourceMap = true
      sourceMapEmbedSources = "always"
    }
  }
}
