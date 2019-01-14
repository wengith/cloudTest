package ins.platform.robot.dao;

import ins.framework.mybatis.MybatisBaseDao;
import ins.framework.mybatis.Page;
import ins.framework.mybatis.PageParam;
import ins.platform.robot.po.DemoRobotMain;
import ins.platform.robot.vo.DemoRobotMainVo;
import org.apache.ibatis.annotations.Mapper;

/**
 *
 * 表demo_robot_main对应的基于MyBatis实现的Dao接口<br/>
 * 在其中添加自定义方法
 *
 */
@Mapper
public interface DemoRobotMainDao extends MybatisBaseDao<DemoRobotMain, Long> {

	Page<DemoRobotMain> selectByManufactureName(PageParam pageParam, String manufactureName);
	Page<DemoRobotMain> selectPage(PageParam pageParam, DemoRobotMainVo demoRobotMainVo);
}
