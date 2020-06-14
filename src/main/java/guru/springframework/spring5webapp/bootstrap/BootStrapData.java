package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.Reposotories.AuthorRepository;
import guru.springframework.spring5webapp.Reposotories.BookRepository;
import guru.springframework.spring5webapp.Reposotories.PublisherRepository;
import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    private final AuthorRepository authorRepository;

    private final BookRepository bookRepository;

    private final PublisherRepository publisherRepository;

    @Override
    public void run(String... args) throws Exception {

        Publisher pub = new Publisher("MES", "Bangalore");

        publisherRepository.save(pub);

        Author eric = new Author("Eric","Evans");
        Book ddd = new Book("Domain Driver Design","123123");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        ddd.setPublisher(pub);

        authorRepository.save(eric);
        bookRepository.save(ddd);

        Author rod = new Author("Rod","Johnson");
        Book noEJB = new Book("J2EE Development without EJB","3939459459");
        noEJB.setPublisher(pub);
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);





        authorRepository.save(rod);
        bookRepository.save(noEJB);

        System.out.println("Started in BootStrap");
        System.out.println("Number of Books: "+ bookRepository.count());
        System.out.print("Number of Author" + authorRepository.count());
        System.out.print("Number of Publisher" + publisherRepository.count());
    }
}
