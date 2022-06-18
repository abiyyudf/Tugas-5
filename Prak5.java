/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication81;

/**
 *
 * @author abiyy
 */
public class JavaApplication81 {

    /**
     * @param args the command line arguments
     */
        public static void main(String[] args) {
        CarRider ming = new CarRider("Lin Ming", 19, "08000000000");
        CarRider youhan = new CarRider("Bei Youhan", 20, "08111111111");
        CarRider ling = new CarRider("Ling'er", 31, "08122222222");

        CarData data = new CarData();
        data.addCar("SUV", "N 1111 AB", "Honda");
        data.addCar("SPORT", "N 2222 AB", "SSC Tuatara");
        data.addCar("TRUCK", "N 3333 AB", "Suzuki");

        data.listOfCar();
        System.out.println();

        RentArchive arsip = new RentArchive();
        arsip.Rent(ming, data.carList.get(1), 9);
        arsip.Rent(youhan, data.carList.get(0), 3);
        arsip.Rent(ling, data.carList.get(1), 1);

        System.out.println();
        arsip.info();

    }
}

public class RentArchive {
    ArrayList<CarRent> rentData;

    public RentArchive() {
        rentData = new ArrayList<>();
    }

    public void Rent(CarRider rider, Car car, int rentDur) {

        if (car.isStatus() == true) {
            System.out.println("MOBIL BERHASIL DISEWA");
            car.setStatus(false);
            rentData.add(new CarRent(rider, car, rentDur));
        } else {
            System.out.println("MAAF, MOBIL SUDAH DISEWA");
        }
    }

    public void info() {
        System.out.println("------------------------------");
        System.out.println("INFORMASI PELANGGAN");
        System.out.println("------------------------------");
        rentData.stream().map((i) -> {
            System.out.println("NAMA PEMINJAM : " + i.getRider().getName());
            return i;
        }).map((i) -> {
            System.out.println("TIPE MOBIL : " + i.getCar().getCarType());
            return i;
        }).map((i) -> {
            System.out.println("NO. POLISI : " + i.getCar().getPolNum());
            return i;
        }).forEachOrdered((i) -> {
            System.out.println("LAMA RENTAL : " + i.getRentDur());
        });

    }

}

public class CarRent {
    private int rentDur;
    private Car car;
    private CarRider rider;

    public CarRent(CarRider rider, Car car, int rentDur) {
        this.rentDur = rentDur;
        this.car = car;
        this.rider = rider;
    }

    public int getRentDur() {
        return rentDur;
    }

    public void setRentDur(int rentDur) {
        this.rentDur = rentDur;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public CarRider getRider() {
        return rider;
    }

    public void setRider(CarRider rider) {
        this.rider = rider;
    }
}

public class Car {
    private String carType;
    private String polNum;
    private String merk;
    private boolean status = true;

    public Car(String carType, String polNum, String merk) {
        this.carType = carType;
        this.polNum = polNum;
        this.merk = merk;

    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getPolNum() {
        return polNum;
    }

    public void setPolNum(String polNum) {
        this.polNum = polNum;
    }

    public String getMerk() {
        return merk;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

}

public class CarData {
    ArrayList<Car> carList;

    public CarData() {
        carList = new ArrayList<>();
    }

    public void addCar(String carType, String polNum, String merk) {
        carList.add(new Car(carType, polNum, merk));
    }

    public void listOfCar() {
        System.out.println("------------------------------");
        System.out.println("DAFTAR MOBIL");
        System.out.println("------------------------------");
        carList.stream().map((i) -> {
            System.out.print("TIPE MOBIL : " + i.getCarType());
            return i;
        }).map((i) -> {
            System.out.println();
            return i;
        }).map((i) -> {
            System.out.print("No. POLISI : " + i.getPolNum());
            return i;
        }).map((i) -> {
            System.out.println();
            return i;
        }).map((i) -> {
            System.out.print("MERK MOBIL : " + i.getMerk());
            return i;
        }).map((_item) -> {
            System.out.println();
            return _item;
        }).forEachOrdered((_item) -> {
            System.out.println("------------------------------");
        });
    }
}

public class CarRider {
    private String name;
    private int age;
    private String phone;

    public CarRider(String name, int age, String phone) {
        this.name = name;
        this.age = age;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}