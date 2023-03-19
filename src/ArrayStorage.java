import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    public final int STORAGE_LIMIT = 10000;
    Resume[] storage = new Resume[STORAGE_LIMIT];
    int size;

    void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    void save(Resume r) {
        if (r.uuid != null && !r.uuid.isBlank() && find(r.uuid) == null) {
            storage[size++] = new Resume(r);
        }
    }

    Resume get(String uuid) {
        Resume r = find(uuid);
        return r == null ? null : new Resume(r);
    }

    void delete(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].toString().equals(uuid)) {
                System.arraycopy(storage, i + 1, storage, i, size - i - 1);
                storage[--size] = null;
                return;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    int size() {
        return size;
    }

    private Resume find(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return storage[i];
            }
        }
        return null;
    }
}
