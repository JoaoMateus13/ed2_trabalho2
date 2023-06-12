package objeto;

import org.testng.mustache.Value;

import java.util.Date;

public class Item {
    private String nome;
    private String caminho;
    private String tipo;
    private double tamanho;
    private Date dataCriacao;
    private Date dataModificacao;

    public Item(String nome, String caminho, String tipo, double tamanho, Date dataCriacao, Date dataModificacao) {
        this.nome = nome;
        this.caminho = caminho;
        this.tipo = tipo;
        this.tamanho = tamanho;
        this.dataCriacao = dataCriacao;
        this.dataModificacao = dataModificacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCaminho() {
        return caminho;
    }

    public void setCaminho(String caminho) {
        this.caminho = caminho;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getTamanho() {
        return tamanho;
    }

    public void setTamanho(double tamanho) {
        this.tamanho = tamanho;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Date getDataModificacao() {
        return dataModificacao;
    }

    public void setDataModificacao(Date dataModificacao) {
        this.dataModificacao = dataModificacao;
    }

    public Comparable retornarChave(objOrdem ordenarPor) {

        if (ordenarPor == objOrdem.PORNOME) {
            return getNome();
        } else if (ordenarPor == objOrdem.PORTIPO) {
            return getTipo();
        } else if(ordenarPor == objOrdem.PORDATADECRIACAO) {
            return getDataCriacao();
        }
        else if(ordenarPor == objOrdem.PORTAMANHO) {
            return getTamanho();
        }else return getDataModificacao();
    }

    @Override
    public String toString() {
        return "Item{" +
                "nome='" + nome + '\'' +
                ", caminho='" + caminho + '\'' +
                ", tipo='" + tipo + '\'' +
                ", tamanho=" + tamanho +
                ", dataCriacao=" + dataCriacao +
                ", dataModificacao=" + dataModificacao +
                '}';
    }
}
