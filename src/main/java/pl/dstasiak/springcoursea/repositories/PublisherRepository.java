package pl.dstasiak.springcoursea.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.dstasiak.springcoursea.domain.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
