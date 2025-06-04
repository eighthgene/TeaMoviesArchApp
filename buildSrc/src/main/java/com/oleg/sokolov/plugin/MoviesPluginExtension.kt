package com.oleg.sokolov.plugin

open class MoviesPluginExtension {

  /**
   * configure BuildConfig generation
   */
  open var buildConfigGeneration = false

  /**
   * apply "kotlin-parcelize" plugin
   */
  open var kotlinParcelize = false

  /**
   * configure Compose
   */
  open var compose = false

}