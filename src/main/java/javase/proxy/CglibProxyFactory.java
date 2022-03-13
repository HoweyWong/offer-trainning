package javase.proxy;

import net.sf.cglib.proxy.Enhancer;

/**
 * @Description
 * @Author huanghao
 * @Date 2022-3-10
 * @Version 1.0
 */
public class CglibProxyFactory {
    public static Object getProxy(Class clazz) {
        Enhancer enhancer = new Enhancer();
        enhancer.setClassLoader(clazz.getClassLoader());
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(new MyMethodInterceptor());
        return enhancer.create();
    }

    public static void main(String[] args) {
        AliMsgService proxy = (AliMsgService)CglibProxyFactory.getProxy(AliMsgService.class);
        proxy.send("Java");
    }
}
