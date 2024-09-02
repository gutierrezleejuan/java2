import javax.swing.JOptionPane;

public class JAVA {

    public static void main(String[] args) {
        // Llamadas a las funciones para mostrar resultados
        calcularSalarioYRetencion();
        verificarNivelDeStock();
        calcularCostoProduccion();
        evaluarRendimientoDepartamentos();
        calcularDepreciacion();
        calcularRentabilidadInversion();
        generarInformeHorasExtras();
        calcularCostoProyectoConstruccion();
        calcularNominaSemanal();
        calcularTiempoEntregaPaquete();
        calcularConsumoCombustible();
    }

    // 1. Calcular salario anual y retención
    public static void calcularSalarioYRetencion() {
        String salarioMensualStr = JOptionPane.showInputDialog("Ingrese el salario mensual del empleado:");
        String porcentajeRetencionStr = JOptionPane.showInputDialog("Ingrese el porcentaje de retención en la fuente:");

        double salarioMensual = Double.parseDouble(salarioMensualStr);
        double porcentajeRetencion = Double.parseDouble(porcentajeRetencionStr);

        double salarioAnual = salarioMensual * 12;
        double retencionAnual = salarioAnual * (porcentajeRetencion / 100);

        JOptionPane.showMessageDialog(null, String.format("Salario Anual: %.2f\nRetención Anual en la Fuente: %.2f", salarioAnual, retencionAnual));
    }

    // 2. Verificar nivel de stock
    public static void verificarNivelDeStock() {
        int numProductos = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de productos:"));
        String stockMinimoStr = JOptionPane.showInputDialog("Ingrese el nivel mínimo de stock requerido:");
        int stockMinimo = Integer.parseInt(stockMinimoStr);

        StringBuilder resultado = new StringBuilder();
        for (int i = 1; i <= numProductos; i++) {
            int cantidadProducto = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad del producto " + i + ":"));
            if (cantidadProducto < stockMinimo) {
                resultado.append("Producto ").append(i).append(" necesita reabastecimiento.\n");
            }
        }

        JOptionPane.showMessageDialog(null, resultado.toString());
    }

    // 3. Calcular costo de producción
    public static void calcularCostoProduccion() {
        double costoMateriales = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el costo de materiales:"));
        double costoManoObra = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el costo de mano de obra:"));
        double gastosGenerales = Double.parseDouble(JOptionPane.showInputDialog("Ingrese los gastos generales:"));

        double costoTotal = costoMateriales + costoManoObra + gastosGenerales;

        JOptionPane.showMessageDialog(null, String.format("Costo Total de Producción: %.2f", costoTotal));
    }

    // 4. Evaluar rendimiento trimestral
    public static void evaluarRendimientoDepartamentos() {
        int numDepartamentos = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de departamentos:"));
        double mayorGanancia = 0;
        int mejorDepartamento = 0;

        for (int i = 1; i <= numDepartamentos; i++) {
            double ganancia = Double.parseDouble(JOptionPane.showInputDialog("Ingrese las ganancias trimestrales del departamento " + i + ":"));
            if (ganancia > mayorGanancia) {
                mayorGanancia = ganancia;
                mejorDepartamento = i;
            }
        }

        JOptionPane.showMessageDialog(null, "El departamento con mejor rendimiento es el departamento " + mejorDepartamento + " con ganancias de " + mayorGanancia);
    }

    // 5. Calcular depreciación anual
    public static void calcularDepreciacion() {
        double valorInicial = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el valor inicial del activo:"));
        double valorResidual = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el valor residual del activo:"));
        int vidaUtil = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la vida útil del activo en años:"));

        double depreciacionAnual = (valorInicial - valorResidual) / vidaUtil;

        JOptionPane.showMessageDialog(null, String.format("Depreciación Anual: %.2f", depreciacionAnual));
    }

    // 6. Calcular rentabilidad de una inversión
    public static void calcularRentabilidadInversion() {
        double capitalInicial = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el capital inicial de la inversión:"));
        double tasaInteres = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la tasa de interés anual (%):"));
        int numeroAnios = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de años de la inversión:"));

        double valorFuturo = capitalInicial * Math.pow(1 + tasaInteres / 100, numeroAnios);

        JOptionPane.showMessageDialog(null, String.format("Valor Futuro de la Inversión: %.2f", valorFuturo));
    }

    // 7. Generar informe de horas extras
    public static void generarInformeHorasExtras() {
        int numEmpleados = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de empleados:"));
        StringBuilder informe = new StringBuilder();

        for (int i = 1; i <= numEmpleados; i++) {
            String nombre = JOptionPane.showInputDialog("Ingrese el nombre del empleado " + i + ":");
            int horasExtras = Integer.parseInt(JOptionPane.showInputDialog("Ingrese las horas extras trabajadas por " + nombre + ":"));
            informe.append(nombre).append(": ").append(horasExtras).append(" horas extras\n");
        }

        JOptionPane.showMessageDialog(null, informe.toString());
    }

    // 8. Calcular costo de un proyecto de construcción
    public static void calcularCostoProyectoConstruccion() {
        double costoMateriales = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el costo de materiales:"));
        double costoManoObra = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el costo de mano de obra:"));
        double costoEquipos = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el costo de equipos:"));

        double costoTotal = costoMateriales + costoManoObra + costoEquipos;

        JOptionPane.showMessageDialog(null, String.format("Costo Total del Proyecto: %.2f", costoTotal));
    }

    // 9. Calcular nómina semanal
    public static void calcularNominaSemanal() {
        int numEmpleados = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de empleados:"));
        double nominaTotal = 0;

        for (int i = 1; i <= numEmpleados; i++) {
            String nombre = JOptionPane.showInputDialog("Ingrese el nombre del empleado " + i + ":");
            int horasTrabajadas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese las horas trabajadas por " + nombre + ":"));
            double salarioPorHora = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el salario por hora de " + nombre + ":"));
            double salarioSemanal = horasTrabajadas * salarioPorHora;
            nominaTotal += salarioSemanal;
        }

        JOptionPane.showMessageDialog(null, String.format("Nómina Total de la Semana: %.2f", nominaTotal));
    }

    // 10. Calcular tiempo estimado de entrega
    public static void calcularTiempoEntregaPaquete() {
        double distancia = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la distancia en kilómetros:"));
        double velocidad = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la velocidad promedio en km/h:"));

        double tiempoEstimado = distancia / velocidad;

        JOptionPane.showMessageDialog(null, String.format("Tiempo Estimado de Entrega: %.2f horas", tiempoEstimado));
    }

    // 11. Calcular consumo de combustible de una flota
    public static void calcularConsumoCombustible() {
        int numVehiculos = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de vehículos:"));
        double consumoTotal = 0;

        for (int i = 1; i <= numVehiculos; i++) {
            double distancia = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la distancia recorrida por el vehículo " + i + " en km:"));
            double combustible = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el combustible consumido por el vehículo " + i + " en litros:"));
            double consumo = distancia / combustible;
            consumoTotal += consumo;
        }

        double consumoPromedio = consumoTotal / numVehiculos;

        JOptionPane.showMessageDialog(null, String.format("Consumo Promedio de Combustible: %.2f km/l", consumoPromedio));
    }
}
