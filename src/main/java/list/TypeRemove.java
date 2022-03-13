package list;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * @Description Java的泛型是伪泛型，在运行时会把类型擦除
 * @Author huanghao
 * @Date 2022-3-10
 * @Version 1.0
 */
public class TypeRemove {
    public static void main(String[] args)
        throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(17);
        Class<? extends ArrayList> clazz = list.getClass();
        Method method = clazz.getMethod("add", Object.class);
        method.invoke(list, "ab");
        System.out.println(list);
    }
}
