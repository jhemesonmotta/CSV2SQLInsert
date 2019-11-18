package Controllers;
import java.io.*;

public class UnidadeFederativaController {
    public String gerarSql() {
        String comandoSql = "";

        String arquivoCSV = "C:\\Users\\Administrator\\Documents\\playground\\svn\\java-novo\\criar-inserts\\src\\DataSources\\ufs.csv";
        BufferedReader br = null;
        String linha = "";
        String csvDivisor = ",";
        try {
            br = new BufferedReader(new FileReader(arquivoCSV));
            while ((linha = br.readLine()) != null) {
                String[] colunas = linha.split(csvDivisor);
                String comandoInsert = "INSERT INTO mydb.uf (`sigla`, `nome`) VALUES ('" + colunas[0] + "','" + colunas[1] + "');";
                comandoSql = comandoSql + "\n" + comandoInsert;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        try{
            FileWriter fw= new FileWriter("C:\\Users\\Administrator\\Documents\\playground\\svn\\java-novo\\criar-inserts\\out\\comandos-sql\\ufs.sql");
            fw.write(comandoSql);
            fw.close();
        }catch(Exception e){System.out.println(e);}
        return comandoSql;
    }
}
