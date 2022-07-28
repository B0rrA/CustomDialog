package com.B0rrA.Customize;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Date;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.LocalDate;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JTextField;

/**
 * Módulo para generar un JDialog personalizado
 * @author Gustavo Maciel
 * @version 3.3
 */
public class CustomDialog extends javax.swing.JDialog {

    private boolean confirmado=false;
    private boolean cancelado=false;
    private boolean soloNumeros=false;
    int decimales = 0;
    private Object resultado;
    private CardLayout cards;
    private final Color[] colores;
    
    
    /**
     * Crea un nuevo dialogo personalizado
     * @param parent Formulario desde el cual se llama
     * @param opciones Tipo de opciones de botones (usar opciones de jOptionPane)
     * @param componente Componente a mostrar. Se aceptan "textField" o "calendar"
     * @param título Título del dialogo
     * @param mensaje mensaje del dialogo
     * @param colores paleta de colores <p> 
     * <ol start="0">
     *  <li>Background</li>
     *  <li>Foreground</li>
     *  <li>BT Background </li>
     *  <li>BTS Background </li>
     *  <li>BTC Background </li>
     *  <li>BTCS Background </li>
     *  <li>BT Foreground </li>
     *  <li>Focus </li>
     * </ol>
     * @param ícono ícono
     */
    public CustomDialog(Frame parent,int opciones,String componente,String título,String mensaje,Color[] colores,ImageIcon ícono) {
        super(parent,true);
        initComponents();
        this.colores=colores;
        personalizar(componente,opciones,título,mensaje,ícono);
    }

    /** Método para personalizar el diálogo
     * 
     * @param componente Tipo de componenete en el diálogo: "textField","calendar","textArea"
     * @param opciones Opciones disponibles para los botones. 0: Si/No/Cancelar, 1: Si/NO, 3: Buscar, 4: Aceptar
     * @param título Título del diálogo
     * @param mensaje mensaje a mostrar
     * @param ícono imagen del diálogo
     */
    private void personalizar(String componente,int opciones,String título,String mensaje,ImageIcon ícono){
        /* Se asigna ícono */
        setIconImage(ícono.getImage());
        
        /* Se crean las vistas para la ventana principal */
        panelTipo.add(textField,"textField");
        panelTipo.add(calendar,"calendar");
        panelTipo.add(textArea,"textArea");
        cards=((CardLayout) panelTipo.getLayout());
        /*
        Se ajustan los mensajes y botones a mostrar 
        */
        this.setTitle(título);
        if (componente==null) {
            lblMensaje.setText(mensaje);
            panelTipo.setVisible(false);
        } else {
            if (componente.equals("textArea")) {
                lblMensaje.setVisible(false);
            } 
            lblMensaje.setText(mensaje);
            txtTexto.setText(mensaje);
            txtTexto.setCaretPosition(0);
            cards.show(panelTipo, componente);
        }
        switch(opciones) {
            case 0:
                btnPositivo.setText("Si");
                btnNegativo.setText("No");
                btnCancelar.setVisible(false);
                break;
            case 1:
                btnPositivo.setText("Si");
                btnNegativo.setText("No");
                break;
            case 3:
                btnPositivo.setText("Buscar");
                btnNegativo.setVisible(false);
                break;
            default:
                btnPositivo.setText("Aceptar");
                btnNegativo.setVisible(false);
                btnCancelar.setVisible(false);
                break;
        }
        
        panelPrincipal.setBackground(colores[0]);
        lblMensaje.setForeground(colores[1]);
        txtTexto.setForeground(colores[1]);
        btnPositivo.setBackground(colores[2]);
        btnNegativo.setBackground(colores[4]);
        btnCancelar.setBackground(colores[4]);
        
        /* Se asigna evento al cerrar el formulario */
        WindowListener exitListener = new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                btnCancelar.doClick();
            }
        };
        addWindowListener(exitListener);
    }
    
    /** Método para asignar si el campo aceptará solo números. FALSO por defecto
     * 
     * @param numeros TRUE para aceptar solo números. 
     */
    public void setSoloNúmeros(Boolean numeros) {
        soloNumeros = numeros;
    }
    
    /** Método para asignar si el campo aceptará solo números. FALSO por defecto
     * 
     * @param soloNumeros TRUE para aceptar solo números. 
     * @param cantidadDecimales cantidad de posiciones decimales a permitir.
     */
    public void setSoloNúmeros(Boolean soloNumeros,int cantidadDecimales) {
        this.soloNumeros = soloNumeros;
        this.decimales = cantidadDecimales;
    }
    
    /** Método para asignar el tamaño del diálogo
     * 
     * @param d tamaño a asignar
     */
    public void setTamaño(Dimension d) {
        this.setSize(d);
        this.setPreferredSize(d);
    }
    
    /** Método para estado del dialogo
     * 
     * @return TRUE si el dialogo ha sido confirmado, caso contrario FALSE
     */
    public Boolean confirmado() {
        return confirmado;
    }
    
    /** Método para comprobar si el dialogo ha sido cancelado
     * 
     * @return TRUE si el dialogo ha sido cancelado, caso contrario FALSE
     */
    public Boolean cancelado() {
        return cancelado;
    }
    
    /** Método para obtener el valor ingresado en el dialogo
     * 
     * @return valor ingresado por el usuario
     */
    public Object getResultado() {
        return resultado;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPrincipal = new javax.swing.JPanel();
        btnCancelar = new javax.swing.JButton();
        btnNegativo = new javax.swing.JButton();
        panelTipo = new javax.swing.JPanel();
        textField = new javax.swing.JPanel();
        txtInput = new javax.swing.JTextField();
        calendar = new javax.swing.JPanel();
        txtFecha = new com.toedter.calendar.JDateChooser();
        textArea = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtTexto = new javax.swing.JEditorPane();
        lblMensaje = new javax.swing.JLabel();
        btnPositivo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        panelPrincipal.setPreferredSize(new java.awt.Dimension(300, 175));

        btnCancelar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setText("Cancelar");
        btnCancelar.setOpaque(true);
        btnCancelar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                btnCancelarFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                btnCancelarFocusLost(evt);
            }
        });
        btnCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCancelarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCancelarMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnCancelarMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnCancelarMouseReleased(evt);
            }
        });
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        btnCancelar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnCancelarKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                btnCancelarKeyReleased(evt);
            }
        });

        btnNegativo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnNegativo.setForeground(new java.awt.Color(255, 255, 255));
        btnNegativo.setText("Negativo");
        btnNegativo.setNextFocusableComponent(btnCancelar);
        btnNegativo.setOpaque(true);
        btnNegativo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                btnNegativoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                btnNegativoFocusLost(evt);
            }
        });
        btnNegativo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnNegativoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnNegativoMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnNegativoMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnNegativoMouseReleased(evt);
            }
        });
        btnNegativo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNegativoActionPerformed(evt);
            }
        });
        btnNegativo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnNegativoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                btnNegativoKeyReleased(evt);
            }
        });

        panelTipo.setBackground(new java.awt.Color(102, 204, 255));
        panelTipo.setOpaque(false);
        panelTipo.setLayout(new java.awt.CardLayout());

        textField.setOpaque(false);

        txtInput.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 5, 0, 0));
        txtInput.setMinimumSize(new java.awt.Dimension(250, 16));
        txtInput.setNextFocusableComponent(btnPositivo);
        txtInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtInputActionPerformed(evt);
            }
        });
        txtInput.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtInputKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtInputKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout textFieldLayout = new javax.swing.GroupLayout(textField);
        textField.setLayout(textFieldLayout);
        textFieldLayout.setHorizontalGroup(
            textFieldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, textFieldLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(txtInput, javax.swing.GroupLayout.DEFAULT_SIZE, 389, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        textFieldLayout.setVerticalGroup(
            textFieldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(textFieldLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtInput, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        panelTipo.add(textField, "card1");

        calendar.setOpaque(false);

        txtFecha.setDate(Date.valueOf(LocalDate.now())
        );
        txtFecha.setDateFormatString("dd-MM-yyyy");
        txtFecha.setNextFocusableComponent(btnPositivo);
        txtFecha.setOpaque(false);
        txtFecha.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtFechaFocusGained(evt);
            }
        });
        txtFecha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFechaKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout calendarLayout = new javax.swing.GroupLayout(calendar);
        calendar.setLayout(calendarLayout);
        calendarLayout.setHorizontalGroup(
            calendarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, calendarLayout.createSequentialGroup()
                .addContainerGap(102, Short.MAX_VALUE)
                .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(107, Short.MAX_VALUE))
        );
        calendarLayout.setVerticalGroup(
            calendarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(calendarLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        panelTipo.add(calendar, "card2");

        jScrollPane2.setBorder(null);

        txtTexto.setContentType("text"); // NOI18N
        txtTexto.setText("");
        txtTexto.setToolTipText("");
        jScrollPane2.setViewportView(txtTexto);

        javax.swing.GroupLayout textAreaLayout = new javax.swing.GroupLayout(textArea);
        textArea.setLayout(textAreaLayout);
        textAreaLayout.setHorizontalGroup(
            textAreaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 374, Short.MAX_VALUE)
            .addGroup(textAreaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane2))
        );
        textAreaLayout.setVerticalGroup(
            textAreaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 54, Short.MAX_VALUE)
            .addGroup(textAreaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE))
        );

        panelTipo.add(textArea, "card3");

        lblMensaje.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblMensaje.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMensaje.setText("Mensaje");
        lblMensaje.setMinimumSize(new java.awt.Dimension(0, 20));

        btnPositivo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnPositivo.setForeground(new java.awt.Color(255, 255, 255));
        btnPositivo.setText("Positivo");
        btnPositivo.setNextFocusableComponent(btnNegativo);
        btnPositivo.setOpaque(true);
        btnPositivo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                btnPositivoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                btnPositivoFocusLost(evt);
            }
        });
        btnPositivo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnPositivoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnPositivoMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnPositivoMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnPositivoMouseReleased(evt);
            }
        });
        btnPositivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPositivoActionPerformed(evt);
            }
        });
        btnPositivo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnPositivoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                btnPositivoKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelTipo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(lblMensaje, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPrincipalLayout.createSequentialGroup()
                        .addComponent(btnPositivo, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnNegativo, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                        .addGap(2, 2, 2)))
                .addGap(15, 15, 15))
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblMensaje, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelTipo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNegativo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPositivo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void btnNegativoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNegativoActionPerformed
        confirmado=false;
        cancelado=false;
        dispose();
    }//GEN-LAST:event_btnNegativoActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        confirmado=false;
        cancelado=true;
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnNegativoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNegativoMouseEntered
        btnNegativo.setBorder(BorderFactory.createLineBorder(colores[7],2));
    }//GEN-LAST:event_btnNegativoMouseEntered

    private void btnCancelarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseEntered
        btnCancelar.setBorder(BorderFactory.createLineBorder(colores[7],2));
    }//GEN-LAST:event_btnCancelarMouseEntered

    private void btnNegativoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNegativoMouseExited
        btnNegativo.setBorder(null);
    }//GEN-LAST:event_btnNegativoMouseExited

    private void btnCancelarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseExited
        btnCancelar.setBorder(null);
    }//GEN-LAST:event_btnCancelarMouseExited

    private void btnNegativoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_btnNegativoFocusGained
        btnNegativo.setBorder(BorderFactory.createLineBorder(colores[7],2));
    }//GEN-LAST:event_btnNegativoFocusGained

    private void btnCancelarFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_btnCancelarFocusGained
        btnCancelar.setBorder(BorderFactory.createLineBorder(colores[7],2));
    }//GEN-LAST:event_btnCancelarFocusGained

    private void btnNegativoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_btnNegativoFocusLost
        btnNegativo.setBorder(null);
    }//GEN-LAST:event_btnNegativoFocusLost

    private void btnCancelarFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_btnCancelarFocusLost
        btnCancelar.setBorder(null);
    }//GEN-LAST:event_btnCancelarFocusLost

    private void btnNegativoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNegativoMousePressed
        btnNegativo.setBackground(colores[5]);
    }//GEN-LAST:event_btnNegativoMousePressed

    private void btnCancelarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMousePressed
        btnCancelar.setBackground(colores[5]);
    }//GEN-LAST:event_btnCancelarMousePressed

    private void btnNegativoMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNegativoMouseReleased
        btnNegativo.setBackground(colores[4]);
    }//GEN-LAST:event_btnNegativoMouseReleased

    private void btnCancelarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseReleased
        btnCancelar.setBackground(colores[4]);
    }//GEN-LAST:event_btnCancelarMouseReleased

    private void btnNegativoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnNegativoKeyPressed
        switch (evt.getKeyCode()) {
            case 32:
                evt.getComponent().setBackground(colores[3]);
                break;
            case 10:
                btnNegativoActionPerformed(null);
                break;
            default:
                break;
        }
    }//GEN-LAST:event_btnNegativoKeyPressed

    private void btnCancelarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnCancelarKeyPressed
        switch (evt.getKeyCode()) {
            case 32:
                evt.getComponent().setBackground(colores[3]);
                break;
            case 10:
                btnCancelarActionPerformed(null);
                break;
            default:
                break;
        }
    }//GEN-LAST:event_btnCancelarKeyPressed

    private void btnNegativoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnNegativoKeyReleased
        evt.getComponent().setBackground(colores[4]);
        switch(evt.getKeyCode()) {
            case 37:
                btnPositivo.requestFocus();
                break;
            case 38:
                if (textField.isShowing()==true) {
                    txtInput.requestFocus();
                } else {
                    txtFecha.requestFocus();
                }
                break;
            case 39:
                evt.getComponent().transferFocus();
                break;
            case 40:
                break;
            default:
                break;
        }
    }//GEN-LAST:event_btnNegativoKeyReleased

    private void btnCancelarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnCancelarKeyReleased
        evt.getComponent().setBackground(colores[4]);
        switch(evt.getKeyCode()) {
            case 37:
                if (btnNegativo.isVisible()==true) {
                    btnNegativo.requestFocus();
                } else {
                    btnPositivo.requestFocus();
                }
                break;
            case 38:
                if (textField.isShowing()==true) {
                    txtInput.requestFocus();
                } else {
                    txtFecha.requestFocus();
                }
                break;
            case 39:
                break;
            case 40:
                break;
            default:
                break;
        }
    }//GEN-LAST:event_btnCancelarKeyReleased

    private void txtFechaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFechaFocusGained
        txtFecha.requestFocusInWindow();
    }//GEN-LAST:event_txtFechaFocusGained

    private void txtInputKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtInputKeyReleased
        switch(evt.getKeyCode()) {
            case 37:
                break;
            case 38:
                break;
            case 39:
                break;
            case 40:
                evt.getComponent().transferFocus();
                break;
            default:
                break;
        }
    }//GEN-LAST:event_txtInputKeyReleased

    private void txtInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtInputActionPerformed
        btnPositivo.doClick();
    }//GEN-LAST:event_txtInputActionPerformed

    private void txtInputKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtInputKeyTyped
        if (soloNumeros) {
            JTextField txt = txtInput;
            DecimalFormatSymbols dfs = new DecimalFormatSymbols();
            dfs.setGroupingSeparator('.');
            dfs.setDecimalSeparator(',');
            DecimalFormat df;
            //<editor-fold defaultstate="collapsed" desc="Se crean los formatos teniendo en cuenta la cantidad de decimales">
            switch (decimales) {
                case 1:
                    df= new DecimalFormat("###,###.#",dfs);
                    break;
                case 2:
                    df= new DecimalFormat("###,###.##",dfs);
                    break;
                case 3:
                    df= new DecimalFormat("###,###.###",dfs);
                    break;
                case 4:
                    df= new DecimalFormat("###,###.####",dfs);
                    break;
                case 5:
                    df= new DecimalFormat("###,###.#####",dfs);
                    break;
                case 6:
                    df= new DecimalFormat("###,###.######",dfs);
                    break;
                default:
                    df= new DecimalFormat("###,###",dfs);
                    break;
            }
            //</editor-fold>
            String t = txt.getText();
            switch (evt.getKeyCode()) {
                case 8://borrar
                    if (!t.isEmpty() || txt.getCaretPosition()>0) {
                        if (!t.contains(",") || txt.getCaretPosition()!=t.length()) {
                            int posicion=txt.getCaretPosition();
                            int tamañoa=t.length();
                            Double c = Double.valueOf(txt.getText().replace(".", "").replace(",","."));
                            txt.setText(df.format(c));
                            String b = txt.getText();
                            int tamañob=b.length();
                            int cambios=tamañob-tamañoa;
                            txt.setCaretPosition(posicion+cambios);
                        }
                    }
                    break;
                case 37://atras
                case 38://arriba
                case 39://adelante
                case 40://abajo
                    break;
                case 96://cero
                    if (!t.isEmpty()) {
                        if (!t.contains(",") || txt.getCaretPosition()!=t.length()) {
                            int posicion=txt.getCaretPosition();
                            int tamañoa=t.length();
                            Double c = Double.valueOf(txt.getText().replace(".", "").replace(",","."));
                            txt.setText(df.format(c));
                            String b = txt.getText();
                            int tamañob=b.length();
                            int cambios=tamañob-tamañoa;
                            txt.setCaretPosition(posicion+cambios);
                        }
                    }
                    break;
                case 44://coma
                    if (t.isEmpty()) {
                        txt.setText("0,");
                    } else {
                        if (!t.contains(",")) {
                            txt.setText(t+",");
                        } 
                    }
                    break;
                case 110://punto
                    if (t.isEmpty()) {
                        txt.setText("0,");
                    } else {
                        if (!t.contains(",")) {
                            txt.setText(t+",");
                        } 
                    }
                    break;
                default:
                    if (!t.isEmpty()) {
                        int posicion=txt.getCaretPosition();
                        int tamañoa=t.length();
                        Double c = Double.valueOf(txt.getText().replace(".", "").replace(",","."));
                        txt.setText(df.format(c));
                        String b = txt.getText();
                        int tamañob=b.length();
                        int cambios=tamañob-tamañoa;
                        txt.setCaretPosition(posicion+cambios);
                    }
                    break;
            }
        }
    }//GEN-LAST:event_txtInputKeyTyped

    private void btnPositivoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnPositivoKeyReleased
        evt.getComponent().setBackground(colores[2]);
        switch(evt.getKeyCode()) {
            case 37:
            break;
            case 38:
            if (textField.isShowing()==true) {
                txtInput.requestFocus();
            } else {
                txtFecha.requestFocus();
            }
            break;
            case 39:
            evt.getComponent().transferFocus();
            break;
            case 40:
            break;
            default:
            break;
        }
    }//GEN-LAST:event_btnPositivoKeyReleased

    private void btnPositivoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnPositivoKeyPressed
        switch (evt.getKeyCode()) {
            case 32:
                evt.getComponent().setBackground(colores[3]);
                break;
            case 10:
                btnPositivoActionPerformed(null);
                break;
            default:
                break;
        }
    }//GEN-LAST:event_btnPositivoKeyPressed

    private void btnPositivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPositivoActionPerformed
        // asigna confirmado a verdadero
        confirmado=true;
        // asigna el resultado
        if (textField.isShowing()) {
            resultado=txtInput.getText();
        } else if (txtTexto.isShowing()) {
            resultado=txtTexto.getText();
        } else {
            resultado=txtFecha.getDate();
        }
        dispose();
    }//GEN-LAST:event_btnPositivoActionPerformed

    private void btnPositivoMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPositivoMouseReleased
        btnPositivo.setBackground(colores[2]);
    }//GEN-LAST:event_btnPositivoMouseReleased

    private void btnPositivoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPositivoMousePressed
        btnPositivo.setBackground(colores[3]);
    }//GEN-LAST:event_btnPositivoMousePressed

    private void btnPositivoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPositivoMouseExited
        btnPositivo.setBorder(null);
    }//GEN-LAST:event_btnPositivoMouseExited

    private void btnPositivoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPositivoMouseEntered
        btnPositivo.setBorder(BorderFactory.createLineBorder(colores[7],2));
    }//GEN-LAST:event_btnPositivoMouseEntered

    private void btnPositivoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_btnPositivoFocusLost
        btnPositivo.setBorder(null);
    }//GEN-LAST:event_btnPositivoFocusLost

    private void btnPositivoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_btnPositivoFocusGained
        btnPositivo.setBorder(BorderFactory.createLineBorder(colores[7],2));
    }//GEN-LAST:event_btnPositivoFocusGained

    private void txtFechaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFechaKeyReleased
        if (evt.getKeyCode()==10) {
            txtFecha.getCalendarButton().doClick();
        }
    }//GEN-LAST:event_txtFechaKeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnNegativo;
    private javax.swing.JButton btnPositivo;
    private javax.swing.JPanel calendar;
    private javax.swing.JScrollPane jScrollPane2;
    public static javax.swing.JLabel lblMensaje;
    private javax.swing.JPanel panelPrincipal;
    public static javax.swing.JPanel panelTipo;
    private javax.swing.JPanel textArea;
    private javax.swing.JPanel textField;
    private com.toedter.calendar.JDateChooser txtFecha;
    private javax.swing.JTextField txtInput;
    private javax.swing.JEditorPane txtTexto;
    // End of variables declaration//GEN-END:variables
}
