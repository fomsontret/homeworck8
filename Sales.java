public class Sales extends Deal {

    public Sales(String productName, int price) {
        super("Продажа " + productName + " на " + price + " руб.",
                0,
                price);
    }
}