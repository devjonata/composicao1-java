package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entidades.Departamento;
import entidades.HorasContrato;
import entidades.Trabalhador;
import entidades.enums.NivelTrabalhador;

public class Programa {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Informe o nome do departamento: ");
		String departamento = sc.next();
		System.out.println();
		System.out.println("Informe os dados do trabalhador:");
		System.out.print("Nome: ");
		String nome = sc.next();
		System.out.print("Nivel: ");
		String nivel = sc.next();
		System.out.print("Salario base: ");
		Double salarioBase = sc.nextDouble();
		
		Trabalhador trabalhador = new Trabalhador(nome, NivelTrabalhador.valueOf(nivel), salarioBase, new Departamento(departamento));
		
		System.out.print("Quantos contratos para o trabalhador? ");
		int quantidade = sc.nextInt();
		
		for (int i=1; i<=quantidade; i++) {
			System.out.println();
			System.out.println("Dados do " + i + "º contrato: ");
			System.out.print("Data (DD/MM/YYYY): ");
			Date data = sdf.parse(sc.next());
			System.out.print("Valor por hora: ");
			double valorPorHora = sc.nextDouble();
			System.out.print("Duração (Horas): ");
			int horas = sc.nextInt();
			HorasContrato contrato = new HorasContrato(data, valorPorHora, horas);
			trabalhador.adicionarContrato(contrato);
		}
		
		System.out.println();
		System.out.print("Informe o mes e ano para calcular a renda (MM/AAAA): ");
		String mesEano = sc.next();
		int mes = Integer.parseInt(mesEano.substring(0, 2));
		int ano = Integer.parseInt(mesEano.substring(3));
		System.out.println("Nome: " + trabalhador.getNome());
		System.out.println("Departamento: " + trabalhador.getDepartamento().getNome());
		System.out.println("Renda de " + mesEano + ": " + String.format("%.2f",trabalhador.renda(mes, ano)));
		
		
		sc.close();
	}

}
