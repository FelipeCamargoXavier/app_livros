/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Felipe
 */
public class Conexao 
{
    private String host = "Felipe-PC";
    private String banco = "producao";
    private String user = "root";
    private String senha = "zapping1304";
    
    public Connection getConnection() 
    {
        try 
        {
            return DriverManager.getConnection("jdbc:mysql://"+host+"/"+banco+"", user, senha);
        } 
        catch (SQLException e) 
        {
            throw new RuntimeException(e);
        }
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
}
