package likelion.hackathon.BradingHelper.ApiAccess.Interfaces;

import java.util.Map;

public interface DataPreprocessorInterface {
    Map<String, Object> fetchData(String prompt);
}
