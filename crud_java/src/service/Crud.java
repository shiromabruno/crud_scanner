package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import DB.JdbcConnection;

public class Crud {
	
	public String nome;
	public Integer idade;
	public String email;
	
	public Crud() {
		
	}
	
	public void create() throws SQLException {
		JdbcConnection jdbcConnection = new JdbcConnection();
		Connection conn = jdbcConnection.getConnection();
		
		System.out.println("Cadastro de um novo registro:");
		Scanner sc = new Scanner(System.in);
		System.out.print("Nome: ");
		String nome = sc.nextLine();
		System.out.print("Idade: ");
		int idade = sc.nextInt();
		sc.nextLine();
		System.out.print("Email: ");
		String email = sc.nextLine();
		
		String sql = "INSERT INTO agenda (nome, idade, email) VALUES (?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, nome);
		ps.setInt(2, idade);
		ps.setString(3, email);
		ps.execute();
		ps.close();
		
		System.out.println("Cadastro realizado com sucesso!\n");
	}
	
	public void read() throws SQLException {
		JdbcConnection jdbcConnection = new JdbcConnection();
		Connection conn = jdbcConnection.getConnection();
		
		System.out.println("Leitura de registros:");
		String sql = "SELECT * FROM agenda";
		Statement st = conn.createStatement();
		ResultSet resultSet = st.executeQuery(sql);
		
		while(resultSet.next()) {
			System.out.print(resultSet.getString("nome"));
			System.out.print(" ");
			System.out.print(resultSet.getInt("idade"));
			System.out.print(" ");
			System.out.print(resultSet.getString("email"));
			System.out.println();
		}
	}
	
	public void update() throws SQLException {
		JdbcConnection jdbcConnection = new JdbcConnection();
		Connection conn = jdbcConnection.getConnection();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Alteração de registros: ");
		System.out.println("1. Nome");
		System.out.println("2. Idade");
		System.out.println("3. Email");
		System.out.print("Selecione o campo a ser alterado: ");
		int escolha = sc.nextInt();
		
		if (escolha == 1) {
			System.out.println("Informe o nome a ser alterado: ");
			sc.nextLine();
			String nome_anterior = sc.nextLine();
			System.out.println("Informe o novo nome a ser adicionado: ");
			String nome_posterior = sc.nextLine();
	
			String sqlUpdate = "UPDATE agenda SET nome = ? WHERE nome = ?";
			PreparedStatement ps = conn.prepareStatement(sqlUpdate);
			ps.setString(1, nome_posterior);
			ps.setString(2, nome_anterior);	
			ps.execute();
			ps.close();
			System.out.println("Alteração realizada com sucesso!");
		}
		else if (escolha == 2) {
			System.out.println("Informe a idade a ser alterada: ");
			int idade_anterior = sc.nextInt();
			System.out.println("Informe a nova idade a ser adicionada: ");
			int idade_posterior = sc.nextInt();
			
			String sqlUpdate = "UPDATE agenda SET idade = ? WHERE idade = ?";
			PreparedStatement ps = conn.prepareStatement(sqlUpdate);
			ps.setInt(1, idade_posterior);
			ps.setInt(2, idade_anterior);	
			ps.execute();
			ps.close();
			System.out.println("Alteração realizada com sucesso!");
		}
		else if (escolha == 3) {
			System.out.println("Informe o email a ser alterado: ");
			sc.nextLine();
			String email_anterior = sc.nextLine();
			System.out.println("Informe o novo email a ser adicionado: ");
			String email_posterior = sc.nextLine();
	
			String sqlUpdate = "UPDATE agenda SET email = ? WHERE email = ?";
			PreparedStatement ps = conn.prepareStatement(sqlUpdate);
			ps.setString(1, email_posterior);
			ps.setString(2, email_anterior);	
			ps.execute();
			ps.close();
			System.out.println("Alteração realizada com sucesso!");
		}
	}
	
	public void delete() throws SQLException {
		JdbcConnection jdbcConnection = new JdbcConnection();
		Connection conn = jdbcConnection.getConnection();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Deleção de registros: ");
		System.out.println("1. Nome");
		System.out.println("2. Idade");
		System.out.println("3. Email");
		System.out.print("Selecione o campo a ser alterado: ");
		int escolha = sc.nextInt();
		
		if (escolha == 1) {
			System.out.println("Informe o nome: ");
			sc.nextLine();
			String nome = sc.nextLine();
			String sql = "DELETE FROM agenda WHERE nome = '" + nome + "'";
			Statement st = conn.createStatement();
			st.executeUpdate(sql);
		}
		else if (escolha == 2) {
			System.out.println("Informe a idade: ");
			int idade = sc.nextInt();
			String sql = "DELETE FROM agenda WHERE idade = '" + idade + "'";
			Statement st = conn.createStatement();
			st.executeUpdate(sql);
		}
		else if (escolha == 3) {
			System.out.println("Informe o email: ");
			sc.nextLine();
			String email = sc.nextLine();
			String sql = "DELETE FROM agenda WHERE email = '" + email + "'";
			Statement st = conn.createStatement();
			st.executeUpdate(sql);
		}
	}


	
	

}
