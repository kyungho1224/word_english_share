package kr.kro.teamstudy.wordenglishshare.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import kr.kro.teamstudy.wordenglishshare.controller.dto.SampleRequest;
import kr.kro.teamstudy.wordenglishshare.controller.dto.SampleResponse;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "samples")
@Entity
public class SampleEntity extends BaseEntity {

	@Column(name = "username", nullable = false)
	private String username;

	@Column(name = "description", nullable = false)
	private String description;

	@Builder
	public SampleEntity(String username, String description) {
		this.username = username;
		this.description = description;
	}

	public static SampleEntity createOf(SampleRequest sampleRequest) {
		return SampleEntity.builder()
		  .username(sampleRequest.getUsername())
		  .description(sampleRequest.getDescription())
		  .build();
	}

}
