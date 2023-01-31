import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Servidor {
    public static void main(String[] args) {
        try {

            // 1 - Crear DatagramSocket y le indicamos el puerto
            System.out.println("(Servidor) Creando socket...");
            DatagramSocket socket = new DatagramSocket(42500);

            // 2 - Crear array de bytes que actuará de buffer
            byte[] buffer = new byte[64];
            byte[] buffer2 = new byte[64];
            // 3 - Creación de datagrama con la clase DatagramPacket
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            DatagramPacket packet2 = new DatagramPacket(buffer2, buffer2.length);
            // 4 - Recepción del datagrama mediante el método receive
            socket.receive(packet);
            socket.receive(packet2);

            String mensaje = "Hola "+ new String(packet.getData()) + " eres el " + new String(packet2.getData());

            // 5 - Generación y envío de la respuesta
            System.out.println("(Servidor): Enviando datagrama...");
            byte[] bufferSalida = mensaje.getBytes();

            DatagramPacket packetSalida = new DatagramPacket(bufferSalida, bufferSalida.length, packet.getAddress(), packet.getPort());

            socket.send(packetSalida);

            // 6 - Cierre del socket
            System.out.println("(Servidor): Cerrando la conexión...");
            socket.close();
            System.out.println("(Servidor): Conexión cerrada");

        }catch (SocketException e){
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}