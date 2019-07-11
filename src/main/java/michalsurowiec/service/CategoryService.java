package michalsurowiec.service;

import michalsurowiec.dto.CategoryDto;
import michalsurowiec.entity.Category;
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

    @Autowired
    public CategoryService (CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    public List<CategoryDto> getAllCategories(){
        List <Category> categoryList = categoryRepository.findAll();
        List<CategoryDto> categoryDtoList = new ArrayList<>();
        for(Category eachCategory : categoryList){
            categoryDtoList.add(new CategoryDto(eachCategory));
        }
        return categoryDtoList;
    }

}
