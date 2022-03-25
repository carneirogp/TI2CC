package com.ti2cc;

import java.util.*;
import java.io.BufferedReader;
import java.io.*;

public class Principal {

	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in, "ISO-8859-1"));


		DAO dao = new DAO();

		dao.conectar();

		int op = 1;

		do {
			// Receber a opcao do carro
		System.out.println("1 - Listar");
		System.out.println("2 - Inserir");
		System.out.println("3 - Excluir");
		System.out.println("4 - Atualizar");
		System.out.println("5 - Sair");

		op = sc.nextInt();

		Carro carro = new Carro();
		Carro[] carros = dao.getCarros();

		if (op == 1) {
			// Mostrar elemento na tabela
			System.out.println("==== Mostrar usuários === ");
			for (int i = 0; i < carros.length; i++) {
				System.out.println(carros[i].toString());
			}

		} else if (op == 2) {

			// Inserir um elemento na tabela
			System.out.println("Codido que sera inserido: ");
			carro.setCodigo(sc.nextInt());
			System.out.println("Nome que sera inserido: ");
			carro.setNome(br.readLine());
			System.out.println("Senha que sera inserido: ");
			carro.setMarca(br.readLine());
			System.out.println("Sexo que sera inserido: ");
			carro.setAno(sc.nextInt());
			if (dao.inserirCarro(carro) == true) {
				System.out.println("Inserção com sucesso -> " + carro.toString());
			}

		} else if (op == 3) {

			// Excluir usuário
			System.out.println("Codigo que sera excluido: ");
			int codigo = sc.nextInt();
			dao.excluirCarro(codigo);
		} else if (op == 4) {

			// Atualizar usuário
			System.out.println("Codigo que sera atualizado: ");
			carro.setCodigo(sc.nextInt());
			System.out.println("Login que sera atualizado: ");
			carro.setNome(br.readLine());
			System.out.println("Senha que sera atualizado: ");
			carro.setMarca(br.readLine());
			System.out.println("Sexo que sera atualizado: ");
			carro.setAno(sc.nextInt());
			if (dao.atualizarCarro(carro) == true) {
				System.out.println("Atualizacao com sucesso -> " + carro.toString());
			}
		} else if (op == 5) {
			dao.close();
		}
			
		} while (op != 5);
		
	}
}