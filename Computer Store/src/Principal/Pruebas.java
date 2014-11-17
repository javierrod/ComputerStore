package Principal;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Set;

import InterfazLogica.Bill;
import InterfazLogica.Client;
import InterfazLogica.Components;
import InterfazLogica.HardDrive;
import InterfazLogica.Store;

public class Pruebas {

	//@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Store store = Store.getIntance();
		ArrayList<Components> hehe = new ArrayList<Components>();
		
		HardDrive a = new HardDrive("1234", "eric", "67", 1000, 1500, 20, true, "1TB");
		HardDrive e = new HardDrive("1235", "Juan", "67", 1000, 1500, 18, true, "1TB");
		HardDrive i = new HardDrive("1236", "jeen", "67", 1000, 1500, 20, true, "1TB");
		HardDrive o = new HardDrive("1237", "jje", "67", 1000, 1500, 10, true, "1TB");

		hehe.add(a);
		hehe.add(e);
		hehe.add(i);
		hehe.add(o);
	//	store.addHardDrive("1237", "jje", "67", 1000, 1500, 20, true, "1TB");
		store.setComponents(hehe);
	//	System.out.println(store.getComponents().get(3).getBrand());
		store.addHardDrive("1238", "jje", "67", 1000, 1500, 10, true, "1TB");		
		
		Calendar c1 = GregorianCalendar.getInstance();
		Calendar c2 = GregorianCalendar.getInstance();

		Client client = new Client("juan", "rod", "Av. 27 feb", "809-234", "1234");
		
		
		c1.set(2000, Calendar.AUGUST, 31);
		
		Bill bill1 = new Bill("1213", hehe, c1, client, true);
		Bill bill2 = new Bill("2335", hehe, c2, client, true);
		ArrayList<Bill> bills = new ArrayList<Bill>();
		bills.add(bill1);
		bills.add(bill2);
		store.setBills(bills);
		
		store.addPaidBill(bill1);
		store.addPaidBill(bill2);
		store.addPaidBill(bill2);
		
		System.out.println(store.getBills().size());
		float T = store.ClosingBalance(c2);
		
      	System.out.println(T);
      	System.out.println(store.GainOfStore(c1));
      	System.out.println(store.getComponents().get(3).getAvailableCant());
  //    System.out.println(store.getComponents().get(4).g);
	
	}

}
