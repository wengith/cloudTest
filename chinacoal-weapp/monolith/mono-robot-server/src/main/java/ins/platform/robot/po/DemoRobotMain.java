package ins.platform.robot.po;

import ins.framework.mybatis.annotations.Column;
import ins.framework.mybatis.annotations.Table;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * 通过ins-framework-mybatis-generator工具自动生成，请勿手工修改。表demo_robot_main的PO对象<br/>
 * 对应表名：demo_robot_main
 *
 */
@Data
@Table(name="demo_robot_main")
public class DemoRobotMain implements Serializable {
	private static final long serialVersionUID = 1L;
	/** 对应字段：Id */
	@Column(name = "Id")
	private Long id;
	/** 对应字段：robot_sn */
	@Column(name = "robot_sn")
	private String robotSn;
	/** 对应字段：robot_height */
	@Column(name = "robot_height")
	private BigDecimal robotHeight;
	/** 对应字段：nickname */
	@Column(name = "nickname")
	private String nickname;
	/** 对应字段：recharge_count */
	@Column(name = "recharge_count")
	private Integer rechargeCount;
	/** 对应字段：manufacture_name */
	@Column(name = "manufacture_name")
	private String manufactureName;
	/** 对应字段：manufacture_date */
	@Column(name = "manufacture_date")
	private Date manufactureDate;
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
