import java.io.IOException;
import java.net.*;

public class Cliente {
    public static void main(String[] args) {
        try {

            // 1 - Obtención de la dirección del servidor usando el métod getLocalHost de
            // InetAddress
            System.out.println("(Cliente): Estableciendo parámetros de conexión...");
            InetAddress direccion = InetAddress.getLocalHost();

            // 2 - Creación del socket UDP
            System.out.println("(Cliente): Creando el socket...");
            DatagramSocket socket = new DatagramSocket();
            System.out.println("(Cliente) Enviando datagrama1...");
            String mensaje = "diego";
            // 3 - Generación del datagrama
            System.out.println("(Cliente): Creando datagrama...");
            byte[] buffer = mensaje.getBytes();
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length, direccion, 42500);
            socket.send(packet);

            String mensaje2 ="abcde";
            byte[] buffer2 = mensaje2.getBytes();
            DatagramPacket packet2 = new DatagramPacket(buffer2, buffer2.length, direccion, 42500);

            // 4 - Envío del datagrama a través de send
            System.out.println("(Cliente) Enviando datagrama2...");
            socket.send(packet2);


            // 5 - Recepción de la respuesta
            System.out.println("(Cliente) Recibiendo respuesta...");
            byte[] bufferEntrada = new byte[64];
            DatagramPacket packetRecibir = new DatagramPacket(bufferEntrada, bufferEntrada.length);
            socket.receive(packetRecibir);
            String mensajeRecibido =  new String(packetRecibir.getData());
            System.out.println(mensajeRecibido.trim());


            // 5 - Recepción de la respuesta
            System.out.println("(Cliente) Recibiendo respuesta...");
            byte[] bufferEntrada2 = new byte[64];
            DatagramPacket packetRecibir2 = new DatagramPacket(bufferEntrada, bufferEntrada.length);
            socket.receive(packetRecibir2);
            String mensajeRecibido2 =  new String(packetRecibir.getData());
            System.out.println(mensajeRecibido2.trim());

            // 6 - Cierre del socket
            System.out.println("(Cliente): Cerrando conexión...");
            socket.close();
            System.out.println("(Cliente): Conexión cerrada.");

        } catch (SocketException e) {
            throw new RuntimeException(e);
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}