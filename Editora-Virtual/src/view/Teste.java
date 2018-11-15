package view;




import java.util.List;

import controller.Fachada;
import model.Area;
import model.Categoria;
import model.Livro;

public class Teste {

	public Teste() {
		try {
			Fachada.inicializar();
			

			//atualização
			

			//exclusao
			

			//listagem
			

			//consultas
			
			
//			Livro l1 ;
//			l1 = Fachada.procurarLivroPorNome("Python");
//			System.out.println(l1);
			
//			List<Livro> l;
//			l= Fachada.ListarLivros();
//			for(Livro li : l)
//				System.out.println(li.getTitulo());
//			
//			for(int i = 0 ; i<l.size(); i++)
//				System.out.println(l.get(i).getTitulo());
//			
			
/*			List<Livro> listalivros;
			listalivros = Fachada.procurarLivrosPorNome("Python");
			for (Livro li : listalivros)
				System.out.println(li.getTitulo());

			
			Categoria c;
			c = Fachada.procurarLivrosNaCategoria("Comercial");
	
				for (Livro li : c.getLivros())
				System.out.println(li.getTitulo());
		
	*/			
				
			 List<Area> areas = Fachada.procurarAreasPorAutor("Gesoaldo");
			// System.out.println(areas.get(0));
			 for (Area a : areas)
				 System.out.println(a.getNome());
		
					
			 
		 
			 List<Livro> lista;
			 lista = Fachada.procurarLivrosPorAreas("Tecnologia");
					for (Livro l: lista)
					System.out.println(l.getTitulo());


			

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		Fachada.finalizar();
		System.out.println("fim do programa");
	}


	//  ***********************************************
	public static void main (String[] args)
	//  ***********************************************
	{
		new Teste();
	}

}
