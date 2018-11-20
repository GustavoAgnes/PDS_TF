public class Vendas {
    String idVenda;
    String dataVenda;
    String nome;
    String CRM;
    String dataReceita;

    public String getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(String idVenda) {
        this.idVenda = idVenda;
    }

    public String getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(String dataVenda) {
        this.dataVenda = dataVenda;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCRM() {
        return CRM;
    }

    public void setCRM(String CRM) {
        this.CRM = CRM;
    }

    @Override
    public String toString() {
        return "O número de identificação da venda é: "+getIdVenda()+
                ", a venda foi efetuada dia: "+getDataVenda()+
                ", o nome do atendende responsável pela venda é: "+getNome()+
                ", o CRM do médico responsável é: "+getCRM()+
                ", a receita é do dia: "+getDataReceita()+"\n";
    }

    public String imprimirVenda() {
        return "O número de identificação da venda é: "+getIdVenda()+
                ", a venda foi efetuada dia: "+getDataVenda()+
                ", o nome do atendende responsável pela venda é: "+getNome()+
                ", o CRM do médico responsável é: "+getCRM()+
                ", a receita é do dia: "+getDataReceita();
    }

    public String getDataReceita() {
        return dataReceita;
    }

    public void setDataReceita(String dataReceita) {
        this.dataReceita = dataReceita;
    }

    public Vendas(String idVenda, String dataVenda, String nome, String CRM, String dataReceita){
        this.idVenda = idVenda;
        this.dataVenda = dataVenda;
        this.nome = nome;
        this.CRM = CRM;
        this.dataReceita = dataReceita;
    }

}
