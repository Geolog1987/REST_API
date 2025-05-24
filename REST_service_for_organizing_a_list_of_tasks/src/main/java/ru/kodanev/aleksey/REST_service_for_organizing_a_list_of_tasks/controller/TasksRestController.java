package ru.kodanev.aleksey.REST_service_for_organizing_a_list_of_tasks.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.kodanev.aleksey.REST_service_for_organizing_a_list_of_tasks.model.Task;
import ru.kodanev.aleksey.REST_service_for_organizing_a_list_of_tasks.repository.TaskRepository;

import java.util.List;

@RestController
@RequestMapping("api/tasks")
public class TasksRestController {

    private final TaskRepository taskRepository;

    public TasksRestController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @GetMapping
    public ResponseEntity<List<Task>> handleGetAllTasks() {
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(this.taskRepository.findAll());
        /*
        Поскольку метод должен обрабатывать запросы с методом GET и путём /api/tasks,
        я добавил на уровне метода аннотацию @GetMapping, эта аннотация —
        альтернатива @RequestMapping(method = RequestMethod.GET), но исключительно для GET-запросов.
        Путь в аргументах аннотации я не указывал, так как он наследуется от аннотации
        @RequestMapping("api/tasks") на уровне класса.
        В качестве возвращаемого объекта я использовал экземпляр ResponseEntity, так как этого класс позволяет
        детально описать HTTP-ответ, например, указать код состояния HTTP, значение заголовка Content-type и
        задать тело ответа. На основании значения заголовка Content-type Spring Framework постарается
        конвертировать тело ответа в нужный формат. JSON, используемый в этом примере, является стандартным
        форматом представления данных в REST-сервисах, и Spring Framework поддерживает преобразование между
        Java-объектами и JSON при помощи библиотеки Jackson (хотя при желании могут быть использованы и
        другие библиотеки).
         */
    }
}
