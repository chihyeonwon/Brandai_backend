package likelion.hackathon.BradingHelper.DataCollection.Entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
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
}
