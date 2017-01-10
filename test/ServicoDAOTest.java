/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Felipe
 */

import dao.ServicoDAO;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import pojo.ServicoPojo;

public class ServicoDAOTest 
{
    public String IDServico = "2";
    public String IDUsuario = "1";
    
    @Test
    public void insereResgistro() throws Exception 
    {
        ServicoPojo servicoPojo = new ServicoPojo();

        servicoPojo.setIDUsuario(IDUsuario);
        servicoPojo.setIDMonitoria("1");
        servicoPojo.setDSServico("teste");
        servicoPojo.setPreco("10");
        
        ServicoDAO servicoDAO = new ServicoDAO();
        
        assertEquals(true, servicoDAO.InsereRegistro(servicoPojo));
    }
    
    @Test
    public void alteraResgistro() throws Exception 
    {
        ServicoPojo servicoPojo = new ServicoPojo();

        servicoPojo.setIDMonitoria("1");
        servicoPojo.setDSServico("teste 2 update");
        servicoPojo.setPreco("20");
        servicoPojo.setIDServico(IDServico);
        
        ServicoDAO servicoDAO = new ServicoDAO();
        
        assertEquals(true, servicoDAO.AlteraRegistro(servicoPojo));
    }
}

