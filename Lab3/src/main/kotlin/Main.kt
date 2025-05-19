import kotlinx.coroutines.* // Імпорт корутин із kotlinx для асинхронного виконання

fun main() {
    runBlocking { // Запускає корутину, що блокує потік до завершення всіх операцій

        val student1 = Student(name = "   Trump  ") // Створення студента з ім’ям з пробілами

        val deferredGrades = async { fetchGradesFromServer() } // Асинхронне отримання оцінок
        val gradesFromServer = deferredGrades.await() // Очікування завершення та отримання результату
        student1.updateGrades(gradesFromServer) // Оновлення оцінок студента

        // Створення студентів з оцінками
        val student2 = Student("Моця Андрій", 19, listOf(90, 85, 95))
        val student3 = Student("Самойленко Богдан", 20, listOf(70, 60, 80))
        val student4 = Student("Грушківська Анна",18, listOf(100, 100, 100) )

        val group = Group(student1, student2, student3, student4) // Створення групи студентів

        // Вивід інформації про кожного студента
        student1.printInfo()
        student2.printInfo()
        student3.printInfo()

        // Об’єднання оцінок двох студентів
        val combined = student2 + student3
        combined.printInfo()

        // Множення оцінок студента на 2
        val multiplied = student2 * 2
        multiplied.printInfo()

        // Виведення найкращого студента з групи
        println("Top student: ")
        group.getTopStudent()?.printInfo()
    }
}
