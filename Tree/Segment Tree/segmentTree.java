public class segmentTree {
    int n;
    int segT[];

    void build(int arr[], int curr, int low, int high) {
        if (low == high) {
            segT[curr] = arr[low];
        } else {
            int mid = (low) + (high - low) / 2;
            build(arr, curr * 2, low, mid);
            build(arr, curr * 2 + 1, mid + 1, high);
            segT[curr] = segT[curr * 2] + segT[curr * 2 + 1];
        }
    }
    

    int sum(int curr, int low, int high, int l, int r) {
        if (l > r) {
            return 0;
        }
        if (l == low && r == high) {
            return segT[curr];
        }
        int mid = (low) + (high - low) / 2;
        return sum(curr * 2, low, mid, l, Math.min(r, mid)) +
                sum(curr * 2 + 1, mid + 1, high, Math.max(l, mid + 1), r);
    }
    
    void update(int curr, int low, int high, int pos, int val) {
        if (low == high) {
            segT[curr] = val;
        } else {
            int mid = (low) + (high - low) / 2;
            if (pos <= mid) {
                update(curr*2, low, mid, pos, val);
            } else {
                update(curr * 2 + 1, mid + 1, high, pos, val);
            }
            segT[curr] = segT[curr * 2] + segT[curr * 2 + 1];
        }
    }

    public static void main(String[] args) {
        int arr[] = {1, 3, 5, 7, 9, 11};
        int n = arr.length;
        segmentTree tree = new segmentTree();
        tree.n = n;
        tree.segT = new int[4 * n];
        tree.build(arr, 1, 0, n - 1);
        System.out.println(tree.sum(1, 0, n - 1, 1, 3));
        tree.update(1, 0, n - 1, 1, 10);
        System.out.println(tree.sum(1, 0, n - 1, 1, 3));
    }
}