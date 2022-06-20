package model.Manufacture;

public class Manufacture {
    private String productId;
    private String name;
    private String nation;

    public Manufacture(String name, String productId, String nation) {
        this.name = name;
        this.productId = productId;
        this.nation = nation;
    }



    public String getName() {
        return name;
    }

    public String getNation() {
        return nation;
    }

    public String getProductId() {
        return productId;
    }

    @Override
    public String toString() {
        return "Manufacture is " +
                "productId='" + productId + '\'' +
                ", name='" + name + '\'' +
                ", nation='" + nation + '\'';
    }
}
