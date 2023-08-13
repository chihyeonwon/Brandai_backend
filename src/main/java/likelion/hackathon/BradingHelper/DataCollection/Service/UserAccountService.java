package likelion.hackathon.BradingHelper.DataCollection.Service;

import likelion.hackathon.BradingHelper.DataCollection.Dto.UserAccountDto;
import likelion.hackathon.BradingHelper.DataCollection.Entity.UserAccount;
import likelion.hackathon.BradingHelper.DataCollection.Repository.UserAccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserAccountService {
//    private final UserAccountRepository userAccountRepository;

//    @Transactional
//    public Long createData(UserAccountDto userAccountDto) {
//        UserAccount userAccount = UserAccount.builder()
//                .name(userAccountDto.getName())
//                .phoneNumber(userAccountDto.getPhoneNumber())
//                .build();
//
//        userAccountRepository.save(userAccount);
//
//        return userAccount.getId();
//    }
//
//    @Transactional(readOnly = true)
//    public UserAccountDto getUserAccountById(Long userId) {
//        Optional<UserAccount> userAccountOptional = userAccountRepository.findById(userId);
//
//        if (userAccountOptional.isPresent()) {
//            UserAccount userAccount = userAccountOptional.get();
//
//            UserAccountDto userAccountDto = new UserAccountDto();
//
//            userAccountDto.setId(userAccount.getId());
//            userAccountDto.setName(userAccount.getName());
//            userAccountDto.setPhoneNumber(userAccount.getPhoneNumber());
//            return userAccountDto;
//        }
//        return null; // 해당 ID에 해당하는 사용자 계정이 없을 경우에 대한 처리 추가 필요
//    }
//
//    @Transactional
//    public void updateUserData(Long userId, UserAccountDto userAccountDto) {
//        Optional<UserAccount> userAccountOptional = userAccountRepository.findById(userId);
//
//        if (userAccountOptional.isPresent()) {
//            UserAccount userAccount = UserAccount.builder()
//                    .id(userAccountDto.getId())
//                    .name(userAccountDto.getName())
//                    .phoneNumber(userAccountDto.getPhoneNumber())
//                    .build();
//            userAccountRepository.save(userAccount);
//        }
//    }
//
//    @Transactional
//    public void deleteData(Long userId) {
//        userAccountRepository.deleteById(userId);
//    }
}
