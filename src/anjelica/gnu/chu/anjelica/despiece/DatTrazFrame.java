/**
 *
 * <p>Título: DatTrazFrame </p>
 * <p>Descripción: Frame que muestra los datos de trazabilidad de un individuo.
 * </p>
 * <p>Copyright: Copyright (c) 2005-2011
 *  Este programa es software libre. Puede redistribuirlo y/o modificarlo bajo
 *  los terminos de la Licencia Pública General de GNU según es publicada por
 *  la Free Software Foundation, bien de la versión 2 de dicha Licencia
 *  o bien (según su elección) de cualquier versión posterior.
 *  Este programa se distribuye con la esperanza de que sea útil,ed
 *  pero SIN NINGUNA GARANTIA, incluso sin la garantía MERCANTIL implícita
 *  o sin garantizar la CONVENIENCIA PARA UN PROPOSITO PARTICULAR.
 *  Véase la Licencia Pública General de GNU para más detalles.
 *  Debería haber recibido una copia de la Licencia Pública General junto con este programa.
 *  Si no ha sido así, escriba a la Free Software Foundation, Inc.,
 *  en 675 Mass Ave, Cambridge, MA 02139, EEUU.
 * </p>
 * <p>Empresa: miSL</p>
 * @author chuchiP
 * @version 1.0
 */
package gnu.chu.anjelica.despiece;

import gnu.chu.controles.CInternalFrame;
import gnu.chu.controles.StatusBar;
import gnu.chu.sql.DatosTabla;
import gnu.chu.utilidades.EntornoUsuario;
import gnu.chu.utilidades.ventana;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.sql.SQLException;
import javax.swing.JLayeredPane;

public class DatTrazFrame extends ventana {
   ventana papa;
  public DatTrazFrame() {
        initComponents();
  }
  public DatTrazFrame(EntornoUsuario e, JLayeredPane fr,ventana padre)
  {
    setTitulo("Datos Trazabilidad");
   
    EU = e;
    vl=fr;
    jf=padre.jf;
    papa=padre;
    try
    {
      jbInit();
    }
    catch (Exception k)
    {
      fatalError("constructor: ", k);
      setErrorInit(true);
    }
  }
 
 
  public void iniciar(DatosTabla dtStat, DatosTabla dtCon1,CInternalFrame intFrame,
                      JLayeredPane layPan, EntornoUsuario EU) throws SQLException
  {
        this.EU=EU;
        this.dtStat=dtStat;
        this.dtCon1=dtCon1;
        lotePanel.iniciar(dtStat, intFrame, layPan, EU);
        datTrazPanel.iniciar(dtStat, dtCon1, papa,layPan, EU);
        datTrazPanel.setEditable(false);
        lotePanel.setEditable(false);
        datTrazPanel.setVerDatosCompra(false);
        datTrazPanel.setLotePanel(lotePanel);
        datTrazPanel.setDatosCompraCheckBox(opDatCompra);
  }
  public void setDatos(int proCodi,String proSerie,int ejeNume,int proLote,int proNumind)
  {
      lotePanel.setDatos(proCodi,proSerie, ejeNume, proLote, proNumind);
      datTrazPanel.setDatos(proCodi, ejeNume, proSerie, proLote, proNumind);
  }
  public void actualizar() throws SQLException
  {
      datTrazPanel.actualizar();
  }
  public void mostrar()
  {
       setVisible(true);
       statusBar.setEnabled(true);
       toFront();
       setEnabled(true);
  }
  
  private void jbInit() throws Exception
  {
    statusBar = new StatusBar(this);
    iniciarFrame();
    
    this.setIconifiable(false);
    this.setResizable(false);
    this.setMaximizable(false);
    if (dtCon1 == null)
      conecta();
    initComponents();
     
    this.add(statusBar,BorderLayout.SOUTH);
    this.setSize(new Dimension(525, 275));
  }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Pprinc = new gnu.chu.controles.CPanel();
        datTrazPanel = new gnu.chu.camposdb.DatTrazPanel();
        opDatCompra = new gnu.chu.controles.CCheckBox();
        lotePanel = new gnu.chu.camposdb.LotePanel();

        Pprinc.setLayout(null);

        datTrazPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        datTrazPanel.setEditable(false);
        Pprinc.add(datTrazPanel);
        datTrazPanel.setBounds(0, 40, 510, 150);

        opDatCompra.setText("Ver Datos Compra");
        Pprinc.add(opDatCompra);
        opDatCompra.setBounds(380, 20, 130, 20);

        lotePanel.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        Pprinc.add(lotePanel);
        lotePanel.setBounds(0, 0, 370, 41);

        getContentPane().add(Pprinc, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private gnu.chu.controles.CPanel Pprinc;
    private gnu.chu.camposdb.DatTrazPanel datTrazPanel;
    private gnu.chu.camposdb.LotePanel lotePanel;
    private gnu.chu.controles.CCheckBox opDatCompra;
    // End of variables declaration//GEN-END:variables
}
