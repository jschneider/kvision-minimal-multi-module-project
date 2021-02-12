package com.example

import pl.treksoft.kvision.*
import pl.treksoft.kvision.html.*
import pl.treksoft.kvision.i18n.*
import pl.treksoft.kvision.modal.*
import pl.treksoft.kvision.panel.*

class App : Application() {
  init {
    require("css/kvapp.css")
  }

  override fun start() {
    I18n.manager =
      DefaultI18nManager(
        mapOf(
          "pl" to require("i18n/messages-pl.json"),
          "en" to require("i18n/messages-en.json")
        )
      )

    root("kvapp", containerType = ContainerType.NONE, addRow = false) {
      addCssClass("h-100")
      addCssClass("d-flex")
      addCssClass("flex-column")

      header(className = "container") {
        div(className = "row") {
          addCssClass("banner")

          div(className = "col-md-12") {
            h1("Banner Content!")
            p("Hello in the banner!")
          }
        }
      }

      main(className = "container-fluid") {
        addCssClass("flex-fill")

        div(className = "row") {
          addCssClass("h-100")

          div(className = "col-md-2") {
            h1("Left Config")
            h3("Roof")


            label("Size") {
              forId = "roofSizeSpan"
            }

            button(text = "Edit", icon = "fas fa-pen") {
              onClick {
                val modal = Modal(
                  "Roof size",
                  size = ModalSize.SMALL,
                  closeButton = true,
                  animation = true,
                  escape = true
                )
                modal.show()
              }
              style = ButtonStyle.SECONDARY
            }

          }

          div(classes = setOf("col-md-8")) {
            h1("Hey Main Content! 2")
          }

          div(className = "col-md-2") {
            h1("Right side")
          }
        }
      }

      footer {

      }
    }

  }
}

fun main() {
  startApplication(::App, module.hot)
}
