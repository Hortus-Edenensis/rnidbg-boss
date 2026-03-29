package defpackage;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import com.igexin.push.core.b;
import com.umeng.ccg.a;
import com.zenmen.palmchat.AppContext;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class uv1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String[] f21296a = {"15555215554", "15555215556", "15555215558", "15555215560", "15555215562", "15555215564", "15555215566", "15555215568", "15555215570", "15555215572", "15555215574", "15555215576", "15555215578", "15555215580", "15555215582", "15555215584"};
    public static String[] b = {"000000000000000", "e21833235b6eef10", "012345678912345"};
    public static String[] c = {"310260000000000"};
    public static String[] d = {"/dev/socket/qemud", "/dev/qemu_pipe"};
    public static String[] e = {"/system/lib/libc_malloc_debug_qemu.so", "/sys/qemu_trace", "/system/bin/qemu-props"};
    public static String[] f = {"/dev/socket/genyd", "/dev/socket/baseband_genyd"};
    public static String[] g = {"goldfish"};
    public static oo4[] h = {new oo4("init.svc.qemud", null), new oo4("init.svc.qemu-props", null), new oo4("qemu.hw.mainkeys", null), new oo4("qemu.sf.fake_camera", null), new oo4("qemu.sf.lcd_density", null), new oo4("ro.bootloader", "unknown"), new oo4("ro.bootmode", "unknown"), new oo4("ro.hardware", "goldfish"), new oo4("ro.kernel.android.qemud", null), new oo4("ro.kernel.qemu.gles", null), new oo4("ro.kernel.qemu", "1"), new oo4("ro.product.device", "generic"), new oo4("ro.product.model", a.x), new oo4("ro.product.name", a.x), new oo4("ro.serialno", null)};
    public static int i = 5;
    public static boolean j = true;

    public static String a() {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", String.class, String.class).invoke(cls.newInstance(), "gsm.version.baseband", "no message");
        } catch (Exception unused) {
            return "";
        }
    }

    public static String b() {
        for (String str : f) {
            if (new File(str).exists()) {
                return str;
            }
        }
        return b.m;
    }

    public static String c(Context context) {
        WifiInfo connectionInfo;
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            return null;
        }
        if (activeNetworkInfo.getType() != 0) {
            if (activeNetworkInfo.getType() != 1 || (connectionInfo = ((WifiManager) AppContext.getContext().getApplicationContext().getSystemService("wifi")).getConnectionInfo()) == null) {
                return null;
            }
            return k(connectionInfo.getIpAddress());
        }
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress inetAddressNextElement = inetAddresses.nextElement();
                    if (!inetAddressNextElement.isLoopbackAddress() && (inetAddressNextElement instanceof Inet4Address)) {
                        return inetAddressNextElement.getHostAddress();
                    }
                }
            }
            return null;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String d() {
        try {
            String str = Build.DISPLAY;
            return str.contains(Build.VERSION.INCREMENTAL) ? str : Build.VERSION.INCREMENTAL;
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static String e() {
        Process processExec;
        try {
            processExec = Runtime.getRuntime().exec("cat /proc/version");
        } catch (IOException e2) {
            e2.printStackTrace();
            processExec = null;
        }
        if (processExec == null) {
            return "";
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(processExec.getInputStream()), 8192);
        String str = "";
        while (true) {
            try {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                str = str + line;
            } catch (IOException e3) {
                e3.printStackTrace();
            }
        }
        if (str == "") {
            return "";
        }
        try {
            String strSubstring = str.substring(str.indexOf("version ") + 8);
            return strSubstring.substring(0, strSubstring.indexOf(" "));
        } catch (IndexOutOfBoundsException e4) {
            e4.printStackTrace();
            return "";
        }
    }

    public static String f() {
        return ac1.k;
    }

    public static String g() {
        for (String str : d) {
            if (new File(str).exists()) {
                return str;
            }
        }
        return b.m;
    }

    public static String h() {
        for (String str : e) {
            if (new File(str).exists()) {
                return str;
            }
        }
        return b.m;
    }

    public static boolean i() {
        try {
            return tv1.a();
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static boolean j() throws Throwable {
        FileInputStream fileInputStream;
        File[] fileArr = {new File("/proc/tty/drivers"), new File("/proc/cpuinfo")};
        for (int i2 = 0; i2 < 2; i2++) {
            File file = fileArr[i2];
            if (file.exists() && file.canRead()) {
                byte[] bArr = new byte[1024];
                FileInputStream fileInputStream2 = null;
                try {
                    try {
                        fileInputStream = new FileInputStream(file);
                    } catch (Exception e2) {
                        e = e2;
                    }
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    fileInputStream.read(bArr);
                    pu1.u(fileInputStream);
                } catch (Exception e3) {
                    e = e3;
                    fileInputStream2 = fileInputStream;
                    e.printStackTrace();
                    pu1.u(fileInputStream2);
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream2 = fileInputStream;
                    pu1.u(fileInputStream2);
                    throw th;
                }
                String str = new String(bArr);
                for (String str2 : g) {
                    if (str.indexOf(str2) != -1) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static String k(int i2) {
        return (i2 & 255) + "." + ((i2 >> 8) & 255) + "." + ((i2 >> 16) & 255) + "." + ((i2 >> 24) & 255);
    }
}
