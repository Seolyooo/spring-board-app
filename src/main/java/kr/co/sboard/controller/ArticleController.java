package kr.co.sboard.controller;

import jakarta.servlet.http.HttpServletRequest;
import kr.co.sboard.dto.ArticleDTO;
import kr.co.sboard.dto.FileDTO;
import kr.co.sboard.dto.PageRequestDTO;
import kr.co.sboard.dto.PageResponseDTO;
import kr.co.sboard.service.ArticleService;
import kr.co.sboard.service.FileService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Controller
public class ArticleController {

    private final ArticleService articleService;
    private final FileService fileService;

    @GetMapping("/article/list")
    public String list(Model model, PageRequestDTO pageRequestDTO){

        PageResponseDTO pageResponseDTO = articleService.getArticleAll(pageRequestDTO);

        model.addAttribute(pageResponseDTO);

        return "article/list";
    }

    @GetMapping("/article/modify")
    public String modify(){
        return "article/modify";
    }

    @GetMapping("/article/search")
    public String searchList(PageRequestDTO pageRequestDTO, Model model){

        log.info("pageRequestDTO = {}", pageRequestDTO);

        PageResponseDTO pageResponseDTO = articleService.getArticleAll(pageRequestDTO);
        model.addAttribute(pageResponseDTO);

        return "article/searchList";
    }

    @GetMapping("/article/view")
    public String view(){
        return "article/view";
    }

    @GetMapping("/article/write")
    public String write(){
        return "article/write";
    }

    @PostMapping("/article/write")
    public String write(ArticleDTO articleDTO, HttpServletRequest request){

        String regip = request.getRemoteAddr();
        articleDTO.setReg_ip(regip);
        log.info("articleDTO = {}", articleDTO);

        // 파일 업로드
        List<FileDTO> fileDTOList = fileService.upload(articleDTO);

        // 글 저장
        int fileCnt = fileDTOList.size();
        articleDTO.setFile_cnt(fileCnt);
        int ano = articleService.save(articleDTO);

        // 파일 저장
        for(FileDTO fileDTO : fileDTOList){

            fileDTO.setAno(ano);
            fileService.save(fileDTO);
        }

        return "redirect:/article/list";
    }


}