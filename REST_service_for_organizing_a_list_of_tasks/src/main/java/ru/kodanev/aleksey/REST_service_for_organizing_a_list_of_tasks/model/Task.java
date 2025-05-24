package ru.kodanev.aleksey.REST_service_for_organizing_a_list_of_tasks.model;
/*
Поскольку речь идёт о сервисе планирования задач, то мне потребуется класс, описывающий задачу:
 */
import java.util.UUID;// Генерация уникального идентификатора (UUID)
/*
В Java record - это специальный тип класса, представленный в Java 14 как preview-функция и ставший стандартным
в Java 16. Record автоматически создает неизменяемый класс с конструктором, геттерами и методами equals(),
hashCode() и toString().
 */

public record Task(UUID id, String details, boolean completed) {

    public Task(String details) {
        this(UUID.randomUUID(), details, false);
    }
}

