package likelion.hackathon.BradingHelper.DataCollection.Entity;

import likelion.hackathon.BradingHelper.DataCollection.Dto.CardDto;
import likelion.hackathon.BradingHelper.DataCollection.Dto.UserAccountDto;
import lombok.*;

import javax.persistence.*;
import java.util.Iterator;
import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "userAccounts")
public class UserAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @OneToMany(mappedBy = "userAccount", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Card> cardList;

    @Builder
    public UserAccount(Long id, String name, String email, List<Card> cardList) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.cardList = cardList;
    }

    public void updateFromDto(UserAccountDto userAccountDto) {
        if (userAccountDto.getName() != null) {
            this.name = userAccountDto.getName();
        } if (userAccountDto.getEmail() != null) {
            this.email = userAccountDto.getEmail();
        } if (userAccountDto.getCardList() != null) {
            Iterator<CardDto> cardDtoIterator = userAccountDto.getCardList().iterator();
        }
    }
}
