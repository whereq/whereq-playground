package com.whereq.utils;

import org.junit.Test;

import com.whereq.utils.ID;

public class IdentitiesTest {

	@Test
	public void demo() {
		System.out.println("uuid: " + ID.uuid());
		System.out.println("uuid2:" + ID.uuid2());
		System.out.println("randomLong:  " + ID.randomLong());
		System.out.println("randomBase62:" + ID.randomBase62(7));
	}
}
