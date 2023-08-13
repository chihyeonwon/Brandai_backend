package likelion.hackathon.BradingHelper.DataCollection.Service;

import likelion.hackathon.BradingHelper.DataCollection.Dto.DataCollectionDto;
import likelion.hackathon.BradingHelper.DataCollection.Entity.DataCollection;
import likelion.hackathon.BradingHelper.DataCollection.Repository.DataCollectionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class DataCollectionService {
    private final DataCollectionRepository dataCollectionRepository;

    @Transactional
    public Long createData(DataCollectionDto dataCollectionDto) {
        DataCollection dataCollection = DataCollection.builder()
                .agreement(dataCollectionDto.getAgreement())
                .age_range(dataCollectionDto.getAgeRange())
                .build();

        dataCollectionRepository.save(dataCollection);

        return dataCollection.getId();
    }
}
