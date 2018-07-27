
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Comprador {

	private static String url = "jdbc:postgresql://localhost/tarjetas";

	// Credenciales de la base de datos
	private static String usuario = "postgres";
	private static String contrasena = "postgres";

	private static Connection BaseDatos = null;

	public static void realizarCompra(String numero, String codigo, double monto, int nroComercio) {

		try {
			BaseDatos = DriverManager.getConnection(url, usuario, contrasena);
			Statement st = BaseDatos.createStatement();

			st.executeQuery("SELECT autorizarCompra('" + numero + "','" + codigo + "'," + monto + "," + nroComercio + ");");

			st.close();
			BaseDatos.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
