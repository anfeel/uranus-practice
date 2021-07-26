package problems.design.parking;

import java.util.List;

/**
 *
 * @author anfeel
 * @version $ Id:ParkingBoy, v 0.1 2021年07月26日 8:56 anfeel Exp $
 */
public abstract class ParkingBoy {

    protected String name;

    protected List<ParkingLot> list;

    protected int ptr;

    protected abstract void park(List<ParkingLot> list, Car car);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ParkingLot> getList() {
        return list;
    }

    public void setList(List<ParkingLot> list) {
        this.list = list;
    }

    public int getPtr() {
        return ptr;
    }

    public void setPtr(int ptr) {
        this.ptr = ptr;
    }
}
