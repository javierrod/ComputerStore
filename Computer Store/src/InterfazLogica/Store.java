package InterfazLogica;

import java.util.ArrayList;
import java.util.Date;

public class Store {
	private static ArrayList<Components> components;
	private static ArrayList<Bill> Bills;
	private static ArrayList<Client> clients;
	private static Store store = null;
	
	private Store(ArrayList<Components> components, ArrayList<Bill> Bills, ArrayList<Client> clients) {
		super();
		Store.components = components;
		Store.Bills = Bills;
		Store.clients = clients;
	}
	
	public static Store getIntance(){
		if(store==null){
			store = new Store(components, Bills, clients);
		}
		return store;
	}

	public static ArrayList<Components> getComponents() {
		return components;
	}

	public static void setComponents(ArrayList<Components> components) {
		Store.components = components;
	}

	public static void setBills(ArrayList<Bill> Bills) {
		Store.Bills = Bills;
	}

	public static ArrayList<Bill> getBills() {
		return Bills;
	}

	public static ArrayList<Client> getClients() {
		return clients;
	}

	public static void setClients(ArrayList<Client> clients) {
		Store.clients = clients;
	}

	public static Store getStore() {
		return store;
	}

	public static void setStore(Store store) {
		Store.store = store;
	}
	
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
		
		HardDrive hardDrive = new HardDrive(pSerialNumber, pBrand, pModel,
			pPrice, pPriceSales, pAvailableCant, pAvailable, capacity);
		
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
			findComponent(serialNumber);
		}
		this.Bills.add(pBill);
	}
	
	public Components findComponent(String pSerialNumber){
		int i=0;
		while(i<this.components.size() && !this.components.get(i).getSerialNumber().equalsIgnoreCase(pSerialNumber))
			i++;
		
		return this.components.get(i);	
	}
	
	public float ClosingBalance(Date today){
		float sum =0;
		for(int i=0; i<Bills.size();i++){
			if(Bills.get(i).getDate().getTime() == today.getTime()){
				sum+= Bills.get(i).getTotalAmount();
			}
		}
		return sum;
	}
	
	public void DecreaseCant(){
		
	}
	
	
	/*
	public float GainOfStore(Date first, Date second){
		float sum =0;
		for(int i=0; i<payedBills.size();i++){
			if(payedBills.get(i).getDate() >= first && payedBills.get(i).getDate()<=second){
				sum+= payedBills.get(i).GainPerBill();
			}
		}
		return sum;
	*/
	
	

}
