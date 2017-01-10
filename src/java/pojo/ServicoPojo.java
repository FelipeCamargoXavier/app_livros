/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

/**
 *
 * @author Felipe
 */
public class ServicoPojo 
{
    private String IDServico;
    private String IDUsuario;
    private String IDMonitoria;
    private String DSServico;
    private String preco;
    private String NMMonitoria;

    public String getIDServico() {
        return IDServico;
    }

    public void setIDServico(String IDServico) {
        this.IDServico = IDServico;
    }

    public String getIDUsuario() {
        return IDUsuario;
    }

    public void setIDUsuario(String IDUsuario) {
        this.IDUsuario = IDUsuario;
    }

    public String getIDMonitoria() {
        return IDMonitoria;
    }

    public void setIDMonitoria(String IDMonitoria) {
        this.IDMonitoria = IDMonitoria;
    }


    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    public String getDSServico() {
        return DSServico;
    }

    public void setDSServico(String DSServico) {
        this.DSServico = DSServico;
    }

    public String getNMMonitoria() {
        return NMMonitoria;
    }

    public void setNMMonitoria(String NMMonitoria) {
        this.NMMonitoria = NMMonitoria;
    }
    
}
