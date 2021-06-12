package com.example.demo;


import com.example.demo.jmx.SystemStatus;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;

public class Main {
    public static void main(String[] args) {
        try {
//            String programName = (args.length == 0) ? "Java" : args[0];

            // Initialize the object
//            SystemStatus systemStatus = new SystemStatus(programName);
            SystemStatus systemStatus = new SystemStatus();

            // Register the object in the MBeanServer
            MBeanServer platformMBeanServer = ManagementFactory.getPlatformMBeanServer();





            ObjectName objectName = new ObjectName("com.example.demo:name=SystemStatusExample");
            platformMBeanServer.registerMBean(systemStatus, objectName);

            while (true){

            }



        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
