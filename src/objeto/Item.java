package objeto;

import java.time.LocalDateTime;

public class Item {
    private String nome;
    private String caminho;
    private String tipo;
    private long tamanho;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataModificacao;

    public Item(String nome, String caminho, String tipo, long tamanho, LocalDateTime dataCriacao, LocalDateTime dataModificacao) {
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

    public long getTamanho() {
        return tamanho;
    }

    public void setTamanho(long tamanho) {
        this.tamanho = tamanho;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public LocalDateTime getDataModificacao() {
        return dataModificacao;
    }

    public void setDataModificacao(LocalDateTime dataModificacao) {
        this.dataModificacao = dataModificacao;
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
