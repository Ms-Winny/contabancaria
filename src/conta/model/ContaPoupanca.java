package conta.model;

import conta.util.Cores;

public class ContaPoupanca extends Conta{
	
	int aniversario;

	public ContaPoupanca(int numero, int agencia, int tipo, String titular, float saldo, int aniversario) {
		super(numero, agencia, tipo, titular, saldo);
		this.aniversario = aniversario;

	}

	public int getAniversario() {
		return aniversario;
	}
	public void setAniversario(int aniversario) {
		this.aniversario = aniversario;
	}
	
	@Override
	public void visualizar() {
		super.visualizar();
		System.out.println(Cores.TEXT_CYAN_BOLD_BRIGHT+" Aniversário da conta: "+this.aniversario+Cores.TEXT_RESET);
	}

}
