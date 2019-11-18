package Classes;

public class Compra {
    private int id;
    private int id_modalidade_licitacao;
    private int id_orgao;
    private int id_uasg;
    private int id_responsavel_reconhecimento;
    private int id_responsavel_ratificacao;
    private int numero_inciso;
    private String numero_processo;
    private double valor_estimado;
    private String fundamento_legal;
    private String justificativa;
    private String objeto_licitacao;
    private String data_declaracao_dispensa;
    private String data_publicacao;
    private String data_ratificacao;

    public Compra() {
    }

    public Compra(int id, int id_modalidade_licitacao, int id_orgao, int id_uasg, int id_responsavel_reconhecimento, int id_responsavel_ratificacao, int numero_inciso, String numero_processo, double valor_estimado, String fundamento_legal, String justificativa, String objeto_licitacao, String data_declaracao_dispensa, String data_publicacao, String data_ratificacao) {
        this.id = id;
        this.id_modalidade_licitacao = id_modalidade_licitacao;
        this.id_orgao = id_orgao;
        this.id_uasg = id_uasg;
        this.id_responsavel_reconhecimento = id_responsavel_reconhecimento;
        this.id_responsavel_ratificacao = id_responsavel_ratificacao;
        this.numero_inciso = numero_inciso;
        this.numero_processo = numero_processo;
        this.valor_estimado = valor_estimado;
        this.fundamento_legal = fundamento_legal;
        this.justificativa = justificativa;
        this.objeto_licitacao = objeto_licitacao;
        this.data_declaracao_dispensa = data_declaracao_dispensa;
        this.data_publicacao = data_publicacao;
        this.data_ratificacao = data_ratificacao;
    }

    public Compra(int id, int id_modalidade_licitacao, int id_orgao, int id_uasg, int numero_inciso, String numero_processo, double valor_estimado, String fundamento_legal, String justificativa, String objeto_licitacao, String data_declaracao_dispensa, String data_publicacao, String data_ratificacao) {
        this.id = id;
        this.id_modalidade_licitacao = id_modalidade_licitacao;
        this.id_orgao = id_orgao;
        this.id_uasg = id_uasg;
        this.numero_inciso = numero_inciso;
        this.numero_processo = numero_processo;
        this.valor_estimado = valor_estimado;
        this.fundamento_legal = fundamento_legal;
        this.justificativa = justificativa;
        this.objeto_licitacao = objeto_licitacao;
        this.data_declaracao_dispensa = data_declaracao_dispensa;
        this.data_publicacao = data_publicacao;
        this.data_ratificacao = data_ratificacao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_modalidade_licitacao() {
        return id_modalidade_licitacao;
    }

    public void setId_modalidade_licitacao(int id_modalidade_licitacao) {
        this.id_modalidade_licitacao = id_modalidade_licitacao;
    }

    public int getId_orgao() {
        return id_orgao;
    }

    public void setId_orgao(int id_orgao) {
        this.id_orgao = id_orgao;
    }

    public int getId_uasg() {
        return id_uasg;
    }

    public void setId_uasg(int id_uasg) {
        this.id_uasg = id_uasg;
    }

    public int getId_responsavel_reconhecimento() {
        return id_responsavel_reconhecimento;
    }

    public void setId_responsavel_reconhecimento(int id_responsavel_reconhecimento) {
        this.id_responsavel_reconhecimento = id_responsavel_reconhecimento;
    }

    public int getId_responsavel_ratificacao() {
        return id_responsavel_ratificacao;
    }

    public void setId_responsavel_ratificacao(int id_responsavel_ratificacao) {
        this.id_responsavel_ratificacao = id_responsavel_ratificacao;
    }

    public int getNumero_inciso() {
        return numero_inciso;
    }

    public void setNumero_inciso(int numero_inciso) {
        this.numero_inciso = numero_inciso;
    }

    public String getNumero_processo() {
        return numero_processo;
    }

    public void setNumero_processo(String numero_processo) {
        this.numero_processo = numero_processo;
    }

    public double getValor_estimado() {
        return valor_estimado;
    }

    public void setValor_estimado(double valor_estimado) {
        this.valor_estimado = valor_estimado;
    }

    public String getFundamento_legal() {
        return fundamento_legal;
    }

    public void setFundamento_legal(String fundamento_legal) {
        this.fundamento_legal = fundamento_legal;
    }

    public String getJustificativa() {
        return justificativa;
    }

    public void setJustificativa(String justificativa) {
        this.justificativa = justificativa;
    }

    public String getObjeto_licitacao() {
        return objeto_licitacao;
    }

    public void setObjeto_licitacao(String objeto_licitacao) {
        this.objeto_licitacao = objeto_licitacao;
    }

    public String getData_declaracao_dispensa() {
        return data_declaracao_dispensa;
    }

    public void setData_declaracao_dispensa(String data_declaracao_dispensa) {
        this.data_declaracao_dispensa = data_declaracao_dispensa;
    }

    public String getData_publicacao() {
        return data_publicacao;
    }

    public void setData_publicacao(String data_publicacao) {
        this.data_publicacao = data_publicacao;
    }

    public String getData_ratificacao() {
        return data_ratificacao;
    }

    public void setData_ratificacao(String data_ratificacao) {
        this.data_ratificacao = data_ratificacao;
    }

    @Override
    public String toString() {
        return "Compra{" +
                "id=" + id +
                ", id_modalidade_licitacao=" + id_modalidade_licitacao +
                ", id_orgao=" + id_orgao +
                ", id_uasg=" + id_uasg +
                ", id_responsavel_reconhecimento=" + id_responsavel_reconhecimento +
                ", id_responsavel_ratificacao=" + id_responsavel_ratificacao +
                ", numero_inciso=" + numero_inciso +
                ", numero_processo='" + numero_processo + '\'' +
                ", valor_estimado=" + valor_estimado +
                ", fundamento_legal='" + fundamento_legal + '\'' +
                ", justificativa='" + justificativa + '\'' +
                ", objeto_licitacao='" + objeto_licitacao + '\'' +
                ", data_declaracao_dispensa='" + data_declaracao_dispensa + '\'' +
                ", data_publicacao='" + data_publicacao + '\'' +
                ", data_ratificacao='" + data_ratificacao + '\'' +
                '}';
    }
}