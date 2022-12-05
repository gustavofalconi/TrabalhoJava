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
        int numeroAeronave = 0;
        int aviaoX, aviaoY;
        int lugaresVazios = 0;
        //variáveis do voo
        ArrayList<Voo> voos = new ArrayList();
        int numeroVoo;
        int numeroDoVooLista = 0;
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
                	 JOptionPane.showMessageDialog(null, "Aeronave cadastrada!");
                	 break;
                 case 2:
                	 numeroAeronave = 0;
                	 if(aeronaves.size() == 0) {
                		 JOptionPane.showMessageDialog(null, "Sem aeronaves disponíveis, cadastre uma", "Erro", JOptionPane.ERROR_MESSAGE);
                		 break;
                	 }else {               
                	 numeroVoo = Integer.parseInt(JOptionPane.showInputDialog("Digite o número do voo"));
                	 dataVoo = JOptionPane.showInputDialog("Digite a data do voo (ex: 20/12/2022): ");
                	 horaVoo = JOptionPane.showInputDialog("Digite a hora do voo (ex: 13:30): ");
                	 while(numeroAeronave < 1 || numeroAeronave > aeronaves.size()) {
                	 numeroAeronave = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o número correspondente a aeronave \n"+
                			 modelos));
                	 if (numeroAeronave < 1 || numeroAeronave > aeronaves.size()) {
                		 JOptionPane.showMessageDialog(null, "Escolha um número válido", "Número Inválido", JOptionPane.ERROR_MESSAGE);
                	 }
                	 }
                	 Voo voo = new Voo(aeronaves.get(numeroAeronave - 1), numeroVoo, dataVoo, horaVoo);
                	 voos.add(voo);
                	 voosTexto +=  (voos.indexOf(voo)+1)+": "+voo.toString()+"\n";
                	 JOptionPane.showMessageDialog(null, "Voo cadastrado!");
                	 }
                	 break;
                 case 3:
                	 opcaoPrincipal = 0;
                	 break;
                 default:
                	 JOptionPane.showMessageDialog(null, "Escolha uma opção válida", "Opção Inválida", JOptionPane.ERROR_MESSAGE);
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
                	 numeroDoVooLista = 0;
                	 
                	 if(voos.size() == 0) {
                		 JOptionPane.showMessageDialog(null, "Não existem voos disponíveis no momento", "Sem voos", JOptionPane.ERROR_MESSAGE);
                		 break;
                	 }else{
                	 nomePassageiro = JOptionPane.showInputDialog("Digite o nome do passageiro");
                	 cpfPassageiro = JOptionPane.showInputDialog("Digite o CPF do passageiro: ");
                	 while(numeroDoVooLista < 1 || numeroDoVooLista > voos.size()) {
                	 numeroDoVooLista = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o número correspondente ao voo que deseja: \n"+
                			 voosTexto));
                	 if (numeroDoVooLista < 1 || numeroDoVooLista > voos.size()) {
                		 
                		 JOptionPane.showMessageDialog(null, "Escolha um número válido", "Número Inválido", JOptionPane.ERROR_MESSAGE);
                		 
                	 }
                	 }
                	 
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
                		 
                		 JOptionPane.showMessageDialog(null, "Não existe nenhum lugar disponível no voo", "Erro", JOptionPane.ERROR_MESSAGE);
                		 
                	 }else{
                		int opcaoX = -1;
                		int opcaoY = -1;
                		assentosTexto = escreverAssentos(aviaoX, aviaoY,voos.get(numeroDoVooLista - 1));
                		while(opcaoX < 0 || opcaoX>aviaoX-1) {
                		opcaoX = Integer.parseInt(JOptionPane.showInputDialog("Escolha a linha do assento desejado (Os marcados em X estão ocupados) \n"
                				+ assentosTexto));
                		if(opcaoX < 0 || opcaoX>aviaoX-1) {
                			JOptionPane.showMessageDialog(null, "Linha inválida, selecione uma linha de 0 até "+(aviaoX-1), "Erro", JOptionPane.ERROR_MESSAGE);
                		}
                	}
                		while(opcaoY < 0 || opcaoY>aviaoY-1) {
                		opcaoY = Integer.parseInt(JOptionPane.showInputDialog("Escolha a coluna do assento desejado (Os marcados em X estão ocupados) \n"
                				+ assentosTexto));
                		if(opcaoY < 0 || opcaoY>aviaoY-1) {
                			JOptionPane.showMessageDialog(null, "Coluna inválida, selecione uma coluna de 0 até "+(aviaoY-1), "Erro", JOptionPane.ERROR_MESSAGE);
                		}
                	}	
                		 if(voos.get(numeroDoVooLista-1).getAeronave().verificaLugarOcupado(opcaoX, opcaoY)) {
                			 JOptionPane.showMessageDialog(null, "Assento ocupado, selecione outro", "Erro", JOptionPane.ERROR_MESSAGE);
                		 }else{
                			 voos.get(numeroDoVooLista-1).getAeronave().lugares[opcaoX][opcaoY] = new Passageiro (nomePassageiro, cpfPassageiro);
                			 JOptionPane.showMessageDialog(null, "Reserva Realizada");
                		 }
                	 }
                }	 
                 break;
                 case 2:
                	 lugaresVazios = 0;
                	 numeroDoVooLista = 0;
                	 
                	 if(voos.size() == 0) {
                		 JOptionPane.showMessageDialog(null, "Não existem voos disponíveis no momento", "Sem voos", JOptionPane.ERROR_MESSAGE);
                		 break;
                	 }else{
                	 
                	 while(numeroDoVooLista < 1 || numeroDoVooLista > voos.size()) {
                	 numeroDoVooLista = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o número correspondente ao voo que deseja: \n"+
                			 voosTexto));
                	 if (numeroDoVooLista < 1 || numeroDoVooLista > voos.size()) {
                		 JOptionPane.showMessageDialog(null, "Escolha um número válido", "Número Inválido", JOptionPane.ERROR_MESSAGE);
                	 }
                	 }
                	 			
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
               }	
                 break;
                 case 3:
                	 
                	 if(voos.size() == 0) {
                		 JOptionPane.showMessageDialog(null, "Não existem voos disponíveis no momento", "Sem voos", JOptionPane.ERROR_MESSAGE);
                		 break;
                	 }else{
                	 numeroDoVooLista = 0;
                	 while(numeroDoVooLista < 1 || numeroDoVooLista > voos.size()) {
                	 numeroDoVooLista = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o número correspondente ao voo que deseja: \n"+
                			 voosTexto));
                	 if (numeroDoVooLista < 1 || numeroDoVooLista > voos.size()) {
                		 JOptionPane.showMessageDialog(null, "Escolha um número válido", "Número Inválido", JOptionPane.ERROR_MESSAGE);
                	 }
                	 }
                	 aviaoX = voos.get(numeroDoVooLista - 1).getAeronave().getX();
                	 aviaoY = voos.get(numeroDoVooLista - 1).getAeronave().getY();
                	 
                	 
                	 for(int i = 0; i<aviaoX; i++) {
                		 for(int j = 0; j<aviaoY; j++) {
                			 if(!voos.get((numeroDoVooLista - 1)).getAeronave().verificaLugarOcupado(i, j)){
                      			  lugaresVazios++;
                			 
                	 		}
                		 }
                	 }
               	 
                		assentosTexto = escreverAssentos(aviaoX, aviaoY,voos.get(numeroDoVooLista - 1));
                		JOptionPane.showMessageDialog(null,"Assentos com um X são os assentos com reservas já realizadas: \n"
                				+ assentosTexto);
                }	
                 break;
                 case 4:
                 break;
                 default:
                	 JOptionPane.showMessageDialog(null, "Escolha uma opção válida", "Opção Inválida", JOptionPane.ERROR_MESSAGE);
             }
           }
            break; 
            case 3:
            	JOptionPane.showMessageDialog(null, "Obrigado por usar o programa!");
            break;
            default:
            	JOptionPane.showMessageDialog(null, "Escolha uma opção válida", "Opção Inválida", JOptionPane.ERROR_MESSAGE);
        }
        }
    }
        
      public static String escreverAssentos(int x, int y, Voo voo) {
    	  
    	  String escrever="     ";
    	  for(int j = 0; j<y;j++) {
    		  if(j<y-1) {
    		  escrever += ""+j+"  ";
    		  }else if(j==y-1) {
    			  escrever += ""+j+"";
    		  }
    		  
    	  }
    	  escrever += "\n";
    for(int i = 0; i<x; i++) {
    	escrever += i+" ";
     		 for(int j = 0; j<y; j++) {
     			if(voo.getAeronave().verificaLugarOcupado(i, j)) {
     				escrever += "[X]" ;
     		 }else {
     			escrever += "[  ]";
     		 }
     		}
     		escrever += " \n";
     	 }	
    	return escrever;
      }
}
