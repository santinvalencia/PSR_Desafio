package desafios;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

// Clase que representa a un cliente
class Cliente {
    private String nombre;
    private boolean atendido;

    public Cliente(String nombre) {
        this.nombre = nombre;
        this.atendido = false;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean isAtendido() {
        return atendido;
    }

    public void atender() {
        atendido = true;
    }
}

// Clase que representa al cajero del banco
class Cajero {
    private String nombre;

    public Cajero(String nombre) {
        this.nombre = nombre;
    }

    // Atender a un cliente
    public void atenderCliente(Cliente cliente) {
        System.out.println(nombre + " está atendiendo a " + cliente.getNombre());
        cliente.atender();
        System.out.println(cliente.getNombre() + " fue atendido.\n");
    }
}

// Clase principal
public class ColaBanco {
    public static void main(String[] args) {
        // Crear la cola de clientes
        Queue<Cliente> cola = new LinkedList<>();

        // Crear cajero
        Cajero cajero = new Cajero("Cajero 1");

        // Agregar algunos clientes
        cola.add(new Cliente("Erick"));
        cola.add(new Cliente("Santiago"));
        cola.add(new Cliente("Dominique"));
        cola.add(new Cliente("Fausto"));
        cola.add(new Cliente("Tiziano"));

        System.out.println("Simulación de cola de banco iniciada...\n");

        // Simular la atención de los clientes
        while (!cola.isEmpty()) {
            Cliente clienteActual = cola.poll(); // saca el primero de la cola
            cajero.atenderCliente(clienteActual);
            esperarAleatorio(); // simula el tiempo de atención
        }

        System.out.println("Todos los clientes han sido atendidos.");
    }

    // Método auxiliar para simular tiempo de espera
    private static void esperarAleatorio() {
        try {
            Thread.sleep(new Random().nextInt(1500) + 500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
