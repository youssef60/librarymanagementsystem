/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Views;

import Controllers.CassetteVideoController;
import Controllers.CategorieController;
import Controllers.DisqueCompactController;
import Controllers.JournalController;
import Controllers.LivreController;
import Controllers.PeriodicController;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author MHD
 */
public class livreView extends javax.swing.JFrame {

    CategorieController categorieController = new  CategorieController();
    LivreController livreController = new LivreController();
    CassetteVideoController cassetteVideoController = new CassetteVideoController();
    JournalController journalController = new JournalController();
    PeriodicController periodicController = new PeriodicController();
    DisqueCompactController disqueCompactController = new DisqueCompactController();
    String titre ;
    String nomAuteur;
    int nbCopie;
    String datePublication;
    String isbn;
    int idCat; 
    String type;
    DefaultComboBoxModel cmbModel;
    /**
     * Creates new form livreView
     */
    public livreView()  {
        initComponents();
        initTable();
        initComboModelSearch();
        initComboModelCategorie();

        
    }

    public void initComboModelCategorie(){

      cmbModel = new DefaultComboBoxModel();

      try{
            categorieController.getModel().setResultSet(categorieController.getDao().getRsAll());
                   
            for(int i=0;i<categorieController.getModel().getRowCount() ; i++){

                   String cat = categorieController.getModel().getValueAt(i, 0) + "-" + categorieController.getModel().getValueAt(i, 1);
                   cmbModel.addElement( cat );                
            } 
   
            comboCat.setModel(cmbModel);
            
      }catch(SQLException e){

          JOptionPane.showMessageDialog(rootPane, e);
      }


    }

    public void initTable(){
             
        if(affichageCombo.getSelectedItem().equals("livreRegulier")){
            try{
                ResultSet rs = livreController.getDao().getRsAllLivreRegulier();
                livreController.getModel().setResultSet(rs);

            }catch(SQLException e){
                  JOptionPane.showMessageDialog(rootPane, e);
            }

             tblDisplay.setModel(livreController.getModel());       
        }else if(affichageCombo.getSelectedItem().equals("disqueCompact")){
        
           try{
                ResultSet rs = disqueCompactController.getDao().getRsAll();
                disqueCompactController.getModel().setResultSet(rs);

            }catch(SQLException e){
                  JOptionPane.showMessageDialog(rootPane, e);
            }

             tblDisplay.setModel(disqueCompactController.getModel());   

        }else if(affichageCombo.getSelectedItem().equals("livreDemander")){
        
           try{
                ResultSet rs = livreController.getDao().getRsAllLivreDemander();
                livreController.getModel().setResultSet(rs);

            }catch(SQLException e){
                  JOptionPane.showMessageDialog(rootPane, e);
            }

             tblDisplay.setModel(livreController.getModel());   

        }else if(affichageCombo.getSelectedItem().equals("cassettesVideo")){
        
           try{
                ResultSet rs = cassetteVideoController.getDao().getRsAll();
                cassetteVideoController.getModel().setResultSet(rs);

            }catch(SQLException e){
                  JOptionPane.showMessageDialog(rootPane, e);
            }

             tblDisplay.setModel(cassetteVideoController.getModel());   

        }else if(affichageCombo.getSelectedItem().equals("periodic")){
        
           try{
                ResultSet rs = periodicController.getDao().getRsAll();
                periodicController.getModel().setResultSet(rs);

            }catch(SQLException e){
                  JOptionPane.showMessageDialog(rootPane, e);
            }

             tblDisplay.setModel(periodicController.getModel());   

        }else if(affichageCombo.getSelectedItem().equals("journal")){
        
           try{
                ResultSet rs = journalController.getDao().getRsAll();
                journalController.getModel().setResultSet(rs);

            }catch(SQLException e){
                  JOptionPane.showMessageDialog(rootPane, e);
            }

             tblDisplay.setModel(journalController.getModel());   

        }

         
    }

    public void initComboModelSearch(){
        
       String type = affichageCombo.getSelectedItem().toString();
       String champ1;
        cmbModel = new DefaultComboBoxModel();

      try{
            livreController.getModel().setResultSet(livreController.getDao().getRsAllLivreRegulier());
             
            for(int i=0;i<livreController.getModel().getColumnCount() ; i++){
                   
                      
                   if(livreController.getModel().getColumnName(i).equals("champ1") ){
                        if(type.equals("livreRegulier") || type.equals("livreDemander") ){
                                cmbModel.addElement("ISBN");
                         }else if(type.equals("cassettesVideo") || type.equals("disqueCompact") ){
                                cmbModel.addElement("Duree"); 
                         }else if(type.equals("journal") || type.equals("periodic")){
                                cmbModel.addElement("ISSN"); 
                         }
                    }
                   if(livreController.getModel().getColumnName(i).equals("nomCat")){
                       cmbModel.addElement("categorie");
                       
                  }else{
                   cmbModel.addElement(livreController.getModel().getColumnName(i));    
                  }
                    
            } 
   
            comboSearch.setModel(cmbModel);
            
      }catch(SQLException e){

          JOptionPane.showMessageDialog(rootPane, e);
      }
         
}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        clear = new javax.swing.JButton();
        updateBtn = new javax.swing.JButton();
        sauvegarderBtn = new javax.swing.JButton();
        supprimerBtn = new javax.swing.JButton();
        chercherBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDisplay = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        comboSearch = new javax.swing.JComboBox<>();
        chercherTxt = new javax.swing.JTextField();
        affichageCombo = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        titreTxt = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        idLivreTxt = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        auteurTxt = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        nbCopieTxt = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        datePublicationTxt = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        isbnTxt = new javax.swing.JTextField();
        champ1Txt = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        comboCat = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        typeCombo = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setEnabled(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Gestion des Documents");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        clear.setText("Clear");
        clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearActionPerformed(evt);
            }
        });

        updateBtn.setText("Update");
        updateBtn.setEnabled(false);
        updateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBtnActionPerformed(evt);
            }
        });

        sauvegarderBtn.setText("Sauvegarder");
        sauvegarderBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sauvegarderBtnActionPerformed(evt);
            }
        });

        supprimerBtn.setText("Supprimer");
        supprimerBtn.setEnabled(false);
        supprimerBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supprimerBtnActionPerformed(evt);
            }
        });

        chercherBtn.setText("Chercher");
        chercherBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chercherBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(clear)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sauvegarderBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chercherBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(updateBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(supprimerBtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(clear)
                    .addComponent(sauvegarderBtn)
                    .addComponent(chercherBtn)
                    .addComponent(updateBtn)
                    .addComponent(supprimerBtn))
                .addContainerGap())
        );

        tblDisplay.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Titre", "Auteur", "nbCopie", "datePublication", "ISBN", "Categorie"
            }
        ));
        tblDisplay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDisplayMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tblDisplayMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblDisplay);

        jLabel9.setText("Chercher par :");

        comboSearch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Titre", "Auteur", " " }));
        comboSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboSearchActionPerformed(evt);
            }
        });

        chercherTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chercherTxtActionPerformed(evt);
            }
        });
        chercherTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                chercherTxtKeyReleased(evt);
            }
        });

        affichageCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "livreRegulier", "livreDemander", "disqueCompact", "cassettesVideo", "journal", "periodic", " ", " " }));
        affichageCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                affichageComboActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("Afficher :");

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Titre :");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                .addComponent(titreTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titreTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Id Doc :");

        idLivreTxt.setEnabled(false);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addComponent(idLivreTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idLivreTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Auteur");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addComponent(auteurTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(auteurTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addContainerGap())
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Nombre Copie :");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(nbCopieTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nbCopieTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addContainerGap())
        );

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        datePublicationTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                datePublicationTxtActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Date publication :");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(datePublicationTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(datePublicationTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        champ1Txt.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        champ1Txt.setText("ISBN :");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(champ1Txt)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                .addComponent(isbnTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(champ1Txt)
                    .addComponent(isbnTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));

        comboCat.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Math", "Music", "Physique", " " }));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Categorie :");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(comboCat, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(comboCat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));

        typeCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "livreRegulier", "livreDemander", "disqueCompact", "cassettesVideo", "journal", "periodic", " " }));
        typeCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                typeComboActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Type  :");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addComponent(typeCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(typeCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(289, 289, 289))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62)
                        .addComponent(affichageCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(comboSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(chercherTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 483, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(affichageCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addGap(28, 28, 28)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comboSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(chercherTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(47, 47, 47)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(65, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnActionPerformed
        
        String idDoc = idLivreTxt.getText();
        String titre = titreTxt.getText();
        String nomAuteur = auteurTxt.getText();
        String nbCopie = nbCopieTxt.getText();
        String datePublication = datePublicationTxt.getText();
        String isbn = isbnTxt.getText();
        String type = typeCombo.getSelectedItem().toString();
        int idCat = Integer.parseInt(comboCat.getSelectedItem().toString().split("-")[0]);
      
        livreController.getLivre().setIdLivre(Integer.parseInt(idDoc));
        livreController.getLivre().setTitre(titre);
        livreController.getLivre().setNomAuteur(nomAuteur);
        livreController.getLivre().setNbCopie(Integer.parseInt(nbCopie));
        livreController.getLivre().setDatePublication(datePublication);
        livreController.getLivre().setIsbn(isbn);
        livreController.getLivre().setIdCat(idCat);

        try{
                livreController.getDao().update(livreController.getLivre());
                JOptionPane.showMessageDialog(rootPane, "Document updated succesfully");
            }catch(SQLException e){
                JOptionPane.showMessageDialog(rootPane, e);
        }
        initTable();

    }//GEN-LAST:event_updateBtnActionPerformed

    private void supprimerBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supprimerBtnActionPerformed
        int idDoc = Integer.parseInt(idLivreTxt.getText());
            livreController.getLivre().setIdLivre(idDoc);
            try{
                   livreController.getDao().delete(livreController.getLivre());
            }catch(SQLException e){
               JOptionPane.showMessageDialog(rootPane, e);
            }

        initTable();
        clearData();
    }//GEN-LAST:event_supprimerBtnActionPerformed

   public void clearData(){
        idLivreTxt.setText("");
        titreTxt.setText("");
        auteurTxt.setText("");
        nbCopieTxt.setText("");
        datePublicationTxt.setText("");
        isbnTxt.setText("");
       
        sauvegarderBtn.setEnabled(true);
        clear.setEnabled(false);
   }
    
    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed
        
        clearData();
           
    }//GEN-LAST:event_clearActionPerformed

    private void sauvegarderBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sauvegarderBtnActionPerformed

        
        if(getRecordValidation() == true ){
             
              titre  = titreTxt.getText().trim();
             nomAuteur = auteurTxt.getText().trim();
             nbCopie  = Integer.parseInt(nbCopieTxt.getText().trim());
             datePublication =  datePublicationTxt.getText().trim();
             isbn = isbnTxt.getText().trim();
             idCat =  Integer.parseInt(comboCat.getSelectedItem().toString().split("-")[0]);
             type = typeCombo.getSelectedItem().toString();

             if(type.equals("livreRegulier") || type.equals("livreDemander") ){
                 livreController.getLivre().setTitre(titre);
                 livreController.getLivre().setNomAuteur(nomAuteur);
                 livreController.getLivre().setNbCopie(nbCopie);
                 livreController.getLivre().setDatePublication(datePublication); 
                 livreController.getLivre().setIsbn(isbn); 
                 livreController.getLivre().setIdCat(idCat); 
                 if(type.equals("livreRegulier")){
                      try{
                            livreController.getDao().insertLivreRegulier(livreController.getLivre());
                            JOptionPane.showMessageDialog(rootPane, "livreRegulier saved succefully");
                            clear.setEnabled(true);
                            sauvegarderBtn.setEnabled(false);
                            initTable();
                         }catch(SQLException e){
                            e.printStackTrace();
                         }
                 }else{
                       try{
                            livreController.getDao().insertLivreDemander(livreController.getLivre());
                            JOptionPane.showMessageDialog(rootPane, "livreDemander saved succefully");
                            clear.setEnabled(true);
                            sauvegarderBtn.setEnabled(false);
                            initTable();
                         }catch(SQLException e){
                            e.printStackTrace();
                         }
                 }
                 
             }else if(type.equals("disqueCompact")){

                 disqueCompactController.getDisque().setTitre(titre);
                 disqueCompactController.getDisque().setNomAuteur(nomAuteur);
                 disqueCompactController.getDisque().setNbCopie(nbCopie);
                 disqueCompactController.getDisque().setDatePublication(datePublication);
                 disqueCompactController.getDisque().setDuree(isbn);
                 disqueCompactController.getDisque().setIdCat(idCat);

                 try{
                disqueCompactController.getDao().insert(disqueCompactController.getDisque());
                JOptionPane.showMessageDialog(rootPane, "disqueCompact saved succefully");
                clear.setEnabled(true);
                sauvegarderBtn.setEnabled(false);
                initTable();
                }catch(SQLException e){
                    e.printStackTrace();
                }

             }else if(type.equals("journal")){

                 journalController.getJournal().setTitre(titre);
                 journalController.getJournal().setIssn(isbn);
                 journalController.getJournal().setIdCat(idCat);
                 journalController.getJournal().setNbCopie(nbCopie);
                 journalController.getJournal().setNomAuteur(nomAuteur);
                 journalController.getJournal().setDatePublication(datePublication);               

                 try{
                journalController.getDao().insert(journalController.getJournal());
                JOptionPane.showMessageDialog(rootPane, "journal saved succefully");
                clear.setEnabled(true);
                sauvegarderBtn.setEnabled(false);
                initTable();
                }catch(SQLException e){
                    e.printStackTrace();
                }
             }else if(type.equals("periodic")){

                 periodicController.getPeriodic().setTitre(titre);
                 periodicController.getPeriodic().setDatePublication(datePublication);
                 periodicController.getPeriodic().setIssn(isbn);
                 periodicController.getPeriodic().setNbCopie(nbCopie);
                 periodicController.getPeriodic().setNomAuteur(nomAuteur);
                 periodicController.getPeriodic().setNomAuteur(nomAuteur);

                 try{
                periodicController.getDao().insert(periodicController.getPeriodic());
                JOptionPane.showMessageDialog(rootPane, "peridic saved succefully");
                clear.setEnabled(true);
                sauvegarderBtn.setEnabled(false);
                initTable();
                }catch(SQLException e){
                    e.printStackTrace();
                }
             }else if(type.equals("cassettesVideo")){
              
                 cassetteVideoController.getCassette().setDatePublication(datePublication);
                 cassetteVideoController.getCassette().setDuree(isbn);
                 cassetteVideoController.getCassette().setNbCopie(nbCopie);
                 cassetteVideoController.getCassette().setIdCat(idCat);
                 cassetteVideoController.getCassette().setNomAuteur(nomAuteur);
                 cassetteVideoController.getCassette().setTitre(titre);
                 

                 try{
                cassetteVideoController.getDao().insert(cassetteVideoController.getCassette());
                JOptionPane.showMessageDialog(rootPane, "cassette saved succefully");
                clear.setEnabled(true);
                sauvegarderBtn.setEnabled(false);
                initTable();
                }catch(SQLException e){
                    e.printStackTrace();
                }
             }

             

             


             

             



         }
    }//GEN-LAST:event_sauvegarderBtnActionPerformed

    private void chercherBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chercherBtnActionPerformed
        
    }//GEN-LAST:event_chercherBtnActionPerformed

    private void chercherTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_chercherTxtKeyReleased
        String word = chercherTxt.getText();
        String type = affichageCombo.getSelectedItem().toString();
        String colName = comboSearch.getSelectedItem().toString();
        if(colName.equals("Duree") || colName.equals("ISBN") || colName.equals("ISSN") ) { colName = "champ1"; }
        
        try{
               if(type.equals("livreRegulier")){
                   ResultSet rs = livreController.getDao().searchLivreRegulier(colName, word);
                   livreController.getModel().setResultSet(rs);
                   tblDisplay.setModel(livreController.getModel());
               }else if(type.equals("livreDemander")){
                   ResultSet rs = livreController.getDao().searchLivreDemander(colName, word);
                   livreController.getModel().setResultSet(rs);
                   tblDisplay.setModel(livreController.getModel());
               }else if(type.equals("disqueCompact")){
                   ResultSet rs = disqueCompactController.getDao().search(colName, word);
                   disqueCompactController.getModel().setResultSet(rs);
                   tblDisplay.setModel(disqueCompactController.getModel());
               }else if(type.equals("cassettesVideo")){
                   ResultSet rs = cassetteVideoController.getDao().search(colName, word);
                   cassetteVideoController.getModel().setResultSet(rs);
                   tblDisplay.setModel(disqueCompactController.getModel());
               }else if(type.equals("journal")){
                   ResultSet rs = journalController.getDao().search(colName, word);
                   journalController.getModel().setResultSet(rs);
                   tblDisplay.setModel(journalController.getModel());
               }else if(type.equals("periodic")){
                   ResultSet rs = periodicController.getDao().search(colName, word);
                   periodicController.getModel().setResultSet(rs);
                   tblDisplay.setModel(periodicController.getModel());
               }

        }catch(SQLException e){
            JOptionPane.showMessageDialog(rootPane, e);
            
        }

    }//GEN-LAST:event_chercherTxtKeyReleased

    private void tblDisplayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDisplayMouseClicked
             
    }//GEN-LAST:event_tblDisplayMouseClicked

    private void tblDisplayMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDisplayMouseReleased
        
        int i = tblDisplay.getSelectedRow();
        String getCategorieTable = "" ;
        String type = affichageCombo.getSelectedItem().toString();
        typeCombo.setSelectedItem(affichageCombo.getSelectedItem());
        typeCombo.setSelectedItem(affichageCombo.getSelectedItem());
        if(type.equals("livreRegulier")  || type.equals("livreDemander")){

            
            idLivreTxt.setText(livreController.getModel().getValueAt(i, 0).toString());
            titreTxt.setText(livreController.getModel().getValueAt(i, 1).toString());
            auteurTxt.setText(livreController.getModel().getValueAt(i, 2).toString());
            nbCopieTxt.setText(livreController.getModel().getValueAt(i, 3).toString());
            datePublicationTxt.setText(livreController.getModel().getValueAt(i, 4).toString());
            isbnTxt.setText(livreController.getModel().getValueAt(i, 5).toString());
            getCategorieTable = livreController.getModel().getValueAt(i, 6).toString();
        }else if(type.equals("disqueCompact")){
            
            idLivreTxt.setText(disqueCompactController.getModel().getValueAt(i, 0).toString());
            titreTxt.setText(disqueCompactController.getModel().getValueAt(i, 1).toString());
            auteurTxt.setText(disqueCompactController.getModel().getValueAt(i, 2).toString());
            nbCopieTxt.setText(disqueCompactController.getModel().getValueAt(i, 3).toString());
            datePublicationTxt.setText(disqueCompactController.getModel().getValueAt(i, 4).toString());
            isbnTxt.setText(disqueCompactController.getModel().getValueAt(i, 5).toString());
            getCategorieTable = disqueCompactController.getModel().getValueAt(i, 6).toString();
        }else if(type.equals("cassettesVideo")){
            
            idLivreTxt.setText(cassetteVideoController.getModel().getValueAt(i, 0).toString());
            titreTxt.setText(cassetteVideoController.getModel().getValueAt(i, 1).toString());
            auteurTxt.setText(cassetteVideoController.getModel().getValueAt(i, 2).toString());
            nbCopieTxt.setText(cassetteVideoController.getModel().getValueAt(i, 3).toString());
            datePublicationTxt.setText(cassetteVideoController.getModel().getValueAt(i, 4).toString());
            isbnTxt.setText(cassetteVideoController.getModel().getValueAt(i, 5).toString());
            getCategorieTable = cassetteVideoController.getModel().getValueAt(i, 6).toString();
        }if(type.equals("journal ")){
            
            idLivreTxt.setText(journalController.getModel().getValueAt(i, 0).toString());
            titreTxt.setText(journalController.getModel().getValueAt(i, 1).toString());
            auteurTxt.setText(journalController.getModel().getValueAt(i, 2).toString());
            nbCopieTxt.setText(journalController.getModel().getValueAt(i, 3).toString());
            datePublicationTxt.setText(journalController.getModel().getValueAt(i, 4).toString());
            isbnTxt.setText(journalController.getModel().getValueAt(i, 5).toString());
            getCategorieTable = journalController.getModel().getValueAt(i, 6).toString();
        }if(type.equals("periodic")){
            
            idLivreTxt.setText(periodicController.getModel().getValueAt(i, 0).toString());
            titreTxt.setText(periodicController.getModel().getValueAt(i, 1).toString());
            auteurTxt.setText(periodicController.getModel().getValueAt(i, 2).toString());
            nbCopieTxt.setText(periodicController.getModel().getValueAt(i, 3).toString());
            datePublicationTxt.setText(periodicController.getModel().getValueAt(i, 4).toString());
            isbnTxt.setText(periodicController.getModel().getValueAt(i, 5).toString());
            getCategorieTable = periodicController.getModel().getValueAt(i, 6).toString();
        }
        
        
       
        
        cmbModel = new DefaultComboBoxModel();

      try{
            categorieController.getModel().setResultSet(categorieController.getDao().getRsAll());
                 String cat;  
            for(int k=0;k<categorieController.getModel().getRowCount() ; k++){

                    cat = categorieController.getModel().getValueAt(k, 0) + "-" + categorieController.getModel().getValueAt(k, 1);
                   cmbModel.addElement( cat );  
                   if(getCategorieTable.equals(categorieController.getModel().getValueAt(k, 1)))  {
                         cmbModel.setSelectedItem(cat);
                     }            
            } 
   
            comboCat.setModel(cmbModel);
            
      }catch(SQLException e){

          JOptionPane.showMessageDialog(rootPane, e);
      }
        
        
         // comboCat.setModel(cmbModel);
        clear.setEnabled(true);
        updateBtn.setEnabled(true);
        supprimerBtn.setEnabled(true);
        sauvegarderBtn.setEnabled(true);

    }//GEN-LAST:event_tblDisplayMouseReleased

    private void typeComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_typeComboActionPerformed
        if(typeCombo.getSelectedItem().equals("disqueCompact") || typeCombo.getSelectedItem().equals("cassettesVideo")  ){
               champ1Txt.setText("Duree");
        }else if(typeCombo.getSelectedItem().equals("journal") || typeCombo.getSelectedItem().equals("periodic") ){
               champ1Txt.setText("ISSN");
        }else{
               champ1Txt.setText("ISBN");
        }
    }//GEN-LAST:event_typeComboActionPerformed

    private void datePublicationTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_datePublicationTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_datePublicationTxtActionPerformed

    private void chercherTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chercherTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chercherTxtActionPerformed

    private void affichageComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_affichageComboActionPerformed
         initComboModelSearch();  
         initTable();
    }//GEN-LAST:event_affichageComboActionPerformed

    private void comboSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboSearchActionPerformed
    public boolean getRecordValidation(){
          if(livreController.getValidation().isEmpty(titreTxt.getText().trim())){
                JOptionPane.showMessageDialog(rootPane, "plz enter the titre");
                titreTxt.requestFocus();
                return false;
          }else if(livreController.getValidation().isEmpty(auteurTxt.getText().trim())){
                JOptionPane.showMessageDialog(rootPane, "plz enter the autheur name ");
                auteurTxt.requestFocus();
                return false; 
          }else if(livreController.getValidation().isEmpty(nbCopieTxt.getText().trim())){
                JOptionPane.showMessageDialog(rootPane, "plz enter the copies number ");
                nbCopieTxt.requestFocus();
                return false;
          }else if(livreController.getValidation().isEmpty(datePublicationTxt.getText().trim())){
                JOptionPane.showMessageDialog(rootPane, "plz enter the publication date ");
                datePublicationTxt.requestFocus();
                return false;
          }else if(livreController.getValidation().isEmpty(isbnTxt.getText().trim())){
                JOptionPane.showMessageDialog(rootPane, "plz enter the isbn  ");
                isbnTxt.requestFocus();
                return false;
          }else if(livreController.getValidation().isEmpty( ((String) comboCat.getSelectedItem()))){
                JOptionPane.showMessageDialog(rootPane, "plz select a categorie  ");
                
                return false;
          }
               return true;
}
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(livreView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(livreView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(livreView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(livreView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new livreView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> affichageCombo;
    private javax.swing.JTextField auteurTxt;
    private javax.swing.JLabel champ1Txt;
    private javax.swing.JButton chercherBtn;
    private javax.swing.JTextField chercherTxt;
    private javax.swing.JButton clear;
    private javax.swing.JComboBox<String> comboCat;
    private javax.swing.JComboBox<String> comboSearch;
    private javax.swing.JTextField datePublicationTxt;
    private javax.swing.JTextField idLivreTxt;
    private javax.swing.JTextField isbnTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nbCopieTxt;
    private javax.swing.JButton sauvegarderBtn;
    private javax.swing.JButton supprimerBtn;
    private javax.swing.JTable tblDisplay;
    private javax.swing.JTextField titreTxt;
    private javax.swing.JComboBox<String> typeCombo;
    private javax.swing.JButton updateBtn;
    // End of variables declaration//GEN-END:variables
}
