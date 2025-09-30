package kr.co.sboard.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FileDTO {

    private int fno;
    private int ano;
    private String oname;
    private String sname;
    private int download;
    private String rdate;

}