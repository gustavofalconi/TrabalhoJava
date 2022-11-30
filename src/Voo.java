
public class Voo {
	String modelo;
	int x, y;
	private Aviao aeronave = new Aviao(modelo, x, y);
	private int nro;
	String data;
	String hora;
	
	
	
	public Voo(Aviao aeronave, int nro, String data, String hora) {
		super();
		this.aeronave = aeronave;
		this.nro = nro;
		this.data = data;
		this.hora = hora;
	}
	
	public int getNro() {
		return nro;
	}
	public void setNro(int nro) {
		this.nro = nro;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}

	@Override
	public String toString() {
		return "Voo [Aeronave=" + aeronave.getModelo() + ", Numero do Voo=" + nro + ", data="
				+ data + ", hora=" + hora + "]";
	}

	public Aviao getAeronave() {
		return this.aeronave;
	}

	public void setAeronave(Aviao aeronave) {
		this.aeronave = aeronave;
	}
	
	
}
