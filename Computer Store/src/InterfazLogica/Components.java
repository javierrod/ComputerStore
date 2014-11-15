package InterfazLogica;

public abstract class Components {
	protected String serialNumber;
	protected String brand;
	protected String model;
	protected float price;
	protected float priceSale;
	protected int availableCant;
	protected boolean available;
	
	public Components(String pSerialNumber, String pBrand, String pModel,
			float pPrice, float pPriceSales, int pAvailableCant, boolean pAvailable) {
		super();
		this.serialNumber = pSerialNumber;
		this.brand = pBrand;
		this.model = pModel;
		this.price = pPrice;
		this.priceSale = pPriceSales;
		this.availableCant = pAvailableCant;
		this.available = pAvailable;
	}

	public float getPriceSale() {
		return priceSale;
	}

	public void setPriceSale(float priceSale) {
		this.priceSale = priceSale;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) { //creo que se colocaria una excepcion
		//if(price>0)
		this.price = price;
	}

	public int getAvailableCant() {
		return availableCant;
	}

	public void setAvailableCant(int availableCant) {
		this.availableCant = availableCant;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}
	
	/*
	public void DecreaseCant(){
		this.availableCant = this.availableCant -1;
	}
	*/
	
	
	

}
