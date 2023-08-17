package likelion.hackathon.BradingHelper.DataCollection.Dao;

import likelion.hackathon.BradingHelper.DataCollection.Dto.CardDto;
import likelion.hackathon.BradingHelper.DataCollection.Dto.DescriptionDto;
import likelion.hackathon.BradingHelper.DataCollection.Entity.Card;
import likelion.hackathon.BradingHelper.DataCollection.Entity.Description;
import likelion.hackathon.BradingHelper.DataCollection.Entity.UserAccount;
import likelion.hackathon.BradingHelper.DataCollection.Repository.CardRepository;
import likelion.hackathon.BradingHelper.DataCollection.Repository.UserAccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class CardDao {
    private final UserAccountRepository userAccountRepository;
    private final CardRepository cardRepository;

    public Long create(CardDto cardDto) {
        Optional<UserAccount> userAccount = userAccountRepository.findById(cardDto.getUserId());

        return userAccount.map(account -> {
            DescriptionDto descriptionDto = cardDto.getDescription();
            Description description = Description.builder()
                    .id(descriptionDto.getId())
                    .productName(descriptionDto.getProductName())
                    .introduction(descriptionDto.getIntroduction())
                    .featureFirst(descriptionDto.getFeatureFirst())
                    .featureDescription1(descriptionDto.getFeatureDescription1())
                    .featureSecond(descriptionDto.getFeatureSecond())
                    .featureDescription2(descriptionDto.getFeatureDescription2())
                    .featureThird(descriptionDto.getFeatureThird())
                    .featureDescription3(descriptionDto.getFeatureDescription3())
                    .promotion(descriptionDto.getPromotion())
                    .build();

            Card card = Card.builder()
                    .userAccount(account)
                    .logoUrl1(cardDto.getLogoUrl1())
                    .logoUrl2(cardDto.getLogoUrl2())
                    .description(description)
                    .imagePath(cardDto.getImagePath())
                    .build();

            cardRepository.save(card);
            return card.getId();
        }).orElse(null);
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
        Optional<UserAccount> userAccountOptional = userAccountRepository.findById(userId);

        return userAccountOptional.map(userAccount -> userAccount.getCardList().stream()
                .map(CardDto::of)
                .collect(Collectors.toList())
        ).orElse(null);
    }

    public Long update(Long userId, Long cardId, CardDto cardDto) {
        Optional<UserAccount> userAccountOptional = userAccountRepository.findById(userId);
        Optional<Card> cardOptional = cardRepository.findById(cardId);

        if (userAccountOptional.isEmpty() || cardOptional.isEmpty()) {
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
        if (userAccountRepository.findById(userId).isEmpty()
                || cardRepository.findById(cardId).isEmpty()) {
            return;
        }

        cardRepository.deleteById(cardId);
    }
}
