/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import pojo.UsuarioPojo;
import conexao.Conexao;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Felipe
 */
public class UsuarioDAO {
    
    private Connection connection = null;
    
    public boolean InsereRegistro(UsuarioPojo usuarioPojo) throws Exception
    {
        boolean retorno = false;
        
        try 
        {
            String sql = "INSERT INTO tb_usuario( "
                + " nm_usuario, "
                + " email, "
                + " telefone, "
                + " foto, "
                + " reputacao, "
                + " id_faculdade, "
                + " localizacao, "
                + " id_curso, "
                + " dt_cad, "
                + " dt_alt"
                + " ) "
                + " VALUES(?,?,?,?,?,?,?,?, NOW(), NOW()) ";
            
            connection = new Conexao().getConnection();
             
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            stmt.setString(1, usuarioPojo.getNMUsuario());
            stmt.setString(2, usuarioPojo.getEmail());
            stmt.setString(3, usuarioPojo.getTelefone());
            stmt.setString(4, usuarioPojo.getFoto());
            stmt.setString(5, usuarioPojo.getReputacao());
            stmt.setString(6, usuarioPojo.getIDFaculdade());
            stmt.setString(7, usuarioPojo.getLocalizacao());
            stmt.setString(8, usuarioPojo.getIDCurso());
            //stmt.setString(9, usuarioPojo.getDTCad());
            //stmt.setString(10, usuarioPojo.getDTAlt());
            
            stmt.execute();
            stmt.close();
            
            retorno = true;
        } 
        catch(Exception e)
        {
            System.out.println("erro usuarioDAO: " + e.getMessage());
        }
        finally
        {
            if(connection != null)
                connection.close();
            
            return retorno;
        }
    }
    
    public boolean AlteraRegistro(UsuarioPojo usuarioPojo) throws Exception
    {
        boolean retorno = false;
        
        try 
        {
            String sql = "UPDATE tb_usuario SET "
                + " nm_usuario = ? , "
                + " email = ? , "
                + " telefone = ? , "
                + " foto = ? , "
                + " reputacao = ? , "
                + " id_faculdade = ? , "
                + " localizacao = ? , "
                + " id_curso = ? , "
                + " dt_alt = NOW() "
                + " WHERE id_usuario = "+usuarioPojo.getIDUsuario()+" LIMIT 1 ";
            
            connection = new Conexao().getConnection();
             
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            stmt.setString(1, usuarioPojo.getNMUsuario());
            stmt.setString(2, usuarioPojo.getEmail());
            stmt.setString(3, usuarioPojo.getTelefone());
            stmt.setString(4, usuarioPojo.getFoto());
            stmt.setString(5, usuarioPojo.getReputacao());
            stmt.setString(6, usuarioPojo.getIDFaculdade());
            stmt.setString(7, usuarioPojo.getLocalizacao());
            stmt.setString(8, usuarioPojo.getIDCurso());
            
            stmt.execute();
            stmt.close();
            
            retorno = true; 
        }
        catch(Exception e)
        {
            System.out.println("erro usuarioDAO: " + e.getMessage());
        }
        finally
        {
            if(connection != null)
                connection.close();
            
            return retorno;
        }
    }
    
    public boolean DeletaRegistro(UsuarioPojo usuarioPojo) throws SQLException
    {
        boolean retorno = false;
        
        try 
        {
            String sql = " DELETE FROM tb_usuario WHERE id_usuario = "+usuarioPojo.getIDUsuario()+" LIMIT 1 ";
            
            connection = new Conexao().getConnection();
            Statement stmt = connection.createStatement();
            stmt.execute(sql);
            stmt.close();
            
            retorno = true;
        }
        finally
        {
            if(connection != null)
                connection.close();
            
            return retorno;
        }
    }
}
