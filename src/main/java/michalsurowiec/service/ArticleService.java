package michalsurowiec.service;

import michalsurowiec.dto.ArticleDto;
import michalsurowiec.entity.Article;
import michalsurowiec.entity.Category;
import michalsurowiec.repository.ArticleRepository;
import michalsurowiec.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ArticleService {

    private ArticleRepository articleRepository;
    private CategoryRepository categoryRepository;

    @Autowired
    public ArticleService(ArticleRepository articleRepository, CategoryRepository categoryRepository){
        this.articleRepository = articleRepository;
        this.categoryRepository = categoryRepository;
    }

    public List<ArticleDto> getAllArticles(){
        List<Article> articleList = articleRepository.findAll();
        List<ArticleDto> articleDtoList = new ArrayList<>();
        for(Article eachArticle : articleList){
            articleDtoList.add(new ArticleDto(eachArticle));
        }
        return articleDtoList;
    }

    public void deleteArticle(Long id){
        Article article = articleRepository.findById(id);
        List<Category> categoryList = categoryRepository.findAllByArticleSetContaining(article);
        categoryList.forEach(category -> category.getArticleSet().remove(article));
        categoryRepository.save(categoryList);
        articleRepository.delete(article);
    }

}
