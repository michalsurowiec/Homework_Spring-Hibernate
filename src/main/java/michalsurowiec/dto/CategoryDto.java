package michalsurowiec.dto;

import michalsurowiec.entity.Article;

import java.util.HashSet;
import java.util.Set;

public class CategoryDto {

    private Long id;
    private String name;
    private String description;
    private Set<Article> articleSet = new HashSet<>();

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

    public Set<Article> getArticleSet() {
        return articleSet;
    }

    public void setArticleSet(Set<Article> articleSet) {
        this.articleSet = articleSet;
    }

    public CategoryDto() {
    }

    public CategoryDto(long id, String name, String description, Set<Article> articleSet) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.articleSet = articleSet;
    }
}
