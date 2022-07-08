package test.product.models;

public class ImportProduct extends Product {
    private double importCostProduct;
    private String provinceImport;
    private double importTax;

    public ImportProduct() {
    }

    public ImportProduct(double importCostProduct, String provinceImport, double importTax) {
        this.importCostProduct = importCostProduct;
        this.provinceImport = provinceImport;
        this.importTax = importTax;
    }

    public ImportProduct(int idProduct, String codeProduct, String nameProduct, double costProduct, int quanlityProduct, String manufacture, double importCostProduct, String provinceImport, double importTax) {
        super(idProduct, codeProduct, nameProduct, costProduct, quanlityProduct, manufacture);
        this.importCostProduct = importCostProduct;
        this.provinceImport = provinceImport;
        this.importTax = importTax;
    }

    public double getImportCostProduct() {
        return importCostProduct;
    }

    public void setImportCostProduct(double importCostProduct) {
        this.importCostProduct = importCostProduct;
    }

    public String getProvinceImport() {
        return provinceImport;
    }

    public void setProvinceImport(String provinceImport) {
        this.provinceImport = provinceImport;
    }

    public double getImportTax() {
        return importTax;
    }

    public void setImportTax(double importTax) {
        this.importTax = importTax;
    }

    public String getData() {
        return super.getData() + "," + getImportCostProduct() + "," + getProvinceImport() + "," + getImportTax();
    }

    @Override
    public String toString() {
        return "ImportProduct{" + super.toString() +
                "importCostProduct=" + importCostProduct +
                ", provinceImport='" + provinceImport + '\'' +
                ", importTax=" + importTax +
                "} ";
    }
}
