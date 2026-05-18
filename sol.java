 class MergeSort {

    void merge(int arr[], int left, int mid, int right) {

        int n1 = mid - left + 1;
        int n2 = right - mid;

        int L[] = new int[n1];
        int R[] = new int[n2];

        // Copy data to temporary arrays
        for (int i = 0; i < n1; i++)
            L[i] = arr[left + i];

        for (int j = 0; j < n2; j++)
            R[j] = arr[mid + 1 + j];

        int i = 0, j = 0;
        int k = left;

        // Merge the temp arrays
        while (i < n1 && j < n2) {

            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    void sort(int arr[], int left, int right) {

        if (left < right) {

            int mid = (left + right) / 2;

            // Sort first half
            sort(arr, left, mid);

            // Sort second half
            sort(arr, mid + 1, right);

            // Merge both halves
            merge(arr, left, mid, right);
        }
    }

    public static void main(String args[]) {

        int arr[] = {5, 2, 4, 1, 3};

        MergeSort obj = new MergeSort();

        obj.sort(arr, 0, arr.length - 1);

        System.out.println("Sorted array:");

        for (int num : arr)
            System.out.print(num + " ");
    }
}
