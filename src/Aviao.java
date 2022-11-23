
public class Aviao extends Aeronave {
    


	int x, y;
    public Passageiro passageiro[][] = new Passageiro[x][y];
  

     public Aviao(String modelo, int x, int y) {
        super(modelo);
        this.x = x;
        this.y = y;
    }




	public Passageiro[][] getPassageiro() {
		if(verificaLugarOcupado(this.x, this.y)) {
		return passageiro;
		}else {
		return null;
		}
	}




	public void setPassageiro(Passageiro[][] passageiro) {
		this.passageiro = passageiro;
	}

     
	public boolean verificaLugarOcupado(int x, int y){
		boolean status = false;
		for(int i=0; i<x; i++) {
			for(int j=0; j<y; j++) {
				if(passageiro[x][y].getNome().isEmpty()) {
					status = false;
				}else{
					status = true;
				}
			}
		}
		return status;
	}
    


}
