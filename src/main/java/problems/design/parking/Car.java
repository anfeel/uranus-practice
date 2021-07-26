package problems.design.parking;

/**
 *
 * @author anfeel
 * @version $ Id:Car, v 0.1 2021年07月26日 8:56 anfeel Exp $
 */
public class Car {

    public static final String STATUS_IN = "in";

    public static final String STATUS_OUT = "OUT";

    private int no;

    private String status;

    public Car(int no, String status) {
        this.no = no;
        this.status = status;
    }

    public void park() {
        this.status = STATUS_IN;
    }

    public void get() {
        this.status = STATUS_OUT;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
