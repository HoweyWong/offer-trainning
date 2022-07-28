package design.pattern.decorator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

/**
 * ClubbedTrollTest
 *
 * @author huanghao
 * @version 1.0
 * @date 2022/7/27 18:14
 */
public class ClubbedTrollTest {
    @Test
    void testClubbedTroll() {
        SimpleTroll simpleTroll = spy(new SimpleTroll());
        ClubbedTroll clubbedTroll = new ClubbedTroll(simpleTroll);
        assertEquals(20, clubbedTroll.getAttackPower());
        verify(simpleTroll, times(1)).getAttackPower();

        clubbedTroll.attack();
        verify(simpleTroll, times(1)).attack();
        clubbedTroll.fleeBattle();
        verify(simpleTroll, times(1)).fleeBattle();
        verifyNoMoreInteractions(simpleTroll);
    }
}
