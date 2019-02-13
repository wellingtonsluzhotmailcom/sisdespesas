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
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JComboBox;

/**
 *
 * @author AutoPecasLuz
 */
public class ControleDespesas {

    public static final String SQL = "select ID_DESPESA, CENTRO_CUSTO,  DESPESA_DESCRICAO, VALOR_BR, PAGOEM, ATUALIZADOEM from DROGARIA.LISTA_DESPESA _%_  ";

    public static void centroCusto(JComboBox bx) {
        try {
            bx.removeAllItems();
            ArrayList<HashMap<Object, Object>> rst = BriefDb.query(Conexao.get(), "select * from DROGARIA.CENTRO_CUSTO where ATIVO=?", 1);
            for (HashMap<Object, Object>  data : rst) {
                bx.addItem(Format.get(data, "ID_CENTRO_CUSTO")+" - "+Format.get(data, "DESCRICAO"));
            }
        } catch (Exception ex) {
            Alert.error(ex.getMessage() + " =(", "QUERY ERROR");
        }
    }

    public static boolean delete(Object id) {
        try {
            HashMap<Object, Object> mapa = BriefDb.crud(Conexao.get(), BriefDb.DELETE, "DROGARIA.DESPESA", "ID_DESPESA", Integer.parseInt(id.toString()), null);
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
            HashMap<Object, Object> mapa = BriefDb.crud(Conexao.get(), acao, "DROGARIA.DESPESA", "ID_DESPESA", pk, dados);

            boolean comite = (boolean) mapa.get("STATUS");
            return comite;
        } catch (Exception ex) {
            Alert.error(ex.getMessage() + " =(", "CRUD ERROR");
            return false;
        }
    }

    public static HashMap<Object, Object> get(Object id) {
        try {
            ArrayList<HashMap<Object, Object>> rst = BriefDb.query(Conexao.get(), "SELECT * FROM DROGARIA.LISTA_DESPESA where ID_DESPESA=?", id);
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
