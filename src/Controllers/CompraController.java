package Controllers;
import Classes.Compra;
import Classes.Pessoa;
import org.jetbrains.annotations.NotNull;
import java.io.*;
import java.util.ArrayList;

public class CompraController {
    public String gerarSql() {
        ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
        ArrayList<Compra> compras = new ArrayList<Compra>();

        String comandoSqlPessoas = "";
        String comandoSqlCompras = "";

        String arquivoCSV = "C:\\Users\\Administrator\\Documents\\playground\\svn\\java-novo\\criar-inserts\\src\\DataSources\\compras_slicitacoes_ponto_e_virgula.csv";
        BufferedReader br = null;
        String linha = "";
        String csvDivisor = ";";
        try {
            int i = 0;
            int arquivosCriados = 0;

            br = new BufferedReader(new FileReader(arquivoCSV));

            while ((linha = br.readLine()) != null) {
                try{
                    linha = linha.replaceAll("'","");
                    linha = linha.replaceAll("\"","");

                    String[] colunas = linha.split(csvDivisor);

                    int id = Integer.parseInt(colunas[1]);
                    int id_modalidade_licitacao = Integer.parseInt(colunas[2]);
                    int id_orgao = Integer.parseInt(colunas[3]);
                    int id_uasg = Integer.parseInt(colunas[4]);
                    String fundamento_legal = colunas[5];
                    String justificativa = colunas[6];
                    String objeto_licitacao = colunas[7];
                    String data_declaracao = colunas[8];
                    if(data_declaracao != "" && data_declaracao != null){
                        data_declaracao = data_declaracao.split("T")[0];
                    }

                    String data_publicacao = colunas[9];
                    if(data_publicacao != "" && data_publicacao != null){
                        data_publicacao = data_publicacao.split("T")[0];
                    }

                    String data_ratificacao = colunas[10];
                    if(data_ratificacao != "" && data_ratificacao != null){
                        data_ratificacao = data_ratificacao.split("T")[0];
                    }

                    int numero_inciso = 0;
                    if(colunas[15] != "" && colunas[15] != null){
                        try{
                            numero_inciso = Integer.parseInt(colunas[15]);
                        }catch (Exception ex){
                            numero_inciso = 0;
                        }
                    }

                    String numero_processo = colunas[16];
                    double valor_estimado = Double.parseDouble(colunas[17]);

                    Compra compra = new Compra(id, id_modalidade_licitacao, id_orgao, id_uasg, numero_inciso, numero_processo, valor_estimado, fundamento_legal, justificativa, objeto_licitacao, data_declaracao, data_publicacao, data_ratificacao);

                    Pessoa pessoaReconhecimento = new Pessoa(colunas[13],colunas[11], pessoas.size()+1);
                    Pessoa pessoaRatificacao = new Pessoa(colunas[14],colunas[12], pessoas.size()+2);

                    int idPessoaReconhecimento = listaTemPessoa(pessoas, pessoaReconhecimento);
                    int idPessoaRatificacao = listaTemPessoa(pessoas, pessoaRatificacao);

                    if(idPessoaReconhecimento == 0){
                        pessoas.add(pessoaReconhecimento);
                        idPessoaReconhecimento = pessoaReconhecimento.getId();
                    }
                    compra.setId_responsavel_reconhecimento(idPessoaReconhecimento);

                    if(idPessoaRatificacao == 0){
                        pessoas.add(pessoaRatificacao);
                        idPessoaRatificacao = pessoaRatificacao.getId();
                    }
                    compra.setId_responsavel_ratificacao(idPessoaRatificacao);
                    compras.add(compra);
                }
                catch (Exception exce){
                    System.out.println("Erro: " + exce.getLocalizedMessage());
                }

                i = i + 1;

                if(i == 499){
                    for (Pessoa p : pessoas){
                        String addPessoa = "INSERT INTO mydb.pessoa(`id`,`nome`,`cargo`)VALUES(" + p.getId() + ",'" + p.getNome() + "','" + p.getCargo() + "');";
                        comandoSqlPessoas = comandoSqlPessoas + "\n" + addPessoa;
                    }
                    for (Compra c : compras){
                        String addCompra = "INSERT INTO mydb.compra" +
                                "(`id`," +
                                "`fundamento_legal`," +
                                "`justificativa`," +
                                "`objeto_licitacao`," +
                                "`data_declaracao_dispensa`," +
                                "`data_publicacao`," +
                                "`data_ratificacao`," +
                                "`numero_inciso`," +
                                "`numero_processo`," +
                                "`valor_estimado`," +
                                "`Orgao_id`," +
                                "`UASG_id`," +
                                "`id_responsavel_reconhecimento`," +
                                "`id_responsavel_ratificacao`," +
                                "`ModalidadeLicitacao_id`)" +
                                "VALUES(" +
                                c.getId() + "," +
                                "'" + c.getFundamento_legal() + "'," +
                                "'" + c.getJustificativa() + "'," +
                                "'" + c.getObjeto_licitacao() + "'," +
                                pegarStringInsercaoData(c.getData_declaracao_dispensa()) +
                                pegarStringInsercaoData(c.getData_publicacao()) +
                                pegarStringInsercaoData(c.getData_ratificacao()) +
                                c.getNumero_inciso() + "," +
                                "'" + c.getNumero_processo() + "'," +
                                c.getValor_estimado() + "," +
                                c.getId_orgao() + "," +
                                c.getId_uasg() + "," +
                                c.getId_responsavel_reconhecimento() + "," +
                                c.getId_responsavel_ratificacao() + "," +
                                c.getId_modalidade_licitacao() + ");";

                        comandoSqlCompras = comandoSqlCompras + "\n" + addCompra;
                    }
                    try{
                        FileWriter fw= new FileWriter("C:\\Users\\Administrator\\Documents\\playground\\svn\\java-novo\\criar-inserts\\out\\comandos-sql\\pessoas_" + arquivosCriados + ".sql");
                        fw.write(comandoSqlPessoas);
                        comandoSqlPessoas = "";
                        fw.close();
                    }catch(Exception e){System.out.println(e);}
                    try{
                        FileWriter fw= new FileWriter("C:\\Users\\Administrator\\Documents\\playground\\svn\\java-novo\\criar-inserts\\out\\comandos-sql\\compras_" + arquivosCriados + ".sql");
                        fw.write(comandoSqlCompras);
                        comandoSqlCompras = "";
                        compras = new ArrayList<Compra>();
                        fw.close();
                    }catch(Exception e){System.out.println(e);}

                    i = 0;
                    arquivosCriados = arquivosCriados + 1;
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

        return comandoSqlCompras;
    }

    public int listaTemPessoa(@NotNull ArrayList<Pessoa> pessoas, Pessoa pessoa){
        for(Pessoa p: pessoas){
            if (p.getNome().equalsIgnoreCase(pessoa.getNome())){
                return p.getId();
            }
        }
        return 0;
    }

    public String pegarStringInsercaoData(String data){
        if(data != "" && data != null && !data.isEmpty()){
            return "'"+data+"',";
        }
        return "null,";
    }
}
