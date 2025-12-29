import taxes.TaxSystem;

public class Company {

    private String title;
    private int debit;
    private int amount;
    private int credit;
    private TaxSystem taxSystem;

    public  Company (String title, TaxSystem taxSystem) {
        this.title = title;
        this.taxSystem = taxSystem;
        this.debit = 0;
        this.credit = 0;
    }

    public void shiftMoney(int amount) {
        if (amount > 0) {
            debit += amount;
        } else if (amount < 0){
            credit += Math.abs(amount);
        }
    }

    public void setTaxSystem(TaxSystem taxSystem) {
        this.taxSystem = taxSystem;
    }

    public void payTaxes() {
        int tax = taxSystem.calcTaxFor(debit, credit);
        System.out.println("Компания " + title + " уплатила налог в размере: " + tax + " руб.");
        debit = 0;
        credit = 0;
    }

    public int applyDeals(Deal[] deals) {
        // Применяем все сделки
        for (Deal deal : deals) {
            this.debit += deal.debitChange;
            this.credit += deal.creditChange;
            System.out.println("Компания " + title + ": " + deal.comment);
        }

        // Сохраняем разницу доходов и расходов на момент уплаты налогов
        int profitBeforeTaxes = debit - credit;

        // Выплачиваем налоги
        payTaxes();

        // Возвращаем разницу доходов и расходов
        return profitBeforeTaxes;
    }
}