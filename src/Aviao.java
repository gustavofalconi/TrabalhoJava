
public class Aviao extends Aeronave {
    
	int x, y;
	public Passageiro[][] lugares;
    

     public Aviao(String modelo, int x, int y) {
        super(modelo);
        this.x = x;
        this.y = y;
        this.lugares = new Passageiro[x][y];
    }
    



	public Passageiro getPassageiro(int xPassageiro, int yPassageiro) {
		if(verificaLugarOcupado(xPassageiro, yPassageiro)) {
		return lugares[xPassageiro][yPassageiro];
		}else{
		return null;
		}
	}

     
	public void setPassageiro(int xPassageiro, int yPassageiro, Passageiro passageiro) {
		this.lugares[x][y] = passageiro;
	}





	public boolean verificaLugarOcupado(int x, int y){
		boolean status = false;
				if(lugares[x][y] == null) {
					status = false;
				}else{
					status = true;
				}
		return status;
	}




	public int getX() {
		return x;
	}




	public int getY() {
		return y;
	}




	public void setX(int x) {
		this.x = x;
	}




	public void setY(int y) {
		this.y = y;
	}    

}
