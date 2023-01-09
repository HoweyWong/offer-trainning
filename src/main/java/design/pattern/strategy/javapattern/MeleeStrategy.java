package design.pattern.strategy.javapattern;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Description
 * @Author huanghao
 * @Date 2022-4-6
 * @Version 1.0
 */
@Slf4j
public class MeleeStrategy implements DragonSlayingStrategy {
    private static final Logger LOGGER = LoggerFactory.getLogger(DragonSlayingStrategy.class);

    /**
     * 执行方法
     *
     * @Author huanghao
     * @Date 2022-4-6
     */
    @Override
    public void execute() {
        LOGGER.info("你用神剑砍下了神龙的头！");
    }
}
