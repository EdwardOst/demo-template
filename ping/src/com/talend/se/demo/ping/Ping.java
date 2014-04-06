package com.talend.se.demo.ping;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Ping {

    public static void main(String[] args) throws UnknownHostException, IOException {
//        ping("127.0.0.1");
//        ping("74.125.228.37");
        ping(args[0]);
    }

    private static byte unsignedByteParse(String s) {
        int i = Integer.parseInt(s);
        return (byte) (i & 0xFF);
    }
    
    private static void ping(String ipAddress) throws UnknownHostException, IOException {
        InetAddress inet;
//        String ip_addr[] = ipAddress.split("\\.");
//        byte ip_addr_byte[] = new byte[] {unsignedByteParse(ip_addr[0]), unsignedByteParse(ip_addr[1]), unsignedByteParse(ip_addr[2]), unsignedByteParse(ip_addr[3])};
//        inet = InetAddress.getByAddress(ip_addr_byte);
        inet = InetAddress.getByName(ipAddress);
        System.out.println("Sending Ping Request to " + ipAddress);
        System.out.println(inet.isReachable(5000) ? "Host is reachable" : "Host is NOT reachable");
    }
}
