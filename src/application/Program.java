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

			// Usu�rio realiza escolha
			try {
				escolhaDoUsuario = Integer.parseInt(
						JOptionPane.showInputDialog("1 - Par�metros de sistema \n2 - Reserva de passagens \n3 - Sair"));
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "S� n�meros s�o aceitos");
			}

			switch (escolhaDoUsuario) {
			// --------------Menu Par�metros de sistema---------------------
			case 1: // Menu Par�metros de sistema
				do {
					boolean continuaTentando = true;
					while (continuaTentando) {
						try {
							escolhaDoUsuario = Integer.parseInt(JOptionPane
									.showInputDialog("1 - Cadastrar aeronave \n2 - Cadastrar voo \n3 - Voltar"));
							continuaTentando = false;
						} catch (NumberFormatException e) {
							JOptionPane.showMessageDialog(null, "S� n�meros s�o aceitos");
						}
					}
					switch (escolhaDoUsuario) {

					case 1:
						// Op��o de cadastro de aeronave
						// Exibindo menu
						boolean aviaoCadastrado = false;
						while (!aviaoCadastrado) {
							String modelo = JOptionPane.showInputDialog("Digite o modelo do avi�o");

							int fileiras = -1, assentos = -1;

							// Validando fileiras
							boolean continueTentando = true; // vari�vel para validar dados entrados pelo usu�rio
							while (continueTentando) {
								try {
									fileiras = Integer.parseInt(JOptionPane.showInputDialog("Fileiras"));
									continueTentando = false;
								} catch (NumberFormatException e) {
									JOptionPane.showMessageDialog(null, "S� n�meros s�o aceitos");
								}
							}

							// Validando assentos
							continueTentando = true; // resetando vari�vel
							while (continueTentando) {
								try {
									assentos = Integer.parseInt(JOptionPane.showInputDialog("Assentos"));
									continueTentando = false;
								} catch (NumberFormatException e) {
									JOptionPane.showMessageDialog(null, "S� n�meros s�o aceitos");
								}
							}

							try { // Validando cadastro de avi�o
								avioes.add(new Aviao(modelo, fileiras, assentos));
								JOptionPane.showMessageDialog(null, "Avi�o cadastrado");
								aviaoCadastrado = true;
							} catch (NegativeArraySizeException e) {
								JOptionPane.showMessageDialog(null,
										"Erro de cadastro, fileiras e assentos devem ser n�meros positivos !");
							}
						}
						break;
					case 2: // Op��o de cadastro de voo

						int numeroVoo = -1;
						String dataVoo = "", horaVoo = "";
						Aviao aviaoSelecionado = null;

						// Validando entrada do modelo do avi�o
						while (true) {
							String modelo = JOptionPane.showInputDialog("Digite o modelo do avi�o"); // Considerando que
																										// o
							// modelo do avi�o �
							// o ID

							// Selecionando avi�o pelo modelo digitado
							for (int i = 0; i < avioes.size(); i++) {
								if (avioes.get(i).getModelo().equals(modelo)) {
									aviaoSelecionado = avioes.get(i);
								}
							}
							// Verifica se o avi�o foi encontrado
							if (aviaoSelecionado != null) {
								break;
							} else {
								JOptionPane.showMessageDialog(null, "Digite um modelo v�lido !");
							}
						}

						// Lendo numero do voo
						boolean continueTentando = true; // vari�vel para validar dados entrados pelo usu�rio at� que
															// ele
															// acerte
						while (continueTentando) {
							try {
								numeroVoo = Integer.parseInt(JOptionPane.showInputDialog("N�mero do voo"));
								continueTentando = false;
							} catch (NumberFormatException e) {
								JOptionPane.showMessageDialog(null, "S� n�meros s�o aceitos");
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
				} while (escolhaDoUsuario != 3); // Menu de par�metro de usu�rio
				escolhaDoUsuario = 0; // resetando escolha do usu�rio
				break;
			// --------------Menu Par�metros de sistema---------------------
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
							JOptionPane.showMessageDialog(null, "S� n�meros s�o aceitos");
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
								JOptionPane.showMessageDialog(null, "S� n�meros s�o aceitos");
							}
						}

						do {
							// ====================== 1- Op��o de registrar passageiro======================
							if (escolhaDoUsuario == 1) {
								String nome, cpf;

								nome = JOptionPane.showInputDialog("Nome");
								cpf = JOptionPane.showInputDialog("Cpf");

								passageiros.add(new Passageiro(nome, cpf));
								// ======================1- Op��o de registrar passageiro======================
							}
							// ======================2- Op��o Reservar assento=============================
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
										JOptionPane.showMessageDialog(null, "Passageiro n�o existe !");
									} else {
										break;
									}
								}

								// Selecionando Voo
								Voo vooSelecionado = null;
								int nroVoo = -1;

								while (true) {
									vooSelecionado = null;

									// Selecionando n�mero do Voo (id)
									continuaTentando = true;
									while (continuaTentando) {
										try {
											nroVoo = Integer.parseInt(JOptionPane.showInputDialog("N�mero do voo"));
											continuaTentando = false;
										} catch (NumberFormatException e) {
											JOptionPane.showMessageDialog(null, "S� n�meros s�o aceitos");
										}
									}

									// Tentando selecionar um voo
									for (int i = 0; i < arrayVoo.length; i++) {
										try {
											if (arrayVoo[i].getNro() == nroVoo) {
												vooSelecionado = arrayVoo[i];
											}
										} catch (NullPointerException e) {
											JOptionPane.showMessageDialog(null, "Voo n�o existe ");
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
										JOptionPane.showMessageDialog(null, "S� n�meros s�o aceitos");
									}
								}

								// Selecionando assento
								continuaTentando = true;
								while (continuaTentando) {
									try {
										assentoSelecionado = Integer.parseInt(JOptionPane.showInputDialog("Assento"));
										continuaTentando = false;
									} catch (NumberFormatException e) {
										JOptionPane.showMessageDialog(null, "S� n�meros s�o aceitos");
									}
								}

								// Reservando assento
								boolean assentoReservado = false;
								while (!assentoReservado) {
									// Vari�vel que indica se o assento est� dispon�vel
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
											JOptionPane.showMessageDialog(null, "Assento n�o existe");
										}
									} else { // Se o assento estiver ocupado
										JOptionPane.showMessageDialog(null,
												"Assento j� est� ocupado. \nSelecione outra assento.");
									}
								}
							}
							// ======================2- Op��o Reservar assento=============================
						} while (escolhaDoUsuario != 3);
						escolhaDoUsuario = 0; // resetando escolha do usu�rio para ficar na op��o de fazer reserva
						break;
					// ------------------Fazer reserva-----------------

					case 2:
						// -----------2 - Consultar lugares vazios-----------------
						// Escolhendo um voo
						Voo vooSelecionado = null;

						while (vooSelecionado == null) {
							vooSelecionado = null;

							// Seleciona um n�mero de voo
							int nroSelecionado = -1;
							continuaTentando = true;
							while (continuaTentando) {
								try {
									nroSelecionado = Integer.parseInt(JOptionPane.showInputDialog("N�mero do voo"));
									continuaTentando = false;
								} catch (NumberFormatException e) {
									JOptionPane.showMessageDialog(null, "S� n�meros s�o aceitos");
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
									JOptionPane.showMessageDialog(null, "Voo n�o existe ");
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
				escolhaDoUsuario = 0; // resetando escolha do usu�rio
				break;
			// ------------Menu Reserva de passagem---------------------------
			}
		} while (escolhaDoUsuario != 3);
	}
}