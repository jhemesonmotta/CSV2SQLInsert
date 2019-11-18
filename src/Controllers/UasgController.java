package Controllers;
import java.io.*;

public class UasgController {
    public String gerarSql() {
        String comandoSql = "";
        String arquivoCSV = "C:\\Users\\Administrator\\Documents\\playground\\svn\\java-novo\\criar-inserts\\src\\DataSources\\uasgs.csv";
        BufferedReader br = null;
        String linha = "";
        String csvDivisor = ",";
        try {
            br = new BufferedReader(new FileReader(arquivoCSV));
            while ((linha = br.readLine()) != null) {
                String[] colunas = linha.split(csvDivisor);
                if(colunas.length == 4){
                    String comandoInsert = "INSERT INTO mydb.uasg(`id`,`nome`,`Municipio_id`)VALUES(" + colunas[0] + ",'" + colunas[1]+colunas[2] +"','"+ colunas[3]+"');";
                    comandoSql = comandoSql + "\n" + comandoInsert;
                }
                else if(colunas.length == 3){
                    String comandoInsert = "";
                    if(ehInteiro(colunas[2])){
                        comandoInsert = "INSERT INTO mydb.uasg(`id`,`nome`,`Municipio_id`)VALUES(" + colunas[0] + ",'" + colunas[1] +"','" +colunas[2]+ "');";
                    }
                    else{
                        comandoInsert = "INSERT INTO mydb.uasg(`id`,`nome`,`Municipio_id`)VALUES(" + colunas[0] + ",'" + colunas[1]+colunas[2]+"',null);";
                    }
                    comandoSql = comandoSql + "\n" + comandoInsert;
                }
                else if(colunas.length == 2){
                    String comandoInsert = "INSERT INTO mydb.uasg(`id`,`nome`,`Municipio_id`)VALUES(" + colunas[0] + ",'" + colunas[1] +"',null);";
                    comandoSql = comandoSql + "\n" + comandoInsert;
                }
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
            FileWriter fw= new FileWriter("C:\\Users\\Administrator\\Documents\\playground\\svn\\java-novo\\criar-inserts\\out\\comandos-sql\\uasgs.sql");
            fw.write(comandoSql);
            fw.close();
        }catch(Exception e){System.out.println(e);}
        return comandoSql;
    }

    public boolean ehInteiro( String s ) {
        // cria um array de char
        char[] c = s.toCharArray();
        boolean d = true;

        for ( int i = 0; i < c.length; i++ ){
            // verifica se o char não é um dígito
            if ( !Character.isDigit( c[ i ] ) ) {
                d = false;
                break;
            }
        }
        return d;
    }
}
