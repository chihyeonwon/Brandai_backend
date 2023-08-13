package likelion.hackathon.BradingHelper.DataCollection.Entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "card_details")
public class CardDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cardDetailId")
    private Long id;

    @Column(name = "description")
    private String description;

    @Column(name = "logoUrl1")
    private String logoUrl1;

    @Column(name = "logoUrl2")
    private String logoUrl2;

    @OneToOne
    @JoinColumn(name = "cardId")
    private Card card;

    @Builder
    public CardDetail(Long id, String description, String logoUrl1, String logoUrl2, Card card) {
        this.id = id;
        this.description = description;
        this.logoUrl1 = logoUrl1;
        this.logoUrl2 = logoUrl2;
        this.card = card;
    }
}
