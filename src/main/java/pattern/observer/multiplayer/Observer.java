package pattern.observer.multiplayer;

/**
 * 
 * @author anfeel
 * @version $Id: Observer.java, v 0.1 2020年1月7日 下午1:43:55 anfeel Exp $
 */
public interface Observer {

    public String getName();

    public void setName(String name);

    public void help();

    public void beAttacked(AllyControlCenter acc);
}
