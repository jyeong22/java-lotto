package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BonusNumberTest {

    Lotto lotto = new Lotto("1, 2, 3, 4, 5, 6");

    @DisplayName("보너스 번호 입력 - 정상 값 입력")
    @Test
    void createNormalBonusNumber(){
        String bonusNumber = "17";
        assertThat(new BonusNumber(lotto, bonusNumber).getBonusNumber()).isEqualTo(17);
    }

    @DisplayName("보너스 번호 입력 - 빈 값을 입력한 경우 예외 발생")
    @Test
    void createEmptyBonusNumber(){
        String bonusNumber = "";
        assertThatThrownBy(()->new BonusNumber(lotto, bonusNumber)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호 입력 - 띄어쓰기만 입력 시 예외 발생")
    @Test
    void createSpaceBonusNumber(){
        Lotto lotto = new Lotto("1, 2, 3, 4, 5, 6");
        String bonusNumber = "  ";
        assertThatThrownBy(()->new BonusNumber(lotto, bonusNumber)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호 입력 - 숫자를 입력하지 않은 경우")
    @Test
    void createBonusNumberNotDigit(){
        Lotto lotto = new Lotto("1, 2, 3, 4, 5, 6");
        String bonusNumber = "1a";
        assertThatThrownBy(()->new BonusNumber(lotto, bonusNumber)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호 입력 - 1부터 45사이의 숫자가 아닌 경우")
    @Test
    void createBonusNumberOutOfRange(){
        Lotto lotto = new Lotto("1, 2, 3, 4, 5, 6");
        String bonusNumber = "46";
        assertThatThrownBy(()->new BonusNumber(lotto, bonusNumber)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호 입력 - 당첨 로또 번호 안에 이미 존재할 경우")
    @Test
    void createBonusNumberDuplicated(){
        Lotto lotto = new Lotto("1, 2, 3, 4, 5, 6");
        String bonusNumber = "6";
        assertThatThrownBy(()->new BonusNumber(lotto, bonusNumber)).isInstanceOf(IllegalArgumentException.class);
    }
}
