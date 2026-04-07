/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import modelo.Vehiculo;

/**
 *
 * @author MANBIR
 */
public class FicheroVehiculos {

    private static final File rutaCarpeta = new File(System.getProperty("user.dir") + File.separator + "src" + File.separator + "datos");
    private static final File rutaArchivo = new File(System.getProperty("user.dir") + File.separator + "src" + File.separator + "datos" + File.separator + "vehiculos.txt");

    static FileReader fr;
    static BufferedReader br;

    static FileWriter fw;
    static BufferedWriter bw;

    static String line;

    public static ArrayList<Vehiculo> cargar() {
        ArrayList<Vehiculo> vehiculos = new ArrayList<>();
        try {
            if (!rutaArchivo.exists()) {
                rutaArchivo.mkdir();
                rutaArchivo.createNewFile();
            }
        } catch (IOException e) {
            System.err.println("Error a la carga de creacion de la carpeta.");
        }

        try {
            fr = new FileReader(rutaArchivo);
            br = new BufferedReader(fr);
            while ((line = br.readLine()) != null) {
                String[] atributos = line.split(";");
                vehiculos.add(new Vehiculo(atributos[0], atributos[1], atributos[2], Double.parseDouble(atributos[3]), atributos[4]));
            }
            fr.close();
            br.close();
        } catch (IOException e) {
            System.err.println("Error al leer el libro de la carpeta.");
        }
        return vehiculos;
    }

    public static void guardar(ArrayList<Vehiculo> vehiculos) {

        try {
            fw = new FileWriter(rutaArchivo, true);
            bw = new BufferedWriter(fw);
            for (Vehiculo vehiculo : vehiculos) {
                bw.write(vehiculo.toString() + System.getProperty("line.separator"));
                bw.flush();
            }
            fw.close();
            bw.close();
        } catch (IOException e) {

            System.err.println("Error al subir el vehicula al archivo.");

        }
    }
}
