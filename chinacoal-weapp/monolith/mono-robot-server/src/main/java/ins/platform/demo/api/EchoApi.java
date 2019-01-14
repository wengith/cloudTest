package ins.platform.demo.api;

import ins.framework.common.ResultPage;
import ins.framework.web.ApiResponse;
import ins.platform.demo.service.EchoService;
import ins.platform.demo.vo.EchoVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * 示例用的EchoService实现
 *
 */
@RestController
@RequestMapping("/demo/echo")
public class EchoApi {
	@Autowired
	private EchoService echoService;

	@ApiOperation(value = "传入对象，返回对象")
	@PostMapping(value = "/echoObjectByObject")
	public ApiResponse<EchoVo> echoObjectByObject(@RequestBody EchoVo echo) {
		EchoVo vo = echoService.echoObjectByObject(echo);
		return new ApiResponse<>(vo);
	}

	@GetMapping("/echoStringInSession")
	public ApiResponse<String> echoStringInSession(HttpServletRequest req) {
		// 从Session获取信息
		String echoString = (String) req.getSession().getAttribute("echoString");
		echoString += ".session MaxInactiveInterval" + req.getSession().getMaxInactiveInterval();
		return new ApiResponse<>(echoString);
	}

	@ApiOperation(value = "传入String，返回String")
	@GetMapping(value = "/echoStringByString/{value}")
	public ApiResponse<String> echoStringByString(HttpServletRequest req, @PathVariable(value = "value") String value) {
		String str = echoService.echoStringByString(value);
		// 往Session中存入内容，在echoStringInSession可以获取
		req.getSession().setAttribute("echoString", str);
		// 演示TraceLog用
		for (int i = 0; i < 3; i++) {
			echoService.echoStringByString(value);
		}
		return new ApiResponse<>(str);
	}

	@ApiOperation(value = "传入String，返回对象")
	@GetMapping(value = "/echoObjectByString/{value}")
	public ApiResponse<EchoVo> echoObjectByString(@PathVariable(value = "value") String value) {
		EchoVo vo = echoService.echoObjectByString(value);
		return new ApiResponse<>(vo);
	}

	@ApiOperation(value = "传入对象，返回String")
	@PostMapping(value = "/echoStringByObject")
	public ApiResponse<String> echoStringByObject(@RequestBody EchoVo echo) {
		String str = echoService.echoStringByObject(echo);
		return new ApiResponse<>(str);
	}

	@ApiOperation(value = "传入String和Date，返回String")
	@GetMapping(value = "/echoStringByStringAndDate")
	public ApiResponse<String> echoStringByStringAndDate(@RequestParam(name = "value") String value,
			@RequestParam(name = "date") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date date) {
		String str = echoService.echoStringByStringAndDate(value, date);
		return new ApiResponse<>(str);
	}

	@ApiOperation(value = "分页查询")
	@GetMapping(value = "/search")
	public ApiResponse<ResultPage<EchoVo>> search(@RequestParam(name = "_pageNo", defaultValue = "1") int pageNo,
			@RequestParam(name = "_pageSize", defaultValue = "10") int pageSize) {
		ResultPage<EchoVo> result = echoService.search(pageNo, pageSize);
		return new ApiResponse<>(result);
	}
}
