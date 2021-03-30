package application;

import java.sql.SQLException;
import java.util.Scanner;

import service.Crud;

public class Main {

	public static void main(String[] args) throws SQLException {
	
		Scanner sc = new Scanner(System.in);
		Crud cd = new Crud();
		
		System.out.println("===========================");
		System.out.println("      CRUD - SIMPLES");
		System.out.println("===========================");
		System.out.println("Opções: ");
		System.out.println("1. Create");
		System.out.println("2. Read");
		System.out.println("3. Update");
		System.out.println("4. Delete");
		System.out.print("Informe a opção desejada: ");
		int escolha = sc.nextInt();
		System.out.println();
		
		if (escolha == 1) {
			cd.create();
		}
		else if (escolha == 2) {
			cd.read();
		}
		else if (escolha == 3) {
			cd.update();
		}
		else if (escolha == 4) {
			cd.delete();
		}
	}
}
