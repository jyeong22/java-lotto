package lotto.model;

import lotto.controller.Lotto;
import lotto.controller.RandomUtility;
import java.util.ArrayList;
import java.util.List;

public class PurchaseLottos {
    private int purchaseAmount;
    private int purchaseQuantity;
    private List<Lotto> purchaseLottoList = new ArrayList<>();

    public PurchaseLottos(String stringPurchaseAmount) {
        // comma 생략
        stringPurchaseAmount = removeComma(stringPurchaseAmount);
        setPurchaseAmount(validate(stringPurchaseAmount));
        setPurchaseQuantity();
        setPurchaseLottoList();
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    public int getPurchaseQuantity() {
        return purchaseQuantity;
    }

    public List<Lotto> getPurchaseLottoList() {
        return purchaseLottoList;
    }

    private void setPurchaseAmount(String stringPurchaseAmount) {
        purchaseAmount = stringToInt(stringPurchaseAmount);
    }

    private void setPurchaseQuantity() {
        purchaseQuantity = purchaseAmount/1000;
    }

    private void setPurchaseLottoList(){
        while(purchaseLottoList.size()!=purchaseQuantity){
            Lotto lotto = new Lotto(new RandomUtility().getRandomNumber());
            purchaseLottoList.add(lotto);
        }
    }

    private String validate(String stringPurchaseAmount) {
        if(isEmpty(stringPurchaseAmount)){
            throw new IllegalArgumentException("[ERROR] 값을 입력해주세요.");
        }
        else if (!isDigit(stringPurchaseAmount)){
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요.");
        }
        else if (!isOverZero(stringToInt(stringPurchaseAmount))){
            throw new IllegalArgumentException("[ERROR] 양수가 아닙니다.");
        }
        else if (!isMultipleOf1000(stringToInt(stringPurchaseAmount))){
            throw new IllegalArgumentException("[ERROR] 1000의 배수가 아닙니다.");
        }
        return stringPurchaseAmount;
    }

    private boolean isEmpty(String stringPurchaseAmount) {
        return stringPurchaseAmount == null || stringPurchaseAmount.isBlank();
    }

    private boolean isDigit(String stringPurchaseAmount) {
        return stringPurchaseAmount.chars().allMatch(Character::isDigit);
    }

    private boolean isOverZero(Integer intValue) {
        return intValue>0;
    }

    private boolean isMultipleOf1000(Integer intValue) {
        return intValue%1000 == 0;
    }

    private Integer stringToInt(String stringValue) {
        return Integer.parseInt(stringValue);
    }

    private String removeComma(String stringPurchaseAmount) {
        return stringPurchaseAmount.replace(",", "");
    }
}
