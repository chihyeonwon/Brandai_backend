package likelion.hackathon.BradingHelper.DataCollection.Dao;

import likelion.hackathon.BradingHelper.DataCollection.Dto.CardDto;
import likelion.hackathon.BradingHelper.DataCollection.Entity.Card;
import likelion.hackathon.BradingHelper.DataCollection.Entity.UserAccount;
import likelion.hackathon.BradingHelper.DataCollection.Repository.CardRepository;
import likelion.hackathon.BradingHelper.DataCollection.Repository.UserAccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class CardDao {
    private final UserAccountRepository userAccountRepository;
    private final CardRepository cardRepository;

    public Long create(CardDto cardDto) {
        Optional<UserAccount> userAccount = userAccountRepository.findById(cardDto.getUserId());

        if (userAccount.isEmpty()) { // If you try to create a card for a non-existent user
            return null;
        }

        Card card = Card.builder()
                .id(cardDto.getId())
                .logoUrl1(cardDto.getLogoUrl1())
                .logoUrl2(cardDto.getLogoUrl2())
                .description(cardDto.getDescription())
                .userAccount(userAccount.get())
                .build();

        cardRepository.save(card);
        return card.getId();
    }

    public CardDto read(Long cardId) {
        Optional<Card> cardOptional = cardRepository.findById(cardId);

        if (cardOptional.isEmpty()) {
            return null;
        }

        Card targetAccount = cardOptional.get(); // target Card

        return CardDto.of(targetAccount); // Card -> CardDto
    }

    public List<CardDto> readAllByUserId(Long userId) {
        Optional<UserAccount> userAccountOptional = userAccountRepository.findById(userId); // Find UserAccount by userId

        if (userAccountOptional.isEmpty()) {
            return null;
        }

        Iterator<Card> cardIterator = userAccountOptional.get().getCardList().iterator(); // Find CardList by UserAccount
        List<CardDto> cardDtoList = new ArrayList<>();

        while (cardIterator.hasNext()) {
            Card card = cardIterator.next();
            cardDtoList.add(CardDto.of(card));
        }

        return cardDtoList;
    }

    public Long update(Long userId, Long cardId, CardDto cardDto) {
        Optional<UserAccount> userAccountOptional = userAccountRepository.findById(userId);

        if (userAccountOptional.isEmpty()) {
            return null;
        }

        Optional<Card> cardOptional = cardRepository.findById(cardId);

        if (cardOptional.isEmpty()) {
            return null;
        }

        Card targetCard = cardOptional.get();
        targetCard.updateFromDto(cardDto);

        if (cardDto.getUserId() != null) {
            Optional<UserAccount> userAccount = userAccountRepository.findById(cardDto.getUserId());
            userAccount.ifPresent(targetCard::setUserAccount);
        }

        cardRepository.save(targetCard);

        return targetCard.getId();
    }

    public void delete(Long userId, Long cardId) {
        if (userAccountRepository.findById(userId).isEmpty()) {
            return;
        }

        if (cardRepository.findById(cardId).isEmpty()) {
            return;
        }

        cardRepository.deleteById(cardId);
    }
}
