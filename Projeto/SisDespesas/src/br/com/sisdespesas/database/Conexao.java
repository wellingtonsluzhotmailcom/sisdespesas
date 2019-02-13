/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sisdespesas.database;

import br.com.sisdespesas.classes.Alert;
import br.com.sisdespesas.entities.ConnectionData;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.h2.tools.Server;

/**
 *
 * @author AutoPecasLuz
 */
public class Conexao {

    public static Server server;

    public static void startServer() throws SQLException {
        ConnectionData data = ConnectionData.read();
        if (data != null) {
            if (data.getModoConexao() == 1) {
                // start the TCP Server
                Conexao.server = Server.createTcpServer(
                        "-tcpPort", data.getPortaTcp(),
                        "-tcpAllowOthers",
                        "-tcpDaemon"
                ).start();
            }
        }
    }

    // Classe de conexão há sofre alteração
    public static Connection get() {
        ConnectionData data = ConnectionData.read();
        try {
            Class.forName("org.h2.Driver");
            if (data.getModoConexao() == 2) {
                return DriverManager.getConnection("jdbc:h2:" + data.getLocal(), data.getUsuario(), data.getSenha());
            } else {
                return DriverManager.getConnection("jdbc:h2:tcp://" + data.getIp() + ":" + data.getPortaTcp() + "/" + data.getLocal(), data.getUsuario(), data.getSenha());
            }
        } catch (Exception ex) {
            Alert.error(ex.getMessage() + " =(", "Error Connection");
            return null;
        }
    }

    //url modo server jdbc:h2:tcp://127.0.0.1:9092/./lib/db
}
