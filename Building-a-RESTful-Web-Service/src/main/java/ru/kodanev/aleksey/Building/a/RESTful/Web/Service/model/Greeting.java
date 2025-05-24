package ru.kodanev.aleksey.Building.a.RESTful.Web.Service.model;
/*
Это приложение использует библиотеку Jackson JSON для автоматического преобразования экземпляров типа Greeting
в JSON. Библиотека Jackson по умолчанию включена в веб-приложение.
 */
public record Greeting(long id, String content) {
}
