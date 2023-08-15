package likelion.hackathon.BradingHelper.DataCollection.Dao;

import likelion.hackathon.BradingHelper.DataCollection.Dto.UserAccountDto;
import likelion.hackathon.BradingHelper.DataCollection.Entity.UserAccount;
import likelion.hackathon.BradingHelper.DataCollection.Repository.UserAccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserAccountDao {
    private final UserAccountRepository userAccountRepository;

    public Long create(UserAccountDto userAccountDto) {

        UserAccount userAccount = UserAccount.builder()
                .name(userAccountDto.getName())
                .email(userAccountDto.getEmail())
                .cardList(new ArrayList<>())
                .build();
        userAccountRepository.save(userAccount);

        return userAccount.getId();
    }

    public UserAccountDto read(Long userId) {
        Optional<UserAccount> targetAccountOptional = userAccountRepository.findById(userId);

        if (targetAccountOptional.isEmpty()) {
            return null;
        }

        UserAccount targetAccount = targetAccountOptional.get(); // target Account

        return UserAccountDto.of(targetAccount); // UserAccount -> UserAccountDto
    }

    public List<UserAccountDto> readAll() {
        Iterator<UserAccount> userAccountIterable = userAccountRepository.findAll().iterator();
        
        List<UserAccountDto> userAccountDtoList = new ArrayList<>(); // Setting Return Value

        while (userAccountIterable.hasNext()) {
            UserAccount userAccount = userAccountIterable.next();
            userAccountDtoList.add(UserAccountDto.of(userAccount)); // UserAccount -> UserAccountDto
        }

        return userAccountDtoList;

    }

    public Long update(Long userId, UserAccountDto userAccountDto) {
        Optional<UserAccount> userAccountOptional = userAccountRepository.findById(userId);

        if (userAccountOptional.isEmpty()) {
            return null;
        }

        UserAccount userAccount = userAccountOptional.get();
        userAccount.updateFromDto(userAccountDto); // name과 Email number만 수정가능

        userAccountRepository.save(userAccount);

        return userAccount.getId();
    }

    public void delete(Long userId) {
        userAccountRepository.deleteById(userId);
    }

    public UserAccountDto readByName(String name) {
        Optional<UserAccount> targetAccountOptional = userAccountRepository.findByName(name);

        if (targetAccountOptional.isEmpty()) {
            return null;
        }

        UserAccount targetAccount = targetAccountOptional.get(); // target Account

        return UserAccountDto.of(targetAccount); // UserAccount -> UserAccountDto
    }
}
