package likelion.hackathon.BradingHelper.DataCollection.Repository;

import likelion.hackathon.BradingHelper.DataCollection.Entity.UserAccount;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserAccountRepository extends CrudRepository<UserAccount, Long> {
    Optional<UserAccount> findByName(String name);
}
