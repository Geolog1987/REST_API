package ru.kodanev.aleksey.REST_API_CLIENTS.service;

import ru.kodanev.aleksey.REST_API_CLIENTS.model.Client;

import java.util.List;

/*
В сервисе будут реализованы CRUD операции над клиентом. Следующим шагом мы должны создать сервис,
в котором будут реализованы эти операции. В пакете com.javarush.lectures.rest_example создадим пакет service,
внутри которого создадим интерфейс ClientService.
 */
public interface ClientService {
    /**
     * Создает нового клиента
     * @param client - клиент для создания
     */
    void create(Client client);

    /**
     * Возвращает список всех имеющихся клиентов
     * @return список клиентов
     */
    List<Client> readAll();

    /**
     * Возвращает клиента по его ID
     * @param id - ID клиента
     * @return - объект клиента с заданным ID
     */
    Client read(int id);

    /**
     * Обновляет клиента с заданным ID,
     * в соответствии с переданным клиентом
     * @param client - клиент в соответсвии с которым нужно обновить данные
     * @param id - id клиента которого нужно обновить
     * @return - true если данные были обновлены, иначе false
     */
    boolean update(Client client, int id);

    /**
     * Удаляет клиента с заданным ID
     * @param id - id клиента, которого нужно удалить
     * @return - true если клиент был удален, иначе false
     */
    boolean delete(int id);
}
