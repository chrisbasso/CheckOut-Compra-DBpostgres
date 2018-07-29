
import java.sql.SQLException;
import java.sql.Statement;

public class Comprador {

	private static DBConnector conexion = DBConnector.getInstance();

	public static void realizarCompra(String numero, String codigo, double monto, int nroComercio) {

		try {

			Statement st = conexion.getBaseDatos().createStatement();

			st.executeQuery("SELECT autorizarCompra('" + numero + "','" + codigo + "'," + monto + "," + nroComercio + ");");

			st.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
