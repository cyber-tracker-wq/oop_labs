public class SavingsAccount extends Account {
    public SavingsAccount(String id, double openingBalance) { super(id, openingBalance); }

    // Savings: no fee while the balance is at least 500, otherwise a flat 2.00
    @Override public double monthlyFee() { return balance >= 500 ? 0.0 : 2.0; }
}
