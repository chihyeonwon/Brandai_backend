package likelion.hackathon.BradingHelper.DataCollection.Repository;

import likelion.hackathon.BradingHelper.DataCollection.Entity.DataCollection;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class DataCollectionRepository {
    private final EntityManager em;

    public void save(DataCollection dataCollection) {
        em.persist(dataCollection);
    }
}
