package ins.platform.robot.api;

import ins.framework.common.ResultPage;
import ins.framework.lang.Strings;
import ins.framework.web.ApiResponse;
import ins.platform.robot.service.DemoRobotService;
import ins.platform.robot.vo.DemoRobotJobVo;
import ins.platform.robot.vo.DemoRobotMainVo;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/robot/demo")
@Slf4j
public class DemoRobotApi {
	private static final int DEC = 10;
	@Autowired
	private DemoRobotService demoRobotService;

	@ApiOperation(value = "创建对象（包含可能的子对象）")
	@PostMapping(value = "/create")
	public ApiResponse<DemoRobotMainVo> create(@RequestBody DemoRobotMainVo vo) {
		DemoRobotMainVo result = demoRobotService.create(vo);
		return new ApiResponse<>(result);
	}

	@ApiOperation(value = "更新对象（包含可能的子对象）")
	@PostMapping(value = "/update")
	public ApiResponse<String> update(@RequestBody DemoRobotMainVo vo) {
		demoRobotService.update(vo);
		return new ApiResponse<>("");
	}

	@ApiOperation(value = "查询对象（包含可能的子对象）")
	@GetMapping(value = "/select/{id}")
	public ApiResponse<DemoRobotMainVo> select(@PathVariable(value = "id") Long id) {
		DemoRobotMainVo result = demoRobotService.selectByPrimaryKey(id);
		return new ApiResponse<>(result);
	}

	@ApiOperation(value = "删除对象（包含可能的子对象）")
	@PostMapping(value = "/delete/{ids}")
	public ApiResponse<String> delete(@PathVariable(value = "ids") String ids) {
		List<String> idStrList = Arrays.asList(Strings.split(ids, ","));
		List<Long> idList = new ArrayList<>(idStrList.size());
		for (String idStr : idStrList) {
			idList.add(Long.valueOf(idStr, DEC));
		}

		demoRobotService.delete(idList);
		return new ApiResponse<>("");
	}

	@ApiOperation(value = "根据生产厂家查找对象（包含可能的子对象）")
	@PostMapping(value = "/selectByManufactureName")
	public ApiResponse<ResultPage<DemoRobotMainVo>> selectByManufactureName(
			@RequestParam(value = "manufactureName") String manufactureName) {
		ResultPage<DemoRobotMainVo> result = demoRobotService.selectByManufactureName(manufactureName);
		return new ApiResponse<>(result);
	}

	@ApiOperation(value = "查找对象（包含可能的子对象）")
	@PostMapping(value = "/search")
	public ApiResponse<ResultPage<DemoRobotMainVo>> search(HttpServletRequest request,
														   @ModelAttribute DemoRobotMainVo demoRobotMainVo) {
		ResultPage<DemoRobotMainVo> result = demoRobotService.findForDataTables(demoRobotMainVo);
		return new ApiResponse<>(result);
	}

	@ApiOperation(value = "创建主对象")
	@PostMapping(value = "/createMain")
	public ApiResponse<DemoRobotMainVo> createMain(@RequestBody DemoRobotMainVo vo) {
		DemoRobotMainVo result = demoRobotService.createMain(vo);
		return new ApiResponse<>(result);
	}

	@ApiOperation(value = "更新主对象")
	@PostMapping(value = "/updateMain")
	public ApiResponse<String> updateMain(@RequestBody DemoRobotMainVo vo) {
		demoRobotService.updateMain(vo);
		return new ApiResponse<>("");
	}

	@ApiOperation(value = "查询主对象")
	@GetMapping(value = "/selectMain/{id}")
	public ApiResponse<DemoRobotMainVo> selectMain(@PathVariable(value = "id") Long id) {
		DemoRobotMainVo result = demoRobotService.selectMainByPrimaryKey(id);
		return new ApiResponse<>(result);
	}

	@ApiOperation(value = "创建子对象")
	@PostMapping(value = "/createJob")
	public ApiResponse<DemoRobotJobVo> createJob(@RequestBody DemoRobotJobVo vo) {
		DemoRobotJobVo result = demoRobotService.createJob(vo);
		return new ApiResponse<>(result);
	}

	@ApiOperation(value = "更新子对象")
	@PostMapping(value = "/updateJob")
	public ApiResponse<String> updateJob(@RequestBody DemoRobotJobVo vo) {
		demoRobotService.updateJob(vo);
		return new ApiResponse<>("");
	}

	@ApiOperation(value = "查询子对象")
	@GetMapping(value = "/selectJob/{id}")
	public ApiResponse<DemoRobotJobVo> selectJob(@PathVariable(value = "id") Long id) {
		DemoRobotJobVo result = demoRobotService.selectJobByPrimaryKey(id);
		return new ApiResponse<>(result);
	}

	@ApiOperation(value = "删除子对象")
	@PostMapping(value = "/deleteJob/{ids}")
	public ApiResponse<String> deleteJob(@PathVariable(value = "ids") String ids) {
		List<String> idStrList = Arrays.asList(Strings.split(ids, ","));
		List<Long> idList = new ArrayList<>(idStrList.size());
		for (String idStr : idStrList) {
			idList.add(Long.valueOf(idStr, DEC));
		}

		demoRobotService.deleteJob(idList);
		return new ApiResponse<>("");
	}

	@ApiOperation(value = "查找子对象")
	@PostMapping(value = "/searchJob")
	public ApiResponse<ResultPage<DemoRobotJobVo>> searchJob(ServletRequest request) {
		ResultPage<DemoRobotJobVo> result = demoRobotService.findJobForDataTables(request.getParameterMap());
		return new ApiResponse<>(result);
	}

	@ApiOperation(value = "上传文件")
	@PostMapping(value = "/file")
	public ApiResponse<String> file(ServletRequest request,
			@RequestParam(value = "file", required = false) MultipartFile image) {
		return new ApiResponse<>(image.getName());
	}

	@ApiOperation(value = "插入Test")
	@GetMapping(value = "/insertTestData/{mainCount}/{jobCount}")
	public ApiResponse<String> insertTestData(@PathVariable(value = "mainCount") int mainCount,
			@PathVariable(value = "jobCount") int jobCount) {
		demoRobotService.insertTestData(mainCount, jobCount);
		return new ApiResponse<>();
	}

	@ApiOperation(value = "插入Test")
	@GetMapping(value = "/transactionTest")
	public ApiResponse<String> transactionTest() {

		log.info("开启第一个查询");
		log.info("结果条数 {} ", demoRobotService.selectByManufactureName("A").getTotalCount());
		log.info("结束第一个查询");

		log.info("开启调用外部接口（模拟用）");
		demoRobotService.longCall();
		log.info("结束调用外部接口（模拟用）");

		log.info("开启第一个事务");
		demoRobotService.insertTestData(1, 1);
		log.info("结束第一个事务");

		log.info("开启第二个查询");
		log.info("结果条数 {} ", demoRobotService.selectByManufactureName("B").getTotalCount());
		log.info("结束第二个查询");

		log.info("开启调用外部接口（模拟用）");
		demoRobotService.longCall();
		log.info("结束调用外部接口（模拟用）");

		log.info("开启第二个事务");
		demoRobotService.insertTestData(1, 1);
		log.info("结束第二个事务");

		return new ApiResponse<>();
	}

}
