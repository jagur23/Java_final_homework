import java.util.Objects;

public class Laptop {
    
    private int id;
    private int ram;
    private int hdd;
    private String trademark;
    private String operatingSystem;
    private String color;
    private int price;


    public Laptop(int id, int ram, int hdd, String trademark, String operatingSystem, String color){
        this.id = id;
        this.ram = ram;
        this.hdd = hdd;
        this.trademark = trademark;
        this.operatingSystem = operatingSystem;
        this.color = color;
    }

    public int getId(){
        return id;
    }

    public int getRam(){
        return ram;
    }

    public int getHdd(){
        return hdd;
    }

    public String getTrademark(){
        return trademark;
    }

    public String getOperatingSystem(){
        return operatingSystem;
    }

    public String getColor(){
        return color;
    }

    public int getPrice(){
        if(this.price == 0){
            System.out.println("Price not set!");
            return -1;
        }
        return price;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setRam(int ram){
        this.ram = ram;
    }

    public void setHdd(int hdd){
        this.hdd = hdd;
    }

    public void setTrademark(String trademark){
        this.trademark = trademark;
    }

    public void setOperatingSystem(String operatingSystem){
        this.operatingSystem = operatingSystem;
    }

    public void setColor(String color){
        this.color = color;
    }

    public void setPrice(int price){
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("ID: %d / RAM: %d / HDD: %d / Trademark: %s / OS: %s / color: %s", id, ram, hdd, trademark, operatingSystem, color);
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }
        
        if(obj == null || getClass() != obj.getClass()){
            return false;
        }

        Laptop laptop = (Laptop) obj;
        return id == laptop.id && ram == laptop.ram && hdd == laptop.hdd && trademark.equals(laptop.trademark) && 
            operatingSystem.equals(laptop.operatingSystem) && color.equals(laptop.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ram, hdd, trademark, operatingSystem, color);
    }
}
