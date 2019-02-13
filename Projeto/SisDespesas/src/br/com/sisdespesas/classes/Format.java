/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sisdespesas.classes;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author AutoPecasLuz
 */
public abstract class Format {

    public static boolean in(int n1, int... n) {
        for (int v : n) {
            if (n1 == v) {
                return true;
            }
        }
        return false;
    }

    public static java.sql.Timestamp getCurrentTimestamp() {
        try {
            return new java.sql.Timestamp(new java.util.Date().getTime());
        } catch (Exception e) {
            return null;
        }
    }

    public static String percentual(Object valor) {
        try {
            Float numero = Float.parseFloat(valor.toString());
            DecimalFormat df = new DecimalFormat();
            df.applyPattern("###0.###");
            String aux = df.format(numero);
            if (aux.substring(0, 1).equals(",")) {
                aux = "0" + aux;
            }
            if (aux.contains(",")) {
                if (aux.split(",")[1].length() > 3) {
                    aux = aux.substring(0, aux.length() - 1);
                }
            }
            return aux;
        } catch (Exception ex) {
            return "0,000";
        }
    }

    public static String money(Object valor) {
        try {
            Float numero = Float.parseFloat(valor.toString());
            DecimalFormat df = new DecimalFormat();
            df.applyPattern("#,###.00");
            String aux = df.format(numero);
            if (aux.substring(0, 1).equals(",")) {
                aux = "0" + aux;
            }

            return aux;
        } catch (Exception ex) {
            return valor.toString();
        }
    }

    public static float numeric(JFormattedTextField t) {
        if (t.getText().equals("")) {
            return 0;
        } else {
            return Float.parseFloat(t.getText().trim().replaceAll("\\.", "").replaceAll(",", "."));
        }
    }

    public static float numeric(Object t) {
        if (t.toString().replaceAll("[^0-9]", "").equals("")) {
            return 0;
        } else {
            return Float.parseFloat(t.toString().trim().replaceAll("\\.", "").replaceAll(",", "."));
        }
    }

    public static float percentual(JFormattedTextField t) {
        if (t.getText().equals("")) {
            return 0;
        } else {
            return Float.parseFloat(t.getText().trim().replaceAll("[,]", "."));
        }
    }

    public static java.sql.Timestamp getCurrentDate() {
        return new java.sql.Timestamp(new java.util.Date().getTime());
    }

    public static String getCurrentDateBR() {
        SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
        return data.format(new Date());
    }

    public static String clear(JFormattedTextField t) {
        return t.getText().trim().replaceAll("[^0-9]", "");
    }

    public static String clear(JTextField t) {
        return t.getText().trim().replaceAll("[^0-9]", "");
    }

    public static String clear(String t) {
        return t.trim().replaceAll("[^0-9]", "");
    }

    public static Object getId(JComboBox j) {
        try {
            return Integer.parseInt(j.getSelectedItem().toString().split("-")[0].trim());
        } catch (Exception ex) {
            return null;
        }
    }

    public static int getIdInt(JComboBox j) {
        try {
            return Integer.parseInt(j.getSelectedItem().toString().split("-")[0].trim());
        } catch (Exception ex) {
            return 0;
        }
    }

    public static Object getId(Object obj) {
        try {
            return Integer.parseInt(obj.toString().split("-")[0].trim());
        } catch (Exception ex) {
            return null;
        }
    }

    public static Object getPreco(Object obj) {
        try {
            String token[] = obj.toString().split(" R\\$ ");
            return Format.numeric(token[token.length - 1].trim());
        } catch (Exception ex) {
            return null;
        }
    }

    public static String br(Object data) {
        try {
            if (data != null) {
                String vetor[] = data.toString().split("-");
                return vetor[2] + "/" + vetor[1] + "/" + vetor[0];
            }
        } catch (Exception ex) {
            // JOptionPane.showMessageDialog(null, "Impossivel formatar data\n"+ex.getMessage(), "Error de Formatação",JOptionPane.ERROR_MESSAGE);
        }
        return "";
    }

    public static java.util.Date toJavaDate(Object data) {
        try {
            if (data != null) {
                DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                Date date = (Date) formatter.parse(data.toString());
                return date;
            }
            return null;
        } catch (ParseException ex) {
            return null;
        }
    }

    public static java.util.Date toDate(Object data) {
        try {
            if (data != null) {
                DateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
                Date date = (Date) formatter.parse(data.toString());
                return date;
            }
            return null;
        } catch (ParseException ex) {
            return null;
        }
    }

    public static String dateBr(java.util.Date data) {
        try {
            SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            return df.format(data);
        } catch (Exception e) {
            return "";
        }
    }

    public static String dateBr(java.sql.Date date) {
        String data[] = date.toString().split("-");
        return data[2] + "/" + data[1] + "/" + data[0];
    }

    public static void main(String[] args) {
        ;

        System.out.println();
    }

    public static java.sql.Date formatoSQL(java.util.Date data) {
        try {
            SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            java.util.Date dataUtil = data;
            java.sql.Date dataSql = null;
            dataUtil = new java.sql.Date(dataUtil.getTime());
            dataSql = (java.sql.Date) dataUtil;
            return dataSql;
        } catch (Exception e) {
            return null;
        }
    }

    public static java.sql.Date toSqlDate(java.util.Date data) {
        try {
            return new java.sql.Date(data.getTime());
        } catch (Exception e) {
            return null;
        }
    }

    public static String currentDatetimeBr() {
        try {
            SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            java.util.Date dataUtil = new java.util.Date();
            return df.format(dataUtil);
        } catch (Exception e) {
            return null;
        }
    }

    public static boolean isDoc(String doc) {
        doc = doc.replaceAll("[^0-9]", "");
        if (doc.length() == 11) {
            return Format.isCPF(doc);
        } else {
            return Format.isCnpj(doc);
        }
    }

    public static boolean isCPF(String CPF) {
        boolean valido = false;
        CPF = CPF.replaceAll("[^0-9]", "");
        CPF = CPF.replace("00000000000", "").replace("11111111111", "").replace("22222222222", "").replace("33333333333", "")
                .replace("44444444444", "").replace("55555555555", "").replace("66666666666", "").replace("77777777777", "")
                .replace("88888888888", "");

        if (CPF.equals("")) {
            JOptionPane.showMessageDialog(null, "CPF inválido\nVerifique o número digitado!", "Atenção", JOptionPane.WARNING_MESSAGE);
            return false;

        }

        if (CPF.length() != 11) {
            JOptionPane.showMessageDialog(null, "CPF inválido\nVerifique o número digitado!", "Atenção", JOptionPane.WARNING_MESSAGE);
            valido = (false);
        }
        char dig10, dig11;
        int sm, i, r, num, peso;
        try {
            sm = 0;
            peso = 10;
            for (i = 0; i < 9; i++) {

                num = (int) (CPF.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }
            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11)) {
                dig10 = '0';
            } else {
                dig10 = (char) (r + 48);
            }

            sm = 0;
            peso = 11;
            for (i = 0; i < 10; i++) {
                num = (int) (CPF.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }
            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11)) {
                dig11 = '0';
            } else {
                dig11 = (char) (r + 48);
            }

            if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10))) {
                valido = (true);
            } else {
                valido = (false);
            }
        } catch (Exception erro) {
            valido = (false);
        } finally {
            if (!valido) {
                JOptionPane.showMessageDialog(null, "CPF inválido\nVerifique o número digitado!", "Atenção", JOptionPane.WARNING_MESSAGE);
            }
            return valido;
        }
    }

    public static boolean isCnpj(String CNPJ) {
// considera-se erro CNPJ's formados por uma sequencia de numeros iguais 
        if (CNPJ.equals("00000000000000") || CNPJ.equals("11111111111111")
                || CNPJ.equals("22222222222222") || CNPJ.equals("33333333333333")
                || CNPJ.equals("44444444444444") || CNPJ.equals("55555555555555")
                || CNPJ.equals("66666666666666") || CNPJ.equals("77777777777777")
                || CNPJ.equals("88888888888888") || CNPJ.equals("99999999999999")
                || (CNPJ.length() != 14)) {
            return (false);

        }
        char dig13, dig14;
        int sm, i, r, num, peso;
        // "try" - protege o código para eventuais erros de conversao de tipo (int) 
        try {
            // Calculo do 1o. Digito Verificador
            sm = 0;
            peso = 2;
            for (i = 11; i >= 0; i--) {
                // converte o i-ésimo caractere do CNPJ em um número: 
                // por exemplo, transforma o caractere '0' no inteiro 0 
                // (48 eh a posição de '0' na tabela ASCII) 
                num = (int) (CNPJ.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso + 1;
                if (peso == 10) {
                    peso = 2;
                }
            }
            r = sm % 11;
            if ((r == 0) || (r == 1)) {
                dig13 = '0';
            } else {
                dig13 = (char) ((11 - r) + 48);
            }
            // Calculo do 2o. Digito Verificador
            sm = 0;
            peso = 2;
            for (i = 12; i >= 0; i--) {
                num = (int) (CNPJ.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso + 1;
                if (peso == 10) {
                    peso = 2;
                }
            }
            r = sm % 11;
            if ((r == 0) || (r == 1)) {
                dig14 = '0';
            } else {
                dig14 = (char) ((11 - r) + 48);
            }
            // Verifica se os dígitos calculados conferem com os dígitos informados. 
            if ((dig13 == CNPJ.charAt(12)) && (dig14 == CNPJ.charAt(13))) {

                return (true);
            } else {

                return (false);
            }
        } catch (Exception erro) {

            return (false);
        }
    }

    public static String CEP(Object obj) {
        String numero = obj == null ? "" : obj.toString();
        try {
            return numero.substring(0, 5) + "-" + numero.substring(5, numero.length());
        } catch (Exception ex) {
            return numero;
        }
    }

    public static String CnpjCpf(Object obj) {
        String num = "";
        if (obj != null) {
            if (obj.toString().length() > 11) {
                num = Format.CNPJ(obj);
            } else {
                num = Format.CPF(obj);
            }
        }
        return num;
    }

    public static String CNPJ(Object obj) {
        String numero = obj == null ? "" : obj.toString();
        try {
            return numero.substring(0, 2) + "." + numero.substring(2, 5) + "."
                    + numero.substring(5, 8) + "/" + numero.substring(8, 12)
                    + "-" + numero.substring(12, 14);
        } catch (Exception ex) {
            return numero;
        }
    }

    public static String CPF(Object obj) {
        String numero = obj == null ? "" : obj.toString();
        try {
            return numero.substring(0, 3) + "." + numero.substring(3, 6) + "."
                    + numero.substring(6, 9) + "-" + numero.substring(9, 11);
        } catch (Exception ex) {
            return numero;
        }
    }

    public static String telefone(Object obj) {
        String numero = obj == null ? "" : obj.toString();
        try {
            return "(" + numero.substring(0, 2) + ") " + numero.substring(2, 6)
                    + "-" + numero.substring(6, numero.length());
        } catch (Exception ex) {
            return numero;
        }
    }

    public static void in(JComboBox cmb, Object item) {
        cmb.setSelectedItem(item);
        if (cmb.getSelectedItem() != null && cmb.getSelectedItem().toString().equals(item.toString())) {
            return;
        }
        cmb.addItem(item);
        cmb.setSelectedItem(item);
    }

    public static String md5(String senha) {
        String md5 = null;
        if (null == senha) {
            return null;
        }
        try {
            //Create MessageDigest object for MD5
            MessageDigest digest = MessageDigest.getInstance("MD5");
            //Update input string in message digest
            digest.update(senha.getBytes(), 0, senha.length());
            //Converts message digest value in base 16 (hex) 
            md5 = new BigInteger(1, digest.digest()).toString(16);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return md5;
    }

    public static void icon(JCheckBox... cks) {
        for (JCheckBox ck : cks) {
            ck.setCursor(new Cursor(Cursor.HAND_CURSOR));
            ck.setToolTipText("Clique para alterar");
            ck.setIcon(new javax.swing.ImageIcon(ck.getClass().getResource("/br/com/easydesk/img/" + (ck.isSelected() ? "1" : "0") + ".png")));
            ck.setText((ck.isSelected() ? "Ativo" : "Inativo"));
            ck.addChangeListener(new ChangeListener() {
                @Override
                public void stateChanged(ChangeEvent ce) {
                    ck.setIcon(new javax.swing.ImageIcon(ck.getClass().getResource("/br/com/easydesk/img/" + (ck.isSelected() ? "1" : "0") + ".png")));
                    ck.setText((ck.isSelected() ? "Ativo" : "Inativo"));
                }
            });
        }
    }

    public static void iconDefault(JCheckBox... cks) {
        for (JCheckBox ck : cks) {
            ck.setCursor(new Cursor(Cursor.HAND_CURSOR));
            ck.setToolTipText("Clique para alterar");
            ck.setIcon(new javax.swing.ImageIcon(ck.getClass().getResource("/br/com/easydesk/img/" + (ck.isSelected() ? "1" : "0") + ".png")));
            ck.setToolTipText((ck.isSelected() ? "Sim" : "Não"));
            ck.addChangeListener(new ChangeListener() {
                @Override
                public void stateChanged(ChangeEvent ce) {
                    ck.setIcon(new javax.swing.ImageIcon(ck.getClass().getResource("/br/com/easydesk/img/" + (ck.isSelected() ? "1" : "0") + ".png")));
                    ck.setText((ck.isSelected() ? "Sim" : "Não"));
                }
            });
        }
    }

    public static void iconDefault(JLabel... cks) {
        for (JLabel ck : cks) {
            ck.setIcon(new javax.swing.ImageIcon(ck.getClass().getResource("/br/com/easydesk/img/" + (ck.getText().equalsIgnoreCase("t") ? "1" : "0") + ".png")));
            ck.setText((ck.getText().equalsIgnoreCase("t") ? "Sim" : "Não"));
        }
    }

    public static void PJPf(JComboBox cm, JFormattedTextField pjpf) {
        cm.removeAllItems();
        cm.addItem("CPF");
        cm.addItem("CNPJ");
        try {
            pjpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (Exception ex) {
            Alert.error(ex.getMessage(), "Máscara PjPf");
        }
        cm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    pjpf.setValue(null);
                    if (cm.getSelectedItem().toString().equals("CNPJ")) {
                        pjpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###/####-##")));
                    } else {
                        pjpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
                    }
                } catch (Exception ex) {
                    Alert.error(ex.getMessage(), "Máscara PjPf");
                }
            }
        });
    }

    public static void setPJPf(JComboBox cm, JFormattedTextField pjpf, Object value) {
        if (value != null) {
            cm.setSelectedItem(value.toString().length() > 11 ? "CNPJ" : "CPF");
            pjpf.setText(value.toString());
        }
    }

    public static String mes(int indexMes) {
        String mes = "";
        switch (indexMes) {
            case 1:
                mes = "Janeiro";
                break;
            case 2:
                mes = "Fevereiro";
                break;
            case 3:
                mes = "Março";
                break;
            case 4:
                mes = "Abril";
                break;
            case 5:
                mes = "Maio";
                break;
            case 6:
                mes = "Junho";
                break;
            case 7:
                mes = "Julho";
                break;
            case 8:
                mes = "Agosto";
                break;
            case 9:
                mes = "Setembro";
                break;
            case 10:
                mes = "Outubro";
                break;
            case 11:
                mes = "Novembro";
                break;
            case 12:
                mes = "Dezembro";
                break;
        }
        return mes;
    }

    public static Object zerofill(Object strNumber, int totalCasas) {
        if (strNumber != null) {
            String zeroPut = "";
            for (int i = strNumber.toString().length(); i < totalCasas; i++) {
                zeroPut += "0";
            }
            return (strNumber.toString().length() < totalCasas ? zeroPut : "") + strNumber.toString();
        }
        return strNumber;
    }

    public static String getDateBr(HashMap<Object, Object> map, String key) {
        String data = Format.get(map, key);
        if (data.equals("")) {
            return data;
        }
        try {
            SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = f.parse(data);
            f = new SimpleDateFormat("dd/MM/yyyy HH:mm a");
            return (f.format(date));
        } catch (ParseException ex) {
            return "";
        }
    }

    public static java.util.Date getDateBrToUsa(HashMap<Object, Object> map, String key) {
        String data = Format.get(map, key);
        if (data.equals("")) {
            return null;
        }
        try {
            SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
            Date date = f.parse(data);
            return date;
        } catch (ParseException ex) {
            return null;
        }
    }

    public static String get(HashMap<Object, Object> map, String key) {
        try {
            key = key.toUpperCase();
            if (map.get(key.toLowerCase()) != null) {
                return map.get(key.toLowerCase()).toString();
            }
            if (map.get(key.toUpperCase()) != null) {
                return map.get(key.toUpperCase()).toString();
            }
            if (map.get(key) != null) {
                return map.get(key).toString();
            } else {
                return "";
            }
        } catch (Exception ex) {
            return "";
        }
    }

    public static String getMoney(HashMap<Object, Object> map, String key) {
        String valor = (Format.get(map, key));
        if (valor.equals("")) {
            return "0,00";
        }
        return Format.money(valor);
    }

    public static String getDecimal(HashMap<Object, Object> map, String key) {
        String valor = (Format.get(map, key));
        if (valor.equals("")) {
            return "0,00";
        }
        return Format.percentual(valor);
    }

    public static Color corBotaoComanda(Object solicitacoes, Object pedidos) {
        int s = Integer.parseInt(solicitacoes.toString()), p = Integer.parseInt(pedidos.toString());
        if (s > 0 && p > 0) {
            return new Color(255, 255, 0);
        } else if (p > 0) {
            return new Color(0, 255, 0);
        } else {
            return new Color(255, 0, 0);
        }
    }

    public static int getDay() {
        /* Padrão javascript       
        semana[0]=Domingo
        semana[1]=Segunda-Feira
        semana[2]=Terça-Feira
        semana[3]=Quarta-Feira
        semana[4]=Quinta-Feira
        semana[5]=Sexta-Feira
        semana[6]=Sábado
        semana[7]=Todos os Dias */
        return Calendar.getInstance().get(Calendar.DAY_OF_WEEK) - 1;
    }

    public static Object getIp() {
        String ipAddress = null;
        Enumeration<NetworkInterface> net = null;
        try {
            net = NetworkInterface.getNetworkInterfaces();
        } catch (SocketException e) {
            return "0.0.0.0";
        }
        while (net.hasMoreElements()) {
            NetworkInterface element = net.nextElement();
            Enumeration<InetAddress> addresses = element.getInetAddresses();
            while (addresses.hasMoreElements()) {
                InetAddress ip = addresses.nextElement();
                if (ip.isSiteLocalAddress()) {
                    ipAddress = ip.getHostAddress();
                }
            }
        }
        return ipAddress;
    }

    public static ArrayList<String> getMacs() {
        ArrayList<String> macs = new ArrayList<>();
        try {
            byte[] mac = null;
            Enumeration<NetworkInterface> net = NetworkInterface.getNetworkInterfaces();
            while (net.hasMoreElements()) {
                NetworkInterface element = net.nextElement();
                mac = element.getHardwareAddress();
                if (mac != null) {
                    StringBuilder formattedMac = new StringBuilder();
                    boolean first = true;
                    for (byte b : mac) {
                        if (first) {
                            first = false;
                        } else {
                            formattedMac.append(":");
                        }
                        String hexStr = Integer.toHexString(b & 0xff);
                        if (hexStr.length() == 1) {
                            formattedMac.append("0");
                        }
                        formattedMac.append(hexStr);
                    }
                    macs.add(formattedMac.toString());
                }
            }
        } catch (Exception ex) {
            Alert.error("Erro ao recuperar endereços do computador." + ex.getMessage());
        }
        return macs;
    }

    public static Object parseDay(Object day) {
        if (day == null) {
            return "";
        }
        String dia = "";
        switch (day.toString()) {
            case "0":
                dia = "Domingo";
                break;
            case "1":
                dia = "Segunda-Feira";
                break;
            case "2":
                dia = "Terça-Feira";
                break;
            case "3":
                dia = "Quarta-Feira";
                break;

            case "4":
                dia = "Quinta-Feira";
                break;

            case "5":
                dia = "Sexta-Feira";
                break;
            case "6":
                dia = "Sábado";
                break;
            case "7":
                dia = "Todos os dias";
                break;
        }
        if (dia.equals("")) {
            return day;
        }
        return dia;
    }

    public static float getTroco(HashMap<Object, Object> map, String key) {
        String valor = (Format.get(map, key));
        if (valor.equals("")) {
            return -1;
        }
        return Float.parseFloat(valor);
    }

    public static int getInt(HashMap<Object, Object> map, String key) {
        String valor = (Format.get(map, key));
        if (valor.equals("")) {
            return 0;
        }
        return Integer.parseInt(valor);
    }

    public static float getFloat(HashMap<Object, Object> map, String key) {
        String valor = (Format.get(map, key));
        if (valor.equals("")) {
            return 0;
        }
        try {
            return Float.parseFloat(valor);
        } catch (Exception ex) {
            return 0;
        }
    }

}
