package design.pattern.strategy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lombok.extern.slf4j.Slf4j;

/**
 * @Description
 * @Author huanghao
 * @Date 2022-4-6
 * @Version 1.0
 */
@Slf4j
public class App {
    private static final Logger LOGGER = LoggerFactory.getLogger(DragonSlayingStrategy.class);
    private static final String RED_DRAGON_EMERGES = "红龙出现了。";

    public static void main(String[] args) {
        LOGGER.info(RED_DRAGON_EMERGES);
        var slayer = new DragonSlayer(new MeleeStrategy());
        slayer.goToBattle();
    }
}
