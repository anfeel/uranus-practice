package pattern.composite.adv;

import java.util.ArrayList;

/**
 *
 * @author anfeel
 * @version $ Id:Composite, v 0.1 2020年01月19日 21:36 anfeel Exp $
 */
public class Folder extends AbstractFile {

    private String name;

    private ArrayList<AbstractFile> list = new ArrayList<>();

    public Folder(String name) {
        this.name = name;
    }

    @Override
    public void killVirus() {
        for (AbstractFile child : list)
            child.killVirus();
    }

    @Override
    public void add(AbstractFile c) {
        list.add(c);
    }

    @Override
    public void remove(AbstractFile c) {
        list.remove(c);
    }

    @Override
    public Folder getChild(int i) {
        return (Folder) list.get(i);
    }
}
