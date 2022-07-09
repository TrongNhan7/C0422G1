package test.electric_bill.models;

public class VNCustomer extends Customer {
    private TypeCustomer typeCustomer;
    private int quota;

    public VNCustomer() {
    }

    public VNCustomer(TypeCustomer typeCustomer, int quota) {
        this.typeCustomer = typeCustomer;
        this.quota = quota;
    }

    public VNCustomer(String idCustomer, String nameCustomer, TypeCustomer typeCustomer, int quota) {
        super(idCustomer, nameCustomer);
        this.typeCustomer = typeCustomer;
        this.quota = quota;
    }

    public TypeCustomer getTypeCustomer() {
        return typeCustomer;
    }

    public void setTypeCustomer(TypeCustomer typeCustomer) {
        this.typeCustomer = typeCustomer;
    }

    public int getQuota() {
        return quota;
    }

    public void setQuota(int quota) {
        this.quota = quota;
    }

    public String getData() {
        return super.getData() + "," + getTypeCustomer().getUsagePattern() + "," + getQuota();
    }

    @Override
    public String toString() {
        return "VNCustomer{" + super.toString() +
                "typeCustomer='" + typeCustomer.getUsagePattern() + '\'' +
                ", quota=" + quota +
                "} ";
    }
}
