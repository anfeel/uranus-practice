package pattern.adapter;

/**
 *
 * @author anfeel
 * @version $ Id:Client, v 0.1 2020年01月18日 21:59 anfeel Exp $
 */
public class Client {
    public static void main(String[] args) {
        ScoreOperationAdapter adapter = new ScoreOperationAdapter();
        adapter.sort(new int[]{1, 2, 3});
        adapter.search(new int[]{1, 2, 3}, 4);
    }
}
