import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.*;

public class HttpClient {
    public void start() throws IOException {
        String hostname = "localhost";//服务器主机名
        int port = 8080;
        String response;

        System.out.println("---->>>> 开始连接 <<<<----");
        Socket socket = new Socket();
        socket.connect(new InetSocketAddress(hostname, port), 10 * 1000);

        System.out.println("---->>>> 发送请求 <<<<----");
        //TODO:发送请求
        String url = "example";
        response = sendRequest(socket, url);
        handleResponse(response);

        socket.close();
        System.exit(0);
    }


    /**
     * 向服务器发送HTTP请求并接受响应报文
     * @param socket 客户端socket
     * @param url
     * @return 响应报文
     */
    public static String sendRequest(Socket socket, String url) throws IOException {

        //TODO:创建HTTP请求 实现GET/POST两种请求报文
        StringBuffer stringBuffer = new StringBuffer("GET1 " + url + " HTTP/1.1\r\n");//仅测试，需修改

        //发送HTTP请求
        OutputStream outputStream = socket.getOutputStream();//创建输出流
        outputStream.write(stringBuffer.toString().getBytes());//HTTP请求写入输出流

        //接受响应数据
        InputStream inputStream = socket.getInputStream();//获得服务器响应报文
        int size = inputStream.available();
        byte[] responseBuffer = new byte[size];
        inputStream.read(responseBuffer);
        return new String(responseBuffer);
    }

    /**
     * 客户端对响应报文进行处理 如特殊状态码
     * @param response 响应报文
     */
    public static void handleResponse(String response){
        //TODO:MIME至少支持三种类型，包含一种非文本类型

        //TODO:HTTP客户端对301、302、304的状态码做相应的处理
    }

    public static void main(String[] args) throws IOException {
        try {
            HttpClient httpClient = new HttpClient();
            httpClient.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.exit(0);
    }
}
