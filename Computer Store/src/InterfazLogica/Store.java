package InterfazLogica;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Store {
	/*
	 * QUITE LO DE STATIC, YA QUE SEGUN EL PPROFESOR EL CONSTRUCTOR DEBE DE SER VACIO.
	 */
	private ArrayList<Components> components;
	private ArrayList<Bill> Bills;
	private ArrayList<Client> clients;
	private static Store store = null;
	
	private Store() {
		super();
		components=new ArrayList<Components>();
		Bills=new ArrayList<Bill>();
		clients=new ArrayList<Client>();
	}
	
	public static Store getIntance(){
		if(store==null){
			store = new Store();
		}
		return store;
	}

	public ArrayList<Components> getComponents() {
		return components;
	}

	public void setComponents(ArrayList<Components> components) {
		this.components = components;
	}

	public void setBills(ArrayList<Bill> Bills) {
		this.Bills = Bills;
	}

	public ArrayList<Bill> getBills() {
		return Bills;
	}

	public ArrayList<Client> getClients() {
		return clients;
	}

	public void setClients(ArrayList<Client> clients) {
		this.clients = clients;
	}
	
	/*
	public static Store getStore() {
		return store;
	}

	public static void setStore(Store store) {
		Store.store = store;
	}
	*/
	
	public void addComponents(Components components){
		this.components.add(components);
	}
	
	public void addRam(String pSerialNumber, String pBrand, String pModel,
			float pPrice,float pPriceSales, int pAvailableCant, boolean pAvailable,
			String pCantMemo, TypeMemory pMemory){
		RAM ram = new RAM(pSerialNumber, pBrand, pModel, pPrice, pPriceSales, pAvailableCant, pAvailable, pCantMemo, pMemory);
		
		addComponents(ram);
	}
	
	public void addHardDrive(String pSerialNumber, String pBrand, String pModel,
			float pPrice,float pPriceSales, int pAvailableCant, boolean pAvailable,
			String capacity){
		
		HardDrive hardDrive = new HardDrive(pSerialNumber, pBrand, pModel, pPrice, pPriceSales, pAvailableCant, pAvailable, capacity);
		
		addComponents(hardDrive);
	}
	
	public void addMicroProcessor(String pSerialNumber, String pBrand, String pModel,
			float pPrice,float pPriceSales, int pAvailableCant, boolean pAvailable,
			String socket, String clockRate, TypeConnection connection){
		
		MicroProcessor micro = new MicroProcessor(pSerialNumber, pBrand, pModel, pPrice, pPriceSales, pAvailableCant, pAvailable, socket, clockRate, connection);
		
		addComponents(micro);
	}
	
	public void addMotherBoard(String pSerialNumber, String pBrand, String pModel,
			float pPrice,float pPriceSales, int pAvailableCant, boolean pAvailable,
			String socket, String RAM, String[] hDDconnection){
		MotherBoard MD = new MotherBoard(pSerialNumber, pBrand, pModel,
			pPrice, pPriceSales, pAvailableCant, pAvailable,
			socket, RAM, hDDconnection);
		
		addComponents(MD);
	}
	
	public void addClient(Client client){
		this.clients.add(client);
	}
	
	public void addPaidBill(Bill pBill){
		pBill.setPaid(true);
		int i;
		for(i=0; i < pBill.getItems().size() ; i++ ){
			String serialNumber = pBill.getItems().get(i).getSerialNumber();
			findAndDecreaseCant(serialNumber);
		}
		this.getBills().add(pBill);
	}

	
	public void addUnpaidBill(Bill pBill){
		if(pBill.isPaid() == false)
			this.Bills.add(pBill);
		else
			addPaidBill(pBill);
	}
	
	public void findAndDecreaseCant(String pSerialNumber){
		int i=0;
		
		while(i<this.components.size() && !this.components.get(i).getSerialNumber().equalsIgnoreCase(pSerialNumber)){
			i++;
		}
		this.components.get(i).availableCant -= 1;
		//	return this.components.get(i);	YA NO SE USARA
	}
	
	@SuppressWarnings("deprecation")
	public float ClosingBalance(Calendar today){
		float sum =0;
		for(int i=0; i<Bills.size();i++){
			if(Bills.get(i).getDate().getTime().getDay() == today.getTime().getDay() 
				&& Bills.get(i).getDate().getTime().getMonth() == today.getTime().getMonth()
				&& Bills.get(i).getDate().getTime().getYear() == today.getTime().getYear()){
				
				sum+= Bills.get(i).getTotalAmount();
			}
		}
		return sum;
	}
	
	public float ClosingBalance(Calendar date1, Calendar date2){
		float sum =0;
		if(date2.getTime().getTime() > date1.getTime().getTime()){
			for(int i=0; i< Bills.size();i++){
				if(Bills.get(i).getDate().getTime().getTime() >= date1.getTime().getTime() 
						&& Bills.get(i).getDate().getTime().getTime() <= date2.getTime().getTime())
					
					sum+= Bills.get(i).getTotalAmount();
			}
		}
		return sum;
	}
	
	public float GainOfStore(Calendar today){
		float sum =0;
		for(int i=0; i<Bills.size();i++){
			if(Bills.get(i).getDate().getTime().getTime() == today.getTime().getTime()){
				sum+= Bills.get(i).GainPerBill();
			}
		}
		return sum;
	}
	
	public float GainOfStore(Calendar date1, Calendar date2){
		float sum =0;
		if(date2.getTime().getTime() > date1.getTime().getTime()){
			
			for(int i=0; i< Bills.size();i++){
				if(Bills.get(i).getDate().getTime().getTime() >= date1.getTime().getTime() 
						&& Bills.get(i).getDate().getTime().getTime() <= date2.getTime().getTime())
					sum+= Bills.get(i).GainPerBill();
			}	
		}
		return sum;
	}
	

}
