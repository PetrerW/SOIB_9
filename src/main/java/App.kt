import ui.UserInterface

object Application {
    var JAVA = "java"
    var KOTLIN = "kotlin"
    @JvmStatic
    fun main(args: Array<String>) {
        UserInterface.run()
    }


}