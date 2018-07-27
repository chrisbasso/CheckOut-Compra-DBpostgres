import java.sql.Connection;
import java.sql.DriverManager;



public class DBConnector {

	private static DBConnector instance = new DBConnector();

	// Donde se localiza la base de datos
	private String url = "jdbc:postgresql://localhost/tarjetas";

	// Credenciales de la base de datos
	private String usuario = "postgres";
	private String contrasena = "postgres";

	private Connection BaseDatos;

	private DBConnector() {

		try {
			setBaseDatos(DriverManager.getConnection(url, usuario, contrasena));
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

	}

	public static DBConnector getInstance() {
		return instance;
	}

	public Connection getBaseDatos() {
		return BaseDatos;
	}

	private void setBaseDatos(Connection baseDatos) {
		BaseDatos = baseDatos;
	}

}
