package com.wifi.utils;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.Reader;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
@Deprecated
public class MacUtil {
    private static String getMac() {
        String strSubstring;
        LineNumberReader lineNumberReader;
        String line;
        try {
            lineNumberReader = new LineNumberReader(new InputStreamReader(Runtime.getRuntime().exec("cat /sys/class/net/wlan0/address ").getInputStream()));
            line = "";
        } catch (Exception e) {
            e.printStackTrace();
        }
        while (line != null) {
            line = lineNumberReader.readLine();
            if (line != null) {
                strSubstring = line.trim();
                break;
            }
            strSubstring = "";
        }
        strSubstring = "";
        if (strSubstring == null || "".equals(strSubstring)) {
            try {
                strSubstring = loadFileAsString("/sys/class/net/eth0/address").toUpperCase().substring(0, 17);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        if (strSubstring != null && !"".equals(strSubstring)) {
            return strSubstring;
        }
        try {
            return macAddress();
        } catch (Exception unused) {
            return strSubstring;
        }
    }

    public static String getMacAdress(Context context) {
        WifiInfo connectionInfo;
        String str = "";
        try {
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            if (wifiManager == null || (connectionInfo = wifiManager.getConnectionInfo()) == null) {
                return "";
            }
            String macAddress = connectionInfo.getMacAddress();
            if (macAddress == null) {
                macAddress = "";
            }
            try {
                if (!macAddress.equals("02:00:00:00:00:00")) {
                    if (!macAddress.equals("")) {
                        return macAddress;
                    }
                }
                try {
                    return getMac();
                } catch (Exception unused) {
                    return macAddress;
                }
            } catch (Exception unused2) {
                str = macAddress;
            }
        } catch (Exception unused3) {
        }
        return str;
    }

    private static String loadFileAsString(String str) throws Exception {
        FileReader fileReader = new FileReader(str);
        String strLoadReaderAsString = loadReaderAsString(fileReader);
        fileReader.close();
        return strLoadReaderAsString;
    }

    private static String loadReaderAsString(Reader reader) throws Exception {
        StringBuilder sb = new StringBuilder();
        char[] cArr = new char[4096];
        int i = reader.read(cArr);
        while (i >= 0) {
            sb.append(cArr, 0, i);
            i = reader.read(cArr);
        }
        return sb.toString();
    }

    private static String macAddress() throws SocketException {
        Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
        String str = null;
        while (networkInterfaces.hasMoreElements()) {
            NetworkInterface networkInterfaceNextElement = networkInterfaces.nextElement();
            byte[] hardwareAddress = networkInterfaceNextElement.getHardwareAddress();
            if (hardwareAddress != null && hardwareAddress.length != 0) {
                StringBuilder sb = new StringBuilder();
                for (byte b : hardwareAddress) {
                    sb.append(String.format("%02X:", Byte.valueOf(b)));
                }
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
                String string = sb.toString();
                if (networkInterfaceNextElement.getName().equals("wlan0")) {
                    str = string;
                }
                if (networkInterfaceNextElement.getName().equals("eth0")) {
                    str = string;
                }
            }
        }
        return str;
    }
}
