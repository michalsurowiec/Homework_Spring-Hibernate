package michalsurowiec.service;

import michalsurowiec.dao.CategoryDao;
import michalsurowiec.dto.CategoryDto;
import michalsurowiec.entity.Article;
import michalsurowiec.entity.Category;
import michalsurowiec.repository.ArticleRepository;
import michalsurowiec.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class CategoryService {

    private CategoryRepository categoryRepository;
    private ArticleRepository articleRepository;

    @Autowired
    public CategoryService (CategoryRepository categoryRepository, ArticleRepository articleRepository){
        this.categoryRepository = categoryRepository;
        this.articleRepository = articleRepository;
    }

    public List<CategoryDto> getAllCategories(){
        List <Category> categoryList = categoryRepository.findAll();
        List<CategoryDto> categoryDtoList = new ArrayList<>();
        for(Category eachCategory : categoryList){
            categoryDtoList.add(new CategoryDto(eachCategory));
        }
        return categoryDtoList;
    }

    public void deleteCategory(Long id){
        Category category = categoryRepository.findById(id);
        List<Article> articleList = articleRepository.findAllByCategorySetContaining(category);
        articleList.forEach(article -> article.getCategorySet().remove(category));
        articleRepository.save(articleList);
        categoryRepository.delete(category);
    }

}
