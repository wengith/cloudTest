package ins.platform.robot.service;

import ins.framework.common.ResultPage;
import ins.framework.mybatis.MybatisApiUtils;
import ins.framework.mybatis.Page;
import ins.framework.mybatis.PageParam;
import ins.framework.mybatis.util.Pages;
import ins.framework.utils.Beans;
import ins.framework.utils.Uuids;
import ins.platform.robot.dao.DemoRobotJobDao;
import ins.platform.robot.dao.DemoRobotMainDao;
import ins.platform.robot.po.DemoRobotJob;
import ins.platform.robot.po.DemoRobotMain;
import ins.platform.robot.vo.DemoRobotJobVo;
import ins.platform.robot.vo.DemoRobotMainVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 用于演示数据库操作的Robot服务实现
 * 
 * @author zhouxianli
 *
 */
@Service
@Transactional
@Slf4j
public class DemoRobotService {
	private static final int TEN_SECONDS = 10000;
	@Autowired
	private DemoRobotMainDao demoRobotMainDao;
	@Autowired
	private DemoRobotJobDao demoRobotJobDao;

	/**
	 * 插入一条记录
	 * 
	 * @param vo 传入VO
	 * @return 返回结果对象
	 */
	public DemoRobotMainVo create(DemoRobotMainVo vo) {
		DemoRobotMainVo result = createMain(vo);
		List<DemoRobotJobVo> resultJobList = new ArrayList<>();
		for (DemoRobotJobVo jobVo : vo.getJobList()) {
			jobVo.setRobotId(result.getId());
			DemoRobotJobVo resultVo = createJob(jobVo);
			resultJobList.add(resultVo);
		}

		result.setJobList(resultJobList);
		return result;
	}

	/**
	 * 根据生产厂家查询
	 * 
	 * @param manufactureName 生产厂家
	 * @return 返回结果对象
	 */

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ResultPage<DemoRobotMainVo> selectByManufactureName(String manufactureName) {
		PageParam pageParam = MybatisApiUtils.getPageParam();
		Page<DemoRobotMain> poList = demoRobotMainDao.selectByManufactureName(pageParam, manufactureName);
		return Pages.convert(pageParam, poList, DemoRobotMainVo.class);
	}

	/**
	 * 修改记录信息
	 * 
	 * @param vo 传入VO
	 */
	public void update(DemoRobotMainVo vo) {
		updateMain(vo);
		for (DemoRobotJobVo jobVo : vo.getJobList()) {
			updateJob(jobVo);
		}
	}

	/**
	 * 获取记录信息
	 * 
	 * @param id 传入id
	 * @return 返回结果对象
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DemoRobotMainVo selectByPrimaryKey(Long id) {
		DemoRobotMain po = demoRobotMainDao.selectByPrimaryKey(id);
		if (po == null) {
			return null;
		}
		DemoRobotMainVo vo = new DemoRobotMainVo();
		Beans.copy().from(po).to(vo);
		// 这里获取所有数据，无需count值
		PageParam pageParam = new PageParam(Integer.MAX_VALUE);
		pageParam.setContainsTotalCount(false);
		List<DemoRobotJob> jobList = demoRobotJobDao.selectByRobotId(pageParam, vo.getId());
		List<DemoRobotJobVo> resultJobList = new ArrayList<>();

		for (DemoRobotJob jobPo : jobList) {
			DemoRobotJobVo jobVo = new DemoRobotJobVo();
			Beans.copy().from(jobPo).to(jobVo);
			resultJobList.add(jobVo);
		}
		vo.setJobList(resultJobList);
		return vo;
	}

	/**
	 * 删除多条记录
	 * 
	 * @param ids 传入ids
	 */
	public void delete(List<Long> ids) {
		demoRobotJobDao.deleteByRobotIds(ids);
		demoRobotMainDao.deleteBatchByPrimaryKeys(ids);
	}

	/**
	 * 前端页面查询
	 * 
	 * @param demoRobotMainVo 传入VO
	 * @return 返回结果对象
	 */

	@Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.READ_COMMITTED, readOnly = true)
	public ResultPage<DemoRobotMainVo> findForDataTables(DemoRobotMainVo demoRobotMainVo) {
		PageParam pageParam = MybatisApiUtils.getPageParam();
		Page<DemoRobotMain> poList = demoRobotMainDao.selectPage(pageParam, demoRobotMainVo);
		return Pages.convert(pageParam, poList, DemoRobotMainVo.class);
	}

	/**
	 * 插入一条Main记录
	 * 
	 * @param vo 传入VO
	 * @return 返回结果对象
	 */
	public DemoRobotMainVo createMain(DemoRobotMainVo vo) {
		// 1.检查传入参数
		Assert.notNull(vo, "Object must have value");
		// 2.构建PO对象
		DemoRobotMain po = new DemoRobotMain();
		// 3.VO复制值到PO
		Beans.copy().from(vo).to(po);
		// 4.设置PO本身的属性

		// 5.实际调用Dao进行操作
		demoRobotMainDao.insertSelective(po);

		DemoRobotMainVo result = new DemoRobotMainVo();
		Beans.copy().from(po).to(result);
		return result;
	}

	/**
	 * 修改Main记录信息
	 * 
	 * @param vo 传入VO
	 */
	public void updateMain(DemoRobotMainVo vo) {
		DemoRobotMain po = new DemoRobotMain();
		Beans.copy().from(vo).to(po);
		demoRobotMainDao.updateSelectiveByPrimaryKey(po);
	}

	/**
	 * 获取Main记录信息
	 * 
	 * @param id 传入id
	 * @return 返回结果对象
	 */

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DemoRobotMainVo selectMainByPrimaryKey(Long id) {
		DemoRobotMain po = demoRobotMainDao.selectByPrimaryKey(id);
		if (po == null) {
			return null;
		}
		DemoRobotMainVo vo = new DemoRobotMainVo();
		Beans.copy().from(po).to(vo);
		return vo;
	}

	/**
	 * 插入一条Job记录
	 * 
	 * @param vo 传入VO
	 * @return 返回结果对象
	 */
	public DemoRobotJobVo createJob(DemoRobotJobVo vo) {
		// 1.检查传入参数
		Assert.notNull(vo, "Object must have value");
		Assert.state(vo.getRobotId() > 0, "RobotId must have value");
		// 2.构建PO对象
		DemoRobotJob po = new DemoRobotJob();
		// 3.VO复制值到PO
		Beans.copy().from(vo).to(po);
		// 4.设置PO本身的属性

		// 5.实际调用Dao进行操作
		demoRobotJobDao.insertSelective(po);

		DemoRobotJobVo result = new DemoRobotJobVo();
		Beans.copy().from(po).to(result);
		return result;
	}

	/**
	 * 修改Job记录信息
	 * 
	 * @param vo 传入VO
	 */
	public void updateJob(DemoRobotJobVo vo) {
		DemoRobotJob po = new DemoRobotJob();
		Beans.copy().from(vo).to(po);
		demoRobotJobDao.updateSelectiveByPrimaryKey(po);
	}

	/**
	 * 获取Job记录信息
	 * 
	 * @param id 传入Id
	 * @return 返回结果对象
	 */

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DemoRobotJobVo selectJobByPrimaryKey(Long id) {
		DemoRobotJob po = demoRobotJobDao.selectByPrimaryKey(id);
		if (po == null) {
			return null;
		}
		DemoRobotJobVo vo = new DemoRobotJobVo();
		Beans.copy().from(po).to(vo);
		return vo;
	}

	/**
	 * 删除多条Job记录
	 * 
	 * @param ids 传入ids
	 */
	public void deleteJob(List<Long> ids) {
		demoRobotJobDao.deleteBatchByPrimaryKeys(ids);
	}

	/**
	 * 前端页面查询Job记录
	 * 
	 * @param paramMap 传入参数map
	 * @return 返回结果对象
	 */

	@Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.READ_COMMITTED, readOnly = true)
	public ResultPage<DemoRobotJobVo> findJobForDataTables(Map<String, String[]> paramMap) {
		PageParam pageParam = MybatisApiUtils.getPageParam();
		Page<DemoRobotJob> poList = demoRobotJobDao.selectPage(pageParam, null);
		return Pages.convert(pageParam, poList, DemoRobotJobVo.class);
	}

	/**
	 * 用于演示长时间使用的外部服务
	 */
	@Transactional(propagation = Propagation.NEVER)
	public void longCall() {
		log.info("长时间外部服务--Start");
		try {
			Thread.sleep(TEN_SECONDS);
		} catch (InterruptedException e) {
			log.error("{}", e.getMessage(), e);
			Thread.currentThread().interrupt();
			throw new IllegalArgumentException(e.getMessage(), e);
		}
		log.info("长时间外部服务--End");
	}

	/**
	 * 插入测试数据
	 * 
	 * @param mainCount 机器人数量
	 * @param jobCount  每个机器人的作业数量
	 */
	public void insertTestData(int mainCount, int jobCount) {
		try {
			for (int i = 0; i < mainCount; i++) {
				DemoRobotMainVo vo = makeMainVo(Uuids.longUuid());
				List<DemoRobotJobVo> jobList = new ArrayList<>();
				for (int j = 0; j < jobCount; j++) {
					DemoRobotJobVo jobVo = makeJobVo(vo.getId());
					jobList.add(jobVo);
				}
				vo.setJobList(jobList);
				create(vo);
			}
		} catch (ParseException e) {
			log.warn("{}", e.getMessage(), e);
		}
	}

	private static DemoRobotMainVo makeMainVo(String robotSn) throws ParseException {
		DemoRobotMainVo vo = new DemoRobotMainVo();
		vo.setRobotSn(robotSn);
		vo.setRobotHeight(new BigDecimal("10.5"));
		vo.setRechargeCount(4);
		vo.setManufactureName("SERVICE_TEST:金融保险二部:" + vo.getRobotSn());
		vo.setManufactureDate(DateUtils.parseDate("2016-11-1", "yyyy-MM-dd"));
		vo.setComCode("001001");
		return vo;
	}

	private static DemoRobotJobVo makeJobVo(Long robotId) throws ParseException {
		DemoRobotJobVo vo = new DemoRobotJobVo();
		vo.setRobotId(robotId);
		vo.setStartTime(DateUtils.parseDate("2016-11-2 11:27:10", "yyyy-MM-dd HH:mm:ss"));
		vo.setEndTime(DateUtils.parseDate("2016-11-2 14:28:25", "yyyy-MM-dd HH:mm:ss"));

		vo.setWalkCount(5L);
		vo.setConsumeEnergy(new BigDecimal("23134.2489"));
		vo.setJobContent("SERVICE_TEST:作业内容");
		vo.setComCode("002001");
		return vo;
	}
}
