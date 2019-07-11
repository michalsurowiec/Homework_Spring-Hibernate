package michalsurowiec.controller;

import michalsurowiec.dao.ArticleDao;
import michalsurowiec.dao.AuthorDao;
import michalsurowiec.dao.CategoryDao;
import michalsurowiec.dto.AuthorDto;
import michalsurowiec.entity.Author;
import michalsurowiec.repository.AuthorRepository;
import michalsurowiec.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/author")
public class AuthorController {

    AuthorDao authorDao;
    AuthorRepository authorRepository;
    AuthorService authorService;

    @Autowired
    public AuthorController(AuthorDao authorDao, AuthorRepository authorRepository, AuthorService authorService){
        this.authorDao = authorDao;
        this.authorRepository = authorRepository;
        this.authorService = authorService;
    }

    @GetMapping("/create")
    public String createAuthor(Model model){
        model.addAttribute("authordto", new AuthorDto());
        return "save_author";
    }

    @PostMapping("/save")
    public void saveAuthor(@ModelAttribute AuthorDto authorDto){
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
    public String updateAuthor(@PathVariable("id") Long id, Model model){
        model.addAttribute("authordto", new AuthorDto(id));
        return "save_author";
    }

    @GetMapping(path = "/show/{id}", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String showAuthor(@PathVariable("id") Long id){
        return authorService.getAuthorById(id).toString();
    }

    @GetMapping("/read")
    @ResponseBody
    public String readAllAuthors(){
        StringBuffer stringBuffer = new StringBuffer();
        authorService.getAllAuthors().forEach(authorDto -> stringBuffer.append(authorDto.toString()).append("<br>"));
        return stringBuffer.toString();
    }

    @GetMapping("/delete/{id}")
    public void deleteAuthor(@PathVariable("id") Long id){
        authorService.deleteAuthor(id);
    }

}
