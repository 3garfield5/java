package lab2;

public abstract class Institution {
    private String name;
    private String address;

    public Institution(String name, String address){
        this.address = address;
        this.name = name;
    }

    public Institution(){
        this.address = "Неизвестный адрес";
        this.name = "Неизвестное учреждение";
    }

    public Institution(String name) {
        this.name = name;
        this.address = "Неизвестный адрес";
    }

    public Institution(String address, boolean isAddressOnly) {
        this.address = address;
        this.name = "Неизвестное учреждение"; // Значение по умолчанию для имени
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public abstract void describe();

    @Override
    public String toString(){
        return "Establishment{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';

    }
}
