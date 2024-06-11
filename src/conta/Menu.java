package conta;

import java.util.*;
import conta.util.Cores;

public class Menu {

	public static void main(String[] args) {
		Scanner ler = new Scanner(System.in);
		int opcao;
		
		while (true) {
			
			System.out.println(Cores.TEXT_CYAN_BOLD_BRIGHT+
					           "_________________________________________________________");
			System.out.println(Cores.ANSI_BLACK_BACKGROUND+
							   "                                                         ");
			System.out.println("               BANCO DO BRASIU COM U                     ");
			System.out.println("_________________________________________________________");
			System.out.println("                                                         ");
			System.out.println("      1- Criar conta                                     ");
			System.out.println("      2- Listar todas as Contas                          ");
			System.out.println("      3- Buscar Contas por Número                        ");
			System.out.println("      4- Atualizar Dados da Conta                        ");
			System.out.println("      5- Apagar Conta                                    ");
			System.out.println("      6- Sacar                                           ");
			System.out.println("      7- Depositar                                       ");
			System.out.println("      8- Transferir valores entre contas                 ");
			System.out.println("      9- Sair                                            ");
			System.out.println("_________________________________________________________");
			System.out.println("                                                         ");
			System.out.println("   Entre com a opção desejada:                           ");
			System.out.println("                                                         "+ Cores.TEXT_RESET);
			
			opcao = ler.nextInt();
			
			if(opcao == 9) {
				System.out.println(Cores.TEXT_WHITE_BOLD_BRIGHT+Cores.ANSI_BLACK_BACKGROUND+
						           "                                                         ");
				System.out.println("Banco do Brasiu com U - Seu Futuro começa aqui           ");
				sobre();
				ler.close();
				System.exit(0);
			}
			
			switch(opcao) {
			case 1:
				System.out.println(Cores.TEXT_WHITE+"Criar conta\n\n");
				break;
			
			case 2:
				System.out.println(Cores.TEXT_WHITE+"Listar todas as contas\n\n");
				break;
				
			case 3:
				System.out.println(Cores.TEXT_WHITE+"Consultar dados da conta - por número\n\n");
				break;
				
			case 4:
				System.out.println(Cores.TEXT_WHITE+"Atualizar dados da conta\n\n");
				break;
				
			case 5:
				System.out.println(Cores.TEXT_WHITE+"Apagar a conta\n\n");
				break;
				
			case 6:
				System.out.println(Cores.TEXT_WHITE+"Saque\n\n");
				break;
				
			case 7:
				System.out.println(Cores.TEXT_WHITE+"Depósito\n\n");
				break;
				
			case 8:
				System.out.println(Cores.TEXT_WHITE+"Tranferência entre contas\n\n");
				break;	
			default:
				System.out.println(Cores.TEXT_RED_BOLD+"\nOpção inválida\n"+Cores.TEXT_RESET);
				break;
			}
		}

	}
	
	public static void sobre() {
		System.out.println("_________________________________________________________");
		System.out.println("                                                         ");
		System.out.println(" Projeto Desenvolvido por: Weida Winy Rodrigues Viana    ");
		System.out.println(" Weida Viana - winnyweida@hotmail.com                    ");
		System.out.println(" https://github.com/Ms-Winny                             ");
		System.out.println("_________________________________________________________");
	}

}
