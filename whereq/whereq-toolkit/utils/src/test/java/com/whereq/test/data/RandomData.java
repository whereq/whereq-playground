package com.whereq.test.data;

import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Random data generator.
 * 
 * @author bacon
 */
public class RandomData {

	private static Random random = new Random();

	/**
	 * randomId.
	 */
	public static long randomId() {
		return random.nextLong();
	}

	/**
	 * random name, prefix + 5 random digits.
	 */
	public static String randomName(String prefix) {
		return prefix + random.nextInt(10000);
	}

	/**
	 * get a random object from a list.
	 */
	public static <T> T randomOne(List<T> list) {
		Collections.shuffle(list);
		return list.get(0);
	}

	/**
	 * get N random objects from a list.
	 */
	public static <T> List<T> randomSome(List<T> list, int n) {
		Collections.shuffle(list);
		return list.subList(0, n);
	}

	/**
	 * get random number of objects from a list.
	 */
	public static <T> List<T> randomSome(List<T> list) {
		int size = random.nextInt(list.size());
		if (size == 0) {
			size = 1;
		}
		return randomSome(list, size);
	}
}
