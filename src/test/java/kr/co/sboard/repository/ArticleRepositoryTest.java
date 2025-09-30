package kr.co.sboard.repository;

import com.querydsl.core.Tuple;
import kr.co.sboard.dto.PageRequestDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ArticleRepositoryTest {


    @Autowired
    ArticleRepository articleRepository;

    @Test
    void test1(){

        PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
                .build();

        Pageable pageable = pageRequestDTO.getPageable("ano");

        Page<Tuple> pageTuple  = articleRepository.selectArticleAllForList(pageRequestDTO, pageable);

        List<Tuple> tupleList = pageTuple.getContent();

        System.out.println(tupleList);

    }


}