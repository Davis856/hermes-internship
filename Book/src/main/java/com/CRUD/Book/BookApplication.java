package com.CRUD.Book;

import com.CRUD.Book.repo.Repository;
import com.CRUD.Book.service.Service;
import com.CRUD.Book.ui.UI;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookApplication.class, args);

		Repository repo = new Repository();
		Service serv = new Service(repo);
		UI ui = new UI(serv);

		ui.startUI();
	}

}
