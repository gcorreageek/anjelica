/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gnu.chu.anjelica.almacen;

import gnu.chu.Menu.Principal;
import gnu.chu.controles.StatusBar;
import gnu.chu.utilidades.EntornoUsuario;
import gnu.chu.utilidades.Iconos;
import gnu.chu.utilidades.ventana;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Types;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author chuchip
 */
public class CheckMvtos extends ventana
{
  MvtosAlma mvtos;
  ArrayList<String>  listIndiv=new ArrayList(); 
  public CheckMvtos(EntornoUsuario eu, Principal p)
  {
    EU = eu;
    vl = p.panel1;
    jf = p;
    eje = true;

    setTitulo("Comprueba mvtos VS Documentos");

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

  public CheckMvtos(gnu.chu.anjelica.menu p, EntornoUsuario eu)
  {
    EU = eu;
    vl = p.getLayeredPane();
    setTitulo("Comprueba mvtos VS Documentos");
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

      this.setVersion("2016-05-01");
      statusBar = new StatusBar(this);
      this.getContentPane().add(statusBar, BorderLayout.SOUTH);
      conecta();

      initComponents();
      this.setSize(new Dimension(750,500));
      Pcabe.setDefButton(Baceptar);
   
  }
  @Override
  public void iniciarVentana() throws Exception
  { 
    pdalmace.llenaLinkBox(alm_codiE,dtStat);
    mvtos=new MvtosAlma();
    activarEventos();
   
  }
  void activarEventos()
  {
    Baceptar.addActionListener(new ActionListener() {
            @Override
        public void actionPerformed(ActionEvent e)
        {
            consultar();
        }
    });
  }
  
  void consultar()
  {
      try
      {
          mvtos.setUsaDocumentos(true);
          mvtos.setFechasDocumento(false);
          mvtos.setDesglIndiv(true);
          mvtos.setIncIniFechaInv(true);
          mvtos.setAlmacen(alm_codiE.getValorInt());
          String sql=mvtos.getSqlMvt(feciniE.getFecha("dd-MM-yyyy"), fecfinE.getFecha("dd-MM-yyyy"),0);
          DatIndiv dtInd;
          ArrayList v=new ArrayList();
          int row;
          StringBuffer s;
          if (dtCon1.select(sql))
          {
              do
              {
                  char sel;
                  switch (dtCon1.getString("sel"))
                  {
                      case "CO":
                          sel='C';
                          break;
                       case "VE":
                          sel='V';
                          break;
                       case "DS":
                          sel='D';
                          break;
                       case "DE":
                          sel='d';
                          break;
                       case "RE":
                          sel=dtCon1.getString("tipmov").equals("=")?'i':'R';
                          break;
                        default:
                           throw new SQLException("Tipo Mvto: "+dtCon1.getString("sel")+" No valido");
                  }
                listIndiv.add( (dtCon1.getString("tipmov").equals("+")?"E":
                    (dtCon1.getString("tipmov").equals("-")?"S":"="))+"|"+
                    sel+"|"+
                  dtCon1.getInt("alm_codi")+"|"+
                  dtCon1.getInt("pro_codori")+"|"+
                  dtCon1.getInt("ejeNume")+"|"+
                  dtCon1.getString("serie")+"|"+
                  dtCon1.getInt("lote")+"|"+
                  dtCon1.getInt("numind")+"|"+
                  dtCon1.getDouble("canti"));
              } while (dtCon1.next());
          }
      } catch (ParseException | SQLException ex)
      {
          Error("Error al buscar mvtos", ex);
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

        Pprinc = new gnu.chu.controles.CPanel();
        Pcabe = new gnu.chu.controles.CPanel();
        cLabel1 = new gnu.chu.controles.CLabel();
        alm_codiE = new gnu.chu.controles.CLinkBox();
        cLabel4 = new gnu.chu.controles.CLabel();
        feciniE = new gnu.chu.controles.CTextField(Types.DATE,"dd-MM-yyyy");
        cLabel5 = new gnu.chu.controles.CLabel();
        fecfinE = new gnu.chu.controles.CTextField(Types.DATE,"dd-MM-yyyy");
        Baceptar = new gnu.chu.controles.CButton(Iconos.getImageIcon("check"));

        Pprinc.setLayout(null);

        Pcabe.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        Pcabe.setLayout(null);

        cLabel1.setText("Almacen");
        Pcabe.add(cLabel1);
        cLabel1.setBounds(2, 2, 62, 18);

        alm_codiE.setAncTexto(30);
        Pcabe.add(alm_codiE);
        alm_codiE.setBounds(70, 2, 240, 18);

        cLabel4.setText("De Fecha");
        Pcabe.add(cLabel4);
        cLabel4.setBounds(0, 22, 62, 18);

        feciniE.setMinimumSize(new java.awt.Dimension(10, 18));
        feciniE.setPreferredSize(new java.awt.Dimension(10, 18));
        Pcabe.add(feciniE);
        feciniE.setBounds(70, 22, 79, 18);

        cLabel5.setText("A Fecha");
        Pcabe.add(cLabel5);
        cLabel5.setBounds(170, 22, 44, 18);

        fecfinE.setMinimumSize(new java.awt.Dimension(10, 18));
        fecfinE.setPreferredSize(new java.awt.Dimension(10, 18));
        Pcabe.add(fecfinE);
        fecfinE.setBounds(220, 22, 79, 18);

        Baceptar.setText("Aceptar");
        Pcabe.add(Baceptar);
        Baceptar.setBounds(300, 20, 90, 31);

        Pprinc.add(Pcabe);
        Pcabe.setBounds(0, 0, 400, 60);

        getContentPane().add(Pprinc, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private gnu.chu.controles.CButton Baceptar;
    private gnu.chu.controles.CPanel Pcabe;
    private gnu.chu.controles.CPanel Pprinc;
    private gnu.chu.controles.CLinkBox alm_codiE;
    private gnu.chu.controles.CLabel cLabel1;
    private gnu.chu.controles.CLabel cLabel4;
    private gnu.chu.controles.CLabel cLabel5;
    private gnu.chu.controles.CTextField fecfinE;
    private gnu.chu.controles.CTextField feciniE;
    // End of variables declaration//GEN-END:variables
}

class DatIndivMvto extends DatIndivBase
{
   int swDocu=-1; // Es tipo documento?
   char tipDocu;
   char tipMvto;
   java.util.Date fecMvto;
   
}
