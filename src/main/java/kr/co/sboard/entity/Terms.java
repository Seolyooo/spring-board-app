package kr.co.sboard.entity;

import jakarta.persistence.*;
import kr.co.sboard.dto.TermsDTO;
import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name="SB_TERMS")
public class Terms {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int no;
    private String terms;
    private String privacy;

    public TermsDTO toDTO() {
        return TermsDTO.builder()
                .no(no)
                .terms(terms)
                .privacy(privacy)
                .build();
    }
}
