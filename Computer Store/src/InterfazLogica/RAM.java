package InterfazLogica;

public class RAM extends Components {
	private String cantMemo;
	private TypeMemory memory;
	

	public RAM(String pSerialNumber, String pBrand, String pModel,
			float pPrice,float pPriceSales, int pAvailableCant, boolean pAvailable,
			String pCantMemo, TypeMemory pMemory) {
		super(pSerialNumber, pBrand, pModel, pPrice,pPriceSales, pAvailableCant, pAvailable);
		this.cantMemo = pCantMemo;
		this.memory = pMemory;
	}


	public String getCantMemo() {
		return cantMemo;
	}


	public void setCantMemo(String cantMemo) {
		this.cantMemo = cantMemo;
	}


	public TypeMemory getMemory() {
		return memory;
	}


	public void setMemory(TypeMemory memory) {
		this.memory = memory;
	}
	
	
}
