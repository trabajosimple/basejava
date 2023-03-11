/**
 * Initial resume class
 */
public class Resume {

    // Unique identifier
    String uuid;

    public  Resume(){
    }

    public Resume(Resume r){
        this.uuid = r.uuid;
    }

    @Override
    public String toString() {
        return uuid;
    }
}
