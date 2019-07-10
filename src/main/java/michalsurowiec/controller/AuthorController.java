package michalsurowiec.controller;

import michalsurowiec.dao.ArticleDao;
import michalsurowiec.dao.AuthorDao;
import michalsurowiec.dao.CategoryDao;
import michalsurowiec.dto.AuthorDto;
import michalsurowiec.entity.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/author")
public class AuthorController {

    ArticleDao articleDao;
    AuthorDao authorDao;
    CategoryDao categoryDao;

    @Autowired
    public AuthorController(ArticleDao articleDao, AuthorDao authorDao, CategoryDao categoryDao){
        this.articleDao = articleDao;
        this.authorDao = authorDao;
        this.categoryDao = categoryDao;
    }

    @GetMapping("/create")
    public String createAuthor(Model model){
        model.addAttribute("authordto", new AuthorDto());
        return "save_author";
    }

    @PostMapping("/save")
    public void saveCategory(@ModelAttribute AuthorDto authorDto){
        Author author = new Author();
        author.setFirstName(authorDto.getFirstName());
        author.setLastName(authorDto.getLastName());
        if (authorDto.getId() != null) {
            author.setId(authorDto.getId());
            authorDao.update(author);
        } else {
            authorDao.create(author);
        }

    }

    @GetMapping("/update/{id}")
    public String updateCategory(@PathVariable("id") long id, Model model){
        model.addAttribute("authordto", new AuthorDto(id));
        return "save_author";
    }

}
