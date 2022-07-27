package design.pattern.decorator;

import lombok.extern.slf4j.Slf4j;

/**
 * ClubbedTroll 木棍
 *
 * @author huanghao
 * @version 1.0
 * @date 2022/7/27 17:54
 */
@Slf4j
public class ClubbedTroll implements Troll {
    private final Troll decorator;

    public ClubbedTroll(Troll decorator) {
        this.decorator = decorator;
    }

    @Override
    public void attack() {
        decorator.attack();
        log.info("The troll swings at you with a club!");
    }

    @Override
    public int getAttackPower() {
        return decorator.getAttackPower() + 10;
    }

    @Override
    public void fleeBattle() {
        decorator.fleeBattle();
    }
}
