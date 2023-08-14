package likelion.hackathon.BradingHelper.DataCollection.Service;

import likelion.hackathon.BradingHelper.DataCollection.Dao.CardDao;
import likelion.hackathon.BradingHelper.DataCollection.Dto.CardDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CardService {
    private final CardDao cardDao;

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

}
