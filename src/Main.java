import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Main {
        public static void main(String [] args){
        //variáveis do menu
        int opcaoPrincipal = 0, opcaoParametros = 0, opcaoReserva = 0;
        //variáveis da aeronave
        int x, y;
        String modeloAeronave;
        ArrayList<Aviao> aeronaves = new ArrayList();
        String modelos = "";
        int numeroAeronave;
        int aviaoX, aviaoY;
        int lugaresVazios = 0;
        //variáveis do voo
        ArrayList<Voo> voos = new ArrayList();
        int numeroVoo;
        int numeroDoVooLista;
        String dataVoo, horaVoo;
        String voosTexto = "";
        String assentosTexto = "";
        
        while(opcaoPrincipal != 3) {
        opcaoParametros = 0;
        opcaoReserva = 0;
        opcaoPrincipal = Integer.parseInt(JOptionPane.showInputDialog("Menu Principal"
                                                            +"\n1 - Parâmetros do Sistema"
                                                            +"\n2 - Reserva de Passagens"
                                                            +"\n3 - Sair "));
        switch(opcaoPrincipal){
            case 1:
               while (opcaoParametros != 3) {
            	 opcaoParametros = Integer.parseInt(JOptionPane.showInputDialog("Parâmetros do Sistema"
                         +"\n1 - Cadastrar Aeronave"
                         +"\n2 - Cadastrar Voo"
                         +"\n3 - Voltar"));
            	 switch(opcaoParametros){
                 case 1:
                	 modeloAeronave = JOptionPane.showInputDialog("Digite o modelo da aeronave: ");
                	 x = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de linhas de assentos: "));
                	 y = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de colunas de assentos: "));
                	 Aviao aeronave = new Aviao(modeloAeronave, x, y );
                	 aeronaves.add(aeronave);
                	 modelos +=  (aeronaves.indexOf(aeronave)+1)+": "+modeloAeronave+"\n";
                	 break;
                 case 2:      
                	 numeroVoo = Integer.parseInt(JOptionPane.showInputDialog("Digite o número do voo"));
                	 dataVoo = JOptionPane.showInputDialog("Digite a data do voo (ex: 20/12/2022): ");
                	 horaVoo = JOptionPane.showInputDialog("Digite a hora do voo (ex: 13:30): ");
                	 numeroAeronave = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o número correspondente a aeronave \n"+
                			 modelos));
                	 Voo voo = new Voo(aeronaves.get(numeroAeronave - 1), numeroVoo, dataVoo, horaVoo);
                	 voos.add(voo);
                	 voosTexto +=  (voos.indexOf(voo)+1)+": "+voo.toString()+"\n";
                	 break;
                 case 3:
                	 opcaoPrincipal = 0;
                	 break;
                 default:
                	 JOptionPane.showMessageDialog(null, "Escolha uma opção válida");
             }
           }
            	 break;
            case 2:
            	while(opcaoReserva != 4) {
            	 opcaoReserva = Integer.parseInt(JOptionPane.showInputDialog("Reserva de Passagens"
                         +"\n1 - Fazer Reserva"
                         +"\n2 - Consultar lugares vazios"
                         +"\n3 - Consultar reservas realizadas"
                         +"\n4 - Voltar"));
            	 switch(opcaoReserva){
                 case 1:
                	 lugaresVazios = 0;
                	 String nomePassageiro, cpfPassageiro;
                	 int opcaoX,opcaoY;
                	 String assentoTexto;
                	 nomePassageiro = JOptionPane.showInputDialog("Digite o nome do passageiro");
                	 cpfPassageiro = JOptionPane.showInputDialog("Digite o CPF do passageiro: ");
                	 Passageiro passageiro = new Passageiro(nomePassageiro, cpfPassageiro);
                	 numeroDoVooLista = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o número correspondente ao voo que deseja: \n"+
                			 voosTexto));
                	 aviaoX = voos.get(numeroDoVooLista - 1).getAeronave().getX();
                	 aviaoY = voos.get(numeroDoVooLista - 1).getAeronave().getY();
                	 
                	 
                	 
                	 for(int i = 0; i<aviaoX; i++) {
                		 for(int j = 0; j<aviaoY; j++) {
                			 if(!voos.get((numeroDoVooLista - 1)).getAeronave().verificaLugarOcupado(i, j)){
                      			  lugaresVazios++;
                			 
                	 		}
                		 }
                	 }
                	 if(lugaresVazios == 0) {
                		 JOptionPane.showMessageDialog(null, "Não existe nenhum lugar disponível no voo");
                		 
                	 }else{
                		 
                		assentosTexto = escreverAssentos(aviaoX, aviaoY,voos.get(numeroDoVooLista - 1));
                		opcaoX = Integer.parseInt(JOptionPane.showInputDialog("Escolha a linha do assento desejado (Os marcados em X estão ocupados) \n"
                				+ assentosTexto));
                		opcaoY = Integer.parseInt(JOptionPane.showInputDialog("Escolha a coluna do assento desejado (Os marcados em X estão ocupados) \n"
                				+ assentosTexto));
                		 if(voos.get(numeroDoVooLista-1).getAeronave().verificaLugarOcupado(opcaoX, opcaoY)) {
                			 JOptionPane.showMessageDialog(null, "Assento ocupado, selecione outro");
                		 }else{
                			 System.out.println(opcaoX);
                			 System.out.println(opcaoY);
                			 voos.get(numeroDoVooLista-1).getAeronave().setPassageiro(opcaoX, opcaoY, passageiro);
                			 JOptionPane.showMessageDialog(null, "Reserva Realizada");
                		 }
                	 }
                 break;
                 case 2:
                	 lugaresVazios = 0;
                	 
                	 numeroDoVooLista = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o número correspondente ao voo \n"+
                			 voosTexto));
                	 			
                	 aviaoX = voos.get(numeroDoVooLista - 1).getAeronave().getX();
                	 aviaoY = voos.get(numeroDoVooLista - 1).getAeronave().getY();
                	 
                	 
                	 
                	 for(int i = 0; i<aviaoX; i++) {
                		 for(int j = 0; j<aviaoY; j++) {
                			 if(!voos.get((numeroDoVooLista - 1)).getAeronave().verificaLugarOcupado(i, j)){
                      			  lugaresVazios++;
                			 
                	 		}
                		 }
                	 }
                	  	
                	 JOptionPane.showMessageDialog(null, "Esse voo tem "+lugaresVazios+" lugares vazios");
                	 	
                 break;
                 case 3:
                	 
                 break;
                 case 4:
                 break;
                 default:
                	 JOptionPane.showMessageDialog(null, "Escolha uma opção válida");
             }
           }
            break; 
            case 3:
            	JOptionPane.showMessageDialog(null, "Obrigado por usar o programa!");
            break;
            default:
            	JOptionPane.showMessageDialog(null, "Escolha uma opção válida");
        }
        }
    }
        
      public static String escreverAssentos(int x, int y, Voo voo) {
    	  
    	  String escrever="   ";
    	  for(int j = 0; j<y;j++) {
    		  escrever += " "+j+"";
    	  }
    	  escrever += "\n";
    for(int i = 0; i<x; i++) {
    	escrever += i+" ";
     		 for(int j = 0; j<y; j++) {
     			if(voo.getAeronave().verificaLugarOcupado(i, j)) {
     				escrever += "[X]" ;
     		 }else {
     			escrever += "[ ]";
     		 }
     		}
     		escrever += " \n";
     	 }	
    	return escrever;
      }
}
