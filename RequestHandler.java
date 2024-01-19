import java.io.*;
import java.net.Socket;

public class RequestHandler extends Thread {
    private final Socket socket;

    public RequestHandler(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        String request;
        System.out.println("---->>>> 读取请求 <<<<----");
        try {
            request = readRequest(socket);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("---->>>> 发送响应 <<<<----");
        try {
            sendResponse(socket, request);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 读取客户端请求，并打印HTTP请求数据
     *
     * @param socket 客户端socket
     * @return HTTP请求字符串
     */
    public String readRequest(Socket socket) throws IOException {
        InputStream inputStream = socket.getInputStream();
        int size = inputStream.available();
        byte[] requestBuffer = new byte[size];
        inputStream.read(requestBuffer);
        String request = new String(requestBuffer);
        System.out.println(request);
        return request;
    }

    /**
     * 解析HTTP请求并向客户端发送响应
     *
     * @param socket  客户端socket
     * @param request 客户端HTTP请求字符串
     */
    public void sendResponse(Socket socket, String request) throws IOException {
        //TODO:解析HTTP请求

        //TODO:创建HTTP响应结果

        //TODO:发送响应数据

    }

}
