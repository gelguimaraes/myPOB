package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileFilter;

import model.Area;
import model.Livro;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class TelaInfoLivro extends JFrame{

	
	private static Livro livro;
	private JLabel lblCapaLivro;
	private JLabel lbltituloLivro;
	private JLabel lblCategoriaLivro;
	private JLabel lblResumoLivro;
	private JLabel lblInfoLivro;
	private JLabel lblEdicaoLivro;
	private JLabel lblEditoraLivro;
	private JLabel lblPagLivro;
	private JLabel lblAnoLivro;
	private JLabel lblAreasLivro;
	private JPanel panelAutoresLivro;
	private JLabel lblTagsLivro;
	private ImageIcon imgIcon;
	private JLabel lblAutores;
	private JLabel[] autores = new JLabel[5];
	private JButton btnDownloadPdf;
	private JScrollPane scrollPane;
	

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInfoLivro window = new TelaInfoLivro(livro);
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public TelaInfoLivro(Livro l) {
		
		getContentPane().setBackground(new Color(240,240,240));
		setTitle(l.getTitulo());
		setBounds(100, 100, 1024, 768);
		getContentPane().setLayout(null);
		
		BufferedImage bf = null;
		try {
			bf = l.getBufferedImage();
		} catch (Exception e) {	
			e.getMessage();
		}

		imgIcon = new ImageIcon(bf.getScaledInstance(288, 420,Image.SCALE_DEFAULT));				
		lblCapaLivro = new JLabel();
		lblCapaLivro.setIcon(imgIcon);
		lblCapaLivro.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblCapaLivro.setVerticalAlignment(SwingConstants.CENTER);
		lblCapaLivro.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblCapaLivro.setHorizontalTextPosition(SwingConstants.CENTER);
		lblCapaLivro.setHorizontalAlignment(SwingConstants.CENTER);
		lblCapaLivro.setOpaque(true);
		lblCapaLivro.setBackground(new Color(32, 178, 170));
		lblCapaLivro.setBounds(40, 50, 288, 420);
		getContentPane().add(lblCapaLivro);
		
		lbltituloLivro = new JLabel();
		lbltituloLivro.setVerticalTextPosition(SwingConstants.BOTTOM);
		lbltituloLivro.setHorizontalTextPosition(SwingConstants.LEFT);
		lbltituloLivro.setHorizontalAlignment(SwingConstants.LEFT);
		lbltituloLivro.setVerticalAlignment(SwingConstants.TOP);
		lbltituloLivro.setForeground(new Color(32, 178, 170));
		lbltituloLivro.setFont(new Font("Tahoma", Font.BOLD, 18));
		lbltituloLivro.setBounds(353, 51, 625, 41);
		lbltituloLivro.setText("<html><p align='left'>"+ l.getTitulo().toUpperCase() +"</p></html>");
		getContentPane().add(lbltituloLivro);
		
		lblCategoriaLivro = new JLabel();
		lblCategoriaLivro.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblCategoriaLivro.setForeground(new Color(105, 105, 105));
		lblCategoriaLivro.setBounds(353, 94, 625, 14);
		lblCategoriaLivro.setText("(Categoria: " + l.getCategoria().getNome()+ ")");
		getContentPane().add(lblCategoriaLivro);
		
		lblResumoLivro = new JLabel();
		lblResumoLivro.setVerticalAlignment(SwingConstants.TOP);
		lblResumoLivro.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblResumoLivro.setBounds(38, 489, 940, 171);
		lblResumoLivro.setText("<html><p align='left'><b>RESUMO:</b> <br><br>"+ l.getResumo() +"</p></html>");
		getContentPane().add(lblResumoLivro);
		
	
		lblInfoLivro = new JLabel();
		lblInfoLivro.setForeground(new Color(0, 0, 0));
		lblInfoLivro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblInfoLivro.setBounds(353, 119, 625, 32);
		lblInfoLivro.setText(l.getInformacoes());
		getContentPane().add(lblInfoLivro);
		
		lblEditoraLivro = new JLabel();
		lblEditoraLivro.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEditoraLivro.setBounds(353, 162, 179, 32);
		lblEditoraLivro.setText("<html><b>EDITORA: </b>"+l.getEditora().getNome()+"</html>");
		getContentPane().add(lblEditoraLivro);
		
		lblEdicaoLivro = new JLabel();
		lblEdicaoLivro.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEdicaoLivro.setBounds(542, 162, 163, 32);
		lblEdicaoLivro.setText("<html><b>EDIÇÂO: </b>"+ Integer.toString(l.getEdicao())+"ª</html>");
		getContentPane().add(lblEdicaoLivro);
		
		lblPagLivro = new JLabel();
		lblPagLivro.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPagLivro.setBounds(715, 162, 145, 32);
		lblPagLivro.setText("<html><b>PÁGINAS: </b>" + Integer.toString(l.getPaginas())+"</html>");
		getContentPane().add(lblPagLivro);
		
		lblAnoLivro = new JLabel();
		lblAnoLivro.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAnoLivro.setBounds(863, 162, 115, 32);
		lblAnoLivro.setText("<html><b>ANO: </b>" + Integer.toString(l.getAno())+"</html>");
		getContentPane().add(lblAnoLivro);
		
		
		String areas ="";
		for(Area a :l.getAreas())
			areas += ""+a.getNome() +"<br>";
		
		lblAreasLivro = new JLabel();
		lblAreasLivro.setVerticalAlignment(SwingConstants.TOP);
		lblAreasLivro.setForeground(new Color(32, 178, 170));
		lblAreasLivro.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblAreasLivro.setBounds(353, 205, 625, 87);
		lblAreasLivro.setText("<html><font color='black'><b>ÁREAS:</b></font><br> " +areas +"</html>");
		getContentPane().add(lblAreasLivro);
		
		
		String tags = "";
		for(String tag : l.getTags())
			tags += "#" +tag + " ";
		lblTagsLivro = new JLabel();
		lblTagsLivro.setForeground(new Color(105, 105, 105));
		lblTagsLivro.setFont(new Font("Tahoma", Font.ITALIC, 12));
		lblTagsLivro.setVerticalAlignment(SwingConstants.BOTTOM);
		lblTagsLivro.setBounds(353, 455, 625, 14);
		lblTagsLivro.setText("Tags: " +tags);
		getContentPane().add(lblTagsLivro);
		
		panelAutoresLivro = new JPanel();
		panelAutoresLivro.setBounds(353, 328, 625, 116);
		getContentPane().add(panelAutoresLivro);
		panelAutoresLivro.setLayout(null);
		
		int tam = l.getAutores().size();
		
		for(int j=0; j < tam; j++){
			
			//	System.out.println("i: " + i + ", j: " + j);
				BufferedImage bfAutor = null;
				try {
					bfAutor = l.getAutores().get(j).getBufferedImage();
				} catch (Exception e) {	
					e.getMessage();
				}

				imgIcon = new ImageIcon(bfAutor.getScaledInstance(90, 90,Image.SCALE_DEFAULT));				
				autores[j] = new JLabel();
				autores[j].setBounds(j*120, 0, 120, 120);	
				autores[j].setText("<html><p align='center'>"+ l.getAutores().get(j).getNome() +"</p></html>");
				autores[j].setIcon(imgIcon);
				autores[j].setVerticalTextPosition(SwingConstants.BOTTOM);
				autores[j].setVerticalAlignment(SwingConstants.CENTER);
				autores[j].setAlignmentX(Component.CENTER_ALIGNMENT);
				autores[j].setHorizontalTextPosition(SwingConstants.CENTER);
				autores[j].setHorizontalAlignment(SwingConstants.CENTER);
				autores[j].setToolTipText(l.getAutores().get(j).getNome());
				autores[j].setFont(new Font("NewsGoth BT", Font.BOLD, 12));
				autores[j].setOpaque(true);


				panelAutoresLivro.add(autores[j]);
		}
		
		lblAutores = new JLabel();
		lblAutores.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAutores.setText("<html><b>AUTORES:</b></html>");
		lblAutores.setBounds(353, 303, 625, 14);
		
		getContentPane().add(lblAutores);
		
		btnDownloadPdf = new JButton("Download do Livro");
		btnDownloadPdf.setFocusPainted(false);
		btnDownloadPdf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				JFileChooser telaEscolha = new JFileChooser("C:/"); 
				telaEscolha.setDialogTitle("Salvar " + l.getTitulo()); 
				
				File arquivo = telaEscolha.getSelectedFile();
				telaEscolha.setSelectedFile(new File(l.getTitulo()+".pdf"));
      
				int option = telaEscolha.showSaveDialog(null); 	
				
				if (option == JFileChooser.APPROVE_OPTION) {
				    try {
				    	arquivo = telaEscolha.getSelectedFile();
						OutputStream ops = new FileOutputStream(arquivo);
						ops.write(l.getFilePdfBytes());
						ops.close();
				    } catch (IOException e) {
						e.printStackTrace();
					}
				    System.out.println("Salvando em: " + arquivo.getAbsolutePath());
				}
			}
			
			
	
		});
		btnDownloadPdf.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDownloadPdf.setBorder(new LineBorder(new Color(32, 178, 170), 2));
		btnDownloadPdf.setBackground(new Color(32, 178, 170));
		btnDownloadPdf.setForeground(new Color(255, 255, 255));
		btnDownloadPdf.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnDownloadPdf.setBounds(40, 671, 228, 33);
		getContentPane().add(btnDownloadPdf);
		setLocationRelativeTo(null);
	
	}
}
