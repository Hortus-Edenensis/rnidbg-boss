package cn.com.chinatelecom.account.api.d;

import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.baidu.platform.comapi.map.MapController;
import com.oplus.tblplayer.Constants;
import com.ss.android.ttvecamera.TELogUtils;
import com.tide.protocol.util.TdFileUtils;
import com.umeng.analytics.pro.dn;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.security.MessageDigest;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.UUID;
import java.util.regex.Pattern;
import okio.Utf8;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f2051a = "cn.com.chinatelecom.account.api.d.d";
    private static String b = "";
    private static final Pattern c = Pattern.compile("^(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)(\\.(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)){3}$");
    private static String d = "";

    public static String a() {
        String string = UUID.randomUUID().toString();
        try {
            string = UUID.nameUUIDFromBytes((string + System.currentTimeMillis() + Math.random()).getBytes("utf8")).toString();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return !TextUtils.isEmpty(string) ? string.replace("-", "") : string;
    }

    private static String b(Context context, String str) {
        try {
            Class<?> clsLoadClass = context.getClassLoader().loadClass(l.a(new byte[]{dn.k, 2, 8, 30, 3, 5, 8, 66, 3, TELogUtils.DEBUG_LEVEL_V, 66, 28, 30, 3, 28, 9, 30, 24, 5, 9, TELogUtils.DEBUG_LEVEL_V}));
            return (String) clsLoadClass.getMethod("get", String.class).invoke(clsLoadClass, str);
        } catch (Exception unused) {
            return "";
        }
    }

    public static boolean c() {
        String strA = l.a(new byte[]{67, TELogUtils.DEBUG_LEVEL_V, 21, TELogUtils.DEBUG_LEVEL_V, 24, 9, 1, 67, dn.l, 5, 2, 67, TELogUtils.DEBUG_LEVEL_V, 25});
        String strA2 = l.a(new byte[]{67, TELogUtils.DEBUG_LEVEL_V, 21, TELogUtils.DEBUG_LEVEL_V, 24, 9, 1, 67, 20, dn.l, 5, 2, 67, TELogUtils.DEBUG_LEVEL_V, 25});
        if (new File(strA).exists() && c(strA)) {
            return true;
        }
        return new File(strA2).exists() && c(strA2);
    }

    public static boolean d() throws SocketException {
        Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
        if (networkInterfaces == null) {
            return false;
        }
        while (networkInterfaces.hasMoreElements()) {
            NetworkInterface networkInterfaceNextElement = networkInterfaces.nextElement();
            if (networkInterfaceNextElement.isUp() && !networkInterfaceNextElement.getInterfaceAddresses().isEmpty()) {
                String strA = l.a(new byte[]{24, 25, 2, 92});
                String strA2 = l.a(new byte[]{28, 28, 28, 92});
                if (strA.equals(networkInterfaceNextElement.getName()) || strA2.equals(networkInterfaceNextElement.getName())) {
                    return true;
                }
            }
        }
        return false;
    }

    private static String e(Context context) {
        return c.b(context, "key_d_i_u", "");
    }

    private static String f(Context context) {
        String strB = b(UUID.randomUUID().toString() + MapController.DEFAULT_LAYER_TAG);
        return TextUtils.isEmpty(strB) ? MapController.DEFAULT_LAYER_TAG : strB;
    }

    private static boolean g(Context context) {
        String strA = l.a(new byte[]{8, 9, 66, 30, 3, dn.l, 26, 66, dn.k, 2, 8, 30, 3, 5, 8, 66, 20, 28, 3, TELogUtils.DEBUG_LEVEL_V, 9, 8, 66, 5, 2, TELogUtils.DEBUG_LEVEL_V, 24, dn.k, 0, 0, 9, 30});
        String strA2 = l.a(new byte[]{15, 3, 1, 66, TELogUtils.DEBUG_LEVEL_V, dn.k, 25, 30, 5, 7, 66, TELogUtils.DEBUG_LEVEL_V, 25, dn.l, TELogUtils.DEBUG_LEVEL_V, 24, 30, dn.k, 24, 9});
        boolean z = context.createPackageContext(strA, 2) != null;
        boolean z2 = context.createPackageContext(strA2, 2) != null;
        return z || z2;
    }

    private static boolean h(Context context) throws Throwable {
        FileReader fileReader;
        Throwable th;
        BufferedReader bufferedReader;
        try {
            String strA = l.a(new byte[]{67, 28, 30, 3, 15, 67});
            String strA2 = l.a(new byte[]{67, 1, dn.k, 28, TELogUtils.DEBUG_LEVEL_V});
            String strA3 = l.a(new byte[]{15, 3, 1, 66, TELogUtils.DEBUG_LEVEL_V, dn.k, 25, 30, 5, 7, 66, TELogUtils.DEBUG_LEVEL_V, 25, dn.l, TELogUtils.DEBUG_LEVEL_V, 24, 30, dn.k, 24, 9});
            String strA4 = l.a(new byte[]{52, 28, 3, TELogUtils.DEBUG_LEVEL_V, 9, 8, 46, 30, 5, 8, 11, 9, 66, 6, dn.k, 30});
            HashSet<String> hashSet = new HashSet();
            fileReader = new FileReader(strA + Process.myPid() + strA2);
            try {
                bufferedReader = new BufferedReader(fileReader);
                while (true) {
                    try {
                        String line = bufferedReader.readLine();
                        if (line == null) {
                            break;
                        }
                        if (line.endsWith(Constants.LIBRARY_SUFFIX) || line.endsWith(TdFileUtils.PLUGIN_FILE_TAIL)) {
                            hashSet.add(line.substring(line.lastIndexOf(" ") + 1));
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                        if (fileReader == null) {
                            throw th;
                        }
                        try {
                            fileReader.close();
                            throw th;
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            throw th;
                        }
                    }
                }
                for (String str : hashSet) {
                    if (str.contains(strA3)) {
                        try {
                            bufferedReader.close();
                        } catch (Exception e3) {
                            e3.printStackTrace();
                        }
                        try {
                            fileReader.close();
                        } catch (Exception e4) {
                            e4.printStackTrace();
                        }
                        return true;
                    }
                    if (str.contains(strA4)) {
                        try {
                            bufferedReader.close();
                        } catch (Exception e5) {
                            e5.printStackTrace();
                        }
                        try {
                            fileReader.close();
                        } catch (Exception e6) {
                            e6.printStackTrace();
                        }
                        return true;
                    }
                }
                try {
                    bufferedReader.close();
                } catch (Exception e7) {
                    e7.printStackTrace();
                }
                try {
                    fileReader.close();
                    return false;
                } catch (Exception e8) {
                    e8.printStackTrace();
                    return false;
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedReader = null;
            }
        } catch (Throwable th4) {
            fileReader = null;
            th = th4;
            bufferedReader = null;
        }
    }

    private static boolean i(Context context) {
        try {
            throw new Exception("we have exception");
        } catch (Exception e) {
            String strA = l.a(new byte[]{15, 3, 1, 66, dn.k, 2, 8, 30, 3, 5, 8, 66, 5, 2, 24, 9, 30, 2, dn.k, 0, 66, 3, TELogUtils.DEBUG_LEVEL_V, 66, 54, 21, 11, 3, 24, 9, 37, 2, 5, 24});
            String strA2 = l.a(new byte[]{8, 9, 66, 30, 3, dn.l, 26, 66, dn.k, 2, 8, 30, 3, 5, 8, 66, 20, 28, 3, TELogUtils.DEBUG_LEVEL_V, 9, 8, 66, 52, 28, 3, TELogUtils.DEBUG_LEVEL_V, 9, 8, 46, 30, 5, 8, 11, 9});
            String strA3 = l.a(new byte[]{8, 9, 66, 30, 3, dn.l, 26, 66, dn.k, 2, 8, 30, 3, 5, 8, 66, 20, 28, 3, TELogUtils.DEBUG_LEVEL_V, 9, 8, 66, 52, 28, 3, TELogUtils.DEBUG_LEVEL_V, 9, 8, 46, 30, 5, 8, 11, 9});
            String strA4 = l.a(new byte[]{5, 2, 26, 3, 7, 9, 8});
            String strA5 = l.a(new byte[]{1, dn.k, 5, 2});
            String strA6 = l.a(new byte[]{4, dn.k, 2, 8, 0, 9, 36, 3, 3, 7, 9, 8, 33, 9, 24, 4, 3, 8});
            String strA7 = l.a(new byte[]{15, 3, 1, 66, TELogUtils.DEBUG_LEVEL_V, dn.k, 25, 30, 5, 7, 66, TELogUtils.DEBUG_LEVEL_V, 25, dn.l, TELogUtils.DEBUG_LEVEL_V, 24, 30, dn.k, 24, 9, 66, 33, Utf8.REPLACEMENT_BYTE, 72, 94});
            int i = 0;
            for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                if (stackTraceElement.getClassName().equals(strA) && (i = i + 1) == 2) {
                    return true;
                }
                if (stackTraceElement.getClassName().equals(strA7) && stackTraceElement.getMethodName().equals(strA4)) {
                    return true;
                }
                if (stackTraceElement.getClassName().equals(strA2) && stackTraceElement.getMethodName().equals(strA5)) {
                    return true;
                }
                if (stackTraceElement.getClassName().equals(strA3) && stackTraceElement.getMethodName().equals(strA6)) {
                    return true;
                }
            }
            return false;
        }
    }

    public static String a(Context context) {
        if (TextUtils.isEmpty(d)) {
            String strE = e(context);
            d = strE;
            if (TextUtils.isEmpty(strE)) {
                String strF = f(context);
                d = strF;
                a(context, strF);
            }
        }
        return d;
    }

    private static String b(String str) {
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            byte[] bytes = str.getBytes();
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(bytes);
            byte[] bArrDigest = messageDigest.digest();
            char[] cArr2 = new char[bArrDigest.length * 2];
            int i = 0;
            for (byte b2 : bArrDigest) {
                int i2 = i + 1;
                cArr2[i] = cArr[(b2 >>> 4) & 15];
                i = i2 + 1;
                cArr2[i2] = cArr[b2 & 15];
            }
            return new String(cArr2);
        } catch (Exception unused) {
            return null;
        }
    }

    public static boolean c(Context context) {
        return g(context) || h(context) || i(context);
    }

    /* JADX WARN: Code restructure failed: missing block: B:65:0x00e7, code lost:
    
        r12 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00e8, code lost:
    
        r12.printStackTrace();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean d(Context context) throws Throwable {
        Throwable th;
        FileReader fileReader;
        String line;
        BufferedReader bufferedReader = null;
        try {
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            String strA = l.a(new byte[]{11, 3, 0, 8, 10, 5, TELogUtils.DEBUG_LEVEL_V, 4});
            String strA2 = l.a(new byte[]{30, 3, 66, 4, dn.k, 30, 8, 27, dn.k, 30, 9});
            String strA3 = l.a(new byte[]{30, 3, 66, 7, 9, 30, 2, 9, 0, 66, 29, 9, 1, 25});
            String strA4 = l.a(new byte[]{11, 9, 2, 9, 30, 5, 15});
            String strA5 = l.a(new byte[]{30, 3, 66, 28, 30, 3, 8, 25, 15, 24, 66, 8, 9, 26, 5, 15, 9});
            if (strA.equals(b(context, strA2)) || "1".equals(b(context, strA3)) || strA4.equals(b(context, strA5))) {
                return true;
            }
            String str = Build.BRAND;
            String str2 = Build.DEVICE;
            String str3 = Build.HARDWARE;
            String str4 = Build.MODEL;
            String str5 = Build.PRODUCT;
            String strA6 = l.a(new byte[]{43, 9, 2, 21, 1, 3, 24, 5, 3, 2});
            String strA7 = l.a(new byte[]{11, 9, 2, 9, 30, 5, 15});
            String strA8 = l.a(new byte[]{TELogUtils.DEBUG_LEVEL_V, 8, 7});
            if (Build.MANUFACTURER.contains(strA6) || str2.startsWith(strA7) || str4.contains(strA8) || str.compareTo(strA7) == 0 || str2.compareTo(strA7) == 0 || str4.compareTo(strA8) == 0 || str5.compareTo(strA8) == 0 || str3.compareTo(strA) == 0) {
                return true;
            }
            String strA9 = l.a(new byte[]{67, 28, 30, 3, 15, 67, 15, 28, 25, 5, 2, 10, 3});
            String strA10 = l.a(new byte[]{43, 3, 0, 8, 10, 5, TELogUtils.DEBUG_LEVEL_V, 4});
            fileReader = new FileReader(strA9);
            try {
                BufferedReader bufferedReader2 = new BufferedReader(fileReader);
                do {
                    try {
                        line = bufferedReader2.readLine();
                        if (line == null) {
                            try {
                                bufferedReader2.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            try {
                                fileReader.close();
                                return false;
                            } catch (IOException e2) {
                                e2.printStackTrace();
                                return false;
                            }
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        bufferedReader = bufferedReader2;
                    }
                } while (!line.contains(strA10));
                bufferedReader2.close();
                try {
                    fileReader.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
                return true;
            } catch (Throwable th4) {
                th = th4;
            }
        } catch (Throwable th5) {
            th = th5;
            fileReader = null;
        }
        if (bufferedReader != null) {
            try {
                bufferedReader.close();
            } catch (IOException e4) {
                e4.printStackTrace();
            }
        }
        if (fileReader == null) {
            throw th;
        }
        try {
            fileReader.close();
            throw th;
        } catch (IOException e5) {
            e5.printStackTrace();
            throw th;
        }
    }

    private static void a(Context context, String str) {
        if (TextUtils.isEmpty(str) || context == null) {
            return;
        }
        c.a(context, "key_d_i_u", str);
    }

    public static StringBuffer b() throws SocketException {
        StringBuffer stringBuffer = new StringBuffer();
        Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
        while (networkInterfaces.hasMoreElements()) {
            NetworkInterface networkInterfaceNextElement = networkInterfaces.nextElement();
            String name = networkInterfaceNextElement.getName();
            if (name == null || (!name.contains("wlan") && !name.equals("eth0"))) {
                Enumeration<InetAddress> inetAddresses = networkInterfaceNextElement.getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress inetAddressNextElement = inetAddresses.nextElement();
                    if (!inetAddressNextElement.isLoopbackAddress() && !inetAddressNextElement.isLinkLocalAddress()) {
                        String hostAddress = inetAddressNextElement.getHostAddress();
                        if (!TextUtils.isEmpty(hostAddress)) {
                            if (stringBuffer.length() > 0) {
                                stringBuffer.append(",");
                            }
                            stringBuffer.append(hostAddress);
                        }
                    }
                }
            }
        }
        return stringBuffer;
    }

    private static boolean c(String str) {
        Process processExec = null;
        try {
            processExec = Runtime.getRuntime().exec("ls -l " + str);
            String line = new BufferedReader(new InputStreamReader(processExec.getInputStream())).readLine();
            if (line != null && line.length() >= 4) {
                char cCharAt = line.charAt(3);
                if (cCharAt == 's' || cCharAt == 'x') {
                    processExec.destroy();
                    return true;
                }
            }
            processExec.destroy();
            return false;
        } catch (Throwable th) {
            if (processExec != null) {
                processExec.destroy();
            }
            throw th;
        }
    }

    public static boolean a(Object obj, String str) throws NoSuchMethodException {
        Method declaredMethod = obj.getClass().getDeclaredMethod(str, new Class[0]);
        declaredMethod.setAccessible(true);
        return ((Boolean) declaredMethod.invoke(obj, new Object[0])).booleanValue();
    }

    public static boolean b(Context context) {
        String strA = l.a(new byte[]{4, 24, 24, 28, 66, 28, 30, 3, 20, 21, 36, 3, TELogUtils.DEBUG_LEVEL_V, 24});
        String strA2 = l.a(new byte[]{4, 24, 24, 28, 66, 28, 30, 3, 20, 21, 60, 3, 30, 24});
        String property = System.getProperty(strA);
        String property2 = System.getProperty(strA2);
        if (property2 == null) {
            property2 = "-1";
        }
        return (TextUtils.isEmpty(property) || Integer.parseInt(property2) == -1) ? false : true;
    }

    public static boolean a(String str) {
        return str != null && c.matcher(str).matches();
    }
}
