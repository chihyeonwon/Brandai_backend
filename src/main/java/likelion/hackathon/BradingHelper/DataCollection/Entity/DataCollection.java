package likelion.hackathon.BradingHelper.DataCollection.Entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "data_collection")
public class DataCollection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "agreement")
    private Boolean agreement;

    @Column(name = "age_range")
    private int ageRange;

    @Builder
    public DataCollection(Long id, Boolean agreement, int age_range) {
        this.id = id;
        this.agreement = agreement;
        this.ageRange = age_range;
    }
}
