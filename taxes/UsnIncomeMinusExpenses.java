package taxes;

public class UsnIncomeMinusExpenses extends TaxSystem {
    @Override
    public int calcTaxFor(int debit, int credit) {
        int difference = debit - credit;
        int tax = (int) Math.round(difference * 0.15);
        return Math.max(tax, 0);
    }
}