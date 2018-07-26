
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Comprador {

	public static void realizarCompra() {

		DBConnector db = DBConnector.getInstance();

		try {
			Statement st = db.getBaseDatos().createStatement();

			ResultSet rs = st.executeQuery("SELECT * FROM alumnos");

			while (rs.next()) {

				int dni = rs.getInt("dni");
				String nombre = rs.getString("nombre");

				System.out.println(dni + " " + nombre);

			}

			rs.close();
			st.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
