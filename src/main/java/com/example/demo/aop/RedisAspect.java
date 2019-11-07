package com.example.demo.aop;

import com.alibaba.fastjson.JSON;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

/**
 * @Auther: ahu_w
 * @Date: 2019/11/7 17:52
 * @Description: aop整合redis,dao层
 */
@Aspect
@Component
public class RedisAspect {
    private static final Logger logger = LoggerFactory.getLogger(WebLogAspect.class);
    @Autowired
    private RedisTemplate redisTemplate;
    //设置切点，用户基础维护查询
    @Pointcut("(execution(* com.example.demo.dao.ComputerUserDao.select*(..)))")//
    public void getComputerUserCache(){
    }

    @Around("getComputerUserCache()")
    public Object aroundGetComputerUserCache(ProceedingJoinPoint joinPoint) throws Throwable {
        logger.info("进入redis缓存切面");
        //数据以json形式存储
        ValueOperations<String, String> operations = redisTemplate.opsForValue();
        //获取目标类名，方法名、参数
        String clazzName=joinPoint.getSignature().getDeclaringTypeName();//类名
        String methodName =joinPoint.getSignature().getName();//方法名
        Object[] args = joinPoint.getArgs();
        //得到被代理的方法
        Method method = ((MethodSignature)joinPoint.getSignature()).getMethod();
        //被代理方法的返回值类型
        Class returnType = ((MethodSignature) joinPoint.getSignature()).getReturnType();
        String key = generateCacheKey(clazzName,methodName,args);

        Object result;
        boolean hasKey = redisTemplate.hasKey(key);
        if (hasKey){
            String text = operations.get(key);
            result = JSON.parseObject(text, returnType);
            logger.info("命中缓存，缓存数据：[{}]",text);
            return result;
        }

        result = joinPoint.proceed();
        String json = JSON.toJSONString(result);
        operations.set(key,json);
        redisTemplate.expire(key,60L,TimeUnit.SECONDS);
        logger.info("查询数据库，插入数据：[{}]",json);
        return result;
    }
    /**
     * key构造函数
     * */
    public static String generateCacheKey(String targetName, String methodName, Object[] arguments) {
        StringBuffer keySb = new StringBuffer();
        keySb.append(targetName.toUpperCase());
        keySb.append("_");
        keySb.append(methodName.toUpperCase());
        if ((arguments != null) && (arguments.length != 0)) {
            for (int i = 0; i < arguments.length; i++) {
                Object arg = arguments[i];
                if(arg instanceof String){
                    keySb.append("_").append(arg.toString().toUpperCase());
                }else if(arg instanceof Integer){
                    keySb.append("_").append(arg.toString().toUpperCase());
                }else if(arg instanceof Double){
                    keySb.append("_").append(arg.toString().toUpperCase());
                }else if(arg instanceof Float){
                    keySb.append("_").append(arg.toString().toUpperCase());
                }else if(arg instanceof Boolean){
                    keySb.append("_").append(arg.toString().toUpperCase());
                }else if(arg instanceof Long){
                    keySb.append("_").append(arg.toString().toUpperCase());
                }else if(arg instanceof Byte){
                    keySb.append("_").append(arg.toString().toUpperCase());
                }else if(arg instanceof Short){
                    keySb.append("_").append(arg.toString().toUpperCase());
                }
            }
        }
        return keySb.toString();
    }
}
