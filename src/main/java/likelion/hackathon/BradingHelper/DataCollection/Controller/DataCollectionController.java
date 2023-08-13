package likelion.hackathon.BradingHelper.DataCollection.Controller;

import likelion.hackathon.BradingHelper.DataCollection.Dto.DataCollectionDto;
import likelion.hackathon.BradingHelper.DataCollection.Service.DataCollectionService;
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
public class DataCollectionController {
    private final DataCollectionService dataCollectionService;

    @PostMapping
    public ResponseEntity<Map<String, Long>> createData(@RequestBody DataCollectionDto dataCollectionDto) {
        Long row = dataCollectionService.createData(dataCollectionDto);
        Map<String, Long> response = new HashMap<>();
        response.put("Id", row);
        return ResponseEntity.ok().body(response);
    }
}
