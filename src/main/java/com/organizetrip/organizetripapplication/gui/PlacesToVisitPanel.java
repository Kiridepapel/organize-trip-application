package com.organizetrip.organizetripapplication.gui;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

import com.organizetrip.organizetripapplication.classes.PlaceToVisit;
import com.organizetrip.organizetripapplication.classes.UserInfo;

public class PlacesToVisitPanel extends javax.swing.JPanel {
    private UserInfo userInfo;
    private List<PlaceToVisit> places;
    private List<String> placesToVisit;

    /**
     * Creates new form PlacesToVisitPanel
     */
    public PlacesToVisitPanel(UserInfo userInfo) {
        this.userInfo = userInfo;
        placesToVisit = new ArrayList<>();
        initPlaces();
        initComponents();
        initCmb();
    }

    private void initPlaces() {
        places = List.of(
            PlaceToVisit.builder()
                .name("Catedral de Santa Marta")
                .imgPath("/assets/images/0_catedral_san_marta.jpg")
                .description("La Catedral Basílica de Santa Marta es un templo católico de estilo neoclásico situado en la ciudad de Santa Marta, Colombia. Es la sede de la Arquidiócesis de Santa Marta.")
                .build(),
            PlaceToVisit.builder()
                .name("Parque Nacional Natural Tayrona")
                .imgPath("/assets/images/1_parque_nacional_tayrona.jpg")
                .description("El Parque Nacional Natural Tayrona es un área protegida en la costa norte de Colombia, en el departamento de Magdalena, a 34 km de la ciudad de Santa Marta.")
                .build(),
            PlaceToVisit.builder() // 450 x 360
                .name("Quinta de San Pedro Alejandrino")
                .imgPath("/assets/images/2_quinta_san_pedro_alejandrino.jpg")
                .description("La Quinta de San Pedro Alejandrino es una hacienda colonial situada en la ciudad de Santa Marta, Colombia. Es conocida por ser el lugar donde murió el libertador Simón Bolívar.")
                .build(),
            PlaceToVisit.builder()
                .name("Sierra Nevada de Santa Marta")
                .imgPath("/assets/images/3_sierra_nevada_santa_marta.jpg")
                .description("La Sierra Nevada de Santa Marta es una formación montañosa ubicada en la región norte de Colombia, en los departamentos de Magdalena, Cesar y La Guajira.")
                .build(),
            PlaceToVisit.builder()
                .name("Playa Blanca")
                .imgPath("/assets/images/4_playa_blanca.jpg")
                .description("Playa Blanca es una playa situada en la isla de Barú, en el Caribe colombiano. Es conocida por sus aguas cristalinas y su arena blanca.")
                .build(),
            PlaceToVisit.builder()
                .name("Museo del Oro Tairona")
                .imgPath("/assets/images/5_museo_oro_tairona.jpg")
                .description("El Museo del Oro Tairona es un museo arqueológico situado en la ciudad de Santa Marta, Colombia. Alberga una colección de objetos de oro y cerámica de la cultura tairona.")
                .build(),
            PlaceToVisit.builder()
                .name("Bahía Concha")
                .imgPath("/assets/images/6_bahia_concha.jpg")
                .description("Bahía Concha es una playa situada en el Parque Nacional Natural Tayrona, en la costa norte de Colombia. Es conocida por sus aguas cristalinas y su arena blanca.")
                .build(),
            PlaceToVisit.builder()
                .name("Cascada de Marinka")
                .imgPath("/assets/images/7_cascada_marinka.jpg")
                .description("La Cascada de Marinka es una cascada situada en la Sierra Nevada de Santa Marta, en el norte de Colombia. Es conocida por su belleza natural y su entorno selvático.")
                .build(),
            PlaceToVisit.builder()
                .name("Centro Histórico de Santa Marta")
                .imgPath("/assets/images/8_centro_historico_santa_marta.jpg")
                .description("El Centro Histórico de Santa Marta es el casco antiguo de la ciudad de Santa Marta, Colombia. Es conocido por su arquitectura colonial y sus calles empedradas.")
                .build(),
            PlaceToVisit.builder()
                .name("Pueblito Chairama")
                .imgPath("/assets/images/9_pueblito_chairama.jpg")
                .description("Pueblito Chairama es un sitio arqueológico situado en la Sierra Nevada de Santa Marta, en el norte de Colombia. Es conocido por sus terrazas y sus construcciones de piedra.")
                .build()
        );
    }

    private void verifyIfExist() {
        // El elemento no existe en la lista
        if (!placesToVisit.contains(cmbLocations.getSelectedItem().toString())) {
            btnAdd.setEnabled(true);
            btnAdd.setBackground(new java.awt.Color(3, 139, 255));
            btnRemove.setEnabled(false);
            btnRemove.setBackground(new java.awt.Color(204, 204, 204));
        } else {
            // El elemento ya existe en la lista
            btnRemove.setEnabled(true);
            btnRemove.setBackground(new java.awt.Color(255, 102, 102));
            btnAdd.setEnabled(false);
            btnAdd.setBackground(new java.awt.Color(204, 204, 204));
        }
    }

    private void initCmb() {
        cmbLocations.removeAllItems();
        places.forEach(place -> cmbLocations.addItem(place.getName()));
        
        // Para el primer elemento
        lblImg.setIcon(new ImageIcon(getClass().getResource(places.get(0).getImgPath())));
        txtArea.setText(places.get(0).getDescription());
        verifyIfExist();

        // Para todos los elementos cada vez que se seleccione uno dentro del combobox
        cmbLocations.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    int index = cmbLocations.getSelectedIndex();
                    lblImg.setIcon(new ImageIcon(getClass().getResource(places.get(index).getImgPath())));
                    txtArea.setText(places.get(index).getDescription());
                    verifyIfExist();
                }
            }
        });
        cmbSelectedLocations.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    // seleccionar el item seleccionado aca, en cmbLocations
                    cmbLocations.setSelectedItem(cmbSelectedLocations.getSelectedItem());
                    verifyIfExist();
                }
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        pnContent = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblTitle1 = new javax.swing.JLabel();
        lblImg = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtArea = new javax.swing.JEditorPane();
        cmbLocations = new javax.swing.JComboBox<>();
        btnAdd = new com.organizetrip.organizetripapplication.classes.button.Button();
        btnRemove = new com.organizetrip.organizetripapplication.classes.button.Button();
        cmbSelectedLocations = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();

        bg.setBackground(new java.awt.Color(27, 27, 27));

        pnContent.setBackground(new java.awt.Color(27, 27, 27));

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Selecciona los lugares turísticos que te gustaría visitar:");

        lblTitle1.setBackground(java.awt.Color.white);
        lblTitle1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lblTitle1.setForeground(new java.awt.Color(3, 139, 255));
        lblTitle1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle1.setText("LUGARES TURÍSTICOS A VISITAR");

        lblImg.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lblImg.setForeground(java.awt.Color.white);
        lblImg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblImg.setText("Esperando a cargar imagen...");

        txtArea.setEditable(false);
        txtArea.setBackground(new java.awt.Color(27, 27, 27));
        txtArea.setBorder(null);
        txtArea.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtArea.setForeground(java.awt.Color.white);
        txtArea.setText("Esperando descripcion...");
        txtArea.setToolTipText("");
        txtArea.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jScrollPane1.setViewportView(txtArea);

        btnAdd.setBackground(new java.awt.Color(204, 204, 204));
        btnAdd.setBorder(null);
        btnAdd.setForeground(java.awt.Color.white);
        btnAdd.setText("Agregar a la lista");
        btnAdd.setEnabled(false);
        btnAdd.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btnAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddMouseClicked(evt);
            }
        });

        btnRemove.setBackground(new java.awt.Color(204, 204, 204));
        btnRemove.setBorder(null);
        btnRemove.setForeground(java.awt.Color.white);
        btnRemove.setText("Eliminar de la lista");
        btnRemove.setEnabled(false);
        btnRemove.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btnRemove.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRemoveMouseClicked(evt);
            }
        });

        cmbSelectedLocations.setEnabled(false);

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Lugares seleccionados:");

        javax.swing.GroupLayout pnContentLayout = new javax.swing.GroupLayout(pnContent);
        pnContent.setLayout(pnContentLayout);
        pnContentLayout.setHorizontalGroup(
            pnContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTitle1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnContentLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(pnContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnContentLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnContentLayout.createSequentialGroup()
                        .addGroup(pnContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbLocations, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 428, Short.MAX_VALUE)
                            .addComponent(btnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnRemove, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbSelectedLocations, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(lblImg, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44))))
        );
        pnContentLayout.setVerticalGroup(
            pnContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnContentLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(lblTitle1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cmbLocations, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(pnContentLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbSelectedLocations, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblImg, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37))
        );

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnContent, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddMouseClicked
        placesToVisit.add(cmbLocations.getSelectedItem().toString());
        userInfo.setPlacesToVisit(placesToVisit);
        // Estilos
        verifyIfExist();
        // Actualiza el combobox de lugares seleccionados
        updateCmbSelectedPlaces();
    }//GEN-LAST:event_btnAddMouseClicked

    private void btnRemoveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRemoveMouseClicked
        placesToVisit.remove(cmbLocations.getSelectedItem().toString());
        userInfo.setPlacesToVisit(placesToVisit);
        // Estilos
        verifyIfExist();
        // Actualiza el combobox de lugares seleccionados
        updateCmbSelectedPlaces();
    }//GEN-LAST:event_btnRemoveMouseClicked

    private void updateCmbSelectedPlaces() {
        cmbSelectedLocations.removeAllItems();
        placesToVisit.forEach(place -> cmbSelectedLocations.addItem(place));
        cmbSelectedLocations.setSelectedItem(-1);
        // Activa o desactiva el combobox de lugares seleccionados
        if (placesToVisit.size() > 0) cmbSelectedLocations.setEnabled(true);
        else cmbSelectedLocations.setEnabled(false);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    private com.organizetrip.organizetripapplication.classes.button.Button btnAdd;
    private com.organizetrip.organizetripapplication.classes.button.Button btnRemove;
    private javax.swing.JComboBox<String> cmbLocations;
    private javax.swing.JComboBox<String> cmbSelectedLocations;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblImg;
    private javax.swing.JLabel lblTitle1;
    private javax.swing.JPanel pnContent;
    private javax.swing.JEditorPane txtArea;
    // End of variables declaration//GEN-END:variables
}
