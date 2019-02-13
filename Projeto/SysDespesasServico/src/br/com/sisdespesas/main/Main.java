/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sisdespesas.main;

import br.com.sisdespesas.classes.Alert;
import br.com.sisdespesas.db.Conexao;

/**
 *
 * @author AutoPecasLuz
 */
public class Main {

    public static void main(String[] args) {
        try {
            Conexao.startServer();
            new Thread() {
                @Override
                public void run() {
                    while (true) {
                        try {

                            Thread.sleep(100000);
                        } catch (Exception ex) {
                            Alert.error(ex.getMessage() + " =(", "Error Start Server");
                        }
                    }
                }
            }.start();
        } catch (Exception ex) {
            Alert.error(ex.getMessage() + " =(", "Error Start Server");
        }
    }
}
