package likelion.hackathon.BradingHelper.DataCollection.Dto;

import likelion.hackathon.BradingHelper.DataCollection.Entity.Card;
import likelion.hackathon.BradingHelper.DataCollection.Entity.Description;
import lombok.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;

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

    public static CardDto toBase64(CardDto cardDto) { // Path -> base64
        try {
            Path imagePathObject = Paths.get(cardDto.getImagePath());
            byte[] imageBytes = Files.readAllBytes(imagePathObject);
            cardDto.setImagePath(Base64.getEncoder().encodeToString(imageBytes));
        } catch (Exception e) {
            cardDto.setImagePath(null);
        }

        return cardDto;
    }

    public static CardDto toPath(CardDto cardDto, String imagePath) { // base64 -> pasth
        try {
            byte[] imageBytes = Base64.getDecoder().decode(cardDto.getImagePath());
            Path imagePathObject = Paths.get(imagePath);

            if (!Files.exists(imagePathObject)) {
                Files.createFile(imagePathObject);
            }

            Files.write(imagePathObject, imageBytes);
            cardDto.setImagePath(imagePath);
        } catch (Exception e) {
            cardDto.setImagePath(null);
        }

        return cardDto;
    }

}
