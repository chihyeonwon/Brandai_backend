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

    @Column(name = "phoneNumber")
    private String phoneNumber;

    @OneToMany(mappedBy = "userAccount", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Card> cardList;

    @Builder
    public UserAccount(Long id, String name, String phoneNumber, List<Card> cardList) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.cardList = cardList;
    }

    public void updateFromDto(UserAccountDto userAccountDto) {
        if (userAccountDto.getName() != null) {
            this.name = userAccountDto.getName();
        } if (userAccountDto.getPhoneNumber() != null) {
            this.phoneNumber = userAccountDto.getPhoneNumber();
        } if (userAccountDto.getCardList() != null) {
            Iterator<CardDto> cardDtoIterator = userAccountDto.getCardList().iterator();
        }
    }
}
