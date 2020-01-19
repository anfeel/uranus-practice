package pattern.composite.adv;

/**
 *
 * @author anfeel
 * @version $ Id:TextFile, v 0.1 2020年01月19日 21:56 anfeel Exp $
 */
public class TextFile extends AbstractFile {

    private String name;

    public TextFile(String name) {
        this.name = name;
    }

    @Override
    public void killVirus() {
        System.out.println("文本文件" + this.name + "杀毒");
    }

    @Override
    public void add(AbstractFile c) {

    }

    @Override
    public void remove(AbstractFile c) {

    }

    @Override
    public Folder getChild(int i) {
        return null;
    }
}
