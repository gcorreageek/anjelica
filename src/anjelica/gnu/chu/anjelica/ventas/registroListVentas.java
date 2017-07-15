/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gnu.chu.anjelica.ventas;

import gnu.chu.controles.StatusBar;
import gnu.chu.utilidades.ventana;
import java.awt.BorderLayout;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author cpuente
 */
public class registroListVentas extends ventana
{
    
    pdalbara padre;
    boolean aceptar=false;
    
    
 public registroListVentas() {
        initComponents();
        setResizable(false);
        setMaximizable(false);
        setIconifiable(false);
        this.setSize(480,350);
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
    }
    public void llenaGrid(int idAlbaran) throws SQLException
    {
        jt.removeAllDatos();
        String s="select r.*,men_nomb from registro as r, mensajes as m where reg_numdoc ="+idAlbaran+
            " and r.men_codi = m.men_codi"+
            " and r.men_codi like 'AV%' "+
            " order by reg_codi";
        if (!dtCon1.select(s))
            return;
        do
        {
            ArrayList v=new ArrayList();
            v.add(dtCon1.getFecha("reg_time","dd-MM-yy"));
            v.add(dtCon1.getFecha("reg_time","HH:mm"));
            v.add(dtCon1.getString("usu_nomb"));
            v.add(dtCon1.getString("men_nomb"));
            v.add(dtCon1.getString("reg_valor"));
            jt.addLinea(v);
        } while (dtCon1.next());
        jt.requestFocusInicio();
        statusBar.setEnabled(true);
    }
    /**
     * Creates new form registroListVentas
     */
   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        PPrinc = new gnu.chu.controles.CPanel();
        jt = new gnu.chu.controles.Cgrid(5);

        PPrinc.setLayout(new java.awt.GridBagLayout());

        ArrayList v=new ArrayList();
        v.add("Fecha");
        v.add("Hora");
        v.add("Usuario");
        v.add("Accion");
        v.add("Salida");
        jt.setCabecera(v);
        jt.setAnchoColumna(new int[]{50,40,60,70,250});
        jt.setAlinearColumna(new int[]{1,1,0,0,0});
        jt.setMaximumSize(new java.awt.Dimension(100, 100));
        jt.setMinimumSize(new java.awt.Dimension(100, 100));
        jt.setPreferredSize(new java.awt.Dimension(100, 100));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        PPrinc.add(jt, gridBagConstraints);

        getContentPane().add(PPrinc, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private gnu.chu.controles.CPanel PPrinc;
    private gnu.chu.controles.Cgrid jt;
    // End of variables declaration//GEN-END:variables
}
