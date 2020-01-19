package pattern.composite.base;

/**
 *
 * @author anfeel
 * @version $ Id:ImageFile, v 0.1 2020年01月18日 22:14 anfeel Exp $
 */
public class ImageFile {
    private String name;

    public ImageFile(String name) {
        this.name = name;
    }

    public void killVirus() {
        System.out.println("图像文件" + this.name + "杀毒");
    }
}

