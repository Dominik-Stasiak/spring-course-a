package pl.dstasiak.springcoursea.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.dstasiak.springcoursea.domain.Book;

public interface BookRepository extends CrudRepository<Book, Long> {
}
