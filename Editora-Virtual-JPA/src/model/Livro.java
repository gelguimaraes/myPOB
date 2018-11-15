package model;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;


@Entity 
public class Livro  {
	@Id		
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(length=4, nullable=false, name="ID_LIVRO")
	private int id;
	
	@ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinTable(name="AUTORES_LIVROS", joinColumns={@JoinColumn(name="FK_LIVRO_ID")},
    inverseJoinColumns={@JoinColumn(name="FK_AUTOR_ID")})
	private ArrayList<Autor> autores = new ArrayList<Autor>();
	
	@ManyToOne
	@JoinColumn(nullable=true, name="FK_CATEGORIA_ID")
	private Categoria categoria;
	
	@ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinTable(name="LIVROS_AREAS", joinColumns={@JoinColumn(name="FK_LIVRO_ID")},
    inverseJoinColumns={@JoinColumn(name="FK_AREA_ID")})
	private ArrayList<Area> areas = new ArrayList<Area>();
	
	@ElementCollection(fetch=FetchType.LAZY)
	@CollectionTable(name = "LIVRO_TAGS", joinColumns=@JoinColumn(name = "FK_LIVRO_ID", referencedColumnName = "ID_LIVRO")) 
	@Column(length=50, nullable=true, name="TAGS")
	private ArrayList<String> tags = new ArrayList<String>();
	
	@ManyToOne
	@JoinColumn(nullable=true, name="FK_EDITORA_ID")
	private Editora editora;
	
	private String titulo;
	private String resumo;
	private int paginas;
	private int edicao;
	private int ano;
	private String informacoes;
	private boolean status; 
	private byte[] imagem;
	private byte[] file;
	
	
	public Livro(){}
	
	public Livro(String titulo, String resumo, int paginas, int edicao, int ano,
			String informacoes, boolean status, BufferedImage bf, File pdf) {
		
		this.titulo = titulo;
		this.resumo = resumo;
		this.paginas = paginas;
		this.edicao = edicao;
		this.ano = ano;
		this.informacoes = informacoes;
		this.status = status;
		this.setBufferedImage(bf);
		this.setFilePdf(pdf);
		
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public ArrayList<Autor> getAutores() {
		return autores;
	}

	public void addAutor(Autor autor) {
		this.autores.add(autor);
		autor.addLivro(this);
	}
	
	public void delAutor(Autor autor) {
		this.autores.remove(autor);
		autor.delLivro(this);
	
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void addCategoria(Categoria categoria) {
		this.categoria = categoria;
		categoria.addLivro(this);
	}
	
	public void delCategoria(Categoria categoria) {
		this.categoria = null;
		categoria.delLivro(this);
	}
	
	public ArrayList<Area> getAreas() {
		return areas;
	}

	public void addArea(Area area) {
		this.areas.add(area);
		area.addLivro(this);
	}
	
	public void delArea(Area area) {
		this.areas.remove(area);
		area.delLivro(this);
	}
	

	public ArrayList<String> getTags() {
		return tags;
	}

	public void addTag(String tag) {
		this.tags.add(tag);
	}
	
	public void delTag(String tag) {
		this.tags.remove(tag);
	}
	

	public Editora getEditora() {
		return editora;
	}

	public void addEditora(Editora editora) {
		this.editora = editora;
		editora.addLivro(this);
	}
	
	public void delEditora(Editora editora) {
		this.editora = null;
		editora.delLivro(this);
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getResumo() {
		return resumo;
	}

	public void setResumo(String resumo) {
		this.resumo = resumo;
	}

	public int getPaginas() {
		return paginas;
	}

	public void setPaginas(int paginas) {
		this.paginas = paginas;
	}

	public int getEdicao() {
		return edicao;
	}

	public void setEdicao(int edicao) {
		this.edicao = edicao;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public String getInformacoes() {
		return informacoes;
	}

	public void setInformacoes(String informacoes) {
		this.informacoes = informacoes;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
	public BufferedImage getBufferedImage() throws Exception{
		try {
			InputStream in = new ByteArrayInputStream(this.imagem);
			BufferedImage bf = ImageIO.read(in);
			return bf;
		} catch (IOException e) {
			throw new Exception("Leitura de arquivo inválida!");
		}
		
	}

	public void setBufferedImage(BufferedImage bf) {
		try{
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ImageIO.write(bf, "jpg", baos );		// tipo de gravacao
			baos.flush();
			baos.close();
			this.imagem = baos.toByteArray();		
		}
		catch(Exception e ){
			e.printStackTrace();
		}

	}
	
    public void setFilePdf(File pdf){
        
        try {
	        FileInputStream fis = new FileInputStream(pdf);
	        //System.out.println(file.exists() + "!!");
	        //InputStream in = resource.openStream();
	        ByteArrayOutputStream bos = new ByteArrayOutputStream();
	        byte[] buf = new byte[1024];
        	
            for (int readNum; (readNum = fis.read(buf)) != -1;) {
                bos.write(buf, 0, readNum); 
                //System.out.println("read " + readNum + " bytes,");
            }
            this.file = bos.toByteArray();
            fis.close();
            
        } catch (Exception ex) {
        	System.err.println(ex.getMessage()); 
        }  
    }

    public File getFilePdf() {
        	
        File downloadFile = new File(this.titulo + ".pdf");   
        try {
	        FileOutputStream fos = new FileOutputStream(downloadFile);
	        fos.write(this.file);
	        fos.flush();
	        fos.close();
       
        } catch (IOException ex) {
        	System.err.println(ex.getMessage());
        }  
        return downloadFile;
    }
    
    public byte[] getFilePdfBytes() {
        return this.file;
    }

	@Override
	public String toString() {
		return "Id: " + id + ", Titulo: " + titulo + " Autores: " + autores + ", Categoria: " 
					+ categoria + ", Areas: " + areas + "\n";
	}
	
	

}
