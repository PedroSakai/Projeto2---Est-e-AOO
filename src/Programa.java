public class Programa
{
    public static void main (String[] args)
    {
		// PARTE 1:
		char opcao = 'b';
		Resultado resul = null;
		Fila<Resultado> fila = new Fila<Resultado>();;
	
		do
		{
			try
			{
				System.out.println("(a) Adicionar o resultado de um aluno.");
				System.out.println("(b) Finalizar insercao.");
				opcao = Character.toLowerCase(Teclado.getUmChar());
			}
			catch(Exception err)
			{
				System.out.println(err.getMessage());
			}
			
			if(opcao == 'a')
			{
				try
				{
					System.out.print("\nRA: ");
					int ra  = Teclado.getUmInt();
					
					System.out.print("Codigo da Disciplina: ");
					int cod = Teclado.getUmInt();
					
					System.out.print("Nota: ");
					float nota = Teclado.getUmFloat();
					
					System.out.print("Frequencia (0.0 - 1.0): ");
					float freq = Teclado.getUmFloat();
					
					resul = new Resultado(ra, cod, nota, freq);
					
					
					fila.guardeUmItem(resul);
				}
				catch(Exception err) 
				{
					System.out.println(err.getMessage());
				}
			}

		}while(opcao != 'b');
				
		
		// PARTE 2:

		while(!fila.isVazia())
		{
			Resultado atual = null;
			try
			{
				atual = fila.recupereUmItem();

				ClienteWS.deleteObjeto(Resultado.class, "http://localhost:3000/Matriculas/" + atual.getCod() + "/" + atual.getRa());
				
				ClienteWS.postObjeto(atual, Resultado.class, "http://localhost:5000/Resultados");
				
				fila.removaUmItem();
			}
			catch(Exception err)
			{
				System.err.println("[ERRO]");
			}
		}

		// Printa tudo de resultados:
		ArrayResultado resultado = (ArrayResultado)ClienteWS.getObjeto(ArrayResultado.class, "http://localhost:5000/Resultados");
    	System.out.println (resultado);

	}
}
