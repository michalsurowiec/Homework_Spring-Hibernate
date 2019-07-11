package michalsurowiec.repository;

import michalsurowiec.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Override
    List<Category> findAll();
}
