package com.demo.other.modbus;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.scheduling.annotation.Async;

import com.intelligt.modbus.jlibmodbus.Modbus;
import com.intelligt.modbus.jlibmodbus.exception.ModbusIOException;
import com.intelligt.modbus.jlibmodbus.exception.ModbusNumberException;
import com.intelligt.modbus.jlibmodbus.exception.ModbusProtocolException;
import com.intelligt.modbus.jlibmodbus.master.ModbusMaster;
import com.intelligt.modbus.jlibmodbus.master.ModbusMasterFactory;
import com.intelligt.modbus.jlibmodbus.tcp.TcpParameters;
import com.serotonin.modbus4j.locator.BaseLocator;

public class TestModbus {

	public static void main(String[] args) {
        try {

        	
        	System.out.println("................");
        	
            // 设置主机TCP参数
            TcpParameters tcpParameters = new TcpParameters();
 
            // 设置TCP的ip地址
            InetAddress adress = InetAddress.getByName("127.0.0.1");
 
            // TCP参数设置ip地址
            // tcpParameters.setHost(InetAddress.getLocalHost());
            tcpParameters.setHost(adress);
 
            // TCP设置长连接
            tcpParameters.setKeepAlive(true);
            // TCP设置端口，这里设置是默认端口502
            tcpParameters.setPort(Modbus.TCP_PORT);
 
            // 创建一个主机
            ModbusMaster master = ModbusMasterFactory.createModbusMasterTCP(tcpParameters);
            Modbus.setAutoIncrementTransactionId(true);
 
            int slaveId = 1;//从机地址
            int offset = 10;//寄存器读取开始地址
            int quantity = 10;//读取的寄存器数量
 
 
            try {
                if (!master.isConnected()) {
                    master.connect();// 开启连接
                }
                
                //master.maskWriteRegister(slaveId, 2, 2, 3);
                // 读取对应从机的数据，readInputRegisters读取的写寄存器，功能码04
                //int[] registerValues = master.readInputRegisters(slaveId, offset, quantity);
 
                // 控制台输出
//                for (int value : registerValues) {
//                    System.out.println("Address: " + offset++ + ", Value: " + value);
//                }
                
                //写操作
//                master.writeSingleRegister(1, 10, 100);//第十位写入了1000
                
                //读取操作
                int[] registerValues = master.readHoldingRegisters(slaveId, offset, quantity);
                for (int value : registerValues) {
                  System.out.println("Address: " + offset++ + ", Value: " + value);
                }
                
//                master.writeSingleRegister(1, 10002, 33);
                
            } catch (ModbusProtocolException e) {
                e.printStackTrace();
            } catch (ModbusNumberException e) {
                e.printStackTrace();
            } catch (ModbusIOException e) {
                e.printStackTrace();
            } finally {
                try {
                    master.disconnect();
                } catch (ModbusIOException e) {
                    e.printStackTrace();
                }
            }
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

	
	
}
