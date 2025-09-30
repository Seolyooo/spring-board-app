package kr.co.sboard.dto;

import kr.co.sboard.entity.User;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {

    private String usid;
    private String pass;
    private String us_name;
    private String nick;
    private String email;
    private String hp;

    @Builder.Default
    private String us_role ="MEMBER";

    private String zip;
    private String addr1;
    private String addr2;
    private String reg_ip;
    private String reg_date;
    private String leave_date;



}
