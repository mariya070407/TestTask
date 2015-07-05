package TestTask.AccountManagement;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class AccountMAnagementTest {

	@Test
	public void testFindAccountByName() {
		AccountMAnagement am=new AccountMAnagement();
		
		assertEquals("Must return - Petr | Petrov", "Petr | Petrov", am.findAccountByName("Petr"));
		assertNull("Must be NULL", am.findAccountByName("Peter"));
		assertEquals("Must return - Ivan | Ivanov", "Ivan | Ivanov", am.findAccountByName("Ivan"));
	}
	
	
	@Test
	public void testEditSurname() {
		AccountMAnagement am=new AccountMAnagement();
		
		assertEquals("Must return true",true, am.editSurname("Sidor", "Fedorov"));
		assertEquals("Must return - Sidor | Fedorov", "Sidor | Fedorov", am.findAccountByName("Sidor"));
		assertEquals("Must return false",false, am.editSurname("Fedor", "Fedorov"));
		
		CreateTable.viewTable();
	}

	@BeforeClass
	public static void createTable(){
		try {
			CreateTable.createAndFillTable();
		} catch (Exception e) {
			e.printStackTrace();
		}
		CreateTable.viewTable();
	}
	
	@AfterClass
	public static void viewResults(){
		CreateTable.viewTable();
	}
}
