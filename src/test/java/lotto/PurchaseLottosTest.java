package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PurchaseLottosTest {

    @DisplayName("로또 구입 - LottoMachine, Lotto를 통해 유효성 검사 시 예외 발생하지 않음")
    @Test
    void checkPurchaseLottos() {
        PurchaseLottos purchaseLottos = new PurchaseLottos(3);
        assertThat( purchaseLottos.getPurchaseLottos().size()).isEqualTo(3);
    }

    @DisplayName("로또 구입 - 6개의 로또 모두 다름")
    @Test
    void checkDifferentLottos() {
        PurchaseLottos purchaseLottos = new PurchaseLottos(3);
        assertThat(purchaseLottos.getPurchaseLottos().stream().distinct().count() ==3).isTrue();
    }
}
