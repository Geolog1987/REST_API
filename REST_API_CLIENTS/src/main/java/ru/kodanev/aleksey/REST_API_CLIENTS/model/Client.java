package ru.kodanev.aleksey.REST_API_CLIENTS.model;
/*
Наше приложение управляет клиентами. Поэтому первым делом нам необходимо создать сущность клиента.
Это будет POJO класс.
Создадим пакет model внутри пакета com.javarush.lectures.rest_example. Внутри пакета model создадим класс Client:
 */
public class Client {
    private int id;
    private String name;
    private String email;
    private String phone;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
