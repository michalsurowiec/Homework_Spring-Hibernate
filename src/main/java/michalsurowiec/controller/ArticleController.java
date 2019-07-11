package michalsurowiec.controller;

import michalsurowiec.dao.ArticleDao;
import michalsurowiec.dao.AuthorDao;
import michalsurowiec.dao.CategoryDao;
import michalsurowiec.dto.ArticleDto;
import michalsurowiec.entity.Article;
import michalsurowiec.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/article")
public class ArticleController {

    ArticleDao articleDao;
    ArticleService articleService;

    @Autowired
    public ArticleController(ArticleDao articleDao, ArticleService articleService){
        this.articleDao = articleDao;
        this.articleService = articleService;
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
    public String updateCategory(@PathVariable("id") long id, Model model){
        model.addAttribute("categorydto", new ArticleDto(id));
        return "save_article";
    }

    @GetMapping("/read")
    @ResponseBody
    public String readArticles(){
        StringBuffer stringBuffer = new StringBuffer();
        articleService.getAllArticles().forEach(articleDto -> stringBuffer.append(articleDto.toString()).append("<br>"));
        return stringBuffer.toString();
    }

}
