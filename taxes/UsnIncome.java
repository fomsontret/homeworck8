package taxes;

public class UsnIncome extends TaxSystem {
    @Override
    public int calcTaxFor(int debit, int credit) {
        int tax = (int) Math.round(debit * 0.06);
        return Math.max(tax, 0);
    }
}
