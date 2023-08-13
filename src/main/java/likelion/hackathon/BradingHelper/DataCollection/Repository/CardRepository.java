package likelion.hackathon.BradingHelper.DataCollection.Repository;

import likelion.hackathon.BradingHelper.DataCollection.Entity.Card;
import org.springframework.data.repository.CrudRepository;

public interface CardRepository extends CrudRepository<Card, Long> {
}
