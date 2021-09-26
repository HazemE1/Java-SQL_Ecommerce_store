package Model;


import Controller.DBController;

public class Supplier {
    private String supplierName;
    private String supplierPhone;
    private String supplierAddress;
    private DBController dbController;


    public Supplier(String supplierName, String supplierAddress, String supplierPhone, DBController dbController) {
        this.supplierName = supplierName;
        this.supplierAddress = supplierAddress;
        this.supplierPhone = supplierPhone;
        this.dbController = dbController;
    }

    public String getSupplierName() {
        return supplierName;
    }
    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }
    public String getSupplierPhone() {
        return supplierPhone;
    }
    public void setSupplierPhone(String supplierPhone) {
        this.supplierPhone = supplierPhone;
    }
    public String getSupplierAddress() {
        return supplierAddress;
    }
    public void setSupplierAddress(String supplierAddress) {
        this.supplierAddress = supplierAddress;
    }
}
