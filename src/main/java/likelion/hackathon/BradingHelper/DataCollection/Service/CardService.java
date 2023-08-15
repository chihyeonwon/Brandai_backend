package likelion.hackathon.BradingHelper.DataCollection.Service;

import likelion.hackathon.BradingHelper.DataCollection.Dao.CardDao;
import likelion.hackathon.BradingHelper.DataCollection.Dto.CardDto;
import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CardService {
    private final CardDao cardDao;
    private final Environment environment;

    public Long createCard(CardDto cardDto) {
        return cardDao.create(cardDto);
    }

    public CardDto readCard(Long cardId) {
        return cardDao.read(cardId);
    }

    public List<CardDto> readCardAllByUserId(Long userId) {
        return cardDao.readAllByUserId(userId);
    }

    public Long updateCard(Long userId, Long cardId, CardDto cardDto) {
        return cardDao.update(userId, cardId, cardDto);
    }

    public void deleteCard(Long userId, Long cardId) {
        cardDao.delete(userId, cardId);
    }

    public String generateUniqueImagePath() {
        String imageFileName = UUID.randomUUID() + ".png";
        return environment.getProperty("image.upload.directory") + imageFileName;
    }
}
