package likelion.hackathon.BradingHelper.Auth.Controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import likelion.hackathon.BradingHelper.Auth.Service.KakaoService;
import likelion.hackathon.BradingHelper.DataCollection.Dto.UserAccountDto;
import likelion.hackathon.BradingHelper.DataCollection.Service.UserAccountService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/dai/auth")
@RequiredArgsConstructor
@Tag(name = "카카오톡 OAuth 회원기능")
public class KakaoController {
    private static final Logger logger = LoggerFactory.getLogger(KakaoController.class);
    private final KakaoService kakaoService;
    private final UserAccountService userAccountService;

    @GetMapping("/kakao")
    @Operation(summary = "카카오톡 회원가입 및 로그인 기능입니다.", description = "인가코드를 적절히 추가하여 Get요청 해주세요.")
    public ResponseEntity<?> registerLogin(
            @RequestParam(required = true) String code
            ) {
        try {
            String token = kakaoService.getKakaoToken(code);

            if (token == null) {
                logger.info("Invalid token");
                return ResponseEntity
                        .status(HttpStatus.UNAUTHORIZED)
                        .body("Invalid token");
            }

            Map<String, String> userData = kakaoService.getKakaoUserData(token);
            if (userData == null) {
                logger.info("Failed to fetch user data");
                return ResponseEntity
                        .status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body("Failed to fetch user data");
            }

            String name = userData.get("name");

            if (userAccountService.readAccountByName(name) == null) {
                userAccountService.createAccount(UserAccountDto.builder()
                        .name(userData.get("name"))
                        .email(userData.get("email"))
                        .cardList(new ArrayList<>())
                        .build());
            }

            Map<String, String> tokenMap = new HashMap<>();
            tokenMap.put("token", token);

            return ResponseEntity.ok(tokenMap);
        } catch (Exception e) {
            logger.info("[ KakaoController Error ] " + e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred");
        }
    }
}
