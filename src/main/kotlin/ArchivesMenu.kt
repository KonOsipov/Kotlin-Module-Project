fun createArchive() {
    println("Введите название нового архива:")
    scanner.nextLine()
    val archiveName = scanner.nextLine()
    archives[archiveName] = mutableMapOf()
    println("Создан архив: '$archiveName'\n")

}

fun openArchive(input: Int) {
    archiveName = archives.keys.elementAt(input - 1)
    println("Открыт архив: $archiveName\n")
    menu("Работа с заметками","Создать заметку", "Назад","Открыть заметку", archives[archiveName]!!.keys, ::createNote, ::showNote)
}
