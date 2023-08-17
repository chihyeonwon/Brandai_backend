package likelion.hackathon.BradingHelper.ApiAccess.Description;

import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
public class DescriptionTemplate {
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
    public DescriptionTemplate(String productName, String introduction,
                               String featureFirst, String featureDescription1,
                               String featureSecond, String featureDescription2,
                               String featureThird, String featureDescription3,
                               String promotion) {
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