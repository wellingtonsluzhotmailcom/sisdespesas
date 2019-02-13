/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sisdespesas.controle;

import br.com.briefdb.BriefDb;
import br.com.sisdespesas.classes.Alert;
import br.com.sisdespesas.classes.Format;
import br.com.sisdespesas.database.Conexao;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author AutoPecasLuz
 */
public class ControleUsuario {

    public static boolean login(String login, String senha) {
        try {
            Connection conn = Conexao.get();
            String password = Format.md5(senha);
            ArrayList<HashMap<Object, Object>> rst = BriefDb.query(conn, "select count(*) as VALIDO from drogaria.usuario where ativo=1 and (upper(login)=upper(?) or upper(email)=upper(?)) and upper(senha)=upper(?)", login, login, password);
            if (rst != null) {
                HashMap<Object, Object> data = rst.get(0);
                return data.get("VALIDO").toString().equals("1");
            }
        } catch (Exception ex) {
            Alert.error(ex.getMessage() + " =(", "User Control Error");
            return false;
        }
        return false;
    }

    public static final String SQL = "select ID_USUARIO, NOME, ATIVO from DROGARIA.USUARIO _%_  ";

    public static boolean delete(Object id) {
        try {
            HashMap<Object, Object> mapa = BriefDb.crud(Conexao.get(), BriefDb.DELETE, "DROGARIA.USUARIO", "ID_USUARIO", Integer.parseInt(id.toString()), null);
            return (boolean) mapa.get("STATUS");
        } catch (Exception ex) {
            Alert.error(ex.getMessage() + " =(", "DELETE ERROR");
            return false;
        }
    }

    public static boolean crud(HashMap<Object, Object> dados, int acao, String id) {
        try {
            int pk = 0;
            if (acao == BriefDb.UPDATE) {
                pk = Integer.parseInt(id);
            }
            HashMap<Object, Object> mapa = BriefDb.crud(Conexao.get(), acao, "DROGARIA.USUARIO", "ID_USUARIO", pk, dados);

            boolean comite = (boolean) mapa.get("STATUS");
            return comite;
        } catch (Exception ex) {
            Alert.error(ex.getMessage() + " =(", "CRUD ERROR");
            return false;
        }
    }

    public static HashMap<Object, Object> get(Object id) {
        try {
            ArrayList<HashMap<Object, Object>> rst = BriefDb.query(Conexao.get(), "SELECT * FROM DROGARIA.USUARIO where ID_USUARIO=?", id);
            if (rst.isEmpty()) {
                return null;
            }
            return rst.get(0);
        } catch (Exception ex) {
            Alert.error(ex.getMessage() + " =(", "GET ERROR");
            return null;
        }
    }

}
