import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import java.util.List;


import org.javatuples.Pair;

public class ObtencionDatos {

	private static DBConnector conexion = DBConnector.getInstance();

	public static ArrayList<Pair<Integer, String>> getComercios() {

		List<Pair<Integer, String>> comercios = new ArrayList<Pair<Integer, String>>();

		try {

			Statement st = conexion.getBaseDatos().createStatement();

			ResultSet rs = st.executeQuery("SELECT * FROM comercio");

			while (rs.next()) {

				Pair<Integer, String> tupla = new Pair<Integer, String>(rs.getInt("nrocomercio"), rs.getString("nombre"));
				comercios.add((Pair<Integer, String>) tupla);

			}

			rs.close();
			st.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return (ArrayList<Pair<Integer, String>>) comercios;

	}

}
