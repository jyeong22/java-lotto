package lotto.controller;

import lotto.model.BonusNumber;
import lotto.model.PurchaseLottos;
import lotto.model.Statistics;
import lotto.model.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class GameController {

    private static PurchaseLottos purchaseLottos;
    private static WinningLotto winningLotto;
    private static BonusNumber bonusNumber;
    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();

    public static void proceedGame(){
        buyLottos();
        setWinningNumber();
        setBonusNumber();
        showWinningStatistics();
    }

    private static void buyLottos() {
        setPurchaseLottos();
        division();
        showPurchaseLottos();
        division();
    }

    private static void division() {
        System.out.println();
    }

    private static void setPurchaseLottos() {
        purchaseLottos = new PurchaseLottos(getPurchaseAmount());
    }

    private static String getPurchaseAmount() {
        return inputView.inputPurchaseAmount();
    }

    private static void showPurchaseLottos() {
        outputView.printPurchaseLottos(purchaseLottos);
    }

    private static void setWinningNumber() {
        winningLotto = new WinningLotto(getWinningNumber());
        division();
    }

    private static String getWinningNumber() {
        return inputView.inputWinningNumber();
    }

    private static void setBonusNumber() {
        bonusNumber = new BonusNumber(getBonusNumber(), winningLotto.getWinningLottoNumber());
        division();
    }

    private static String getBonusNumber() {
        return inputView.inputBonusNumber();
    }

    private static void showWinningStatistics() {
        Statistics statistics = new Statistics(purchaseLottos, winningLotto, bonusNumber);
        outputView.printWinningResult(statistics.getWinningMap());
        outputView.printRateOfReturn(purchaseLottos.getPurchaseAmount(), statistics.getReward());
    }

}
