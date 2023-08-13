package likelion.hackathon.BradingHelper.DataCollection.Entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "cards")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cardId")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "userId")
    private UserAccount userAccount;

    @OneToOne(mappedBy = "card", cascade = CascadeType.ALL, orphanRemoval = true)
    private CardDetail cardDetail;

    @Builder
    public Card(Long id, UserAccount userAccount, CardDetail cardDetail) {
        this.id = id;
        this.userAccount = userAccount;
        this.cardDetail = cardDetail;
    }
}
