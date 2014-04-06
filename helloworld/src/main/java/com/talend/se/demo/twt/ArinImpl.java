package com.talend.se.demo.twt;

import java.util.ArrayList;
import java.util.List;


public class ArinImpl implements Arin {

    @Override
    public WhoIs ping(String ipAddress) {
        WhoIs whoIs = new WhoIs();
        whoIs.ip = ipAddress;
        whoIs.ref = "http://localhost:9091/arin/96.241.55.231";

        whoIs.network = new Network();
        whoIs.network.ref = "http://whois.arin.net/rest/net/NET-96-224-0-0-1/";
        
        List<NetBlock> netblocks = new ArrayList();
        whoIs.network.netblocks = netblocks;

        NetBlock netblock = new NetBlock();
        netblock.pingResults.add(new PingResult("96.224.0.0", "1", "Pinging 96.224.0.0 with 32 bytes of data:Request timed out.Request timed out.Request timed out.Ping statistics for 96.224.0.0:    Packets: Sent = 3, Received = 0, Lost = 3 (100% loss)"));
        netblock.pingResults.add(new PingResult("96.224.0.1", "1", "Pinging 96.224.0.1 with 32 bytes of data:Request timed out.Request timed out.Request timed out.Ping statistics for 96.224.0.1:    Packets: Sent = 3, Received = 0, Lost = 3 (100% loss)"));
        netblock.pingResults.add(new PingResult("96.224.0.2", "0", "Pinging 96.224.0.2 with 32 bytes of data:Reply from 96.224.0.2: bytes=32 time=52ms TTL=56Reply from 96.224.0.2: bytes=32 time=54ms TTL=56Reply from 96.224.0.2: bytes=32 time=55ms TTL=56Ping statistics for 96.224.0.2:    Packets: Sent = 3, Received = 3, Lost = 0 (0% loss),Approximate round trip times in milli-seconds:    Minimum = 52ms, Maximum = 55ms, Average = 53ms"));
        netblocks.add(netblock);

        whoIs.org = new Org("VRIS", "Verizon Online LLC", "http://whois.arin.net/rest/org/VRIS",
                        new Address("Ashburn", "VA", "20147"));
        
        return whoIs;
    }
    
}
