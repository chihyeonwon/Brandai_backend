package likelion.hackathon.BradingHelper.DataCollection.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CardDto {
    private Long id;
    private Long userAccountId;
    private CardDetailDto cardDetail;
}
