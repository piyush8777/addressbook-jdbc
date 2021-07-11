package com.addressbook;

import static org.junit.Assert.assertEquals;

import java.awt.List;

import org.junit.Test;

public class AddressBookTest {
	@Test
    public void givenAddressBookData_WhenRetreived_ShouldRetrieveAllContacts() {
        AddressBookDBService addressBookDBService = new AddressBookDBService();
        List contactList = (List) addressBookDBService.readData();
        System.out.println(contactList);
        assertEquals(3, contactList.size());
    }
}
