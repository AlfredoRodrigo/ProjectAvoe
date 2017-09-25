/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import static Classes.ProjectAvoe.deserializa;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author guisi
 */
public class LoginInterface extends javax.swing.JFrame {

    private JPanel JPanel;
    private JPanel JPanel1;
    private JPanel BotãoEnrar;
    
    //static String fileName = "D:\\Documentos\\Documentos do Usuário\\Acadêmico\\IFPB\\E.C\\Matérias\\Laboratório de POO\\Documentos\\Programas\\ProjectAvoe\\src\\Classes\\saves\\cadastro.ser";
    static String fileName = "C:\\Users\\guisi\\OneDrive\\Documentos\\Engenharia de Computação\\Programação Orientada a Objetos\\ProjectAvoe\\src\\Classes\\saves\\cadastro.ser";
    /**
     * Creates new form AvoeInterface
     */
    public LoginInterface() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        BG_Login = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        Float = new javax.swing.JPanel();
        UserCamp = new javax.swing.JTextField();
        UserIcon = new javax.swing.JLabel();
        Separator = new javax.swing.JSeparator();
        PasswordCamp = new javax.swing.JPasswordField();
        PasswordIcon = new javax.swing.JLabel();
        Separator2 = new javax.swing.JSeparator();
        btn_entrar = new javax.swing.JPanel();
        mgn_Entrar = new javax.swing.JLabel();
        ClientLoginName = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Project Avoe - Login");
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setLocation(new java.awt.Point(270, 40));
        setResizable(false);

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, BG_Login, org.jdesktop.beansbinding.ELProperty.create("${background}"), BG_Login, org.jdesktop.beansbinding.BeanProperty.create("background"));
        bindingGroup.addBinding(binding);

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GraficInterface/icons/iconSup.png"))); // NOI18N

        Float.setBackground(new java.awt.Color(153, 153, 153));

        UserCamp.setBackground(Float.getBackground());
        UserCamp.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        UserCamp.setBorder(null);
        UserCamp.setSelectionColor(new java.awt.Color(102, 102, 102));
        UserCamp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UserCampActionPerformed(evt);
            }
        });

        UserIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        UserIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GraficInterface/icons/icons8_Customer_26px.png"))); // NOI18N
        UserIcon.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        Separator.setBackground(Float.getBackground());
        Separator.setForeground(Float.getForeground());

        PasswordCamp.setBackground(Float.getBackground());
        PasswordCamp.setBorder(null);
        PasswordCamp.setDragEnabled(true);
        PasswordCamp.setSelectionColor(new java.awt.Color(102, 102, 102));

        PasswordIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PasswordIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GraficInterface/icons/icons8_Lock_26px.png"))); // NOI18N

        Separator2.setBackground(Float.getBackground());
        Separator2.setForeground(Float.getForeground());

        btn_entrar.setBackground(new java.awt.Color(51, 51, 51));
        btn_entrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_entrarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_entrarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_entrarMouseExited(evt);
            }
        });

        mgn_Entrar.setFont(new java.awt.Font("Swis721 WGL4 BT", 0, 18)); // NOI18N
        mgn_Entrar.setForeground(new java.awt.Color(255, 255, 255));
        mgn_Entrar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mgn_Entrar.setText("Entrar");

        javax.swing.GroupLayout btn_entrarLayout = new javax.swing.GroupLayout(btn_entrar);
        btn_entrar.setLayout(btn_entrarLayout);
        btn_entrarLayout.setHorizontalGroup(
            btn_entrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_entrarLayout.createSequentialGroup()
                .addGap(124, 124, 124)
                .addComponent(mgn_Entrar, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(124, Short.MAX_VALUE))
        );
        btn_entrarLayout.setVerticalGroup(
            btn_entrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mgn_Entrar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        ClientLoginName.setFont(new java.awt.Font("Verdana", 0, 36)); // NOI18N
        ClientLoginName.setForeground(new java.awt.Color(255, 255, 255));
        ClientLoginName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ClientLoginName.setText("Client Login");

        javax.swing.GroupLayout FloatLayout = new javax.swing.GroupLayout(Float);
        Float.setLayout(FloatLayout);
        FloatLayout.setHorizontalGroup(
            FloatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FloatLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(FloatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(UserIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PasswordIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(FloatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_entrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Separator2)
                    .addComponent(PasswordCamp)
                    .addComponent(Separator)
                    .addComponent(UserCamp))
                .addContainerGap(122, Short.MAX_VALUE))
            .addComponent(ClientLoginName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        FloatLayout.setVerticalGroup(
            FloatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FloatLayout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(ClientLoginName, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(FloatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(UserCamp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(UserIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(1, 1, 1)
                .addGroup(FloatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(FloatLayout.createSequentialGroup()
                        .addComponent(Separator, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(PasswordCamp, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(PasswordIcon))
                .addGap(1, 1, 1)
                .addComponent(Separator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(btn_entrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
        );

        javax.swing.GroupLayout BG_LoginLayout = new javax.swing.GroupLayout(BG_Login);
        BG_Login.setLayout(BG_LoginLayout);
        BG_LoginLayout.setHorizontalGroup(
            BG_LoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(BG_LoginLayout.createSequentialGroup()
                .addGap(145, 145, 145)
                .addComponent(Float, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(149, Short.MAX_VALUE))
        );
        BG_LoginLayout.setVerticalGroup(
            BG_LoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BG_LoginLayout.createSequentialGroup()
                .addGroup(BG_LoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BG_LoginLayout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(jLabel2))
                    .addGroup(BG_LoginLayout.createSequentialGroup()
                        .addGap(115, 115, 115)
                        .addComponent(Float, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(100, 100, 100))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BG_Login, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BG_Login, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void UserCampActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UserCampActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UserCampActionPerformed

    private void btn_entrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_entrarMouseEntered
        setcolor(btn_entrar);
    }//GEN-LAST:event_btn_entrarMouseEntered

    private void btn_entrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_entrarMouseExited
        resetcolor(btn_entrar);
    }//GEN-LAST:event_btn_entrarMouseExited
    
    private void btn_entrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_entrarMouseClicked
        Cadastrados cadastro = deserializa(fileName);
        
        Usuario logado = null;
        
        if (cadastro.getQtdAdm() == 0) {
            cadastro.administradorPadrao();
        }
        
        logado = cadastro.autentica(UserCamp.getText(), PasswordCamp.getText());
        if (logado != null) {
            MainInterface main = new MainInterface(cadastro, logado);
            main.setVisible(true);
            this.dispose();
        }
        else {
            JOptionPane.showMessageDialog(null,"Usuário ou senha incorretos.");
            UserCamp.setText(null);
            PasswordCamp.setText(null);
        }
    }//GEN-LAST:event_btn_entrarMouseClicked
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginInterface().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BG_Login;
    private javax.swing.JLabel ClientLoginName;
    private javax.swing.JPanel Float;
    private javax.swing.JPasswordField PasswordCamp;
    private javax.swing.JLabel PasswordIcon;
    private javax.swing.JSeparator Separator;
    private javax.swing.JSeparator Separator2;
    private javax.swing.JTextField UserCamp;
    private javax.swing.JLabel UserIcon;
    private javax.swing.JPanel btn_entrar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel mgn_Entrar;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables

    private void setcolor(JPanel jPanel1) {
        jPanel1.setBackground(new Color(102,102,102));
    }
    
    private void resetcolor(JPanel jPanel1) {
        jPanel1.setBackground(new Color(51,51,51));
    }
}
