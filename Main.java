import taxes.UsnIncome;
import taxes.UsnIncomeMinusExpenses;

public class Main {

        public static void main(String[] args) {
            System.out.println("=== Тест 1: Базовый тест работы сделок ===");
            Company company1 = new Company("ООО ТехноМир", new UsnIncome());

            Deal[] deals1 = {
                    new Sales("Компьютер", 50000),
                    new Expenditure("Канцелярия", 5000),
                    new Sales("Монитор", 20000)
            };

            int profit = company1.applyDeals(deals1);
            System.out.println("Прибыль до налогообложения: " + profit + " руб.\n");

            System.out.println("=== Тест 2: С УСН доходы-расходы ===");
            Company company2 = new Company("ИП Петров", new UsnIncomeMinusExpenses());

            Deal[] deals2 = {
                    new Sales("Услуги ремонта", 80000),
                    new Expenditure("Инструменты", 25000),
                    new Sales("Консультация", 15000),
                    new Expenditure("Транспорт", 5000)
            };

            profit = company2.applyDeals(deals2);
            System.out.println("Прибыль до налогообложения: " + profit + " руб.\n");

            System.out.println("=== Тест 3: Комбинирование shiftMoney и applyDeals ===");
            Company company3 = new Company("ООО Гибрид", new UsnIncome());


            company3.shiftMoney(30000);
            company3.shiftMoney(-10000);


            Deal[] deals3 = {
                    new Sales("Товар А", 40000),
                    new Expenditure("Упаковка", 3000)
            };

            profit = company3.applyDeals(deals3);
            System.out.println("Прибыль до налогообложения: " + profit + " руб.\n");

            System.out.println("=== Тест 4: Проверка наследования и полиморфизма ===");
            Company company4 = new Company("ООО Торговая", new UsnIncomeMinusExpenses());


            Deal[] mixedDeals = new Deal[4];
            mixedDeals[0] = new Sales("Холодильник", 40000);
            mixedDeals[1] = new Expenditure("Доставка", 3000);
            mixedDeals[2] = new Sales("Телевизор", 60000);
            mixedDeals[3] = new Expenditure("Реклама", 10000);

            profit = company4.applyDeals(mixedDeals);
            System.out.println("Прибыль до налогообложения: " + profit + " руб.\n");

            System.out.println("=== Тест 5: Крайние случаи ===");
            Company company5 = new Company("ООО Экстрим", new UsnIncomeMinusExpenses());


            Deal zeroDeal = new Sales("Бесплатный образец", 0);
            
            Deal[] extremeDeals = {
                    zeroDeal,
                    new Expenditure("Дорогое оборудование", 500000),
                    new Sales("Мега-продажа", 1000000)
            };

            profit = company5.applyDeals(extremeDeals);
            System.out.println("Прибыль до налогообложения: " + profit + " руб.");
        }
    }
