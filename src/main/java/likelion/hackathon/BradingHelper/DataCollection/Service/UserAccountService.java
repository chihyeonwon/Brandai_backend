package likelion.hackathon.BradingHelper.DataCollection.Service;

import likelion.hackathon.BradingHelper.DataCollection.Dao.UserAccountDao;
import likelion.hackathon.BradingHelper.DataCollection.Dto.UserAccountDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserAccountService {
    private final UserAccountDao userAccountDao;

    @Transactional
    public Long createAccount(UserAccountDto userAccountDto) {
        return userAccountDao.create(userAccountDto);
    }

    public UserAccountDto readAccount(Long cardId) {
        return userAccountDao.read(cardId);
    }

    public List<UserAccountDto> readAccountAll() {
        return userAccountDao.readAll();
    }

    @Transactional
    public Long updateAccount(Long cardId, UserAccountDto userAccountDto) {
        return userAccountDao.update(cardId, userAccountDto);
    }

    @Transactional
    public void deleteAccount(Long cardId) {
        userAccountDao.delete(cardId);
    }
}
