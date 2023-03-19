/**
 * Initial resume class
 */
public class Resume {
    // Unique identifier
    String uuid;

    public Resume() {
    }

    public Resume(Resume r) {
        this.uuid = r.uuid;
    }

    public String getUuid() {
        return uuid;
    }

    @Override
    public String toString() {
        return uuid;
    }
}
