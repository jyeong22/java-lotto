package lotto.view;

import lotto.model.WinningPrice;
import lotto.controller.Lotto;
import lotto.model.PurchaseLottos;
import java.util.List;
import java.util.Map;

public class OutputView {
    private static final String PURCHASE_LOTTOS_QUANTITY = "%d개를 구매했습니다.\n";
    private static final String WINNING_RESULT = "당첨 통계\n---";
    private static final String RATE_OF_RETURN = "총 수익률은 %.1f%%입니다.";

    public static void printPurchaseLottos(final PurchaseLottos purchaseLottos) {
        printPurchaseLottosQuantity(purchaseLottos.getPurchaseQuantity());
        printPurchaseLottosList(purchaseLottos.getPurchaseLottoList());
    }

    public static void  printPurchaseLottosQuantity(final int purchaseQuantity) {
        System.out.printf(PURCHASE_LOTTOS_QUANTITY, purchaseQuantity);
    }

    public static void printWinningResult(Map<WinningPrice, Integer> winningMap) {
        System.out.println(WINNING_RESULT);
        System.out.println("3개 일치 (5,000원) - "+winningMap.get(WinningPrice.fifthPlace)+"개");
        System.out.println("4개 일치 (50,000원) - "+winningMap.get(WinningPrice.fourthPlace)+"개");
        System.out.println("5개 일치 (1,500,000원) - "+winningMap.get(WinningPrice.thirdPlace)+"개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - "+winningMap.get(WinningPrice.secondPlace)+"개");
        System.out.println("6개 일치 (2,000,000,000원) - "+winningMap.get(WinningPrice.firstPlace)+"개");
    }

    private static void printPurchaseLottosList(final List<Lotto> purchaseLottoList) {
        for(Lotto lotto:purchaseLottoList){
            System.out.println(lotto.getNumbers());
        }
    }

    public static void printRateOfReturn(int purchaseAmount, long reward) {
        System.out.printf(RATE_OF_RETURN, ((double) reward / purchaseAmount)*100);
    }

}
