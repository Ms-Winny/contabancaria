package conta;

import java.io.IOException;
import java.util.*;
import conta.util.Cores;
import conta.controller.ContaController;
import conta.model.ContaCorrente;
import conta.model.ContaPoupanca;

public class Menu {

	public static void main(String[] args) {
		ContaController contas = new ContaController();
		Scanner ler = new Scanner(System.in);
		int opcao, numero, agencia, tipo, aniversario, numeroDestino;
		String titular;
		float saldo, limite, valor;
		
		ContaCorrente cC1 = new ContaCorrente(contas.gerarNumero(), 48, 1, "Weida Winy Rodrigues Viana", 1500f, 2500f);
		contas.cadastrar(cC1);
		
		ContaCorrente cC2 = new ContaCorrente(contas.gerarNumero(), 47, 1, "Gustavo Abreu Pires de Assis", 200f, 600f);
		contas.cadastrar(cC2);
		
		ContaPoupanca cP1 = new ContaPoupanca(contas.gerarNumero(), 50, 2, "Flávia Rodrigues dos Santos", 1000f, 20);
		contas.cadastrar(cP1);
		
		ContaPoupanca cP2 = new ContaPoupanca(contas.gerarNumero(), 47, 2, "Eliane Soares", 15f, 14);
		contas.cadastrar(cP2);
		
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
				
				System.out.println("Digite o número da agência: ");
				agencia = ler.nextInt();
				System.out.println("Digite o nome do titular: ");
				ler.skip("\\R?"); //Serve para ignorar o \r para que o programa aceite nomes compostos
				titular = ler.nextLine();
				
				do {
					System.out.println("Digite o tipo da conta (1 - CC | 2 - CP)");	
					tipo = ler.nextInt();
				} while(tipo < 1 && tipo > 2);
				
				System.out.println("Digite o saldo da conta (R$): ");
				saldo = ler.nextFloat();
				
				switch(tipo) {
				case 1:
					System.out.println("Digite o limite de crédito (R$): ");
					limite = ler.nextFloat();
					contas.cadastrar(new ContaCorrente(contas.gerarNumero(), agencia, tipo, titular, saldo, limite));
					break;
				
				case 2:
					System.out.println("Digite o dia do aniversário da conta: ");
					aniversario = ler.nextInt();
					contas.cadastrar(new ContaPoupanca(contas.gerarNumero(), agencia, tipo, titular, saldo, aniversario));
					break;
				}
				
				keyPress();
				break;
			
			case 2:
				System.out.println(Cores.TEXT_WHITE+"Listar todas as contas\n\n");
				contas.listarTodas();
				keyPress();
				break;
				
			case 3:
				System.out.println(Cores.TEXT_WHITE+"Consultar dados da conta - por número\n\n");
				System.out.println("Digite o número da conta: ");
				numero = ler.nextInt(); 
				contas.procurarPorNumero(numero);
				
				keyPress();
				break;
				
			case 4:
				System.out.println(Cores.TEXT_WHITE+"Atualizar dados da conta\n\n");
				System.out.println("Digite o número da conta: ");
				numero = ler.nextInt();
				
				var buscaConta = contas.buscarNaCollection(numero);
				
				if(buscaConta != null) {
					tipo = buscaConta.getTipo();
					
					System.out.println("Digite o número da agência: ");
					agencia = ler.nextInt();
					System.out.println("Digite o nome do titular: ");
					ler.skip("\\R?"); //Serve para ignorar o \r para que o programa aceite nomes compostos
					titular = ler.nextLine();
					System.out.println("Digite o saldo da conta (R$): ");
					saldo = ler.nextFloat();
					
					switch(tipo) {
					case 1: 
						System.out.println("Digite o valor do limite de crédito (R$): ");
						limite = ler.nextFloat();
						
						contas.atualizar(new ContaCorrente(numero, agencia, tipo, titular, saldo, limite));
						break;
					
					case 2:
						System.out.println("Digite o dia do aniversario da conta: ");
						aniversario = ler.nextInt();
						
						contas.atualizar(new ContaPoupanca(numero, agencia, tipo, titular, saldo, aniversario));
						break;
					
					default:
						System.out.println("Tipo de conta inválido!");
						break;
					}
					
				} else {
					System.out.println("A conta não foi encontrada!");
				}
				
				keyPress();
				break;
				
			case 5:
				System.out.println(Cores.TEXT_WHITE+"Apagar a conta\n\n");
				System.out.println("Digite o número da conta: ");
				numero = ler.nextInt();
				
				contas.deletar(numero);
				
				keyPress();
				break;
				
			case 6:
				System.out.println(Cores.TEXT_WHITE+"Saque\n\n");
				System.out.println("Digite o número da conta: ");
				numero = ler.nextInt();
				
				do {
					System.out.println("Digite o valor a ser sacado (R$): ");
					valor = ler.nextFloat();
				} while(valor <= 0);
				
				contas.sacar(numero, valor);
				
				keyPress();
				break;
				
			case 7:
				System.out.println(Cores.TEXT_WHITE+"Depósito\n\n");
				System.out.println("Digite o número da comta: ");
				numero = ler.nextInt();
				
				do {
					System.out.println("Digite o valor a ser depositado (R$): ");
					valor = ler.nextFloat();
				} while(valor <= 0);
				
				contas.depositar(numero, valor);
				
				keyPress();
				break;
				
			case 8:
				System.out.println(Cores.TEXT_WHITE+"Tranferência entre contas\n\n");
				System.out.println("Digite o número da conta de origem: ");
				numero = ler.nextInt();
				System.out.println("Digite o número da conta de destino: ");
				numeroDestino = ler.nextInt();
				do {
					System.out.println("Digite o valor da transferência (R$): ");
					valor = ler.nextFloat();
				} while(valor <= 0);
				
				contas.transferir(numero, numeroDestino, valor);
				
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
