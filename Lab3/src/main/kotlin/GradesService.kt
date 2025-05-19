import kotlinx.coroutines.delay // Імпорт функції затримки з корутин

// Імітує затримку при отриманні оцінок з "сервера"
suspend fun fetchGradesFromServer(): List<Int> {
    delay(2000) // Затримка на 2 секунди для симуляції очікування відповіді
    return listOf(88, 75, 92, 80, 69) // Повертає список оцінок
}
