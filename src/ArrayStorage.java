import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    int size;

    void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    void save(Resume r)  {
        if(r.uuid != null && !r.uuid.isBlank()){
            storage[size++] = new Resume(r);
        }
    }

    Resume get(String uuid)  {
        for (int i = 0; i < size; i++) {
            if (storage[i].toString().equals(uuid)) {
                return new Resume(storage[i]);
            }
        }
        return null;
    }

    void delete(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].toString().equals(uuid)) {
                Resume[] newStorage = Arrays.copyOfRange(storage, 0, --size);
                if (size > 0) System.arraycopy(storage, 0, newStorage, i, size - i - 1);
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
}
