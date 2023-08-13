package likelion.hackathon.BradingHelper.DataCollection.Controller;

import likelion.hackathon.BradingHelper.DataCollection.Dto.UserAccountDto;
import likelion.hackathon.BradingHelper.DataCollection.Service.UserAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/data")
@RequiredArgsConstructor
public class UserAccountController {
    private final UserAccountService userAccountService;

    @PostMapping
    public ResponseEntity<Map<String, Long>> createUser(@RequestBody UserAccountDto userAccountDto) {
//        Long row = userAccountService.createData(userAccountDto);
        Map<String, Long> response = new HashMap<>();
//        response.put("Id", row);
        response.put("Id", 5L);
        return ResponseEntity.ok().body(response);
    }
}
