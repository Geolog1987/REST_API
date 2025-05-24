package ru.kodanev.aleksey.REST_API_CLIENTS.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.kodanev.aleksey.REST_API_CLIENTS.model.Client;
import ru.kodanev.aleksey.REST_API_CLIENTS.service.ClientService;

import java.util.List;

@RestController//@RestController — говорит спрингу, что данный класс является REST контроллером.
// Т.е. в данном классе будет реализована логика обработки клиентских запросов
public class ClientController {

    private final ClientService clientService;

    @Autowired
//@Autowired — говорит спрингу, что в этом месте необходимо внедрить зависимость. В конструктор мы передаем интерфейс ClientService.
    // Реализацию данного сервиса мы пометили аннотацией @Service ранее, и теперь спринг сможет передать экземпляр
    // этой реализации в конструктор контроллера.
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping(value = "/clients")
    public ResponseEntity<?> create(@RequestBody Client client) {
        clientService.create(client);
        return new ResponseEntity<>(HttpStatus.CREATED);
        /*
       @PostMapping(value = "/clients") — здесь мы обозначаем, что данный метод обрабатывает POST запросы на адрес /clients
       Метод возвращает ResponseEntity<?>. ResponseEntity — специальный класс для возврата ответов.
       С помощью него мы сможем в дальнейшем вернуть клиенту HTTP статус код.
       Метод принимает параметр @RequestBody Client client, значение этого параметра подставляется из тела запроса.
       Об этом говорит аннотация @RequestBody.
       Внутри тела метода мы вызываем метод create у ранее созданного сервиса и передаем ему принятого в параметрах
       контроллера клиента.
       После чего возвращаем статус 201 Created, создав новый объект ResponseEntity и передав в него нужное значение
       енума HttpStatus.
         */
    }

    @GetMapping(value = "/clients")
    public ResponseEntity<List<Client>> read() {
        final List<Client> clients = clientService.readAll();

        return clients != null && !clients.isEmpty()
                ? new ResponseEntity<>(clients, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
        /*
        @GetMapping(value = "/clients") — все аналогично аннотации @PostMapping, только теперь мы обрабатываем GET запросы.
        На этот раз мы возвращаем ResponseEntity<List<Client>>, только в этот раз, помимо HTTP статуса, мы вернем еще и
        тело ответа, которым будет список клиентов.
        В REST контроллерах спринга все POJO объекты, а также коллекции POJO объектов, которые возвращаются в качестве
        тел ответов, автоматически сериализуются в JSON, если явно не указано иное. Нас это вполне устраивает.
        Внутри метода, с помощью нашего сервиса мы получаем список всех клиентов. Далее, в случае если список не null и
        не пуст, мы возвращаем c помощью класса ResponseEntity сам список клиентов и HTTP статус 200 OK.
        Иначе мы возвращаем просто HTTP статус 404 Not Found.
         */
    }

    @PutMapping(value = "/clients/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") int id, @RequestBody Client client) {
        final boolean updated = clientService.update(client, id);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/clients/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") int id) {
        final boolean deleted = clientService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);

        /*
        Чего-то существенно нового в данных методах нет, поэтому подробное описание пропустим. Единственное,
        о чем стоит сказать: метод update обрабатывает PUT запросы (аннотация @PutMapping),
        а метод delete обрабатывает DELETE запросы (аннотация DeleteMapping).
         */
    }
}
