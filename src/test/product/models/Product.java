package test.product.models;

public abstract class Product {
    private int idProduct;
    private String codeProduct;
    private String nameProduct;
    private double costProduct;
    private int quanlityProduct;
    private String manufacture;

    public Product() {
    }

    public Product(int idProduct, String codeProduct, String nameProduct, double costProduct, int quanlityProduct, String manufacture) {
        this.idProduct = idProduct;
        this.codeProduct = codeProduct;
        this.nameProduct = nameProduct;
        this.costProduct = costProduct;
        this.quanlityProduct = quanlityProduct;
        this.manufacture = manufacture;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public String getCodeProduct() {
        return codeProduct;
    }

    public void setCodeProduct(String codeProduct) {
        this.codeProduct = codeProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public double getCostProduct() {
        return costProduct;
    }

    public void setCostProduct(double costProduct) {
        this.costProduct = costProduct;
    }

    public int getQuanlityProduct() {
        return quanlityProduct;
    }

    public void setQuanlityProduct(int quanlityProduct) {
        this.quanlityProduct = quanlityProduct;
    }

    public String getManufacture() {
        return manufacture;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }

    public String getData() {
        return getIdProduct() + "," + getCodeProduct() + "," + getNameProduct() + "," + getCostProduct()
                + "," + getQuanlityProduct() + "," + getManufacture();
    }

    @Override
    public String toString() {
        return "Product{" +
                "idProduct=" + idProduct +
                ", codeProduct='" + codeProduct + '\'' +
                ", nameProduct='" + nameProduct + '\'' +
                ", costProduct=" + costProduct +
                ", quanlityProduct=" + quanlityProduct +
                ", manufacture='" + manufacture + '\'' +
                '}';
    }
}
