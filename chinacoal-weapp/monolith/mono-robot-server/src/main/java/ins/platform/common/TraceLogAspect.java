package ins.platform.common;

import ins.framework.log.AbstractTraceLogAspect;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 默认的方法日志拦截器
 * @author zhouxianli
 * 
 */ 
@Aspect
@Component
public class TraceLogAspect extends AbstractTraceLogAspect{  
	
	@Pointcut("execution(public * ins.platform.robot..*.*(..))")
	public void traceLogPointcut() {
		//本方法的注解表明了拦截的类和方法（用于调试日志TraceLog）
	}
}
