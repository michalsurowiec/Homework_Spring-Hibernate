package michalsurowiec.dto;

import michalsurowiec.entity.Article;
import michalsurowiec.entity.Author;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class AuthorDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String articleSet;

    public AuthorDto(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "AuthorDto{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", articleSet=" + articleSet +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getArticleSet() {
        return articleSet;
    }

    public void setArticleSet(String articleSet) {
        this.articleSet = articleSet;
    }

    public AuthorDto() {
    }

    public AuthorDto(Author author){
        this.id = author.getId();
        this.firstName = author.getFirstName();
        this.lastName = author.getLastName();
        this.articleSet = author.getArticleSet().stream()
                .map(Article::getTitle)
                .collect(Collectors.joining(", "));
    }
}
