package michalsurowiec.dto;

import michalsurowiec.entity.Article;
import michalsurowiec.entity.Author;
import michalsurowiec.entity.Category;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class ArticleDto {

    private Long id;
    private String title;
    //Powiązane OneToMany z klasą Author
    private String author;
    //Powiązane ManytoMany z klasą Category
    private String categorySet;
    private Long[] categoryIdTable;
    private String content;
    private String created;
    private String updated;

    public ArticleDto(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ArticleDto{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author=" + author +
                ", categorySet=" + categorySet +
                ", content='" + content + '\'' +
                ", created=" + created +
                ", updated=" + updated +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategorySet() {
        return categorySet;
    }

    public void setCategorySet(String categorySet) {
        this.categorySet = categorySet;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public ArticleDto() {
    }

    public ArticleDto(Article article) {
        this.id = article.getId();
        this.title = article.getTitle();
        this.author = article.getAuthor().getFirstName() + " " + article.getAuthor().getLastName();
        this.categorySet = article.getCategorySet()
                .stream()
                .map(Category::getName)
                .collect(Collectors.joining(", "));
        this.categoryIdTable = article.getCategorySet()
                .stream()
                .map(Category::getId)
                .toArray(Long[]::new);
        this.content = article.getContent();
        this.created = article.getCreated().toString();
        this.updated = article.getUpdated().toString();
    }

    public Long[] getCategoryIdTable() {
        return categoryIdTable;
    }

    public void setCategoryIdTable(Long[] categoryIdTable) {
        this.categoryIdTable = categoryIdTable;
    }
}
