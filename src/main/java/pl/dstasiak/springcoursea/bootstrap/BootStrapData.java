package pl.dstasiak.springcoursea.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.dstasiak.springcoursea.domain.Author;
import pl.dstasiak.springcoursea.domain.Book;
import pl.dstasiak.springcoursea.domain.Publisher;
import pl.dstasiak.springcoursea.repositories.AuthorRepository;
import pl.dstasiak.springcoursea.repositories.BookRepository;
import pl.dstasiak.springcoursea.repositories.PublisherRepository;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author eric = new Author();
        eric.setFirstName("Eric");
        eric.setLastName("Evans");

        Book ddd = new Book();
        ddd.setTitle("Domain Driven Design");
        ddd.setIsbn("123123");

        Author ericSaved = authorRepository.save(eric);
        Book dddSaved = bookRepository.save(ddd);

        Author rod = new Author();
        rod.setFirstName("Rod");
        rod.setLastName("Johnson");

        Book noEJB = new Book();
        noEJB.setTitle("J2EE Development without EJB");
        noEJB.setIsbn("321321");

        Author rodSaved = authorRepository.save(rod);
        Book noEJBSaved = bookRepository.save(noEJB);

        ericSaved.getBooks().add(dddSaved);
        rodSaved.getBooks().add(noEJBSaved);

        System.out.println("Started in Bootstrap");
        System.out.println("Authors count: " + authorRepository.count());
        System.out.println("Books count: " + bookRepository.count());

        Publisher publisherA = new Publisher();
        publisherA.setName("Publisher A");
        publisherA.setCity("City A");
        publisherA.setState("State A");
        publisherA.setAddress("Address A");
        publisherA.setZip("Zip A");

        Publisher publisherB = new Publisher();
        publisherB.setName("Publisher B");
        publisherB.setCity("City B");
        publisherB.setState("State B");
        publisherB.setAddress("Address B");
        publisherB.setZip("Zip B");

        publisherRepository.save(publisherA);
        publisherRepository.save(publisherB);

        System.out.println("Publishers count: " + publisherRepository.count());
    }
}
