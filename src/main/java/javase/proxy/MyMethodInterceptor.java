package javase.proxy;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * @Description
 * @Author huanghao
 * @Date 2022-3-10
 * @Version 1.0
 */
public class MyMethodInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("before method");
        Object result = methodProxy.invokeSuper(o, objects);
        System.out.println("after method");
        return result;
    }
}
