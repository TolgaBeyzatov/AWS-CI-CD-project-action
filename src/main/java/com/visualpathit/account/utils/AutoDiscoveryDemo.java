package com.amazon.elasticache;

import java.io.IOException;

public class AutoDiscoveryDemo {

    public static void main(String[] args) throws IOException {
            
        String configEndpoint = System.getenv("MemcachedEndpoint");
        Integer clusterPort = 11211;

        MemcachedClient client = new MemcachedClient(
                                 new InetSocketAddress(configEndpoint, 
                                                       clusterPort));       
        // The client will connect to the other cache nodes automatically.

        // Store a data item for an hour.  
        // The client will decide which cache host will store this item. 
        client.set("theKey", 3600, "This is the data value");
    }
}