/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sisdespesas.main;

import br.com.sisdespesas.classes.Alert;
import br.com.sisdespesas.database.Conexao;
import br.com.sisdespesas.database.Db;
import br.com.sisdespesas.view.window.Janela;
import java.util.Properties;
import javax.swing.UIManager;

/**
 *
 * @author AutoPecasLuz
 */
public class Main {

    public static void main(String[] args) {
        try {
            // setup the look and feel properties
            Properties props = new Properties();
            props.put("logoString", "");
            props.put("buttonColor", "255 255 255");
            props.put("buttonColorLight", "255 255 255");
            props.put("buttonColorDark", "255 255 255");
            props.put("windowTitleForegroundColor", "49 43 103");
            props.put("windowTitleBackgroundColor", "255 255 255");
            props.put("windowTitleColorLight", "255 255 255");
            props.put("windowTitleColorDark", "255 255 255");

            props.put("windowInactiveTitleColorLight", "255 255 255");
            props.put("windowInactiveTitleColorDark", "255 255 255");
            props.put("windowInactiveBorderColor", "255 255 255");

            props.put("toolbarBackgroundColor", "255 255 255");

            props.put("menuBackgroundColor", "255 255 255");
            props.put("menuForegroundColor", "49 43 103");

            props.put("windowIconColor", "49 43 103");
            props.put("windowIconRolloverColor", "255 0 0");
            props.put("windowInactiveTitleForegroundColor", "49 43 103");
            props.put("windowBorderColor", "255 255 255");

            props.put("windowIconShadowColor", "255 255 255");
            props.put("windowInactiveTitleColorLight", "255 255 255");
            props.put("windowInactiveBorderColor", "255 255 255");
            props.put("windowInactiveTitleColorDark", "255 255 255");
            // windowTitleBackgroundColor
            props.put("backgroundColor", "255 255 255");
            props.put("backgroundColorDark", "255 255 255");
            props.put("backgroundColorLight", "255 255 255");
            props.put("foregroundColor", "49 43 103");
            props.put("backgroundColorLight", "255 255 255");

            props.put("tooltipBackgroundColor", "255 255 255");
            props.put("tooltipForegroundColor", "49 43 103");

            props.put("controlTextFont", "Arial Simples 14");
            props.put("systemTextFont", "Arial Simples 14");
            props.put("userTextFont", "Arial Simples 14");
            props.put("menuTextFont", "Arial Simples 14");
            props.put("windowTitleFont", "Arial Simples 14");
            props.put("subTextFont", "Arial Simples 14");

            props.put("alterBackgroundColor", "255 255 255");
            props.put("buttonBackgroundColor", "255 255 255");
            props.put("selectionForegroundColor", "0 0 249");
            props.put("selectionBackgroundColor", "192 220 249");

            props.put("focusColor", "255 0 0");
            props.put("focusCellColor", "255 0 0");

            com.jtattoo.plaf.fast.FastLookAndFeel.setCurrentTheme(props);
            //com.jtattoo.plaf.fast.FastLookAndFeel.setTheme("Default", "", "");
            UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
        } catch (Exception ex) {
            Alert.error(ex.getMessage(), "Theme Error");
        }
        try {
            Db.registrarDb();
        } catch (Exception ex) {
            Alert.error(ex.getMessage() + " =(", "Register Database Error");
        }

        try {
            Conexao.startServer();
        } catch (Exception ex) {
            Alert.error(ex.getMessage() + " =(", "Error Start Server");
        }

        try {
            //new Referencia().setVisible(true);
            new Janela().setVisible(true);
        } catch (Exception ex) {
            Alert.error(ex.getMessage() + " =(", "Window Error");
        }
    }

}
