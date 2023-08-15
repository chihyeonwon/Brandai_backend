package likelion.hackathon.BradingHelper.DataCollection.Controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import likelion.hackathon.BradingHelper.DataCollection.Dto.UserAccountDto;
import likelion.hackathon.BradingHelper.DataCollection.Service.UserAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/dai/db/account")
@Tag(name = "회원 기능 Api")
public class UserAccountController {
    private final UserAccountService userAccountService;

    // Create
    @Operation(summary = "계정 생성", description = "계정을 생성합니다.")
    @PostMapping
    public ResponseEntity<Map<String, Long>> createAccount(@RequestBody UserAccountDto userAccountDto) {
        Long row = userAccountService.createAccount(userAccountDto);

        Map<String, Long> response = new HashMap<>();
        response.put("userId", row);

        return ResponseEntity.ok().body(response);
    }

    // Read
    @Operation(summary = "계정 정보 가져오기", description = "계정 정보를 가져옵니다.")
    @GetMapping("{userId}")
    public ResponseEntity<UserAccountDto> readAccount(@PathVariable("userId") Long id) {
        UserAccountDto userAccountDto = userAccountService.readAccount(id);

        if (userAccountDto == null){
            return ResponseEntity.unprocessableEntity().body(null);
        }

        return ResponseEntity.ok(userAccountDto);
    }

    @Operation(summary = "모든 계정 정보 가져오기", description = "모든 계정의 계정 정보를 가져옵니다.")
    @GetMapping
    public ResponseEntity<List<UserAccountDto>> readAccountAll() {
        List<UserAccountDto> userAccountDtoList = userAccountService.readAccountAll();

        return ResponseEntity.ok(userAccountDtoList);
    }

    // Update
    @Operation(summary = "계정 업데이트", description = "계정 정보를 업데이트 합니다.")
    @PutMapping("{userId}")
    public ResponseEntity<Map<String, Long>> updateAccount(
            @PathVariable("userId") Long id,
            @RequestBody UserAccountDto userAccountDto
    ){
        Map<String, Long> response = new HashMap<>();
        response.put("userId", userAccountService.updateAccount(id, userAccountDto));
        return ResponseEntity.ok().body(response);
    }

    // Delete
    @Operation(summary = "계정 삭제", description = "계정을 삭제합니다.")
    @DeleteMapping("{userId}")
    public ResponseEntity<HttpStatus> deleteAccount(@PathVariable("userId") Long id) {
        userAccountService.deleteAccount(id);
        return ResponseEntity.ok().body(HttpStatus.OK);
    }
}
