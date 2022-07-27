package design.pattern.decorator;

import lombok.extern.slf4j.Slf4j;

/**
 * SimpleTroll
 *
 * @author huanghao
 * @version 1.0
 * @date 2022/7/27 17:50
 */
@Slf4j
public class SimpleTroll implements Troll {
    @Override
    public void attack() {
        // grab 抓住
        log.info("The troll tries to grab you!");
    }

    @Override
    public int getAttackPower() {
        return 10;
    }

    @Override
    public void fleeBattle() {
        // shriek 尖叫
        // horror 因...而恐惧
        log.info("The troll shrieks in horror and runs away!");
    }
}
