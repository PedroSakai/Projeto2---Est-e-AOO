import java.util.List;


public class ArrayResultado {
	
	private List<Resultado> resultado;
	
	public List<Resultado> getResultado()
	{
		return resultado;
	}
	
	public void setResultado(List<Resultado> resul)
	{
		this.resultado = resul;
	}
	
	
	public ArrayResultado(List<Resultado> resul)
	{
		this.resultado = resul;
	}
	
	public ArrayResultado()
	{
		
	}
	
	public String toString()
	{
		String ret = "";
		
		int size = resultado.size();
		
		
		for(int i=0; i< size; i++)
		{
			Resultado resultadoVez = resultado.get(i);
			ret += resultadoVez;
		}
		
		return ret;
	}
}
