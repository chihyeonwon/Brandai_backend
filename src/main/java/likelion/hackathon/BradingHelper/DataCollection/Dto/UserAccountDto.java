package likelion.hackathon.BradingHelper.DataCollection.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserAccountDto {
    private Long id;
    private String name;
    private String phoneNumber;
    private List<CardDto> cardList;
}
