/**
 * *****************************************************************
 * Purpose: AddressBook Service to rerieve all the Entries from the DB
 *                       
 * @author Piyush Shaw
 * @version 1.0
 * @since 07-07-2021
 * ******************************************************************
 */



package com.addressbook;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.xdevapi.Statement;

public class AddressBookDBService {
	 private Connection getConnection() throws SQLException {
	        String jdbcURL = "jdbc:mysql://localhost:3306/addressbook_service?useSSL=false";
	        String userName = "root";
	        String password = "Alliance@123";
	        Connection connection;
	        connection = DriverManager.getConnection(jdbcURL, userName, password);
	        System.out.println("Connection established: "+connection);
	        return connection;
	    }
	    public List<Contact> readData() {
	        List<Contact> contactList = new ArrayList<Contact>();
	        String sql = "SELECT * FROM userdetails;";
	        try(Connection connection = this.getConnection()){
	            Statement statement = (Statement) connection.createStatement();
	            ResultSet resultSet = ((java.sql.Statement) statement).executeQuery(sql);
	            while(resultSet.next()) {
	                Integer user_id = resultSet.getInt(1);
	                String firstName = resultSet.getString("first_name");
	                String lastName = resultSet.getString("last_name");
	                String address = resultSet.getString("address");
	                String city = resultSet.getString("city");
	                String state = resultSet.getString("state");
	                Integer zip = resultSet.getInt(7);
	                Long phoneNo = resultSet.getLong(8);
	                String email = resultSet.getString("email");
	                Contact contact = new Contact(user_id,firstName, lastName, address, city, state, zip, phoneNo, email);
	                contactList.add(contact);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return contactList;
	    }

}
