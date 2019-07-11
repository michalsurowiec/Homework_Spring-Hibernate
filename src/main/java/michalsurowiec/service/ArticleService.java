package michalsurowiec.service;

import michalsurowiec.dto.ArticleDto;
import michalsurowiec.entity.Article;
import michalsurowiec.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ArticleService {

    private ArticleRepository articleRepository;

    @Autowired
    public ArticleService (ArticleRepository articleRepository){
        this.articleRepository = articleRepository;
    }

    public List<ArticleDto> getAllArticles(){
        List<Article> articleList = articleRepository.findAll();
        List<ArticleDto> articleDtoList = new ArrayList<>();
        for(Article eachArticle : articleList){
            articleDtoList.add(new ArticleDto(eachArticle));
        }
        return articleDtoList;
    }

}
