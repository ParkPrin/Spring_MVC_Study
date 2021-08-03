package hello.springmvc.basic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogTestController {

	private final Logger log  = LoggerFactory.getLogger(getClass());

	/**
	 * log의 5단계
	 * trace: 로컬에서 특정 변수를 파악할 때 주로 사용
	 * debug: 디버깅 단계에서 변수를 확인할 때 사용
	 * info: 로그에 남겨야 하는 중요한 내용일 때 명시
	 * warn: 특정 경고적인 메세지를 남길때 사용
	 * error: 에러 메세지에서 사용함
	 *
	 * 일반적으로 info, warn, error가 로그에 남는다.
	 * 단계를 trace부터 하면 5단계가 나온다.
	 *
	 * @return
	 */

	@RequestMapping("log-test")
	public String logTest() {
		String name = "Spring";

		log.trace("trace log={}", name);
		log.debug("debug log={}", name);
		log.info("info log={}", name);
		log.warn("warn log={}", name);
		log.error("error log={}", name);

		// 로그를 사용하지 않아도 a+b 개산 로직이 먼저 실행됨, 이런 방식으로 사용하면 X
		//log.debug("String concat log=" + name);

		return "ok";


	}
}
