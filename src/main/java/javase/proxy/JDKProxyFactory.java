package javase.proxy;

import java.lang.reflect.Proxy;

/**
 * @Description
 * @Author huanghao
 * @Date 2022-3-10
 * @Version 1.0
 */
public class JDKProxyFactory {
    public static Object getProxy(Object target) {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),
            new MessageInvocationHandler(target));
    }

    public static void main(String[] args) {
        SmsService smsService = (SmsService)JDKProxyFactory.getProxy(new SmsServiceImpl());
        smsService.sendMessage("Test");
    }
}
