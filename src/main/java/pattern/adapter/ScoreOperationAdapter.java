package pattern.adapter;

/**
 *
 * @author anfeel
 * @version $ Id:ScoreOperationAdapter, v 0.1 2020年01月18日 21:53 anfeel Exp $
 */
public class ScoreOperationAdapter implements ScoreOperation {

    private QuickSort quickSort;
    private BinarySearch binarySearch;

    public ScoreOperationAdapter() {
        quickSort = new QuickSort();
        binarySearch = new BinarySearch();
    }

    @Override
    public void sort(int[] arr) {
        quickSort.quickSort(arr);
    }

    @Override
    public boolean search(int[] arr, int score) {
        return binarySearch.binarySearch(arr, score);
    }
}
