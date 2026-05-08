/**
 * Comprehensive Java Networking Program for Beginners
 * 
 * This program demonstrates all fundamental networking concepts in Java
 * with simple, easy-to-understand examples.
 * 
 * Topics covered:
 * 1. IP Address and Network Interface Information
 * 2. URL and URLConnection
 * 3. HTTP Connections
 * 4. Socket Programming (Client-Server)
 * 5. Multi-Client Server
 * 6. UDP Communication
 * 7. InetAddress methods
 * 8. Downloading files from internet
 */

import java.io.*;
import java.net.*;
import java.util.*;
import java.net.http.*;
import java.time.Duration;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.CompletableFuture;

public class JavaNetworkingForBeginners {
    
    public static void main(String[] args) {
        System.out.println("=".repeat(80));
        System.out.println("JAVA NETWORKING - BEGINNER'S GUIDE");
        System.out.println("=".repeat(80));
        
        // Section 1: Understanding IP Addresses
        System.out.println("\n" + "#".repeat(60));
        System.out.println("SECTION 1: IP ADDRESS AND NETWORK INFORMATION");
        System.out.println("#".repeat(60));
        demonstrateInetAddress();
        
        // Section 2: Working with URLs
        System.out.println("\n" + "#".repeat(60));
        System.out.println("SECTION 2: WORKING WITH URLS");
        System.out.println("#".repeat(60));
        demonstrateURLs();
        
        // Section 3: HTTP Connections (Traditional)
        System.out.println("\n" + "#".repeat(60));
        System.out.println("SECTION 3: HTTP CONNECTIONS (TRADITIONAL)");
        System.out.println("#".repeat(60));
        demonstrateHttpURLConnection();
        
        // Section 4: Modern HTTP Client (Java 11+)
        System.out.println("\n" + "#".repeat(60));
        System.out.println("SECTION 4: MODERN HTTP CLIENT (JAVA 11+)");
        System.out.println("#".repeat(60));
        demonstrateHttpClient();
        
        // Section 5: TCP Socket Programming - Server
        System.out.println("\n" + "#".repeat(60));
        System.out.println("SECTION 5: TCP SOCKET PROGRAMMING - SERVER");
        System.out.println("#".repeat(60));
        demonstrateTCPServer();
        
        // Section 6: TCP Socket Programming - Client
        System.out.println("\n" + "#".repeat(60));
        System.out.println("SECTION 6: TCP SOCKET PROGRAMMING - CLIENT");
        System.out.println("#".repeat(60));
        demonstrateTCPClient();
        
        // Section 7: Multi-Client Server
        System.out.println("\n" + "#".repeat(60));
        System.out.println("SECTION 7: MULTI-CLIENT SERVER");
        System.out.println("#".repeat(60));
        demonstrateMultiClientServer();
        
        // Section 8: UDP Communication
        System.out.println("\n" + "#".repeat(60));
        System.out.println("SECTION 8: UDP COMMUNICATION");
        System.out.println("#".repeat(60));
        demonstrateUDP();
        
        // Section 9: Download File from Internet
        System.out.println("\n" + "#".repeat(60));
        System.out.println("SECTION 9: DOWNLOAD FILE FROM INTERNET");
        System.out.println("#".repeat(60));
        demonstrateFileDownload();
        
        // Section 10: Network Utilities
        System.out.println("\n" + "#".repeat(60));
        System.out.println("SECTION 10: NETWORK UTILITIES");
        System.out.println("#".repeat(60));
        demonstrateNetworkUtilities();
        
        System.out.println("\n" + "=".repeat(80));
        System.out.println("🎉 CONGRATULATIONS! You've learned Java Networking basics!");
        System.out.println("=".repeat(80));
    }
    
    // =========================================================================
    // SECTION 1: IP ADDRESS AND NETWORK INFORMATION
    // =========================================================================
    
    private static void demonstrateInetAddress() {
        System.out.println("\n📌 InetAddress - Working with IP Addresses");
        
        try {
            // Method 1: Get local host address
            System.out.println("\n1. Local Host Information:");
            InetAddress localHost = InetAddress.getLocalHost();
            System.out.println("   Host Name: " + localHost.getHostName());
            System.out.println("   Host Address: " + localHost.getHostAddress());
            System.out.println("   Canonical Host Name: " + localHost.getCanonicalHostName());
            
            // Method 2: Get address by name
            System.out.println("\n2. Get address by hostname:");
            InetAddress google = InetAddress.getByName("www.google.com");
            System.out.println("   Google IP: " + google.getHostAddress());
            
            // Method 3: Get all addresses for a host
            System.out.println("\n3. All addresses for a host:");
            InetAddress[] allGoogle = InetAddress.getAllByName("www.google.com");
            System.out.println("   Google has " + allGoogle.length + " IP addresses:");
            for (int i = 0; i < Math.min(3, allGoogle.length); i++) {
                System.out.println("   - " + allGoogle[i].getHostAddress());
            }
            
            // Method 4: Get by IP address
            System.out.println("\n4. Get by IP address:");
            byte[] ip = {8, 8, 8, 8}; // Google DNS
            InetAddress byIP = InetAddress.getByAddress(ip);
            System.out.println("   IP 8.8.8.8 resolves to: " + byIP.getHostName());
            
            // Method 5: Check reachability
            System.out.println("\n5. Check reachability (ping):");
            System.out.println("   Is Google reachable? " + google.isReachable(5000));
            
            // Method 6: Loopback address
            System.out.println("\n6. Loopback address:");
            InetAddress loopback = InetAddress.getLoopbackAddress();
            System.out.println("   Loopback: " + loopback.getHostAddress());
            
            // Method 7: Check if special address
            System.out.println("\n7. Address type checks:");
            System.out.println("   Is loopback? " + loopback.isLoopbackAddress());
            System.out.println("   Is site local? " + localHost.isSiteLocalAddress());
            System.out.println("   Is multicast? " + localHost.isMulticastAddress());
            
        } catch (UnknownHostException e) {
            System.out.println("   Error: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("   Error: " + e.getMessage());
        }
        
        System.out.println("\n   ✅ InetAddress demonstrated");
    }
    
    // =========================================================================
    // SECTION 2: WORKING WITH URLS
    // =========================================================================
    
    private static void demonstrateURLs() {
        System.out.println("\n📌 URL - Working with URLs");
        
        try {
            // Method 1: Create URL
            System.out.println("\n1. Creating URL objects:");
            URL url1 = new URL("https://www.example.com:8080/path/page.html?query=java#section");
            URL url2 = new URL("https", "www.example.com", 443, "/index.html");
            URL url3 = new URL("https://www.google.com/search?q=java+networking");
            
            System.out.println("   URL 1: " + url1);
            System.out.println("   URL 2: " + url2);
            System.out.println("   URL 3: " + url3);
            
            // Method 2: Parse URL components
            System.out.println("\n2. Parsing URL components:");
            System.out.println("   Protocol: " + url1.getProtocol());
            System.out.println("   Host: " + url1.getHost());
            System.out.println("   Port: " + url1.getPort());
            System.out.println("   Default Port: " + url1.getDefaultPort());
            System.out.println("   Path: " + url1.getPath());
            System.out.println("   Query: " + url1.getQuery());
            System.out.println("   File: " + url1.getFile());
            System.out.println("   Ref (anchor): " + url1.getRef());
            System.out.println("   Authority: " + url1.getAuthority());
            System.out.println("   User Info: " + url1.getUserInfo());
            
            // Method 3: Compare URLs
            System.out.println("\n3. URL comparison:");
            URL sameUrl = new URL("https://www.EXAMPLE.com:8080/path/page.html?query=java#section");
            System.out.println("   equals (case-sensitive): " + url1.equals(sameUrl));
            System.out.println("   sameFile (ignores fragment): " + url1.sameFile(sameUrl));
            
            // Method 4: Open connection
            System.out.println("\n4. Open connection (basic):");
            URLConnection conn = url3.openConnection();
            System.out.println("   Connection type: " + conn.getClass().getSimpleName());
            System.out.println("   Content length: " + conn.getContentLength());
            System.out.println("   Content type: " + conn.getContentType());
            
            // Method 5: Get content
            System.out.println("\n5. Get content (simplified):");
            Object content = url3.getContent();
            System.out.println("   Content class: " + content.getClass().getName());
            
            // Method 6: Stream handler
            System.out.println("\n6. URL Stream Handler:");
            // URLStreamHandler handler = url1.getURLStreamHandler();
            // System.out.println("   Handler for " + url1.getProtocol() + ": " + handler);
            
            System.out.println("Protocol: " + url1.getProtocol());
            System.out.println("Host: " + url1.getHost());
            System.out.println("Port: " + url1.getPort());
        } catch (MalformedURLException e) {
            System.out.println("   Malformed URL: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("   IO Error: " + e.getMessage());
        }
        
        System.out.println("\n   ✅ URL demonstrated");
    }
    
    // =========================================================================
    // SECTION 3: HTTP CONNECTIONS (TRADITIONAL)
    // =========================================================================
    
    private static void demonstrateHttpURLConnection() {
        System.out.println("\n📌 HttpURLConnection - Traditional HTTP Client");
        
        try {
            // Create URL and open connection
            URL url = new URL("https://httpbin.org/get");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            
            // Method 1: Set request method
            System.out.println("\n1. Setting request method:");
            conn.setRequestMethod("GET");
            System.out.println("   Request method: " + conn.getRequestMethod());
            
            // Method 2: Set request headers
            System.out.println("\n2. Setting request headers:");
            conn.setRequestProperty("User-Agent", "Java Networking Demo");
            conn.setRequestProperty("Accept", "application/json");
            System.out.println("   User-Agent: " + conn.getRequestProperty("User-Agent"));
            System.out.println("   Accept: " + conn.getRequestProperty("Accept"));
            
            // Method 3: Set timeouts
            System.out.println("\n3. Setting timeouts:");
            conn.setConnectTimeout(5000); // 5 seconds
            conn.setReadTimeout(5000);
            System.out.println("   Connect timeout: " + conn.getConnectTimeout() + "ms");
            System.out.println("   Read timeout: " + conn.getReadTimeout() + "ms");
            
            // Method 4: Connect
            System.out.println("\n4. Connecting...");
            conn.connect();
            System.out.println("   Connected");
            
            // Method 5: Get response code and message
            System.out.println("\n5. Response information:");
            int responseCode = conn.getResponseCode();
            String responseMessage = conn.getResponseMessage();
            System.out.println("   Response code: " + responseCode);
            System.out.println("   Response message: " + responseMessage);
            
            // Method 6: Get response headers
            System.out.println("\n6. Response headers:");
            Map<String, List<String>> headers = conn.getHeaderFields();
            for (Map.Entry<String, List<String>> entry : headers.entrySet()) {
                String key = entry.getKey();
                if (key != null) {
                    System.out.println("   " + key + ": " + entry.getValue().get(0));
                }
            }
            
            // Method 7: Read response body
            System.out.println("\n7. Reading response body (first 200 chars):");
            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()))) {
                String line;
                int count = 0;
                while ((line = reader.readLine()) != null && count < 5) {
                    System.out.println("   " + line);
                    count++;
                }
            }
            
            // Method 8: Check various properties
            System.out.println("\n8. Connection properties:");
            System.out.println("   Content length: " + conn.getContentLength());
            System.out.println("   Content type: " + conn.getContentType());
            System.out.println("   Content encoding: " + conn.getContentEncoding());
            System.out.println("   Date: " + new Date(conn.getDate()));
            System.out.println("   Expiration: " + conn.getExpiration());
            System.out.println("   Last modified: " + new Date(conn.getLastModified()));
            
            // Method 9: POST request example (commented out)
            System.out.println("\n9. POST request example:");
            System.out.println("   (Would send data in real implementation)");
            
            // Method 10: Disconnect
            System.out.println("\n10. Disconnecting...");
            conn.disconnect();
            System.out.println("   Disconnected");
            
        } catch (MalformedURLException e) {
            System.out.println("   Malformed URL: " + e.getMessage());
        } catch (ProtocolException e) {
            System.out.println("   Protocol error: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("   IO Error: " + e.getMessage());
        }
        
        System.out.println("\n   ✅ HttpURLConnection demonstrated");
    }
    
    // =========================================================================
    // SECTION 4: MODERN HTTP CLIENT (JAVA 11+)
    // =========================================================================
    
    private static void demonstrateHttpClient() {
        System.out.println("\n📌 HTTP Client - Modern API (Java 11+)");
        
        try {
            // Method 1: Create HTTP Client
            System.out.println("\n1. Creating HTTP Client:");
            HttpClient client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .connectTimeout(Duration.ofSeconds(10))
                .followRedirects(HttpClient.Redirect.NORMAL)
                .build();
            System.out.println("   Client created");
            System.out.println("   Version: " + client.version());
            System.out.println("   Connect timeout: " + client.connectTimeout().orElse(null));
            
            // Method 2: Create GET request
            System.out.println("\n2. Creating GET request:");
            HttpRequest getRequest = HttpRequest.newBuilder()
                .uri(URI.create("https://httpbin.org/get"))
                .header("User-Agent", "Java HTTP Client")
                .timeout(Duration.ofSeconds(30))
                .GET()
                .build();
            System.out.println("   GET request created");
            System.out.println("   URI: " + getRequest.uri());
            System.out.println("   Method: " + getRequest.method());
            
            // Method 3: Send request synchronously
            System.out.println("\n3. Sending request synchronously:");
            HttpResponse<String> response = client.send(getRequest, 
                HttpResponse.BodyHandlers.ofString());
            
            System.out.println("   Status code: " + response.statusCode());
            System.out.println("   Response headers: " + response.headers().map().size() + " headers");
            System.out.println("   Body preview: " + response.body().substring(0, 100) + "...");
            
            // Method 4: Send request asynchronously
            System.out.println("\n4. Sending request asynchronously:");
            CompletableFuture<HttpResponse<String>> futureResponse = 
                client.sendAsync(getRequest, HttpResponse.BodyHandlers.ofString());
            
            futureResponse.thenAccept(resp -> {
                System.out.println("   Async response code: " + resp.statusCode());
            }).join(); // Wait for completion
            
            // Method 5: POST request with body
            System.out.println("\n5. POST request with body:");
            String jsonBody = "{\"name\":\"John\",\"age\":30}";
            HttpRequest postRequest = HttpRequest.newBuilder()
                .uri(URI.create("https://httpbin.org/post"))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(jsonBody))
                .build();
            
            HttpResponse<String> postResponse = client.send(postRequest, 
                HttpResponse.BodyHandlers.ofString());
            System.out.println("   POST response code: " + postResponse.statusCode());
            
            // Method 6: Handle different body types
            System.out.println("\n6. Different body handlers:");
            System.out.println("   - BodyHandlers.ofString(): String");
            System.out.println("   - BodyHandlers.ofFile(): Save to file");
            System.out.println("   - BodyHandlers.ofByteArray(): byte[]");
            System.out.println("   - BodyHandlers.discarding(): Ignore body");
            
            // Method 7: Request with parameters
            System.out.println("\n7. Request with query parameters:");
            URI uri = new URI("https://httpbin.org/get?param1=value1&param2=value2");
            HttpRequest paramRequest = HttpRequest.newBuilder(uri).GET().build();
            System.out.println("   URI with parameters: " + paramRequest.uri());
            
            // Method 8: Check response info
            System.out.println("\n8. Response information:");
            System.out.println("   Previous response successful? " + (response.statusCode() == 200));
            System.out.println("   TLS version: " + response.version());
            System.out.println("   Previous response URI: " + response.uri());
            
        } catch (URISyntaxException e) {
            System.out.println("   URI syntax error: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("   IO Error: " + e.getMessage());
        } catch (InterruptedException e) {
            System.out.println("   Interrupted: " + e.getMessage());
        }
        
        System.out.println("\n   ✅ HTTP Client demonstrated");
    }
    
    // =========================================================================
    // SECTION 5: TCP SOCKET PROGRAMMING - SERVER
    // =========================================================================
    
    private static void demonstrateTCPServer() {
        System.out.println("\n📌 TCP Server - Socket Programming");
        
        // Simple echo server
        Thread serverThread = new Thread(() -> {
            try {
                // Method 1: Create server socket
                System.out.println("\n1. Creating server socket on port 8888...");
                ServerSocket serverSocket = new ServerSocket(8888);
                System.out.println("   Server socket created");
                System.out.println("   Local port: " + serverSocket.getLocalPort());
                System.out.println("   Inet address: " + serverSocket.getInetAddress());
                
                // Method 2: Set timeout
                serverSocket.setSoTimeout(10000); // 10 seconds timeout
                System.out.println("   Timeout set to: " + serverSocket.getSoTimeout() + "ms");
                
                // Method 3: Wait for client connection
                System.out.println("\n2. Waiting for client connection...");
                Socket clientSocket = serverSocket.accept();
                System.out.println("   Client connected!");
                System.out.println("   Client address: " + clientSocket.getInetAddress());
                System.out.println("   Client port: " + clientSocket.getPort());
                
                // Method 4: Set socket options
                clientSocket.setTcpNoDelay(true);
                clientSocket.setKeepAlive(true);
                System.out.println("\n3. Socket options:");
                System.out.println("   TCP no delay: " + clientSocket.getTcpNoDelay());
                System.out.println("   Keep alive: " + clientSocket.getKeepAlive());
                System.out.println("   Receive buffer size: " + clientSocket.getReceiveBufferSize());
                System.out.println("   Send buffer size: " + clientSocket.getSendBufferSize());
                
                // Method 5: Get I/O streams
                System.out.println("\n4. Setting up I/O streams...");
                BufferedReader in = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(
                    clientSocket.getOutputStream(), true);
                
                // Method 6: Communicate with client
                System.out.println("\n5. Communicating with client...");
                String clientMessage = in.readLine();
                System.out.println("   Received from client: " + clientMessage);
                
                String response = "Server echoes: " + clientMessage;
                out.println(response);
                System.out.println("   Sent response: " + response);
                
                // Method 7: Check connection state
                System.out.println("\n6. Connection state:");
                System.out.println("   isConnected: " + clientSocket.isConnected());
                System.out.println("   isClosed: " + clientSocket.isClosed());
                System.out.println("   isBound: " + clientSocket.isBound());
                System.out.println("   isInputShutdown: " + clientSocket.isInputShutdown());
                System.out.println("   isOutputShutdown: " + clientSocket.isOutputShutdown());
                
                // Method 8: Close connection
                System.out.println("\n7. Closing connection...");
                in.close();
                out.close();
                clientSocket.close();
                serverSocket.close();
                System.out.println("   Server closed");
                
            } catch (SocketTimeoutException e) {
                System.out.println("   Timeout: No client connected");
            } catch (IOException e) {
                System.out.println("   Server error: " + e.getMessage());
            }
        });
        
        serverThread.start();
        
        // Let server start
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {}
        
        // Start a client to connect (will be handled in next section)
        
        System.out.println("\n   ✅ TCP Server demonstrated (run with client)");
    }
    
    // =========================================================================
    // SECTION 6: TCP SOCKET PROGRAMMING - CLIENT
    // =========================================================================
    
    private static void demonstrateTCPClient() {
        System.out.println("\n📌 TCP Client - Socket Programming");
        
        try {
            // Wait for server to be ready
            Thread.sleep(2000);
            
            // Method 1: Create client socket
            System.out.println("\n1. Creating client socket...");
            Socket socket = new Socket();
            System.out.println("   Socket created (not connected)");
            
            // Method 2: Set socket options before connecting
            socket.setSoTimeout(5000);
            System.out.println("   Read timeout set to: " + socket.getSoTimeout() + "ms");
            
            // Method 3: Connect to server
            System.out.println("\n2. Connecting to localhost:8888...");
            socket.connect(new InetSocketAddress("localhost", 8888), 5000);
            System.out.println("   Connected to server");
            System.out.println("   Local port: " + socket.getLocalPort());
            System.out.println("   Remote port: " + socket.getPort());
            
            // Method 4: Get I/O streams
            System.out.println("\n3. Setting up I/O streams...");
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));
            
            // Method 5: Send message to server
            System.out.println("\n4. Sending message to server...");
            String message = "Hello from client!";
            out.println(message);
            System.out.println("   Sent: " + message);
            
            // Method 6: Receive response
            System.out.println("\n5. Waiting for response...");
            String response = in.readLine();
            System.out.println("   Received: " + response);
            
            // Method 7: Check socket state
            System.out.println("\n6. Socket state:");
            System.out.println("   isConnected: " + socket.isConnected());
            System.out.println("   isClosed: " + socket.isClosed());
            System.out.println("   isBound: " + socket.isBound());
            
            // Method 8: Get socket info
            System.out.println("\n7. Socket information:");
            System.out.println("   Local address: " + socket.getLocalAddress());
            System.out.println("   Remote address: " + socket.getInetAddress());
            System.out.println("   Local socket address: " + socket.getLocalSocketAddress());
            System.out.println("   Remote socket address: " + socket.getRemoteSocketAddress());
            
            // Method 9: Close connection
            System.out.println("\n8. Closing connection...");
            out.close();
            in.close();
            socket.close();
            System.out.println("   Client closed");
            
        } catch (ConnectException e) {
            System.out.println("   Connection refused - is server running?");
        } catch (SocketTimeoutException e) {
            System.out.println("   Connection timeout");
        } catch (IOException e) {
            System.out.println("   Client error: " + e.getMessage());
        } catch (InterruptedException e) {
            System.out.println("   Interrupted: " + e.getMessage());
        }
        
        System.out.println("\n   ✅ TCP Client demonstrated");
    }
    
    // =========================================================================
    // SECTION 7: MULTI-CLIENT SERVER
    // =========================================================================
    
    private static void demonstrateMultiClientServer() {
        System.out.println("\n📌 Multi-Client Server");
        
        class ClientHandler extends Thread {
            private Socket clientSocket;
            private int clientId;
            
            public ClientHandler(Socket socket, int id) {
                this.clientSocket = socket;
                this.clientId = id;
            }
            
            @Override
            public void run() {
                try {
                    System.out.println("   Handler for Client " + clientId + " started");
                    
                    BufferedReader in = new BufferedReader(
                        new InputStreamReader(clientSocket.getInputStream()));
                    PrintWriter out = new PrintWriter(
                        clientSocket.getOutputStream(), true);
                    
                    // Communicate with client
                    String message = in.readLine();
                    System.out.println("   Client " + clientId + " says: " + message);
                    
                    // Echo back with client ID
                    out.println("Server to Client " + clientId + ": " + message);
                    
                    in.close();
                    out.close();
                    clientSocket.close();
                    System.out.println("   Client " + clientId + " disconnected");
                    
                } catch (IOException e) {
                    System.out.println("   Error handling client " + clientId + ": " + e.getMessage());
                }
            }
        }
        
        // Start multi-client server in separate thread
        Thread serverThread = new Thread(() -> {
            try {
                ServerSocket serverSocket = new ServerSocket(8889);
                System.out.println("\n   Multi-client server started on port 8889");
                System.out.println("   Press Ctrl+C to stop\n");
                
                int clientCount = 0;
                
                // Accept multiple clients
                while (clientCount < 3) { // Limit to 3 for demo
                    System.out.println("   Waiting for client " + (clientCount + 1) + "...");
                    Socket clientSocket = serverSocket.accept();
                    clientCount++;
                    
                    System.out.println("   Client " + clientCount + " connected");
                    
                    // Create new thread for each client
                    ClientHandler handler = new ClientHandler(clientSocket, clientCount);
                    handler.start();
                }
                
                serverSocket.close();
                System.out.println("   Multi-client server stopped");
                
            } catch (IOException e) {
                System.out.println("   Server error: " + e.getMessage());
            }
        });
        
        serverThread.start();
        
        // Simulate multiple clients
        try {
            Thread.sleep(1000);
            
            // Client 1
            new Thread(() -> {
                try {
                    Socket socket = new Socket("localhost", 8889);
                    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                    BufferedReader in = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));
                    
                    out.println("Hello from Client 1");
                    System.out.println("   Client 1 received: " + in.readLine());
                    
                    socket.close();
                } catch (IOException e) {
                    System.out.println("   Client 1 error: " + e.getMessage());
                }
            }).start();
            
            Thread.sleep(500);
            
            // Client 2
            new Thread(() -> {
                try {
                    Socket socket = new Socket("localhost", 8889);
                    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                    BufferedReader in = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));
                    
                    out.println("Greetings from Client 2");
                    System.out.println("   Client 2 received: " + in.readLine());
                    
                    socket.close();
                } catch (IOException e) {
                    System.out.println("   Client 2 error: " + e.getMessage());
                }
            }).start();
            
            Thread.sleep(500);
            
            // Client 3
            new Thread(() -> {
                try {
                    Socket socket = new Socket("localhost", 8889);
                    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                    BufferedReader in = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));
                    
                    out.println("Hi from Client 3");
                    System.out.println("   Client 3 received: " + in.readLine());
                    
                    socket.close();
                } catch (IOException e) {
                    System.out.println("   Client 3 error: " + e.getMessage());
                }
            }).start();
            
            Thread.sleep(2000);
            
        } catch (InterruptedException e) {
            System.out.println("   Interrupted: " + e.getMessage());
        }
        
        System.out.println("\n   ✅ Multi-client server demonstrated");
    }
    
    // =========================================================================
    // SECTION 8: UDP COMMUNICATION
    // =========================================================================
    
    private static void demonstrateUDP() {
        System.out.println("\n📌 UDP Communication");
        
        // UDP Server
        Thread udpServer = new Thread(() -> {
            try {
                // Method 1: Create DatagramSocket
                System.out.println("\n1. Creating UDP server on port 9876...");
                DatagramSocket serverSocket = new DatagramSocket(9876);
                System.out.println("   UDP server started");
                
                // Method 2: Set socket options
                serverSocket.setSoTimeout(5000);
                System.out.println("   Receive timeout: " + serverSocket.getSoTimeout() + "ms");
                
                // Method 3: Prepare receive buffer
                byte[] receiveBuffer = new byte[1024];
                DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
                
                // Method 4: Receive packet
                System.out.println("\n2. Waiting for UDP packet...");
                serverSocket.receive(receivePacket);
                
                // Method 5: Extract data from packet
                String received = new String(receivePacket.getData(), 0, receivePacket.getLength());
                System.out.println("   Received: " + received);
                System.out.println("   From: " + receivePacket.getAddress());
                System.out.println("   Port: " + receivePacket.getPort());
                System.out.println("   Length: " + receivePacket.getLength() + " bytes");
                
                // Method 6: Prepare response
                String response = "Server received: " + received;
                byte[] sendBuffer = response.getBytes();
                
                // Method 7: Create send packet
                DatagramPacket sendPacket = new DatagramPacket(
                    sendBuffer, sendBuffer.length,
                    receivePacket.getAddress(), receivePacket.getPort()
                );
                
                // Method 8: Send response
                System.out.println("\n3. Sending response...");
                serverSocket.send(sendPacket);
                System.out.println("   Response sent");
                
                // Method 9: Check socket info
                System.out.println("\n4. Server socket info:");
                System.out.println("   Local port: " + serverSocket.getLocalPort());
                System.out.println("   Local address: " + serverSocket.getLocalAddress());
                System.out.println("   Broadcast: " + serverSocket.getBroadcast());
                
                // Method 10: Close socket
                serverSocket.close();
                System.out.println("   UDP server closed");
                
            } catch (SocketTimeoutException e) {
                System.out.println("   Server timeout");
            } catch (IOException e) {
                System.out.println("   UDP server error: " + e.getMessage());
            }
        });
        
        udpServer.start();
        
        // UDP Client
        try {
            Thread.sleep(1000);
            
            System.out.println("\n📤 UDP Client");
            
            // Method 1: Create client socket
            DatagramSocket clientSocket = new DatagramSocket();
            System.out.println("   UDP client created");
            
            // Method 2: Prepare data
            String message = "Hello UDP Server!";
            byte[] sendBuffer = message.getBytes();
            
            // Method 3: Create packet to send
            InetAddress serverAddress = InetAddress.getByName("localhost");
            DatagramPacket sendPacket = new DatagramPacket(
                sendBuffer, sendBuffer.length,
                serverAddress, 9876
            );
            
            // Method 4: Send packet
            System.out.println("   Sending: " + message);
            clientSocket.send(sendPacket);
            
            // Method 5: Receive response
            byte[] receiveBuffer = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
            
            clientSocket.setSoTimeout(3000);
            clientSocket.receive(receivePacket);
            
            // Method 6: Process response
            String response = new String(receivePacket.getData(), 0, receivePacket.getLength());
            System.out.println("   Received: " + response);
            
            // Method 7: Get packet info
            System.out.println("\n   Packet info:");
            System.out.println("   From: " + receivePacket.getAddress());
            System.out.println("   Port: " + receivePacket.getPort());
            System.out.println("   Length: " + receivePacket.getLength());
            
            // Method 8: Close client
            clientSocket.close();
            System.out.println("   UDP client closed");
            
        } catch (IOException | InterruptedException e) {
            System.out.println("   UDP client error: " + e.getMessage());
        }
        
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {}
        
        System.out.println("\n   ✅ UDP communication demonstrated");
    }
    
    // =========================================================================
    // SECTION 9: DOWNLOAD FILE FROM INTERNET
    // =========================================================================
    
    private static void demonstrateFileDownload() {
        System.out.println("\n📌 Download File from Internet");
        
        String fileUrl = "https://httpbin.org/bytes/1024"; // 1KB test file
        String savePath = "downloaded_file.bin";
        
        try {
            // Method 1: Open connection
            System.out.println("\n1. Opening connection to: " + fileUrl);
            URL url = new URL(fileUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            
            // Method 2: Set up connection
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(5000);
            conn.setReadTimeout(5000);
            
            // Method 3: Check response code
            int responseCode = conn.getResponseCode();
            System.out.println("   Response code: " + responseCode);
            
            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Method 4: Get content length
                int fileSize = conn.getContentLength();
                System.out.println("   File size: " + fileSize + " bytes");
                
                // Method 5: Get content type
                String contentType = conn.getContentType();
                System.out.println("   Content type: " + contentType);
                
                // Method 6: Download file
                System.out.println("\n2. Downloading file...");
                try (InputStream in = conn.getInputStream();
                     FileOutputStream out = new FileOutputStream(savePath)) {
                    
                    byte[] buffer = new byte[4096];
                    int bytesRead;
                    int totalBytes = 0;
                    
                    while ((bytesRead = in.read(buffer)) != -1) {
                        out.write(buffer, 0, bytesRead);
                        totalBytes += bytesRead;
                        
                        // Show progress
                        if (fileSize > 0) {
                            int percent = (totalBytes * 100) / fileSize;
                            System.out.print("\r   Progress: " + percent + "%");
                        }
                    }
                    System.out.println("\n   Download complete!");
                    System.out.println("   Total bytes downloaded: " + totalBytes);
                }
                
                // Method 7: Verify downloaded file
                File downloadedFile = new File(savePath);
                System.out.println("\n3. Downloaded file info:");
                System.out.println("   File exists: " + downloadedFile.exists());
                System.out.println("   File size: " + downloadedFile.length() + " bytes");
                System.out.println("   Saved to: " + downloadedFile.getAbsolutePath());
                
            } else {
                System.out.println("   Server returned: " + responseCode);
            }
            
            // Method 8: Disconnect
            conn.disconnect();
            
            // Clean up - delete downloaded file
            Files.delete(Paths.get(savePath));
            System.out.println("\n   Cleaned up downloaded file");
            
        } catch (MalformedURLException e) {
            System.out.println("   Malformed URL: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("   Download error: " + e.getMessage());
        }
        
        System.out.println("\n   ✅ File download demonstrated");
    }
    
    // =========================================================================
    // SECTION 10: NETWORK UTILITIES
    // =========================================================================
    
    private static void demonstrateNetworkUtilities() {
        System.out.println("\n📌 Network Utilities");
        
        try {
            // Method 1: NetworkInterface enumeration
            System.out.println("\n1. Network Interfaces:");
            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
            while (interfaces.hasMoreElements()) {
                NetworkInterface ni = interfaces.nextElement();
                System.out.println("   - " + ni.getName() + ": " + ni.getDisplayName());
                
                // Method 2: Get interface addresses
                Enumeration<InetAddress> addresses = ni.getInetAddresses();
                while (addresses.hasMoreElements()) {
                    InetAddress addr = addresses.nextElement();
                    System.out.println("     Address: " + addr.getHostAddress());
                }
                
                // Method 3: Interface properties
                System.out.println("     Up: " + ni.isUp());
                System.out.println("     Loopback: " + ni.isLoopback());
                System.out.println("     Virtual: " + ni.isVirtual());
                System.out.println("     MTU: " + ni.getMTU());
            }
            
            // Method 4: Get by name
            System.out.println("\n2. Get interface by name:");
            NetworkInterface lo = NetworkInterface.getByName("lo");
            if (lo != null) {
                System.out.println("   Loopback interface: " + lo.getDisplayName());
            }
            
            // Method 5: Cookie management
            System.out.println("\n3. Cookie handling:");
            CookieManager cookieManager = new CookieManager();
            CookieHandler.setDefault(cookieManager);
            System.out.println("   Default cookie handler set");
            
            // Method 6: Proxy settings
            System.out.println("\n4. Proxy information:");
            List<Proxy> proxies = ProxySelector.getDefault().select(new URI("http://www.google.com"));
            for (Proxy proxy : proxies) {
                System.out.println("   Proxy type: " + proxy.type());
                System.out.println("   Proxy address: " + proxy.address());
            }
            
            // Method 7: Authenticator (commented)
            System.out.println("\n5. Authenticator (for password-protected sites):");
            System.out.println("   Authenticator.setDefault(new MyAuthenticator());");
            
            // Method 8: Check reachable ports
            System.out.println("\n6. Common ports status:");
            checkPort("localhost", 80);   // HTTP
            checkPort("localhost", 443);  // HTTPS
            checkPort("localhost", 8080); // Common dev port
            checkPort("localhost", 8888); // Our test port
            
            // Method 9: DNS lookup time
            System.out.println("\n7. DNS lookup timing:");
            long start = System.nanoTime();
            InetAddress.getByName("www.google.com");
            long end = System.nanoTime();
            System.out.println("   DNS lookup time: " + (end - start) / 1_000_000 + "ms");
            
            // Method 10: Network bandwidth (simulated)
            System.out.println("\n8. Network speed test (simulated):");
            simulateBandwidth();
            
        } catch (SocketException e) {
            System.out.println("   Socket error: " + e.getMessage());
        } catch (URISyntaxException e) {
            System.out.println("   URI error: " + e.getMessage());
        } catch (UnknownHostException e) {
            System.out.println("   Unknown host: " + e.getMessage());
        }
        
        System.out.println("\n   ✅ Network utilities demonstrated");
    }
    
    private static void checkPort(String host, int port) {
        try (Socket socket = new Socket()) {
            socket.connect(new InetSocketAddress(host, port), 500);
            System.out.println("   Port " + port + ": OPEN");
        } catch (IOException e) {
            System.out.println("   Port " + port + ": CLOSED");
        }
    }
    
    private static void simulateBandwidth() {
        // Simulate bandwidth test
        long dataSize = 10 * 1024 * 1024; // 10 MB
        long startTime = System.currentTimeMillis();
        
        // Simulate data transfer
        try {
            Thread.sleep(100); // Simulate transfer time
        } catch (InterruptedException e) {}
        
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        double bandwidth = (dataSize * 8.0) / (duration * 1000.0); // Mbps
        
        System.out.println("   Simulated bandwidth: " + String.format("%.2f", bandwidth) + " Mbps");
    }
}

/**
 * 📚 BEGINNER'S GUIDE TO JAVA NETWORKING
 * =======================================
 * 
 * 1. KEY CONCEPTS:
 *    - IP Address: Unique identifier for a device on network
 *    - Port: Virtual endpoint for communication (0-65535)
 *    - Protocol: Rules for communication (TCP, UDP, HTTP)
 *    - Socket: Endpoint for sending/receiving data
 * 
 * 2. PROTOCOLS:
 *    ┌──────────┬───────────────┬───────────┬──────────────┐
 *    │ Protocol │ Connection    │ Reliability │ Use Case    │
 *    ├──────────┼───────────────┼───────────┼──────────────┤
 *    │ TCP      │ Connection-   │ Reliable  │ Web, Email,  │
 *    │          │ oriented      │           │ File Transfer│
 *    ├──────────┼───────────────┼───────────┼──────────────┤
 *    │ UDP      │ Connectionless│ Unreliable│ Streaming,   │
 *    │          │               │           │ Gaming, DNS  │
 *    ├──────────┼───────────────┼───────────┼──────────────┤
 *    │ HTTP     │ Request-      │ Reliable  │ Web APIs,    │
 *    │          │ Response      │           │ REST Services│
 *    └──────────┴───────────────┴───────────┴──────────────┘
 * 
 * 3. COMMON CLASSES:
 *    ┌─────────────────┬────────────────────────────────────┐
 *    │ Class           │ Purpose                            │
 *    ├─────────────────┼────────────────────────────────────┤
 *    │ InetAddress     │ Represents IP address              │
 *    │ URL             │ Uniform Resource Locator           │
 *    │ URLConnection   │ Communication with URL             │
 *    │ HttpURLConnection│ HTTP-specific communication       │
 *    │ Socket          │ TCP client socket                  │
 *    │ ServerSocket    │ TCP server socket                  │
 *    │ DatagramSocket  │ UDP socket                         │
 *    │ DatagramPacket  │ UDP data packet                    │
 *    │ NetworkInterface│ Network interface information      │
 *    └─────────────────┴────────────────────────────────────┘
 * 
 * 4. IMPORTANT METHODS:
 *    TCP Server:
 *    - ServerSocket(port): Create server
 *    - accept(): Wait for client
 *    - getInputStream()/getOutputStream(): Communicate
 *    
 *    TCP Client:
 *    - Socket(host, port): Connect to server
 *    - getInputStream()/getOutputStream(): Communicate
 *    
 *    UDP:
 *    - DatagramSocket(port): Create socket
 *    - send(DatagramPacket): Send packet
 *    - receive(DatagramPacket): Receive packet
 *    
 *    HTTP:
 *    - HttpURLConnection: setRequestMethod(), getResponseCode()
 *    - HttpClient (modern): send(), sendAsync()
 * 
 * 5. COMMON PORT NUMBERS:
 *    - 20/21: FTP
 *    - 22: SSH
 *    - 23: Telnet
 *    - 25: SMTP (Email)
 *    - 53: DNS
 *    - 80: HTTP
 *    - 110: POP3
 *    - 123: NTP
 *    - 143: IMAP
 *    - 443: HTTPS
 *    - 3306: MySQL
 *    - 8080: HTTP Alternate
 * 
 * 6. EXCEPTIONS TO HANDLE:
 *    - UnknownHostException: Host not found
 *    - ConnectException: Connection refused
 *    - SocketTimeoutException: Timeout
 *    - BindException: Port already in use
 *    - ProtocolException: Protocol error
 *    - MalformedURLException: Invalid URL
 * 
 * 7. BEST PRACTICES:
 *    ✅ Always close sockets/streams
 *    ✅ Set timeouts to avoid hanging
 *    ✅ Handle exceptions properly
 *    ✅ Use try-with-resources
 *    ✅ Validate input data
 *    ✅ Use appropriate buffer sizes
 *    ✅ Consider threading for multiple clients
 *    ✅ Use modern HTTP Client for HTTP/2
 * 
 * 8. SECURITY CONSIDERATIONS:
 *    ⚠️ Validate all input
 *    ⚠️ Use SSL/TLS for sensitive data
 *    ⚠️ Don't trust client data
 *    ⚠️ Limit connection attempts
 *    ⚠️ Sanitize log outputs
 *    ⚠️ Use secure protocols
 */