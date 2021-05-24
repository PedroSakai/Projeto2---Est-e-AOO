public class Teste
{
    public static void main (String[] args)
    {
        try
        {
            ListaDuplamenteLigadaDesordenada ls = new ListaDuplamenteLigadaDesordenada<String>();

            ls.guardeUmItemNoFinal("Arroz");
            ls.guardeUmItemNoFinal("Batata");
            ls.guardeUmItemNoFinal("Feijão");

            ls.removaItemDoFinal();

            ListaDuplamenteLigadaDesordenada copia = new ListaDuplamenteLigadaDesordenada<String>();

            copia = new ListaDuplamenteLigadaDesordenada<String>(ls);

            System.out.println(ls);
            System.out.println(copia);
        }
        catch(Exception er)
        {
            System.out.println(er.getMessage());
        }
        
    }
}