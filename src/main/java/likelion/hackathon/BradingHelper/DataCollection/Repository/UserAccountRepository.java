package likelion.hackathon.BradingHelper.DataCollection.Repository;

import likelion.hackathon.BradingHelper.DataCollection.Entity.UserAccount;
import org.springframework.data.repository.CrudRepository;

public interface UserAccountRepository extends CrudRepository<UserAccount, Long> {
}
