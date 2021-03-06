/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package correio.gui;

import correio.core.Correio;
import correio.core.Usuario;
import correio.utils.RMIUtils;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;

/**
 *
 * @author filipe
 */
public class TelaLogin extends javax.swing.JDialog {

    private String hostname;
    private Map<String, String> usuario;

    public TelaLogin(java.awt.Frame parent, String hostname, boolean modal) {
        super(parent, modal);
        this.hostname = hostname;
        initComponents();
        setLocationRelativeTo(parent);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelDeAbas = new javax.swing.JTabbedPane();
        panelLogin = new javax.swing.JPanel();
        labelCorreio1 = new javax.swing.JLabel();
        labelUsername1 = new javax.swing.JLabel();
        labelSenha1 = new javax.swing.JLabel();
        textUserLogin = new javax.swing.JTextField();
        textPassLogin = new javax.swing.JPasswordField();
        botaoOk = new javax.swing.JButton();
        painelRegistro = new javax.swing.JPanel();
        labelCorreio2 = new javax.swing.JLabel();
        labelUsername2 = new javax.swing.JLabel();
        textUserRegistrar = new javax.swing.JTextField();
        labelSenha2 = new javax.swing.JLabel();
        textPassRegistrar = new javax.swing.JPasswordField();
        labelSenha3 = new javax.swing.JLabel();
        textConfirmarRegistrar = new javax.swing.JPasswordField();
        botaoRegistrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Correio - Login");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        labelCorreio1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        labelCorreio1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelCorreio1.setText("CORREIO");

        labelUsername1.setText("Username:");

        labelSenha1.setText("Senha:");

        botaoOk.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        botaoOk.setText("TALQUEI");
        botaoOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoOkActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelLoginLayout = new javax.swing.GroupLayout(panelLogin);
        panelLogin.setLayout(panelLoginLayout);
        panelLoginLayout.setHorizontalGroup(
            panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLoginLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botaoOk, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelCorreio1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelLoginLayout.createSequentialGroup()
                        .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelUsername1)
                            .addComponent(labelSenha1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textUserLogin)
                            .addComponent(textPassLogin))))
                .addContainerGap())
        );
        panelLoginLayout.setVerticalGroup(
            panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLoginLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelCorreio1)
                .addGap(18, 18, 18)
                .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelUsername1)
                    .addComponent(textUserLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelSenha1)
                    .addComponent(textPassLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botaoOk, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        painelDeAbas.addTab("Login", panelLogin);

        labelCorreio2.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        labelCorreio2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelCorreio2.setText("CORREIO");

        labelUsername2.setText("Username:");

        labelSenha2.setText("Senha:");

        labelSenha3.setText("Confirmar:");

        botaoRegistrar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        botaoRegistrar.setText("REGISTRAR");
        botaoRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoRegistrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelRegistroLayout = new javax.swing.GroupLayout(painelRegistro);
        painelRegistro.setLayout(painelRegistroLayout);
        painelRegistroLayout.setHorizontalGroup(
            painelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelRegistroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botaoRegistrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelCorreio2, javax.swing.GroupLayout.DEFAULT_SIZE, 347, Short.MAX_VALUE)
                    .addGroup(painelRegistroLayout.createSequentialGroup()
                        .addGroup(painelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelUsername2)
                            .addComponent(labelSenha2)
                            .addComponent(labelSenha3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(painelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textConfirmarRegistrar)
                            .addComponent(textUserRegistrar)
                            .addComponent(textPassRegistrar))))
                .addContainerGap())
        );
        painelRegistroLayout.setVerticalGroup(
            painelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelRegistroLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelCorreio2)
                .addGap(18, 18, 18)
                .addGroup(painelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelUsername2)
                    .addComponent(textUserRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(painelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelSenha2)
                    .addComponent(textPassRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(painelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelSenha3)
                    .addComponent(textConfirmarRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(botaoRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        painelDeAbas.addTab("Registrar", painelRegistro);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(painelDeAbas)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(painelDeAbas)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    @SuppressWarnings("deprecated")
    private void botaoOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoOkActionPerformed
        String user = textUserLogin.getText();
        String pass = textPassLogin.getText();
        Correio servidorDeCorreio = RMIUtils.getStub(hostname);
        if (user.trim().equals("") || pass.trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Logins normalmente precisam de usuário e senha, fera.",
                    "ó as idéia kkkkk", JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                boolean logou = servidorDeCorreio.login(user, pass);
                if (!logou) {
                    JOptionPane.showMessageDialog(null, "Tem um trem errado aí auhauaha",
                            "Oxe", JOptionPane.WARNING_MESSAGE);
                } else {
                    usuario = new HashMap<>();
                    usuario.put("user", user);
                    usuario.put("pass", pass);
                    dispose();
                }
            } catch (RemoteException ex) {
                JOptionPane.showMessageDialog(null, "UÉ, o servidor deu pala auahuahau",
                        "Que merda kkkk", JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_botaoOkActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        usuario = null;
    }//GEN-LAST:event_formWindowClosing

    private void botaoRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoRegistrarActionPerformed
        String user = textUserRegistrar.getText();
        String pass = textPassRegistrar.getText();
        String confPass = textConfirmarRegistrar.getText();
        Correio servidorDeCorreio = RMIUtils.getStub(hostname);
        if (user.trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Bota um nome aí pa nois pelo menos opora",
                    "ó as idéia kkkkk", JOptionPane.WARNING_MESSAGE);
        } else if (user.contains(" ")) {
            JOptionPane.showMessageDialog(null, "Nome de usuário nem pode ter espaço, fera.",
                    "opora kkkkk", JOptionPane.WARNING_MESSAGE);
        } else if (!pass.equals(confPass) || pass.trim().equals("") || confPass.trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Escreve direito a senha aí men",
                    "opora kkkkk", JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                if (servidorDeCorreio.cadastrarUsuario(new Usuario(user, pass))) {
                    JOptionPane.showMessageDialog(null, "Novo usuário registrado!",
                            "Aí é sucesso", JOptionPane.INFORMATION_MESSAGE);
                    textUserRegistrar.setText("");
                    textPassRegistrar.setText("");
                    textConfirmarRegistrar.setText("");
                    painelDeAbas.setSelectedIndex(0);
                } else {
                    JOptionPane.showMessageDialog(null, "Já tem neguim com esse nome auhaua",
                            "Oxe", JOptionPane.WARNING_MESSAGE);
                }
            } catch (RemoteException ex) {
                JOptionPane.showMessageDialog(null, "UÉ, o servidor deu pala auahuahau",
                        "Que merda kkkk", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_botaoRegistrarActionPerformed

    public static Map<String, String> getUsuarioFromLogin(String hostname) {
        TelaLogin login = new TelaLogin(null, hostname, true);
        login.setVisible(true);
        return login.usuario;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoOk;
    private javax.swing.JButton botaoRegistrar;
    private javax.swing.JLabel labelCorreio1;
    private javax.swing.JLabel labelCorreio2;
    private javax.swing.JLabel labelSenha1;
    private javax.swing.JLabel labelSenha2;
    private javax.swing.JLabel labelSenha3;
    private javax.swing.JLabel labelUsername1;
    private javax.swing.JLabel labelUsername2;
    private javax.swing.JTabbedPane painelDeAbas;
    private javax.swing.JPanel painelRegistro;
    private javax.swing.JPanel panelLogin;
    private javax.swing.JPasswordField textConfirmarRegistrar;
    private javax.swing.JPasswordField textPassLogin;
    private javax.swing.JPasswordField textPassRegistrar;
    private javax.swing.JTextField textUserLogin;
    private javax.swing.JTextField textUserRegistrar;
    // End of variables declaration//GEN-END:variables
}
