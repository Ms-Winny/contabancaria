package conta;

import java.io.IOException;
import java.util.*;
import conta.util.Cores;
import conta.model.ContaCorrente;
import conta.model.ContaPoupanca;

public class Menu {

	public static void main(String[] args) {
		Scanner ler = new Scanner(System.in);
		int opcao;
		
		//Teste da conta corrente
		ContaCorrente cc1 = new ContaCorrente(1, 123, 1, "Ana", 1000.0f, 10000.0f);
		cc1.visualizar();
		cc1.sacar(1550.0f);
		cc1.visualizar();
		cc1.depositar(100.0f);
		cc1.visualizar();
		
		//Teste da conta poupança
		ContaPoupanca cp1 = new ContaPoupanca(1, 123, 1, "José", 5000.0f, 21);
		cp1.visualizar();
		cp1.sacar(7000.0f);
		cp1.visualizar();
		cp1.depositar(500.0f);
		cp1.visualizar();
		
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
			
			try {
				opcao = ler.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("\nDigite valores inteiros!");
				ler.nextLine();
				opcao = 0;
			}
			
			
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
				
				keyPress();
				break;
			
			case 2:
				System.out.println(Cores.TEXT_WHITE+"Listar todas as contas\n\n");
				
				keyPress();
				break;
				
			case 3:
				System.out.println(Cores.TEXT_WHITE+"Consultar dados da conta - por número\n\n");
				//visualizar();
				
				keyPress();
				break;
				
			case 4:
				System.out.println(Cores.TEXT_WHITE+"Atualizar dados da conta\n\n");
				
				keyPress();
				break;
				
			case 5:
				System.out.println(Cores.TEXT_WHITE+"Apagar a conta\n\n");
				
				keyPress();
				break;
				
			case 6:
				System.out.println(Cores.TEXT_WHITE+"Saque\n\n");
				
				keyPress();
				break;
				
			case 7:
				System.out.println(Cores.TEXT_WHITE+"Depósito\n\n");
				
				keyPress();
				break;
				
			case 8:
				System.out.println(Cores.TEXT_WHITE+"Tranferência entre contas\n\n");
				
				keyPress();
				break;	
			default:
				System.out.println(Cores.TEXT_RED_BOLD+"\nOpção inválida\n"+Cores.TEXT_RESET);
				
				keyPress();
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
	
	public static void keyPress() {
		try {
			System.out.println(Cores.TEXT_RESET+"\n\nPressione enter para continuar...");
			System.in.read();
		} catch (IOException e) {
			System.out.println("Você pressionou uma tecla diferente de enter");
		  }
	}

}
