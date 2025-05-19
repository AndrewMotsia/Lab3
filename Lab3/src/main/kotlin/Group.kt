// Клас Group представляє групу студентів
class Group(vararg students: Student) {

    // Приватний список студентів, створений з переданих аргументів
    private val studentList = students.toList()

    // Перевантаження оператора [] для доступу до студента за індексом
    operator fun get(index: Int): Student = studentList[index]

    // Повертає студента з найвищим середнім балом або null, якщо список порожній
    fun getTopStudent(): Student? = studentList.maxByOrNull { it.getAverage() }
}
