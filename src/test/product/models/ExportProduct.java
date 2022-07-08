package test.product.models;

public class ExportProduct extends Product {
    private double exportCostProduct;
    private String exportCountry;

    public ExportProduct() {
    }

    public ExportProduct(double exportCostProduct, String exportCountry) {
        this.exportCostProduct = exportCostProduct;
        this.exportCountry = exportCountry;
    }

    public ExportProduct(int idProduct, String codeProduct, String nameProduct, double costProduct, int quanlityProduct, String manufacture, double exportCostProduct, String exportCountry) {
        super(idProduct, codeProduct, nameProduct, costProduct, quanlityProduct, manufacture);
        this.exportCostProduct = exportCostProduct;
        this.exportCountry = exportCountry;
    }

    public double getExportCostProduct() {
        return exportCostProduct;
    }

    public void setExportCostProduct(double exportCostProduct) {
        this.exportCostProduct = exportCostProduct;
    }

    public String getExportCountry() {
        return exportCountry;
    }

    public void setExportCountry(String exportCountry) {
        this.exportCountry = exportCountry;
    }

    public String getData() {
        return super.getData() + "," + getExportCostProduct() + "," + getExportCountry();
    }

    @Override
    public String toString() {
        return "ExportProduct{" + super.toString() +
                "exportCostProduct=" + exportCostProduct +
                ", exportCountry='" + exportCountry + '\'' +
                "} ";
    }
}
