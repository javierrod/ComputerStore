package InterfazLogica;

public class HardDrive extends Components{
	private String capacity;

	public HardDrive(String pSerialNumber, String pBrand, String pModel,
			float pPrice,float pPriceSales, int pAvailableCant, boolean pAvailable,
			String capacity) {
		super(pSerialNumber, pBrand, pModel,pPrice, pPriceSales, pAvailableCant, pAvailable);
		this.capacity = capacity;
	}

	public String getCapacity() {
		return capacity;
	}

	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}
	
	
}
