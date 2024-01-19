import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.*;

public class HttpClient {
    public void start() throws IOException {
        String hostname = "localhost";//服务器主机名
        int port = 8080;

        System.out.println("---->>>> 开始连接 <<<<----");
        Socket socket = new Socket();
        socket.connect(new InetSocketAddress(hostname,port),10*1000);

        System.out.println("---->>>> 发送请求 <<<<----");
        //TODO:发送请求
        String url = "example";
        doGet(socket,url);

    }


    /**
     * GET方法，向服务器请求资源
     * @param socket 客户端socket
     * @param url 请求资源url
     */
    public static void doGet(Socket socket, String url) throws IOException {
        try {
            //TODO:创建HTTP请求
            StringBuffer stringBuffer = new StringBuffer("GET1 " + url + " HTTP/1.1\r\n");

            //TODO:发送HTTP请求
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write(stringBuffer.toString().getBytes());

            //TODO:接受响应结果并呈现
            InputStream inputStream = socket.getInputStream();//获得服务器响应数据
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            System.out.println(new String(buffer));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        try{
            HttpClient httpClient = new HttpClient();
            httpClient.start();
        }catch (Exception e){
            e.printStackTrace();
        }
        System.exit(0);
    }
}
