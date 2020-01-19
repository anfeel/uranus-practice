package pattern.composite.base;

/**
 *
 * @author anfeel
 * @version $ Id:Client, v 0.1 2020年01月19日 21:05 anfeel Exp $
 */
public class Client {
    public static void main(String[] args) {
        Folder folder1 = new Folder("欧洲足球俱乐部");
        Folder folder2 = new Folder("英超");
        Folder folder3 = new Folder("利物浦");
        ImageFile image1 = new ImageFile("马内");
        ImageFile image2 = new ImageFile("范戴克");
        TextFile text1 = new TextFile("英超射手榜");
        TextFile text2 = new TextFile("队内评分榜");
        folder3.addImage(image1);
        folder3.addImage(image2);
        folder3.addText(text2);
        folder2.addText(text1);
        folder2.addFolder(folder3);
        folder1.addFolder(folder2);
        folder1.killVirus();
    }
}
