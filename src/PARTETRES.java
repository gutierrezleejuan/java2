import javax.swing.JOptionPane;
import java.util.Arrays;

public class PARTETRES {

    static class Libro {
        String titulo;
        String autor;
        int cantidadStock;

        Libro(String titulo, String autor, int cantidadStock) {
            this.titulo = titulo;
            this.autor = autor;
            this.cantidadStock = cantidadStock;
        }

        @Override
        public String toString() {
            return "Título: " + titulo + ", Autor: " + autor + ", Stock: " + cantidadStock;
        }
    }

    static class Vehiculo {
        String modelo;
        String matricula;
        double precioPorDia;
        boolean disponible;

        Vehiculo(String modelo, String matricula, double precioPorDia, boolean disponible) {
            this.modelo = modelo;
            this.matricula = matricula;
            this.precioPorDia = precioPorDia;
            this.disponible = disponible;
        }

        @Override
        public String toString() {
            return "Modelo: " + modelo + ", Matrícula: " + matricula + ", Precio por Día: " + precioPorDia + ", Disponible: " + disponible;
        }
    }

    static class Mesa {
        int numero;
        int capacidad;
        boolean disponible;

        Mesa(int numero, int capacidad, boolean disponible) {
            this.numero = numero;
            this.capacidad = capacidad;
            this.disponible = disponible;
        }

        @Override
        public String toString() {
            return "Número: " + numero + ", Capacidad: " + capacidad + ", Disponible: " + disponible;
        }
    }

    static class Producto {
        String tipoRopa;
        int cantidad;
        double precio;

        Producto(String tipoRopa, int cantidad, double precio) {
            this.tipoRopa = tipoRopa;
            this.cantidad = cantidad;
            this.precio = precio;
        }

        @Override
        public String toString() {
            return "Tipo de Ropa: " + tipoRopa + ", Cantidad: " + cantidad + ", Precio: " + precio;
        }
    }

    static class Proyecto {
        String nombre;
        int duracion;
        boolean completado;

        Proyecto(String nombre, int duracion, boolean completado) {
            this.nombre = nombre;
            this.duracion = duracion;
            this.completado = completado;
        }

        @Override
        public String toString() {
            return "Nombre: " + nombre + ", Duración: " + duracion + " días, Completado: " + completado;
        }
    }

    static class Miembro {
        String nombre;
        int edad;
        String deporte;
        double cuotaMensual;

        Miembro(String nombre, int edad, String deporte, double cuotaMensual) {
            this.nombre = nombre;
            this.edad = edad;
            this.deporte = deporte;
            this.cuotaMensual = cuotaMensual;
        }

        @Override
        public String toString() {
            return "Nombre: " + nombre + ", Edad: " + edad + ", Deporte: " + deporte + ", Cuota Mensual: " + cuotaMensual;
        }
    }

    // Datos de ejemplo
    static Libro[] libros = {
        new Libro("1984", "George Orwell", 5),
        new Libro("To Kill a Mockingbird", "Harper Lee", 2)
    };

    static Vehiculo[] vehiculos = {
        new Vehiculo("Toyota Corolla", "ABC123", 50.0, true),
        new Vehiculo("Honda Civic", "XYZ789", 60.0, false)
    };

    static Mesa[] mesas = {
        new Mesa(1, 4, true),
        new Mesa(2, 2, false)
    };

    static Producto[] inventario = {
        new Producto("Camisa", 10, 20.0),
        new Producto("Pantalón", 5, 40.0)
    };

    static Proyecto[] proyectos = {
        new Proyecto("Desarrollo Web", 30, true),
        new Proyecto("Aplicación Móvil", 60, false)
    };

    static Miembro[] miembros = {
        new Miembro("Juan Pérez", 25, "Fútbol", 50.0),
        new Miembro("Ana Gómez", 30, "Tennis", 60.0)
    };

    public static void main(String[] args) {
        while (true) {
            String mensaje = JOptionPane.showInputDialog("Introduce el comando (o 'salir' para terminar):");
            if (mensaje == null || mensaje.equalsIgnoreCase("salir")) {
                break;
            }
            procesarMensaje(mensaje);
        }
    }

    private static void procesarMensaje(String mensaje) {
        String[] partes = mensaje.split(" ");
        String comando = partes[0];
        switch (comando) {
            case "Mostrar":
                if (mensaje.contains("inventario biblioteca")) {
                    mostrarInventarioLibros();
                } else if (mensaje.contains("lista vehículos")) {
                    mostrarListaVehiculos();
                } else if (mensaje.contains("disponibilidad mesas")) {
                    mostrarDisponibilidadMesas();
                } else if (mensaje.contains("inventario ropa")) {
                    mostrarInventarioProductos();
                } else if (mensaje.contains("proyectos")) {
                    mostrarProyectos();
                } else if (mensaje.contains("miembros club")) {
                    mostrarListaMiembros();
                }
                break;

            case "Agregar":
                if (mensaje.contains("copias")) {
                    String titulo = partes[2];
                    int cantidad = Integer.parseInt(partes[3]);
                    agregarCopiasLibro(titulo, cantidad);
                } else if (mensaje.contains("unidades")) {
                    String tipoRopa = partes[1];
                    int cantidad = Integer.parseInt(partes[2]);
                    agregarUnidadesProducto(tipoRopa, cantidad);
                } else if (mensaje.contains("proyecto")) {
                    String nombre = partes[1];
                    int duracion = Integer.parseInt(partes[2]);
                    boolean completado = Boolean.parseBoolean(partes[3]);
                    agregarProyecto(nombre, duracion, completado);
                } else if (mensaje.contains("miembro")) {
                    String nombre = partes[1] + " " + partes[2];
                    int edad = Integer.parseInt(partes[3]);
                    String deporte = partes[4];
                    double cuotaMensual = Double.parseDouble(partes[5]);
                    agregarMiembro(nombre, edad, deporte, cuotaMensual);
                }
                break;

            case "Prestar":
                String tituloLibro = partes[2];
                prestarLibro(tituloLibro);
                break;

            case "Buscar":
                if (mensaje.contains("libro")) {
                    String tituloLibroBuscar = partes[2];
                    buscarLibro(tituloLibroBuscar);
                } else if (mensaje.contains("vehículo")) {
                    String modeloVehiculoBuscar = partes[2];
                    buscarVehiculo(modeloVehiculoBuscar);
                } else if (mensaje.contains("mesa")) {
                    int numeroMesaBuscar = Integer.parseInt(partes[2]);
                    buscarMesa(numeroMesaBuscar);
                } else if (mensaje.contains("producto")) {
                    String tipoRopaBuscar = partes[2];
                    buscarProducto(tipoRopaBuscar);
                } else if (mensaje.contains("proyecto")) {
                    String nombreProyectoBuscar = partes[2];
                    buscarProyecto(nombreProyectoBuscar);
                } else if (mensaje.contains("miembro")) {
                    String nombreMiembroBuscar = partes[2] + " " + partes[3];
                    buscarMiembro(nombreMiembroBuscar);
                }
                break;

            case "Ordenar":
                if (mensaje.contains("libros por título")) {
                    ordenarLibrosPorTitulo();
                } else if (mensaje.contains("vehículos por precio")) {
                    ordenarVehiculosPorPrecio();
                } else if (mensaje.contains("mesas por capacidad")) {
                    ordenarMesasPorCapacidad();
                } else if (mensaje.contains("productos por precio")) {
                    ordenarProductosPorPrecio();
                } else if (mensaje.contains("proyectos por duración")) {
                    ordenarProyectosPorDuracion();
                }
                break;

            case "Alquilar":
                String matriculaVehiculo = partes[2];
                alquilarVehiculo(matriculaVehiculo);
                break;

            case "Devolver":
                String matriculaVehiculoDevolver = partes[2];
                devolverVehiculo(matriculaVehiculoDevolver);
                break;

            case "Realizar":
                int numeroReserva = Integer.parseInt(partes[2]);
                realizarReservaMesa(numeroReserva);
                break;

            case "Cancelar":
                int numeroReservaCancelar = Integer.parseInt(partes[2]);
                cancelarReservaMesa(numeroReservaCancelar);
                break;

            case "Actualizar":
                if (mensaje.contains("estado")) {
                    String nombreProyectoActualizar = partes[1];
                    boolean completado = Boolean.parseBoolean(partes[2]);
                    actualizarEstadoProyecto(nombreProyectoActualizar, completado);
                } else if (mensaje.contains("cuota")) {
                    String nombreMiembroActualizar = partes[1] + " " + partes[2];
                    double cuota = Double.parseDouble(partes[3]);
                    actualizarCuotaMensual(nombreMiembroActualizar, cuota);
                }
                break;

            case "Calcular":
                if (mensaje.contains("promedio edad")) {
                    calcularPromedioEdad();
                }
                break;

            default:
                JOptionPane.showMessageDialog(null, "Comando no reconocido.");
        }
    }

    // Métodos para gestionar libros
    private static void mostrarInventarioLibros() {
        StringBuilder sb = new StringBuilder();
        for (Libro libro : libros) {
            sb.append(libro).append("\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }

    private static void agregarCopiasLibro(String titulo, int cantidad) {
        for (Libro libro : libros) {
            if (libro.titulo.equals(titulo)) {
                libro.cantidadStock += cantidad;
                JOptionPane.showMessageDialog(null, "Copias agregadas.");
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Libro no encontrado.");
    }

    private static void prestarLibro(String titulo) {
        for (Libro libro : libros) {
            if (libro.titulo.equals(titulo)) {
                if (libro.cantidadStock > 0) {
                    libro.cantidadStock--;
                    JOptionPane.showMessageDialog(null, "Libro prestado.");
                } else {
                    JOptionPane.showMessageDialog(null, "No hay copias disponibles.");
                }
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Libro no encontrado.");
    }

    private static void buscarLibro(String titulo) {
        for (Libro libro : libros) {
            if (libro.titulo.equals(titulo)) {
                JOptionPane.showMessageDialog(null, libro.toString());
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Libro no encontrado.");
    }

    private static void ordenarLibrosPorTitulo() {
        Arrays.sort(libros, (l1, l2) -> l1.titulo.compareTo(l2.titulo));
    }

    // Métodos para gestionar vehículos
    private static void mostrarListaVehiculos() {
        StringBuilder sb = new StringBuilder();
        for (Vehiculo vehiculo : vehiculos) {
            sb.append(vehiculo).append("\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }

    private static void alquilarVehiculo(String matricula) {
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo.matricula.equals(matricula)) {
                if (vehiculo.disponible) {
                    vehiculo.disponible = false;
                    JOptionPane.showMessageDialog(null, "Vehículo alquilado.");
                } else {
                    JOptionPane.showMessageDialog(null, "Vehículo ya está alquilado.");
                }
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Vehículo no encontrado.");
    }

    private static void devolverVehiculo(String matricula) {
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo.matricula.equals(matricula)) {
                if (!vehiculo.disponible) {
                    vehiculo.disponible = true;
                    JOptionPane.showMessageDialog(null, "Vehículo devuelto.");
                } else {
                    JOptionPane.showMessageDialog(null, "Vehículo ya estaba disponible.");
                }
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Vehículo no encontrado.");
    }

    private static void buscarVehiculo(String modelo) {
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo.modelo.equals(modelo)) {
                JOptionPane.showMessageDialog(null, vehiculo.toString());
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Vehículo no encontrado.");
    }

    private static void ordenarVehiculosPorPrecio() {
        Arrays.sort(vehiculos, (v1, v2) -> Double.compare(v1.precioPorDia, v2.precioPorDia));
    }

    // Métodos para gestionar mesas
    private static void mostrarDisponibilidadMesas() {
        StringBuilder sb = new StringBuilder();
        for (Mesa mesa : mesas) {
            sb.append(mesa).append("\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }

    private static void realizarReservaMesa(int numero) {
        for (Mesa mesa : mesas) {
            if (mesa.numero == numero) {
                if (mesa.disponible) {
                    mesa.disponible = false;
                    JOptionPane.showMessageDialog(null, "Reserva realizada.");
                } else {
                    JOptionPane.showMessageDialog(null, "Mesa ya está reservada.");
                }
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Mesa no encontrada.");
    }

    private static void cancelarReservaMesa(int numero) {
        for (Mesa mesa : mesas) {
            if (mesa.numero == numero) {
                if (!mesa.disponible) {
                    mesa.disponible = true;
                    JOptionPane.showMessageDialog(null, "Reserva cancelada.");
                } else {
                    JOptionPane.showMessageDialog(null, "Mesa ya estaba disponible.");
                }
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Mesa no encontrada.");
    }

    private static void buscarMesa(int numero) {
        for (Mesa mesa : mesas) {
            if (mesa.numero == numero) {
                JOptionPane.showMessageDialog(null, mesa.toString());
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Mesa no encontrada.");
    }

    private static void ordenarMesasPorCapacidad() {
        Arrays.sort(mesas, (m1, m2) -> Integer.compare(m1.capacidad, m2.capacidad));
    }

    // Métodos para gestionar inventario de ropa
    private static void mostrarInventarioProductos() {
        StringBuilder sb = new StringBuilder();
        for (Producto producto : inventario) {
            sb.append(producto).append("\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }

    private static void agregarUnidadesProducto(String tipoRopa, int cantidad) {
        for (Producto producto : inventario) {
            if (producto.tipoRopa.equals(tipoRopa)) {
                producto.cantidad += cantidad;
                JOptionPane.showMessageDialog(null, "Unidades agregadas.");
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Producto no encontrado.");
    }

    private static void venderProducto(String tipoRopa, int cantidad) {
        for (Producto producto : inventario) {
            if (producto.tipoRopa.equals(tipoRopa)) {
                if (producto.cantidad >= cantidad) {
                    producto.cantidad -= cantidad;
                    JOptionPane.showMessageDialog(null, "Producto vendido.");
                } else {
                    JOptionPane.showMessageDialog(null, "No hay suficiente stock.");
                }
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Producto no encontrado.");
    }

    private static void buscarProducto(String tipoRopa) {
        for (Producto producto : inventario) {
            if (producto.tipoRopa.equals(tipoRopa)) {
                JOptionPane.showMessageDialog(null, producto.toString());
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Producto no encontrado.");
    }

    private static void ordenarProductosPorPrecio() {
        Arrays.sort(inventario, (p1, p2) -> Double.compare(p1.precio, p2.precio));
    }

    // Métodos para gestionar proyectos
    private static void mostrarProyectos() {
        StringBuilder sb = new StringBuilder();
        for (Proyecto proyecto : proyectos) {
            sb.append(proyecto).append("\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }

    private static void agregarProyecto(String nombre, int duracion, boolean completado) {
        Proyecto[] nuevosProyectos = Arrays.copyOf(proyectos, proyectos.length + 1);
        nuevosProyectos[proyectos.length] = new Proyecto(nombre, duracion, completado);
        proyectos = nuevosProyectos;
        JOptionPane.showMessageDialog(null, "Proyecto agregado.");
    }

    private static void actualizarEstadoProyecto(String nombre, boolean completado) {
        for (Proyecto proyecto : proyectos) {
            if (proyecto.nombre.equals(nombre)) {
                proyecto.completado = completado;
                JOptionPane.showMessageDialog(null, "Estado actualizado.");
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Proyecto no encontrado.");
    }

    private static void buscarProyecto(String nombre) {
        for (Proyecto proyecto : proyectos) {
            if (proyecto.nombre.equals(nombre)) {
                JOptionPane.showMessageDialog(null, proyecto.toString());
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Proyecto no encontrado.");
    }

    private static void ordenarProyectosPorDuracion() {
        Arrays.sort(proyectos, (p1, p2) -> Integer.compare(p1.duracion, p2.duracion));
    }

    // Métodos para gestionar miembros de club
    private static void mostrarListaMiembros() {
        StringBuilder sb = new StringBuilder();
        for (Miembro miembro : miembros) {
            sb.append(miembro).append("\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }

    private static void agregarMiembro(String nombre, int edad, String deporte, double cuotaMensual) {
        Miembro[] nuevosMiembros = Arrays.copyOf(miembros, miembros.length + 1);
        nuevosMiembros[miembros.length] = new Miembro(nombre, edad, deporte, cuotaMensual);
        miembros = nuevosMiembros;
        JOptionPane.showMessageDialog(null, "Miembro agregado.");
    }

    private static void actualizarCuotaMensual(String nombre, double cuota) {
        for (Miembro miembro : miembros) {
            if (miembro.nombre.equals(nombre)) {
                miembro.cuotaMensual = cuota;
                JOptionPane.showMessageDialog(null, "Cuota mensual actualizada.");
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Miembro no encontrado.");
    }

    private static void buscarMiembro(String nombre) {
        for (Miembro miembro : miembros) {
            if (miembro.nombre.equals(nombre)) {
                JOptionPane.showMessageDialog(null, miembro.toString());
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Miembro no encontrado.");
    }

    private static void calcularPromedioEdad() {
        if (miembros.length == 0) {
            JOptionPane.showMessageDialog(null, "No hay miembros.");
            return;
        }
        double sumaEdad = 0;
        for (Miembro miembro : miembros) {
            sumaEdad += miembro.edad;
        }
        double promedioEdad = sumaEdad / miembros.length;
        JOptionPane.showMessageDialog(null, "Promedio de edad: " + promedioEdad);
    }
}
