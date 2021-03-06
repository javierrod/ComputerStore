package InterfazLogica;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Bill {
	private String ID;
	private float totalAmount;
	private ArrayList<Components> items;
	private Calendar date;
	private Client client;
	private boolean paid;
	
	public Bill(String iD, ArrayList<Components> items,
			Calendar date, Client client, boolean payed) {
		super();
		ID = iD;
		this.items = items;
		this.date = date;
		this.client = client;
		this.paid = paid;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public float getTotalAmount() {
		return this.totalAmount = TotalAmount();
	}

	public void setTotalAmount(float totalAmount) {
		this.totalAmount = totalAmount;
	}

	public ArrayList<Components> getItems() {
		return items;
	}

	public void setItems(ArrayList<Components> items) {
		this.items = items;
	}

	public Calendar getDate() {
		return date;
	}

	public void setDate(Calendar date) {
		this.date = date;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	public void addItem(Components component){
		this.items.add(component);
	}
	
	public boolean isPaid() {
		return paid;
	}

	public void setPaid(boolean paid) {
		this.paid = paid;
	}

	public void verifyClient(ArrayList<Client> c, String id, String name, String lastName, String adress,
			String phoneNumber){
		//Revisar si los demas campos estan en null en los textBox
		for(int i = 0; i<c.size(); i++){
			if(c.get(i).getIdentification() == id || (c.get(i).getName() == name && c.get(i).getLastName() == lastName) || c.get(i).getPhoneNumber() == phoneNumber){
				setClient(c.get(i));
			}
			else {
			Client client = new Client(name, lastName, adress, phoneNumber, id);
			Store store = Store.getIntance();
			store.addClient(client);
			
			setClient(client);
			}
		}
	}
	
	private float TotalAmount(){
		float sum = 0;
		for(int i=0; i<items.size();i++){
			sum += items.get(i).getPriceSale();
		}
		return sum;
		
	}
	
	public float GainPerBill(){
		float sum = 0;
		for(int i=0; i<items.size();i++){
			sum += (items.get(i).getPriceSale() - items.get(i).getPrice());
		}
		return sum;
		
	}
	
	
	
	
	
}
