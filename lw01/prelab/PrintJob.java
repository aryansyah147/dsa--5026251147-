/**
 * Abstract base class for all print jobs.
 * Holds shared state (id, pages) and shared behaviour (label, summary,
 * the calculateCharge(copies) overload), while leaving the per-page
 * pricing rule (calculateCharge()) to concrete subclasses.
 */
public abstract class PrintJob implements Chargeable {

    private String id;
    private int pages;

    protected PrintJob(String id, int pages) {
        if (pages <= 0) {
            throw new IllegalArgumentException("pages must be positive");
        }
        this.id = id;
        this.pages = pages;
    }

    public String getId() {
        return id;
    }

    public int getPages() {
        return pages;
    }

    // Abstract declaration implementing the interface method.
    @Override
    public abstract int calculateCharge();

    // Overload: same name, different parameter list (copies).
    // Implemented once here so subclasses do not duplicate it.
    public int calculateCharge(int copies) {
        if (copies <= 0) {
            throw new IllegalArgumentException("copies must be positive");
        }
        return copies * calculateCharge();
    }

    public String label() {
        return "Print";
    }

    public String summary() {
        return getId() + " | " + label() + " | " + calculateCharge();
    }
}
