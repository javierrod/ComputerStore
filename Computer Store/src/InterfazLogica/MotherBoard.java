package InterfazLogica;

public class MotherBoard extends Components{
	private String socket;
	private String RAM;
	private String[] HDDconnection;
	
	public MotherBoard(String pSerialNumber, String pBrand, String pModel,
			float pPrice,float pPriceSales, int pAvailableCant, boolean pAvailable,
			String socket, String RAM, String[] hDDconnection) {
		super(pSerialNumber, pBrand, pModel, pPrice,pPriceSales, pAvailableCant, pAvailable);
		this.socket = socket;
		this.RAM = RAM;
		HDDconnection = hDDconnection;
	}

	public String getSocket() {
		return socket;
	}

	public void setSocket(String socket) {
		this.socket = socket;
	}

	public String getRAM() {
		return RAM;
	}

	public void setRAM(String rAM) {
		RAM = rAM;
	}

	public String[] getHDDconnection() {
		return HDDconnection;
	}

	public void setHDDconnection(String[] hDDconnection) {
		HDDconnection = hDDconnection;
	}
	
	
	
	
}
