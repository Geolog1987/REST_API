package ru.kodanev.aleksey.REST_API_CLIENTS.model;

import org.springframework.stereotype.Service;
import ru.kodanev.aleksey.REST_API_CLIENTS.service.ClientService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
/*
Далее нам необходимо создать реализацию этого интерфейса. Сейчас в роли хранилища клиентов будет выступать
Map<Integer, Client>. Ключом карты будет id клиента, а значением — сам клиент. Сделано это для того, чтобы
не перегружать пример спецификой работы с БД. Однако в будущем мы сможем написать другую реализацию интерфейса,
в которой можно будет подключить реальную базу данных.

В пакете service создадим реализацию интерфейса ClientService:
 */
@Service
public class ClientServiceImpl implements ClientService {
    // Хранилище клиентов
    private static final Map<Integer, Client> CLIENT_REPOSITORY_MAP = new HashMap<>();
    // Переменная для генерации ID клиента
    private static final AtomicInteger CLIENT_ID_HOLDER = new AtomicInteger();
    @Override
    public void create(Client client) {
        final int clientId = CLIENT_ID_HOLDER.incrementAndGet();
        client.setId(clientId);
        CLIENT_REPOSITORY_MAP.put(clientId, client);

    }

    @Override
    public List<Client> readAll() {
        return new ArrayList<>(CLIENT_REPOSITORY_MAP.values());
    }

    @Override
    public Client read(int id) {
        return CLIENT_REPOSITORY_MAP.get(id);
    }

    @Override
    public boolean update(Client client, int id) {
        if (CLIENT_REPOSITORY_MAP.containsKey(id)) {
            client.setId(id);
            CLIENT_REPOSITORY_MAP.put(id, client);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        return CLIENT_REPOSITORY_MAP.remove(id) != null;
    }
}
