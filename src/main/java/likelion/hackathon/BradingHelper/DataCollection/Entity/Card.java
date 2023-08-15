package likelion.hackathon.BradingHelper.DataCollection.Entity;

import likelion.hackathon.BradingHelper.DataCollection.Dto.CardDto;
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

    @Column(name = "description")
    private String description;

    @Column(name = "logoUrl1")
    private String logoUrl1;

    @Column(name = "logoUrl2")
    private String logoUrl2;

    @Column(name = "image_path")
    private String imagePath;

    @Builder
    public Card(Long id, UserAccount userAccount, String description, String logoUrl1, String logoUrl2, String imagePath) {
        this.id = id;
        this.userAccount = userAccount;
        this.description = description;
        this.logoUrl1 = logoUrl1;
        this.logoUrl2 = logoUrl2;
        this.imagePath = imagePath;
    }

    public void updateFromDto(CardDto cardDto) {
        if (cardDto.getDescription() != null) {
            this.description = cardDto.getDescription();
        } if (cardDto.getLogoUrl1() != null) {
            this.logoUrl1 = cardDto.getLogoUrl1();
        } if (cardDto.getLogoUrl2() != null) {
            this.logoUrl2 = cardDto.getLogoUrl2();
        } if (cardDto.getImagePath() != null) {
            this.imagePath = cardDto.getImagePath();
        }
    }
}
