package michalsurowiec.dto;

import michalsurowiec.entity.Article;
import michalsurowiec.entity.Category;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class CategoryDto {

    private Long id;
    private String name;
    private String description;
    private String articleSet;

    public CategoryDto(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "CategoryDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", articleSet=" + articleSet +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getArticleSet() {
        return articleSet;
    }

    public void setArticleSet(String articleSet) {
        this.articleSet = articleSet;
    }

    public CategoryDto() {
    }

    public CategoryDto(Category category) {
        this.id = category.getId();
        this.name = category.getName();
        this.description = category.getDescription();
        this.articleSet = category.getArticleSet()
                .stream()
                .map(Article::getTitle)
                .collect(Collectors.joining(", "));
    }
}
