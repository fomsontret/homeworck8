public class Expenditure extends Deal {

    public Expenditure(String productName, int price) {
        super("Покупка " + productName + " на " + price + " руб.",
                price,
                0);
    }
}