class Animal {
    protected HealthRecord healthRecord;

    public Animal() {
        this.healthRecord = new HealthRecord();
    }

    public void makeSound() {
        System.out.println("Animal sound");
    }

    public HealthRecord getHealthRecord() {
        return healthRecord;
    }
}

class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Guk-Guk!");
    }
}

class Cat extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Meong!");
    }
}

class HealthRecord {
    private static int counter = 1;
    private int recordNumber;
    private String createdDate;

    public HealthRecord() {
        this.recordNumber = counter++;
        this.createdDate = "15-05-2025"; 
    }

    public int getRecordNumber() {
        return recordNumber;
    }

    public String getCreatedDate() {
        return createdDate;
    }
}

class Owner {
    private String name;
    private Animal pet;

    public Owner(String name, Animal pet) {
        this.name = name;
        this.pet = pet;
    }

    public void showInfo() {
        System.out.println("Nama Pemilik: " + name);
        System.out.print("Suara Hewan: ");
        pet.makeSound();

        if (pet instanceof Dog) {
            System.out.println("Jenis Hewan: Anjing");
        } else if (pet instanceof Cat) {
            System.out.println("Jenis Hewan: Kucing");
        } else {
            System.out.println("Jenis Hewan: Tidak Diketahui");
        }

        HealthRecord hr = pet.getHealthRecord();
        System.out.println("Nomor Rekam Medis: " + hr.getRecordNumber());
        System.out.println("Tanggal Rekam Medis: " + hr.getCreatedDate());
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {
        Owner pemilik1 = new Owner("Jennie", new Dog());
        Owner pemilik2 = new Owner("Lucas", new Cat());

        pemilik1.showInfo();
        pemilik2.showInfo();
    }
}
