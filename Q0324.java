import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Q0324 {
    private static final Random rand = new Random();

    public static int quickSelect(int[] L, int k) {
        if (L.length == 1) {
            return L[0];
        }
        int pivotIdx = rand.nextInt(L.length - 1);
        int pivot = L[pivotIdx];
        int[] left = Arrays.stream(L).filter(x -> x < pivot).toArray();
        int[] right = Arrays.stream(L).filter(x -> x > pivot).toArray();
        if (k < left.length) {
            return quickSelect(left, k);
        } else if (k < L.length - right.length) {
            return pivot;
        } else {
            return quickSelect(right, k - (L.length - right.length));
        }
    }

    public static void wiggleSort(int[] nums) {
        int medianIdx;
        if (nums.length % 2 == 0) {
            medianIdx = nums.length / 2 - 1;
        } else {
            medianIdx = nums.length / 2;
        }
        int median = quickSelect(nums, nums.length / 2 + 1);
        List<Integer> left = Arrays.stream(nums).filter(x -> x < median).boxed().collect(Collectors.toList());
        List<Integer> middle = Arrays.stream(nums).filter(x -> x == median).boxed().collect(Collectors.toList());
        List<Integer> right = Arrays.stream(nums).filter(x -> x > median).boxed().collect(Collectors.toList());
        left.addAll(middle);
        left.addAll(right);
        int leftCount = (left.size() - 1) / 2;
        int rightCount = left.size() - 1;
        for (int i = 0; i < left.size(); i++) {
            if (i % 2 == 0) {
                nums[i] = left.get(leftCount);
                leftCount--;

            } else {
                nums[i] = left.get(rightCount);
                rightCount--;
            }
        }
    }

    public static void main(String[] args) {
        int[] L = new int[]{1, 4, 3, 4, 1, 2, 1, 3, 1, 3, 2, 3, 3};
        wiggleSort(L);
        System.out.println(L);
    }
}
