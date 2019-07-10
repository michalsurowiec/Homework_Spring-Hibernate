package michalsurowiec.controller;

import michalsurowiec.dao.ArticleDao;
import michalsurowiec.dao.AuthorDao;
import michalsurowiec.dao.CategoryDao;
import michalsurowiec.dto.CategoryDto;
import michalsurowiec.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/category")
public class CategoryController {

    ArticleDao articleDao;
    AuthorDao authorDao;
    CategoryDao categoryDao;

    @Autowired
    public CategoryController(ArticleDao articleDao, AuthorDao authorDao, CategoryDao categoryDao){
        this.articleDao = articleDao;
        this.authorDao = authorDao;
        this.categoryDao = categoryDao;
    }

    @GetMapping("/create")
    public String createCategory(Model model){
        model.addAttribute("categorydto", new CategoryDto());
        return "create_category";
    }

    @PostMapping("/save")
    public void saveCategory(@ModelAttribute CategoryDto categoryDto){
        Category category = new Category();
        category.setDescription(categoryDto.getDescription());
        category.setName(categoryDto.getName());
        if (categoryDto.getId() != null) {
            category.setId(categoryDto.getId());
            categoryDao.update(category);
        } else {
            categoryDao.create(category);
        }

    }

    @GetMapping("/update/{id}")
    public String updateCategory(@PathVariable("id") long id, Model model){
        model.addAttribute("categorydto", new CategoryDto(id));
        return "create_category";
    }

    //Problem z delete - powiązane rekordy
//    @GetMapping("/delete/{id}")
//    public void deleteCategory(@PathVariable("id") long id){
//        categoryDao.delete(categoryDao.readById(id));
//    }

    //Problem z read - lazyException
//    @GetMapping("/read")
//    @ResponseBody
//    public String readCategory(){
//        StringBuffer stringBuffer = new StringBuffer();
//        Hibernate.initialize(new Category().getArticleSet());
//        categoryDao.readAll().stream().forEach(category -> stringBuffer.append(category.toString()).append("<br>"));
//        return stringBuffer.toString();
//    }

}
