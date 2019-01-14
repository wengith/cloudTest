package ins.platform.robot.po;

import ins.framework.mybatis.annotations.Column;
import ins.framework.mybatis.annotations.Table;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * 通过ins-framework-mybatis-generator工具自动生成，请勿手工修改。表demo_robot_job的PO对象<br/>
 * 对应表名：demo_robot_job
 *
 */
@Data
@Table(name="demo_robot_job")
public class DemoRobotJob implements Serializable {
	private static final long serialVersionUID = 1L;
	/** 对应字段：Id */
	@Column(name = "Id")
	private Long id;
	/** 对应字段：robot_id */
	@Column(name = "robot_id")
	private Long robotId;
	/** 对应字段：start_time */
	@Column(name = "start_time")
	private Date startTime;
	/** 对应字段：end_time */
	@Column(name = "end_time")
	private Date endTime;
	/** 对应字段：walk_count */
	@Column(name = "walk_count")
	private Long walkCount;
	/** 对应字段：consume_energy */
	@Column(name = "consume_energy")
	private BigDecimal consumeEnergy;
	/** 对应字段：job_content */
	@Column(name = "job_content")
	private String jobContent;
	/** 对应字段：job_image */
	@Column(name = "job_image")
	private byte[] jobImage;
	/** 对应字段：com_code */
	@Column(name = "com_code")
	private String comCode;
	/** 对应字段：version */
	@Column(name = "version")
	private Integer version;
	/** 对应字段：Insert_Time_For_His */
	@Column(name = "Insert_Time_For_His")
	private Date insertTimeForHis;
	/** 对应字段：Operate_Time_For_His */
	@Column(name = "Operate_Time_For_His")
	private Date operateTimeForHis;

}
