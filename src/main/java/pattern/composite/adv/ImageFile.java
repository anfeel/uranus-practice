package pattern.composite.adv;

/**
 *
 * @author anfeel
 * @version $ Id:Leaf, v 0.1 2020年01月19日 21:48 anfeel Exp $
 */
public class ImageFile extends AbstractFile {

    private String name;

    public ImageFile(String name) {
        this.name = name;
    }

    @Override
    public void killVirus() {
        System.out.println("图像文件" + this.name + "杀毒");
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
