/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sisdespesas.controle;

import br.com.briefdb.BriefDb;
import br.com.sisdespesas.classes.Alert;
import br.com.sisdespesas.database.Conexao;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author AutoPecasLuz
 */
public class ControleCentroCusto {

    public static final String SQL = "select ID_CENTRO_CUSTO, DESCRICAO, ATIVO from DROGARIA.CENTRO_CUSTO _%_  ";

    public static boolean delete(Object id) {
        try {
            HashMap<Object, Object> mapa = BriefDb.crud(Conexao.get(), BriefDb.DELETE, "DROGARIA.CENTRO_CUSTO", "ID_CENTRO_CUSTO", Integer.parseInt(id.toString()), null);
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
            HashMap<Object, Object> mapa = BriefDb.crud(Conexao.get(), acao, "DROGARIA.CENTRO_CUSTO", "ID_CENTRO_CUSTO", pk, dados);

            boolean comite = (boolean) mapa.get("STATUS");
            return comite;
        } catch (Exception ex) {
            Alert.error(ex.getMessage() + " =(", "CRUD ERROR");
            return false;
        }
    }

    public static HashMap<Object, Object> get(Object id) {
        try {
            ArrayList<HashMap<Object, Object>> rst = BriefDb.query(Conexao.get(), "select * from DROGARIA.CENTRO_CUSTO where ID_CENTRO_CUSTO=?", id);
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
