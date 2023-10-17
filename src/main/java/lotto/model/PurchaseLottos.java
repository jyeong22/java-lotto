package lotto.model;

import lotto.controller.Lotto;
import lotto.controller.RandomUtility;

import java.util.ArrayList;
import java.util.List;

public class PurchaseLottos {

    private int purchaseAmount;
    private int purchaseQuantity;
    private List<Lotto> purchaseLottoList = new ArrayList<>();
    
    public PurchaseLottos(String stringPurchaseAmount){
        setPurchaseAmount(validate(stringPurchaseAmount));
        setPurchaseQuantity();
        setPurchaseLottoList();
    }

    private void setPurchaseLottoList(){
        while(purchaseLottoList.size()!=purchaseQuantity){
            Lotto lotto = new Lotto(new RandomUtility().getRandomNumber());
            purchaseLottoList.add(lotto);
        }
    }

    private void setPurchaseQuantity() {
        purchaseQuantity = purchaseAmount/1000;
    }

    private void setPurchaseAmount(String stringPurchaseAmount) {
        purchaseAmount = stringToInt(stringPurchaseAmount);
    }

    private String validate(String stringPurchaseAmount) {
        if(isEmpty(stringPurchaseAmount)){
            throw new IllegalArgumentException("[ERROR] 값을 입력해주세요.");
        }
        else if (isNotNumber(stringPurchaseAmount)){
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

    private boolean isMultipleOf1000(Integer intValue) {
        return intValue%1000 == 0;
    }

    private boolean isOverZero(Integer intValue) {
        return intValue>0;
    }

    private Integer stringToInt(String stringValue) {
        return Integer.parseInt(stringValue);
    }

    private boolean isNotNumber(String stringPurchaseAmount) {
        try{
            Integer.parseInt(stringPurchaseAmount);
            return false;
        }
        catch (Exception e){
            return true;
        }
    }

    private boolean isEmpty(String stringPurchaseAmount) {
        return stringPurchaseAmount.isBlank();
    }

    public int getPurchaseQuantity() {
        return purchaseQuantity;
    }

    public List<Lotto> getPurchaseLottoList() {
        return purchaseLottoList;
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }
}
