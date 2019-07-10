package michalsurowiec.dto;

import michalsurowiec.entity.Author;
import michalsurowiec.entity.Category;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class ArticleDto {

    private Long id;
    private String title;
    private Author author;
    private Set<Category> categorySet = new HashSet<>();
    private String content;
    private LocalDateTime created;
    private LocalDateTime updated;

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

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Set<Category> getCategorySet() {
        return categorySet;
    }

    public void setCategorySet(Set<Category> categorySet) {
        this.categorySet = categorySet;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getUpdated() {
        return updated;
    }

    public void setUpdated(LocalDateTime updated) {
        this.updated = updated;
    }

    public ArticleDto() {
    }

    public ArticleDto(long id, String title, Author author, Set<Category> categorySet, String content, LocalDateTime created, LocalDateTime updated) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.categorySet = categorySet;
        this.content = content;
        this.created = created;
        this.updated = updated;
    }
}
