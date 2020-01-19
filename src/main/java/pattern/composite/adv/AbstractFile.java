package pattern.composite.adv;

/**
 *
 * @author anfeel
 * @version $ Id:Component, v 0.1 2020年01月19日 21:34 anfeel Exp $
 */
public abstract class AbstractFile {

    public abstract void killVirus();

    public abstract void add(AbstractFile c);

    public abstract void remove(AbstractFile c);

    public abstract Folder getChild(int i);
}
