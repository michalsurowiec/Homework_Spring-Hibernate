package michalsurowiec.repository;

import michalsurowiec.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Long> {

    @Override
    List<Article> findAll();
}
