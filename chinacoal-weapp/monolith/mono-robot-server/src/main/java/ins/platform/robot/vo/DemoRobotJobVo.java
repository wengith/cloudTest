package ins.platform.robot.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * 通过ins-framework-mybatis工具自动生成。表demo_robot_job的VO对象<br/>
 * 对应表名：demo_robot_job
 *
 */
@Data
public class DemoRobotJobVo implements Serializable {
	private static final long serialVersionUID = 1L;
	/** 对应字段：id */
	private Long id;
	/** 对应字段：robot_id */
	private Long robotId;
	/** 对应字段：start_time */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	private Date startTime;
	/** 对应字段：end_time */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	private Date endTime;
	/** 对应字段：walk_count */
	private Long walkCount;
	/** 对应字段：consume_energy */
	private BigDecimal consumeEnergy;
	/** 对应字段：job_content */
	private String jobContent;
	/** 对应字段：job_image */
	private byte[] jobImage;
	/** 对应字段：com_code */
	private String comCode;
	/** 对应字段：version */
	private Integer version;
	/** 对应字段：Insert_Time_For_His */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	private Date insertTimeForHis;
	/** 对应字段：Operate_Time_For_His */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	private Date operateTimeForHis;

}
