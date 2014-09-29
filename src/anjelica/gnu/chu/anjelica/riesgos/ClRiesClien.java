
package gnu.chu.anjelica.riesgos;


import gnu.chu.utilidades.*; 
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import gnu.chu.Menu.*;
import gnu.chu.anjelica.pad.MantRepres;
import gnu.chu.controles.CButton;
import gnu.chu.controles.StatusBar;
import gnu.chu.print.util;
import net.sf.jasperreports.engine.*;
 
/**
 *
 * <p>Titulo: ClRiesClien </p>
 * <p>Descripción:  Consulta/Listado Riesgos de Clientes (Cobros Pendientes)</p>
 * <p>Copyright: Copyright (c) 2005-2009
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
/**
 *
 * @author cpuente
 */
public class ClRiesClien  extends ventana implements JRDataSource
{
  String s;
  CButton Bprint = new CButton(Iconos.getImageIcon("print"));
  ResultSet rs;
    /** Creates new form ClRiesClien */
     public ClRiesClien(EntornoUsuario eu, Principal p)
  {
    EU = eu;
    vl = p.panel1;
    jf = p;
    eje = true;

    setTitulo("Cons./List. Documentos Pend. Cobro Clientes");

    try
    {
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

  public ClRiesClien(gnu.chu.anjelica.menu p, EntornoUsuario eu)
  {
    EU = eu;
    vl = p.getLayeredPane();
    setTitulo("Cons./List. Documentos Pend. Cobro Clientes");
    eje = false;

    try
    {
      jbInit();
    }
    catch (Exception e)
    {
      ErrorInit(e);
    }
  }

  private void jbInit() throws Exception
  {

    iniciarFrame();
    setVersion("2009-03-22");

    statusBar= new StatusBar(this);
    this.getContentPane().add(statusBar,BorderLayout.SOUTH);
    conecta();
    initComponents();
    this.setSize(new Dimension(760, 426));
   
    configGrid();
    Bprint.setPreferredSize(new Dimension(70, 24));
    Bprint.setMaximumSize(Bprint.getPreferredSize());
    Bprint.setMinimumSize(Bprint.getPreferredSize());
    Bprint.setMargin(new Insets(0, 0, 0, 0));
    statusBar.add(Bprint, new GridBagConstraints(9, 0, 1, 2, 0.0, 0.0
                                            , GridBagConstraints.EAST,
                                            GridBagConstraints.VERTICAL,
                                            new Insets(0, 5, 0, 0), 0, 0));
  }
  private void configGrid() throws Exception
  {
    jt.setNumColumnas(9);
    Vector v = new Vector();
    v.addElement("Cliente"); // 0
    v.addElement("Nombre"); // 1
    v.addElement("Factura"); // 2
    v.addElement("Fec.Fra"); //3
    v.addElement("Imp.Total"); // 4
    v.addElement("Imp.Cobra"); // 5
    v.addElement("Imp.Pend."); // 6
    v.addElement("Giro"); // 7
    v.addElement("Fec.Vto"); // 8
    jt.setCabecera(v);
    jt.setAnchoColumna(new int[]{50,150,90,70,70,70,70,40,90});
    jt.setAlinearColumna(new int[]{2,0,0,1,2,2,2,1,1});
    jt.setFormatoColumna(4, "----,--9.99");
    jt.setFormatoColumna(5, "----,--9.99");
    jt.setFormatoColumna(6, "----,--9.99");
    jt.setFormatoColumna(7, "BSN");
    jt.resetRenderer(7);
    jt.setMaximumSize(new Dimension(528, 237));
    jt.setMinimumSize(new Dimension(528, 237));
    jt.setPreferredSize(new Dimension(528, 237));
    jt.setAjustarGrid(true);
  }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        Pprinc = new gnu.chu.controles.CPanel();
        Pcondic = new gnu.chu.controles.CPanel();
        cLabel1 = new gnu.chu.controles.CLabel();
        zon_codiE = new gnu.chu.controles.CLinkBox();
        cLabel2 = new gnu.chu.controles.CLabel();
        cli_codiE = new gnu.chu.camposdb.cliPanel();
        cLabel3 = new gnu.chu.controles.CLabel();
        feciniE = new gnu.chu.controles.CTextField(Types.DATE,"dd-MM-yyyy");
        cLabel4 = new gnu.chu.controles.CLabel();
        fecfinE = new gnu.chu.controles.CTextField(Types.DATE,"dd-MM-yyyy");
        opInact = new gnu.chu.controles.CCheckBox();
        opAlbarE = new gnu.chu.controles.CCheckBox();
        cLabel5 = new gnu.chu.controles.CLabel();
        girosE = new gnu.chu.controles.CComboBox();
        Baceptar = new gnu.chu.controles.CButton("Aceptar",Iconos.getImageIcon("check"));
        cLabel6 = new gnu.chu.controles.CLabel();
        emp_codiE = new gnu.chu.camposdb.empPanel();
        cLabel7 = new gnu.chu.controles.CLabel();
        rep_codiE = new gnu.chu.controles.CLinkBox();
        jt = new gnu.chu.controles.Cgrid();

        Pprinc.setLayout(new java.awt.GridBagLayout());

        Pcondic.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Pcondic.setMaximumSize(new java.awt.Dimension(703, 90));
        Pcondic.setMinimumSize(new java.awt.Dimension(703, 90));
        Pcondic.setPreferredSize(new java.awt.Dimension(703, 90));
        Pcondic.setLayout(null);

        cLabel1.setText("Zona");
        Pcondic.add(cLabel1);
        cLabel1.setBounds(2, 4, 40, 14);

        zon_codiE.setAncTexto(30);
        Pcondic.add(zon_codiE);
        zon_codiE.setBounds(40, 0, 270, 20);

        cLabel2.setText("Cliente");
        Pcondic.add(cLabel2);
        cLabel2.setBounds(0, 30, 40, 20);
        Pcondic.add(cli_codiE);
        cli_codiE.setBounds(40, 30, 330, 20);

        cLabel3.setText("De Fecha Fra");
        Pcondic.add(cLabel3);
        cLabel3.setBounds(380, 30, 74, 20);
        Pcondic.add(feciniE);
        feciniE.setBounds(460, 30, 79, 20);

        cLabel4.setText("A Fecha Fra");
        Pcondic.add(cLabel4);
        cLabel4.setBounds(550, 30, 66, 20);
        Pcondic.add(fecfinE);
        fecfinE.setBounds(620, 30, 79, 20);

        opInact.setText("Ver Clientes Inactivos");
        Pcondic.add(opInact);
        opInact.setBounds(0, 60, 161, 19);

        opAlbarE.setText("Mostrar Albaranes");
        Pcondic.add(opAlbarE);
        opAlbarE.setBounds(170, 60, 141, 15);

        cLabel5.setText("Forma Pago");
        Pcondic.add(cLabel5);
        cLabel5.setBounds(320, 60, 68, 14);
        Pcondic.add(girosE);
        girosE.setBounds(400, 60, 170, 20);
        Pcondic.add(Baceptar);
        Baceptar.setBounds(580, 53, 110, 30);

        cLabel6.setText("Empresa");
        Pcondic.add(cLabel6);
        cLabel6.setBounds(600, 0, 51, 20);
        Pcondic.add(emp_codiE);
        emp_codiE.setBounds(650, 0, 47, 20);

        cLabel7.setText("Agente");
        Pcondic.add(cLabel7);
        cLabel7.setBounds(330, 0, 40, 20);

        rep_codiE.setAncTexto(30);
        Pcondic.add(rep_codiE);
        rep_codiE.setBounds(370, 0, 230, 20);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        Pprinc.add(Pcondic, gridBagConstraints);

        jt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        org.jdesktop.layout.GroupLayout jtLayout = new org.jdesktop.layout.GroupLayout(jt);
        jt.setLayout(jtLayout);
        jtLayout.setHorizontalGroup(
            jtLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 798, Short.MAX_VALUE)
        );
        jtLayout.setVerticalGroup(
            jtLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 415, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(6, 0, 0, 0);
        Pprinc.add(jt, gridBagConstraints);

        getContentPane().add(Pprinc, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private gnu.chu.controles.CButton Baceptar;
    private gnu.chu.controles.CPanel Pcondic;
    private gnu.chu.controles.CPanel Pprinc;
    private gnu.chu.controles.CLabel cLabel1;
    private gnu.chu.controles.CLabel cLabel2;
    private gnu.chu.controles.CLabel cLabel3;
    private gnu.chu.controles.CLabel cLabel4;
    private gnu.chu.controles.CLabel cLabel5;
    private gnu.chu.controles.CLabel cLabel6;
    private gnu.chu.controles.CLabel cLabel7;
    private gnu.chu.camposdb.cliPanel cli_codiE;
    private gnu.chu.camposdb.empPanel emp_codiE;
    private gnu.chu.controles.CTextField fecfinE;
    private gnu.chu.controles.CTextField feciniE;
    private gnu.chu.controles.CComboBox girosE;
    private gnu.chu.controles.Cgrid jt;
    private gnu.chu.controles.CCheckBox opAlbarE;
    private gnu.chu.controles.CCheckBox opInact;
    private gnu.chu.controles.CLinkBox rep_codiE;
    private gnu.chu.controles.CLinkBox zon_codiE;
    // End of variables declaration//GEN-END:variables

 public void iniciarVentana() throws Exception
  {
    emp_codiE.iniciar(dtStat,this,vl,EU);
//    emp_codiE.setLabelEmp(empNombL);
    emp_codiE.setColumnaAlias("f.emp_codi");
  
    emp_codiE.setAceptaNulo(true);
    emp_codiE.setText("0");
    cli_codiE.iniciar(dtStat,this,vl,EU);
    zon_codiE.setFormato(Types.CHAR, "XX", 2);
    zon_codiE.texto.setMayusc(true);
    zon_codiE.setFormato(true);
    rep_codiE.setFormato(Types.CHAR, "XX", 2);
    rep_codiE.texto.setMayusc(true);
    rep_codiE.setFormato(true);

    girosE.addItem("No giros","N");
    girosE.addItem("Giros","S");
    girosE.addItem("TODO","T");

    gnu.chu.anjelica.pad.pdconfig.llenaDiscr(dtCon1,zon_codiE,"Cz",EU.em_cod);
    MantRepres.llenaLinkBox(rep_codiE, dtCon1);
//    gnu.chu.anjelica.pad.pdconfig.llenaDiscr(dtCon1,rep_codiE,"Cr",EU.em_cod);

    zon_codiE.addDatos("**","TODOS");
    zon_codiE.setText("**");
    rep_codiE.addDatos("**","TODOS");
    rep_codiE.setText("**");
    activarEventos();
    this.setEnabled(true);
    feciniE.requestFocus();
  }
  void activarEventos()
  {
    Baceptar.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        Baceptar_actionPerformed();
      }
    });
    Bprint.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        Bprint_actionPerformed();
      }
    });
  }
  String getStrSql()
  {
    String zonCodi = zon_codiE.getText().trim().equals("") ? null :
        zon_codiE.getText();
    String repCodi = rep_codiE.getText().trim().equals("") ? null :
        rep_codiE.getText();
    if (zonCodi != null)
    {
      if (zonCodi.equals("*") || zonCodi.equals("**"))
        zonCodi = null;
    }
    if (repCodi != null)
    {
      if (repCodi.equals("*") || repCodi.equals("**"))
        repCodi = null;
    }
    if (zonCodi != null)
      zonCodi = zonCodi.replace('*', '%');
    if (repCodi != null)
      repCodi = repCodi.replace('*', '%');
    String cliCodi = cli_codiE.getText().trim().equals("") ||
        cli_codiE.getValorInt() == 0 ? null : cli_codiE.getText();
    s = "SELECT cl.cli_zonrep,cl.cli_pobl,f.cli_codi,cl.cli_nomb,fvc_ano,"+
         " f.emp_codi,fvc_serie AS serie,fvc_nume,fvc_fecfra," +
        " f.fvc_sumtot,fvc_impcob," +
        " fvc_sumtot-fvc_impcob as fvc_imppen,cl.cli_giro,cl.cli_dipa1,cl.cli_dipa2,fp.*, "+
        " cl.cli_gener, f.fvc_clinom as avc_clinom "+
        "  FROM V_facvec f,clientes cl,v_forpago as fp " +
        " WHERE fvc_cobrad = 0" +
            " and cl.cli_codi = f.cli_codi " +
        " and cl.fpa_codi = fp.fpa_codi "+
        (zonCodi != null ? " and zon_codi  like '" + zonCodi + "'" : "") +
        (repCodi != null ? " and rep_codi  like '" + repCodi + "'" : "") +
        (cliCodi != null ? " and f.cli_codi = " + cliCodi : "") +
        (emp_codiE.getStrQuery().trim().equals("")?"":" and "+emp_codiE.getStrQuery())+
        (feciniE.isNull() ? "" :
         " and fvc_fecfra >= TO_DATE('" + feciniE.getText() +
         "','dd-MM-yyyy') ") +
        (fecfinE.isNull() ? "" :
         " and fvc_fecfra <= TO_DATE('" + fecfinE.getText() +
         "','dd-MM-yyyy') ") +
        (opInact.isSelected() ? "" : " and cli_activ ='S'");
    if (girosE.getValor().equals("S"))
      s+=" and cl.cli_giro = 'S'";
    if (girosE.getValor().equals("N"))
      s+=" and cl.cli_giro = 'N'";
    if (opAlbarE.isSelected())
    {
      s+= " UNION ALL "+
          "SELECT cl.cli_zonrep,cl.cli_pobl,f.cli_codi,cl.cli_nomb,avc_ano as fvc_ano,f.emp_codi,"+
                 " avc_serie AS serie,avc_nume as fvc_nume,avc_fecalb as fvc_fecfra," +
                 " avc_impalb as fvc_sumtot,avc_impcob as fvc_impcob," +
                 " avc_impalb-avc_impcob as fvc_imppen,cl.cli_giro,cl.cli_dipa1,cl.cli_dipa2, fp.*, "+
                 " cl.cli_gener, f.avc_clinom as avc_clinom"+
                 "   FROM V_albavec f,clientes cl,v_forpago as fp " +
                 " WHERE avc_cobrad = 0" +
                 " and cl.cli_codi = f.cli_codi " +
                 " and cl.fpa_codi = fp.fpa_codi "+
                 " and (fvc_nume = 0 or fvc_nume is null) "+
                 (EU.isRootAV()?"":" AND f.div_codi > 0 ")+
                 (zonCodi != null ? " and cli_zonrep  like '" + zonCodi + "'" : "") +
                 (cliCodi != null ? " and f.cli_codi = " + cliCodi : "") +
                  (emp_codiE.getStrQuery().trim().equals("")?"":" and "+emp_codiE.getStrQuery())+
                 (feciniE.isNull() ? "" :
                  " and avc_fecalb >= TO_DATE('" + feciniE.getText() +"','dd-MM-yyyy') ") +
                 (fecfinE.isNull() ? "" :
                  " and avc_fecalb <= TO_DATE('" + fecfinE.getText() +"','dd-MM-yyyy') ") +
                 (opInact.isSelected() ? "" : " and cli_activ ='S'");
             if (girosE.getValor().equals("S"))
               s+=" and cl.cli_giro = 'S'";
             if (girosE.getValor().equals("N"))
               s+=" and cl.cli_giro = 'N'";
    }
    s+=" order by 3,9 asc"; // Cliente, Fecha Fra.
//    s+=" order by cl.cli_zonrep,f.cli_codi,f.fvc_fecfra";
    return s;
  }
  void Baceptar_actionPerformed()
  {
    new clriesclienTh(this);
  }
  void consulta()
  {
    String cliNomb;
    s=getStrSql();
//    debug("s: "+s);
   jt.setEnabled(false);
  
   jt.removeAllDatos();
   try {
     if (!emp_codiE.controla())
     {
         mensajeErr(emp_codiE.getMsgError());
         return;
     }
     if (!dtCon1.select(s))
     {
       msgBox("No encontrados Cobros PENDIENTES");
       zon_codiE.requestFocus();
       return;
     }
     jt.panelG.setVisible(false);
     int cliCodi=dtCon1.getInt("cli_codi");
     double sumTotCl=0,impCobCl=0,impPenCl=0;
     double sumTot=0,impCob=0,impPen=0;
     int nFac=0;
     do
     {
       if (cliCodi!=dtCon1.getInt("cli_codi"))
       {
         if (nFac>1)
         {
           Vector v = new Vector();
           v.addElement("");
           v.addElement("Total Cliente ("+nFac+" Fras. )");
           v.addElement("");
           v.addElement("");
           v.addElement("" + sumTotCl);
           v.addElement("" + impCobCl);
           v.addElement("" + impPenCl);
           v.addElement("");
           v.addElement("");
           jt.addLinea(v);
         }
         cliCodi=dtCon1.getInt("cli_codi");
         sumTot+=sumTotCl;
         impCob+=impCobCl;
         impPen+=impPenCl;
         sumTotCl=0;
         impCobCl=0;
         impPenCl=0;
         nFac=0;
       }
       nFac++;
       sumTotCl+=dtCon1.getDouble("fvc_sumtot");
       impCobCl+=dtCon1.getDouble("fvc_impcob");
       impPenCl+=dtCon1.getDouble("fvc_imppen");
       Vector v=new Vector();
       v.addElement(dtCon1.getString("cli_codi"));
       cliNomb=dtCon1.getString("cli_nomb");
       if (dtCon1.getInt("cli_gener")!=0)
       {
         if (!dtCon1.getString("avc_clinom",true).equals(""))
           cliNomb=dtCon1.getString("avc_clinom");
       }
       v.addElement(cliNomb);
       v.addElement(Formatear.format(dtCon1.getString("fvc_ano"),"##99")+"-"+
                    Formatear.format(dtCon1.getString("emp_codi"),"99")+"-"+
                    dtCon1.getString("serie").toUpperCase()+"/"+
                    Formatear.format(dtCon1.getString("fvc_nume"),"###99"));
       v.addElement(dtCon1.getFecha("fvc_fecfra","dd-MM-yy"));
       v.addElement(dtCon1.getString("fvc_sumtot"));
       v.addElement(dtCon1.getString("fvc_impcob"));
       v.addElement(dtCon1.getString("fvc_imppen"));
       v.addElement(dtCon1.getString("cli_giro"));
       if (clFactCob.calDiasVto(dtCon1, dtCon1.getInt("cli_dipa1"), dtCon1.getInt("cli_dipa2"), 0, dtCon1.getFecha("fvc_fecfra", "dd-MM-yyyy"))>=1)
         v.addElement(clFactCob.diasVto[0]);
        else
          v.addElement("");
       jt.addLinea(v);
     } while (dtCon1.next());
     if (nFac>1)
     {
       Vector v = new Vector();
       v.addElement("");
       v.addElement("Total Cliente ("+nFac+" Fras. )");
       v.addElement("");
       v.addElement("");
       v.addElement("" + sumTotCl);
       v.addElement("" + impCobCl);
       v.addElement("" + impPenCl);
       v.addElement("");
       v.addElement("");
       jt.addLinea(v);
       sumTot += sumTotCl;
       impCob += impCobCl;
       impPen += impPenCl;
     }
     {
       Vector v = new Vector();
       v.addElement("");
       v.addElement("Total General");
       v.addElement("");
       v.addElement("");
       v.addElement("" + sumTot);
       v.addElement("" + impCob);
       v.addElement("" + impPen);
       v.addElement("");
       v.addElement("");
       jt.addLinea(v);
     }
   } catch (Throwable k)
   {
     Error("Error al Consultar Cobros Pendientes",k);
   }
   mensajeErr("Consulta ... Realizada");
   mensaje("");
   jt.panelG.setVisible(true);
   jt.setEnabled(true);
   jt.requestFocusInicio();
  }

  void Bprint_actionPerformed()
  {
    try
    {
      s = getStrSql();
      dtCon1.setStrSelect(s);
      rs = ct.createStatement().executeQuery(dtCon1.getStrSelect());

      JasperReport jr = gnu.chu.print.util.getJasperReport(EU, "liscobpen");
      java.util.HashMap mp = new java.util.HashMap();
      mp.put("fecini", feciniE.getText());
      mp.put("fecfin", fecfinE.getText());
      mp.put("zonNomb", zon_codiE.getText() + "-" + zon_codiE.getTextCombo());
      mp.put("repNomb", rep_codiE.getText() + "-" + rep_codiE.getTextCombo());
      mp.put("empNomb",(emp_codiE.getEmpNomb().equals("")?null:emp_codiE.getEmpNomb()));
      mp.put("giros", girosE.getText());
      mp.put("albaran", opAlbarE.isSelected()?"INC. Albaranes":"");

      JasperPrint jp = JasperFillManager.fillReport(jr, mp,this);
      util.printJasper(jp, EU);
      
    }
    catch (Exception k)
    {
      Error("Error al generar Listado", k);
      return;
    }
  }
  public boolean next() throws JRException
  {
    try {
      return rs.next();
    } catch (SQLException k)
    {
      throw new JRException(k);
    }
  }
  public Object getFieldValue(JRField f) throws JRException
  {
    try {
      String campo=f.getName().toLowerCase();
       if (campo.equals("fvc_ano"))
         return new Integer(rs.getInt(campo));
       if (campo.equals("emp_codi"))
         return new Integer(rs.getInt(campo));
       if (campo.equals("serie"))
         return rs.getString(campo);

      if (campo.equals("fvc_fecvto"))
      {

        if (clFactCob.calDiasVto(rs.getInt("fpa_dia1"),rs.getInt("fpa_dia2"),rs.getInt("fpa_dia3"),
                                 rs.getInt("cli_dipa1"), rs.getInt("cli_dipa2"), 0, Formatear.getFechaVer(rs.getDate("fvc_fecfra"))) >=1)
        {
          SimpleDateFormat sd = new SimpleDateFormat("dd-MM-yyyy");
          java.util.Date dt = sd.parse(clFactCob.diasVto[0]);
          return dt;
        }
       else
         return null;

      }
      if (f.getValueClassName().indexOf("Double")>=0)
        return new Double(rs.getDouble(campo));
      if (f.getValueClassName().indexOf("Integer")>=0)
        return new Integer(rs.getInt(campo));

      if (f.getValueClassName().indexOf("Date")>=0)
        return rs.getDate(campo);
      if (f.getValueClassName().indexOf("String")>=0)
        return rs.getString(campo);

    } catch (Throwable k)
    {
      throw new JRException(k);
    }
    return null;
  }
}
class clriesclienTh extends Thread
{
  ClRiesClien r;
  public clriesclienTh(ClRiesClien padre)
  {
    r=padre;
    this.start();
  }
  public void run()
  {
    r.mensaje("Espere, por favor ... Buscando Datos");
    r.setEnabled(false);
    r.consulta();
    r.setEnabled(true);
    r.mensaje("");
  }
}
