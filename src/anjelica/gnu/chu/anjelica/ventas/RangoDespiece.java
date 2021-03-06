package gnu.chu.anjelica.ventas;
/**
 *
 * <p>Titulo: RangoEtiquetas </p>
 * <p>Descripcion:Permite Realizar un autodespiece de todos los productos indicados .</p>
 * 
 * <p>Copyright: Copyright (c) 2005-2017
 *  Este programa es software libre. Puede redistribuirlo y/o modificarlo bajo
 *  los terminos de la Licencia Pública General de GNU según es publicada por
 *  la Free Software Foundation, bien de la versión 2 de dicha Licencia
 *  o bien (según su elección) de cualquier versión posterior.
 *  Este programa se distribuye con la esperanza de que sea útil,
 *  pero SIN NINGUNA GARANTIA, incluso sin la garantía MERCANTIL implícita
 *  o sin garantizar la CONVENIENCIA PARA UN PROPOSITO PARTICULAR.
 *  Véase la Licencia Pública General de GNU para más detalles.
 *  Debería haber recibido una copia de la Licencia Pública General junto con este programa.
 *  Si no ha sido así, escriba a la Free Software Foundation, Inc.,
 *  en 675 Mass Ave, Cambridge, MA 02139, EEUU.
 * </p>
 * @author chuchiP
 * @version 1.0
 * 
 */
import gnu.chu.anjelica.listados.etiqueta;
import gnu.chu.controles.StatusBar;
import gnu.chu.utilidades.Iconos;
import gnu.chu.utilidades.ventana;
import java.awt.BorderLayout;
import java.sql.SQLException;
import java.sql.Types;
import java.util.logging.Level;
import java.util.logging.Logger;


public class RangoDespiece extends ventana
{
    pdalbara padre;
    boolean aceptar=false;   
    
    public RangoDespiece() {
        initComponents();
        setResizable(false);
        setMaximizable(false);
        setIconifiable(false);
        this.setSize(400,150);
        statusBar = new StatusBar(this);
        this.getContentPane().add(statusBar, BorderLayout.SOUTH);
        setVisibleCabeceraVentana(false);                      
    }
  
    
    @Override
  public void matar()
  {
    setVisible(false);
   
    padre.setEnabled(true);
    padre.setFoco(null);
    try {
        padre.setSelected(true);
    } catch (Exception k){}
    muerto();
  }
  /**
   * Funcion llamada cuando la clase se ha muerto
   * A machacar para controlar que hacer despues.
   */
  public void muerto()
  {
      
  }
    public void iniciar(pdalbara papa) throws SQLException
    {
        this.padre=papa;
        EU=padre.EU;
        dtStat=padre.dtStat;
        dtCon1=padre.dtCon1;
        pro_codoriE.iniciar(dtStat, padre, padre.vl, EU);    
        pro_codfinE.iniciar(dtStat, padre, padre.vl, EU);    
    }
    
    public void reset() throws SQLException
    {
         aceptar=false;
         pro_codoriE.resetTexto();
         linInicE.setValorInt(0);
         linFinalE.setValorInt(0);
         pro_codfinE.resetTexto();
         pro_codoriE.requestFocusLater();
       
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        proPanel1 = new gnu.chu.camposdb.proPanel();
        Pprinc = new gnu.chu.controles.CPanel();
        cLabel1 = new gnu.chu.controles.CLabel();
        pro_codoriE = new gnu.chu.camposdb.proPanel();
        cLabel2 = new gnu.chu.controles.CLabel();
        linInicE = new gnu.chu.controles.CTextField(Types.DECIMAL,"##9");
        cLabel3 = new gnu.chu.controles.CLabel();
        linFinalE = new gnu.chu.controles.CTextField(Types.DECIMAL,"##9");
        opLinSelec = new gnu.chu.controles.CCheckBox();
        Aceptar = new gnu.chu.controles.CButton(Iconos.getImageIcon("check"));
        Bcancelar = new gnu.chu.controles.CButton(Iconos.getImageIcon("cancel"));
        cLabel4 = new gnu.chu.controles.CLabel();
        pro_codfinE = new gnu.chu.camposdb.proPanel();

        Pprinc.setLayout(null);

        cLabel1.setText("A Articulo");
        Pprinc.add(cLabel1);
        cLabel1.setBounds(10, 50, 60, 18);
        Pprinc.add(pro_codoriE);
        pro_codoriE.setBounds(70, 0, 290, 18);

        cLabel2.setText("Art.Origen");
        Pprinc.add(cLabel2);
        cLabel2.setBounds(10, 2, 60, 18);

        linInicE.setText("0");
        Pprinc.add(linInicE);
        linInicE.setBounds(60, 25, 30, 18);

        cLabel3.setText("A Linea");
        Pprinc.add(cLabel3);
        cLabel3.setBounds(100, 25, 50, 18);

        linFinalE.setText("0");
        Pprinc.add(linFinalE);
        linFinalE.setBounds(150, 25, 30, 18);

        opLinSelec.setText("Lineas Selecionadas");
        Pprinc.add(opLinSelec);
        opLinSelec.setBounds(220, 25, 130, 18);

        Aceptar.setText("Aceptar");
        Aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AceptarActionPerformed(evt);
            }
        });
        Pprinc.add(Aceptar);
        Aceptar.setBounds(100, 80, 90, 24);

        Bcancelar.setText("Cancelar");
        Bcancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BcancelarActionPerformed(evt);
            }
        });
        Pprinc.add(Bcancelar);
        Bcancelar.setBounds(190, 80, 90, 24);

        cLabel4.setText("De Linea");
        Pprinc.add(cLabel4);
        cLabel4.setBounds(10, 25, 50, 18);
        Pprinc.add(pro_codfinE);
        pro_codfinE.setBounds(70, 50, 300, 18);

        getContentPane().add(Pprinc, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AceptarActionPerformed
        
        try
        {
            if (!pro_codfinE.controla(true))
            {
                mensajeErr("Codigo final no es valido");
                pro_codfinE.requestFocus();
                return;
            }
            aceptar=true;
            matar();
        } catch (SQLException ex)
        {
            Error("Error al comprobar validez de datos",ex);
        }
    }//GEN-LAST:event_AceptarActionPerformed

    private void BcancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BcancelarActionPerformed
        aceptar=false;
        matar();
    }//GEN-LAST:event_BcancelarActionPerformed
    public boolean isAceptado()
    {
        return aceptar;
    }
    
    public int getArticuloOrigen()
    {
        return pro_codoriE.getValorInt();
    }
     public int getArticuloFinal()
    {
        return pro_codfinE.getValorInt();
    }
    public int getLineaInicial()
    {
        return linInicE.getValorInt();
    }
    public int getLineaFinal()
    {
        return linFinalE.getValorInt();
    }     
    public boolean getLineasSelecionadas()
    {
        return opLinSelec.isSelected();
    }   
    public void setLineasSelecionadas(boolean swSelec)
    {
        opLinSelec.setSelected(swSelec);
    }   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private gnu.chu.controles.CButton Aceptar;
    private gnu.chu.controles.CButton Bcancelar;
    private gnu.chu.controles.CPanel Pprinc;
    private gnu.chu.controles.CLabel cLabel1;
    private gnu.chu.controles.CLabel cLabel2;
    private gnu.chu.controles.CLabel cLabel3;
    private gnu.chu.controles.CLabel cLabel4;
    private gnu.chu.controles.CTextField linFinalE;
    private gnu.chu.controles.CTextField linInicE;
    private gnu.chu.controles.CCheckBox opLinSelec;
    private gnu.chu.camposdb.proPanel proPanel1;
    private gnu.chu.camposdb.proPanel pro_codfinE;
    private gnu.chu.camposdb.proPanel pro_codoriE;
    // End of variables declaration//GEN-END:variables
}
