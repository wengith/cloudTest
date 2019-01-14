package ins.platform.demo.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * EchoVo对象，用于Echo服务(通过lombok自动预编译生成Getter/Setter方法和equals、hashCode、
 * toString等3个方法)
 * <p/>
 * 注意：时间属性上组号添加@DateTimeFormat避免格式化问题
 * <p/>
 *
 * @author zhouxianli
 *
 */
@Data
public class EchoVo implements Serializable {

	private static final long serialVersionUID = 1L;
	private String value;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date time;

}
