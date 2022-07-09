package test.electric_bill.models;

import java.util.List;

public class TypeCustomer {
    private String typeCustomer;
    private String usagePattern;


    public TypeCustomer(String typeCustomer, String usagePattern) {
        this.typeCustomer = typeCustomer;
        this.usagePattern = usagePattern;
    }

    public String getTypeCustomer() {
        return typeCustomer;
    }

    public void setTypeCustomer(String typeCustomer) {
        this.typeCustomer = typeCustomer;
    }

    public String getUsagePattern() {
        return usagePattern;
    }

    public void setUsagePattern(String usagePattern) {
        this.usagePattern = usagePattern;
    }

    public String getData() {
        return getTypeCustomer() + "," + getUsagePattern();
    }

    @Override
    public String toString() {
        return "TypeCustomer{" +
                "typeCustomer='" + typeCustomer + '\'' +
                ", usagePattern='" + usagePattern + '\'' +
                '}';
    }
}
