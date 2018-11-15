package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;


import controller.Fachada;
import model.Area;
import model.Autor;
import model.Categoria;
import model.Editora;
import model.Livro;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class TelaPrincipal {

	private JFrame frame;
	private JPanel panelBooks;
	private JTextField search;
	private JComboBox comboBox;
	private JButton btnProcurar;
	private JLabel[][] matriz;
	private JScrollPane scrollPane;
	private ImageIcon imgIcon;
	private List<Livro> livros;
	private Area a;
	private Autor au;
	private Editora e;
	private Categoria c;
	private TelaInfoLivro telainfolivro;
	private TelaAdm telaAdm;
	private JLabel lbllogo;
	private JLabel lblAcessarPainel;
	
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal window = new TelaPrincipal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public TelaPrincipal() {
		Fachada.inicializar();
		initialize();
	}
	
	
	private List<Livro> inicializarBusca(String tipo, String busca) {
		if(!busca.equals("")) {
			switch (tipo) {
			case "Livro": 
				try {
					livros = Fachada.procurarLivrosPorNome(busca) ;
				} catch (Exception e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, e1.getMessage() );
					
				}
			break;
	
			case "Area": 
				try {
					a = Fachada.procurarLivrosNaArea(busca);
				} catch (Exception e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, e1.getMessage() );
				}
				livros = a.getLivros();
			break;
			
			case "Autor":
				try {
					au = Fachada.procurarLivrosNoAutor(busca);
				} catch (Exception e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, e1.getMessage() );
				}
				livros = au.getLivros();
			break;
			
			case "Categoria": 
				try {
					c = Fachada.procurarLivrosNaCategoria(busca);
				} catch (Exception e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, e1.getMessage() );
				}
				livros = c.getLivros();
			break;
				
			case "Editora": 
				try {
					e = Fachada.procurarLivrosNaEditora(busca);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage() );
					e1.printStackTrace();
				}
				livros = e.getLivros();
			break;
	
			default: livros = Fachada.ListarLivros();
				break;
			}
		}else
			livros = Fachada.ListarLivros();

	return livros;
		
	}
	
	
	private void inicializaMatriz(List<Livro> livros) {
	
		panelBooks.removeAll();
		panelBooks.updateUI();
		
		int tam = livros.size();
		int lin=0, i=0, j=0, col=5;
		
		System.out.println("Total de livros: " + tam);
		
		if(tam % 5 == 0) 
			lin = tam/5;	
		else if(tam % 5  < 5) 
			lin = (tam/5) + 1;
		
	
		matriz = new JLabel[lin][col];
		
		for(Livro l : livros) {
			
			System.out.println(l.getTitulo());
			
				if(j == 5) {
					j = 0;
					i++;
				}
				//System.out.println("L: " + L + ", i: " + i + " , j: " + j);
				BufferedImage bf = null;
				try {
					bf = l.getBufferedImage();
				} catch (Exception e) {	
					e.getMessage();
				}

				imgIcon = new ImageIcon(bf.getScaledInstance(140, 180,Image.SCALE_DEFAULT));				
	
				matriz[i][j] = new JLabel();
				matriz[i][j].setBounds((j*175), (i*240), 150, 200);	
				matriz[i][j].setText("<html><p align='center'>"+ l.getTitulo() +"</p></html>");
				matriz[i][j].setIcon(imgIcon);
				matriz[i][j].setVerticalTextPosition(SwingConstants.BOTTOM);
				matriz[i][j].setVerticalAlignment(SwingConstants.TOP);
				matriz[i][j].setAlignmentX(Component.CENTER_ALIGNMENT);
				matriz[i][j].setHorizontalTextPosition(SwingConstants.CENTER);
				matriz[i][j].setHorizontalAlignment(SwingConstants.CENTER);
				matriz[i][j].setToolTipText(l.getTitulo());
				matriz[i][j].setFont(new Font("NewsGoth BT", Font.BOLD, 12));
				matriz[i][j].setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				matriz[i][j].setOpaque(true);
				
				changeBackground(i,j, l);
				
				panelBooks.add(matriz[i][j]);
				
				j++;
					
			}
	
		
		panelBooks.setPreferredSize(new Dimension(875, 240*lin));
		
	}
	
	private void changeBackground(final int i, final int j, Livro l) {
		
		matriz[i][j].addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent evt) {
	        	 matriz[i][j].setBackground(new Color(32, 178, 170));
	        	 //matriz[i][j].setForeground(new Color(255,255,255));
	         }
	  
	         public final void mouseExited(MouseEvent evt) {
	        	 matriz[i][j].setBackground(new Color(240, 240, 240));
	        	 //matriz[i][j].setForeground(new Color(0,0,0));
	         }
	          
	         public final void mouseClicked(MouseEvent evt) {
	        	 try {
	        		 telainfolivro = new TelaInfoLivro(l);
	        		 telainfolivro.setVisible(true);
					} catch (Exception e1) {				
						e1.printStackTrace();
						
					}
		     }
	      });
	}

	private void initialize() {
		frame = new JFrame();
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				Fachada.finalizar();
			}
		});
		frame.setBounds(100, 100, 1024, 768);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		
		scrollPane = new JScrollPane();
		scrollPane.setBorder(null);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setViewportBorder(null);
		scrollPane.setBounds(67, 173, 875, 551);
		frame.getContentPane().add(scrollPane);
		
		panelBooks = new JPanel();
		panelBooks.setAutoscrolls(true);
		scrollPane.setViewportView(panelBooks);
		panelBooks.setLayout(null);
		

		inicializaMatriz(inicializarBusca("",""));
	
	
		lbllogo = new JLabel("");
		lbllogo.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/images/gbooks.png")));
		lbllogo.setHorizontalTextPosition(SwingConstants.CENTER);
		lbllogo.setHorizontalAlignment(SwingConstants.CENTER);
		lbllogo.setBounds(42, 39, 280, 88);
		frame.getContentPane().add(lbllogo);
		
		
	
		
		search = new JTextField();
		search.setBorder(new LineBorder(new Color(32, 178, 170), 1, true));
		search.setBounds(388, 66, 335, 41);
		frame.getContentPane().add(search);
		search.setColumns(10);
		
		comboBox = new JComboBox();
		comboBox.setToolTipText("Procurar por tipo");
		comboBox.setLightWeightPopupEnabled(false);
		comboBox.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		comboBox.setBackground(Color.WHITE);
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboBox.setBorder(null);
		comboBox.setForeground(new Color(32, 178, 170));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Livro", "Categoria", "Area", "Autor", "Editora"}));
		comboBox.setBounds(733, 65, 130, 41);
		frame.getContentPane().add(comboBox);
		
		btnProcurar = new JButton("Procurar");
		btnProcurar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String busca = search.getText();
				String tipo = comboBox.getSelectedItem().toString();
				
				inicializaMatriz(inicializarBusca(tipo,busca));
				
			}
		});
		btnProcurar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnProcurar.setForeground(new Color(255, 255, 255));
		btnProcurar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnProcurar.setBackground(new Color(32, 178, 170));
		btnProcurar.setBorder(new LineBorder(new Color(32, 178, 170), 1, true));
		btnProcurar.setBounds(873, 66, 89, 40);
		frame.getContentPane().add(btnProcurar);
		
		lblAcessarPainel = new JLabel("Acessar Painel");
		lblAcessarPainel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
	        		 telaAdm= new TelaAdm();
	        		 telaAdm.setVisible(true);
					} catch (Exception e1) {				
						e1.printStackTrace();
						
					}
				
			}
		});
		lblAcessarPainel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblAcessarPainel.setHorizontalAlignment(SwingConstants.CENTER);
		lblAcessarPainel.setForeground(new Color(32, 178, 170));
		lblAcessarPainel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAcessarPainel.setBounds(902, 11, 96, 14);
		frame.getContentPane().add(lblAcessarPainel);
		
	
	}
}
