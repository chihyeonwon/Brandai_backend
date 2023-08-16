package likelion.hackathon.BradingHelper.DataCollection.Entity;

import likelion.hackathon.BradingHelper.DataCollection.Dto.CardDto;
import likelion.hackathon.BradingHelper.DataCollection.Dto.DescriptionDto;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "cards")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cardId")
    private Long id;

    @ManyToOne(
            fetch = FetchType.LAZY,
            targetEntity = UserAccount.class)
    @JoinColumn(name = "userId")
    private UserAccount userAccount;

    @OneToOne(
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JoinColumn(name = "descriptionId")
    private Description description;

    @Column(name = "logoUrl1", length = 1000)
    private String logoUrl1;

    @Column(name = "logoUrl2", length = 1000)
    private String logoUrl2;

    @Column(name = "image_path")
    private String imagePath;

    @Builder
    public Card(Long id, UserAccount userAccount, Description description, String logoUrl1, String logoUrl2, String imagePath) {
        this.id = id;
        this.userAccount = userAccount;
        this.description = description;
        this.logoUrl1 = logoUrl1;
        this.logoUrl2 = logoUrl2;
        this.imagePath = imagePath;
    }

    public void updateFromDto(CardDto cardDto) {
        if (cardDto.getDescription() != null) {
            DescriptionDto descriptionDto = cardDto.getDescription();
            this.description = Description.builder()
                    .id(descriptionDto.getId())
                    .productName(descriptionDto.getProductName())
                    .introduction(descriptionDto.getIntroduction())
                    .featureFirst(descriptionDto.getFeatureFirst())
                    .featureDescription1(descriptionDto.getFeatureDescription1())
                    .featureSecond(descriptionDto.getFeatureSecond())
                    .featureDescription2(descriptionDto.getFeatureDescription2())
                    .featureThird(descriptionDto.getFeatureThird())
                    .featureDescription3(descriptionDto.getFeatureDescription3())
                    .promotion(descriptionDto.getPromotion())
                    .build();
        } if (cardDto.getLogoUrl1() != null) {
            this.logoUrl1 = cardDto.getLogoUrl1();
        } if (cardDto.getLogoUrl2() != null) {
            this.logoUrl2 = cardDto.getLogoUrl2();
        } if (cardDto.getImagePath() != null) {
            this.imagePath = cardDto.getImagePath();
        }
    }
}
