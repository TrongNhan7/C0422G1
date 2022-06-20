package vehicle_manager.models.Manufacturer;

import vehicle_manager.controller.ManufactureController;

public class Manufacture {
    private String productId;
    private String name;
    private String nation;

    public Manufacture(String productId, String name, String nation) {
        this.name = name;
        this.productId = productId;
        this.nation = nation;
    }

    public Manufacture(String name) {
        this.name = name;
        this.productId = ManufactureController.getProductId(name);
        this.nation = ManufactureController.getNation(name);
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
