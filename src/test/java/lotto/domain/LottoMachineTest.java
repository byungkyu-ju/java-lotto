package lotto.domain;

import lotto.domain.ticket.LottoBundle;
import lotto.vo.Money;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoMachineTest {
    @Test
    public void 입력값_만큼_로또_가져오기() {
        // given
        int numberOfLottos = 5;

        // when
        LottoBundle lottoBundle = LottoMachine.getLottos(5);

        // then
        assertThat(lottoBundle.getLottos()).hasSize(numberOfLottos);
    }

    @Test
    public void 금액_만큼_로또를_구매하기_잔액없는경우() {
        // given
        Money money = new Money(10_000);

        // when
        LottoBundle lottoBundle = LottoMachine.buyLottos(money);

        // then
        assertThat(lottoBundle.getLottos()).hasSize(10);
    }

    @Test
    public void 금액_만큼_로또를_구매하기_잔액있는경우() {
        // given
        Money money = new Money(10_500);

        // when
        LottoBundle lottoBundle = LottoMachine.buyLottos(money);

        // then
        assertThat(lottoBundle.getLottos()).hasSize(10);
    }

    @Test
    public void 로또를_구매할_수_있는_금액이_아닌_경우_IllegalArgumentException() {
        // given
        Money money = new Money(500);

        //when
        //then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LottoMachine.buyLottos(money));
    }
}