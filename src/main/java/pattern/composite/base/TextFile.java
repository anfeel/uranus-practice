package pattern.composite.base;

/**
 *
 * @author anfeel
 * @version $ Id:TextFile, v 0.1 2020年01月18日 22:17 anfeel Exp $
 */
public class TextFile {

    private String name;

    public TextFile(String name) {
        this.name = name;
    }

    public void killVirus() {
        System.out.println("文本文件" + this.name + "杀毒");
    }
}
