package gnu.chu.anjelica.pad;
/**
 *
 * <p>Titulo: MantPaises  </p>
 * <p>Descripción: Mantenimiento Paises</p>
 * <p>Copyright: Copyright (c) 2005-2016
 *  Este programa es software libre. Puede redistribuirlo y/o modificarlo bajo
 *  los terminos de la Licencia P�blica General de GNU seg�n es publicada por
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
 * @version 1.0 Realizado el mantenimiento.
 *
 */
import gnu.chu.Menu.Principal;
import gnu.chu.controles.StatusBar;
import gnu.chu.interfaces.PAD;
import gnu.chu.sql.DatosTabla;
import gnu.chu.utilidades.EntornoUsuario;
import gnu.chu.utilidades.Iconos;
import gnu.chu.utilidades.navegador;
import gnu.chu.utilidades.ventanaPad;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.KeyEvent;
import java.net.UnknownHostException;
import java.sql.SQLException;
import java.sql.Types;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Locale;

public class MantPaises extends   ventanaPad  implements PAD
{
    boolean modConsulta=false;
    String s;
    public final static int PAI_ESPANA=11;
   
    public MantPaises(EntornoUsuario eu, Principal p) {
        this(eu, p, null);
    }

    public MantPaises(EntornoUsuario eu, Principal p, Hashtable ht) {
        EU = eu;
        vl = p.panel1;
        jf = p;
        eje = true;

        try
        {
            if (ht != null)
            {
                if (ht.get("modConsulta") != null)
                    modConsulta = Boolean.valueOf(ht.get("modConsulta").toString());
            }
            setTitulo("Mantenimiento Paises");
            if (jf.gestor.apuntar(this))
                jbInit();
            else
                setErrorInit(true);
        } catch (Exception e)
        {
          ErrorInit(e);
        }
    }

    public MantPaises(gnu.chu.anjelica.menu p, EntornoUsuario eu, Hashtable ht) {
        EU = eu;
        vl = p.getLayeredPane();
        eje = false;

        try
        {
            if (ht != null)
            {
                if (ht.get("modConsulta") != null)
                {
                    modConsulta = Boolean.valueOf(ht.get("modConsulta").toString());
                }
            }
            setTitulo("Mantenimiento Paises");
            jbInit();
        } catch (Exception e)
        {
           ErrorInit(e);
        }
    }

    private void jbInit() throws Exception {
        statusBar = new StatusBar(this);
        nav = new navegador(this, dtCons, false, modConsulta ? navegador.CURYCON : navegador.NORMAL);
        iniciarFrame();
        this.setResizable(false);

        this.setVersion("2016-05-19" + (modConsulta ? "SOLO LECTURA" : ""));
        strSql = "SELECT * FROM paises  "
            + " ORDER BY pai_codi ";

        this.getContentPane().add(nav, BorderLayout.NORTH);
        this.getContentPane().add(statusBar, BorderLayout.SOUTH);
        this.setPad(this);
        dtCons.setLanzaDBCambio(false);
        initComponents();
        iniciarBotones(Baceptar, Bcancelar);

        conecta();
        navActivarAll();
        this.setSize(413, 229);
        activar(false);
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
        cLabel1 = new gnu.chu.controles.CLabel();
        pai_codiE = new gnu.chu.controles.CTextField(Types.DECIMAL,"###9");
        cLabel2 = new gnu.chu.controles.CLabel();
        pai_activE = new gnu.chu.controles.CComboBox();
        cLabel3 = new gnu.chu.controles.CLabel();
        pai_nombE = new gnu.chu.controles.CTextField(Types.CHAR,"X",50);
        cLabel4 = new gnu.chu.controles.CLabel();
        pai_inicE = new gnu.chu.controles.CTextField(Types.CHAR,"X",2);
        cLabel5 = new gnu.chu.controles.CLabel();
        pai_estcroE = new gnu.chu.controles.CTextField(Types.CHAR,"X",30);
        cLabel6 = new gnu.chu.controles.CLabel();
        pai_coisaE = new gnu.chu.controles.CTextField(Types.DECIMAL,"####9");
        Bcancelar = new gnu.chu.controles.CButton(Iconos.getImageIcon("cancel"));
        Baceptar = new gnu.chu.controles.CButton(Iconos.getImageIcon("check"));
        cLabel7 = new gnu.chu.controles.CLabel();
        pai_nomcorE = new gnu.chu.controles.CTextField(Types.CHAR,"X",5);
        cLabel8 = new gnu.chu.controles.CLabel();
        loc_codiE = new gnu.chu.controles.CLinkBox();

        Pprinc.setLayout(null);

        cLabel1.setText("Codigo");
        Pprinc.add(cLabel1);
        cLabel1.setBounds(10, 2, 49, 15);
        Pprinc.add(pai_codiE);
        pai_codiE.setBounds(63, 1, 42, 17);

        cLabel2.setText("Activo");
        Pprinc.add(cLabel2);
        cLabel2.setBounds(271, 2, 49, 15);

        pai_activE.addItem("Si","-1");
        pai_activE.addItem("No","0");
        Pprinc.add(pai_activE);
        pai_activE.setBounds(324, 0, 60, 20);

        cLabel3.setText("Nombre Corto ");
        Pprinc.add(cLabel3);
        cLabel3.setBounds(10, 47, 90, 15);
        Pprinc.add(pai_nombE);
        pai_nombE.setBounds(60, 25, 321, 17);

        cLabel4.setText("Iniciales");
        Pprinc.add(cLabel4);
        cLabel4.setBounds(147, 2, 49, 15);

        pai_inicE.setMayusc(true);
        Pprinc.add(pai_inicE);
        pai_inicE.setBounds(200, 1, 30, 17);

        cLabel5.setText("Idioma");
        Pprinc.add(cLabel5);
        cLabel5.setBounds(10, 90, 50, 15);

        pai_estcroE.setMayusc(true);
        Pprinc.add(pai_estcroE);
        pai_estcroE.setBounds(120, 68, 198, 17);

        cLabel6.setText("Codigo ISO");
        Pprinc.add(cLabel6);
        cLabel6.setBounds(260, 47, 70, 15);
        Pprinc.add(pai_coisaE);
        pai_coisaE.setBounds(330, 47, 51, 17);

        Bcancelar.setText("Cancelar");
        Pprinc.add(Bcancelar);
        Bcancelar.setBounds(230, 120, 103, 34);

        Baceptar.setText("Aceptar");
        Pprinc.add(Baceptar);
        Baceptar.setBounds(60, 120, 104, 34);

        cLabel7.setText("Nombre");
        Pprinc.add(cLabel7);
        cLabel7.setBounds(10, 25, 49, 15);

        pai_nomcorE.setMayusc(true);
        Pprinc.add(pai_nomcorE);
        pai_nomcorE.setBounds(120, 47, 90, 17);

        cLabel8.setText("Estructura Crotal");
        Pprinc.add(cLabel8);
        cLabel8.setBounds(10, 68, 101, 15);

        loc_codiE.setAceptaNulo(false);
        loc_codiE.setAncTexto(50);
        Pprinc.add(loc_codiE);
        loc_codiE.setBounds(60, 90, 320, 17);

        getContentPane().add(Pprinc, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private gnu.chu.controles.CButton Baceptar;
    private gnu.chu.controles.CButton Bcancelar;
    private gnu.chu.controles.CPanel Pprinc;
    private gnu.chu.controles.CLabel cLabel1;
    private gnu.chu.controles.CLabel cLabel2;
    private gnu.chu.controles.CLabel cLabel3;
    private gnu.chu.controles.CLabel cLabel4;
    private gnu.chu.controles.CLabel cLabel5;
    private gnu.chu.controles.CLabel cLabel6;
    private gnu.chu.controles.CLabel cLabel7;
    private gnu.chu.controles.CLabel cLabel8;
    private gnu.chu.controles.CLinkBox loc_codiE;
    private gnu.chu.controles.CComboBox pai_activE;
    private gnu.chu.controles.CTextField pai_codiE;
    private gnu.chu.controles.CTextField pai_coisaE;
    private gnu.chu.controles.CTextField pai_estcroE;
    private gnu.chu.controles.CTextField pai_inicE;
    private gnu.chu.controles.CTextField pai_nombE;
    private gnu.chu.controles.CTextField pai_nomcorE;
    // End of variables declaration//GEN-END:variables

    @Override
    public void PADPrimero() {
        verDatos();
    }

    @Override
    public void PADAnterior() {
         verDatos();
    }

    @Override
    public void PADSiguiente() {
         verDatos();
    }

    @Override
    public void PADUltimo() {
        verDatos();
    }
    @Override
    public boolean checkAddNew()
    {
        try {
          if (getRegistro(pai_codiE.getValorInt(), dtStat))
          {
              mensajeErr("Codigo de Pais ya esta en uso");
              pai_codiE.requestFocus();
              return false;
          }
         
        } catch (SQLException k)
        {
           Error("Error al comprobrar registro",k); 
        }
        return checkEdit();
    }
    @Override
    public boolean checkEdit()
 {
     if (pai_nombE.isNull())
     {
         mensajeErr("Introduzca Nombre de Pais");
         pai_nombE.requestFocus();
         return false;
     }
     if (pai_nomcorE.isNull())
     {
         mensajeErr("Introduzca Nombre Corto de Pais");
         pai_nomcorE.requestFocus();
         return false;
     }
     if (pai_inicE.isNull())
     {
         mensajeErr("Introduzca Iniciales de Pais");
        pai_inicE.requestFocus();
        return false; 
     }
     if (loc_codiE.getError() || loc_codiE.isNull())
     {
        mensajeErr(" Idioma de Pais no valido");
        loc_codiE.requestFocus();
        return false; 
     }
     try 
     {
      if (!pai_inicE.getText().equals(pai_inicE.getTextAnt()))
      {
          if (getRegistro(pai_inicE.getText(), dtStat))
          {
              mensajeErr("Iniciales de Pais ya esta en uso");
              pai_codiE.requestFocus();
              return false;
          }
      }
     } catch (SQLException k)
     {
         Error("Error al comprobar iniciales del pais",k);
     }
     return true;
    }
    @Override
    public void ej_edit1() {
        try
   {
     dtAdd.edit();
     actDatos(dtAdd);
     resetBloqueo(dtAdd,"paises", pai_codiE.getText());
     ctUp.commit();
   }
   catch (Throwable ex)
   {
     Error("Error al Modificar datos", ex);
     return;
   }
   mensaje("");
   mensajeErr("Datos ... Modificados");
   activaTodo();
   verDatos();
    }
   void actDatos(DatosTabla dt) throws Exception {
        dt.setDato("pai_nomb", pai_nombE.getText());
        dt.setDato("pai_nomcor", pai_nomcorE.getText());
        dt.setDato("pai_activ", pai_activE.getValor());
        dt.setDato("pai_inic", pai_inicE.getText());
        dt.setDato("loc_codi", loc_codiE.getText());
        dt.setDato("pai_coisa", pai_coisaE.getText());
        dt.setDato("pai_estcro", pai_estcroE.getText());
        dt.update();
   }
    @Override
    public void canc_edit() {
        mensaje("");
        try
        {
            resetBloqueo(dtAdd, "paises", pai_codiE.getText());
        }
        catch (Exception ex)
        {
            Error("Error al Quitar Bloqueo", ex);
            return;
        }
        mensajeErr("Modificacion de Datos Cancelada");
        activaTodo();
        verDatos();
    }

    
    @Override
    public void ej_addnew1() {
          try {
           
            dtAdd.addNew("paises");
            dtAdd.setDato("pai_codi", pai_codiE.getText());

            actDatos(dtAdd);
           
            dtAdd.commit();
            mensajeErr("Alta ... REALIZADA");
            mensaje("");
            activaTodo();
        } catch (Exception k) {
            Error("Error al Insertar Pais", k);
        }
    }

    @Override
    public void canc_addnew() {
        mensaje("");
        mensajeErr("Cancelada Alta ...");
        verDatos();
        activaTodo();
    }

    @Override
    public void activar(boolean b) {
       pai_codiE.setEnabled(b);
       pai_nombE.setEnabled(b);
       pai_nomcorE.setEnabled(b);
       pai_activE.setEnabled(b);
       pai_coisaE.setEnabled(b);
       pai_estcroE.setEnabled(b);
       pai_inicE.setEnabled(b);
       loc_codiE.setEnabled(b);
       Bcancelar.setEnabled(b);
       Baceptar.setEnabled(b);
    }
    @Override
    public void iniciarVentana() throws Exception {
        loc_codiE.addDatos(MantIdiomas.getDatos(dtCon1));
        Pprinc.setButton(KeyEvent.VK_F4, Baceptar);
        pai_codiE.setColumnaAlias("pai_codi");
        pai_nombE.setColumnaAlias("pai_nomb");
        pai_nomcorE.setColumnaAlias("pai_nomcor");        
        pai_activE.setColumnaAlias("pai_activ");
        pai_inicE.setColumnaAlias("pai_inic");
        loc_codiE.setColumnaAlias("loc_codi");
        pai_coisaE.setColumnaAlias("pai_coisa");
        pai_estcroE.setColumnaAlias("pai_estcroE");
        
        verDatos();
    }
    void verDatos()
    {
        try
        {
            if (dtCons.getNOREG())
                return;
            if (! getRegistro(dtCons.getInt("pai_codi"),dtStat))
            {
                Pprinc.resetTexto();
                pai_codiE.setValorInt(dtCons.getInt("pai_codi"));
                msgBox("Datos de pais: "+pai_codiE.getValorInt()+" No encontrados");
                return;
            }
            pai_codiE.setValorInt(dtStat.getInt("pai_codi"));
            pai_nombE.setText(dtStat.getString("pai_nomb"));
            pai_nomcorE.setText(dtStat.getString("pai_nomcor"));            
            pai_activE.setValor(dtStat.getInt("pai_activ"));
            pai_inicE.setText(dtStat.getString("pai_inic"));
            loc_codiE.setText(dtStat.getString("loc_codi"));
            pai_coisaE.setValorInt(dtStat.getInt("pai_coisa"));
            pai_estcroE.setText(dtStat.getString("pai_estcro"));
        } catch (SQLException k)
        {
            Error("Error al ver datos de paises",k);
        }
    }
     @Override
    public void PADQuery() {
//        System.out.println("Alto: "+this.getSize().height+" Ancho: "+this.getSize().width);
        activar(true);
      
        Pprinc.setQuery(true);
        Pprinc.resetTexto();
       
        mensajeErr("Introduzca criterios para Filtro de Busqueda");
        pai_codiE.requestFocus();
    }
    @Override
    public void ej_query1(){
     Component c;
     if ( (c = Pprinc.getErrorConf()) != null)
     {
        c.requestFocus();
        mensaje("Error en Criterios de busqueda");
        return;
     }
   

    ArrayList v = new ArrayList();
    v.add(pai_codiE.getStrQuery());
    v.add(pai_nombE.getStrQuery());
    v.add(pai_nomcorE.getStrQuery());
    v.add(pai_activE.getStrQuery());
    v.add(pai_inicE.getStrQuery());
    v.add(loc_codiE.getStrQuery());
    v.add(pai_coisaE.getStrQuery());
    v.add(pai_estcroE.getStrQuery());
    

    s = "SELECT * FROM paises ";
    s = creaWhere(s, v,true);
    s+=" ORDER BY pai_codi ";
    Pprinc.setQuery(false);
    
    try
    {
      if (!dtCons.select(s))
      {
        mensaje("");
        mensajeErr("No encontrados Registros para estos criterios");
        rgSelect();
        activaTodo();
        verDatos();
        return;
      }
      mensaje("");
      strSql = s;
      activaTodo();
      rgSelect();
      verDatos();
      mensajeErr("Nuevos registros selecionados");
    }
    catch (Exception ex)
    {
      fatalError("Error al buscar Representantes: ", ex);
    }

 }
    @Override
  public void PADAddNew(){
  
   activar(true);
   mensaje("Insertando Pais ...");
   Pprinc.resetTexto();
   s="select max(pai_codi) as pai_codi from paises";
   try
   {
    dtStat.select(s);
    pai_codiE.setValorInt(dtStat.getInt("pai_codi",true)+1);
   } catch (SQLException k)
   {
       Error("Error al buscar siguiente codigo de pais",k);
   }
   pai_inicE.resetCambio();
   pai_codiE.requestFocus();
 }
@Override
 public void PADEdit(){
   activar(true);
   try
   {
     if ( ! lockRegistro())
            return;
   }
   catch (UnknownHostException | SQLException | ParseException k)
   {
     Error("Error al bloquear el registro", k);
     return;
   }
   pai_codiE.setEnabled(false);
   pai_nombE.requestFocus();
   pai_inicE.resetCambio();
   mensaje("Modificando datos de registro activo ...");
 }
 @Override
 public void PADDelete(){
     try
     {
       if (pai_codiE.getValorInt()== EU.getLikeUsuario().getInt("pai_codi"))
       {
           msgBox("Pais de empresa NO se puede BORRAR");
           nav.pulsado=navegador.NINGUNO;
           activaTodo();
           return;
       }
       if (! lockRegistro())
           return;
     }
     catch (UnknownHostException | SQLException | ParseException k)
     {
       Error("Error al bloquear el registro", k);
       return;
     }
     Baceptar.setEnabled(true);
     Bcancelar.setEnabled(true);
     Bcancelar.requestFocus();
     mensaje("Borrar registro activo ...");
 }
    @Override
 public void ej_delete1(){
   try
     {
       dtAdd.delete(stUp);
       
       resetBloqueo(dtAdd, "paises", pai_codiE.getText());
       ctUp.commit();
       rgSelect();
     }
     catch (Exception ex)
     {
       Error("Error al borrar Registro",ex);
     }
     activaTodo();
     verDatos();
     mensaje("");
     mensajeErr("Registro ... Borrado");
 }

    @Override
 public void canc_delete(){
   mensaje("");
   try
   {
     resetBloqueo(dtAdd, "paises", pai_codiE.getText());
   }
   catch (Exception ex)
   {
     Error("Error al Quitar Bloqueo", ex);
     return;
   }
   mensajeErr("Borrado de Datos Cancelada");
   activaTodo();
   verDatos();
 }
  private boolean lockRegistro() throws UnknownHostException, SQLException, ParseException {
        if (!setBloqueo(dtAdd, "paises", pai_codiE.getText())) {
            msgBox(msgBloqueo);
            nav.pulsado = navegador.NINGUNO;
            activaTodo();
            dtAdd.getConexion().rollback();
            return false;
        }
        if (!dtAdd.select("SELECT * FROM paises WHERE pai_codi = '" + pai_codiE.getText() + "'", true)) {
            mensajeErr("Registro ha sido borrado");
            resetBloqueo(dtAdd, "paises", pai_codiE.getText());
            activaTodo();
            mensaje("");
            return false;
        }
        return true;
    }
 @Override
 public void canc_query(){
   Pprinc.setQuery(false);

   activaTodo();
   verDatos();
   mensajeErr("Introducion filtro busqueda ... CANCELADO");
   mensaje("");
 }
    /**
     * Devuelve en el datostabla mandado el registro que indica el pais mandado
     * @param paiCodi
     * @param dt
     * @return true si encuentra el registro.
     * @throws SQLException 
     */
    public static boolean getRegistro(int paiCodi, DatosTabla dt) throws SQLException
    {
        return dt.select("select * from paises where pai_codi = "+paiCodi);
    }
    public static boolean getRegistro(String paiInic, DatosTabla dt) throws SQLException
    {
        return dt.select("select * from paises where pai_inic = '"+paiInic+"'");
    }
    /**
     * Busca un Pais por sus iniciales
     * @param paiInic
     * @param dt
     * @return
     * @throws SQLException 
     */
    public static String getNombrePais(String paiInic, DatosTabla dt) throws SQLException
    {
        if (! dt.select("select * from paises where pai_inic = '"+paiInic+"'"))
            return null;
        return dt.getString("pai_nomb");
    }
    public static String getNombrePais(int paiCodi, DatosTabla dt) throws SQLException
    {
        if (! dt.select("select * from paises where pai_codi = "+paiCodi))
            return null;
        return dt.getString("pai_nomb");
    }
     public static String getNombreCortoPais(int paiCodi, DatosTabla dt) throws SQLException
    {
        if (! dt.select("select * from paises where pai_codi = "+paiCodi))
            return null;
        return dt.getString("pai_nomcor");
        
    }
    public static String getInicialesPais(int paiCodi, DatosTabla dt) throws SQLException
    {
        if (! dt.select("select pai_inic from paises where pai_codi = "+paiCodi))
            return null;
        return dt.getString("pai_inic");
    }
    public static String getLocalePais(int paiCodi, DatosTabla dt) throws SQLException
    {
        if (! dt.select("select loc_codi from paises where pai_codi = "+paiCodi))
            return null;
        return dt.getString("loc_codi",true);
    }

}
