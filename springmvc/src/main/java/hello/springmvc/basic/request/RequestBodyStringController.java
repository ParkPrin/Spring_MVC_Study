package hello.springmvc.basic.request;

import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StreamUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
public class RequestBodyStringController {

	@PostMapping("/request-body-string-v1")
	public void requestBodyString(HttpServletRequest request, HttpServletResponse response) throws IOException {
		ServletInputStream inputStream = request.getInputStream();
		String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);

		log.info("messageBody={}", messageBody);
		response.getWriter().write("ok");

	}

	@PostMapping("/request-body-string-v2")
	public void requestBodyStringV2(InputStream inputStream, Writer responseWriter) throws IOException {
		String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
		log.info("messageBody={}", messageBody);
		responseWriter.write("ok");
	}

	/**
	 *
	 * @param httpEntity
	 * @return
	 *
	 * HttpEntity: HTTP header, body 정보를 편하게 조회
	 * - 메시지 바디 정보를 직접조회
	 * - 요청 파라미터를 조회하는 기능과 관계없음
	 *
	 * HttpEntity는 응답에도 사용 가능
	 * - 메시지 바디 정보 직접 반환
	 * - 헤더 정보 포함 가능
	 * - view 조회 X
	 *
	 * HttpEntity를 상송받은 객체
	 * => RequestEntity : HttpMethod, url 정보가 추가, 요청에서 사용
	 * => ResponseEntity: HTTP 상태 코드 설정 가능, 응답에서 사용
	 */

	@PostMapping("/request-body-string-v3")
	public HttpEntity<String> requestBodyStringV3(HttpEntity<String> httpEntity) {
		String messageBody = httpEntity.getBody();
		log.info("messageBody={}", messageBody);

		return new HttpEntity<>("ok");
	}

	@PostMapping("/request-body-string-v4")
	public ResponseEntity<String> requestBodyStringV4(RequestEntity<String> httpEntity) {
		String messageBody = httpEntity.getBody();
		log.info("messageBody={}", messageBody);

		return new ResponseEntity<String>("ok", HttpStatus.CREATED);
	}

	@ResponseBody
	@PostMapping("/request-body-string-v5")
	public String requestBodyStringV5(@RequestBody String messageBody) {
		log.info("messageBody={}", messageBody);
		return "ok";
	}






}
