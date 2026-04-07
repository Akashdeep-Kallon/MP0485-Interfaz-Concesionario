/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.util.ArrayList;
import modelo.Vehiculo;
import persistencia.FicheroVehiculos;

/**
 *
 * @author MANBIR
 */
public class Concesionario {

    private static ArrayList<Vehiculo> vehiculos = FicheroVehiculos.cargar();

    public static void insertarVehiculo(Vehiculo v) {
        if (!comprovarMatricula(v)) {
            vehiculos.add(v);
        }
    }

    public static Vehiculo buscarVehiculo(String matricula) {
        Vehiculo vehiculo = null;
        for (Vehiculo v : vehiculos) {
            String[] mainAtributos = v.toString().split(";");
            if (mainAtributos[0].equals(matricula)) {
                vehiculo = v;
            }
        }
        return vehiculo;
    }

    public static void eliminarVehiculo(String matricula) {
        for (Vehiculo vehiculo : vehiculos) {
            String[] mainAtributos = vehiculo.toString().split(";");
            if (mainAtributos[0].equals(matricula)) {
                vehiculos.remove(vehiculo);
                break;
            }
        }
    }

    public static ArrayList<Vehiculo> listarVehiculos() {
        return Concesionario.vehiculos;
    }

    public static boolean comprovarMatricula(Vehiculo v) {

        String[] atributos = v.toString().split(";");

        for (Vehiculo vehiculo : vehiculos) {
            String[] mainAtributos = vehiculo.toString().split(";");
            if (mainAtributos[0].equals(atributos[0])) {
                return true;
            }
        }
        return false;
    }

}
