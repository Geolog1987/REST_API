package ru.kodanev.aleksey.Building.a.RESTful.Web.Service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.kodanev.aleksey.Building.a.RESTful.Web.Service.model.Greeting;

import java.util.concurrent.atomic.AtomicLong;
@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name){
        return new Greeting(counter.incrementAndGet(), String.format(template,name));
    }

}
/*
@RequestParam привязывает значение параметра строки запроса name к name параметру greeting() метода.
Если name параметр отсутствует в запросе, используется defaultValue of World.
Реализация тела метода создаёт и возвращает новый объект Greeting с атрибутами id и content на основе
следующего значения из counter и форматирует заданный name с помощью приветствия template.
Ключевое различие между традиционным контроллером MVC и контроллером веб-сервиса RESTful, показанным ранее,
заключается в способе создания тела HTTP-ответа. Вместо того чтобы использовать технологию представления для
рендеринга данных приветствия на стороне сервера в HTML, этот контроллер веб-сервиса RESTful заполняет и
возвращает Greeting объект. Данные объекта будут записаны непосредственно в HTTP-ответ в формате JSON.
В этом коде используется аннотация Spring @RestController, которая помечает класс как контроллер,
где каждый метод возвращает объект домена, а не представление. Это сокращение для включения @Controller и
@ResponseBody. GreetingОбъект должен быть преобразован в JSON. Благодаря поддержке Spring для преобразования
HTTP-сообщений вам не нужно выполнять это преобразование вручную.
Поскольку Jackson 2 находится в пути к классу, для преобразования MappingJackson2HttpMessageConverter
экземпляра в JSON автоматически выбирается Spring Greeting.
 */