/**
 * Copyright 2011 Marin Solutions
 */
package com.captaindebug.address;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Roger
 * 
 */
public class ClassicAddressServiceWithStubTest {

	private AddressService instance;

	private Address expectedAddress = new Address(1, "15 My Street", "My Town", "POSTCODE", "My Country");

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {

		instance = new AddressService();
		instance.setAddressDao(new StubAddressDao(expectedAddress));
	}

	/**
	 * Test method for {@link com.captaindebug.address.AddressService#findAddress(int)}.
	 */
	@Test
	public void testFindAddressWithStub() {

		Address result = instance.findAddress(1);

		assertEquals(expectedAddress.getId(), result.getId());
		assertEquals(expectedAddress.getStreet(), result.getStreet());
		assertEquals(expectedAddress.getTown(), result.getTown());
		assertEquals(expectedAddress.getPostCode(), result.getPostCode());
		assertEquals(expectedAddress.getCountry(), result.getCountry());
	}
}