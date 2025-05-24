package ru.kodanev.aleksey.REST_service_for_organizing_a_list_of_tasks.repository;

import org.springframework.stereotype.Repository;
import ru.kodanev.aleksey.REST_service_for_organizing_a_list_of_tasks.model.Task;

import java.util.*;
@Repository
public class InMemTaskRepository implements TaskRepository{

    private List<Task> tasks = new LinkedList<>(){{
        this.add(new Task("First organization"));
        this.add(new Task("Second organization"));
        /*
        В данном случае двойные фигурные скобки {{ }} используются для создания анонимного класса с
        инициализатором экземпляра. Это называется "double brace initialization".
        Первые скобки создают анонимный класс, вторые - блок инициализации.
         */
    }};

    @Override
    public List<Task> findAll() {
        return this.tasks;
    }
}
