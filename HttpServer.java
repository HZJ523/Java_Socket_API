import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.ServerSocket;
import java.net.InetAddress;

public class HttpServer {
    String hostname = "localhost";//服务器主机名
    int port = 8080;

    ServerSocket serverSocket;

    public void start() {
        try {
            serverSocket = new ServerSocket();
            //服务器ip+端口
            serverSocket.bind(new InetSocketAddress(hostname, port));
            System.out.println("---->>>> 服务器已经启动 <<<<----");
            System.out.println("服务器正在监听端口：" + serverSocket.getLocalPort());

            while (true) {
                try {
                    Socket socket = serverSocket.accept();
                    System.out.println("---->>>> 收到客户端请求 <<<<----");
                    System.out.println("客户端的地址为：" + socket.getInetAddress());
                    //响应客户请求
                    RequestHandler requestHandler = new RequestHandler(socket);
                    requestHandler.start();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            HttpServer httpServer = new HttpServer();
            httpServer.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.exit(0);
    }

}
