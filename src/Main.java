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
        //variáveis do voo
        ArrayList<Voo> voos = new ArrayList();
        int numeroVoo;
        String dataVoo, horaVoo;
        
        while(opcaoPrincipal != 3) {
        opcaoPrincipal = Integer.parseInt(JOptionPane.showInputDialog("Menu Principal"
                                                            +"\n1 - Parâmetros do Sistema"
                                                            +"\n2 - Reserva de Passagens"
                                                            +"\n3 - Sair"));
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
                	 break;
                 case 3:
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

                 break;
                 case 2:

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
}
