package aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;

@Component
@Aspect
public class QueryTimeAop {
//advice & pointcut
    //method 구조
    // 앞에 * : 어떤 반환형이든, 뒤에 *: 클래스의 어떤 메서드든지간에, (..): 어떤 파라미터를 받던지간에
    //조인포인트는 메서드 단위로만 지정됌, 나는 쿼리를 보내는 시간을 출력하는 것을 만들려함.
    @Around("execution( * repository.ProductRepository.*(..))")
    public Object printCurrentTime(ProceedingJoinPoint pjp){
        Object result = null;
        String current = null;
        try {
            SimpleDateFormat fmt = new SimpleDateFormat("yyyy년 MM월dd일 HH시mm분ss초");
            current = fmt.format(System.currentTimeMillis());
            System.out.print("AOP before, CURENT TIME :     " + current + "\n");
            pjp.proceed();
            current = fmt.format(System.currentTimeMillis());
            System.out.print("AOP after, CURENT TIME :     " + current + "\n");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return result;
}

}
