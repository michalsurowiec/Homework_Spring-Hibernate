package michalsurowiec.controller;

import michalsurowiec.dao.ArticleDao;
import michalsurowiec.dao.AuthorDao;
import michalsurowiec.dao.CategoryDao;
import michalsurowiec.dto.CategoryDto;
import michalsurowiec.entity.Category;
import michalsurowiec.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/category")
public class CategoryController {

    CategoryDao categoryDao;
    CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryDao categoryDao, CategoryService categoryService){
        this.categoryDao = categoryDao;
        this.categoryService = categoryService;
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

    @GetMapping("/delete/{id}")
    public void deleteCategory(@PathVariable("id") long id){
        categoryService.deleteCategory(id);
    }

    @GetMapping("/read")
    @ResponseBody
    public String readCategory(){
        StringBuffer stringBuffer = new StringBuffer();
        categoryService.getAllCategories().forEach(categoryDto -> stringBuffer.append(categoryDto.toString()).append("<br>"));
        return stringBuffer.toString();
    }

}
