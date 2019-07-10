package michalsurowiec.dto;

import michalsurowiec.entity.Article;

import java.util.HashSet;
import java.util.Set;

public class AuthorDto {

    private Long id;
    private String firstName;
    private String lastName;
    private Set<Article> articleSet = new HashSet<>();

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

    public Set<Article> getArticleSet() {
        return articleSet;
    }

    public void setArticleSet(Set<Article> articleSet) {
        this.articleSet = articleSet;
    }

    public AuthorDto() {
    }

    public AuthorDto(long id, String firstName, String lastName, Set<Article> articleSet) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.articleSet = articleSet;
    }
}
