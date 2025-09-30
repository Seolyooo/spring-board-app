package kr.co.sboard.dto;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ArticleDTO {

    private int ano;

    @Builder.Default
    private String cate = "free";

    private String title;
    private String content;
    private int comment_cnt;
    private int file_cnt;
    private int hit_cnt;
    private String writer;
    private String reg_ip;
    private String wdate;

    public String getWdate(){
        return wdate.substring(2,16).replace("T"," ");
    }
    // 업로드 파일 객체
    private MultipartFile file1;
    private MultipartFile file2;

    public List<MultipartFile> getFiles() {
        return List.of(file1, file2);
    }

    //추가필드
    private String nick;

}