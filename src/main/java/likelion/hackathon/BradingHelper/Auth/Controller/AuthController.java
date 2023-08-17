package likelion.hackathon.BradingHelper.Auth.Controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import likelion.hackathon.BradingHelper.Auth.Service.KakaoService;
import likelion.hackathon.BradingHelper.DataCollection.Dto.CardDto;
import likelion.hackathon.BradingHelper.DataCollection.Dto.UserAccountDto;
import likelion.hackathon.BradingHelper.DataCollection.Service.CardService;
import likelion.hackathon.BradingHelper.DataCollection.Service.UserAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
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
    public ResponseEntity<List<CardDto>> searchCardListByToken(
            @RequestParam(required = true) String token
    ) {
        Map<String, String> userData = kakaoService.getKakaoUserData(token);
        String name = userData.get("name");
        UserAccountDto userAccountDto = userAccountService.readAccountByName(name);

        List<CardDto> cardDtoList = cardService.readCardAllByUserId(userAccountDto.getId());

        return ResponseEntity.ok(cardDtoList);
    }

//    // create
//    @PostMapping("/card")
//    @Operation(summary = "카드 생성", description = "카드를 생성합니다. /dai/auth/card?token=토큰")
//    public ResponseEntity<Map<String, Long>> createCard(
//            @RequestParam(required = true) String token,
//            @RequestBody CardDto cardDto
//    ) {
//        Map<String, String> userData = kakaoService.getKakaoUserData(token);
//        String name = userData.get("name");
//        UserAccountDto userAccountDto = userAccountService.readAccountByName(name);
//
//        cardDto.setUserId(userAccountDto.getId()); // userId 추가
//
//        Long row = cardService.createCard(cardDto);
//
//        Map<String, Long> response = Collections.singletonMap("Id", row);
//
//        return ResponseEntity.ok().body(response);
//    }
    // create
    @PostMapping("/card")
    @Operation(summary = "카드 생성", description = "카드를 생성합니다. /dai/auth/card?token=토큰")
    public ResponseEntity<Map<String, Long>> createCard(
            @RequestParam String token,
            @RequestBody CardDto cardDto
    ) {
        // Check Authentication
        Map<String, String> userData = kakaoService.getKakaoUserData(token);
        String name = userData.get("name");
        UserAccountDto userAccountDto = userAccountService.readAccountByName(name);

        // Successes Authentication
        cardDto.setUserId(userAccountDto.getId()); // userId 추가

        // Create Card
        Long row = cardService.createCard(cardDto);
        Map<String, Long> response = Collections.singletonMap("Id", row);

        return ResponseEntity.ok().body(response);
    }

    // Read
    @Operation(summary = "카드 정보 가져오기", description = "카드 id를 이용해 카드를 가져옵니다. /dai/auth/card/{cardId}")
    @GetMapping("/card/{cardId}")
    public ResponseEntity<CardDto> readCard(@PathVariable("cardId") Long id) {
        CardDto cardDto = cardService.readCard(id);

        return cardDto != null
                ? ResponseEntity.ok(cardDto)
                : ResponseEntity.unprocessableEntity().build();
    }
}
