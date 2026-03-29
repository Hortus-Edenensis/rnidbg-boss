package com.wifi.adsdk.utils;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.Reader;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class MacUtil {
    private static String macAddress;

    private static String getMac() {
        String strSubstring;
        LineNumberReader lineNumberReader;
        String line;
        String stringValue = BLSettings.getStringValue("bl_mac", "");
        if (!TextUtils.isEmpty(stringValue)) {
            return stringValue;
        }
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
        if (strSubstring == null || "".equals(strSubstring)) {
            try {
                strSubstring = macAddress();
            } catch (Exception unused) {
            }
        }
        if (!TextUtils.isEmpty(strSubstring)) {
            BLSettings.setStringValue("bl_mac", strSubstring);
        }
        return strSubstring;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0034 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String getMacAdress(Context context) {
        String macAddress2;
        WifiManager wifiManager;
        WifiInfo connectionInfo;
        String str = "";
        if (!TextUtils.isEmpty(macAddress)) {
            return macAddress;
        }
        try {
            wifiManager = (WifiManager) context.getSystemService("wifi");
        } catch (Exception unused) {
        }
        if (wifiManager == null || (connectionInfo = wifiManager.getConnectionInfo()) == null) {
            return "";
        }
        macAddress2 = connectionInfo.getMacAddress();
        if (macAddress2 == null) {
            macAddress2 = "";
        }
        try {
            if (!macAddress2.equals("02:00:00:00:00:00")) {
                if (macAddress2.equals("")) {
                    try {
                        macAddress2 = getMac();
                    } catch (Exception unused2) {
                    }
                }
            }
        } catch (Exception unused3) {
            str = macAddress2;
            macAddress2 = str;
        }
        macAddress = macAddress2;
        return macAddress2;
        macAddress2 = str;
        macAddress = macAddress2;
        return macAddress2;
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
