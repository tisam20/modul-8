class Vehicle {
    public void startEngine() {
        System.out.println("Mesin Nyala");
    }
}

class Car extends Vehicle {
    public void startEngine() {
        System.out.println("Mesin Mobil Nyala");
    }
}

class Motorcycle extends Vehicle {
    public void startEngine() {
        System.out.println("Mesin Motor Nyala");
    }
}

class License {
    private static int counter = 1001; 
    private String licenseNumber;
    private String validUntil;

    public License() {
        this.licenseNumber = "SIM-A-" + counter;
        counter++;
        this.validUntil = "15-05-2030"; 
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public String getValidUntil() {
        return validUntil;
    }
}

class Driver {
    private String name;
    private Vehicle vehicle;
    private License license;

    public Driver(String name, Vehicle vehicle) {
        this.name = name;
        this.vehicle = vehicle;
        this.license = new License();
    }

    public void showInfo() {
        System.out.println("Nama Pengemudi: " + name);

        if (vehicle instanceof Car) {
            System.out.println("Jenis Kendaraan: Mobil");
        } else if (vehicle instanceof Motorcycle) {
            System.out.println("Jenis Kendaraan: Motor");
        } else {
            System.out.println("Jenis Kendaraan: Tidak Diketahui");
        }

        System.out.print("Status Mesin: ");
        vehicle.startEngine();

        System.out.println("Nomor Lisensi: " + license.getLicenseNumber());
        System.out.println("Lisensi Berlaku Sampai: " + license.getValidUntil());
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {
        Driver driver1 = new Driver("Jungkook", new Car());
        Driver driver2 = new Driver("Jaehyun", new Motorcycle());

        driver1.showInfo();
        driver2.showInfo();
    }
}