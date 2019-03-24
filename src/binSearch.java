class BinarySearch {

    private static int[] nums = {1, 2, 13, 44, 55, 66, 77};

    public static int[] getNums() {
        return nums;
    }

    public static int binSearch(int[] arr, int low, int high, int target) {

        int index = -1;
        int count = 0;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] > target) {
                high = mid - 1;
                count++;
            } else if (arr[mid] < target) {
                low = mid + 1;
                count++;
            } else if (arr[mid] == target) {
                index = mid;
                break;
            }
        }

        if (low > high) {
            return index * count;
        }

        return index;
    }

    public static void main(String[] args) {
        System.out.println(BinarySearch.binSearch(nums, 0, 7, 0));
    }

}