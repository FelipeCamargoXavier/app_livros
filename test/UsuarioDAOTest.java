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
import dao.UsuarioDAO;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import pojo.UsuarioPojo;

public class UsuarioDAOTest 
{
    public String IDServico = "2";
    public String IDUsuario = "1";
    
    @Test
    public void insereResgistro() throws Exception 
    {
        UsuarioPojo usuarioPojo = new UsuarioPojo();

        usuarioPojo.setNMUsuario("skldngksdn");
        usuarioPojo.setEmail("skldngksdn@meusaaco.com");
        usuarioPojo.setTelefone("4591555408");
        usuarioPojo.setFoto("pathfoto");
        usuarioPojo.setReputacao("5");
        usuarioPojo.setIDFaculdade("1");
        usuarioPojo.setLocalizacao("coordenadas");
        usuarioPojo.setIDCurso("1");
        
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        
        assertEquals(true, usuarioDAO.InsereRegistro(usuarioPojo));
    }
    
    @Test
    public void alteraResgistro() throws Exception 
    {
        UsuarioPojo usuarioPojo = new UsuarioPojo();

        usuarioPojo.setNMUsuario("teste 2");
        usuarioPojo.setEmail("teste2@meusaaco.com");
        usuarioPojo.setTelefone("4591555408");
        usuarioPojo.setFoto("pathfoto");
        usuarioPojo.setReputacao("5");
        usuarioPojo.setIDFaculdade("1");
        usuarioPojo.setLocalizacao("coordenadas");
        usuarioPojo.setIDCurso("1");
        usuarioPojo.setIDUsuario("1");
        
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        
        assertEquals(true, usuarioDAO.AlteraRegistro(usuarioPojo));
    }
}

