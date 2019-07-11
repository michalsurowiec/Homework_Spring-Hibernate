package michalsurowiec.repository;

import michalsurowiec.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface AuthorRepository extends JpaRepository<Author, Long> {

    @Override
    List<Author> findAll();

    Author findById (Long id);
}
