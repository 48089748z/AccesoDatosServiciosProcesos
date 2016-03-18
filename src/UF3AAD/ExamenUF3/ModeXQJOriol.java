package UF3AAD.ExamenUF3;
import net.xqj.exist.ExistXQDataSource;
import javax.xml.xquery.*;
public class ModeXQJOriol
{
    private static final String PORT = "8080";
    private static final String IP = "172.31.101.225";
    private static XQConnection connection = null;
    public static void main(String[] args)
    {
        try
        {
            openConnection();
            p1();
            p2(true);
            p3();
            closeConnection();
        }
        catch (XQException e) {System.out.println("XQException: "+e);}
    }
    private static void openConnection() throws XQException
    {
        //CONEXIÓN
        XQDataSource source = new ExistXQDataSource();
        source.setProperty("serverName", IP);
        source.setProperty("port", PORT);
        connection = source.getConnection();
    }
    private static void p1() throws XQException
    {
        String query = "collection('uriCollection')/CATALOG/PLANT/COMMON";
        XQPreparedExpression expression = connection.prepareExpression(query);
        XQResultSequence result = expression.executeQuery();
        String resultados="";
        String linea;
        while (result.next())
        {
            linea = result.getItemAsString(null);
            resultados = resultados+linea;
        }
        String[] nombres = resultados.replaceAll("</COMMON>","").split("<COMMON>");
        String[] stocks = p2(false);

        Integer max = 0;
        Integer index = 0;
        for (int x=1; x< stocks.length; x++)
        {
            if (Integer.parseInt(stocks[x])>max)
            {
                max = Integer.parseInt(stocks[x]);
                index = x;
            }
        }
        System.out.println("\nLa planta amb més Stock es "+nombres[index]);
    }
    private static String[] p2(Boolean outprint) throws XQException
    {
        String query = "collection('uriCollection')/CATALOG/PLANT/AVAILABILITY";
        XQPreparedExpression expression = connection.prepareExpression(query);
        XQResultSequence result = expression.executeQuery();
        String resultados="";
        String linea;
        while (result.next())
        {
            linea = result.getItemAsString(null);
            resultados = resultados+linea;
        }
        String[] results = resultados.replaceAll("</AVAILABILITY>","").split("<AVAILABILITY>");
        Integer totalStock = 0;
        for (int x=1; x<results.length; x++) {totalStock = totalStock + Integer.parseInt(results[x]);}
        if (outprint) {System.out.println("\nEn total hi han "+totalStock+" en Stock");}
        return results;
    }
    private static void p3() throws XQException
    {
        String query = "collection('uriCollection')/CATALOG/PLANT/COMMON";
        XQPreparedExpression expression = connection.prepareExpression(query);
        XQResultSequence result = expression.executeQuery();
        String resultados="";
        String linea;
        while (result.next())
        {
            linea = result.getItemAsString(null);
            resultados = resultados+linea;
        }
        String[] nombres = resultados.replaceAll("</COMMON>","").split("<COMMON>");
        String[] stocks = p2(false);
        String[] prices = getPrices();
        for (int x=1; x<nombres.length; x++)
        {
            Double parsedPrice = Double.parseDouble(prices[x].substring(1,prices[x].length()));
            System.out.println("De la planta "+nombres[x]+" tenim "+stocks[x]+" exemplars. Cada exemplar te un preu de "+parsedPrice+"$. Per tant per la venta tot l'Stock obtindrem "+Integer.parseInt(stocks[x])*parsedPrice+"$");
        }
    }
    private static String[] getPrices() throws XQException
    {
        String query = "collection('uriCollection')/CATALOG/PLANT/PRICE";
        XQPreparedExpression expression = connection.prepareExpression(query);
        XQResultSequence result = expression.executeQuery();
        String resultados="";
        String linea;
        while (result.next())
        {
            linea = result.getItemAsString(null);
            resultados = resultados+linea;
        }
        return  resultados.replaceAll("</PRICE>","").split("<PRICE>");
    }
    private static void closeConnection() throws XQException {connection.close();}
}
