package lotto;

import java.util.ArrayList;
import java.util.List;

public class PurchaseLottos {
    private final List<Lotto> purchaseLottos;

    PurchaseLottos(int numberOfPurchase){
        this.purchaseLottos = generateLottosList(numberOfPurchase);
    }

    private List<Lotto> generateLottosList(int numberOfPurchase) {
        List<Lotto> lottos = new ArrayList<>();
        for(int i = 0; i<numberOfPurchase;++i){
            lottos.add(new Lotto(new LottoMachine().getRandomNumbers()));
        }
        return lottos;
    }

    public List<Lotto> getPurchaseLottos(){
        return purchaseLottos;
    }
}
