package interfaz;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import articulos.Articulos;
import auxiliares.RellenarCeros;
import conexiones.ConexionServFumaca;

public class TextBox {
	public JTextField txtIDProducto,txtCantidad,txtCantXCaja;
	public JComboBox cmbUsuario;
	private Connection conn;

	
	RellenarCeros ceros=new RellenarCeros();

	public TextBox() {
		cmbUsuario=new JComboBox();
		cmbUsuario.setBounds(170,305,300,35);
		cmbUsuario.setForeground(new Color(0,0,102));
		cmbUsuario.setFont(new Font("Adobe Hebrew", Font.BOLD , 15));	
		cargarCombo();
		
		txtIDProducto=new JTextField();
		txtIDProducto.setBounds(170,355,300,35);
		txtIDProducto.setForeground(new Color(0,0,102));
		txtIDProducto.setFont(new Font("Adobe Hebrew", Font.BOLD , 15));
		
		txtCantidad=new JTextField();
		txtCantidad.setBounds(170,405,100,35);
		txtCantidad.setForeground(new Color(0,0,102));
		txtCantidad.setFont(new Font("Adobe Hebrew", Font.BOLD , 15));
		txtCantidad.setEnabled(false);
		txtCantidad.addKeyListener(new KeyAdapter()
		{
			   public void keyTyped(KeyEvent e){				   
			      char caracter = e.getKeyChar();

			      // Verificar si la tecla pulsada no es un digito
			      if(((caracter < '0') ||
			         (caracter > '9')) &&
			         (caracter != '\b' /*corresponde a BACK_SPACE*/))
			      {
			         e.consume();  // ignorar el evento de teclado
			      }
			   }
			});
		txtCantidad.addFocusListener(new FocusListener() {
			   public void focusLost(FocusEvent e) {
					txtCantidad.setBackground(new Color(255,255,255));	
			   }

			@Override
			public void focusGained(FocusEvent e) {
				txtCantidad.setBackground(new Color(253,197,188));		

			}
			});
		
		txtCantXCaja=new JTextField();
		txtCantXCaja.setBounds(170,460,100,35);
		txtCantXCaja.setEnabled(false);
		txtCantXCaja.setForeground(new Color(0,0,102));
		txtCantXCaja.setFont(new Font("Adobe Hebrew", Font.BOLD , 15));
		txtCantXCaja.addKeyListener(new KeyAdapter()
		{
			   public void keyTyped(KeyEvent e){				   
			      char caracter = e.getKeyChar();

			      // Verificar si la tecla pulsada no es un digito
			      if(((caracter < '0') ||
			         (caracter > '9')) &&
			         (caracter != '\b' /*corresponde a BACK_SPACE*/))
			      {
			         e.consume();  // ignorar el evento de teclado
			      }
			   }
			});
		txtCantXCaja.addFocusListener(new FocusListener() {
			   public void focusLost(FocusEvent e) {
				   txtCantXCaja.setBackground(new Color(255,255,255));	
			   }

			@Override
			public void focusGained(FocusEvent e) {
				txtCantXCaja.setBackground(new Color(253,197,188));		

			}
			});	
		}/// FIN CONTRUCTOR

	private void cargarCombo() {
		ConexionServFumaca SQL = new ConexionServFumaca();
		conn = SQL.conectarEtiquetas();
		String sino="SI";
		String sSQL =   "";
		try{	
			sSQL = "SELECT * FROM usuario where visible= '"+sino+"'";
			PreparedStatement ps=conn.prepareStatement(sSQL);
			ResultSet rs=ps.executeQuery(); 
	
			while (rs.next()){
				cmbUsuario.addItem(rs.getNString("usuario"));
			}
			ConexionServFumaca.cerrar();
		}
		catch (Exception e)
		{
			
			JOptionPane.showMessageDialog(null, "ERROR DE CONEXION USU");

		}
		
	}/// FIN METODO CARGACOMBO
	
}/// FIN CLASE

