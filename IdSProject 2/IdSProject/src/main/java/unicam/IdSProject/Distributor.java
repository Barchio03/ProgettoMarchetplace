package unicam.IdSProject;

public class Distributor {

    private int id;

    public Distributor(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public ProductPackage createPackage() {
        return null;
    }

    public boolean deletePackage() {
        return false;
    }

    public boolean addInfo(Product product) {
        return false;
    }
}
