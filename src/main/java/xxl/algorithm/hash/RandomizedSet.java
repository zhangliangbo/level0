package xxl.algorithm.hash;

import java.util.*;
import java.util.stream.IntStream;

/**
 * 插入、删除和随机访问都是O（1）的容器
 * <p>
 * Map提供O(1)的插入和删除操作，Array提供O(1)的随机访问操作
 *
 * @author zhangliangbo
 * @since 2021/11/8
 **/


public class RandomizedSet {

    private Map<Integer, Integer> numToLocation;
    private List<Integer> nums;
    private Random random = new Random();

    public RandomizedSet() {
        numToLocation = new HashMap<>(0);
        nums = new ArrayList<>();
    }

    public boolean insert(int val) {
        if (numToLocation.containsKey(val)) {
            return false;
        }
        numToLocation.put(val, nums.size());
        nums.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (!numToLocation.containsKey(val)) {
            return false;
        }
        Integer location = numToLocation.get(val);
        Integer last = nums.get(nums.size() - 1);
        numToLocation.put(last, location);
        numToLocation.remove(val);
        nums.set(location, last);
        nums.remove(nums.size() - 1);
        return true;
    }

    public Integer random() {
        int p = random.nextInt(nums.size());
        return nums.get(p);
    }

    public static void main(String[] args) {
        Random random = new Random();
        RandomizedSet randomizedSet = new RandomizedSet();
        IntStream.range(0, 100).forEach(randomizedSet::insert);
        System.err.println(randomizedSet.nums);
        randomizedSet.remove(6);
        IntStream.range(0, 10).forEach(value -> System.err.println(randomizedSet.random()));
    }

}
