package Controllers;
import java.io.*;

public class MunicipioController {
    public String gerarSql() {
        String comandoSql = "";
        String arquivoCSV = "C:\\Users\\Administrator\\Documents\\playground\\svn\\java-novo\\criar-inserts\\src\\DataSources\\municipios.csv";
        BufferedReader br = null;
        String linha = "";
        String csvDivisor = ",";
        try {
            br = new BufferedReader(new FileReader(arquivoCSV));
            while ((linha = br.readLine()) != null) {
                String[] colunas = linha.split(csvDivisor);
                String comandoInsert = "INSERT INTO mydb.municipio (`id`,`nome`,`UF_sigla`) VALUES ('"+colunas[0]+"','"+colunas[1]+ "','" + colunas[2] + "');";
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
            FileWriter fw= new FileWriter("C:\\Users\\Administrator\\Documents\\playground\\svn\\java-novo\\criar-inserts\\out\\comandos-sql\\municipios.sql");
            fw.write(comandoSql);
            fw.close();
        }catch(Exception e){System.out.println(e);}
        return comandoSql;
    }
}
