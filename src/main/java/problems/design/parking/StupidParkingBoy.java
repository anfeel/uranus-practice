package problems.design.parking;

import java.util.List;

/**
 *
 * @author anfeel
 * @version $ Id:StupidParkingBoy, v 0.1 2021年07月26日 9:25 anfeel Exp $
 */
public class StupidParkingBoy extends ParkingBoy {

    public StupidParkingBoy(String name, List<ParkingLot> list) {
        this.name = name;
        this.list = list;
        this.ptr = 0;
    }

    @Override
    protected void park(List<ParkingLot> list, Car car) {
        if (car == null || car.getNo() <= 0) {
            throw new RuntimeException("this car is illegal");
        }
        if (list == null | list.size() == 0) {
            throw new RuntimeException("we have no parkingLot");
        }
        ParkingLot lot = list.get(this.ptr);
        System.out.println("lot " + lot.getNo() + " parking");
        lot.parkCar(car);
        afterPark();
    }

    private void afterPark() {
        this.ptr++;
        if (this.ptr == list.size()) {
            this.ptr = 0;
        }
    }
}
