package likelion.hackathon.BradingHelper.DataCollection.Entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "description")
public class Description {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "descriptionId")
    private Long id;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "introduction", length = 1000)
    private String introduction;

    @Column(name = "feature_first", length = 1000)
    private String featureFirst;

    @Column(name = "feature_description_1", length = 1000)
    private String featureDescription1;

    @Column(name = "feature_second", length = 1000)
    private String featureSecond;

    @Column(name = "feature_description_2", length = 1000)
    private String featureDescription2;

    @Column(name = "feature_third", length = 1000)
    private String featureThird;

    @Column(name = "feature_description_3", length = 1000)
    private String featureDescription3;

    @Column(name = "promotion", length = 1000)
    private String promotion;

    @Builder
    public Description(Long id, String productName, String introduction,
                       String featureFirst, String featureDescription1,
                       String featureSecond, String featureDescription2,
                       String featureThird, String featureDescription3,
                       String promotion) {
        this.id = id;
        this.productName = productName;
        this.introduction = introduction;
        this.featureFirst = featureFirst;
        this.featureDescription1 = featureDescription1;
        this.featureSecond = featureSecond;
        this.featureDescription2 = featureDescription2;
        this.featureThird = featureThird;
        this.featureDescription3 = featureDescription3;
        this.promotion = promotion;
    }
}
