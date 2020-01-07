package pattern.observer.multiplayer;

/**
 * 
 * @author anfeel
 * @version $Id: Player.java, v 0.1 2020年1月7日 下午1:44:46 anfeel Exp $
 */
public class Player implements Observer {

    private String name;

    /**
     * 
     */
    public Player(String name) {
        this.name = name;
    }

    /** 
     * @see pattern.observer.multiplayer.Observer#getName()
     */
    @Override
    public String getName() {
        return this.name;
    }

    /** 
     * @see pattern.observer.multiplayer.Observer#setName(java.lang.String)
     */
    @Override
    public void setName(String name) {
        this.name = name;
    }

    /** 
     * @see pattern.observer.multiplayer.Observer#help()
     */
    @Override
    public void help() {
        System.out.println(this.getName() + " is coming !");
    }

    /** 
     * @see pattern.observer.multiplayer.Observer#beAttacked(pattern.observer.multiplayer.AllyControlCenter)
     */
    @Override
    public void beAttacked(AllyControlCenter acc) {
        System.out.println(this.name + " be attacked !");
        acc.notifyObserver(this.name);

    }

}
