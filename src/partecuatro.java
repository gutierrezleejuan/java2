import javax.swing.JOptionPane;
import java.util.ArrayList;

public class partecuatro {

    // Datos para el club de lectura
    static class Socio {
        String nombre;
        int edad;
        String libroFavorito;

        Socio(String nombre, int edad, String libroFavorito) {
            this.nombre = nombre;
            this.edad = edad;
            this.libroFavorito = libroFavorito;
        }

        @Override
        public String toString() {
            return "Nombre: " + nombre + ", Edad: " + edad + ", Libro favorito: " + libroFavorito;
        }
    }

    private static ArrayList<Socio> socios = new ArrayList<>();

    // Datos para el club de natación
    static class Inscripcion {
        String nombreMiembro;
        String nivelNatacion;
        double cuotaMensual;

        Inscripcion(String nombreMiembro, String nivelNatacion, double cuotaMensual) {
            this.nombreMiembro = nombreMiembro;
            this.nivelNatacion = nivelNatacion;
            this.cuotaMensual = cuotaMensual;
        }

        @Override
        public String toString() {
            return "Nombre: " + nombreMiembro + ", Nivel de natación: " + nivelNatacion + ", Cuota mensual: " + cuotaMensual;
        }
    }

    private static ArrayList<Inscripcion> inscripciones = new ArrayList<>();

    // Datos para el club de ajedrez
    static class MiembroAjedrez {
        String nombre;
        int edad;
        String nivelHabilidad;
        double cuotaMensual;

        MiembroAjedrez(String nombre, int edad, String nivelHabilidad, double cuotaMensual) {
            this.nombre = nombre;
            this.edad = edad;
            this.nivelHabilidad = nivelHabilidad;
            this.cuotaMensual = cuotaMensual;
        }

        @Override
        public String toString() {
            return "Nombre: " + nombre + ", Edad: " + edad + ", Nivel de habilidad: " + nivelHabilidad + ", Cuota mensual: " + cuotaMensual;
        }
    }

    private static ArrayList<MiembroAjedrez> miembrosAjedrez = new ArrayList<>();

    // Datos para los jugadores de fútbol
    private static String[] nombresFutbol = {"Juan", "Pedro", "Luis", "Carlos", "Javier"};
    private static double[] pesosFutbol = {70.5, 80.0, 75.0, 85.0, 72.0};
    private static int[] edadesFutbol = {22, 25, 30, 28, 24};

    // Datos para los nadadores
    private static String[] nombresNadadores = {"Ana", "María", "Lucía", "Sofía", "Clara"};
    private static double[] tiemposNadadores = {55.2, 52.5, 58.0, 51.0, 54.3};
    private static int[] edadesNadadores = {22, 26, 24, 20, 23};

    // Datos para los tenistas
    private static String[] nombresTenistas = {"Juan", "Pedro", "Luis", "Carlos", "Javier"};
    private static int[] rankingsTenistas = {5, 8, 3, 10, 6};
    private static int[] edadesTenistas = {28, 30, 25, 27, 22};

    public static void main(String[] args) {
        while (true) {
            String[] opciones = {
                "Gestionar reservas de entradas para películas",
                "Gestionar socios de club de lectura",
                "Gestionar inscripciones en club de natación",
                "Gestionar miembros de club de ajedrez",
                "Seleccionar jugadores de fútbol",
                "Seleccionar nadadores",
                "Seleccionar tenistas",
                "Salir"
            };
            String opcion = (String) JOptionPane.showInputDialog(null, "Selecciona una opción:", "Gestión de Clubes", JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);

            if (opcion == null || opcion.equals("Salir")) break;

            switch (opcion) {
                case "Gestionar reservas de entradas para películas":
                    gestionarReservasPeliculas();
                    break;
                case "Gestionar socios de club de lectura":
                    gestionarSociosClubLectura();
                    break;
                case "Gestionar inscripciones en club de natación":
                    gestionarInscripcionesNatacion();
                    break;
                case "Gestionar miembros de club de ajedrez":
                    gestionarMiembrosAjedrez();
                    break;
                case "Seleccionar jugadores de fútbol":
                    seleccionarJugadoresFutbol();
                    break;
                case "Seleccionar nadadores":
                    seleccionarNadadores();
                    break;
                case "Seleccionar tenistas":
                    seleccionarTenistas();
                    break;
            }
        }
    }

    // Gestión de reservas de entradas para películas
    private static void gestionarReservasPeliculas() {
        ArrayList<Reserva> reservas = new ArrayList<>();
        while (true) {
            String[] opciones = {
                "Mostrar todas las reservas",
                "Agregar nueva reserva",
                "Actualizar número de entradas",
                "Buscar reserva por nombre",
                "Calcular ingreso total",
                "Salir"
            };
            String opcion = (String) JOptionPane.showInputDialog(null, "Selecciona una opción:", "Gestión de Reservas de Películas", JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);

            if (opcion == null || opcion.equals("Salir")) break;

            switch (opcion) {
                case "Mostrar todas las reservas":
                    mostrarReservas(reservas);
                    break;
                case "Agregar nueva reserva":
                    agregarReserva(reservas);
                    break;
                case "Actualizar número de entradas":
                    actualizarNumeroEntradas(reservas);
                    break;
                case "Buscar reserva por nombre":
                    buscarReservaPorNombre(reservas);
                    break;
                case "Calcular ingreso total":
                    calcularIngresoTotal(reservas);
                    break;
            }
        }
    }

    private static void mostrarReservas(ArrayList<Reserva> reservas) {
        StringBuilder sb = new StringBuilder();
        for (Reserva reserva : reservas) {
            sb.append(reserva).append("\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }

    private static void agregarReserva(ArrayList<Reserva> reservas) {
        String nombreCliente = JOptionPane.showInputDialog("Nombre del cliente:");
        String pelicula = JOptionPane.showInputDialog("Película:");
        int numeroEntradas = Integer.parseInt(JOptionPane.showInputDialog("Número de entradas:"));
        double precioTotal = Double.parseDouble(JOptionPane.showInputDialog("Precio total:"));
        reservas.add(new Reserva(nombreCliente, pelicula, numeroEntradas, precioTotal));
        JOptionPane.showMessageDialog(null, "Reserva añadida.");
    }

    private static void actualizarNumeroEntradas(ArrayList<Reserva> reservas) {
        String nombreCliente = JOptionPane.showInputDialog("Nombre del cliente:");
        for (Reserva reserva : reservas) {
            if (reserva.nombreCliente.equals(nombreCliente)) {
                int nuevasEntradas = Integer.parseInt(JOptionPane.showInputDialog("Nuevo número de entradas:"));
                reserva.numeroEntradas = nuevasEntradas;
                reserva.precioTotal = reserva.precioTotal / reserva.numeroEntradas * nuevasEntradas; // Ajustar el precio total
                JOptionPane.showMessageDialog(null, "Número de entradas actualizado.");
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Reserva no encontrada.");
    }

    private static void buscarReservaPorNombre(ArrayList<Reserva> reservas) {
        String nombreCliente = JOptionPane.showInputDialog("Nombre del cliente:");
        for (Reserva reserva : reservas) {
            if (reserva.nombreCliente.equals(nombreCliente)) {
                JOptionPane.showMessageDialog(null, reserva.toString());
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Reserva no encontrada.");
    }

    private static void calcularIngresoTotal(ArrayList<Reserva> reservas) {
        double ingresoTotal = 0;
        for (Reserva reserva : reservas) {
            ingresoTotal += reserva.precioTotal;
        }
        JOptionPane.showMessageDialog(null, "Ingreso total: " + ingresoTotal);
    }

    static class Reserva {
        String nombreCliente;
        String pelicula;
        int numeroEntradas;
        double precioTotal;

        Reserva(String nombreCliente, String pelicula, int numeroEntradas, double precioTotal) {
            this.nombreCliente = nombreCliente;
            this.pelicula = pelicula;
            this.numeroEntradas = numeroEntradas;
            this.precioTotal = precioTotal;
        }

        @Override
        public String toString() {
            return "Nombre del cliente: " + nombreCliente + ", Película: " + pelicula + ", Número de entradas: " + numeroEntradas + ", Precio total: " + precioTotal;
        }
    }

    // Gestión de socios de club de lectura
    private static void gestionarSociosClubLectura() {
        while (true) {
            String[] opciones = {
                "Mostrar lista completa de socios",
                "Agregar nuevo socio",
                "Actualizar libro favorito",
                "Buscar socio por nombre",
                "Calcular promedio de edad",
                "Salir"
            };
            String opcion = (String) JOptionPane.showInputDialog(null, "Selecciona una opción:", "Gestión de Socios de Club de Lectura", JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);

            if (opcion == null || opcion.equals("Salir")) break;

            switch (opcion) {
                case "Mostrar lista completa de socios":
                    mostrarSocios();
                    break;
                case "Agregar nuevo socio":
                    agregarSocio();
                    break;
                case "Actualizar libro favorito":
                    actualizarLibroFavorito();
                    break;
                case "Buscar socio por nombre":
                    buscarSocioPorNombre();
                    break;
                case "Calcular promedio de edad":
                    calcularPromedioEdadSocios();
                    break;
            }
        }
    }

    private static void mostrarSocios() {
        StringBuilder sb = new StringBuilder();
        for (Socio socio : socios) {
            sb.append(socio).append("\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }

    private static void agregarSocio() {
        String nombre = JOptionPane.showInputDialog("Nombre del socio:");
        int edad = Integer.parseInt(JOptionPane.showInputDialog("Edad del socio:"));
        String libroFavorito = JOptionPane.showInputDialog("Libro favorito del socio:");
        socios.add(new Socio(nombre, edad, libroFavorito));
        JOptionPane.showMessageDialog(null, "Socio añadido.");
    }

    private static void actualizarLibroFavorito() {
        String nombre = JOptionPane.showInputDialog("Nombre del socio:");
        for (Socio socio : socios) {
            if (socio.nombre.equals(nombre)) {
                String libroFavorito = JOptionPane.showInputDialog("Nuevo libro favorito:");
                socio.libroFavorito = libroFavorito;
                JOptionPane.showMessageDialog(null, "Libro favorito actualizado.");
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Socio no encontrado.");
    }

    private static void buscarSocioPorNombre() {
        String nombre = JOptionPane.showInputDialog("Nombre del socio:");
        for (Socio socio : socios) {
            if (socio.nombre.equals(nombre)) {
                JOptionPane.showMessageDialog(null, socio.toString());
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Socio no encontrado.");
    }

    private static void calcularPromedioEdadSocios() {
        if (socios.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay socios registrados.");
            return;
        }
        int sumaEdad = 0;
        for (Socio socio : socios) {
            sumaEdad += socio.edad;
        }
        double promedio = (double) sumaEdad / socios.size();
        JOptionPane.showMessageDialog(null, "Promedio de edad: " + promedio);
    }

    // Gestión de inscripciones en club de natación
    private static void gestionarInscripcionesNatacion() {
        while (true) {
            String[] opciones = {
                "Mostrar todas las inscripciones",
                "Agregar nueva inscripción",
                "Actualizar nivel de natación",
                "Buscar inscripción por nombre",
                "Calcular ingreso total",
                "Salir"
            };
            String opcion = (String) JOptionPane.showInputDialog(null, "Selecciona una opción:", "Gestión de Inscripciones en Club de Natación", JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);

            if (opcion == null || opcion.equals("Salir")) break;

            switch (opcion) {
                case "Mostrar todas las inscripciones":
                    mostrarInscripciones();
                    break;
                case "Agregar nueva inscripción":
                    agregarInscripcion();
                    break;
                case "Actualizar nivel de natación":
                    actualizarNivelNatacion();
                    break;
                case "Buscar inscripción por nombre":
                    buscarInscripcionPorNombre();
                    break;
                case "Calcular ingreso total":
                    calcularIngresoTotalInscripciones();
                    break;
            }
        }
    }

    private static void mostrarInscripciones() {
        StringBuilder sb = new StringBuilder();
        for (Inscripcion inscripcion : inscripciones) {
            sb.append(inscripcion).append("\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }

    private static void agregarInscripcion() {
        String nombreMiembro = JOptionPane.showInputDialog("Nombre del miembro:");
        String nivelNatacion = JOptionPane.showInputDialog("Nivel de natación:");
        double cuotaMensual = Double.parseDouble(JOptionPane.showInputDialog("Cuota mensual:"));
        inscripciones.add(new Inscripcion(nombreMiembro, nivelNatacion, cuotaMensual));
        JOptionPane.showMessageDialog(null, "Inscripción añadida.");
    }

    private static void actualizarNivelNatacion() {
        String nombreMiembro = JOptionPane.showInputDialog("Nombre del miembro:");
        for (Inscripcion inscripcion : inscripciones) {
            if (inscripcion.nombreMiembro.equals(nombreMiembro)) {
                String nivelNatacion = JOptionPane.showInputDialog("Nuevo nivel de natación:");
                inscripcion.nivelNatacion = nivelNatacion;
                JOptionPane.showMessageDialog(null, "Nivel de natación actualizado.");
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Inscripción no encontrada.");
    }

    private static void buscarInscripcionPorNombre() {
        String nombreMiembro = JOptionPane.showInputDialog("Nombre del miembro:");
        for (Inscripcion inscripcion : inscripciones) {
            if (inscripcion.nombreMiembro.equals(nombreMiembro)) {
                JOptionPane.showMessageDialog(null, inscripcion.toString());
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Inscripción no encontrada.");
    }

    private static void calcularIngresoTotalInscripciones() {
        double ingresoTotal = 0;
        for (Inscripcion inscripcion : inscripciones) {
            ingresoTotal += inscripcion.cuotaMensual;
        }
        JOptionPane.showMessageDialog(null, "Ingreso total: " + ingresoTotal);
    }

    // Gestión de miembros de club de ajedrez
    private static void gestionarMiembrosAjedrez() {
        while (true) {
            String[] opciones = {
                "Mostrar lista completa de miembros",
                "Agregar nuevo miembro",
                "Actualizar nivel de habilidad",
                "Buscar miembro por nombre",
                "Calcular promedio de edad",
                "Salir"
            };
            String opcion = (String) JOptionPane.showInputDialog(null, "Selecciona una opción:", "Gestión de Miembros de Club de Ajedrez", JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);

            if (opcion == null || opcion.equals("Salir")) break;

            switch (opcion) {
                case "Mostrar lista completa de miembros":
                    mostrarMiembrosAjedrez();
                    break;
                case "Agregar nuevo miembro":
                    agregarMiembroAjedrez();
                    break;
                case "Actualizar nivel de habilidad":
                    actualizarNivelHabilidad();
                    break;
                case "Buscar miembro por nombre":
                    buscarMiembroAjedrezPorNombre();
                    break;
                case "Calcular promedio de edad":
                    calcularPromedioEdadMiembrosAjedrez();
                    break;
            }
        }
    }

    private static void mostrarMiembrosAjedrez() {
        StringBuilder sb = new StringBuilder();
        for (MiembroAjedrez miembro : miembrosAjedrez) {
            sb.append(miembro).append("\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }

    private static void agregarMiembroAjedrez() {
        String nombre = JOptionPane.showInputDialog("Nombre del miembro:");
        int edad = Integer.parseInt(JOptionPane.showInputDialog("Edad del miembro:"));
        String nivelHabilidad = JOptionPane.showInputDialog("Nivel de habilidad:");
        double cuotaMensual = Double.parseDouble(JOptionPane.showInputDialog("Cuota mensual:"));
        miembrosAjedrez.add(new MiembroAjedrez(nombre, edad, nivelHabilidad, cuotaMensual));
        JOptionPane.showMessageDialog(null, "Miembro añadido.");
    }

    private static void actualizarNivelHabilidad() {
        String nombre = JOptionPane.showInputDialog("Nombre del miembro:");
        for (MiembroAjedrez miembro : miembrosAjedrez) {
            if (miembro.nombre.equals(nombre)) {
                String nivelHabilidad = JOptionPane.showInputDialog("Nuevo nivel de habilidad:");
                miembro.nivelHabilidad = nivelHabilidad;
                JOptionPane.showMessageDialog(null, "Nivel de habilidad actualizado.");
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Miembro no encontrado.");
    }

    private static void buscarMiembroAjedrezPorNombre() {
        String nombre = JOptionPane.showInputDialog("Nombre del miembro:");
        for (MiembroAjedrez miembro : miembrosAjedrez) {
            if (miembro.nombre.equals(nombre)) {
                JOptionPane.showMessageDialog(null, miembro.toString());
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Miembro no encontrado.");
    }

    private static void calcularPromedioEdadMiembrosAjedrez() {
        if (miembrosAjedrez.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay miembros registrados.");
            return;
        }
        int sumaEdad = 0;
        for (MiembroAjedrez miembro : miembrosAjedrez) {
            sumaEdad += miembro.edad;
        }
        double promedio = (double) sumaEdad / miembrosAjedrez.size();
        JOptionPane.showMessageDialog(null, "Promedio de edad: " + promedio);
    }

    // Selección de jugadores de fútbol
    private static void seleccionarJugadoresFutbol() {
        while (true) {
            String[] opciones = {
                "Mostrar lista de jugadores",
                "Seleccionar jugador por peso",
                "Seleccionar jugador por edad",
                "Salir"
            };
            String opcion = (String) JOptionPane.showInputDialog(null, "Selecciona una opción:", "Selección de Jugadores de Fútbol", JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);

            if (opcion == null || opcion.equals("Salir")) break;

            switch (opcion) {
                case "Mostrar lista de jugadores":
                    mostrarJugadoresFutbol();
                    break;
                case "Seleccionar jugador por peso":
                    seleccionarJugadorPorPeso();
                    break;
                case "Seleccionar jugador por edad":
                    seleccionarJugadorPorEdad();
                    break;
            }
        }
    }

    private static void mostrarJugadoresFutbol() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nombresFutbol.length; i++) {
            sb.append("Nombre: ").append(nombresFutbol[i])
              .append(", Peso: ").append(pesosFutbol[i])
              .append(", Edad: ").append(edadesFutbol[i])
              .append("\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }

    private static void seleccionarJugadorPorPeso() {
        double peso = Double.parseDouble(JOptionPane.showInputDialog("Peso del jugador:"));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nombresFutbol.length; i++) {
            if (pesosFutbol[i] == peso) {
                sb.append("Nombre: ").append(nombresFutbol[i])
                  .append(", Peso: ").append(pesosFutbol[i])
                  .append(", Edad: ").append(edadesFutbol[i])
                  .append("\n");
            }
        }
        if (sb.length() > 0) {
            JOptionPane.showMessageDialog(null, sb.toString());
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró jugador con ese peso.");
        }
    }

    private static void seleccionarJugadorPorEdad() {
        int edad = Integer.parseInt(JOptionPane.showInputDialog("Edad del jugador:"));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nombresFutbol.length; i++) {
            if (edadesFutbol[i] == edad) {
                sb.append("Nombre: ").append(nombresFutbol[i])
                  .append(", Peso: ").append(pesosFutbol[i])
                  .append(", Edad: ").append(edadesFutbol[i])
                  .append("\n");
            }
        }
        if (sb.length() > 0) {
            JOptionPane.showMessageDialog(null, sb.toString());
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró jugador con esa edad.");
        }
    }

    // Selección de nadadores
    private static void seleccionarNadadores() {
        while (true) {
            String[] opciones = {
                "Mostrar lista de nadadores",
                "Seleccionar nadador por tiempo",
                "Seleccionar nadador por edad",
                "Salir"
            };
            String opcion = (String) JOptionPane.showInputDialog(null, "Selecciona una opción:", "Selección de Nadadores", JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);

            if (opcion == null || opcion.equals("Salir")) break;

            switch (opcion) {
                case "Mostrar lista de nadadores":
                    mostrarNadadores();
                    break;
                case "Seleccionar nadador por tiempo":
                    seleccionarNadadorPorTiempo();
                    break;
                case "Seleccionar nadador por edad":
                    seleccionarNadadorPorEdad();
                    break;
            }
        }
    }

    private static void mostrarNadadores() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nombresNadadores.length; i++) {
            sb.append("Nombre: ").append(nombresNadadores[i])
              .append(", Tiempo: ").append(tiemposNadadores[i])
              .append(", Edad: ").append(edadesNadadores[i])
              .append("\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }

    private static void seleccionarNadadorPorTiempo() {
        double tiempo = Double.parseDouble(JOptionPane.showInputDialog("Tiempo del nadador:"));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nombresNadadores.length; i++) {
            if (tiemposNadadores[i] == tiempo) {
                sb.append("Nombre: ").append(nombresNadadores[i])
                  .append(", Tiempo: ").append(tiemposNadadores[i])
                  .append(", Edad: ").append(edadesNadadores[i])
                  .append("\n");
            }
        }
        if (sb.length() > 0) {
            JOptionPane.showMessageDialog(null, sb.toString());
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró nadador con ese tiempo.");
        }
    }

    private static void seleccionarNadadorPorEdad() {
        int edad = Integer.parseInt(JOptionPane.showInputDialog("Edad del nadador:"));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nombresNadadores.length; i++) {
            if (edadesNadadores[i] == edad) {
                sb.append("Nombre: ").append(nombresNadadores[i])
                  .append(", Tiempo: ").append(tiemposNadadores[i])
                  .append(", Edad: ").append(edadesNadadores[i])
                  .append("\n");
            }
        }
        if (sb.length() > 0) {
            JOptionPane.showMessageDialog(null, sb.toString());
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró nadador con esa edad.");
        }
    }

    // Selección de tenistas
    private static void seleccionarTenistas() {
        while (true) {
            String[] opciones = {
                "Mostrar lista de tenistas",
                "Seleccionar tenista por ranking",
                "Seleccionar tenista por edad",
                "Salir"
            };
            String opcion = (String) JOptionPane.showInputDialog(null, "Selecciona una opción:", "Selección de Tenistas", JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);

            if (opcion == null || opcion.equals("Salir")) break;

            switch (opcion) {
                case "Mostrar lista de tenistas":
                    mostrarTenistas();
                    break;
                case "Seleccionar tenista por ranking":
                    seleccionarTenistaPorRanking();
                    break;
                case "Seleccionar tenista por edad":
                    seleccionarTenistaPorEdad();
                    break;
            }
        }
    }

    private static void mostrarTenistas() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nombresTenistas.length; i++) {
            sb.append("Nombre: ").append(nombresTenistas[i])
              .append(", Ranking: ").append(rankingsTenistas[i])
              .append(", Edad: ").append(edadesTenistas[i])
              .append("\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }

    private static void seleccionarTenistaPorRanking() {
        int ranking = Integer.parseInt(JOptionPane.showInputDialog("Ranking del tenista:"));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nombresTenistas.length; i++) {
            if (rankingsTenistas[i] == ranking) {
                sb.append("Nombre: ").append(nombresTenistas[i])
                  .append(", Ranking: ").append(rankingsTenistas[i])
                  .append(", Edad: ").append(edadesTenistas[i])
                  .append("\n");
            }
        }
        if (sb.length() > 0) {
            JOptionPane.showMessageDialog(null, sb.toString());
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró tenista con ese ranking.");
        }
    }

    private static void seleccionarTenistaPorEdad() {
        int edad = Integer.parseInt(JOptionPane.showInputDialog("Edad del tenista:"));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nombresTenistas.length; i++) {
            if (edadesTenistas[i] == edad) {
                sb.append("Nombre: ").append(nombresTenistas[i])
                  .append(", Ranking: ").append(rankingsTenistas[i])
                  .append(", Edad: ").append(edadesTenistas[i])
                  .append("\n");
            }
        }
        if (sb.length() > 0) {
            JOptionPane.showMessageDialog(null, sb.toString());
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró tenista con esa edad.");
        }
    }
}
