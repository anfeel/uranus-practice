package problems.design.parking;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author anfeel
 * @version $ Id:ParkingLot, v 0.1 2021年07月26日 8:56 anfeel Exp $
 */
public class ParkingLot {

    private int no;

    private int maxSpace;

    private int curSpace;

    private int curCars;

    private Map<Integer, Car> carMap;

    public ParkingLot(int no, int maxSpace) {
        this.no = no;
        this.maxSpace = maxSpace;
        this.curSpace = maxSpace;
        this.curCars = 0;
        this.carMap = new HashMap<>();
    }

    public void parkCar(Car car) {
        if (this.curSpace == 0) {
            throw new RuntimeException("parkingLot have no more space");
        }
        if (car == null || car.getNo() < 0) {
            throw new RuntimeException("this car is illegal");
        }
        if (this.carMap.containsKey(car.getNo())) {
            throw new RuntimeException("this car is already park in");
        }
        car.park();
        System.out.println("car " + car.getNo() + " is park in");
        carMap.put(car.getNo(), car);
        afterPark();
    }


    private void afterPark() {
        this.curSpace--;
        this.curCars++;
    }

    public void getCar(Car car) {
        if (this.curCars == 0) {
            throw new RuntimeException("parkingLot have no car");
        }
        if (car == null || car.getNo() < 0) {
            throw new RuntimeException("this car is illegal");
        }
        if (!this.carMap.containsKey(car.getNo())) {
            throw new RuntimeException("this car is not in");
        }
        car.get();
        System.out.println("car " + car.getNo() + " is out");
        carMap.remove(car.getNo());
        afterGet();
    }

    private void afterGet() {
        this.curSpace++;
        this.curCars--;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public int getMaxSpace() {
        return maxSpace;
    }

    public void setMaxSpace(int maxSpace) {
        this.maxSpace = maxSpace;
    }

    public int getCurSpace() {
        return curSpace;
    }

    public void setCurSpace(int curSpace) {
        this.curSpace = curSpace;
    }

    public int getCurCars() {
        return curCars;
    }

    public void setCurCars(int curCars) {
        this.curCars = curCars;
    }

    public Map<Integer, Car> getCarMap() {
        return carMap;
    }

    public void setCarMap(Map<Integer, Car> carMap) {
        this.carMap = carMap;
    }
}
