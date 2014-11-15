package InterfazLogica;

public class MicroProcessor extends Components{
	private String socket;
	private String clockRate;
	private TypeConnection connection;
	

	public MicroProcessor(String pSerialNumber, String pBrand, String pModel,
			float pPrice,float pPriceSales, int pAvailableCant, boolean pAvailable,
			String socket, String clockRate, TypeConnection connection) {
		super(pSerialNumber, pBrand, pModel, pPrice, pPriceSales, pAvailableCant, pAvailable);
		this.socket = socket;
		this.clockRate = clockRate;
		this.connection = connection;
	}
	
	public String getSocket() {
		return socket;
	}

	public void setSocket(String socket) {
		this.socket = socket;
	}

	public String getClockRate() {
		return clockRate;
	}

	public void setClockRate(String clockRate) {
		this.clockRate = clockRate;
	}

	public TypeConnection getConnection() {
		return connection;
	}

	public void setConnection(TypeConnection connection) {
		this.connection = connection;
	}

	
	
}
