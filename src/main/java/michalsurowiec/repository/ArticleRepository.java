package michalsurowiec.repository;

import michalsurowiec.entity.Article;
import michalsurowiec.entity.Author;
import michalsurowiec.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Long> {

    @Override
    List<Article> findAll();

    List<Article> findAllByCategorySetContaining(Category category);

    List<Article> findAllByAuthor(Author author);

    Article findById(Long id);

    @Override
    <S extends Article> S save(S s);

    @Override
    void delete(Article article);
}
