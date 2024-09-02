import java.awt.HeadlessException;
import javax.swing.JOptionPane;

public class SEGUNDAPARTE{

    public static void main(String[] args) {
        determinarEquipoConMasPuntos();
        calcularRendimientoAcademico();
        determinarMejorProducto();
        calcularEficienciaEnergetica();
        calcularCostoEventoCorporativo();
        calcularNivelSatisfaccionCliente();
        calcularCumplimientoMetas();
        calcularCapacidadRestanteAlmacenamiento();
        calcularCostoPorKilometro();
    }

    // 2. Determinar el equipo con más puntos
    public static void determinarEquipoConMasPuntos() {
        try {
            int numEquipos = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de equipos:"));
            int maxPuntos = 0;
            int equipoGanador = 0;

            for (int i = 1; i <= numEquipos; i++) {
                int puntos = Integer.parseInt(JOptionPane.showInputDialog("Ingrese los puntos del equipo " + i + ":"));
                if (puntos > maxPuntos) {
                    maxPuntos = puntos;
                    equipoGanador = i;
                }
            }

            JOptionPane.showMessageDialog(null, "El equipo con más puntos es el equipo " + equipoGanador + " con " + maxPuntos + " puntos.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al ingresar los datos. Por favor, intente nuevamente.");
        }
    }

    // 13. Calcular rendimiento académico
    public static void calcularRendimientoAcademico() {
        try {
            int numAsignaturas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de asignaturas:"));
            double sumaCalificaciones = 0;

            for (int i = 1; i <= numAsignaturas; i++) {
                double calificacion = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la calificación de la asignatura " + i + ":"));
                sumaCalificaciones += calificacion;
            }

            double promedio = sumaCalificaciones / numAsignaturas;
            JOptionPane.showMessageDialog(null, String.format("El promedio de calificaciones es: %.2f", promedio));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al ingresar los datos. Por favor, intente nuevamente.");
        }
    }

    // 14. Determinar el mejor producto basado en opiniones
    public static void determinarMejorProducto() {
        try {
            int numProductos = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de productos:"));
            double mejorCalificacion = 0;
            int mejorProducto = 0;

            for (int i = 1; i <= numProductos; i++) {
                double calificacion = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la calificación del producto " + i + ":"));
                if (calificacion > mejorCalificacion) {
                    mejorCalificacion = calificacion;
                    mejorProducto = i;
                }
            }

            JOptionPane.showMessageDialog(null, "El producto con la mejor calificación es el producto " + mejorProducto + " con una calificación de " + mejorCalificacion);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al ingresar los datos. Por favor, intente nuevamente.");
        }
    }

    // 15. Calcular eficiencia energética
    public static void calcularEficienciaEnergetica() {
        try {
            int numElectrodomesticos = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de electrodomésticos:"));
            StringBuilder eficienciaInfo = new StringBuilder();

            for (int i = 1; i <= numElectrodomesticos; i++) {
                double consumoEnergia = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el consumo de energía del electrodoméstico " + i + " (kWh):"));
                double rendimiento = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el rendimiento del electrodoméstico " + i + " (unidades):"));

                double eficiencia = rendimiento / consumoEnergia;
                eficienciaInfo.append("Electrodoméstico ").append(i).append(": ").append(eficiencia).append(" unidades/kWh\n");
            }

            JOptionPane.showMessageDialog(null, eficienciaInfo.toString());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al ingresar los datos. Por favor, intente nuevamente.");
        }
    }

    // 16. Calcular costo de un evento corporativo
    public static void calcularCostoEventoCorporativo() {
        try {
            double costoAlquiler = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el costo de alquiler:"));
            double costoCatering = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el costo de catering:"));
            double costoEntretenimiento = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el costo de entretenimiento:"));
            double otrosGastos = Double.parseDouble(JOptionPane.showInputDialog("Ingrese otros gastos:"));

            double costoTotal = costoAlquiler + costoCatering + costoEntretenimiento + otrosGastos;

            JOptionPane.showMessageDialog(null, String.format("El costo total del evento es: %.2f", costoTotal));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al ingresar los datos. Por favor, intente nuevamente.");
        }
    }

    // 17. Determinar nivel de satisfacción del cliente
    public static void calcularNivelSatisfaccionCliente() {
        try {
            int numClientes = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de clientes encuestados:"));
            double sumaPuntuaciones = 0;

            for (int i = 1; i <= numClientes; i++) {
                double puntuacion = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la puntuación de satisfacción del cliente " + i + ":"));
                sumaPuntuaciones += puntuacion;
            }

            double promedioSatisfaccion = sumaPuntuaciones / numClientes;
            JOptionPane.showMessageDialog(null, String.format("El promedio de satisfacción del cliente es: %.2f", promedioSatisfaccion));
        } catch (HeadlessException | NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al ingresar los datos. Por favor, intente nuevamente.");
        }
    }

    // 18. Calcular porcentaje de cumplimiento de metas
    public static void calcularCumplimientoMetas() {
        try {
            int metasCumplidas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de metas cumplidas:"));
            int totalMetas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el total de metas establecidas:"));

            double porcentajeCumplimiento = ((double) metasCumplidas / totalMetas) * 100;

            JOptionPane.showMessageDialog(null, String.format("El porcentaje de cumplimiento de metas es: %.2f%%", porcentajeCumplimiento));
        } catch (HeadlessException | NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al ingresar los datos. Por favor, intente nuevamente.");
        }
    }

    // 19. Calcular capacidad restante de almacenamiento
    public static void calcularCapacidadRestante() {
        try {
            double capacidadTotal = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la capacidad total del almacén:"));
            double espacioOcupado = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el espacio ocupado:"));

            double capacidadRestante = capacidadTotal - espacioOcupado;

            JOptionPane.showMessageDialog(null, String.format("La capacidad restante de almacenamiento es: %.2f", capacidadRestante));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al ingresar los datos. Por favor, intente nuevamente.");
        }
    }

    // 20. Calcular costo por kilómetro de un servicio de taxi
    public static void calcularCostoPorKilometro() {
        try {
            double distancia = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la distancia recorrida (km):"));
            double tarifaTotal = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la tarifa total del viaje:"));

            double costoPorKilometro = tarifaTotal / distancia;

            JOptionPane.showMessageDialog(null, String.format("El costo por kilómetro del viaje es: %.2f", costoPorKilometro));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al ingresar los datos. Por favor, intente nuevamente.");
        }
    }

    private static void calcularCapacidadRestanteAlmacenamiento() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
