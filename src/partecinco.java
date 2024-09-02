import javax.swing.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class partecinco{

    private static List<Libro> libros = new ArrayList<>();
    private static List<Reserva> reservas = new ArrayList<>();
    private static List<Estudiante> estudiantes = new ArrayList<>();
    private static List<Pedido> pedidos = new ArrayList<>();
    private static List<ClienteGimnasio> clientes = new ArrayList<>();
    private static List<Paciente> pacientes = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            String[] opciones = {
                "Gestionar inventario de librería",
                "Gestionar reservas de hotel",
                "Gestionar notas de estudiantes",
                "Gestionar pedidos de restaurante",
                "Gestionar clientes de gimnasio",
                "Gestionar pacientes de hospital",
                "Salir"
            };
            String opcion = (String) JOptionPane.showInputDialog(null, "Selecciona una opción:", "Sistema de Gestión", JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);

            if (opcion == null || opcion.equals("Salir")) break;

            switch (opcion) {
                case "Gestionar inventario de librería":
                    gestionarInventarioLibreria();
                    break;
                case "Gestionar reservas de hotel":
                    gestionarReservasHotel();
                    break;
                case "Gestionar notas de estudiantes":
                    gestionarNotasEstudiantes();
                    break;
                case "Gestionar pedidos de restaurante":
                    gestionarPedidosRestaurante();
                    break;
                case "Gestionar clientes de gimnasio":
                    gestionarClientesGimnasio();
                    break;
                case "Gestionar pacientes de hospital":
                    gestionarPacientesHospital();
                    break;
            }
        }
    }

    private static void gestionarInventarioLibreria() {
        while (true) {
            String[] opciones = {
                "Agregar libro",
                "Eliminar libro",
                "Mostrar información de libros",
                "Calcular valor total del inventario",
                "Volver"
            };
            String opcion = (String) JOptionPane.showInputDialog(null, "Selecciona una opción:", "Gestión de Inventario de Librería", JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);

            if (opcion == null || opcion.equals("Volver")) break;

            switch (opcion) {
                case "Agregar libro":
                    agregarLibro();
                    break;
                case "Eliminar libro":
                    eliminarLibro();
                    break;
                case "Mostrar información de libros":
                    mostrarInformacionLibros();
                    break;
                case "Calcular valor total del inventario":
                    calcularValorTotalInventario();
                    break;
            }
        }
    }

    private static void agregarLibro() {
        String titulo = JOptionPane.showInputDialog("Título del libro:");
        String autor = JOptionPane.showInputDialog("Autor del libro:");
        String isbn = JOptionPane.showInputDialog("ISBN del libro:");
        double precio = Double.parseDouble(JOptionPane.showInputDialog("Precio del libro:"));
        int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Cantidad en stock:"));
        libros.add(new Libro(titulo, autor, isbn, precio, cantidad));
        JOptionPane.showMessageDialog(null, "Libro agregado con éxito.");
    }

    private static void eliminarLibro() {
        String isbn = JOptionPane.showInputDialog("Ingrese el ISBN del libro a eliminar:");
        libros.removeIf(libro -> libro.isbn.equals(isbn));
        JOptionPane.showMessageDialog(null, "Libro eliminado con éxito.");
    }

    private static void mostrarInformacionLibros() {
        StringBuilder sb = new StringBuilder();
        for (Libro libro : libros) {
            sb.append("Título: ").append(libro.titulo).append("\n");
            sb.append("Autor: ").append(libro.autor).append("\n");
            sb.append("ISBN: ").append(libro.isbn).append("\n");
            sb.append("Precio: ").append(libro.precio).append("\n");
            sb.append("Cantidad en stock: ").append(libro.cantidad).append("\n");
            sb.append("Valor total: ").append(libro.precio * libro.cantidad).append("\n\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }

    private static void calcularValorTotalInventario() {
        double total = 0;
        for (Libro libro : libros) {
            total += libro.precio * libro.cantidad;
        }
        JOptionPane.showMessageDialog(null, "Valor total del inventario: " + total);
    }

    private static void gestionarReservasHotel() {
        while (true) {
            String[] opciones = {
                "Registrar reserva",
                "Cancelar reserva",
                "Calcular costo de estancia",
                "Mostrar información de reservas",
                "Volver"
            };
            String opcion = (String) JOptionPane.showInputDialog(null, "Selecciona una opción:", "Gestión de Reservas de Hotel", JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);

            if (opcion == null || opcion.equals("Volver")) break;

            switch (opcion) {
                case "Registrar reserva":
                    registrarReserva();
                    break;
                case "Cancelar reserva":
                    cancelarReserva();
                    break;
                case "Calcular costo de estancia":
                    calcularCostoEstancia();
                    break;
                case "Mostrar información de reservas":
                    mostrarInformacionReservas();
                    break;
            }
        }
    }

    private static void registrarReserva() {
        String nombre = JOptionPane.showInputDialog("Nombre del huésped:");
        String apellido = JOptionPane.showInputDialog("Apellido del huésped:");
        String cedula = JOptionPane.showInputDialog("Cédula del huésped:");
        int numeroHabitacion = Integer.parseInt(JOptionPane.showInputDialog("Número de habitación:"));
        Date fechaEntrada = obtenerFecha("Fecha de entrada (dd/MM/yyyy):");
        Date fechaSalida = obtenerFecha("Fecha de salida (dd/MM/yyyy):");
        reservas.add(new Reserva(nombre, apellido, cedula, numeroHabitacion, fechaEntrada, fechaSalida));
        JOptionPane.showMessageDialog(null, "Reserva registrada con éxito.");
    }

    private static void cancelarReserva() {
        String cedula = JOptionPane.showInputDialog("Ingrese la cédula del huésped:");
        reservas.removeIf(reserva -> reserva.cedula.equals(cedula));
        JOptionPane.showMessageDialog(null, "Reserva cancelada con éxito.");
    }

    private static void calcularCostoEstancia() {
        double precioPorNoche = 100; // Precio fijo para simplificar
        String cedula = JOptionPane.showInputDialog("Ingrese la cédula del huésped:");
        for (Reserva reserva : reservas) {
            if (reserva.cedula.equals(cedula)) {
                int noches = reserva.calcularNoches();
                double costo = noches * precioPorNoche;
                JOptionPane.showMessageDialog(null, "Costo total de la estancia: " + costo);
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Reserva no encontrada.");
    }

    private static void mostrarInformacionReservas() {
        StringBuilder sb = new StringBuilder();
        for (Reserva reserva : reservas) {
            sb.append("Nombre: ").append(reserva.nombre).append("\n");
            sb.append("Apellido: ").append(reserva.apellido).append("\n");
            sb.append("Cédula: ").append(reserva.cedula).append("\n");
            sb.append("Número de habitación: ").append(reserva.numeroHabitacion).append("\n");
            sb.append("Fecha de entrada: ").append(reserva.fechaEntrada).append("\n");
            sb.append("Fecha de salida: ").append(reserva.fechaSalida).append("\n");
            sb.append("Costo total de la estancia: ").append(reserva.calcularNoches() * 100).append("\n\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }

    private static void gestionarNotasEstudiantes() {
        while (true) {
            String[] opciones = {
                "Registrar estudiante",
                "Mostrar notas y promedio",
                "Volver"
            };
            String opcion = (String) JOptionPane.showInputDialog(null, "Selecciona una opción:", "Registro de Notas de Estudiantes", JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);

            if (opcion == null || opcion.equals("Volver")) break;

            switch (opcion) {
                case "Registrar estudiante":
                    registrarEstudiante();
                    break;
                case "Mostrar notas y promedio":
                    mostrarNotasYPromedio();
                    break;
            }
        }
    }

    private static void registrarEstudiante() {
        String nombre = JOptionPane.showInputDialog("Nombre del estudiante:");
        String apellido = JOptionPane.showInputDialog("Apellido del estudiante:");
        String numeroIdentificacion = JOptionPane.showInputDialog("Número de identificación:");
        String curso = JOptionPane.showInputDialog("Curso:");
        String[] notasStr = JOptionPane.showInputDialog("Ingrese las notas separadas por coma:").split(",");
        double[] notas = new double[notasStr.length];
        for (int i = 0; i < notasStr.length; i++) {
            notas[i] = Double.parseDouble(notasStr[i].trim());
        }
        estudiantes.add(new Estudiante(nombre, apellido, numeroIdentificacion, curso, notas));
        JOptionPane.showMessageDialog(null, "Estudiante registrado con éxito.");
    }

    private static void mostrarNotasYPromedio() {
        StringBuilder sb = new StringBuilder();
        for (Estudiante estudiante : estudiantes) {
            sb.append("Nombre: ").append(estudiante.nombre).append("\n");
            sb.append("Apellido: ").append(estudiante.apellido).append("\n");
            sb.append("Número de identificación: ").append(estudiante.numeroIdentificacion).append("\n");
            sb.append("Curso: ").append(estudiante.curso).append("\n");
            sb.append("Notas: ");
            for (double nota : estudiante.notas) {
                sb.append(nota).append(" ");
            }
            sb.append("\n");
            sb.append("Promedio: ").append(estudiante.calcularPromedio()).append("\n\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }

    private static void gestionarPedidosRestaurante() {
        while (true) {
            String[] opciones = {
                "Registrar pedido",
                "Actualizar pedido",
                "Eliminar pedido",
                "Mostrar información de pedidos",
                "Volver"
            };
            String opcion = (String) JOptionPane.showInputDialog(null, "Selecciona una opción:", "Gestión de Pedidos de Restaurante", JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);

            if (opcion == null || opcion.equals("Volver")) break;

            switch (opcion) {
                case "Registrar pedido":
                    registrarPedido();
                    break;
                case "Actualizar pedido":
                    actualizarPedido();
                    break;
                case "Eliminar pedido":
                    eliminarPedido();
                    break;
                case "Mostrar información de pedidos":
                    mostrarInformacionPedidos();
                    break;
            }
        }
    }

    private static void registrarPedido() {
        String nombreCliente = JOptionPane.showInputDialog("Nombre del cliente:");
        int numeroMesa = Integer.parseInt(JOptionPane.showInputDialog("Número de mesa:"));
        String[] platosStr = JOptionPane.showInputDialog("Ingrese los platos separados por coma:").split(",");
        double[] precios = new double[platosStr.length];
        for (int i = 0; i < platosStr.length; i++) {
            precios[i] = Double.parseDouble(JOptionPane.showInputDialog("Precio del plato '" + platosStr[i].trim() + "':"));
        }
        pedidos.add(new Pedido(nombreCliente, numeroMesa, platosStr, precios));
        JOptionPane.showMessageDialog(null, "Pedido registrado con éxito.");
    }

    private static void actualizarPedido() {
        String nombreCliente = JOptionPane.showInputDialog("Ingrese el nombre del cliente:");
        for (Pedido pedido : pedidos) {
            if (pedido.nombreCliente.equals(nombreCliente)) {
                String[] platosStr = JOptionPane.showInputDialog("Ingrese los platos actualizados separados por coma:").split(",");
                double[] precios = new double[platosStr.length];
                for (int i = 0; i < platosStr.length; i++) {
                    precios[i] = Double.parseDouble(JOptionPane.showInputDialog("Precio del plato '" + platosStr[i].trim() + "':"));
                }
                pedido.platos = platosStr;
                pedido.precios = precios;
                JOptionPane.showMessageDialog(null, "Pedido actualizado con éxito.");
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Pedido no encontrado.");
    }

    private static void eliminarPedido() {
        String nombreCliente = JOptionPane.showInputDialog("Ingrese el nombre del cliente:");
        pedidos.removeIf(pedido -> pedido.nombreCliente.equals(nombreCliente));
        JOptionPane.showMessageDialog(null, "Pedido eliminado con éxito.");
    }

    private static void mostrarInformacionPedidos() {
        StringBuilder sb = new StringBuilder();
        for (Pedido pedido : pedidos) {
            sb.append("Nombre del cliente: ").append(pedido.nombreCliente).append("\n");
            sb.append("Número de mesa: ").append(pedido.numeroMesa).append("\n");
            sb.append("Platos solicitados: ");
            for (int i = 0; i < pedido.platos.length; i++) {
                sb.append(pedido.platos[i]).append(" (").append(pedido.precios[i]).append(") ");
            }
            sb.append("\n");
            sb.append("Total a pagar: ").append(pedido.calcularTotal()).append("\n\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }

    private static void gestionarClientesGimnasio() {
        while (true) {
            String[] opciones = {
                "Registrar nuevo cliente",
                "Mostrar estadísticas de clientes",
                "Volver"
            };
            String opcion = (String) JOptionPane.showInputDialog(null, "Selecciona una opción:", "Gestión de Clientes de Gimnasio", JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);

            if (opcion == null || opcion.equals("Volver")) break;

            switch (opcion) {
                case "Registrar nuevo cliente":
                    registrarCliente();
                    break;
                case "Mostrar estadísticas de clientes":
                    mostrarEstadisticasClientes();
                    break;
            }
        }
    }

    private static void registrarCliente() {
        String nombre = JOptionPane.showInputDialog("Nombre del cliente:");
        String apellido = JOptionPane.showInputDialog("Apellido del cliente:");
        int edad = Integer.parseInt(JOptionPane.showInputDialog("Edad del cliente:"));
        String categoria = JOptionPane.showInputDialog("Categoría (Pesas, Cardio, Yoga, Natación, Boxeo):");
        int mesesMembresia = Integer.parseInt(JOptionPane.showInputDialog("Duración de membresía en meses:"));
        clientes.add(new ClienteGimnasio(nombre, apellido, edad, categoria, mesesMembresia));
        JOptionPane.showMessageDialog(null, "Cliente registrado con éxito.");
    }

    private static void mostrarEstadisticasClientes() {
        int[] conteoCategorias = new int[5];
        double[] sumasEdades = new double[5];
        int[] conteoEdades = new int[3];
        int[] conteoMembresia = new int[5];

        for (ClienteGimnasio cliente : clientes) {
            int indiceCategoria = 0;
            switch (cliente.categoria) {
                case "Pesas": indiceCategoria = 0; break;
                case "Cardio": indiceCategoria = 1; break;
                case "Yoga": indiceCategoria = 2; break;
                case "Natación": indiceCategoria = 3; break;
                case "Boxeo": indiceCategoria = 4; break;
            }
            sumasEdades[indiceCategoria] += cliente.edad;
            conteoCategorias[indiceCategoria]++;

            if (cliente.edad >= 18 && cliente.edad <= 25) conteoEdades[0]++;
            else if (cliente.edad >= 26 && cliente.edad <= 35) conteoEdades[1]++;
            else if (cliente.edad > 35) conteoEdades[2]++;

            if (cliente.mesesMembresia >= 1 && cliente.mesesMembresia <= 5) conteoMembresia[0]++;
            else if (cliente.mesesMembresia >= 6 && cliente.mesesMembresia <= 10) conteoMembresia[1]++;
            else if (cliente.mesesMembresia >= 11 && cliente.mesesMembresia <= 15) conteoMembresia[2]++;
            else if (cliente.mesesMembresia >= 16 && cliente.mesesMembresia <= 20) conteoMembresia[3]++;
            else conteoMembresia[4]++;
        }

        StringBuilder sb = new StringBuilder();
        sb.append("Promedio de edad por categoría:\n");
        sb.append("Pesas: ").append(sumasEdades[0] / (double) (conteoCategorias[0] == 0 ? 1 : conteoCategorias[0])).append("\n");
        sb.append("Cardio: ").append(sumasEdades[1] / (double) (conteoCategorias[1] == 0 ? 1 : conteoCategorias[1])).append("\n");
        sb.append("Yoga: ").append(sumasEdades[2] / (double) (conteoCategorias[2] == 0 ? 1 : conteoCategorias[2])).append("\n");
        sb.append("Natación: ").append(sumasEdades[3] / (double) (conteoCategorias[3] == 0 ? 1 : conteoCategorias[3])).append("\n");
        sb.append("Boxeo: ").append(sumasEdades[4] / (double) (conteoCategorias[4] == 0 ? 1 : conteoCategorias[4])).append("\n\n");

        sb.append("Rango de edades:\n");
        sb.append("18-25 años: ").append(conteoEdades[0]).append("\n");
        sb.append("26-35 años: ").append(conteoEdades[1]).append("\n");
        sb.append("Más de 35 años: ").append(conteoEdades[2]).append("\n\n");

        sb.append("Duración de membresía:\n");
        sb.append("1-5 meses: ").append(conteoMembresia[0]).append("\n");
        sb.append("6-10 meses: ").append(conteoMembresia[1]).append("\n");
        sb.append("11-15 meses: ").append(conteoMembresia[2]).append("\n");
        sb.append("16-20 meses: ").append(conteoMembresia[3]).append("\n");
        sb.append("Más de 20 meses: ").append(conteoMembresia[4]).append("\n");

        JOptionPane.showMessageDialog(null, sb.toString());
    }

    private static void gestionarPacientesHospital() {
        while (true) {
            String[] opciones = {
                "Registrar paciente",
                "Mostrar información de pacientes",
                "Volver"
            };
            String opcion = (String) JOptionPane.showInputDialog(null, "Selecciona una opción:", "Gestión de Pacientes de Hospital", JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);

            if (opcion == null || opcion.equals("Volver")) break;

            switch (opcion) {
                case "Registrar paciente":
                    registrarPaciente();
                    break;
                case "Mostrar información de pacientes":
                    mostrarInformacionPacientes();
                    break;
            }
        }
    }

    private static void registrarPaciente() {
        String nombre = JOptionPane.showInputDialog("Nombre del paciente:");
        String apellido = JOptionPane.showInputDialog("Apellido del paciente:");
        String numeroHistoria = JOptionPane.showInputDialog("Número de historia clínica:");
        String enfermedad = JOptionPane.showInputDialog("Enfermedad:");
        String fechaIngreso = JOptionPane.showInputDialog("Fecha de ingreso (dd/MM/yyyy):");
        pacientes.add(new Paciente(nombre, apellido, numeroHistoria, enfermedad, fechaIngreso));
        JOptionPane.showMessageDialog(null, "Paciente registrado con éxito.");
    }

    private static void mostrarInformacionPacientes() {
        StringBuilder sb = new StringBuilder();
        for (Paciente paciente : pacientes) {
            sb.append("Nombre: ").append(paciente.nombre).append("\n");
            sb.append("Apellido: ").append(paciente.apellido).append("\n");
            sb.append("Número de historia clínica: ").append(paciente.numeroHistoria).append("\n");
            sb.append("Enfermedad: ").append(paciente.enfermedad).append("\n");
            sb.append("Fecha de ingreso: ").append(paciente.fechaIngreso).append("\n\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }

    private static Date obtenerFecha(String mensaje) {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        formato.setLenient(false);
        while (true) {
            try {
                return formato.parse(JOptionPane.showInputDialog(mensaje));
            } catch (ParseException e) {
                JOptionPane.showMessageDialog(null, "Fecha inválida. Inténtalo de nuevo.");
            }
        }
    }

}

class Libro {
    String titulo;
    String autor;
    String isbn;
    double precio;
    int cantidad;

    public Libro(String titulo, String autor, String isbn, double precio, int cantidad) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.precio = precio;
        this.cantidad = cantidad;
    }
}

class Reserva {
    String nombre;
    String apellido;
    String cedula;
    int numeroHabitacion;
    Date fechaEntrada;
    Date fechaSalida;

    public Reserva(String nombre, String apellido, String cedula, int numeroHabitacion, Date fechaEntrada, Date fechaSalida) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.numeroHabitacion = numeroHabitacion;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
    }

    public int calcularNoches() {
        long diff = fechaSalida.getTime() - fechaEntrada.getTime();
        return (int) (diff / (1000 * 60 * 60 * 24));
    }
}

class Estudiante {
    String nombre;
    String apellido;
    String numeroIdentificacion;
    String curso;
    double[] notas;

    public Estudiante(String nombre, String apellido, String numeroIdentificacion, String curso, double[] notas) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.numeroIdentificacion = numeroIdentificacion;
        this.curso = curso;
        this.notas = notas;
    }

    public double calcularPromedio() {
        double suma = 0;
        for (double nota : notas) {
            suma += nota;
        }
        return suma / notas.length;
    }
}

class Pedido {
    String nombreCliente;
    int numeroMesa;
    String[] platos;
    double[] precios;

    public Pedido(String nombreCliente, int numeroMesa, String[] platos, double[] precios) {
        this.nombreCliente = nombreCliente;
        this.numeroMesa = numeroMesa;
        this.platos = platos;
        this.precios = precios;
    }

    public double calcularTotal() {
        double total = 0;
        for (double precio : precios) {
            total += precio;
        }
        return total;
    }
}

class ClienteGimnasio {
    String nombre;
    String apellido;
    int edad;
    String categoria;
    int mesesMembresia;

    public ClienteGimnasio(String nombre, String apellido, int edad, String categoria, int mesesMembresia) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.categoria = categoria;
        this.mesesMembresia = mesesMembresia;
    }
}

class Paciente {
    String nombre;
    String apellido;
    String numeroHistoria;
    String enfermedad;
    String fechaIngreso;

    public Paciente(String nombre, String apellido, String numeroHistoria, String enfermedad, String fechaIngreso) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.numeroHistoria = numeroHistoria;
        this.enfermedad = enfermedad;
        this.fechaIngreso = fechaIngreso;
    }
}
