package pattern.composite.adv;


/**
 *
 * @author anfeel
 * @version $ Id:Client, v 0.1 2020年01月19日 22:00 anfeel Exp $
 */
public class Client {
    public static void main(String[] args) {
        Folder folder1 = new Folder("欧洲足球俱乐部");
        Folder folder2 = new Folder("英超");
        Folder folder3 = new Folder("利物浦");
        ImageFile image1 = new ImageFile("萨拉赫");
        ImageFile image2 = new ImageFile("C罗");
        TextFile text1 = new TextFile("英超射手榜");
        TextFile text2 = new TextFile("队内评分榜");
        folder1.add(folder2);
    }
}
