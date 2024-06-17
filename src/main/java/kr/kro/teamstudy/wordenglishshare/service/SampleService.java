package kr.kro.teamstudy.wordenglishshare.service;

import kr.kro.teamstudy.wordenglishshare.controller.dto.SampleRequest;
import kr.kro.teamstudy.wordenglishshare.controller.dto.SampleResponse;
import kr.kro.teamstudy.wordenglishshare.entity.SampleEntity;
import kr.kro.teamstudy.wordenglishshare.repository.SampleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
public class SampleService {

	private final SampleRepository sampleRepository;

	public SampleResponse insertSample(SampleRequest sampleRequest) {
		SampleEntity newEntity = SampleEntity.createOf(sampleRequest);
		SampleEntity savedEntity = sampleRepository.save(newEntity);
		return SampleResponse.of(savedEntity);
	}

	@Transactional(readOnly = true)
	public SampleResponse selectOneById(Long sampleId) {
		SampleEntity validSample = sampleRepository.findById(sampleId)
		  .orElseThrow(() -> new RuntimeException("Not found sample id : " + sampleId));
		return SampleResponse.of(validSample);
	}

}
