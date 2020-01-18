package pattern.adapter;

/**
 *
 * @author anfeel
 * @version $ Id:ScoreOpertion, v 0.1 2020年01月18日 20:43 anfeel Exp $
 */
public interface ScoreOperation {
    void sort(int[] arr);

    boolean search(int[] arr, int score);
}
