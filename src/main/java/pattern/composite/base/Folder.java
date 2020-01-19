package pattern.composite.base;

import java.util.ArrayList;

/**
 *
 * @author anfeel
 * @version $ Id:Folder, v 0.1 2020年01月19日 20:46 anfeel Exp $
 */
public class Folder {
    private String name;
    private ArrayList<Folder> folderList = new ArrayList<>();
    private ArrayList<ImageFile> imageList = new ArrayList<>();
    private ArrayList<TextFile> textList = new ArrayList<>();

    public Folder(String name) {
        this.name = name;
    }

    public void addFolder(Folder f) {
        folderList.add(f);
    }

    public void addImage(ImageFile image) {
        imageList.add(image);
    }

    public void addText(TextFile text) {
        textList.add(text);
    }

    public void killVirus() {
        System.out.println(" start killing virus   , folder name :" + name);

        for (Folder folder : folderList) {
            folder.killVirus();
        }

        for (ImageFile image : imageList) {
            image.killVirus();
        }

        for (TextFile text : textList) {
            text.killVirus();
        }
    }
}
