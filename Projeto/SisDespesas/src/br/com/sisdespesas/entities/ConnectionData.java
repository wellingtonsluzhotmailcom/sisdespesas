/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sisdespesas.entities;

import br.com.sisdespesas.classes.Alert;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 *
 * @author AutoPecasLuz
 */
public class ConnectionData implements Serializable{
    private String ip = "";
    private String portaTcp = "";
    private String senha = "";
    private String Usuario = "";
    private String local = "";
    private int modoConexao = 0;
    
    
    
    public static boolean write(ConnectionData dados) {
        try {
            File file = new File("lib");
            if (!file.exists()) {
                file.mkdir();
            }
            FileOutputStream saida = new FileOutputStream("lib/ConnectionData.jar");
            ObjectOutputStream gravar = new ObjectOutputStream(saida);
            gravar.writeObject(dados);
            gravar.close();
            saida.close();
            return true;
        } catch (Exception ex) {
            Alert.error(ex.getMessage(), "Error to Write File");
            return false;
        }
    }
    
    public static ConnectionData read() {
        try {
            if (!new File("lib/ConnectionData.jar").exists()) {
                return null;
            }
            FileInputStream entrada = new FileInputStream("lib/ConnectionData.jar");
            ObjectInputStream leitor = new ObjectInputStream(entrada);
            ConnectionData dados = (ConnectionData) leitor.readObject();
            leitor.close();
            entrada.close();
            return dados;
        } catch (Exception ex) {
            Alert.error(ex.getMessage(), "Error to Read File");
            return null;
        }
    }

    /**
     * @return the ip
     */
    public String getIp() {
        return ip;
    }

    /**
     * @param ip the ip to set
     */
    public void setIp(String ip) {
        this.ip = ip;
    }

    /**
     * @return the portaTcp
     */
    public String getPortaTcp() {
        return portaTcp;
    }

    /**
     * @param portaTcp the portaTcp to set
     */
    public void setPortaTcp(String portaTcp) {
        this.portaTcp = portaTcp;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     * @return the Usuario
     */
    public String getUsuario() {
        return Usuario;
    }

    /**
     * @param Usuario the Usuario to set
     */
    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }


    /**
     * @return the local
     */
    public String getLocal() {
        return local;
    }

    /**
     * @param local the local to set
     */
    public void setLocal(String local) {
        this.local = local;
    }

    /**
     * @return the modoConexao
     */
    public int getModoConexao() {
        return modoConexao;
    }

    /**
     * @param modoConexao the modoConexao to set
     */
    public void setModoConexao(int modoConexao) {
        this.modoConexao = modoConexao;
    }
    
    
    
}
