package proyekAkhir.JSN.mygadget.models.Laptop;

import java.util.List;

public class SpecsModel {

    private String laptop_id;
    private String laptop_name;
    private String price;
    private String dimension;
    private String gpu;
    private String cpu;
    private String storage;

    public String getLaptop_id() {
        return laptop_id;
    }

    public void setLaptop_id(String laptop_id) {
        this.laptop_id = laptop_id;
    }

    public String getLaptop_name() {
        return laptop_name;
    }

    public void setLaptop_name(String laptop_name) {
        this.laptop_name = laptop_name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    public String getGpu() {
        return gpu;
    }

    public void setGpu(String gpu) {
        this.gpu = gpu;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getStorage() {
        return storage;
    }

    public void setStorage(String storage) {
        this.storage = storage;
    }

    @Override
    public String toString() {
        return "Result{" +
                "laptop_id='" + laptop_id + '\'' +
                ", laptop_name='" + laptop_name + '\'' +
                ", price='" + price + '\'' +
                ", dimension='" + dimension + '\'' +
                ", gpu='" + gpu + '\'' +
                ", cpu='" + cpu + '\'' +
                ", storage='" + storage + '\'' +
                '}';
    }



}