package lotto.view;

import lotto.WinningPrice;
import lotto.controller.Lotto;
import lotto.model.PurchaseLottos;

import java.util.List;
import java.util.Map;

public class OutputView {
    public void printPurchaseLottos(final PurchaseLottos purchaseLottos) {
        printPurchaseLottosQuantity(purchaseLottos.getPurchaseQuantity());
        printPurchaseLottosList(purchaseLottos.getPurchaseLottoList());
    }

    public void printPurchaseLottosQuantity(final int purchaseQuantity) {
        System.out.println(purchaseQuantity+"개를 구매했습니다.");
    }

    private void printPurchaseLottosList(final List<Lotto> purchaseLottoList) {
        for(Lotto lotto:purchaseLottoList){
            System.out.println(lotto.getNumbers());
        }
    }

    public void printWinningResult(Map<WinningPrice, Integer> winningMap) {
        System.out.println("당첨 통계\n---");
        System.out.println("3개 일치 (5,000원) - "+winningMap.get(WinningPrice.fifthPlace)+"개");
        System.out.println("4개 일치 (50,000원) - "+winningMap.get(WinningPrice.fourthPlace)+"개");
        System.out.println("5개 일치 (1,500,000원) - "+winningMap.get(WinningPrice.thirdPlace)+"개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - "+winningMap.get(WinningPrice.secondPlace)+"개");
        System.out.println("6개 일치 (2,000,000,000원) - "+winningMap.get(WinningPrice.firstPlace)+"개");
    }

    public void printRateOfReturn(int purchaseAmount, long reward) {
        String returnValue = String.format("%.1f", (double) reward / purchaseAmount*100);
        System.out.println("총 수익률은 "+returnValue+"%입니다.");
    }
}
