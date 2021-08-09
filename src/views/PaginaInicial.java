package views;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class PaginaInicial extends JFrame{
	
	private JLabel lbTitulo;
	private JButton btParametroDoSistema, btReservaPassagem, btSair;
	private Container cp;
	
	public PaginaInicial() {
		// Atribuindo valores para componentes
		lbTitulo = new JLabel("Home", SwingConstants.CENTER);
		btParametroDoSistema = new JButton("Parâmetros do Sistema");
		btReservaPassagem = new JButton("Reserva de passagem");
		btSair = new JButton("Sair");
		
		// Configurando Frame
		setTitle("Home");
		setSize(800,500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Estilização e layout do componentes
		lbTitulo.setFont(new Font("Arial",Font.BOLD,36));
		lbTitulo.setBounds(231,57,338,50);
		btParametroDoSistema.setBounds(231,140,338,50);
		btReservaPassagem.setBounds(231,223,338,50);
		btSair.setBounds(231,306,338,50);
		
		//Configurando contaier
		cp = getContentPane(); // instancia do container
		cp.setLayout(null);
		cp.setBackground(new Color(180,205,205));
		
		//Adicionando componentes ao container
		cp.add(lbTitulo);
		cp.add(btParametroDoSistema);
		cp.add(btReservaPassagem);
		cp.add(btSair);
		
		//Adicionando listeners
		btParametroDoSistema.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btParametroSistemaAction();
			}
		});
	}

	private void btParametroSistemaAction() {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new PaginaInicial().setVisible(true);
			}
		});
	}
	
}
