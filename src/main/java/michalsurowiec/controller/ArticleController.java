package michalsurowiec.controller;

import michalsurowiec.dao.ArticleDao;
import michalsurowiec.dto.ArticleDto;
import michalsurowiec.dto.AuthorDto;
import michalsurowiec.dto.CategoryDto;
import michalsurowiec.entity.Article;
import michalsurowiec.service.ArticleService;
import michalsurowiec.service.AuthorService;
import michalsurowiec.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/article")
public class ArticleController {

    private ArticleDao articleDao;
    private ArticleService articleService;
    private AuthorService authorService;
    private CategoryService categoryService;

    @Autowired
    public ArticleController(ArticleDao articleDao, ArticleService articleService, AuthorService authorService, CategoryService categoryService){
        this.articleDao = articleDao;
        this.articleService = articleService;
        this.authorService = authorService;
        this.categoryService = categoryService;
    }

    @ModelAttribute("authors")
    public List<AuthorDto> authors() {
        return authorService.getAllAuthors();
    }

    @ModelAttribute("categories")
    public List<CategoryDto> categories(){
        return categoryService.getAllCategories();
    }

    @GetMapping("/create")
    public String createArticle(Model model){
        model.addAttribute("articledto", new ArticleDto());
        return "save_article";
    }

    @PostMapping("/save")
    public void saveArticle(@ModelAttribute ArticleDto articleDto){
        Article article = new Article();
        //Ustawić settery
        if (articleDto.getId() != null) {
            article.setId(articleDto.getId());
            articleDao.update(article);
        } else {
            articleDao.create(article);
        }

    }

    @GetMapping("/update/{id}")
    public String updateArticle(@PathVariable("id") long id, Model model){
        model.addAttribute("category", new ArticleDto(id));
        return "save_article";
    }

    @GetMapping("/read")
    @ResponseBody
    public String readArticles(){
        StringBuffer stringBuffer = new StringBuffer();
        articleService.getAllArticles().forEach(articleDto -> stringBuffer.append(articleDto.toString()).append("<br>"));
        return stringBuffer.toString();
    }

    @GetMapping("/delete/{id}")
    public void deleteArticle(@PathVariable("id") Long id){
        articleService.deleteArticle(id);
    }

}
