package lotto.controller;

import lotto.model.BonusNumber;
import lotto.model.PurchaseLottos;
import lotto.model.Statistics;
import lotto.view.InputView;
import lotto.view.OutputView;

public class GameController {
    private static PurchaseLottos purchaseLottos;
    private static Lotto winningLotto;
    private static BonusNumber bonusNumber;

    public static void proceedGame(){
        try{
            buyLottos();
            setWinningNumber();
            setBonusNumber();
            showWinningStatistics();
        }
        catch(IllegalArgumentException exception){
            System.out.println(exception.getMessage());
        }
    }

    private static void buyLottos() {
        setPurchaseLottos();
        division();
        showPurchaseLottos();
        division();
    }

    private static void setPurchaseLottos() {
        purchaseLottos = new PurchaseLottos(getPurchaseAmount());
    }

    private static String getPurchaseAmount() {
        return InputView.inputPurchaseAmount();
    }

    private static void showPurchaseLottos() {
        OutputView.printPurchaseLottos(purchaseLottos);
    }

    private static void setWinningNumber() {
        winningLotto = new Lotto(getWinningNumber());
        division();
    }

    private static String getWinningNumber() {
        return InputView.inputWinningNumber();
    }

    private static void setBonusNumber() {
        bonusNumber = new BonusNumber(getBonusNumber(), winningLotto.getNumbers());
        division();
    }

    private static String getBonusNumber() {
        return InputView.inputBonusNumber();
    }

    private static void showWinningStatistics() {
        Statistics statistics = new Statistics(purchaseLottos, winningLotto, bonusNumber);
        OutputView.printWinningResult(statistics.getWinningMap());
        OutputView.printRateOfReturn(purchaseLottos.getPurchaseAmount(), statistics.getReward());
    }

    private static void division() {
        System.out.println();
    }
}
