package kr.kro.teamstudy.wordenglishshare.controller;

import kr.kro.teamstudy.wordenglishshare.controller.dto.SampleRequest;
import kr.kro.teamstudy.wordenglishshare.controller.dto.SampleResponse;
import kr.kro.teamstudy.wordenglishshare.service.SampleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RequiredArgsConstructor
@RequestMapping("/api/v1/samples")
@RestController
public class SampleController {

	private final SampleService sampleService;

	@GetMapping("/welcome")
	public String welcome() {
		return "welcome~";
	}

	@PostMapping
	public ResponseEntity<Void> registerSample(@RequestBody SampleRequest sampleRequest) {
		var response = sampleService.insertSample(sampleRequest);
		return ResponseEntity.created(URI.create("/api/v1/samples/" + response.getId())).build();
	}

	@GetMapping("/{sampleId}")
	public ResponseEntity<SampleResponse> searchOne(@PathVariable Long sampleId) {
		var response = sampleService.selectOneById(sampleId);
		return ResponseEntity.ok(response);
	}

}
