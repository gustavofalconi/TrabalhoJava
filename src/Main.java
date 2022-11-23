import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Main {
        public static void main(String [] args){
        //variável auxiliar do case
        int aux = -1;
        //variáveis do menu
        int opcaoPrincipal, opcaoParametros, opcaoReserva;
        //variáveis da aeronave
        int x, y;
        String modeloAeronave;
        ArrayList<Aviao> aeronaves = new ArrayList();
        //variáveis do voo
        ArrayList<Voo> voos = new ArrayList();
        int numeroVoo;
        String dataVoo, horaVoo;
        
        while(aux == -1) {
        opcaoPrincipal = Integer.parseInt(JOptionPane.showInputDialog("Menu Principal"
                                                            +"\n1 - Parâmetros do Sistema"
                                                            +"\n2 - Reserva de Passagens"
                                                            +"\n3 - Sair"));
        switch(opcaoPrincipal){
            case 1:
            	 opcaoParametros = Integer.parseInt(JOptionPane.showInputDialog("Parâmetros do Sistema"
                         +"\n1 - Cadastrar Aeronave"
                         +"\n2 - Cadastrar Voo"
                         +"\n3 - Voltar"));
            	 switch(opcaoParametros){
                 case 1:
                	 aux = 0;
                	 modeloAeronave = JOptionPane.showInputDialog("Digite o modelo da aeronave: ");
                	 x = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de linhas de assentos: "));
                	 y = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de colunas de assentos: "));
                	 Aviao aeronave = new Aviao(modeloAeronave, x, y );
                	 aeronaves.add(aeronave);
                	 break;
                 case 2:
                	 aux = 0;
                	 numeroVoo = Integer.parseInt(JOptionPane.showInputDialog("Digite o número do voo"));
                	 dataVoo = JOptionPane.showInputDialog("Digite a data do voo (ex: 20/12/2022): ");
                	 horaVoo = JOptionPane.showInputDialog("Digite a hora do voo (ex: 13:30): ");
                	 JOptionPane.showInputDialog(null,
                			
                			 "Escolha um voo");
                	// Voo voo = new Voo(aeronave, numeroVoo, horaVoo, horaVoo);
                	 break;
                 case 3:
                	 break;
                 default:
                	 JOptionPane.showMessageDialog(null, "Escolha uma opção válida");
             }
            	 break;
            case 2:
            	 opcaoReserva = Integer.parseInt(JOptionPane.showInputDialog("Reserva de Passagens"
                         +"\n1 - Fazer Reserva"
                         +"\n2 - Consultar lugares vazios"
                         +"\n3 - Consultar reservas realizadas"
                         +"\n4 - Voltar"));
            	 switch(opcaoReserva){
                 case 1:
                	 aux = 0;
                 break;
                 case 2:
                	 aux = 0;
                 break;
                 case 3:
                	 aux = 0;
                 break;
                 case 4:
                 break;
                 default:
                	 JOptionPane.showMessageDialog(null, "Escolha uma opção válida");
             }
            break;
            case 3:
            	aux = 0;
            	JOptionPane.showMessageDialog(null, "Obrigado por usar o programa!");
            break;
            default:
            	JOptionPane.showMessageDialog(null, "Escolha uma opção válida");
        }
        }
    }
}
