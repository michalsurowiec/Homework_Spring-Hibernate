package michalsurowiec.service;

import michalsurowiec.dto.AuthorDto;
import michalsurowiec.entity.Author;
import michalsurowiec.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class AuthorService {

    private AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
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
}
