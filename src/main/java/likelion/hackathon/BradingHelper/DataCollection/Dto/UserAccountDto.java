package likelion.hackathon.BradingHelper.DataCollection.Dto;

import likelion.hackathon.BradingHelper.DataCollection.Entity.Card;
import likelion.hackathon.BradingHelper.DataCollection.Entity.UserAccount;
import lombok.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserAccountDto {
    private Long id;
    private String name;
    private String email;
    private List<CardDto> cardList;

    @Builder
    public UserAccountDto(Long id, String name, String email, List<CardDto> cardList) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.cardList = cardList;
    }

    public static UserAccountDto of(UserAccount userAccount) {
        Iterator<Card> cardDtoIterator = userAccount.getCardList().iterator();
        List<CardDto> cardDtoList = new ArrayList<>();

        while (cardDtoIterator.hasNext()) {
            Card card = cardDtoIterator.next();
            cardDtoList.add(CardDto.of(card));
        }

        return UserAccountDto.builder()
                .id(userAccount.getId())
                .name(userAccount.getName())
                .email(userAccount.getEmail())
                .cardList(cardDtoList).build();
    }
}
