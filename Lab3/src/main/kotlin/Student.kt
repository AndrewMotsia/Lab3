// Клас Student представляє студента з ім'ям, віком і списком оцінок
class Student(name: String, age: Int = 0, grades: List<Int> = listOf()) {

    // Приватне поле для імені — очищується і перша літера робиться великою
    private var _name: String = name.trim().replaceFirstChar { it.uppercase() }
        set(value) {
            field = value.trim().replaceFirstChar { it.uppercase() }
        }

    // Приватне поле для віку
    private var _age: Int = if (age >= 0) age else 0
        set(value) {
            if (value >= 0) field = value
        }

    // Приватне поле для списку оцінок
    private var _grades: List<Int> = grades

    // Публічна властивість, яка визначає, чи є студент повнолітнім
    val isAdult: Boolean
        get() = _age >= 18

    // Властивість статусу ("Adult" або "Minor"), обчислюється лише один раз (lazy)
    val status: String by lazy { if (isAdult) "Adult" else "Minor" }

    // Ініціалізаційний блок — виводить повідомлення при створенні об'єкта
    init {
        println("Студента $_name створено!")
    }

    // Другий конструктор — дозволяє створити студента лише з ім'ям
    constructor(name: String) : this(name, 0, listOf())

    // Обчислює середній бал, або повертає 0.0, якщо оцінок немає
    fun getAverage(): Double = if (_grades.isEmpty()) 0.0 else _grades.average()

    // Обробляє всі оцінки через передану функцію
    fun processGrades(operation: (Int) -> Int) {
        _grades = _grades.map(operation)
    }

    // Оновлює список оцінок
    fun updateGrades(grades: List<Int>) {
        _grades = grades
    }

    // Перевантажений оператор + — об'єднує оцінки двох студентів у нового
    operator fun plus(other: Student): Student {
        return Student(_name, _age, _grades + other._grades)
    }

    // Перевантажений оператор * — множить усі оцінки на задане число
    operator fun times(multiplier: Int): Student {
        return Student(_name, _age, _grades.map { it * multiplier })
    }

    // Перевизначення методу equals — порівнює студентів за іменем та середнім балом
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Student) return false
        return _name == other._name && getAverage() == other.getAverage()
    }

    // Перевизначення hashCode для коректного використання у множинах, мапах тощо
    override fun hashCode(): Int {
        return _name.hashCode() * 31 + getAverage().hashCode()
    }

    // Виводить детальну інформацію про студента
    fun printInfo() {
        println("Name: $_name, Age: $_age, Grades: $_grades, Avg: ${getAverage()}, Adult: $isAdult, Status: $status")
    }
}
