package kr.kro.teamstudy.wordenglishshare.controller.dto;

import kr.kro.teamstudy.wordenglishshare.entity.SampleEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class SampleResponse {

	private Long id;

	private String username;

	private String description;

	private LocalDateTime createdAt;

	public static SampleResponse of(SampleEntity sampleEntity) {
		return SampleResponse.builder()
		  .id(sampleEntity.getId())
		  .username(sampleEntity.getUsername())
		  .description(sampleEntity.getDescription())
		  .createdAt(sampleEntity.getCreatedAt())
		  .build();
	}

}
