package conta.controller;

import java.util.ArrayList;
import conta.model.Conta;
import conta.repository.ContaRepository;
import conta.util.Cores;

public class ContaController implements ContaRepository{
	
	private ArrayList<Conta> listaContas = new ArrayList<Conta>();
	int numero = 0;

	@Override
	public void procurarPorNumero(int numero) {
		var conta = buscarNaCollection(numero);
		if(conta != null) {
			conta.visualizar();
		} else {
			System.out.println(Cores.TEXT_RED_BOLD+"Conta número: "+ numero +" não foi encontrada no sistema!"+Cores.TEXT_RESET);
		}
	}

	@Override
	public void listarTodas() {
		for(var conta : listaContas) {
			conta.visualizar();
		}
	}

	@Override
	public void cadastrar(Conta conta) {
		listaContas.add(conta);
		System.out.println(Cores.TEXT_GREEN_BOLD_BRIGHT+"\nA conta de número "+conta.getNumero()+" foi cadastrada com sucesso!"+Cores.TEXT_RESET);
	}

	@Override
	public void atualizar(Conta conta) {
		var buscaConta = buscarNaCollection(conta.getNumero());
		if(buscaConta != null) {
			listaContas.set(listaContas.indexOf(buscaConta), conta);
			System.out.println(Cores.TEXT_GREEN_BOLD_BRIGHT+"A conta de número: "+conta.getNumero()+" foi atualizada com sucesso!"+Cores.TEXT_RESET);
			
		} else {
			System.out.println(Cores.TEXT_RED_BOLD+"Conta número: "+ conta.getNumero() +" não foi encontrada no sistema!"+Cores.TEXT_RESET);
		}
	}

	@Override
	public void deletar(int numero) {
		var conta = buscarNaCollection(numero);
		
		if(conta != null) {
			if(listaContas.remove(conta) == true) {
				System.out.println(Cores.TEXT_GREEN_BOLD_BRIGHT+"Conta de número: "+numero+" deletada com sucesso!"+Cores.TEXT_RESET);
			} 
		} else {
			System.out.println(Cores.TEXT_RED_BOLD+"Conta número: "+numero+" não foi encontrada no sistema!"+Cores.TEXT_RESET);
		}
	}

	@Override
	public void sacar(int numero, float valor) {
		var conta = buscarNaCollection(numero);
		
		if(conta != null) {
			if(conta.sacar(valor) == true) {
				System.out.println(Cores.TEXT_GREEN_BOLD_BRIGHT+"Saque na conta de número: "+numero+" efetuado com sucesso!"+Cores.TEXT_RESET);
			} 
		} else {
				System.out.println(Cores.TEXT_RED_BOLD+"Conta número: "+numero+" não foi encontrada no sistema!"+Cores.TEXT_RESET);
			}
		
	}

	@Override
	public void depositar(int numero, float valor) {
		var conta = buscarNaCollection(numero);
		
		if(conta != null) {
			conta.depositar(valor);
			System.out.println(Cores.TEXT_GREEN_BOLD_BRIGHT+"Depósito na conta de número: "+numero+" efetuado com sucesso!"+Cores.TEXT_RESET);
		} else {
			System.out.println(Cores.TEXT_RED_BOLD+"Conta número: "+numero+" não foi encontrada no sistema!"+Cores.TEXT_RESET);
		}
		
	}

	@Override
	public void transferir(int numeroOrigem, int numeroDestino, float valor) {
		var contaOrigem = buscarNaCollection(numeroOrigem);
		var contaDestino = buscarNaCollection(numeroDestino);
		
		if(contaOrigem != null && contaDestino != null) {
			if(contaOrigem.sacar(valor) == true) {
				contaDestino.depositar(valor);
				System.out.println(Cores.TEXT_GREEN_BOLD_BRIGHT+"A transferência foi efetuada com sucesso!"+Cores.TEXT_RESET);
			}
	
		} else {
			System.out.println(Cores.TEXT_RED_BOLD+"A conta de origem/destino não foi encontrada no sistema!"+Cores.TEXT_RESET);
		}
		
	}

	public int gerarNumero() {
		return ++ numero ;
	}
	
	public Conta buscarNaCollection(int numero) {
		for (var conta : listaContas) {
			if (conta.getNumero() == numero) {
				return conta;
			}
		}
		return null;
	}
}
