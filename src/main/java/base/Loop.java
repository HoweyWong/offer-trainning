package base;

/**
 * @Description
 * @Author huanghao
 * @Date 2022-3-15
 * @Version 1.0
 */
public class Loop {
    public static void main(String[] args) {
        // 添加标签
        a:
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.println(i + ":" + j);
                // 直接跳转到标签处
                // break a;
                // continue;
                return;
            }
        }
    }
}
