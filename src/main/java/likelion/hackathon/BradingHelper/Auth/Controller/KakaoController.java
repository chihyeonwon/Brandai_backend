package likelion.hackathon.BradingHelper.Auth.Controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import likelion.hackathon.BradingHelper.Auth.Service.KakaoService;
import likelion.hackathon.BradingHelper.DataCollection.Dto.UserAccountDto;
import likelion.hackathon.BradingHelper.DataCollection.Service.UserAccountService;
import lombok.RequiredArgsConstructor;
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
    private final KakaoService kakaoService;
    private final UserAccountService userAccountService;

    @GetMapping("/kakao")
    @Operation(summary = "카카오톡 회원가입 및 로그인 기능입니다.", description = "인가코드를 적절히 추가하여 Get요청 해주세요.")
    public ResponseEntity<Map<String, String>> register(
            @RequestParam(required = true) String code
            ) {

        Map<String, Object> tokenPayLoad = kakaoService.getKakaoToken(code);
        Map<String, String> token = new HashMap<>();
        token.put("token", (String) tokenPayLoad.get("access_token"));

        Map<String, String> userData = kakaoService.getKakaoUserData(token.get("token"));

        String name = userData.get("name");

        if (userAccountService.readAccountByName(name) == null) {
            userAccountService.createAccount(UserAccountDto.builder()
                    .name(userData.get("name"))
                    .email(userData.get("email"))
                    .cardList(new ArrayList<>())
                    .build());
        }

        return ResponseEntity.ok(token);
    }
}
