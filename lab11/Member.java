public class Member {
    public static final int MAX_LOANS = 3;

    private final String id;
    private final String name;
    private int activeLoans;

    public Member(String id, String name) {
        if (id == null || id.isBlank())     throw new IllegalArgumentException("Member id required");
        if (name == null || name.isBlank()) throw new IllegalArgumentException("Member name required");
        this.id = id.trim();
        this.name = name.trim();
    }

    public String getId()        { return id; }
    public String getName()      { return name; }
    public int getActiveLoans()  { return activeLoans; }

    void loanAdded() throws LoanLimitExceededException {
        if (activeLoans >= MAX_LOANS) throw new LoanLimitExceededException(name, MAX_LOANS);
        activeLoans++;
    }

    void loanRemoved() { if (activeLoans > 0) activeLoans--; }

    public String toCsv() { return id + "," + name; }

    @Override
    public String toString() {
        return String.format("%-6s %-20s loans: %d/%d", id, name, activeLoans, MAX_LOANS);
    }
}
