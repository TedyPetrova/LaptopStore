package sample;

public class LaptopsRows {
    String Product_id, Brand, Model, Processor, OS, RAM;
    public LaptopsRows(String product_id, String brand, String model, String processor, String RAM, String OS){
        this.Product_id = product_id;
        this.Brand = brand;
        this.Model = model;
        this.Processor = processor;
        this.RAM = RAM;
        this.OS = OS;
    }

    public String getProduct_id() {
        return Product_id;
    }

    public String getBrand() {
        return Brand;
    }

    public String getModel() {
        return Model;
    }

    public String getProcessor() {
        return Processor;
    }

    public String getRAM() {
        return RAM;
    }

    public String getOS() {
        return OS;
    }
}
