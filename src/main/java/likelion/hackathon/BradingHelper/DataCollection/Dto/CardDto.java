package likelion.hackathon.BradingHelper.DataCollection.Dto;

import likelion.hackathon.BradingHelper.DataCollection.Entity.Card;
import lombok.*;

@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CardDto {
    private Long id;
    private Long userId;
    private DescriptionDto description;
    private String logoUrl1;
    private String logoUrl2;
    private String imagePath;

    @Builder
    public CardDto(Long id, Long userId, DescriptionDto description, String logoUrl1, String logoUrl2, String imagePath) {
        this.id = id;
        this.userId = userId;
        this.description = description;
        this.logoUrl1 = logoUrl1;
        this.logoUrl2 = logoUrl2;
        this.imagePath = imagePath;
    }

    public static CardDto of(Card card) {
        return CardDto.builder()
                .id(card.getId())
                .userId(card.getUserAccount().getId())
                .description(DescriptionDto.of(card.getDescription()))
                .logoUrl1(card.getLogoUrl1())
                .logoUrl2(card.getLogoUrl2())
                .imagePath(card.getImagePath())
                .build();
    }

}
