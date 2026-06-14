package model;

public class Servico {

    private int id;
    private String tipoServico;
    private boolean cera;
    private boolean higienizacaoAr;
    private boolean hidratacaoCouro;
    private double valorTotal;
    private int idVeiculo;

    public Servico() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipoServico() {
        return tipoServico;
    }

    public void setTipoServico(String tipoServico) {
        this.tipoServico = tipoServico;
    }

    public boolean isCera() {
        return cera;
    }

    public void setCera(boolean cera) {
        this.cera = cera;
    }

    public boolean isHigienizacaoAr() {
        return higienizacaoAr;
    }

    public void setHigienizacaoAr(boolean higienizacaoAr) {
        this.higienizacaoAr = higienizacaoAr;
    }

    public boolean isHidratacaoCouro() {
        return hidratacaoCouro;
    }

    public void setHidratacaoCouro(boolean hidratacaoCouro) {
        this.hidratacaoCouro = hidratacaoCouro;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public int getIdVeiculo() {
        return idVeiculo;
    }

    public void setIdVeiculo(int idVeiculo) {
        this.idVeiculo = idVeiculo;
    }
}