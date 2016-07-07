

package gnu.chu.anjelica.compras;

import gnu.chu.Menu.Principal;
import gnu.chu.anjelica.pad.MantPaises;
import gnu.chu.anjelica.pad.pdempresa;
import gnu.chu.controles.StatusBar;
import gnu.chu.interfaces.PAD;
import gnu.chu.utilidades.EntornoUsuario;
import gnu.chu.utilidades.navegador;
import gnu.chu.utilidades.ventanaPad;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Vector;

/**
 *
 * <p>Título: MantReclPrv</p>
 * <p>Descripción: Mantenimiento Reclamaciones Proveedores</p>
 * 
 * <p> Creado a partir pdalbaco2</p>
 *  <p>Copyright: Copyright (c) 2005-2016
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
 * <p>Empresa: MISL</p>
 * @author Chuchi P
 * @version 1.0
 */
public class MantReclPrv extends ventanaPad implements PAD
{
  boolean ARG_MODCONSULTA=false;
  public MantReclPrv(EntornoUsuario eu, Principal p)
  {
    this(eu,p,null);
  }

  public MantReclPrv(EntornoUsuario eu, Principal p, Hashtable ht)
  {
      EU = eu;
      vl = p.panel1;
      jf = p;
      eje = true;     

      try
      {
        ponParametros(ht);

        if (jf.gestor.apuntar(this))
          jbInit();
        else
          setErrorInit(true);
      }
      catch (Exception e)
      {
        ErrorInit(e);
      }
    }
    public MantReclPrv(gnu.chu.anjelica.menu p, EntornoUsuario eu)
    {
        this(p,eu,null);
    }
    
    public MantReclPrv(gnu.chu.anjelica.menu p, EntornoUsuario eu,Hashtable ht)
    {
      EU = eu;
      vl = p.getLayeredPane();
      
      eje = false;
      ponParametros(ht);
      try
      {
        jbInit();
      }
      catch (Exception e)
      {
        ErrorInit(e);
      }
    }
    
    
     
    
    private void ponParametros(Hashtable ht)
    {
         setTitulo("Mant. Reclamación Proveedores"); 
    }
    private void jbInit() throws Exception
    { 
      this.setVersion("2016-05-23" + (ARG_MODCONSULTA ? " SOLO LECTURA" : ""));
      statusBar = new StatusBar(this);
      nav = new navegador(this,dtCons,false);
      iniciarFrame();
      strSql = "SELECT tar_fecini,tar_fecfin,tar_codi FROM tarifa"+
          " group by tar_fecini,tar_fecfin,tar_codi" +
          " order by tar_fecini,tar_codi";
      this.getContentPane().add(nav, BorderLayout.NORTH);
      this.getContentPane().add(statusBar, BorderLayout.SOUTH);
      this.setPad(this);
      navActivarAll();
      dtCons.setLanzaDBCambio(false);
      initComponents();
      iniciarBotones(Baceptar, Bcancelar);
      this.setSize(new Dimension(582,522));
      conecta();
      activar(false);
      if (ARG_MODCONSULTA)
      {
        nav.removeBoton(navegador.ADDNEW);
        nav.removeBoton(navegador.EDIT);
        nav.removeBoton(navegador.DELETE);
      }
//      statusBar.add(Bimpri, new GridBagConstraints(9, 0, 1, 2, 0.0, 0.0
//                            , GridBagConstraints.EAST,
//                            GridBagConstraints.VERTICAL,
//                            new Insets(0, 5, 0, 0), 0, 0));

    }
    @Override
    public void iniciarVentana() throws Exception
    {
      pro_codiE.iniciar(dtStat, this, vl, EU);
      pro_codiE.setEnabledNombre(true);
      activarEventos();
      activar(false);
      acc_idE.iniciar(dtStat,this,vl,EU);
//      verDatos();p
      nav.requestFocus();
      Pprinc.setDefButton(Baceptar);
//      Pprinc.setEscButton(Bcancelar);
    }

    void activarEventos()
    {
        
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rpn_comentE = new gnu.chu.controles.CTextField(Types.CHAR,"X",100);
        rpn_fechaE = new gnu.chu.controles.CTextField();
        Pprinc = new gnu.chu.controles.CPanel();
        Pcabe = new gnu.chu.controles.CPanel();
        cLabel1 = new gnu.chu.controles.CLabel();
        rpv_codiE = new gnu.chu.controles.CTextField(Types.DECIMAL,"#,###,##9");
        cLabel2 = new gnu.chu.controles.CLabel();
        acc_idE = new gnu.chu.camposdb.AccPanel();
        cLabel3 = new gnu.chu.controles.CLabel();
        par_codiE = new gnu.chu.controles.CTextField(Types.DECIMAL,"#,###,##9");
        pal_codiE = new gnu.chu.controles.CTextField(Types.DECIMAL,"##9");
        Bincidenc = new gnu.chu.controles.CButton();
        cLabel4 = new gnu.chu.controles.CLabel();
        pro_codiE = new gnu.chu.camposdb.proPanel();
        cLabel5 = new gnu.chu.controles.CLabel();
        rpv_kilosE = new gnu.chu.controles.CTextField(Types.DECIMAL,"###,##9.99");
        cLabel6 = new gnu.chu.controles.CLabel();
        rpv_precioE = new gnu.chu.controles.CTextField(Types.DECIMAL,"##9.999");
        rpv_kiloriE = new gnu.chu.controles.CTextField(Types.DECIMAL,"###,##9.99");
        rpv_precoriE = new gnu.chu.controles.CTextField(Types.DECIMAL,"##9.999");
        cLabel7 = new gnu.chu.controles.CLabel();
        cLabel8 = new gnu.chu.controles.CLabel();
        cLabel9 = new gnu.chu.controles.CLabel();
        rpv_kilaceE = new gnu.chu.controles.CTextField(Types.DECIMAL,"###,##9.99");
        rpv_preaceE = new gnu.chu.controles.CTextField(Types.DECIMAL,"##9.999");
        cLabel10 = new gnu.chu.controles.CLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        rpv_comentE = new gnu.chu.controles.CTextArea();
        cLabel11 = new gnu.chu.controles.CLabel();
        rpv_estadE = new gnu.chu.controles.CComboBox();
        jt = new gnu.chu.controles.CGridEditable(2);
        Baceptar = new gnu.chu.controles.CButton();
        Bcancelar = new gnu.chu.controles.CButton();

        rpn_fechaE.setEnabled(false);

        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        Pprinc.setLayout(null);

        Pcabe.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        Pcabe.setLayout(null);

        cLabel1.setText("Estado");
        Pcabe.add(cLabel1);
        cLabel1.setBounds(450, 22, 60, 15);
        Pcabe.add(rpv_codiE);
        rpv_codiE.setBounds(130, 2, 60, 17);

        cLabel2.setText("Codigo Reclamación ");
        Pcabe.add(cLabel2);
        cLabel2.setBounds(10, 2, 120, 15);
        Pcabe.add(acc_idE);
        acc_idE.setBounds(250, 2, 120, 18);

        cLabel3.setText("Albaran");
        Pcabe.add(cLabel3);
        cLabel3.setBounds(200, 2, 50, 15);
        Pcabe.add(par_codiE);
        par_codiE.setBounds(440, 2, 60, 17);
        Pcabe.add(pal_codiE);
        pal_codiE.setBounds(505, 2, 30, 17);

        Bincidenc.setToolTipText("Buscar Incidencias");
        Pcabe.add(Bincidenc);
        Bincidenc.setBounds(540, 2, 18, 18);

        cLabel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cLabel4.setText("Comentario");
        Pcabe.add(cLabel4);
        cLabel4.setBounds(240, 40, 330, 17);
        Pcabe.add(pro_codiE);
        pro_codiE.setBounds(70, 22, 370, 17);

        cLabel5.setText("Articulo");
        Pcabe.add(cLabel5);
        cLabel5.setBounds(10, 22, 60, 15);
        Pcabe.add(rpv_kilosE);
        rpv_kilosE.setBounds(80, 60, 70, 17);

        cLabel6.setText("Original");
        Pcabe.add(cLabel6);
        cLabel6.setBounds(10, 80, 70, 15);
        Pcabe.add(rpv_precioE);
        rpv_precioE.setBounds(170, 60, 40, 17);
        Pcabe.add(rpv_kiloriE);
        rpv_kiloriE.setBounds(80, 80, 70, 17);
        Pcabe.add(rpv_precoriE);
        rpv_precoriE.setBounds(170, 80, 40, 17);

        cLabel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cLabel7.setText("Kilos ");
        Pcabe.add(cLabel7);
        cLabel7.setBounds(80, 40, 70, 17);

        cLabel8.setText("Aceptado");
        Pcabe.add(cLabel8);
        cLabel8.setBounds(10, 100, 70, 15);

        cLabel9.setText("Solicitado");
        Pcabe.add(cLabel9);
        cLabel9.setBounds(10, 60, 70, 15);
        Pcabe.add(rpv_kilaceE);
        rpv_kilaceE.setBounds(80, 100, 70, 17);
        Pcabe.add(rpv_preaceE);
        rpv_preaceE.setBounds(170, 100, 40, 17);

        cLabel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cLabel10.setText("Precio");
        Pcabe.add(cLabel10);
        cLabel10.setBounds(160, 40, 70, 17);

        rpv_comentE.setColumns(20);
        rpv_comentE.setRows(5);
        jScrollPane1.setViewportView(rpv_comentE);

        Pcabe.add(jScrollPane1);
        jScrollPane1.setBounds(240, 60, 330, 60);

        cLabel11.setText("Incidencia");
        Pcabe.add(cLabel11);
        cLabel11.setBounds(380, 2, 60, 15);

        rpv_estadE.addItem("Pendiente","0");
        rpv_estadE.addItem("Realizado","1");
        rpv_estadE.addItem("Rechazado","2");
        Pcabe.add(rpv_estadE);
        rpv_estadE.setBounds(500, 22, 70, 18);

        Pprinc.add(Pcabe);
        Pcabe.setBounds(10, 0, 580, 130);

        ArrayList v=new ArrayList();
        v.add("Fecha");
        v.add("Comentario");
        jt.setCabecera(v);
        jt.setAnchoColumna(new int[]{90,400});
        jt.setAlinearColumna(new int[]{0,0});
        ArrayList v1=new ArrayList();
        v1.add(rpn_fechaE);
        v1.add(rpn_comentE);
        try {
            jt.setCampos(v1);
        } catch (Exception k){Error("Error al poner campos al grid",k); }
        jt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Pprinc.add(jt);
        jt.setBounds(8, 138, 580, 120);
        Pprinc.add(Baceptar);
        Baceptar.setBounds(130, 270, 90, 30);
        Pprinc.add(Bcancelar);
        Bcancelar.setBounds(320, 270, 90, 30);

        getContentPane().add(Pprinc);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private gnu.chu.controles.CButton Baceptar;
    private gnu.chu.controles.CButton Bcancelar;
    private gnu.chu.controles.CButton Bincidenc;
    private gnu.chu.controles.CPanel Pcabe;
    private gnu.chu.controles.CPanel Pprinc;
    private gnu.chu.camposdb.AccPanel acc_idE;
    private gnu.chu.controles.CLabel cLabel1;
    private gnu.chu.controles.CLabel cLabel10;
    private gnu.chu.controles.CLabel cLabel11;
    private gnu.chu.controles.CLabel cLabel2;
    private gnu.chu.controles.CLabel cLabel3;
    private gnu.chu.controles.CLabel cLabel4;
    private gnu.chu.controles.CLabel cLabel5;
    private gnu.chu.controles.CLabel cLabel6;
    private gnu.chu.controles.CLabel cLabel7;
    private gnu.chu.controles.CLabel cLabel8;
    private gnu.chu.controles.CLabel cLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private gnu.chu.controles.CGridEditable jt;
    private gnu.chu.controles.CTextField pal_codiE;
    private gnu.chu.controles.CTextField par_codiE;
    private gnu.chu.camposdb.proPanel pro_codiE;
    private gnu.chu.controles.CTextField rpn_comentE;
    private gnu.chu.controles.CTextField rpn_fechaE;
    private gnu.chu.controles.CTextField rpv_codiE;
    private gnu.chu.controles.CTextArea rpv_comentE;
    private gnu.chu.controles.CComboBox rpv_estadE;
    private gnu.chu.controles.CTextField rpv_kilaceE;
    private gnu.chu.controles.CTextField rpv_kiloriE;
    private gnu.chu.controles.CTextField rpv_kilosE;
    private gnu.chu.controles.CTextField rpv_preaceE;
    private gnu.chu.controles.CTextField rpv_precioE;
    private gnu.chu.controles.CTextField rpv_precoriE;
    // End of variables declaration//GEN-END:variables

    @Override
    public void PADPrimero() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void PADAnterior() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void PADSiguiente() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void PADUltimo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ej_query1() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void canc_query() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ej_edit1() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void canc_edit() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ej_addnew1() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void canc_addnew() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ej_delete1() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void canc_delete() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void activar(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
