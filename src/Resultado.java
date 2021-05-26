public class Resultado implements Cloneable
{
	private int ra;
	private int cod;
	private float nota;
	private float freq;
	
	public void setRa(int ra) throws Exception
	{
		if (ra <= 0)
            throw new Exception ("RA invalido");
		
		this.ra = ra;
	}
	
	public void setCod(int cod) throws Exception
	{
		if (cod <= 0)
            throw new Exception ("Codigo invalido");
		
		this.cod = cod;
	}
	
	public void setNota(float nota) throws Exception
	{
		if (nota <= 0)
            throw new Exception ("Nota invalido");
		
		this.nota = nota;
	}
	
	public void setFreq(float freq) throws Exception
	{
		if (freq <= 0)
            throw new Exception ("Frequencia invalido");
		
		this.freq = freq;
	}

	public int getRa()
	{
		return ra;
	}
	
	public int getCod()
	{
		return cod;
	}
	
	public float getNota()
	{
		return nota;
	}
	
	public float getFreq()
	{
		return freq;
	}
	
	public Resultado() {
		
	}
	
	public Resultado(int ra, int cod, float nota, float freq)
	{
		try
		{
			setRa(ra);
			setCod(cod);
			setNota(nota);
			setFreq(freq);	
		}
		catch(Exception err)
		{
			System.out.println(err.getMessage());
		}
	}

    public String toString ()
    {
        String ret="";

        ret+="RA........: "+this.ra   +"\n";
        ret+="Codigo....: "+this.cod  +"\n";
        ret+="Nota......: "+this.nota +"\n";
        ret+="Frequencia: "+this.freq +"\n\n";

        return ret;
    }

    public boolean equals (Object obj)
    {
        if (this==obj)
            return true;

        if (obj==null)
            return false;

        if (!(obj instanceof Resultado))
            return false;

        Resultado resultado = (Resultado)obj;

        if (this.cod  !=resultado.cod)
            return false;

        if (this.ra   !=resultado.ra)
            return false;

        if (this.nota !=resultado.nota)
            return false;
            
	    if (this.freq !=resultado.freq)
			return false;

        return true;
    }

    public int hashCode ()
    {
        int ret=666;

        ret = 7*ret + new Integer(this.ra).hashCode();
        ret = 7*ret + new Integer(this.cod).hashCode();
        ret = 7*ret + new Float(this.nota).hashCode();
        ret = 7*ret + new Float(this.freq).hashCode();
        
        if(ret < 0)
			ret = -ret;

        return ret;
    }

    public Resultado (Resultado modelo) throws Exception
    {
        this.ra = modelo.ra; 
        this.cod   = modelo.cod;   
        this.nota  = modelo.nota;  
        this.freq = modelo.freq; 
    }

    public Object clone ()
    {
        Resultado ret=null;

        try
        {
            ret = new Resultado (this);
        }
        catch (Exception erro)
        {} 
        
        return ret;
    }
	
}