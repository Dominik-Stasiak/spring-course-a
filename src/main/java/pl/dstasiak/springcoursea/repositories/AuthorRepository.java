package pl.dstasiak.springcoursea.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.dstasiak.springcoursea.domain.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
