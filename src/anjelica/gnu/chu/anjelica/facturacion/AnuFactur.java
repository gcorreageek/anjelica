package gnu.chu.anjelica.facturacion;

/**
 * 
 * <p>Título: Anulación de Facturas</p>
 * <p>Descripción: Anulacion  de Facturas de Ventas
 *  de ventas</p> 
 * <p>Copyright: Copyright (c) 2005-2012
 *  Este programa es software libre. Puede redistribuirlo y/o modificarlo bajo
 *  los términos de la Licencia Pública General de GNU segun es publicada por
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
 * @author chuchi P.
 * @version 1.0
 */
import gnu.chu.Menu.*;
import gnu.chu.anjelica.pad.pdclien;
import gnu.chu.controles.*;
import gnu.chu.utilidades.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

public class AnuFactur extends ventana
{
  String s;
 CButton Bbuscar = new CButton("Buscar (F4)",Iconos.getImageIcon("check"));
   CLabel cLabel1 = new CLabel();
   CComboBox cli_tipfacE = new CComboBox();
    /** Creates new form AnuFactur */
  public AnuFactur(EntornoUsuario eu, Principal p) {
    EU=eu;
    vl=p.panel1;
    jf=p;
    eje=true;

    setTitulo("Anulacion Facturas (Borrado)");

    try  {
      if(jf.gestor.apuntar(this))
          jbInit();
      else
        setErrorInit(true);
    }
    catch (Exception e) {
          ErrorInit(e);
    }
  }

  public AnuFactur(gnu.chu.anjelica.menu p,EntornoUsuario eu) {

    EU=eu;
    vl=p.getLayeredPane();
    setTitulo("Anulacion Facturas (Borrado)");

    eje=false;

    try  {
      jbInit();
    }
    catch (Exception e) {
        ErrorInit(e);
    }
  }
 private void jbInit() throws Exception
  {
   // this.setSize(new Dimension(700, 496));
    iniciarFrame();
    this.setVersion("2012-09-12");
    conecta();
    statusBar= new StatusBar(this);

    initComponents();
    this.getContentPane().add(statusBar,  BorderLayout.SOUTH);
    configurarGrid();
    Bbuscar.setBounds(new Rectangle(552, 118, 113, 27));
    Bbuscar.setMargin(new Insets(0, 0, 0, 0));
    cLabel1.setText("Tipo Facturacion");
    cLabel1.setBounds(new Rectangle(338, 128, 101, 16));
    cli_tipfacE.setBounds(new Rectangle(437, 127, 93, 17));
    PcondBus.add(Bbuscar, null);
    PcondBus.add(cLabel1, null);
    PcondBus.add(cli_tipfacE, null);
    this.setSize(new Dimension(700, 496));
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
        PcondBus = new gnu.chu.anjelica.facturacion.condBusFra();
        jtFra = new gnu.chu.controles.Cgrid();
        cPanel1 = new gnu.chu.controles.CPanel();
        cLabel2 = new gnu.chu.controles.CLabel();
        impFrasE = new gnu.chu.controles.CTextField(Types.DECIMAL,"--,---,--9.99");
        cLabel3 = new gnu.chu.controles.CLabel();
        numFrasE = new gnu.chu.controles.CTextField(Types.DECIMAL,"###9");
        Baceptar = new gnu.chu.controles.CButton("Aceptar",Iconos.getImageIcon("check"));
        Binvert = new gnu.chu.controles.CButton(Iconos.getImageIcon("data-undo"));

        Pprinc.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        PcondBus.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jtFra.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        org.jdesktop.layout.GroupLayout jtFraLayout = new org.jdesktop.layout.GroupLayout(jtFra);
        jtFra.setLayout(jtFraLayout);
        jtFraLayout.setHorizontalGroup(
            jtFraLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 763, Short.MAX_VALUE)
        );
        jtFraLayout.setVerticalGroup(
            jtFraLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 196, Short.MAX_VALUE)
        );

        cPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        cLabel2.setText("Imp. Fras");

        impFrasE.setEnabled(false);

        cLabel3.setText("Num. Fras");

        numFrasE.setEnabled(false);

        org.jdesktop.layout.GroupLayout cPanel1Layout = new org.jdesktop.layout.GroupLayout(cPanel1);
        cPanel1.setLayout(cPanel1Layout);
        cPanel1Layout.setHorizontalGroup(
            cPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(cPanel1Layout.createSequentialGroup()
                .add(cLabel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(impFrasE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 96, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(cLabel3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(numFrasE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 58, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 27, Short.MAX_VALUE)
                .add(Binvert, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 69, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(18, 18, 18)
                .add(Baceptar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 111, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        cPanel1Layout.setVerticalGroup(
            cPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(cPanel1Layout.createSequentialGroup()
                .add(4, 4, 4)
                .add(cPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(cLabel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(impFrasE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(cLabel3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(numFrasE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(Baceptar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 27, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(Binvert, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 23, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        org.jdesktop.layout.GroupLayout PprincLayout = new org.jdesktop.layout.GroupLayout(Pprinc);
        Pprinc.setLayout(PprincLayout);
        PprincLayout.setHorizontalGroup(
            PprincLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(PprincLayout.createSequentialGroup()
                .addContainerGap(41, Short.MAX_VALUE)
                .add(PcondBus, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 683, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
            .add(jtFra, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .add(PprincLayout.createSequentialGroup()
                .addContainerGap(115, Short.MAX_VALUE)
                .add(cPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(116, Short.MAX_VALUE))
        );
        PprincLayout.setVerticalGroup(
            PprincLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(PprincLayout.createSequentialGroup()
                .add(PcondBus, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 183, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jtFra, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(cPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(Pprinc, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

  public void iniciarVentana() throws Exception
  {
    PcondBus.setDefButton(Bbuscar);
    PcondBus.iniciar(dtStat,this,vl,EU);
    activar(false);
    activarEventos();
    pdclien.llenaTipoFact(cli_tipfacE);
    cli_tipfacE.setColumnaAlias("cli_tipfac");
    cli_tipfacE.setQuery(true);
    PcondBus.feciniE.setText("01-"+Formatear.getFechaAct("MM-yyyy"));
  }
  void configurarGrid() throws Exception
  {
    jtFra.setMaximumSize(new Dimension(680, 208));
    jtFra.setMinimumSize(new Dimension(680, 208));
    jtFra.setPreferredSize(new Dimension(680, 208));
    jtFra.setNumColumnas(10);
    Vector v=new Vector();
    v.addElement("Ejer"); // 0
    v.addElement("Emp"); // 1
    v.addElement("Fact."); // 2
    v.addElement("Fec.Fra"); // 3
    v.addElement("Cli"); // 4
    v.addElement("Nombre Cliente"); // 5
    v.addElement("Imp.Fra"); // 6
    v.addElement("Tra"); // 7
    v.addElement("INC"); // 8
    v.addElement("A.F"); // 9 Anulada Fra
    jtFra.setCabecera(v);
//    jtFra.setMaximumSize(new Dimension(693, 197));
//    jtFra.setMinimumSize(new Dimension(693, 197));
//    jtFra.setPreferredSize(new Dimension(693, 197));
    jtFra.setBuscarVisible(false);
    jtFra.setAnchoColumna(new int[]{40,40,50,90,70,180,80,30,30,30});
    jtFra.setAlinearColumna(new int[]{2,2,2,1,2,0,2,1,1,1});
    jtFra.setFormatoColumna(7,"BSN");
    jtFra.setFormatoColumna(8,"BSN");
    jtFra.setFormatoColumna(9,"BSN");
    jtFra.setFormatoColumna(6,"---,--9.99");
  }
  void activarEventos()
  {
    Bbuscar.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        Bbuscar_actionPerformed();
      }
    });
    jtFra.addMouseListener(new MouseAdapter()
   {
     public void mouseClicked(MouseEvent e)
     {
       if (!jtFra.isEnabled() || jtFra.getSelectedColumn()!=8 )
         return;
       if (jtFra.getValBoolean(7))
       {
         mensajeErr("Factura Ya esta contabilizada. NO se puede Borrar");
         return;
       }
       jtFra.setValor(new Boolean(!jtFra.getValBoolean(8)));
       recalcTot();
     }
   });
   Binvert.addActionListener(new ActionListener()
   {
     public void actionPerformed(ActionEvent e)
     {
       if (!jtFra.isEnabled())
         return;

       int nRow = jtFra.getRowCount();
       for (int n = 0; n < nRow; n++)
       {
         if (jtFra.getValBoolean(n,7))
           continue;
         jtFra.setValor(new Boolean(!jtFra.getValBoolean(n, 8)), n, 8);
       }
       recalcTot();
     }
   });
   Baceptar.addActionListener(new ActionListener()
     {
       public void actionPerformed(ActionEvent e)
       {
         Baceptar_actionPerformed();
       }
     });

  }

  void Bbuscar_actionPerformed()
  {
    try
    {

      if (!PcondBus.checkCampos())
        return;
    }
    catch (Exception k)
    {
      Error("Error al validar Campos de Busqueda", k);
      return;
    }
    new miThread("")
    {
      public void run()
      {
        AnuFactur.this.setEnabled(false);
        llenaGrid();
        AnuFactur.this.setEnabled(true);
        mensaje("");
      }
    };
  }

  void llenaGrid()
  {
    try
    {
      mensaje("Buscando Facturas que cumplan los criterios");
      s = "SELECT c.emp_codi as fvc_empcod,c.*,cl.* FROM v_facvec as c,clientes as cl " +
          " WHERE  c.cli_codi = cl.cli_codi " +
          PcondBus.getCondWhere() +
          (cli_tipfacE.getStrQuery().equals("") ? "" : " and " + cli_tipfacE.getStrQuery()) +
          " ORDER BY c.emp_codi, fvc_ano,fvc_nume";
      activar(false);
      jtFra.removeAllDatos();
      impFrasE.resetTexto();
      numFrasE.resetTexto();
      if (!dtCon1.select(s))
      {
        mensajeErr("No encontradas Facturas para estas condiciones");
        return;
      }
      jtFra.panelG.setVisible(false);
      do
      {
        Vector v = new Vector();
        v.addElement(dtCon1.getString("fvc_ano"));
        v.addElement(dtCon1.getString("fvc_empcod"));
        v.addElement(dtCon1.getString("fvc_serie")+"-"+dtCon1.getString("fvc_nume"));
        v.addElement(dtCon1.getFecha("fvc_fecfra", "dd-MM-yyyy"));
        v.addElement(dtCon1.getString("cli_codi"));
        v.addElement(dtCon1.getString("cli_nomb"));
        v.addElement(dtCon1.getString("fvc_sumtot"));
        v.addElement(dtCon1.getInt("fvc_trasp") == 0 ? "N" : "S");
        v.addElement(dtCon1.getInt("fvc_trasp") == 0 ? "S" : "N");
        v.addElement("N");
        jtFra.addLinea(v);
      }    while (dtCon1.next());
      jtFra.panelG.setVisible(true);
      recalcTot();
      jtFra.requestFocusInicio();
      activar(true);
      mensajeErr("Busqueda de Facturas finalizada");
    }
    catch (Exception k)
    {
      Error("Error al Buscar Facturas", k);
    }
  }

  void activar(boolean activ)
  {
    jtFra.setEnabled(activ);
    Baceptar.setEnabled(activ);
    Binvert.setEnabled(activ);
  }

  void recalcTot()
  {
    int nFras = 0;
    double impFras = 0;
    int nRow = jtFra.getRowCount();

    for (int n = 0; n < nRow; n++)
    {
      if (jtFra.getValBoolean(n, 8))
      {
        nFras++;
        impFras += jtFra.getValorDec(n, 6);
      }
    }
    numFrasE.setValorInt(nFras);
    impFrasE.setValorDec(impFras);
  }
  void Baceptar_actionPerformed()
  {
    if (numFrasE.getValorInt()==0)
    {
      mensajeErr("Selecione al menos una Fra");
      jtFra.requestFocusInicio();
      return;
    }
    new miThread("")
    {
            @Override
      public void run()
      {
        borrarFras();
        activar(false);
      }
    };

  }

  void borrarFras()
  {
    this.setEnabled(false);
    int nRow = jtFra.getRowCount();
    String msgErr,fvcSerie;
    int n = 1;
    int nFras=0;
    int fvcNume;
    String msgTotal="";
    try
    {
      for (n = 0; n < nRow; n++)
      {
        mensaje("Borrando Fra: " + jtFra.getValorInt(n, 1) + "-" + jtFra.getValorInt(n, 0) + "-"
                + jtFra.getValString(n, 2));
        if (jtFra.getValBoolean(n, 8) && ! jtFra.getValBoolean(n, 9))
        {
          fvcSerie=jtFra.getValString(n,2).substring(0,1);
          fvcNume=Integer.parseInt( jtFra.getValString(n,2).substring(2));
          msgErr = PadFactur.checkModif(! jtFra.getValBoolean(n, 8),jtFra.getValorInt(n, 1),
                                      jtFra.getValorInt(n, 0),fvcSerie,fvcNume, dtStat, dtCon1);
          if (msgErr == null)
          {
            PadFactur.deleteFra(jtFra.getValorInt(n, 1), jtFra.getValorInt(n, 0),fvcSerie,
                 fvcNume, dtCon1);
            dtCon1.commit();
            jtFra.setValor(new Boolean(true),n,9);
            jtFra.setValor(new Boolean(false),n,8);
            nFras++;
          }
          else
          {
            msgTotal += "Fra: " + jtFra.getValorInt(n, 1) + "-" +
                jtFra.getValorInt(n, 0) + "-" + jtFra.getValorInt(n, 2) + ": " + msgErr+"\n";
          }
        }
      }
    }
    catch (Exception k)
    {
      Error("Error al Anular Fra. de Linea: " + n + " Emp: " + jtFra.getValorInt(n, 1) + " Ejerc: " +
            jtFra.getValorInt(n, 0) + " Fra: " + jtFra.getValorInt(n, 2), k);
    }
    msgBox(msgTotal+"\n\n"+nFras+" Facturas Borradas");
    mensaje("");
    this.setEnabled(true);
  }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private gnu.chu.controles.CButton Baceptar;
    private gnu.chu.controles.CButton Binvert;
    private gnu.chu.anjelica.facturacion.condBusFra PcondBus;
    private gnu.chu.controles.CPanel Pprinc;
    private gnu.chu.controles.CLabel cLabel2;
    private gnu.chu.controles.CLabel cLabel3;
    private gnu.chu.controles.CPanel cPanel1;
    private gnu.chu.controles.CTextField impFrasE;
    private gnu.chu.controles.Cgrid jtFra;
    private gnu.chu.controles.CTextField numFrasE;
    // End of variables declaration//GEN-END:variables

}
