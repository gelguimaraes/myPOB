package model;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class Convidado extends Usuario {
	
	private byte[] imagem;

	public Convidado(String nome, String login, String senha, String email, BufferedImage bf) {
		super(nome, login, senha, email);
		this.setBufferedImage(bf);
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
	

}
