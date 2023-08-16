package likelion.hackathon.BradingHelper.DataCollection.Dto;

import likelion.hackathon.BradingHelper.DataCollection.Entity.Card;
import likelion.hackathon.BradingHelper.DataCollection.Entity.Description;
import lombok.*;

@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class DescriptionDto {
    private Long id;
    private String productName;
    private String introduction;
    private String featureFirst;
    private String featureDescription1;
    private String featureSecond;
    private String featureDescription2;
    private String featureThird;
    private String featureDescription3;
    private String promotion;

    @Builder
    public DescriptionDto(Long id, String productName, String introduction,
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

    public static DescriptionDto of(Description description) {
        return DescriptionDto.builder()
                .id(description.getId())
                .productName(description.getProductName())
                .introduction(description.getIntroduction())
                .featureFirst(description.getFeatureFirst())
                .featureDescription1(description.getFeatureDescription1())
                .featureSecond(description.getFeatureSecond())
                .featureDescription2(description.getFeatureDescription2())
                .featureThird(description.getFeatureThird())
                .featureDescription3(description.getFeatureDescription3())
                .promotion(description.getPromotion())
                .build();
    }
}
