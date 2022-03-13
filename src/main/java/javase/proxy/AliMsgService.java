package javase.proxy;

/**
 * @Description
 * @Author huanghao
 * @Date 2022-3-10
 * @Version 1.0
 */
public class AliMsgService {
    public String send(String message) {
        System.out.println("send message:" + message);
        return message;
    }
}
