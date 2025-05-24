package ru.kodanev.aleksey.REST_service_for_organizing_a_list_of_tasks.repository;

import ru.kodanev.aleksey.REST_service_for_organizing_a_list_of_tasks.model.Task;

import java.util.List;

/*
Также мне потребуется компонент для хранения задач — репозиторий (хотя корректнее назвать этот компонент DAO,
т.к. речь идёт о проекте, в котором не применяются практики предметно-ориентированного проектирования).
Но поскольку в рамках этой статьи я не буду касаться вопросов использования аз данных, хранить все существующие
задачи я буду в памяти:
 */
public interface TaskRepository {
    List<Task> findAll();
}
