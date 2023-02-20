import java.util.Scanner

val archives: MutableMap<String, MutableMap<String, String>> = mutableMapOf()
val scanner: Scanner = Scanner(System.`in`)
var archiveName: String? = null

fun main() {
    println("Добро пожаловать в Архивариус ver1.0!")
    println("=====================================")
    menu("Работа с архивами","Создать архив","Выход","Открыть архив",archives.keys,::createArchive,::openArchive)
    println("Завершение программы")

}
fun menu(name: String,create:String,exit: String,command:String,menuList: Iterable<String>,toCreationMenu: () -> Unit,
         toNextMenu: (input: Int) -> Unit){

    while(true){

        println(name)
        if(archives.isEmpty())
        {
            println("  Архивы не обнаружены!")
        }
        println("Команды:")
        println("  0. $create")
        var counter = 1
        menuList.forEach {
            println("  ${counter++}. $command $it")
        }
        println("  $counter. $exit")

        while (scanner.hasNext() and !scanner.hasNextInt()) {
            println("Введено неверное значение! Повторите попытку!")
            scanner.next()
        }

        when (val input = scanner.nextInt()) {
            0 -> toCreationMenu()
            in 0 until counter -> toNextMenu(input)
            counter ->{break}
            else -> println("Такого числа нет в списке! Повторите попытку!")
        }
    }
}


