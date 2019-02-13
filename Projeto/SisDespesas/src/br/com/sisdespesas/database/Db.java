/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sisdespesas.database;

import br.com.filemanager.FileManager;
import br.com.sisdespesas.classes.Alert;
import java.io.File;
import java.io.InputStream;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author AutoPecasLuz
 */
public class Db {

    // importar db - testar
    public static boolean importarDb() {
        try {
            if (Alert.confirm("Importar base de dados e sobrescrever arquivo existente?")) {
                JFileChooser navegador = new JFileChooser();
                FileNameExtensionFilter filter = new FileNameExtensionFilter("H2 db file", "db");
                navegador.setFileFilter(filter);
                if (JFileChooser.APPROVE_OPTION == navegador.showSaveDialog(null) && navegador.getSelectedFile() != null) {
                    String arquivo = navegador.getSelectedFile().toString();
                    if (!arquivo.toLowerCase().endsWith(".db")) {
                        throw new Exception(arquivo + " não é suportado.");
                    }
                    File arquivoOrigem = new File(arquivo);
                    File arquivoDestino = new File("lib/db.mv.db");
                    FileManager.copyFile(arquivoOrigem, arquivoDestino);
                    Alert.info("Importação realizada com sucesso! =)", "SUCCESS");
                    return true;
                }
            }
        } catch (Exception ex) {
            Alert.error(ex.getMessage() + " =(", "IMPORT ERROR");
        }
        return false;
    }

    // exportar db - testar
    public static boolean exportarDb() {
        try {
            JFileChooser navegador = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("H2 db file", ".db");
            navegador.setFileFilter(filter);
            if (JFileChooser.APPROVE_OPTION == navegador.showSaveDialog(null) && navegador.getSelectedFile() != null) {
                File arquivoOrigem = new File("lib/db.mv.db");
                File arquivoDestino = new File(navegador.getSelectedFile() + ".db.mv.db");
                FileManager.copyFile(arquivoOrigem, arquivoDestino);
                Alert.info("Exportação realizada com sucesso! =)", "SUCCESS");
                return true;
            }
        } catch (Exception ex) {
            Alert.error(ex.getMessage() + " =(", "EXPORT ERROR");
        }
        return false;
    }

    // cria o banco de dados na maquina local
    public static void registrarDb() throws Exception {
        File file = new File("lib");
        if (!file.exists()) {
            file.mkdir();
        }
        file = new File("lib/db.mv.db");
        if (!file.exists()) {
            InputStream db = Db.class.getResourceAsStream("/br/com/sisdespesas/files/db.mv.db");
            FileManager.exportInternalFile(db, file);
        }
    }

}
