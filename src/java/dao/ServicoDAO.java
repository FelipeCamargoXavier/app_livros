/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import pojo.ServicoPojo;
import conexao.Conexao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Felipe
 */
public class ServicoDAO {
    
    private Connection connection = null;
    
    public boolean InsereRegistro(ServicoPojo servicoPojo) throws Exception
    {
        boolean retorno = false;
        
        try 
        {
            String sql = "INSERT INTO tb_servico( "
                + " id_usuario, "
                + " id_monitoria, "
                + " ds_servico, "
                + " preco "
                + " ) "
                + " VALUES(?,?,?,?) ";
            
            connection = new Conexao().getConnection();
             
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            stmt.setString(1, servicoPojo.getIDUsuario());
            stmt.setString(2, servicoPojo.getIDMonitoria());
            stmt.setString(3, servicoPojo.getDSServico());
            stmt.setString(4, servicoPojo.getPreco());
            
            stmt.execute();
            stmt.close();
            
            retorno = true;
        } 
        catch(Exception e)
        {
            //System.out.println("erro servicoDAO: " + e.getMessage());
        }
        finally
        {
            if(connection != null)
                connection.close();
            
            return retorno;
        }
    }
    
    public boolean AlteraRegistro(ServicoPojo servicoPojo) throws Exception
    {
        boolean retorno = false;
        
        try 
        {
            if(servicoPojo.getIDServico() != null && !servicoPojo.getIDServico().equals(""))
            {
                String sql = "UPDATE tb_servico SET "
                    + " id_monitoria = ? , "
                    + " ds_servico = ? , "
                    + " preco = ? "
                    + " WHERE id_servico = "+servicoPojo.getIDServico()+" LIMIT 1 ";

                connection = new Conexao().getConnection();

                PreparedStatement stmt = connection.prepareStatement(sql);

                stmt.setString(1, servicoPojo.getIDMonitoria());
                stmt.setString(2, servicoPojo.getDSServico());
                stmt.setString(3, servicoPojo.getPreco());

                stmt.execute();
                stmt.close();

                //connection.commit();
                retorno = true; 
            }
        } 
        catch(Exception e)
        {
            //System.out.println("erro servicoDAO: " + e.getMessage());
        }
        finally
        {
            if(connection != null)
                connection.close();
            
            return retorno;
        }
    }
    
    public boolean DeletaRegistro(ServicoPojo servicoPojo) throws SQLException
    {
        boolean retorno = false;
        
        try 
        {
            String sql = " DELETE FROM tb_servico WHERE id_servico = "+servicoPojo.getIDServico()+" LIMIT 1 ";
            
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
    
    public List<ServicoPojo> BuscaServicos(ServicoPojo servicoPojo) throws SQLException
    {
        List<ServicoPojo> servicoPojos = new ArrayList<ServicoPojo>();
        
        try 
        {
            String sql = " SELECT "
                    + " a.id_servico, "
                    + " a.id_usuario, "
                    + " a.id_monitoria, "
                    + " IFNULL(a.ds_servico, '') AS ds_servico, "
                    + " IFNULL(a.preco, '0.00') AS preco, "
                    + " IFNULL(b.nm_monitoria, '') AS nm_monitoria "
                    + " FROM tb_servico a"
                    + " INNER JOIN tb_monitoria b ON a.id_monitoria = b.id_monitoria ";
        
            String condicao = "";
            
            if(servicoPojo.getIDUsuario() != null && !servicoPojo.getIDUsuario().equals(""))
                condicao += " a.id_usuario = "+servicoPojo.getIDUsuario()+" ";
            
            if(servicoPojo.getIDMonitoria() != null && !servicoPojo.getIDMonitoria().equals(""))
                condicao += " a.id_monitoria = "+servicoPojo.getIDMonitoria()+" ";
            
            if(servicoPojo.getPreco() != null && !servicoPojo.getPreco().equals(""))
                condicao += " a.preco <= "+servicoPojo.getPreco()+" ";
            
            if(!condicao.equals(""))
                sql += " WHERE " + condicao + " LIMIT 100 ";
            
            connection = new Conexao().getConnection();
             
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            ResultSet rs = stmt.executeQuery();
            
            if(rs != null)
            {
                while(rs.next())
                {
                    ServicoPojo servico = new ServicoPojo();
                    servico.setIDServico(rs.getString("id_servico"));
                    servico.setIDUsuario(rs.getString("id_usuario"));
                    servico.setIDMonitoria(rs.getString("id_monitoria"));
                    servico.setDSServico(rs.getString("ds_servico"));
                    servico.setPreco(rs.getString("preco"));
                    servico.setNMMonitoria(rs.getString("nm_monitoria"));
                    
                    servicoPojos.add(servico);
                }
                
                rs.close();
            }
            
            stmt.close();
                
        }
        finally
        {
            if(connection != null)
                connection.close();
            
            return servicoPojos;
        }
    }
    
}
