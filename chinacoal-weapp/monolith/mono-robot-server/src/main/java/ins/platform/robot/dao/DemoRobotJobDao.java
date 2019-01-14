package ins.platform.robot.dao;

import ins.framework.mybatis.MybatisBaseDao;
import ins.framework.mybatis.Page;
import ins.framework.mybatis.PageParam;
import ins.platform.robot.po.DemoRobotJob;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 *
 * 表demo_robot_job对应的基于MyBatis实现的Dao接口<br/>
 * 在其中添加自定义方法
 *
 */
@Mapper
public interface DemoRobotJobDao extends MybatisBaseDao<DemoRobotJob, Long> {

	Page<DemoRobotJob> selectByRobotId(PageParam pageParam, Long robotId);

	void deleteByRobotIds(List<Long> robotIds);
}
