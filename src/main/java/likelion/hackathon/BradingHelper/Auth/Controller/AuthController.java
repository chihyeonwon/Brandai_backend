package likelion.hackathon.BradingHelper.Auth.Controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import likelion.hackathon.BradingHelper.Auth.Service.KakaoService;
import likelion.hackathon.BradingHelper.DataCollection.Dto.CardDto;
import likelion.hackathon.BradingHelper.DataCollection.Dto.UserAccountDto;
import likelion.hackathon.BradingHelper.DataCollection.Entity.UserAccount;
import likelion.hackathon.BradingHelper.DataCollection.Service.CardService;
import likelion.hackathon.BradingHelper.DataCollection.Service.UserAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/dai/auth")
@RequiredArgsConstructor
@Tag(name = "Auth 확인 기능이 구성된 RestApi")
public class AuthController {
    private final KakaoService kakaoService;
    private final UserAccountService userAccountService;
    private final CardService cardService;

    @GetMapping("/searchCard")
    @Operation(summary = "카드 목록을 확인합니다.", description = "카드를 생성합니다. /dai/auth/searchCard?token=토큰")
    public ResponseEntity<?> searchCardListByToken(
            @RequestParam(required = true) String token
    ) {
        Map<String, String> userData = kakaoService.getKakaoUserData(token);

        String name = userData.get("name");
        UserAccountDto userAccountDto = userAccountService.readAccountByName(name);

        if (userAccountDto == null) {
            return ResponseEntity.badRequest().body("Invalid token or Not exist User");
        }
        List<CardDto> cardDtoList = cardService.readCardAllByUserId(userAccountDto.getId());

        return ResponseEntity.ok(cardDtoList);
    }

    // create
    @PostMapping("/card")
    @Operation(summary = "카드 생성", description = "카드를 생성합니다. /dai/auth/card?token=토큰")
    public ResponseEntity<?> createCard(
            @RequestParam(required = true) String token,
            @RequestBody CardDto cardDto
    ) {
        Map<String, String> userData = kakaoService.getKakaoUserData(token);

        String name = userData.get("name");
        UserAccountDto userAccountDto = userAccountService.readAccountByName(name);

        if (userAccountDto == null) {
            return ResponseEntity.badRequest().body("Invalid token or Not exist User");
        }

        cardDto.setId(userAccountDto.getId()); // userId 추가

        CardDto cardDto1 = CardDto.toPath(cardDto, cardService.generateUniqueImagePath()); // base64 -> path

        Long row = cardService.createCard(cardDto1);

        Map<String, Long> response = new HashMap<>();
        response.put("Id", row);

        return ResponseEntity.ok().body(response);

    }

    // Read
    @Operation(summary = "카드 정보 가져오기", description = "카드 id를 이용해 카드를 가져옵니다. /dai/auth/card/{cardId}")
    @GetMapping("/card/{cardId}")
    public ResponseEntity<CardDto> readCard(@PathVariable("cardId") Long id) {
        CardDto cardDto = cardService.readCard(id);

        if (cardDto == null){
            return ResponseEntity.unprocessableEntity().body(null);
        }

        // path -> base64
        CardDto cardDto1 = CardDto.toBase64(cardDto);

        return ResponseEntity.ok(cardDto1);
    }

}
