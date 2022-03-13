package javase.proxy;

/**
 * @Description
 * @Author huanghao
 * @Date 2022-3-10
 * @Version 1.0
 */
public class SmsServiceImpl implements SmsService {
    @Override
    public String sendMessage(String message) {
        System.out.println("Send Message:" + message);
        return message;
    }
}
