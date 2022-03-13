package javase.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Description
 * @Author huanghao
 * @Date 2022-3-10
 * @Version 1.0
 */
public class MessageInvocationHandler implements InvocationHandler {
    private final Object target;

    public MessageInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before method invoke," + method.getName());
        Object result = method.invoke(target, args);
        System.out.println("after method invoke," + method.getName());
        return result;
    }
}
