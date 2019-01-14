package ins.platform.robot.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * 通过ins-framework-mybatis工具自动生成。表demo_robot_main的VO对象<br/>
 * 对应表名：demo_robot_main
 *
 */
@Data
public class DemoRobotMainVo implements Serializable {
	private static final long serialVersionUID = 1L;
	/** 对应字段：id */
	private Long id;
	/** 对应字段：robot_sn */
	private String robotSn;
	/** 对应字段：robot_height */
	private BigDecimal robotHeight;
	/** 对应字段：nickname */
	private String nickname;
	/** 对应字段：recharge_count */
	private Integer rechargeCount;
	/** 对应字段：manufacture_name */
	private String manufactureName;
	/** 对应字段：manufacture_date */
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date manufactureDate;
	/** 对应字段：com_code */
	private String comCode;
	/** 对应字段：version */
	private Integer version;
	/** 对应字段：Insert_Time_For_His */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date insertTimeForHis;
	/** 对应字段：Operate_Time_For_His */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date operateTimeForHis;
	private List<DemoRobotJobVo> jobList = new ArrayList< >();

}
