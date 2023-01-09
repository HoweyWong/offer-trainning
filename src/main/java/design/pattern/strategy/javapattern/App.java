package design.pattern.strategy.javapattern;

import lombok.extern.slf4j.Slf4j;

/**
 * @Description
 * @Author huanghao
 * @Date 2022-4-6
 * @Version 1.0
 */
@Slf4j
public class App {
    private static final String RED_DRAGON_EMERGES = "红龙出现了。";
    private static final String GREEN_DRAGON_SPOTTED = "绿龙出现了。";
    private static final String BLACK_DRAGON_LANDS = "黑龙着陆了。";

    public static void main(String[] args) {
        log.info(RED_DRAGON_EMERGES);
        var slayer = new DragonSlayer(new MeleeStrategy());
        slayer.goToBattle();
        log.info(GREEN_DRAGON_SPOTTED);
        slayer.changeStrategy(new ProjectileStrategy());
        slayer.goToBattle();
    }
}
