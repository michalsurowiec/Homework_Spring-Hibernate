package michalsurowiec.service;

import michalsurowiec.dto.AuthorDto;
import michalsurowiec.entity.Article;
import michalsurowiec.entity.Author;
import michalsurowiec.repository.ArticleRepository;
import michalsurowiec.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
@Transactional
public class AuthorService {

    private AuthorRepository authorRepository;
    private ArticleRepository articleRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository, ArticleRepository articleRepository) {
        this.authorRepository = authorRepository;
        this.articleRepository = articleRepository;
    }

    public AuthorDto getAuthorById(Long id){
        Author author = authorRepository.findById(id);
        return new AuthorDto(author);
    }

    public List<AuthorDto> getAllAuthors(){
        List <Author> authorList = authorRepository.findAll();
        List<AuthorDto> authorDtoList = new ArrayList<>();
        for(Author eachAuthor : authorList){
            authorDtoList.add(new AuthorDto(eachAuthor));
        }
        return authorDtoList;
    }

    public void deleteAuthor(Long id){
        Author author = authorRepository.findById(id);
        List<Article> articleList = articleRepository.findAllByAuthor(author);
        articleList.forEach(article -> article.setAuthor(null));
        articleRepository.save(articleList);
        authorRepository.delete(author);
    }
}
