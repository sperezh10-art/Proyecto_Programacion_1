/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexion;

import java.sql.Connection;
import java.sql.Statement;
import java.io.IOException;

/**
 *
 * @author Misael
 */
public class MainPruebaDirecta {

    public static void main(String[] args) throws IOException {

        CreateConnection cc = new CreateConnection();

        try (Connection con = cc.getConnection();
             Statement st = con.createStatement()) {

            // --- INSERTAR ---
            String sqlInsert = "INSERT INTO empleado VALUES (1, 'Juan', 'Perez', 'Calle 123', 1500.0, 1)";
            st.executeUpdate(sqlInsert);

            // --- ACTUALIZAR ---
            String sqlUpdate = "UPDATE empleado SET salario = 2000.0 WHERE id_empleado = 1";
            st.executeUpdate(sqlUpdate);

            // --- ELIMINAR ---
            String sqlDelete = "DELETE FROM empleado WHERE id_empleado = 1";
            st.executeUpdate(sqlDelete);

            System.out.println("Operaciones terminadas (pero el código es un desastre)");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}