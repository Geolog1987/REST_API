package ru.kodanev.aleksey.Building.a.RESTful.Web.Service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BuildingAResTfulWebServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BuildingAResTfulWebServiceApplication.class, args);
	}

}
/*
@SpringBootApplication Это удобная аннотация, которая добавляет все следующее:
@Configuration: Помечает класс как источник определений компонентов для контекста приложения.
@EnableAutoConfigurationУказывает Spring Boot на необходимость добавления компонентов на основе настроек
пути к классам, других компонентов и различных настроек свойств. Например, если spring-webmvc находится в
пути к классам, эта аннотация помечает приложение как веб-приложение и активирует ключевые функции,
такие как настройка DispatcherServlet.
@ComponentScan: Указывает Spring на необходимость поиска других компонентов, конфигураций и сервисов в
пакете com/example, позволяя ему находить контроллеры.
 */