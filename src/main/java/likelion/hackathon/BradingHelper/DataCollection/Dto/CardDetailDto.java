package likelion.hackathon.BradingHelper.DataCollection.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CardDetailDto {
    private Long id;
    private String description;
    private String logoUrl1;
    private String logoUrl2;
}
