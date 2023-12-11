package com.example.CourseLibraryProj;

import com.example.CourseLibraryProj.entity.Author;
import com.example.CourseLibraryProj.entity.Book;
import com.example.CourseLibraryProj.entity.Category;
import com.example.CourseLibraryProj.entity.Publisher;
import com.example.CourseLibraryProj.service.BookService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CourseLibraryProjApplication {

	public static void main(String[] args) {
		SpringApplication.run(CourseLibraryProjApplication.class, args);
	}

	// .\mvnw spring-boot:build-image "-Dspring-boot.build-image.imageName=deepakdambe/LibraryProj"

	@Bean
	public CommandLineRunner initialCreate(BookService bookService)
	{
		return (args) -> {
			Book book1 = new Book("Book Name 1", "Book ISBN 1", "Book Desc 1");
			Author author1 = new Author("Author Name 1", "Author Desc 1");
			Category category1 = new Category("Category Name 1");
			Publisher publisher1 = new Publisher("Publisher Name 1");
			book1.addAuthor(author1);
			book1.addCategory(category1);
			book1.addPublisher(publisher1);
			bookService.saveBook(book1);

			Book book2 = new Book("Book Name 2", "Book ISBN 2", "Book Desc 2");
			Author author2 = new Author("Author Name 2", "Author Desc 2");
			Category category2 = new Category("Category Name 2");
			Publisher publisher2 = new Publisher("Publisher Name 2");
			book2.addAuthor(author2);
			book2.addCategory(category2);
			book2.addPublisher(publisher2);
			bookService.saveBook(book2);

			Book book3 = new Book("Book Name 3", "Book ISBN 3", "Book Desc 3");
			Author author3 = new Author("Author Name 3", "Author Desc 3");
			Category category3 = new Category("Category Name 3");
			Publisher publisher3 = new Publisher("Publisher Name 3");
			book3.addAuthor(author3);
			book3.addCategory(category3);
			book3.addPublisher(publisher3);
			bookService.saveBook(book3);

		};
	}

}
