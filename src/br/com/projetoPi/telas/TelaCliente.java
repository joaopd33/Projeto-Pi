
package br.com.projetoPi.telas;

import java.sql.Connection;
import java.sql.*;
import br.com.projetoPi.dal.ModuloConexao;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

import net.proteanit.sql.DbUtils;
/**
 *
 * @author joao
 */
public class TelaCliente extends javax.swing.JInternalFrame {
Connection conexao = null;
PreparedStatement pst=null;
ResultSet rs=null;
        
    
    
    /**
     * Creates new form TelaCliente
     */
    public TelaCliente() {
        initComponents();
        
        conexao = ModuloConexao.conector();
    }
//criando metodo adicionar
        private void adicionar(){
            String sql = "insert into tbclientes(nomecli,endcli, fonecli, emailcli) values(?,?,?,? )";
            try {
                pst=conexao.prepareStatement(sql);
                pst.setString(1, txtCliNome.getText()); // pegando os campos preenchidos
                pst.setString(2, txtCliEnde.getText());
                pst.setString(3, txCliTel.getText());
                pst.setString(4, txtCliemail.getText());
                
                
                //validação dos campos obrigatorios
                if ((txtCliNome.getText().isEmpty())||(txCliTel.getText().isEmpty())) {
                    JOptionPane.showMessageDialog(null, "Preecha todos os campos obrigatorios");
                } else {
                
                
                int adicionado =  pst.executeUpdate(); // atualiza os dados
                if (adicionado>0) {
                    JOptionPane.showMessageDialog(null, "Usuario cadastrado com Sucesso");
                    txtCliNome.setText(null);
                    txtCliEnde.setText(null);
                    txCliTel.setText(null);
                    txtCliemail.setText(null);
                     
                }
                }
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
        
        //metodo alterar dados do cliente
        private void alterar(){
        String sql= "update tbclientes set nomecli=?, endcli=?, fonecli=?, emailcli=?  where idcli=?";
        try {
            pst=conexao.prepareStatement(sql);
            pst.setString(1,txtCliNome.getText());
            pst.setString(2,txtCliEnde.getText());
            pst.setString(3,txCliTel.getText());
            pst.setString(4,txtCliemail.getText());
            pst.setString(5,txtCliId.getText());
            
             if ((txtCliNome.getText().isEmpty())||(txCliTel.getText().isEmpty())) {
                    JOptionPane.showMessageDialog(null, "Preecha todos os campos obrigatorios");
                } else {
                
                
                int adicionado =  pst.executeUpdate(); // atualiza os dados
                if (adicionado>0) {
                    JOptionPane.showMessageDialog(null, "Dados do usuarios alterados com sucesso");
                    txtCliNome.setText(null);
                    txtCliEnde.setText(null);
                    txCliTel.setText(null);
                    txtCliemail.setText(null);
                    
                    btnAdiconar.setEnabled(true);
                    
                }
             }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
        
        private void remover() throws SQLException{
        
        
        int confirma=JOptionPane.showConfirmDialog(null, "Tem certaza que deseja remover este Cliente", "Atenção",JOptionPane.YES_NO_OPTION );
        if (confirma== JOptionPane.YES_OPTION){
            String sql="delete from tbclientes where idcli=?";
            try {
                pst=conexao.prepareStatement(sql);
                pst.setString(1,txtCliId.getText());
               int apagado =  pst.executeUpdate();
               if(apagado>0){
                   JOptionPane.showMessageDialog(null, "Cliente Removido com sucesso");
                   
                   txtCliNome.setText(null);
                    txtCliEnde.setText(null);
                    txCliTel.setText(null);
                    txtCliemail.setText(null);
                    
                    btnAdiconar.setEnabled(true);  
               }
               
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
        }
        
        
    // metodo para pesquisar cliente modulo avançado;
        private void pesquisar_cliente(){
            String  sql = "select idcli as id, nomecli as nome, endcli as endereço, fonecli as fone, emailcli as email  from tbclientes where nomecli like ?";
            try {
                pst = conexao.prepareStatement(sql);
                // passando o conteudo para o campo caixa de pesquisa
                pst.setString(1, txtCliPesquisar.getText()+ "%");
                rs=pst.executeQuery();
                
                 //tabela de pesquisa
                 tblClientes.setModel(DbUtils.resultSetToTableModel(rs));
                
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);               
                
                
            }
        }
    
        //metodo para setar os campos do formularios com a tabela
        
    public void setar_campos() {
        int setar = tblClientes.getSelectedRow();
        txtCliId.setText(tblClientes.getModel().getValueAt(setar, 0).toString());
        txtCliNome.setText(tblClientes.getModel().getValueAt(setar, 1).toString());
        txtCliEnde.setText(tblClientes.getModel().getValueAt(setar, 2).toString());
        txCliTel.setText(tblClientes.getModel().getValueAt(setar, 3).toString());
        txtCliemail.setText(tblClientes.getModel().getValueAt(setar, 4).toString());
        txtCliNome.setText(tblClientes.getModel().getValueAt(setar, 5).toString());
            
                    
           btnAdiconar.setEnabled(false);

}
           
        
      /*  
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtCliNome = new javax.swing.JTextField();
        txtCliEnde = new javax.swing.JTextField();
        txCliTel = new javax.swing.JTextField();
        txtCliemail = new javax.swing.JTextField();
        btnAdiconar = new javax.swing.JButton();
        btnCliAlterar = new javax.swing.JButton();
        btnCliDelet = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtCliPesquisar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblClientes = new javax.swing.JTable();
        txtCliId = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        jLabel1.setText("*Nome");

        jLabel2.setText("Enderenço");

        jLabel3.setText("*Telefone");

        jLabel4.setText("email");

        btnAdiconar.setText("Adiconar");
        btnAdiconar.setEnabled(false);
        btnAdiconar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdiconarActionPerformed(evt);
            }
        });

        btnCliAlterar.setText("Alterar");
        btnCliAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCliAlterarActionPerformed(evt);
            }
        });

        btnCliDelet.setText("Remover");
        btnCliDelet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCliDeletActionPerformed(evt);
            }
        });

        jLabel5.setText("*Campos Obrigatórios");

        txtCliPesquisar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCliPesquisarKeyReleased(evt);
            }
        });

        tblClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "id", "nome", "enderenço", "fone", "email"
            }
        ));
        tblClientes.setFocusable(false);
        tblClientes.getTableHeader().setReorderingAllowed(false);
        tblClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblClientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblClientes);

        txtCliId.setEnabled(false);

        jLabel6.setText("Id Cliente");

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/projetoPi/icones/pesquisar.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jLabel4))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel1)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCliNome)
                                    .addComponent(txtCliEnde)
                                    .addComponent(txCliTel)
                                    .addComponent(txtCliemail)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtCliId, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(btnAdiconar)
                                .addGap(70, 70, 70)
                                .addComponent(btnCliAlterar)
                                .addGap(63, 63, 63)
                                .addComponent(btnCliDelet)
                                .addGap(0, 67, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtCliPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(190, 190, 190)
                .addComponent(jLabel5)
                .addGap(165, 165, 165))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 616, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCliPesquisar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCliId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCliNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(txtCliEnde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(txCliTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(txtCliemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdiconar)
                    .addComponent(btnCliAlterar)
                    .addComponent(btnCliDelet))
                .addGap(67, 67, 67))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAdiconarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdiconarActionPerformed
        // metodo para add cliente
        adicionar();
    }//GEN-LAST:event_btnAdiconarActionPerformed

    private void btnCliAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCliAlterarActionPerformed
        // chamando o metodo alterar
        alterar();
    }//GEN-LAST:event_btnCliAlterarActionPerformed

    private void txtCliPesquisarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCliPesquisarKeyReleased
        // o evento é do tipo enquanto for digitado
        
        pesquisar_cliente();
    }//GEN-LAST:event_txtCliPesquisarKeyReleased

    private void tblClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblClientesMouseClicked
        // envento usado para setar o mouse clicando com o mouse
        setar_campos();
    }//GEN-LAST:event_tblClientesMouseClicked

    private void btnCliDeletActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCliDeletActionPerformed
    try {
        // chamando metodo para remover
        remover();
    } catch (SQLException ex) {
        Logger.getLogger(TelaCliente.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_btnCliDeletActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdiconar;
    private javax.swing.JButton btnCliAlterar;
    private javax.swing.JButton btnCliDelet;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblClientes;
    private javax.swing.JTextField txCliTel;
    private javax.swing.JTextField txtCliEnde;
    private javax.swing.JTextField txtCliId;
    private javax.swing.JTextField txtCliNome;
    private javax.swing.JTextField txtCliPesquisar;
    private javax.swing.JTextField txtCliemail;
    // End of variables declaration//GEN-END:variables
}
