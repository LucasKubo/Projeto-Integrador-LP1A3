package application;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import entities.Aviao;
import entities.Passageiro;
import entities.Voo;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Menu
		Voo[] arrayVoo = new Voo[10];
		List<Aviao> avioes = new ArrayList<Aviao>();
		List<Passageiro> passageiros = new ArrayList<Passageiro>();

		Integer escolhaDoUsuario = 0;

		do {
			// Menu principal

			// Usuário realiza escolha
			try {
				escolhaDoUsuario = Integer.parseInt(
						JOptionPane.showInputDialog("1 - Parâmetros de sistema \n2 - Reserva de passagens \n3 - Sair"));
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Só números são aceitos");
			}

			switch (escolhaDoUsuario) {
			// --------------Menu Parâmetros de sistema---------------------
			case 1: // Menu Parâmetros de sistema
				do {
					boolean continuaTentando = true;
					while (continuaTentando) {
						try {
							escolhaDoUsuario = Integer.parseInt(JOptionPane
									.showInputDialog("1 - Cadastrar aeronave \n2 - Cadastrar voo \n3 - Voltar"));
							continuaTentando = false;
						} catch (NumberFormatException e) {
							JOptionPane.showMessageDialog(null, "Só números são aceitos");
						}
					}
					switch (escolhaDoUsuario) {

					case 1:
						// Opção de cadastro de aeronave
						// Exibindo menu
						boolean aviaoCadastrado = false;
						while (!aviaoCadastrado) {
							String modelo = JOptionPane.showInputDialog("Digite o modelo do avião");

							int fileiras = -1, assentos = -1;

							// Validando fileiras
							boolean continueTentando = true; // variável para validar dados entrados pelo usuário
							while (continueTentando) {
								try {
									fileiras = Integer.parseInt(JOptionPane.showInputDialog("Fileiras"));
									continueTentando = false;
								} catch (NumberFormatException e) {
									JOptionPane.showMessageDialog(null, "Só números são aceitos");
								}
							}

							// Validando assentos
							continueTentando = true; // resetando variável
							while (continueTentando) {
								try {
									assentos = Integer.parseInt(JOptionPane.showInputDialog("Assentos"));
									continueTentando = false;
								} catch (NumberFormatException e) {
									JOptionPane.showMessageDialog(null, "Só números são aceitos");
								}
							}

							try { // Validando cadastro de avião
								avioes.add(new Aviao(modelo, fileiras, assentos));
								JOptionPane.showMessageDialog(null, "Avião cadastrado");
								aviaoCadastrado = true;
							} catch (NegativeArraySizeException e) {
								JOptionPane.showMessageDialog(null,
										"Erro de cadastro, fileiras e assentos devem ser números positivos !");
							}
						}
						break;
					case 2: // Opção de cadastro de voo

						int numeroVoo = -1;
						String dataVoo = "", horaVoo = "";
						Aviao aviaoSelecionado = null;

						// Validando entrada do modelo do avião
						while (true) {
							String modelo = JOptionPane.showInputDialog("Digite o modelo do avião"); // Considerando que
																										// o
							// modelo do avião é
							// o ID

							// Selecionando avião pelo modelo digitado
							for (int i = 0; i < avioes.size(); i++) {
								if (avioes.get(i).getModelo().equals(modelo)) {
									aviaoSelecionado = avioes.get(i);
								}
							}
							// Verifica se o avião foi encontrado
							if (aviaoSelecionado != null) {
								break;
							} else {
								JOptionPane.showMessageDialog(null, "Digite um modelo válido !");
							}
						}

						// Lendo numero do voo
						boolean continueTentando = true; // variável para validar dados entrados pelo usuário até que
															// ele
															// acerte
						while (continueTentando) {
							try {
								numeroVoo = Integer.parseInt(JOptionPane.showInputDialog("Número do voo"));
								continueTentando = false;
							} catch (NumberFormatException e) {
								JOptionPane.showMessageDialog(null, "Só números são aceitos");
							}
						}

						// Lendo data do voo
						dataVoo = JOptionPane.showInputDialog("Data do voo");

						// Lendo hora do voo
						horaVoo = JOptionPane.showInputDialog("Hora do Voo");

						// Cadastrando voo
						for (int i = 0; i < arrayVoo.length; i++) {
							try {
								if (arrayVoo[i] == null) {
									arrayVoo[i] = new Voo(aviaoSelecionado, numeroVoo, dataVoo, horaVoo);
									JOptionPane.showMessageDialog(null, "Voo cadastrado");
									break;
								}
							} catch (IndexOutOfBoundsException e) {
								JOptionPane.showMessageDialog(null, e.getMessage());
							}
						}
						break;
					case 3:
						break;
					}
				} while (escolhaDoUsuario != 3); // Menu de parâmetro de usuário
				escolhaDoUsuario = 0; // resetando escolha do usuário
				break;
			// --------------Menu Parâmetros de sistema---------------------
			// --------Menu Reserva de passagem------------------
			case 2:
				do {
					// Exibindo menu
					boolean continuaTentando = true;
					while (continuaTentando) {
						try {
							escolhaDoUsuario = Integer.parseInt(JOptionPane.showInputDialog(
									"1 - Fazer reserva \n2 - Consultar lugares vazios \n3 - Consultar reservas realizadas \n4 - Voltar"));
							continuaTentando = false;
						} catch (NumberFormatException e) {
							JOptionPane.showMessageDialog(null, "Só números são aceitos");
						}
					}
					// -------------------------1 - Fazer Reserva-------------------------
					switch (escolhaDoUsuario) {
					case 1:
						continuaTentando = true;
						while (continuaTentando) {
							try {
								escolhaDoUsuario = Integer.parseInt(JOptionPane.showInputDialog(
										"1 - Registrar passageiro \n2 - Reservar assento\n3 - Voltar"));
								continuaTentando = false;
							} catch (NumberFormatException e) {
								JOptionPane.showMessageDialog(null, "Só números são aceitos");
							}
						}

						do {
							// ====================== 1- Opção de registrar passageiro======================
							if (escolhaDoUsuario == 1) {
								String nome, cpf;

								nome = JOptionPane.showInputDialog("Nome");
								cpf = JOptionPane.showInputDialog("Cpf");

								passageiros.add(new Passageiro(nome, cpf));
								// ======================1- Opção de registrar passageiro======================
							}
							// ======================2- Opção Reservar assento=============================
							else if (escolhaDoUsuario == 2) {

								// Selecionando passageiro
								Passageiro passageiroSelecionado = null;
								String cpfPassageiro;

								// Verificando existencia do passageiro
								while (true) {
									passageiroSelecionado = null;
									cpfPassageiro = JOptionPane.showInputDialog("Cpf do passageiro");
									for (int i = 0; i < passageiros.size(); i++) {
										if (passageiros.get(i).getCpf().equals(cpfPassageiro)) {
											passageiroSelecionado = passageiros.get(i);
										}
									}
									if (passageiroSelecionado == null) {
										JOptionPane.showMessageDialog(null, "Passageiro não existe !");
									} else {
										break;
									}
								}

								// Selecionando Voo
								Voo vooSelecionado = null;
								int nroVoo = -1;

								while (true) {
									vooSelecionado = null;

									// Selecionando número do Voo (id)
									continuaTentando = true;
									while (continuaTentando) {
										try {
											nroVoo = Integer.parseInt(JOptionPane.showInputDialog("Número do voo"));
											continuaTentando = false;
										} catch (NumberFormatException e) {
											JOptionPane.showMessageDialog(null, "Só números são aceitos");
										}
									}

									// Tentando selecionar um voo
									for (int i = 0; i < arrayVoo.length; i++) {
										try {
											if (arrayVoo[i].getNro() == nroVoo) {
												vooSelecionado = arrayVoo[i];
											}
										} catch (NullPointerException e) {
											JOptionPane.showMessageDialog(null, "Voo não existe ");
											break;
										}
									}

									// Verifica se um voo foi selecionado
									if (vooSelecionado != null) {
										JOptionPane.showMessageDialog(null, "Voo existe !");
										break;
									}
								}

								// Selecionando lugar
								int fileiraSelecionada = -1, assentoSelecionado = -1;

								// Selecionando fileira
								continuaTentando = true;
								while (continuaTentando) {
									try {
										fileiraSelecionada = Integer.parseInt(JOptionPane.showInputDialog("Fileira"));
										continuaTentando = false;
									} catch (NumberFormatException e) {
										JOptionPane.showMessageDialog(null, "Só números são aceitos");
									}
								}

								// Selecionando assento
								continuaTentando = true;
								while (continuaTentando) {
									try {
										assentoSelecionado = Integer.parseInt(JOptionPane.showInputDialog("Assento"));
										continuaTentando = false;
									} catch (NumberFormatException e) {
										JOptionPane.showMessageDialog(null, "Só números são aceitos");
									}
								}

								// Reservando assento
								boolean assentoReservado = false;
								while (!assentoReservado) {
									// Variável que indica se o assento está disponível
									boolean assentoDisponivel = vooSelecionado.getAviao()
											.verificaLugarOcupado(fileiraSelecionada, assentoSelecionado);

									if (assentoDisponivel) {
										// Passageiro registrado para o lugar selecionado
										try {
											vooSelecionado.getAviao().setPassageiro(fileiraSelecionada,
													assentoSelecionado, passageiroSelecionado);
											JOptionPane.showMessageDialog(null, "Assento reservado");
											assentoReservado = true;
										} catch (ArrayIndexOutOfBoundsException e) {
											JOptionPane.showMessageDialog(null, "Assento não existe");
										}
									} else { // Se o assento estiver ocupado
										JOptionPane.showMessageDialog(null,
												"Assento já está ocupado. \nSelecione outra assento.");
									}
								}
							}
							// ======================2- Opção Reservar assento=============================
						} while (escolhaDoUsuario != 3);
						escolhaDoUsuario = 0; // resetando escolha do usuário para ficar na opção de fazer reserva
						break;
					// ------------------Fazer reserva-----------------

					case 2:
						// -----------2 - Consultar lugares vazios-----------------
						// Escolhendo um voo
						Voo vooSelecionado = null;

						while (vooSelecionado == null) {
							vooSelecionado = null;

							// Seleciona um número de voo
							int nroSelecionado = -1;
							continuaTentando = true;
							while (continuaTentando) {
								try {
									nroSelecionado = Integer.parseInt(JOptionPane.showInputDialog("Número do voo"));
									continuaTentando = false;
								} catch (NumberFormatException e) {
									JOptionPane.showMessageDialog(null, "Só números são aceitos");
								}
							}

							// Tentando achar o voo pelo numero passado
							for (int i = 0; i < arrayVoo.length; i++) {
								try {
									if (arrayVoo[i].getNro() == nroSelecionado) {
										vooSelecionado = arrayVoo[i];
										break;
									}
								} catch (NullPointerException e) {
									JOptionPane.showMessageDialog(null, "Voo não existe ");
									break;
								}
							}
						}

						// Contando lugares vazios
						int lugaresVazio = 0;
						for (int i = 0; i < vooSelecionado.getAviao().getLugares().length; i++) {
							for (int j = 0; j < vooSelecionado.getAviao().getLugares()[i].length; j++) {
								if (vooSelecionado.getAviao().getLugares()[i][j] == null) {
									lugaresVazio++;
								}
							}
						}

						// Mostrando lugares vazio
						JOptionPane.showMessageDialog(null, "Lugares vazio: " + lugaresVazio);
						break;
					// ------------2 - Consultar lugares vazios-------------------
					case 3:
						// ----------3 - Consultar reservas realizadas---------------

						break;
					// ---------------3 - Consultar reservas realizadas--------------
					case 4:
						break;
					}
				} while (escolhaDoUsuario != 4); // Menu de reserva
				escolhaDoUsuario = 0; // resetando escolha do usuário
				break;
			// ------------Menu Reserva de passagem---------------------------
			}
		} while (escolhaDoUsuario != 3);
	}
}