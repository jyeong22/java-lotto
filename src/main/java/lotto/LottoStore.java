package lotto;

public class LottoStore {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void playLottoGame(){
        PurchaseAmount purchaseAmount = new PurchaseAmount(inputView.enterAmount());
        PurchaseLottos purchaseLottos = new PurchaseLottos(purchaseAmount.getNumberOfPurchasedAmount());
        outputView.printNumberOfLottosPurchased(purchaseAmount.getNumberOfPurchasedAmount());
        outputView.printLottosList(purchaseLottos.getPurchaseLottos());
        Lotto winningNumber = new Lotto(inputView.enterWinningNumber());
        BonusNumber bonusNumber = new BonusNumber(winningNumber, inputView.enterBonusNumber());
        WinningStatistics winningStatistics = new WinningStatistics(purchaseLottos.getPurchaseLottos(),
                winningNumber.getNumbers(), bonusNumber.getBonusNumber(), purchaseAmount);
        outputView.printWinningStatistics(winningStatistics);
        outputView.printRateOfReturn(winningStatistics);
    }
}
