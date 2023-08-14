package likelion.hackathon.BradingHelper.DataCollection.Controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import likelion.hackathon.BradingHelper.DataCollection.Dto.CardDto;
import likelion.hackathon.BradingHelper.DataCollection.Service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/card")
@Tag(name = "카드 관련 API")
public class CardController {
    private final CardService cardService;


    // Create
    @Operation(summary = "카드 생성", description = "카드를 생성합니다.")
    @PostMapping
    public ResponseEntity<Map<String, Long>> createCard(@RequestBody CardDto cardDto) {
        Long row = cardService.createCard(cardDto);

        Map<String, Long> response = new HashMap<>();
        response.put("Id", row);

        return ResponseEntity.ok().body(response);
    }


    // Read
    @Operation(summary = "카드 정보 가져오기", description = "카드 id를 이용해 카드를 가져옵니다.")
    @GetMapping("{id}")
    public ResponseEntity<CardDto> readCard(@PathVariable Long id) {
        CardDto cardDto = cardService.readCard(id);

        if (cardDto == null){
            return ResponseEntity.unprocessableEntity().body(null);
        }

        return ResponseEntity.ok(cardDto);
    }


    // Read All Card By UserId
    @Operation(summary = "특정 유저의 카드 목록 가져오기", description = "해당 유저의 카드 목록을 가져옵니다.")
    @GetMapping("/{userId}")
    public ResponseEntity<List<CardDto>> readCardAllByUserId(@PathVariable("userId") Long userId) {
        List<CardDto> cardDtoList = cardService.readCardAllByUserId(userId);

        return ResponseEntity.ok(cardDtoList);
    }


    // Update
    @Operation(summary = "카드 업데이트", description = "카드를 업데이트 합니다.")
    @PutMapping("/{userId}/{cardId}")
    public ResponseEntity<Map<String, Long>> updateCard(
            @PathVariable("userId") Long userId,
            @PathVariable("cardId") Long cardId,
            @RequestBody CardDto cardDto
    ){
        Map<String, Long> response = new HashMap<>();
        response.put("boardId", cardService.updateCard(userId, cardId, cardDto));

        return ResponseEntity.ok().body(response);
    }


    // Delete
    @Operation(summary = "카드 삭제", description = "카드를 삭제합니다.")
    @DeleteMapping("/{userId}/{cardId}")
    public ResponseEntity<HttpStatus> deleteCard(
            @PathVariable("userId") Long userId,
            @PathVariable("cardId") Long cardId
    ) {
        cardService.deleteCard(userId, cardId);

        return ResponseEntity.ok().body(HttpStatus.OK);
    }
}
