package ins.platform.demo.service;

import ins.framework.common.ResultPage;
import ins.framework.log.TraceLog;
import ins.platform.demo.vo.EchoVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 示例用的EchoService实现
 *
 */
@Service
@Slf4j
@CacheConfig(cacheNames = "echo")
public class EchoService {
	private static final ZoneId ZONE = ZoneId.systemDefault();
	private static final DateTimeFormatter YEAR_TO_SECOND = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

	/**
	 * 传入对象回显对象
	 *
	 * @param vo Echo对象
	 * @return 回显对象
	 */
	@Cacheable
	public EchoVo echoObjectByObject(EchoVo vo) {
		log.info("call echoObjectByObject,input {}", vo);
		EchoVo result = new EchoVo();
		result.setValue(vo.getValue());
		result.setTime(vo.getTime());
		log.info("call echoObjectByObject,return {}", result);
		return result;
	}

	/**
	 * 传入字符串回显字符串
	 *
	 * @param value 传入value
	 * @return 回显name
	 */
	@Cacheable
	public String echoStringByString(String value) {
		log.info("call echoStringByString,input {}", value);
		// 这里演示TraceLog用
		TraceLog.record("这是第1步", value);
		String result = value;
		TraceLog.record("这是第2步", value);
		log.info("call echoStringByString,return {}", result);
		return result;
	}

	/**
	 * 传入字符串回显对象
	 *
	 * @param value 传入value
	 * @return 回显对象
	 */
	@Cacheable()
	public EchoVo echoObjectByString(String value) {
		log.info("call echoObjectByString,input {}", value);
		EchoVo result = new EchoVo();
		result.setValue(value);
		result.setTime(Date.from(
				LocalDateTime.parse("2016-07-12 17:13:20", YEAR_TO_SECOND).atZone(ZoneId.systemDefault()).toInstant()));
		log.info("call echoObjectByString,return {}", result);
		return result;
	}

	/**
	 * 传入对象回显字符串
	 *
	 * @param vo Echo对象
	 * @return 回显字符串
	 */
	@Cacheable
	public String echoStringByObject(EchoVo vo) {
		log.info("call echoStringByObject,input {}", vo);
		LocalDateTime dateTime = LocalDateTime.ofInstant(vo.getTime().toInstant(), ZONE);
		String result = "call echoStringByObject: " + vo.getValue() + " at " + dateTime.format(YEAR_TO_SECOND);
		log.info("call echoStringByObject,return {}", result);
		return result;
	}

	/**
	 * 传入字符串和日期回显字符串
	 *
	 * @param value 传入value
	 * @param date  传入date
	 * @return 回显name
	 */
	@Cacheable
	public String echoStringByStringAndDate(String value, Date date) {
		log.info("call echoStringByObject,input {},{}", value, date);
		LocalDateTime dateTime = LocalDateTime.ofInstant(date.toInstant(), ZONE);
		String result = "call echoStringByStringAndDate: value=" + value + ",date=" + dateTime.format(YEAR_TO_SECOND);
		log.info("call echoStringByObject,return {}", result);
		return result;
	}

	/**
	 * 获取EchoVo结果页
	 * 
	 * @param pageNo   页号
	 * @param pageSize 每页多少条记录
	 * @return 结果页
	 */
	public ResultPage<EchoVo> search(int pageNo, int pageSize) {
		List<EchoVo> data = new ArrayList<>();
		for (int i = (pageNo - 1) * pageSize; i < pageNo * pageSize; i++) {
			EchoVo vo = new EchoVo();
			vo.setValue("我是" + i + "号EchoVo");
			vo.setTime(Date.from(LocalDateTime.now().atZone(ZONE).toInstant()));
			data.add(vo);
		}
		return new ResultPage<>(pageNo, pageSize, Integer.MAX_VALUE, data);
	}
}
