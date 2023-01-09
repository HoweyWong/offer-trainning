package design.pattern.strategy.javapattern;

import lombok.extern.slf4j.Slf4j;

/**
 * @Description
 * @Author huanghao
 * @Date 2022-4-6
 * @Version 1.0
 */
@Slf4j
public class ProjectileStrategy implements DragonSlayingStrategy {
    /**
     * 执行方法
     *
     * @Author huanghao
     * @Date 2022-4-6
     */
    @Override
    public void execute() {
        log.info("你用魔法弩射死了龙，它倒在地上死了！");
    }
}
