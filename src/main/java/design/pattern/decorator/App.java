package design.pattern.decorator;

/**
 * App
 *
 * @author huanghao
 * @version 1.0
 * @date 2022/7/27 17:56
 */
public class App {
    public static void main(String[] args) {
        SimpleTroll simpleTroll = new SimpleTroll();
        simpleTroll.attack();
        simpleTroll.fleeBattle();
        simpleTroll.getAttackPower();

        var clubbedTroll = new ClubbedTroll(simpleTroll);
        clubbedTroll.attack();
        clubbedTroll.fleeBattle();
    }
}
