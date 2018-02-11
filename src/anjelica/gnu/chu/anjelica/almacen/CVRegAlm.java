package gnu.chu.anjelica.almacen;

import gnu.chu.Menu.Principal;
import gnu.chu.controles.StatusBar;
import gnu.chu.sql.DatosTabla;
import gnu.chu.utilidades.EntornoUsuario;
import gnu.chu.utilidades.Formatear;
import gnu.chu.utilidades.Iconos;
import gnu.chu.utilidades.miThread;
import gnu.chu.utilidades.ventana;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.sql.SQLException;
import java.sql.Types;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;

/**
 *
 * <p>Título: CVRegAlm</p>
 * <p>Descripcion: Consulta y Valoracion Regularizaciones Almacen </p>
 * <p>Copyright: Copyright (c) 2005-2015
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
 * @author chuchiP
 * @version 1.0
 */

public class CVRegAlm extends ventana
{
  boolean P_VERPRECIO=false;
  DatosTabla dtAdd;
  Date feulin;
   public CVRegAlm(EntornoUsuario eu, Principal p)
  {
      this(eu,p,null);
  }
 public CVRegAlm(EntornoUsuario eu, Principal p,Hashtable<String,String> ht)
  {
   
    EU = eu;
    vl = p.panel1;
    jf = p;
    eje = true;

    setTitulo("Cons. Regularizaciones Alm.");
    ponParametros(ht);
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
  public CVRegAlm(gnu.chu.anjelica.menu p, EntornoUsuario eu)
  {
      this(p,eu,null);
  }
  public CVRegAlm(gnu.chu.anjelica.menu p, EntornoUsuario eu,Hashtable<String,String> ht)
  {

    EU = eu;
    vl = p.getLayeredPane();
    setTitulo("Cons. Regularizaciones Alm.");
    ponParametros(ht);
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
  private void ponParametros(Hashtable<String,String> ht)
  {
      if (ht==null)
          return;
       if (ht.get("verprecio") != null)
       {
           try {
             P_VERPRECIO = Integer.parseInt(ht.get("verprecio"))!=0;
           } catch ( NumberFormatException  x)        {    }
       }      
  }
private void jbInit() throws Exception
  {
      iniciarFrame();

      this.setVersion("2015-12-15");
      statusBar = new StatusBar(this);
      this.getContentPane().add(statusBar, BorderLayout.SOUTH);
      conecta();

      initComponents();
      this.setSize(new Dimension(730,480));
    
      Pcabe.setDefButton(Baceptar);
   }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        Pprinc = new gnu.chu.controles.CPanel();
        Pcabe = new gnu.chu.controles.CPanel();
        cLabel4 = new gnu.chu.controles.CLabel();
        feciniE = new gnu.chu.controles.CTextField(Types.DATE,"dd-MM-yyyy");
        cLabel10 = new gnu.chu.controles.CLabel();
        fecfinE = new gnu.chu.controles.CTextField(Types.DATE,"dd-MM-yyyy");
        cLabel1 = new gnu.chu.controles.CLabel();
        tir_codiE = new gnu.chu.controles.CLinkBox();
        Baceptar = new gnu.chu.controles.CButton(Iconos.getImageIcon("check"));
        cLabel9 = new gnu.chu.controles.CLabel();
        pro_codiE = new gnu.chu.camposdb.proPanel();
        cLabel2 = new gnu.chu.controles.CLabel();
        pro_artconC = new gnu.chu.controles.CComboBox();
        cLabel3 = new gnu.chu.controles.CLabel();
        tir_afestkE = new gnu.chu.controles.CComboBox();
        cLabel5 = new gnu.chu.controles.CLabel();
        cli_codiE = new gnu.chu.camposdb.cliPanel();
        jt = new gnu.chu.controles.Cgrid(10);
        Ppie = new gnu.chu.controles.CPanel();
        cLabel11 = new gnu.chu.controles.CLabel();
        kgEntE = new gnu.chu.controles.CTextField(Types.DECIMAL,"----,--9.99");
        cLabel12 = new gnu.chu.controles.CLabel();
        uniEntE = new gnu.chu.controles.CTextField(Types.DECIMAL,"----,--9");
        impDifE = new gnu.chu.controles.CTextField(Types.DECIMAL,"--,---,--9.99");
        cLabel14 = new gnu.chu.controles.CLabel();
        kgSalE = new gnu.chu.controles.CTextField(Types.DECIMAL,"----,--9.99");
        cLabel15 = new gnu.chu.controles.CLabel();
        uniSalE = new gnu.chu.controles.CTextField(Types.DECIMAL,"----,--9");
        impSalE = new gnu.chu.controles.CTextField(Types.DECIMAL,"--,---,--9.99");
        cLabel17 = new gnu.chu.controles.CLabel();
        impEntE = new gnu.chu.controles.CTextField(Types.DECIMAL,"--,---,--9.99");
        cLabel18 = new gnu.chu.controles.CLabel();
        kgDifE = new gnu.chu.controles.CTextField(Types.DECIMAL,"----,--9.99");
        uniDifE = new gnu.chu.controles.CTextField(Types.DECIMAL,"----,--9");
        cLabel20 = new gnu.chu.controles.CLabel();
        ganEntE = new gnu.chu.controles.CTextField(Types.DECIMAL,"--,---,--9.99");
        ganDifE = new gnu.chu.controles.CTextField(Types.DECIMAL,"--,---,--9.99");
        ganSalE = new gnu.chu.controles.CTextField(Types.DECIMAL,"--,---,--9.99");
        Bactual = new gnu.chu.controles.CButton();
        opSobreescribir = new gnu.chu.controles.CCheckBox();
        cLabel13 = new gnu.chu.controles.CLabel();
        numRegulE = new gnu.chu.controles.CTextField(Types.DECIMAL,"##,##9");

        Pprinc.setLayout(new java.awt.GridBagLayout());

        Pcabe.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        Pcabe.setMaximumSize(new java.awt.Dimension(559, 68));
        Pcabe.setMinimumSize(new java.awt.Dimension(559, 68));
        Pcabe.setPreferredSize(new java.awt.Dimension(559, 68));
        Pcabe.setLayout(null);

        cLabel4.setText("De Fecha");
        Pcabe.add(cLabel4);
        cLabel4.setBounds(10, 2, 60, 17);
        Pcabe.add(feciniE);
        feciniE.setBounds(70, 2, 70, 17);

        cLabel10.setText("A Fecha");
        Pcabe.add(cLabel10);
        cLabel10.setBounds(140, 2, 50, 17);
        Pcabe.add(fecfinE);
        fecfinE.setBounds(190, 2, 70, 17);

        cLabel1.setText("Tipo");
        Pcabe.add(cLabel1);
        cLabel1.setBounds(410, 42, 30, 15);

        tir_codiE.setFormato(Types.DECIMAL,"##9");
        tir_codiE.setAncTexto(35);
        tir_codiE.setAnchoComboDesp(350);
        Pcabe.add(tir_codiE);
        tir_codiE.setBounds(410, 22, 220, 17);

        Baceptar.setText("Aceptar");
        Baceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BaceptarActionPerformed(evt);
            }
        });
        Pcabe.add(Baceptar);
        Baceptar.setBounds(530, 40, 90, 24);

        cLabel9.setText("Producto");
        Pcabe.add(cLabel9);
        cLabel9.setBounds(10, 22, 60, 17);
        Pcabe.add(pro_codiE);
        pro_codiE.setBounds(70, 22, 270, 17);

        cLabel2.setText("Tipo Prod.");
        Pcabe.add(cLabel2);
        cLabel2.setBounds(430, 2, 62, 18);

        pro_artconC.addItem("Todos", "T");
        pro_artconC.addItem("Congelado", "1");
        pro_artconC.addItem("No Congelado", "0");
        pro_artconC.setMinimumSize(new java.awt.Dimension(32, 20));
        Pcabe.add(pro_artconC);
        pro_artconC.setBounds(490, 2, 142, 18);

        cLabel3.setText("Cod.Reg.");
        Pcabe.add(cLabel3);
        cLabel3.setBounds(345, 22, 60, 15);

        tir_afestkE.addItem("Todos","*");
        tir_afestkE.addItem("Suma","+");
        tir_afestkE.addItem("Resta","-");
        Pcabe.add(tir_afestkE);
        tir_afestkE.setBounds(450, 42, 70, 17);

        cLabel5.setText("Cliente");
        cLabel5.setPreferredSize(new java.awt.Dimension(50, 18));
        Pcabe.add(cLabel5);
        cLabel5.setBounds(10, 42, 50, 18);
        Pcabe.add(cli_codiE);
        cli_codiE.setBounds(69, 42, 330, 18);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        Pprinc.add(Pcabe, gridBagConstraints);

        ArrayList v=new ArrayList();
        v.add("Prod."); // 0
        v.add("Nombre Prod"); // 1
        v.add("Fecha"); // 2
        v.add("Individuo"); // 3
        v.add("Tipo Reg."); // 4
        v.add("Unid."); // 5
        v.add("Cant."); // 6
        v.add("Precio"); // 7
        v.add("Costo"); // 8 . rgs_prmeco
        v.add("rowid"); // 9
        jt.setCabecera(v);
        jt.setAnchoColumna(new int[]{40,150,90,90,120,40,70,60,60,1});
        jt.setAlinearColumna(new int[]{0,0,1,0,0,2,2,2,2,2});
        jt.setFormatoColumna(2, "dd-MM-yy HH:mm");
        jt.setFormatoColumna(6, "---,--9.99");
        jt.setFormatoColumna(7, "---9.99");
        jt.setFormatoColumna(8, "---9.99");
        jt.setAjustarGrid(true);
        jt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jt.setMaximumSize(new java.awt.Dimension(620, 161));
        jt.setMinimumSize(new java.awt.Dimension(620, 161));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 2.0;
        gridBagConstraints.insets = new java.awt.Insets(3, 0, 3, 0);
        Pprinc.add(jt, gridBagConstraints);

        Ppie.setMaximumSize(new java.awt.Dimension(579, 80));
        Ppie.setMinimumSize(new java.awt.Dimension(579, 80));
        Ppie.setPreferredSize(new java.awt.Dimension(579, 80));
        Ppie.setLayout(null);

        cLabel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cLabel11.setText("Entrada");
        Ppie.add(cLabel11);
        cLabel11.setBounds(10, 20, 70, 17);

        kgEntE.setEditable(false);
        Ppie.add(kgEntE);
        kgEntE.setBounds(90, 20, 70, 17);

        cLabel12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cLabel12.setText("Kilos");
        Ppie.add(cLabel12);
        cLabel12.setBounds(90, 0, 70, 17);

        uniEntE.setEditable(false);
        Ppie.add(uniEntE);
        uniEntE.setBounds(170, 20, 50, 17);

        impDifE.setEditable(false);
        Ppie.add(impDifE);
        impDifE.setBounds(230, 60, 80, 17);

        cLabel14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cLabel14.setText("Salida ");
        Ppie.add(cLabel14);
        cLabel14.setBounds(10, 40, 70, 17);

        kgSalE.setEditable(false);
        Ppie.add(kgSalE);
        kgSalE.setBounds(90, 40, 70, 17);

        cLabel15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cLabel15.setText("Unid.");
        Ppie.add(cLabel15);
        cLabel15.setBounds(170, 0, 50, 17);

        uniSalE.setEditable(false);
        Ppie.add(uniSalE);
        uniSalE.setBounds(170, 40, 50, 17);

        impSalE.setEditable(false);
        Ppie.add(impSalE);
        impSalE.setBounds(230, 40, 80, 17);

        cLabel17.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cLabel17.setText("Importe");
        Ppie.add(cLabel17);
        cLabel17.setBounds(230, 0, 80, 17);

        impEntE.setEditable(false);
        Ppie.add(impEntE);
        impEntE.setBounds(230, 20, 80, 17);

        cLabel18.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cLabel18.setText("Diferencia");
        Ppie.add(cLabel18);
        cLabel18.setBounds(10, 60, 70, 17);

        kgDifE.setEditable(false);
        Ppie.add(kgDifE);
        kgDifE.setBounds(90, 60, 70, 17);

        uniDifE.setEditable(false);
        Ppie.add(uniDifE);
        uniDifE.setBounds(170, 60, 50, 17);

        cLabel20.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cLabel20.setText("Ganancia");
        Ppie.add(cLabel20);
        cLabel20.setBounds(320, 0, 80, 17);

        ganEntE.setEditable(false);
        Ppie.add(ganEntE);
        ganEntE.setBounds(320, 20, 80, 17);

        ganDifE.setEditable(false);
        Ppie.add(ganDifE);
        ganDifE.setBounds(320, 60, 80, 17);

        ganSalE.setEditable(false);
        Ppie.add(ganSalE);
        ganSalE.setBounds(320, 40, 80, 17);

        Bactual.setText("Act. Costos");
        Bactual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BactualActionPerformed(evt);
            }
        });
        Ppie.add(Bactual);
        Bactual.setBounds(480, 30, 90, 24);

        opSobreescribir.setSelected(true);
        opSobreescribir.setText("Sobreescribir");
        Ppie.add(opSobreescribir);
        opSobreescribir.setBounds(480, 60, 90, 17);

        cLabel13.setText("Número Reg:");
        Ppie.add(cLabel13);
        cLabel13.setBounds(410, 0, 90, 17);

        numRegulE.setEditable(false);
        Ppie.add(numRegulE);
        numRegulE.setBounds(490, 0, 50, 17);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.gridheight = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        Pprinc.add(Ppie, gridBagConstraints);

        getContentPane().add(Pprinc, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    @Override
    public void iniciarVentana() throws Exception
    {
        dtAdd=new DatosTabla(ctUp);
        String s = "SELECT * FROM v_motregu ORDER BY tir_codi";
        if (dtCon1.select(s)) {
            do {
                tir_codiE.addDatos(dtCon1.getString("tir_codi"),
                        dtCon1.getString("tir_nomb") + "  (" + dtCon1.getString("tir_afestk")
                        + ")", true);
            } while (dtCon1.next());
        }
        cli_codiE.iniciar(dtStat,this,vl,EU);
        pro_codiE.iniciar(dtStat, this, vl, EU);
        fecfinE.setDate(Formatear.getDateAct() );
        feciniE.setDate(Formatear.sumaMesDate(Formatear.getDateAct(), -1));
    }
    boolean checkCondiciones()
    {
        if (fecfinE.getError() || fecfinE.isNull())
        {
            mensajeErr("Fecha Final NO VALIDA");
            return false;
        }
        if (feciniE.getError() || feciniE.isNull())
        {
            mensajeErr("Fecha Inicial NO Valida");
            return false;
        }
        return true;
    }
    private void BaceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BaceptarActionPerformed
     
     try 
     {
         if (!checkCondiciones())
             return;
         jt.removeAllDatos();
         String s="select r.*,a.pro_nomb from v_regstock as r,v_articulo as a where rgs_fecha between '"+feciniE.getFechaDB()+"' and '"+
             fecfinE.getFechaDB()+"' "+
             " and a.pro_codi = r.pro_codi "+
             " and tir_afestk != '=' "+
             (tir_afestkE.getValor().equals("*")?"":" and tir_afestk = '"+tir_afestkE.getValor()+"'")+
             (pro_codiE.isNull()?"":" and r.pro_codi = "+pro_codiE.getValorInt())+
             (cli_codiE.isNull()?"":" and rgs_cliprv="+cli_codiE.getValorInt())+
             (pro_artconC.getValor().equals("T")?"":" and pro_artcon "+
                 (pro_artconC.getValor().equals("0")?"":"!")+"= 0" )+
             (tir_codiE.isNull()?"":" and tir_codi = "+tir_codiE.getValorInt())+
             " order by tir_nomb,rgs_fecha";
         if (!dtCon1.select(s))
         {
             msgBox("No encontrados Regularizaciones para estos criterios");
             return;
         }
         double kilEnt=0,impEnt=0, kilSal=0,impSal=0,difEnt=0,difSal=0;
         int unidEnt=0,unidSal=0;
        
         do
         {
             ArrayList v=new ArrayList();
             v.add(dtCon1.getInt("pro_codi")); // 0
             v.add(dtCon1.getString("pro_nomb")); // 1
             v.add(dtCon1.getTimeStamp("rgs_fecha")); // 2
             v.add(dtCon1.getInt("eje_nume")+dtCon1.getString("pro_serie")+ 
                 dtCon1.getInt("pro_nupar")+"-"+dtCon1.getInt("pro_numind")); // 3
             v.add("("+dtCon1.getString("tir_afestk")+") "+dtCon1.getString("tir_nomb")); // 4
            v.add(dtCon1.getString("rgs_canti")); // 5
            v.add(dtCon1.getString("rgs_kilos")); // 6
            v.add(dtCon1.getString("rgs_prregu")); // 7
            v.add(dtCon1.getString("rgs_prmeco")); // 8
            v.add(dtCon1.getString("rgs_nume"));  // 9
            jt.addLinea(v);
            if (dtCon1.getString("tir_afestk").equals("+"))
            {
                kilEnt+=dtCon1.getDouble("rgs_kilos");
                unidEnt+=dtCon1.getDouble("rgs_canti");
                impEnt+=dtCon1.getDouble("rgs_kilos")*dtCon1.getDouble("rgs_prregu");
                difEnt+= (dtCon1.getDouble("rgs_kilos")*dtCon1.getDouble("rgs_prmeco"))-
                    (dtCon1.getDouble("rgs_kilos")*dtCon1.getDouble("rgs_prregu"));
                   
            }
            else
            {
                kilSal+=dtCon1.getDouble("rgs_kilos");
                unidSal+=dtCon1.getDouble("rgs_canti");
                impSal+=dtCon1.getDouble("rgs_kilos")*dtCon1.getDouble("rgs_prregu");
                difSal+=
                    (dtCon1.getDouble("rgs_kilos")*dtCon1.getDouble("rgs_prregu"))-
                    (dtCon1.getDouble("rgs_kilos")*dtCon1.getDouble("rgs_prmeco"));
            }
                
         } while (dtCon1.next());
         kgEntE.setValorDec(kilEnt);
         uniEntE.setValorDec(unidEnt);
         impEntE.setValorDec(impEnt);
         ganEntE.setValorDec(difEnt);
         
         kgSalE.setValorDec(kilSal);
         uniSalE.setValorDec(unidSal);
         impSalE.setValorDec(impSal);        
         ganSalE.setValorDec(difSal);
         
         kgDifE.setValorDec(kilEnt-kilSal);
         uniDifE.setValorDec(unidEnt-unidSal);
         impDifE.setValorDec(impEnt-impSal);
         ganDifE.setValorDec(difEnt-difSal);
         numRegulE.setValorInt(jt.getRowCount());
         
     } catch (SQLException | ParseException k)
     {
       Error("Error al realizar busqueda",k);  
     }
    }//GEN-LAST:event_BaceptarActionPerformed

    private void BactualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BactualActionPerformed
      try
      {         
          if (!checkCondiciones())
              return;
          feulin=MvtosAlma.getFechaUltInv(dtStat,feciniE.getDate(),0);
          String s= "SELECT mv.pro_codi,  mvt_time as fecmov,mvt_tipo as tipmov,mvt_tipdoc,mvt_numdoc, "              
              + " mvt_canti as canti,mvt_prec as precio,mv.alm_codi "
              + " from mvtosalm as mv, v_articulo as a where "
              + " mvt_canti <> 0 "
              + " and NOT (mvt_tipdoc = 'V' and mvt_serdoc='X')"
              + " and a.pro_codi = mv.pro_codi "              
              + " and mv.pro_codi  "
              + (pro_codiE.isNull()?" in (select distinct(pro_codi) from v_regstock"
              + " where rgs_fecha between '"+feciniE.getFechaDB()+"' and '"+fecfinE.getFechaDB()+"') ":
                 "  =  "+pro_codiE.getValorInt())
              +(cli_codiE.isNull()?"":" and rgs_cliprv="+cli_codiE.getValorInt())
              + (pro_artconC.getValor().equals("T")?"":" and pro_artcon "+
                (pro_artconC.getValor().equals("0")?"":"!")+"= 0" )
              + " AND mvt_time::date >= '"+ Formatear.getFechaDB(feulin)+ "'"
              + " and mvt_time::date <=  '"+fecfinE.getFechaDB()+"'"           
              + " ORDER BY mv.pro_codi,fecmov,tipmov"; // producto, fecha,tipo
          if (!dtCon1.select(s))
          {
              msgBox("No encontrados registros con estas condiciones");
              return;
          }
      } catch (SQLException | ParseException ex)
      {
          Error("ERROR al actualizar costos de regularización",ex);
      }
      new miThread("xx")
          {
            @Override
            public void run()
            {
                msgEspere("Actualizando costos.. espere");
                actualizarCostos();
                resetMsgEspere();
            }
      };
    }
      
    void actualizarCostos()
    {
        try {
          int proCodi=dtCon1.getInt("pro_codi");
          String s;
          HashMap<String,Double> ht=MvtosAlma.getDatosInventario(dtStat,dtCon1.getInt("pro_codi"),feulin);
          boolean swActual;
          double kilos=ht.get("kilos");
          double costo=ht.get("importe")/kilos;
          if (kilos==0)
              costo=0;
          int nRegUpd=0;
          int tirCodi=tir_codiE.getValorInt();
          String tirAfeStk=tir_afestkE.getValor();
          Date fecInicial=feciniE.getDate();
          setMensajePopEspere("Actualizando producto: "+dtCon1.getInt("pro_codi"),false);
          do
          {             
              if (dtCon1.getInt("pro_codi")!=proCodi)
              {
                  setMensajePopEspere("Actualizando producto: "+dtCon1.getInt("pro_codi"),false);
                  proCodi=dtCon1.getInt("pro_codi");
                  ht=MvtosAlma.getDatosInventario(dtStat,proCodi,feulin); 
                  
                  kilos=ht.get("kilos");
                  costo=ht.get("importe")/kilos;
                  if (kilos==0)
                      costo=0;                  
              }
              if (dtCon1.getString("mvt_tipdoc").equals("R"))
              {
                  swActual=true;
                  if (! tirAfeStk.equals("*") && !tirAfeStk.equals(dtCon1.getString("tipmov")))
                      swActual=false;
                  if (Formatear.comparaFechas(dtCon1.getDate("fecmov"), fecInicial)<0)
                      swActual=false;
                  if (swActual)
                  {
                    s="select tir_codi,rgs_prmeco from regalmacen where rgs_nume= "+dtCon1.getInt("mvt_numdoc");
                    if (! dtAdd.select(s,true))
                          swActual = false;
                  }
                  if (swActual)
                  {
                    if (tirCodi!=0  && tirCodi!=dtAdd.getInt("tir_codi"))
                          swActual=false;                    
                    if (dtAdd.getDouble("rgs_prmeco")!=0 && !opSobreescribir.isSelected())
                        swActual=false;
                  }
                  if (swActual )
                  {
                      dtAdd.edit();
                      try {
                        dtAdd.setDato("rgs_prmeco",Formatear.redondea(costo,4));
                      } catch (java.lang.NumberFormatException ex)
                      {
                          msgBox("costo erroneo: "+costo+" en articulo: "+proCodi);
                          dtAdd.setDato("rgs_prmeco",0);
                      }
                      dtAdd.update();
                      nRegUpd++;
                  }                 
              }
              if (dtCon1.getString("tipmov").equals("E"))
              {
                double kilCalc=kilos<0.1?0:kilos;
                if (kilCalc +dtCon1.getDouble("canti")<0.1)
                    costo=0;
                else
                    costo= ((kilCalc*costo)+
                    (dtCon1.getDouble("canti")*dtCon1.getDouble("precio")))/ (kilCalc +dtCon1.getDouble("canti")) ;
                System.out.println(" Articulo: "+ proCodi+" Fecha: "+dtCon1.getFecha("fecmov","dd-MM-yy HH:mm")+
                  " Cantidad: "+dtCon1.getDouble("canti")+" kilos: "+kilos+" Costo: "+costo);
                kilos+=dtCon1.getDouble("canti");                               
                
              }
              else
              {                         
                kilos-=dtCon1.getDouble("canti");               
              }
          } while (dtCon1.next());
        
          mensajeErr("Actualizados "+nRegUpd+" costos de Regularizaciones");
          dtAdd.commit();
      } catch (SQLException | ParseException ex )
      {
          Error("ERROR al actualizar costos de regularización",ex);
      }
    }//GEN-LAST:event_BactualActionPerformed
    
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private gnu.chu.controles.CButton Baceptar;
    private gnu.chu.controles.CButton Bactual;
    private gnu.chu.controles.CPanel Pcabe;
    private gnu.chu.controles.CPanel Ppie;
    private gnu.chu.controles.CPanel Pprinc;
    private gnu.chu.controles.CLabel cLabel1;
    private gnu.chu.controles.CLabel cLabel10;
    private gnu.chu.controles.CLabel cLabel11;
    private gnu.chu.controles.CLabel cLabel12;
    private gnu.chu.controles.CLabel cLabel13;
    private gnu.chu.controles.CLabel cLabel14;
    private gnu.chu.controles.CLabel cLabel15;
    private gnu.chu.controles.CLabel cLabel17;
    private gnu.chu.controles.CLabel cLabel18;
    private gnu.chu.controles.CLabel cLabel2;
    private gnu.chu.controles.CLabel cLabel20;
    private gnu.chu.controles.CLabel cLabel3;
    private gnu.chu.controles.CLabel cLabel4;
    private gnu.chu.controles.CLabel cLabel5;
    private gnu.chu.controles.CLabel cLabel9;
    private gnu.chu.camposdb.cliPanel cli_codiE;
    private gnu.chu.controles.CTextField fecfinE;
    private gnu.chu.controles.CTextField feciniE;
    private gnu.chu.controles.CTextField ganDifE;
    private gnu.chu.controles.CTextField ganEntE;
    private gnu.chu.controles.CTextField ganSalE;
    private gnu.chu.controles.CTextField impDifE;
    private gnu.chu.controles.CTextField impEntE;
    private gnu.chu.controles.CTextField impSalE;
    private gnu.chu.controles.Cgrid jt;
    private gnu.chu.controles.CTextField kgDifE;
    private gnu.chu.controles.CTextField kgEntE;
    private gnu.chu.controles.CTextField kgSalE;
    private gnu.chu.controles.CTextField numRegulE;
    private gnu.chu.controles.CCheckBox opSobreescribir;
    private gnu.chu.controles.CComboBox pro_artconC;
    private gnu.chu.camposdb.proPanel pro_codiE;
    private gnu.chu.controles.CComboBox tir_afestkE;
    private gnu.chu.controles.CLinkBox tir_codiE;
    private gnu.chu.controles.CTextField uniDifE;
    private gnu.chu.controles.CTextField uniEntE;
    private gnu.chu.controles.CTextField uniSalE;
    // End of variables declaration//GEN-END:variables
}
