package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileFilter;
import javax.swing.table.DefaultTableModel;

import controller.Fachada;
import model.Area;
import model.Autor;
import model.Categoria;
import model.Editora;
import model.Livro;

public class TelaAdm extends JFrame {

	private JTabbedPane tabbedPane;
	
	private JPanel panelCategoria;
	private JPanel panelArea;
	private JPanel panelEditora;
	private JPanel panelAutor;
	private JPanel panelLivro;
	private JPanel panelConvidado;
	
	private JTextField tfNomeCat;
	
	private JLabel lblNomeCat;
	private JLabel lblTitleCat;
	private JLabel lblPainelAdministrativo;
	private JLabel lblTileCadastroDeArea;
	private JLabel lblNomeArea;
	private JLabel lblNivelArea;
	private JLabel lblCadastroDeConvidado;
	private JLabel lblNomeConv;
	private JLabel lblLoginConv;
	private JLabel lblSenhaConv;
	private JLabel lblEmailConv;
	private JLabel lblImagemConv;
	private JLabel lblFotoConv;
	private JLabel lblCadEdit;
	private JLabel lblNomeEdit;
	private JLabel lblTelEdit;
	private JLabel lblTel2edit;
	private JLabel lblEmailEdit;
	private JLabel lblSiteEdi;
	private JLabel lblCidadeEdit;
	private JLabel lblUfEdit;
	private JLabel lblEndEdit;
	private JLabel lblNomeAutor;
	private JLabel lblEstadoAutor;
	private JLabel lblPaisAutor;
	private JLabel lblTelAutor;
	private JLabel lblCelAutor;
	private JLabel lblEmailAutor;
	private JLabel lblImgAutor;
	private JLabel lblFotoAutor;
	private JLabel lblCidadeAutor;
	private JLabel lblCadastroDeAutor;
	private JLabel lblOcupAutor;
	private JLabel lblTokenAutor;
	private JLabel lblAreasAutor;
	private JLabel lblTitleCadLivro;
	private JLabel lblTitLivro;
	private JLabel lblCategoria;	
	private JLabel lblEditora;
	private JLabel lblResumoLivro;
	private JLabel lblImgLivro;
	private JLabel lblCapaLivro;
	private JLabel lblEdicaoLivro;
	private JLabel lblAnoLivro;
	private JLabel lblPagLivro;
	private JLabel lblTagsLivro;
	private JLabel ilbInfoLivro;
	private JLabel lblAreasLivro;
	private JLabel lblAutoresLivro;
	
	private JButton btnCadCat;
	private JButton btnCadArea;
	private JButton btnCadConv;
	private JButton btnSelecionarConv;
	private JButton btnCadEdit;
	private JButton btnCadAutor;
	private JButton btnImgAutor;
	private JButton btnCadLivro;
	private JButton btnImgLivro;
	private JButton btnVisLivrosCat;
	private JButton btnVisLivrosArea;
	private JButton btnApagarCat;
	private JButton btnApagarArea;
	private JButton btnApagarEditora;
	private JButton btnAlterarCat;
	private JButton btnAlterarArea;
	private JButton btnSalvarrCat;
	private JButton btnSalvarArea;
	
	private JTextField tfNomeArea;
	private JTextField tfNivelArea;
	private JTextField tfNomeConv;
	private JTextField tfLoginConv;
	private JTextField tfSenhaConv;	
	private JTextField tfEmailConv;	
	private JTextField tfImagemConv;
	private JTextField tfNomeEdit;
	private JTextField tfTelEdit;
	private JTextField tfTel2Edit;
	private JTextField tfEmailEdit;
	private JTextField tfSiteEdit;
	private JTextField tfCidadeEdit;
	private JTextField tfUfEdit;
	private JTextField tfEndEdit;
	private JTextField tfNomeAutor;
	private JTextField tfTelAutor;
	private JTextField tfCelAutor;
	private JTextField tfEmailAutor;
	private JTextField tfEstadoAutor;
	private JTextField tfPaisAutor;
	private JTextField tfCidadeAutor;
	private JTextField tfImgAutor;
	private JTextField tfOcup1Autor;
	private JTextField tfOcup2Autor;
	private JTextField tfTokenAutor;
	private JTextField tfOcup3Autor;
	private JTextField tfTituloLivro;
	private JTextField tfImgLivro;
	private JTextField tfEdicaoLivro;
	private JTextField tfAnoLivro;
	private JTextField tfTag1Livro;
	private JTextField tfTag2Livro;
	private JTextField tfTag3Livro;
	private JTextField tfPagLivro;
	private JTextField tfInfoLivro;
	
	
	private JScrollPane scrollAreaAutor;
	private JScrollPane scrollAreasLivro;
	private JScrollPane scrollAutoresLivro;
	private JScrollPane scrollListcat;
	private JScrollPane scrollListArea;
	private JScrollPane scrollListEditora;
	
	private JList<Area> listAreasAutor;
	private JList<Area> listAreasLivro;
	private JList<Autor> listAutoresLivro;
	
	private DefaultListModel<Area> modelAreas;
	private DefaultListModel<Autor> modelAutores;
	private DefaultComboBoxModel<Editora> modelEditoras;
	private DefaultComboBoxModel<Categoria> modelCategorias;
	private DefaultTableModel modeltablecat;
	private DefaultTableModel modeltablearea;
	private DefaultTableModel modeltableedit;
	private DefaultTableModel modeltableaautor;
	private DefaultTableModel modeltablelivro;

	
	private JTable tableCat;
	private JTable tableArea;
	private JTable tableEditora;
	private JTable tableAutor;
	private JTable tableLivro;
	
	
	private JComboBox<Categoria> cbCatLivro;
	private JComboBox<Editora> cbEditLivro;
	
	

	private JTextArea taResumoLivro;
	private JTextField tfLoginAutor;
	private JTextField tfSenhaAutor;
	private JLabel lblLoginAutor;
	private JLabel lblSenhaAutor;

	
	private BufferedImage bfAutor = null;
	private BufferedImage bfConvidado = null;
	private BufferedImage bfLivro = null;
	private File filepdf = null;
	private JScrollPane scrollResumoLivro;
	private JTextField tfFilePdf;
	private JLabel lblFilePdf;
	private JButton btnFilePdf;
	

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAdm window = new TelaAdm();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	



	public TelaAdm() {
	
		
		setBounds(100, 100, 780, 768);
		getContentPane().setBackground(new Color(240,240,240));
		setTitle("Painel Administrativo");
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		

		
		lblPainelAdministrativo = new JLabel("PAINEL ADMINISTRATIVO");
		lblPainelAdministrativo.setHorizontalAlignment(SwingConstants.CENTER);
		lblPainelAdministrativo.setForeground(new Color(32, 178, 170));
		lblPainelAdministrativo.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPainelAdministrativo.setBounds(281, 38, 244, 27);
		getContentPane().add(lblPainelAdministrativo);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(28, 76, 717, 648);
		
		getContentPane().add(tabbedPane);
		
		
		
		
		
		
		/******************************CATEGORIA ********************************/
		
		
		panelCategoria = new JPanel();
		tabbedPane.addTab("Categoria", null, panelCategoria, null);
		tabbedPane.setForegroundAt(0, new Color(32, 178, 170));
		panelCategoria.setLayout(null);
		
		lblTitleCat = new JLabel("Cadastro de Categoria");
		lblTitleCat.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitleCat.setBounds(257, 26, 205, 26);
		panelCategoria.add(lblTitleCat);
		lblTitleCat.setForeground(new Color(32, 178, 170));
		lblTitleCat.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		lblNomeCat = new JLabel("Nome");
		lblNomeCat.setForeground(new Color(32, 178, 170));
		lblNomeCat.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNomeCat.setBounds(224, 75, 46, 14);
		panelCategoria.add(lblNomeCat);
		
		tfNomeCat = new JTextField();
		tfNomeCat.setColumns(10);
		tfNomeCat.setBorder(new LineBorder(new Color(32, 178, 170), 2, true));
		tfNomeCat.setBounds(224, 102, 268, 32);
		panelCategoria.add(tfNomeCat);
		
		
		scrollListcat = new JScrollPane();
		scrollListcat.setFont(new Font("Tahoma", Font.PLAIN, 11));
		scrollListcat.setForeground(new Color(0, 0, 0));
		scrollListcat.setBorder(new LineBorder(new Color(32, 178, 170)));
		scrollListcat.setBounds(123, 270, 500, 114);
		panelCategoria.add(scrollListcat);
		
		
		tableCat = new JTable();
		tableCat.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				btnAlterarCat.setVisible(true);
			}
		});
		tableCat.getTableHeader().setForeground(new Color(32, 178, 170));
		tableCat.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 12));
		tableCat.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		tableCat.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Nome"
			}
		));
		modeltablecat = (DefaultTableModel)tableCat.getModel();
		Object [] dadosCat = new Object[2]; 
		try {
			List<Categoria> categorias = Fachada.listarCategorias();
			for (Categoria c : categorias) {
					dadosCat[0] = c.getId();
					dadosCat[1] = c.getNome();
					modeltablecat.addRow(dadosCat);
				}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
		
		scrollListcat.setViewportView(tableCat);
		
		btnCadCat = new JButton("Cadastrar Categoria");
		btnCadCat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nome = tfNomeCat.getText();
				try {
					Categoria c = Fachada.cadastrarCategoria(nome) ;
					dadosCat[0] = c.getId();
					dadosCat[1] = c.getNome();
					modeltablecat.insertRow(0, dadosCat);
					modelCategorias.addElement(c);
					JOptionPane.showMessageDialog(null, "Categoria Cadastrada com sucesso: " +c.getNome() +"!");
					
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
			}
		});
		btnCadCat.setForeground(new Color(32, 178, 170));
		btnCadCat.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCadCat.setBorder(new LineBorder(new Color(32, 178, 170), 2, true));
		btnCadCat.setBackground(Color.WHITE);
		btnCadCat.setBounds(246, 145, 216, 32);
		panelCategoria.add(btnCadCat);
		
		btnVisLivrosCat = new JButton("Visualizar Livros");
		btnVisLivrosCat.setForeground(new Color(32, 178, 170));
		btnVisLivrosCat.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnVisLivrosCat.setBorder(new LineBorder(new Color(32, 178, 170), 2, true));
		btnVisLivrosCat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int selecteRowdIdx = tableCat.getSelectedRow();
				int id = (int) modeltablecat.getValueAt(selecteRowdIdx, 0);
				String nome = modeltablecat.getValueAt(selecteRowdIdx, 1).toString();
				System.out.println(id);
				System.out.println(nome);
				
			}
		});
		btnVisLivrosCat.setBounds(123, 236, 116, 23);
		panelCategoria.add(btnVisLivrosCat);
		
		btnApagarCat = new JButton("Apagar");
		btnApagarCat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Object[] options = { "Sim", "Não" };
				int i = JOptionPane.showOptionDialog(null,"Tem certeza que deseja excluir?", "Excluir",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
				if (i == JOptionPane.YES_OPTION) {
						
						try {
							int selecteRowdIdx = tableCat.getSelectedRow();
							int id = (int) modeltablecat.getValueAt(selecteRowdIdx, 0);
							String nome = modeltablecat.getValueAt(selecteRowdIdx, 1).toString();
							Fachada.apagarCategoria(nome, id);
							modeltablecat.removeRow(selecteRowdIdx);
						} catch (Exception e) {
							JOptionPane.showMessageDialog(null, e.getMessage());
						}
						
				}	
			}
		});
		btnApagarCat.setForeground(new Color(32, 178, 170));
		btnApagarCat.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnApagarCat.setBorder(new LineBorder(new Color(32, 178, 170), 2, true));
		btnApagarCat.setBounds(534, 236, 89, 23);
		panelCategoria.add(btnApagarCat);
		
		btnAlterarCat = new JButton("Alterar");
		btnAlterarCat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnCadCat.setVisible(false);
				btnSalvarrCat.setVisible(true);
				int selecteRowdIdx = tableCat.getSelectedRow();
				int id = (int) modeltablecat.getValueAt(selecteRowdIdx, 0);
				try {
					Categoria c = Fachada.consultarCategoria(id);
					tfNomeCat.setText(c.getNome());
					
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
				
			}
		});
		btnAlterarCat.setForeground(new Color(32, 178, 170));
		btnAlterarCat.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAlterarCat.setBorder(new LineBorder(new Color(32, 178, 170), 2, true));
		btnAlterarCat.setBounds(435, 236, 89, 23);
		btnAlterarCat.setVisible(false);
		panelCategoria.add(btnAlterarCat);
		
		btnSalvarrCat = new JButton("Salvar Categoria");
		btnSalvarrCat.setForeground(new Color(32, 178, 170));
		btnSalvarrCat.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSalvarrCat.setBorder(new LineBorder(new Color(32, 178, 170), 2, true));
		btnSalvarrCat.setBackground(Color.WHITE);
		btnSalvarrCat.setBounds(246, 145, 216, 32);
		btnSalvarrCat.setVisible(false);
		btnSalvarrCat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int selecteRowdIdx = tableCat.getSelectedRow();
				String nome = tfNomeCat.getText();
				int id = (int) modeltablecat.getValueAt(selecteRowdIdx, 0);
				
				try {
					Categoria c = Fachada.alterarCategoria(id, nome);
					modeltablecat.removeRow(selecteRowdIdx);
					dadosCat[0] = c.getId();
					dadosCat[1] = c.getNome();
					modeltablecat.insertRow(selecteRowdIdx, dadosCat);
					JOptionPane.showMessageDialog(null, "Categoria Alterada com sucesso: " +c.getNome() +"!");
					btnSalvarrCat.setVisible(false);
					btnCadCat.setVisible(true);
					tfNomeCat.setText("");
					
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
				
				
				
				
			}
		});
		panelCategoria.add(btnSalvarrCat);
		
		
		
		/******************************AREA ********************************/
		
		panelArea = new JPanel();
		tabbedPane.addTab("Área", null, panelArea, null);
		panelArea.setLayout(null);
		
		lblTileCadastroDeArea = new JLabel("Cadastro de \u00C1rea");
		lblTileCadastroDeArea.setHorizontalAlignment(SwingConstants.CENTER);
		lblTileCadastroDeArea.setForeground(new Color(32, 178, 170));
		lblTileCadastroDeArea.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTileCadastroDeArea.setBounds(277, 37, 161, 22);
		panelArea.add(lblTileCadastroDeArea);
		
		lblNomeArea = new JLabel("Nome");
		lblNomeArea.setForeground(new Color(32, 178, 170));
		lblNomeArea.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNomeArea.setBounds(234, 91, 46, 14);
		panelArea.add(lblNomeArea);
		
		tfNomeArea = new JTextField();
		tfNomeArea.setColumns(10);
		tfNomeArea.setBorder(new LineBorder(new Color(32, 178, 170), 2, true));
		tfNomeArea.setBounds(234, 118, 268, 32);
		panelArea.add(tfNomeArea);
		
		tfNivelArea = new JTextField();
		tfNivelArea.setColumns(10);
		tfNivelArea.setBorder(new LineBorder(new Color(32, 178, 170), 2, true));
		tfNivelArea.setBounds(234, 188, 268, 32);
		panelArea.add(tfNivelArea);
		
		lblNivelArea = new JLabel("N\u00EDvel");
		lblNivelArea.setForeground(new Color(32, 178, 170));
		lblNivelArea.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNivelArea.setBounds(234, 161, 46, 14);
		panelArea.add(lblNivelArea);
		
		btnCadArea = new JButton("Cadastrar \u00C1rea");
		btnCadArea.setForeground(new Color(32, 178, 170));
		btnCadArea.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCadArea.setBorder(new LineBorder(new Color(32, 178, 170), 2, true));
		btnCadArea.setBackground(Color.WHITE);
		btnCadArea.setBounds(264, 244, 216, 32);
		
		
		scrollListArea = new JScrollPane();
		scrollListArea.setFont(new Font("Tahoma", Font.PLAIN, 11));
		scrollListArea.setForeground(new Color(0, 0, 0));
		scrollListArea.setBorder(new LineBorder(new Color(32, 178, 170)));
		scrollListArea.setBounds(131, 368, 500, 114);
		panelArea.add(scrollListArea);
		
		
		tableArea = new JTable();
		tableArea.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				btnAlterarArea.setVisible(true);
			}
		});
		tableArea.getTableHeader().setForeground(new Color(32, 178, 170));
		tableArea.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 12));
		tableArea.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		tableArea.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Nome", "Nível"
			}
		));
		Object [] dadosArea = new Object[3];
		modeltablearea = (DefaultTableModel)tableArea.getModel();
		try {
			List<Area> areas = Fachada.listarAreas();
			for (Area a : areas) {
				dadosArea[0] = a.getId();
				dadosArea[1] = a.getNome();
				dadosArea[2] = a.getNivel();
				modeltablearea.addRow(dadosArea);
				
				}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
		scrollListArea.setViewportView(tableArea);
		
		
		btnCadArea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nome = tfNomeArea.getText();
				int nivel = Integer.parseInt(tfNivelArea.getText());
				try {
					Area a = Fachada.cadastrarArea(nome, nivel) ;
					dadosArea[0] = a.getId();
					dadosArea[1] = a.getNome();
					dadosArea[2] = a.getNivel();
					modeltablearea.insertRow(0, dadosArea);
					modelAreas.addElement(a);
					JOptionPane.showMessageDialog(null, "Área Cadastrada com sucesso: " + a.getNome() +"!");
					
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
			}
		});
		panelArea.add(btnCadArea);
		tabbedPane.setForegroundAt(1, new Color(32, 178, 170));
		

		btnVisLivrosArea = new JButton("Visualizar Livros");
		btnVisLivrosArea.setForeground(new Color(32, 178, 170));
		btnVisLivrosArea.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnVisLivrosArea.setBorder(new LineBorder(new Color(32, 178, 170), 2, true));
		btnVisLivrosArea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int selecteRowdIdx = tableArea.getSelectedRow();
				int id = (int) modeltablearea.getValueAt(selecteRowdIdx, 0);
				String nome = modeltablearea.getValueAt(selecteRowdIdx, 1).toString();
				System.out.println(id);
				System.out.println(nome);
				
			}
		});
		btnVisLivrosArea.setBounds(131, 334, 116, 23);
		panelArea.add(btnVisLivrosArea);
		
		btnApagarArea = new JButton("Apagar");
		btnApagarArea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Object[] options = { "Sim", "Não" };
				int i = JOptionPane.showOptionDialog(null,"Tem certeza que deseja excluir?", "Excluir",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
				if (i == JOptionPane.YES_OPTION) {
						
						try {
							int selecteRowdIdx = tableArea.getSelectedRow();
							int id = (int) modeltablearea.getValueAt(selecteRowdIdx, 0);
							String nome = modeltablearea.getValueAt(selecteRowdIdx, 1).toString();
							Fachada.apagarArea(nome, id);
							modeltablearea.removeRow(selecteRowdIdx);
						} catch (Exception e) {
							JOptionPane.showMessageDialog(null, e.getMessage());	
						}
						
				}	
			}
		});
		btnApagarArea.setForeground(new Color(32, 178, 170));
		btnApagarArea.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnApagarArea.setBorder(new LineBorder(new Color(32, 178, 170), 2, true));
		btnApagarArea.setBounds(542, 334, 89, 23);
		panelArea.add(btnApagarArea);
		
		btnAlterarArea = new JButton("Alterar");
		btnAlterarArea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnCadArea.setVisible(false);
				btnSalvarArea.setVisible(true);
				int selecteRowdIdx = tableArea.getSelectedRow();
				int id = (int) modeltablearea.getValueAt(selecteRowdIdx, 0);
				try {
					Area a = Fachada.consultarArea(id);
					tfNomeArea.setText(a.getNome());
					tfNivelArea.setText(Integer.toString(a.getNivel()));
					
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
				
			}
		});
		btnAlterarArea.setForeground(new Color(32, 178, 170));
		btnAlterarArea.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAlterarArea.setBorder(new LineBorder(new Color(32, 178, 170), 2, true));
		btnAlterarArea.setBounds(443, 334, 89, 23);
		btnAlterarArea.setVisible(false);
		panelArea.add(btnAlterarArea);
		
		btnSalvarArea = new JButton("Salvar \u00C1rea");
		btnSalvarArea.setForeground(new Color(32, 178, 170));
		btnSalvarArea.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSalvarArea.setBorder(new LineBorder(new Color(32, 178, 170), 2, true));
		btnSalvarArea.setBackground(Color.WHITE);
		btnSalvarArea.setBounds(264, 244, 216, 32);
		btnSalvarArea.setVisible(false);
		btnSalvarArea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int selecteRowdIdx = tableArea.getSelectedRow();
				String nome = tfNomeArea.getText();
				int nivel = Integer.parseInt(tfNivelArea.getText());
				int id = (int) modeltablearea.getValueAt(selecteRowdIdx, 0);
				
				try {
					Area a  = Fachada.alterarArea(id, nome, nivel);
					modeltablearea.removeRow(selecteRowdIdx);
					dadosArea[0] = a.getId();
					dadosArea[1] = a.getNome();
					dadosArea[2] = a.getNivel();
					modeltablearea.insertRow(selecteRowdIdx, dadosArea);
					JOptionPane.showMessageDialog(null, "Dados da Area alterados com sucesso!: " + a.getNome() +"!");
					btnSalvarArea.setVisible(false);
					btnCadArea.setVisible(true);
					tfNomeArea.setText("");
					tfNivelArea.setText("");
					
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}	

			}
		});
		panelArea.add(btnSalvarArea);
		
		/******************************EDITORA ********************************/
		
		panelEditora = new JPanel();
		tabbedPane.addTab("Editora", null, panelEditora, null);
		panelEditora.setLayout(null);
		
		lblCadEdit = new JLabel("Cadastro de Editora");
		lblCadEdit.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadEdit.setForeground(new Color(32, 178, 170));
		lblCadEdit.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCadEdit.setBounds(273, 28, 161, 22);
		panelEditora.add(lblCadEdit);
		
		lblNomeEdit = new JLabel("Nome");
		lblNomeEdit.setForeground(new Color(32, 178, 170));
		lblNomeEdit.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNomeEdit.setBounds(73, 80, 168, 14);
		panelEditora.add(lblNomeEdit);
		
		tfNomeEdit = new JTextField();
		tfNomeEdit.setColumns(10);
		tfNomeEdit.setBorder(new LineBorder(new Color(32, 178, 170), 2, true));
		tfNomeEdit.setBounds(73, 107, 268, 32);
		panelEditora.add(tfNomeEdit);
		
		lblTelEdit = new JLabel("Telefone");
		lblTelEdit.setForeground(new Color(32, 178, 170));
		lblTelEdit.setFont(new Font("Dialog", Font.BOLD, 13));
		lblTelEdit.setBounds(73, 150, 110, 14);
		panelEditora.add(lblTelEdit);
		
		tfTelEdit = new JTextField();
		tfTelEdit.setColumns(10);
		tfTelEdit.setBorder(new LineBorder(new Color(32, 178, 170), 2, true));
		tfTelEdit.setBounds(73, 175, 120, 32);
		panelEditora.add(tfTelEdit);
		
		lblTel2edit = new JLabel("Telefone 2");
		lblTel2edit.setForeground(new Color(32, 178, 170));
		lblTel2edit.setFont(new Font("Dialog", Font.BOLD, 13));
		lblTel2edit.setBounds(221, 150, 110, 14);
		panelEditora.add(lblTel2edit);
		
		tfTel2Edit = new JTextField();
		tfTel2Edit.setColumns(10);
		tfTel2Edit.setBorder(new LineBorder(new Color(32, 178, 170), 2, true));
		tfTel2Edit.setBounds(221, 175, 120, 32);
		panelEditora.add(tfTel2Edit);
		
		lblEmailEdit = new JLabel("Email");
		lblEmailEdit.setForeground(new Color(32, 178, 170));
		lblEmailEdit.setFont(new Font("Dialog", Font.BOLD, 13));
		lblEmailEdit.setBounds(365, 80, 110, 14);
		panelEditora.add(lblEmailEdit);
		
		tfEmailEdit = new JTextField();
		tfEmailEdit.setColumns(10);
		tfEmailEdit.setBorder(new LineBorder(new Color(32, 178, 170), 2, true));
		tfEmailEdit.setBounds(365, 107, 268, 32);
		panelEditora.add(tfEmailEdit);
		
		lblSiteEdi = new JLabel("Site");
		lblSiteEdi.setForeground(new Color(32, 178, 170));
		lblSiteEdi.setFont(new Font("Dialog", Font.BOLD, 13));
		lblSiteEdi.setBounds(365, 146, 110, 14);
		panelEditora.add(lblSiteEdi);
		
		tfSiteEdit = new JTextField();
		tfSiteEdit.setColumns(10);
		tfSiteEdit.setBorder(new LineBorder(new Color(32, 178, 170), 2, true));
		tfSiteEdit.setBounds(365, 175, 268, 32);
		panelEditora.add(tfSiteEdit);
		
		lblCidadeEdit = new JLabel("Cidade");
		lblCidadeEdit.setForeground(new Color(32, 178, 170));
		lblCidadeEdit.setFont(new Font("Dialog", Font.BOLD, 13));
		lblCidadeEdit.setBounds(365, 222, 110, 14);
		panelEditora.add(lblCidadeEdit);
		
		tfCidadeEdit = new JTextField();
		tfCidadeEdit.setColumns(10);
		tfCidadeEdit.setBorder(new LineBorder(new Color(32, 178, 170), 2, true));
		tfCidadeEdit.setBounds(365, 247, 191, 32);
		panelEditora.add(tfCidadeEdit);
		
		lblUfEdit = new JLabel("UF");
		lblUfEdit.setForeground(new Color(32, 178, 170));
		lblUfEdit.setFont(new Font("Dialog", Font.BOLD, 13));
		lblUfEdit.setBounds(575, 222, 48, 14);
		panelEditora.add(lblUfEdit);
		
		tfUfEdit = new JTextField();
		tfUfEdit.setColumns(10);
		tfUfEdit.setBorder(new LineBorder(new Color(32, 178, 170), 2, true));
		tfUfEdit.setBounds(575, 247, 58, 32);
		panelEditora.add(tfUfEdit);
		
		lblEndEdit = new JLabel("Endere\u00E7o");
		lblEndEdit.setForeground(new Color(32, 178, 170));
		lblEndEdit.setFont(new Font("Dialog", Font.BOLD, 13));
		lblEndEdit.setBounds(73, 218, 110, 14);
		panelEditora.add(lblEndEdit);
		
		tfEndEdit = new JTextField();
		tfEndEdit.setColumns(10);
		tfEndEdit.setBorder(new LineBorder(new Color(32, 178, 170), 2, true));
		tfEndEdit.setBounds(73, 247, 268, 32);
		panelEditora.add(tfEndEdit);
		
		btnCadEdit = new JButton("Cadastrar Editora");
		btnCadEdit.setForeground(new Color(32, 178, 170));
		btnCadEdit.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCadEdit.setBorder(new LineBorder(new Color(32, 178, 170), 2, true));
		btnCadEdit.setBackground(Color.WHITE);
		btnCadEdit.setBounds(273, 305, 226, 32);
		panelEditora.add(btnCadEdit);
		tabbedPane.setForegroundAt(2, new Color(32, 178, 170));
		
		
		scrollListEditora = new JScrollPane();
		scrollListEditora.setFont(new Font("Tahoma", Font.PLAIN, 11));
		scrollListEditora.setForeground(new Color(0, 0, 0));
		scrollListEditora.setBorder(new LineBorder(new Color(32, 178, 170)));
		scrollListEditora.setBounds(26, 411, 659, 114);
		panelEditora.add(scrollListEditora);
		
		tableEditora = new JTable();

		tableEditora.getTableHeader().setForeground(new Color(32, 178, 170));
		tableEditora.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 12));
		tableEditora.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		tableEditora.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Nome", "Email", "cidade", "Estado"
			}
		));
		Object [] dadosEditora = new Object[5];
		modeltableedit = (DefaultTableModel)tableEditora.getModel();
		try {
			List<Editora> editoras = Fachada.listarEditoras();
			for (Editora e : editoras) {
				dadosEditora[0] = e.getId();
				dadosEditora[1] = e.getNome();
				dadosEditora[2] = e.getEmail();
				dadosEditora[3] = e.getCidade();
				dadosEditora[4] = e.getEstado();
				modeltableedit.addRow(dadosEditora);
				}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
		scrollListEditora.setViewportView(tableEditora);
		
		
		btnCadEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nome = tfNomeEdit.getText();
				String site = tfSiteEdit.getText();
				String email = tfEmailEdit.getText();
				String endereco = tfEndEdit.getText();
				String cidade = tfCidadeEdit.getText();
				String estado = tfUfEdit.getText();
				String tel = tfTelEdit.getText();
				String tel2 = tfTel2Edit.getText();
				
				try {
					Editora e = Fachada.cadastrarEditora(nome, site, email, endereco, cidade, estado, tel, tel2) ;
					dadosEditora[0] = e.getId();
					dadosEditora[1] = e.getNome();
					dadosEditora[2] = e.getEmail();
					dadosEditora[3] = e.getCidade();
					dadosEditora[4] = e.getEstado();
					modeltableedit.insertRow(0, dadosEditora);
					modelEditoras.addElement(e);
					JOptionPane.showMessageDialog(null, "Editora Cadastrada com sucesso: " + e.getNome() +"!");
					
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
			}
		});
		
		

		
		
		btnApagarEditora = new JButton("Apagar");
		btnApagarEditora.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Object[] options = { "Sim", "Não" };
				int i = JOptionPane.showOptionDialog(null,"Tem certeza que deseja excluir?", "Excluir",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
				if (i == JOptionPane.YES_OPTION) {
						
						try {
							int selecteRowdIdx = tableEditora.getSelectedRow();
							int id = (int) modeltableedit.getValueAt(selecteRowdIdx, 0);
							String nome = modeltableedit.getValueAt(selecteRowdIdx, 1).toString();
							Fachada.apagarEditora(id, nome);
							modeltableedit.removeRow(selecteRowdIdx);
						} catch (Exception e) {
							JOptionPane.showMessageDialog(null, e.getMessage());	
						}
						
				}	
			}
		});
		btnApagarEditora.setForeground(new Color(32, 178, 170));
		btnApagarEditora.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnApagarEditora.setBorder(new LineBorder(new Color(32, 178, 170), 2, true));
		btnApagarEditora.setBounds(596, 377, 89, 23);
		panelEditora.add(btnApagarEditora);
		
		
		
		
	
		/******************************AUTOR ********************************/

		panelAutor = new JPanel();
		tabbedPane.addTab("Autor", null, panelAutor, null);
		tabbedPane.setForegroundAt(3, new Color(32, 178, 170));
		panelAutor.setLayout(null);
		
		lblCadastroDeAutor = new JLabel("Cadastro de Autor");
		lblCadastroDeAutor.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastroDeAutor.setForeground(new Color(32, 178, 170));
		lblCadastroDeAutor.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCadastroDeAutor.setBounds(238, 11, 161, 22);
		panelAutor.add(lblCadastroDeAutor);
		
		lblNomeAutor = new JLabel("Nome Completo");
		lblNomeAutor.setForeground(new Color(32, 178, 170));
		lblNomeAutor.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNomeAutor.setBounds(37, 62, 168, 14);
		panelAutor.add(lblNomeAutor);
		
		tfNomeAutor = new JTextField();
		tfNomeAutor.setColumns(10);
		tfNomeAutor.setBorder(new LineBorder(new Color(32, 178, 170), 2, true));
		tfNomeAutor.setBounds(37, 89, 268, 32);
		panelAutor.add(tfNomeAutor);
		
		lblTelAutor = new JLabel("Telefone");
		lblTelAutor.setForeground(new Color(32, 178, 170));
		lblTelAutor.setFont(new Font("Dialog", Font.BOLD, 13));
		lblTelAutor.setBounds(37, 204, 110, 14);
		panelAutor.add(lblTelAutor);
		
		tfTelAutor = new JTextField();
		tfTelAutor.setColumns(10);
		tfTelAutor.setBorder(new LineBorder(new Color(32, 178, 170), 2, true));
		tfTelAutor.setBounds(37, 229, 120, 32);
		panelAutor.add(tfTelAutor);
		
		lblCelAutor = new JLabel("Celular");
		lblCelAutor.setForeground(new Color(32, 178, 170));
		lblCelAutor.setFont(new Font("Dialog", Font.BOLD, 13));
		lblCelAutor.setBounds(185, 204, 110, 14);
		panelAutor.add(lblCelAutor);
		
		tfCelAutor = new JTextField();
		tfCelAutor.setColumns(10);
		tfCelAutor.setBorder(new LineBorder(new Color(32, 178, 170), 2, true));
		tfCelAutor.setBounds(185, 229, 120, 32);
		panelAutor.add(tfCelAutor);
		
		lblEmailAutor = new JLabel("Email");
		lblEmailAutor.setForeground(new Color(32, 178, 170));
		lblEmailAutor.setFont(new Font("Dialog", Font.BOLD, 13));
		lblEmailAutor.setBounds(329, 62, 110, 14);
		panelAutor.add(lblEmailAutor);
		
		tfEmailAutor = new JTextField();
		tfEmailAutor.setColumns(10);
		tfEmailAutor.setBorder(new LineBorder(new Color(32, 178, 170), 2, true));
		tfEmailAutor.setBounds(329, 89, 268, 32);
		panelAutor.add(tfEmailAutor);
		
		lblImgAutor = new JLabel("Imagem");
		lblImgAutor.setForeground(new Color(32, 178, 170));
		lblImgAutor.setFont(new Font("Dialog", Font.BOLD, 13));
		lblImgAutor.setBounds(329, 204, 110, 14);
		panelAutor.add(lblImgAutor);
		
		tfImgAutor = new JTextField();
		tfImgAutor.setColumns(10);
		tfImgAutor.setBorder(new LineBorder(new Color(32, 178, 170), 2, true));
		tfImgAutor.setBounds(328, 229, 161, 32);
		panelAutor.add(tfImgAutor);
		
		btnImgAutor = new JButton("Selecionar");
		btnImgAutor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser fc = new JFileChooser(new File("C:"));
				FileFilter ft = new FileFilter() {
					@Override
					public boolean accept(File f) {
						String file = f.getName();
						return file.endsWith(".jpg") | f.isDirectory();          
					}
					@Override
					public String getDescription() {
						return "jpg";
					}
				};
				fc.setFileFilter(ft);
				fc.showOpenDialog(null);
				File f = fc.getSelectedFile();
				tfImgAutor.setText(f.getName());
		
				
				try {
					bfAutor = ImageIO.read(f);
				} catch (IOException e2) {

					e2.printStackTrace();
				}	

				ImageIcon icon = new  ImageIcon(bfAutor.getScaledInstance(95, 100,Image.SCALE_DEFAULT));
				lblFotoAutor.setIcon(icon); 
			}
		});
		btnImgAutor.setForeground(new Color(32, 178, 170));
		btnImgAutor.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnImgAutor.setBorder(new LineBorder(new Color(32, 178, 170), 2, true));
		btnImgAutor.setBackground(Color.WHITE);
		btnImgAutor.setBounds(499, 229, 97, 32);
		panelAutor.add(btnImgAutor);
		
		lblFotoAutor = new JLabel("");
		lblFotoAutor.setBounds(607, 89, 95, 100);
		panelAutor.add(lblFotoAutor);
		
		lblEstadoAutor = new JLabel("Estado");
		lblEstadoAutor.setForeground(new Color(32, 178, 170));
		lblEstadoAutor.setFont(new Font("Dialog", Font.BOLD, 13));
		lblEstadoAutor.setBounds(329, 276, 110, 14);
		panelAutor.add(lblEstadoAutor);
		
		tfEstadoAutor = new JTextField();
		tfEstadoAutor.setColumns(10);
		tfEstadoAutor.setBorder(new LineBorder(new Color(32, 178, 170), 2, true));
		tfEstadoAutor.setBounds(329, 301, 96, 32);
		panelAutor.add(tfEstadoAutor);
		
		lblPaisAutor = new JLabel("Pa\u00EDs");
		lblPaisAutor.setForeground(new Color(32, 178, 170));
		lblPaisAutor.setFont(new Font("Dialog", Font.BOLD, 13));
		lblPaisAutor.setBounds(449, 276, 138, 14);
		panelAutor.add(lblPaisAutor);
		
		tfPaisAutor = new JTextField();
		tfPaisAutor.setColumns(10);
		tfPaisAutor.setBorder(new LineBorder(new Color(32, 178, 170), 2, true));
		tfPaisAutor.setBounds(447, 301, 150, 32);
		panelAutor.add(tfPaisAutor);
		
		lblCidadeAutor = new JLabel("Cidade");
		lblCidadeAutor.setForeground(new Color(32, 178, 170));
		lblCidadeAutor.setFont(new Font("Dialog", Font.BOLD, 13));
		lblCidadeAutor.setBounds(37, 276, 110, 14);
		panelAutor.add(lblCidadeAutor);
		
		tfCidadeAutor = new JTextField();
		tfCidadeAutor.setColumns(10);
		tfCidadeAutor.setBorder(new LineBorder(new Color(32, 178, 170), 2, true));
		tfCidadeAutor.setBounds(37, 301, 268, 32);
		panelAutor.add(tfCidadeAutor);
		
		scrollAreaAutor = new JScrollPane();
		scrollAreaAutor.setBorder(new LineBorder(new Color(32, 178, 170)));
		scrollAreaAutor.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollAreaAutor.setBounds(329, 374, 268, 104);
		panelAutor.add(scrollAreaAutor);
		
		
		
		
		modelAreas = new DefaultListModel<Area>();
		
		List<Area> areas;
		try {
			areas = Fachada.listarAreas();
			for(Area a : areas) {
				//System.out.println(c);
				modelAreas.addElement(a);
			}
		} catch (Exception e) {
			e.getMessage();
		}
		
		
		
		listAreasAutor= new JList<Area>(modelAreas);
		listAreasAutor.setForeground(new Color(32, 178, 170));
		listAreasAutor.setFont(new Font("Tahoma", Font.PLAIN, 12));
		scrollAreaAutor.setViewportView(listAreasAutor);
		

		btnCadAutor = new JButton("Cadastrar Autor");
		btnCadAutor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String nome = tfNomeAutor.getText();
				String login = tfLoginAutor.getText();
				String senha = tfSenhaAutor.getText();
				String email = tfEmailAutor.getText();
				String token = tfTokenAutor.getText();
				String cidade = tfCidadeAutor.getText();
				String estado = tfEstadoAutor.getText();
				String pais = tfPaisAutor.getText();
				String tel  = tfTelAutor.getText();
				String cel = tfCelAutor.getText();
				String ocup1 = tfOcup1Autor.getText();
				String ocup2 = tfOcup2Autor.getText();
				String ocup3 = tfOcup3Autor.getText();
				
				
				
				
				int[] indices = listAreasAutor.getSelectedIndices();
				ArrayList<Area> listAreas = new ArrayList<Area>();
			    // Get all the selected items using the indices
			    for (int i = 0; i < indices.length; i++) {
			      Area areaSel = listAreasAutor.getModel().getElementAt(indices[i]);
			      listAreas.add(areaSel);
			    }
			    
			    ArrayList<String> telefones = new ArrayList<String>();
			    telefones.add(tel);
			    telefones.add(cel);
			    
			    ArrayList<String> ocupacoes = new ArrayList<String>();
			    ocupacoes.add(ocup1);
			    ocupacoes.add(ocup2);
			    ocupacoes.add(ocup3);
			   

				
			    try {
					Autor a  = Fachada.cadastrarAutor(nome, login, senha, email, token, bfAutor, cidade, estado,
							pais, listAreas, telefones, ocupacoes) ;
					modelAutores.addElement(a);
			
					JOptionPane.showMessageDialog(null, "Autor Cadastrado com sucesso: " + a.getNome() +"!");
					
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
				
			}
		});
		btnCadAutor.setForeground(new Color(32, 178, 170));
		btnCadAutor.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCadAutor.setBorder(new LineBorder(new Color(32, 178, 170), 2, true));
		btnCadAutor.setBackground(Color.WHITE);
		btnCadAutor.setBounds(237, 503, 226, 32);
		panelAutor.add(btnCadAutor);
		
		lblOcupAutor = new JLabel("Ocupa\u00E7\u00F5es");
		lblOcupAutor.setForeground(new Color(32, 178, 170));
		lblOcupAutor.setFont(new Font("Dialog", Font.BOLD, 13));
		lblOcupAutor.setBounds(37, 349, 110, 14);
		panelAutor.add(lblOcupAutor);
		
		tfOcup1Autor = new JTextField();
		tfOcup1Autor.setColumns(10);
		tfOcup1Autor.setBorder(new LineBorder(new Color(32, 178, 170), 2, true));
		tfOcup1Autor.setBounds(37, 374, 84, 32);
		panelAutor.add(tfOcup1Autor);
		
		tfOcup2Autor = new JTextField();
		tfOcup2Autor.setColumns(10);
		tfOcup2Autor.setBorder(new LineBorder(new Color(32, 178, 170), 2, true));
		tfOcup2Autor.setBounds(131, 374, 84, 32);
		panelAutor.add(tfOcup2Autor);
		
		tfOcup3Autor = new JTextField();
		tfOcup3Autor.setColumns(10);
		tfOcup3Autor.setBorder(new LineBorder(new Color(32, 178, 170), 2, true));
		tfOcup3Autor.setBounds(221, 374, 84, 32);
		panelAutor.add(tfOcup3Autor);
		
		lblTokenAutor = new JLabel("Token");
		lblTokenAutor.setForeground(new Color(32, 178, 170));
		lblTokenAutor.setFont(new Font("Dialog", Font.BOLD, 13));
		lblTokenAutor.setBounds(37, 421, 110, 14);
		panelAutor.add(lblTokenAutor);
		
		tfTokenAutor = new JTextField();
		tfTokenAutor.setColumns(10);
		tfTokenAutor.setBorder(new LineBorder(new Color(32, 178, 170), 2, true));
		tfTokenAutor.setBounds(37, 446, 268, 32);
		panelAutor.add(tfTokenAutor);
		
		lblAreasAutor = new JLabel("\u00C1reas de Atua\u00E7\u00E3o");
		lblAreasAutor.setForeground(new Color(32, 178, 170));
		lblAreasAutor.setFont(new Font("Dialog", Font.BOLD, 13));
		lblAreasAutor.setBounds(329, 349, 160, 14);
		panelAutor.add(lblAreasAutor);
		
		lblLoginAutor = new JLabel("Login");
		lblLoginAutor.setForeground(new Color(32, 178, 170));
		lblLoginAutor.setFont(new Font("Dialog", Font.BOLD, 13));
		lblLoginAutor.setBounds(37, 134, 168, 14);
		panelAutor.add(lblLoginAutor);
		
		tfLoginAutor = new JTextField();
		tfLoginAutor.setColumns(10);
		tfLoginAutor.setBorder(new LineBorder(new Color(32, 178, 170), 2, true));
		tfLoginAutor.setBounds(37, 161, 268, 32);
		panelAutor.add(tfLoginAutor);
		
		lblSenhaAutor = new JLabel("Senha");
		lblSenhaAutor.setForeground(new Color(32, 178, 170));
		lblSenhaAutor.setFont(new Font("Dialog", Font.BOLD, 13));
		lblSenhaAutor.setBounds(329, 134, 110, 14);
		panelAutor.add(lblSenhaAutor);
		
		tfSenhaAutor = new JTextField();
		tfSenhaAutor.setColumns(10);
		tfSenhaAutor.setBorder(new LineBorder(new Color(32, 178, 170), 2, true));
		tfSenhaAutor.setBounds(329, 161, 268, 32);
		panelAutor.add(tfSenhaAutor);
		
		
		
		/******************************LIVRO ********************************/
		
		panelLivro = new JPanel();
		tabbedPane.addTab("Livro", null, panelLivro, null);
		panelLivro.setLayout(null);
		
		lblTitleCadLivro = new JLabel("Cadastro de Livro");
		lblTitleCadLivro.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitleCadLivro.setForeground(new Color(32, 178, 170));
		lblTitleCadLivro.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTitleCadLivro.setBounds(226, 22, 161, 22);
		panelLivro.add(lblTitleCadLivro);
		
		lblTitLivro = new JLabel("T\u00EDtulo");
		lblTitLivro.setForeground(new Color(32, 178, 170));
		lblTitLivro.setFont(new Font("Dialog", Font.BOLD, 13));
		lblTitLivro.setBounds(26, 73, 168, 14);
		panelLivro.add(lblTitLivro);
		
		tfTituloLivro = new JTextField();
		tfTituloLivro.setColumns(10);
		tfTituloLivro.setBorder(new LineBorder(new Color(32, 178, 170), 2, true));
		tfTituloLivro.setBounds(26, 100, 268, 32);
		panelLivro.add(tfTituloLivro);
		
		lblCategoria = new JLabel("Categoria");
		lblCategoria.setForeground(new Color(32, 178, 170));
		lblCategoria.setFont(new Font("Dialog", Font.BOLD, 13));
		lblCategoria.setBounds(26, 143, 110, 14);
		panelLivro.add(lblCategoria);
		
		lblEditora = new JLabel("Editora");
		lblEditora.setForeground(new Color(32, 178, 170));
		lblEditora.setFont(new Font("Dialog", Font.BOLD, 13));
		lblEditora.setBounds(174, 143, 110, 14);
		panelLivro.add(lblEditora);
		
		lblResumoLivro = new JLabel("Resumo do Livro");
		lblResumoLivro.setForeground(new Color(32, 178, 170));
		lblResumoLivro.setFont(new Font("Dialog", Font.BOLD, 13));
		lblResumoLivro.setBounds(26, 428, 150, 14);
		panelLivro.add(lblResumoLivro);
		
		lblImgLivro = new JLabel("Imagem");
		lblImgLivro.setForeground(new Color(32, 178, 170));
		lblImgLivro.setFont(new Font("Dialog", Font.BOLD, 13));
		lblImgLivro.setBounds(318, 73, 110, 14);
		panelLivro.add(lblImgLivro);
		
		tfImgLivro = new JTextField();
		tfImgLivro.setColumns(10);
		tfImgLivro.setBorder(new LineBorder(new Color(32, 178, 170), 2, true));
		tfImgLivro.setBounds(317, 98, 161, 32);
		panelLivro.add(tfImgLivro);
		
		btnImgLivro = new JButton("Selecionar");
		btnImgLivro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser fc = new JFileChooser(new File("C:/"));
				FileFilter ft = new FileFilter() {
					@Override
					public boolean accept(File f) {
						String file = f.getName();
						return file.endsWith(".jpg") | f.isDirectory();          
					}
					@Override
					public String getDescription() {
						return "jpg";
					}
				};
				fc.setFileFilter(ft);
				fc.showOpenDialog(null);
				File f = fc.getSelectedFile();
				tfImgLivro.setText(f.getName());
		
				
				try {
					bfLivro = ImageIO.read(f);
				} catch (IOException e2) {

					e2.printStackTrace();
				}	

				ImageIcon icon = new  ImageIcon(bfLivro.getScaledInstance(107, 150,Image.SCALE_DEFAULT));
				lblCapaLivro.setIcon(icon); 
			}
		});
		btnImgLivro.setForeground(new Color(32, 178, 170));
		btnImgLivro.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnImgLivro.setBorder(new LineBorder(new Color(32, 178, 170), 2, true));
		btnImgLivro.setBackground(Color.WHITE);
		btnImgLivro.setBounds(488, 98, 97, 32);
		panelLivro.add(btnImgLivro);
		
		lblCapaLivro = new JLabel("");
		lblCapaLivro.setBounds(595, 100, 107, 150);
		panelLivro.add(lblCapaLivro);
		
		tfFilePdf = new JTextField();
		tfFilePdf.setColumns(10);
		tfFilePdf.setBorder(new LineBorder(new Color(32, 178, 170), 2, true));
		tfFilePdf.setBounds(317, 166, 161, 32);
		panelLivro.add(tfFilePdf);
		
		lblFilePdf = new JLabel("Arquivo PDF");
		lblFilePdf.setForeground(new Color(32, 178, 170));
		lblFilePdf.setFont(new Font("Dialog", Font.BOLD, 13));
		lblFilePdf.setBounds(318, 141, 110, 14);
		panelLivro.add(lblFilePdf);
		
		btnFilePdf = new JButton("Selecionar");
		btnFilePdf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser fcpdf = new JFileChooser(new File("C:/"));
				FileFilter ftpdf = new FileFilter() {
					@Override
					public boolean accept(File f) {
						String file = f.getName();
						return file.endsWith(".pdf") | f.isDirectory();          
					}
					@Override
					public String getDescription() {
						return "pdf";
					}
				};
				fcpdf.setFileFilter(ftpdf);
				fcpdf.showOpenDialog(null);
				filepdf = fcpdf.getSelectedFile();
				tfFilePdf.setText(filepdf.getName());
					
			}
		});
		btnFilePdf.setForeground(new Color(32, 178, 170));
		btnFilePdf.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnFilePdf.setBorder(new LineBorder(new Color(32, 178, 170), 2, true));
		btnFilePdf.setBackground(Color.WHITE);
		btnFilePdf.setBounds(488, 166, 97, 32);
		panelLivro.add(btnFilePdf);
		
		lblEdicaoLivro = new JLabel("Edi\u00E7\u00E3o");
		lblEdicaoLivro.setForeground(new Color(32, 178, 170));
		lblEdicaoLivro.setFont(new Font("Dialog", Font.BOLD, 13));
		lblEdicaoLivro.setBounds(120, 215, 84, 14);
		panelLivro.add(lblEdicaoLivro);
		
		tfEdicaoLivro = new JTextField();
		tfEdicaoLivro.setColumns(10);
		tfEdicaoLivro.setBorder(new LineBorder(new Color(32, 178, 170), 2, true));
		tfEdicaoLivro.setBounds(120, 240, 84, 32);
		panelLivro.add(tfEdicaoLivro);
		
		lblAnoLivro = new JLabel("Ano");
		lblAnoLivro.setForeground(new Color(32, 178, 170));
		lblAnoLivro.setFont(new Font("Dialog", Font.BOLD, 13));
		lblAnoLivro.setBounds(214, 215, 80, 14);
		panelLivro.add(lblAnoLivro);
		
		tfAnoLivro = new JTextField();
		tfAnoLivro.setColumns(10);
		tfAnoLivro.setBorder(new LineBorder(new Color(32, 178, 170), 2, true));
		tfAnoLivro.setBounds(214, 240, 80, 32);
		panelLivro.add(tfAnoLivro);
		
		lblPagLivro = new JLabel("P\u00E1ginas");
		lblPagLivro.setForeground(new Color(32, 178, 170));
		lblPagLivro.setFont(new Font("Dialog", Font.BOLD, 13));
		lblPagLivro.setBounds(26, 215, 84, 14);
		panelLivro.add(lblPagLivro);
		
		tfPagLivro = new JTextField();
		tfPagLivro.setColumns(10);
		tfPagLivro.setBorder(new LineBorder(new Color(32, 178, 170), 2, true));
		tfPagLivro.setBounds(26, 240, 84, 32);
		panelLivro.add(tfPagLivro);
		
		btnCadLivro = new JButton("Cadastrar Livro");
		btnCadLivro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String titulo = tfTituloLivro.getText();
				String resumo = taResumoLivro.getText();
				int paginas = Integer.parseInt(tfPagLivro.getText());
				int edicao = Integer.parseInt(tfEdicaoLivro.getText());
				int ano = Integer.parseInt(tfAnoLivro.getText());
				String informacoes = tfInfoLivro.getText();
				String tag1 = tfTag1Livro.getText();
				String tag2 = tfTag2Livro.getText();
				String tag3 = tfTag3Livro.getText();
				Categoria categoria = (Categoria) cbCatLivro.getSelectedItem();
				Editora editora  = (Editora) cbEditLivro.getSelectedItem();
				Boolean status = true;
				
				
				int[] indicesAreas = listAreasLivro.getSelectedIndices();
				ArrayList<Area> listAreas = new ArrayList<Area>();
			    // Get all the selected items using the indices
			    for (int i = 0; i < indicesAreas.length; i++) {
			      Area areaSel = listAreasLivro.getModel().getElementAt(indicesAreas[i]);
			      listAreas.add(areaSel);
			    }
			    
			    int[] indicesAutor = listAutoresLivro.getSelectedIndices();
				ArrayList<Autor> listAutores = new ArrayList<Autor>();
			    // Get all the selected items using the indices
			    for (int i = 0; i < indicesAutor.length; i++) {
			      Autor autorSel = listAutoresLivro.getModel().getElementAt(indicesAutor[i]);
			      listAutores.add(autorSel);
			    }

			    ArrayList<String> tags = new ArrayList<String>();
			    tags.add(tag1);
			    tags.add(tag2);
			    tags.add(tag3);
				
			    try {
					Livro l  = Fachada.cadastrarLivro(listAutores, listAreas, categoria,  editora,  tags, 
							titulo, resumo, paginas, edicao,  ano,  informacoes,  status, bfLivro, filepdf) ;
			
					JOptionPane.showMessageDialog(null, "Livro Cadastrado com sucesso: " + l.getTitulo() +"!");
					
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
				
			}
		});
		btnCadLivro.setForeground(new Color(32, 178, 170));
		btnCadLivro.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCadLivro.setBorder(new LineBorder(new Color(32, 178, 170), 2, true));
		btnCadLivro.setBackground(Color.WHITE);
		btnCadLivro.setBounds(214, 561, 226, 32);
		panelLivro.add(btnCadLivro);
		
		lblTagsLivro = new JLabel("Tags");
		lblTagsLivro.setForeground(new Color(32, 178, 170));
		lblTagsLivro.setFont(new Font("Dialog", Font.BOLD, 13));
		lblTagsLivro.setBounds(26, 288, 110, 14);
		panelLivro.add(lblTagsLivro);
		
		tfTag1Livro = new JTextField();
		tfTag1Livro.setColumns(10);
		tfTag1Livro.setBorder(new LineBorder(new Color(32, 178, 170), 2, true));
		tfTag1Livro.setBounds(26, 313, 84, 32);
		panelLivro.add(tfTag1Livro);
		
		tfTag2Livro = new JTextField();
		tfTag2Livro.setColumns(10);
		tfTag2Livro.setBorder(new LineBorder(new Color(32, 178, 170), 2, true));
		tfTag2Livro.setBounds(120, 313, 84, 32);
		panelLivro.add(tfTag2Livro);
		
		tfTag3Livro = new JTextField();
		tfTag3Livro.setColumns(10);
		tfTag3Livro.setBorder(new LineBorder(new Color(32, 178, 170), 2, true));
		tfTag3Livro.setBounds(210, 313, 84, 32);
		panelLivro.add(tfTag3Livro);
		
		ilbInfoLivro = new JLabel("Informa\u00E7\u00F5es");
		ilbInfoLivro.setForeground(new Color(32, 178, 170));
		ilbInfoLivro.setFont(new Font("Dialog", Font.BOLD, 13));
		ilbInfoLivro.setBounds(26, 360, 110, 14);
		panelLivro.add(ilbInfoLivro);
		
		tfInfoLivro = new JTextField();
		tfInfoLivro.setColumns(10);
		tfInfoLivro.setBorder(new LineBorder(new Color(32, 178, 170), 2, true));
		tfInfoLivro.setBounds(26, 385, 268, 32);
		panelLivro.add(tfInfoLivro);
		
		lblAreasLivro = new JLabel("\u00C1reas de Atua\u00E7\u00E3o");
		lblAreasLivro.setForeground(new Color(32, 178, 170));
		lblAreasLivro.setFont(new Font("Dialog", Font.BOLD, 13));
		lblAreasLivro.setBounds(318, 317, 160, 14);
		panelLivro.add(lblAreasLivro);
		
		scrollAreasLivro = new JScrollPane();
		scrollAreasLivro.setBorder(new LineBorder(new Color(32, 178, 170)));
		scrollAreasLivro.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollAreasLivro.setBounds(318, 342, 268, 75);
		panelLivro.add(scrollAreasLivro);
		

		listAreasLivro= new JList<Area>(modelAreas);
		listAreasLivro.setForeground(new Color(32, 178, 170));
		listAreasLivro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		scrollAreasLivro.setViewportView(listAreasLivro);
		
		
		lblAutoresLivro = new JLabel("Autores");
		lblAutoresLivro.setForeground(new Color(32, 178, 170));
		lblAutoresLivro.setFont(new Font("Dialog", Font.BOLD, 13));
		lblAutoresLivro.setBounds(318, 202, 160, 14);
		panelLivro.add(lblAutoresLivro);
		
		scrollAutoresLivro = new JScrollPane();
		scrollAutoresLivro.setBorder(new LineBorder(new Color(32, 178, 170)));
		scrollAutoresLivro.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollAutoresLivro.setBounds(317, 227, 268, 75);
		panelLivro.add(scrollAutoresLivro);
		
		modelAutores = new DefaultListModel<Autor>();
		List<Autor> autores;
		try {
			autores = Fachada.listarAutores();
			for(Autor au: autores) {
				//System.out.println(c);
				modelAutores.addElement(au);
			}
		} catch (Exception e) {
			e.getMessage();
		}
			
		listAutoresLivro = new JList<Autor>(modelAutores);
		listAutoresLivro.setForeground(new Color(32, 178, 170));
		listAutoresLivro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		scrollAutoresLivro.setViewportView(listAutoresLivro);
		
		
		modelEditoras = new DefaultComboBoxModel<Editora>();
		List<Editora> editoras;
		try {
			editoras = Fachada.listarEditoras();
			for(Editora e: editoras) {
				//System.out.println(c);
				modelEditoras.addElement(e);
			}
		} catch (Exception e) {
			e.getMessage();
		}
			
		cbEditLivro = new JComboBox<Editora>(modelEditoras);
		cbEditLivro.setForeground(new Color(32, 178, 170));
		cbEditLivro.setFont(new Font("Tahoma", Font.PLAIN, 11));
		cbEditLivro.setBorder(new LineBorder(new Color(32, 178, 170)));
		cbEditLivro.setBounds(170, 168, 124, 32);
		panelLivro.add(cbEditLivro);
		
		
		
		modelCategorias = new DefaultComboBoxModel<Categoria>();
		List<Categoria> categorias;
		try {
			categorias = Fachada.listarCategorias();
			for(Categoria c: categorias) {
				//System.out.println(c);
				modelCategorias.addElement(c);
			}
		} catch (Exception e) {
			e.getMessage();
		}
		
		cbCatLivro = new JComboBox<Categoria>(modelCategorias);
		cbCatLivro.setForeground(new Color(32, 178, 170));
		cbCatLivro.setFont(new Font("Tahoma", Font.PLAIN, 11));
		cbCatLivro.setBorder(new LineBorder(new Color(32, 178, 170)));
		cbCatLivro.setBounds(26, 168, 124, 32);
		panelLivro.add(cbCatLivro);
		
		scrollResumoLivro = new JScrollPane();
		scrollResumoLivro.setBounds(26, 453, 565, 97);
		panelLivro.add(scrollResumoLivro);
		
		taResumoLivro = new JTextArea();
		scrollResumoLivro.setViewportView(taResumoLivro);
		taResumoLivro.setBorder(new LineBorder(new Color(32, 178, 170), 2, true));
		tabbedPane.setForegroundAt(4, new Color(32, 178, 170));
		
		
		
		
		
		
		/******************************CONVIDADO ********************************/
		panelConvidado = new JPanel();
		panelConvidado.setEnabled(false);
		tabbedPane.addTab("Convidado", null, panelConvidado, null);
		tabbedPane.setForegroundAt(5, new Color(32, 178, 170));
		panelConvidado.setLayout(null);
		
		lblCadastroDeConvidado = new JLabel("Cadastro de Convidado");
		lblCadastroDeConvidado.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastroDeConvidado.setForeground(new Color(32, 178, 170));
		lblCadastroDeConvidado.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCadastroDeConvidado.setBounds(267, 30, 161, 22);
		panelConvidado.add(lblCadastroDeConvidado);
		
		lblNomeConv = new JLabel("Nome Completo");
		lblNomeConv.setForeground(new Color(32, 178, 170));
		lblNomeConv.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNomeConv.setBounds(37, 83, 168, 14);
		panelConvidado.add(lblNomeConv);
		
		tfNomeConv = new JTextField();
		tfNomeConv.setColumns(10);
		tfNomeConv.setBorder(new LineBorder(new Color(32, 178, 170), 2, true));
		tfNomeConv.setBounds(37, 110, 268, 32);
		panelConvidado.add(tfNomeConv);
		
		lblLoginConv = new JLabel("Login");
		lblLoginConv.setForeground(new Color(32, 178, 170));
		lblLoginConv.setFont(new Font("Dialog", Font.BOLD, 13));
		lblLoginConv.setBounds(37, 153, 110, 14);
		panelConvidado.add(lblLoginConv);
		
		tfLoginConv = new JTextField();
		tfLoginConv.setColumns(10);
		tfLoginConv.setBorder(new LineBorder(new Color(32, 178, 170), 2, true));
		tfLoginConv.setBounds(37, 178, 120, 32);
		panelConvidado.add(tfLoginConv);
		
		lblSenhaConv = new JLabel("Senha");
		lblSenhaConv.setForeground(new Color(32, 178, 170));
		lblSenhaConv.setFont(new Font("Dialog", Font.BOLD, 13));
		lblSenhaConv.setBounds(185, 153, 110, 14);
		panelConvidado.add(lblSenhaConv);
		
		tfSenhaConv = new JTextField();
		tfSenhaConv.setColumns(10);
		tfSenhaConv.setBorder(new LineBorder(new Color(32, 178, 170), 2, true));
		tfSenhaConv.setBounds(185, 178, 120, 32);
		panelConvidado.add(tfSenhaConv);
		
		lblEmailConv = new JLabel("Email");
		lblEmailConv.setForeground(new Color(32, 178, 170));
		lblEmailConv.setFont(new Font("Dialog", Font.BOLD, 13));
		lblEmailConv.setBounds(329, 83, 110, 14);
		panelConvidado.add(lblEmailConv);
		
		tfEmailConv = new JTextField();
		tfEmailConv.setColumns(10);
		tfEmailConv.setBorder(new LineBorder(new Color(32, 178, 170), 2, true));
		tfEmailConv.setBounds(329, 110, 268, 32);
		panelConvidado.add(tfEmailConv);
		
		lblImagemConv = new JLabel("Imagem");
		lblImagemConv.setForeground(new Color(32, 178, 170));
		lblImagemConv.setFont(new Font("Dialog", Font.BOLD, 13));
		lblImagemConv.setBounds(329, 149, 110, 14);
		panelConvidado.add(lblImagemConv);
		
		tfImagemConv = new JTextField();
		tfImagemConv.setColumns(10);
		tfImagemConv.setBorder(new LineBorder(new Color(32, 178, 170), 2, true));
		tfImagemConv.setBounds(329, 178, 161, 32);
		panelConvidado.add(tfImagemConv);
		
		btnSelecionarConv = new JButton("Selecionar");
		btnSelecionarConv.setForeground(new Color(32, 178, 170));
		btnSelecionarConv.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSelecionarConv.setBorder(new LineBorder(new Color(32, 178, 170), 2, true));
		btnSelecionarConv.setBackground(Color.WHITE);
		btnSelecionarConv.setBounds(500, 178, 97, 32);
		panelConvidado.add(btnSelecionarConv);
		
		lblFotoConv = new JLabel("");
		lblFotoConv.setBounds(607, 110, 95, 100);
		panelConvidado.add(lblFotoConv);
		
		btnCadConv = new JButton("Cadastrar Convidado");
		btnCadConv.setForeground(new Color(32, 178, 170));
		btnCadConv.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCadConv.setBorder(new LineBorder(new Color(32, 178, 170), 2, true));
		btnCadConv.setBackground(Color.WHITE);
		btnCadConv.setBounds(240, 253, 213, 32);
		panelConvidado.add(btnCadConv);
	}
}
