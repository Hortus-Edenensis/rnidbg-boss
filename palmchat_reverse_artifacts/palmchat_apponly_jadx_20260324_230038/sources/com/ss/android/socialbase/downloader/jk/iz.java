package com.ss.android.socialbase.downloader.jk;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Environment;
import android.os.Looper;
import android.os.Process;
import android.os.StatFs;
import android.text.TextUtils;
import android.util.SparseArray;
import com.bytedance.sdk.component.utils.k;
import com.heytap.msp.opos.sv.api.params.ErrorCode;
import com.lantern.auth.app.FunDC;
import com.oplus.tbl.exoplayer2.analytics.AnalyticsListener;
import com.oplus.tblplayer.monitor.sdk.SysPerformanceCollector;
import com.ss.android.socialbase.downloader.depend.pb;
import com.ss.android.socialbase.downloader.depend.qq;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.impls.l;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.InterruptedIOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.net.ConnectException;
import java.net.HttpRetryException;
import java.net.MalformedURLException;
import java.net.NoRouteToHostException;
import java.net.PortUnreachableException;
import java.net.ProtocolException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.net.UnknownServiceException;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import kotlin.UByte;
import okhttp3.internal.http2.StreamResetException;
import org.apache.http.HttpHeaders;
import org.apache.http.entity.mime.MIME;
import org.apache.http.protocol.HTTP;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class iz {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static ConnectivityManager f10617a = null;
    private static Boolean jk = null;
    private static Boolean t = null;
    private static final String u = "iz";
    private static final Pattern nr = Pattern.compile(".*\\d+ *- *(\\d+) */ *\\d+");
    private static String fx = null;
    private static volatile SparseArray<Boolean> b = new SparseArray<>();
    private static volatile SparseArray<List<pb>> pn = new SparseArray<>();
    private static final char[] iz = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static Pattern x = null;
    private static Pattern n = null;

    private static String a() {
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(SysPerformanceCollector.APP_CPU_INFO_ROOT_PATH + Process.myPid() + "/cmdline"), "iso-8859-1"));
        } catch (Throwable unused) {
            bufferedReader = null;
        }
        try {
            StringBuilder sb = new StringBuilder();
            while (true) {
                int i = bufferedReader.read();
                if (i <= 0) {
                    break;
                }
                sb.append((char) i);
            }
            if (com.ss.android.socialbase.downloader.fx.u.u()) {
                com.ss.android.socialbase.downloader.fx.u.nr("Process", "get processName = " + sb.toString());
            }
            String string = sb.toString();
            u(bufferedReader);
            return string;
        } catch (Throwable unused2) {
            u(bufferedReader);
            return null;
        }
    }

    public static boolean b(int i) {
        return i == 206 || i == 200;
    }

    public static boolean fx(int i) {
        return i == 200 || i == 201 || i == 0;
    }

    public static boolean iz(String str) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        String strB = b(com.ss.android.socialbase.downloader.downloader.fx.oa());
        return strB != null && strB.equals(str);
    }

    private static String jk(String str) {
        Matcher matcher;
        if (str == null) {
            return null;
        }
        try {
            if (x == null) {
                x = Pattern.compile("attachment;\\s*filename\\s*=\\s*\"([^\"]*)\"");
            }
            matcher = x.matcher(str);
        } catch (Exception unused) {
        }
        if (matcher.find()) {
            return matcher.group(1);
        }
        if (n == null) {
            n = Pattern.compile("attachment;\\s*filename\\s*=\\s*(.*)");
        }
        Matcher matcher2 = n.matcher(str);
        if (matcher2.find()) {
            return matcher2.group(1);
        }
        return null;
    }

    public static boolean n(Throwable th) {
        if (th == null) {
            return false;
        }
        if (th instanceof BaseException) {
            BaseException baseException = (BaseException) th;
            int errorCode = baseException.getErrorCode();
            if (errorCode == 1006) {
                return true;
            }
            if (errorCode == 1023 || errorCode == 1039 || errorCode == 1040 || errorCode == 1054 || errorCode == 1064) {
                String message = baseException.getMessage();
                return !TextUtils.isEmpty(message) && message.contains("ENOSPC");
            }
        } else if (th instanceof IOException) {
            String strJk = jk(th);
            if (!TextUtils.isEmpty(strJk) && strJk.contains("ENOSPC")) {
                return true;
            }
        }
        return false;
    }

    public static boolean nr(long j) {
        return j == -1;
    }

    public static String pn(String str) {
        if (str != null) {
            try {
                if (str.length() != 0) {
                    MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                    messageDigest.update(str.getBytes("UTF-8"));
                    return u(messageDigest.digest());
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }

    private static boolean t(String str) {
        Thread.currentThread();
        if (!TextUtils.isEmpty(str)) {
            File file = new File(str);
            return file.isDirectory() && file.delete();
        }
        return false;
    }

    public static double u(long j) {
        return j / 1048576.0d;
    }

    public static String x(String str) {
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt <= 31 || cCharAt >= 127) {
                sb.append(String.format("\\u%04x", Integer.valueOf(cCharAt)));
            } else {
                sb.append(cCharAt);
            }
        }
        return sb.toString();
    }

    public static boolean b(DownloadInfo downloadInfo) {
        boolean z = false;
        if (downloadInfo.isDeleteCacheIfCheckFailed() || !TextUtils.isEmpty(downloadInfo.getLastModified())) {
            com.ss.android.socialbase.downloader.fx.u.nr(u, "dcache::curt=" + System.currentTimeMillis() + " expired=" + downloadInfo.getCacheExpiredTime());
            if (System.currentTimeMillis() > downloadInfo.getCacheExpiredTime()) {
                z = true;
            }
        } else {
            com.ss.android.socialbase.downloader.fx.u.nr(u, "dcache::last modify is emtpy, so just return cache");
        }
        com.ss.android.socialbase.downloader.fx.u.nr(u, "cacheExpired::dcache::name=" + downloadInfo.getName() + " expired=" + z);
        return z;
    }

    public static String fx(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return String.format("%s.tp", str);
    }

    public static long nr(com.ss.android.socialbase.downloader.network.x xVar) {
        if (xVar == null) {
            return -1L;
        }
        String strNr = nr(xVar, HttpHeaders.CONTENT_RANGE);
        if (TextUtils.isEmpty(strNr)) {
            return -1L;
        }
        try {
            Matcher matcher = Pattern.compile("bytes (\\d+)-(\\d+)/\\d+").matcher(strNr);
            if (matcher.find()) {
                return (Long.parseLong(matcher.group(2)) - Long.parseLong(matcher.group(1))) + 1;
            }
        } catch (Exception e) {
            com.ss.android.socialbase.downloader.fx.u.b(u, "parse content-length from content-range failed " + e);
        }
        return -1L;
    }

    public static boolean u(int i) {
        return i == 0 || i == 2;
    }

    public static String u(byte[] bArr) {
        if (bArr != null) {
            return u(bArr, 0, bArr.length);
        }
        throw new NullPointerException("bytes is null");
    }

    public static void fx(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        File file = new File(str, str2);
        if (file.exists()) {
            k.nr(u, "deleteFile: " + str + "/" + str2);
            file.delete();
        }
    }

    public static boolean iz(Throwable th) {
        if (th == null) {
            return false;
        }
        String strJk = jk(th);
        return !TextUtils.isEmpty(strJk) && strJk.contains("Requested Range Not Satisfiable");
    }

    public static String u(byte[] bArr, int i, int i2) {
        if (bArr != null) {
            if (i >= 0 && i + i2 <= bArr.length) {
                int i3 = i2 * 2;
                char[] cArr = new char[i3];
                int i4 = 0;
                for (int i5 = 0; i5 < i2; i5++) {
                    int i6 = bArr[i5 + i] & UByte.MAX_VALUE;
                    int i7 = i4 + 1;
                    char[] cArr2 = iz;
                    cArr[i4] = cArr2[i6 >> 4];
                    i4 = i7 + 1;
                    cArr[i7] = cArr2[i6 & 15];
                }
                return new String(cArr, 0, i3);
            }
            throw new IndexOutOfBoundsException();
        }
        throw new NullPointerException("bytes is null");
    }

    public static long iz(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return 0L;
        }
        List<com.ss.android.socialbase.downloader.model.nr> listFx = com.ss.android.socialbase.downloader.downloader.fx.kj().fx(downloadInfo.getId());
        int chunkCount = downloadInfo.getChunkCount();
        boolean z = chunkCount > 1;
        if (!downloadInfo.isBreakpointAvailable()) {
            return 0L;
        }
        if (z) {
            if (listFx == null || chunkCount != listFx.size()) {
                return 0L;
            }
            return nr(listFx);
        }
        return downloadInfo.getCurBytes();
    }

    private static String pn(Context context) {
        if (context == null) {
            return null;
        }
        try {
            int iMyPid = Process.myPid();
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            if (activityManager != null) {
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : activityManager.getRunningAppProcesses()) {
                    if (runningAppProcessInfo.pid == iMyPid) {
                        if (com.ss.android.socialbase.downloader.fx.u.u()) {
                            com.ss.android.socialbase.downloader.fx.u.nr("Process", "processName = " + runningAppProcessInfo.processName);
                        }
                        return runningAppProcessInfo.processName;
                    }
                }
            }
        } catch (Exception unused) {
        }
        return null;
    }

    private static String t() {
        try {
            Method declaredMethod = Class.forName("android.app.ActivityThread", false, Application.class.getClassLoader()).getDeclaredMethod("currentProcessName", new Class[0]);
            declaredMethod.setAccessible(true);
            Object objInvoke = declaredMethod.invoke(null, new Object[0]);
            if (!(objInvoke instanceof String)) {
                return null;
            }
            String str = (String) objInvoke;
            try {
                if (!TextUtils.isEmpty(str) && com.ss.android.socialbase.downloader.fx.u.u()) {
                    com.ss.android.socialbase.downloader.fx.u.nr("Process", "processName = " + str);
                }
            } catch (Throwable unused) {
            }
            return str;
        } catch (Throwable unused2) {
            return null;
        }
    }

    public static long b(String str) throws BaseException {
        try {
            return new StatFs(str).getAvailableBytes();
        } catch (IllegalArgumentException e) {
            throw new BaseException(FunDC.ID_AUTH_1050, e);
        } catch (Throwable th) {
            throw new BaseException(FunDC.ID_AUTH_1052, th);
        }
    }

    public static boolean x(Throwable th) {
        return com.ss.android.socialbase.downloader.downloader.fx.xw().u(th);
    }

    public static File x() {
        String externalStorageState;
        try {
            externalStorageState = Environment.getExternalStorageState();
        } catch (Exception unused) {
            externalStorageState = "";
        }
        if ("mounted".equals(externalStorageState)) {
            return Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        }
        return null;
    }

    public static boolean fx(DownloadInfo downloadInfo) {
        return u(downloadInfo, downloadInfo.isForce(), downloadInfo.getMd5());
    }

    public static boolean n(String str) {
        Context contextOa;
        if (com.ss.android.socialbase.downloader.n.u.fx().nr("save_path_security") > 0 && (contextOa = com.ss.android.socialbase.downloader.downloader.fx.oa()) != null && !TextUtils.isEmpty(str) && !str.startsWith("/data")) {
            if (!str.contains("Android/data/" + contextOa.getPackageName())) {
                return false;
            }
        }
        return true;
    }

    public static boolean a(Throwable th) {
        if (!(th instanceof BaseException)) {
            return false;
        }
        int errorCode = ((BaseException) th).getErrorCode();
        return errorCode == 1055 || errorCode == 1023 || errorCode == 1041 || errorCode == 1022 || errorCode == 1048 || errorCode == 1056 || errorCode == 1057 || errorCode == 1058 || errorCode == 1059 || errorCode == 1060 || errorCode == 1061 || errorCode == 1067 || errorCode == 1049 || errorCode == 1047 || errorCode == 1051 || errorCode == 1004 || errorCode == 1011 || errorCode == 1002 || errorCode == 1013;
    }

    public static boolean fx(String str, String str2, String str3) {
        return u(nr(str, str2, str3));
    }

    public static long nr(String str) {
        if (str == null) {
            return -1L;
        }
        String[] strArrSplit = str.split("/");
        if (strArrSplit.length >= 2) {
            try {
                return Long.parseLong(strArrSplit[1]);
            } catch (NumberFormatException unused) {
                com.ss.android.socialbase.downloader.fx.u.b(u, "parse instance length failed with " + str);
            }
        }
        return -1L;
    }

    public static boolean b(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        return new File(str, str2).exists();
    }

    private static String jk() {
        if (Build.VERSION.SDK_INT < 28) {
            return null;
        }
        try {
            String processName = Application.getProcessName();
            if (!TextUtils.isEmpty(processName) && com.ss.android.socialbase.downloader.fx.u.u()) {
                com.ss.android.socialbase.downloader.fx.u.nr("Process", "processName = " + processName);
            }
            return processName;
        } catch (Exception unused) {
            return null;
        }
    }

    public static boolean fx(com.ss.android.socialbase.downloader.network.x xVar) {
        if (xVar == null) {
            return false;
        }
        return u.u(8) ? HTTP.CHUNK_CODING.equals(xVar.u("Transfer-Encoding")) || u(xVar) == -1 : u(xVar) == -1;
    }

    public static String iz() {
        return u(Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.fx.oa()).getGlobalSaveTempDir(), false);
    }

    public static long a(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        try {
            Matcher matcher = Pattern.compile("max-age=([0-9]+)").matcher(str);
            if (matcher.find()) {
                return Long.parseLong(matcher.group(1));
            }
            return 0L;
        } catch (Throwable unused) {
            return 0L;
        }
    }

    public static boolean pn(Throwable th) {
        if (th == null) {
            return false;
        }
        String strJk = jk(th);
        return !TextUtils.isEmpty(strJk) && strJk.contains("Precondition Failed");
    }

    public static String u(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            try {
                bArr[i] = (byte) (Integer.parseInt(str.substring(i2, i2 + 2), 16) & 255);
            } catch (Exception unused) {
            }
        }
        try {
            return new String(bArr, "utf-8");
        } catch (Exception unused2) {
            return str;
        }
    }

    public static String b(Context context) {
        String str = fx;
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        String strJk = jk();
        fx = strJk;
        if (!TextUtils.isEmpty(strJk)) {
            return fx;
        }
        String strT = t();
        fx = strT;
        if (!TextUtils.isEmpty(strT)) {
            return fx;
        }
        String strPn = pn(context);
        fx = strPn;
        if (!TextUtils.isEmpty(strPn)) {
            return fx;
        }
        String strA = a();
        fx = strA;
        return strA;
    }

    public static boolean n() {
        Context contextOa = com.ss.android.socialbase.downloader.downloader.fx.oa();
        return (contextOa == null || nr(contextOa) || !fx(contextOa)) ? false : true;
    }

    public static String nr(String str, String str2) {
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return null;
        }
        return !TextUtils.isEmpty(str2) ? str2 : str;
    }

    public static boolean fx(Context context) {
        NetworkInfo activeNetworkInfo;
        try {
            ConnectivityManager connectivityManagerU = u(context);
            if (connectivityManagerU == null || (activeNetworkInfo = connectivityManagerU.getActiveNetworkInfo()) == null) {
                return false;
            }
            return activeNetworkInfo.isConnected();
        } catch (Exception unused) {
            return false;
        }
    }

    public static String jk(Throwable th) {
        if (th == null) {
            return "";
        }
        try {
            return th.toString();
        } catch (Throwable unused) {
            return "throwable getMsg error";
        }
    }

    public static com.ss.android.socialbase.downloader.constants.iz pn(int i) {
        com.ss.android.socialbase.downloader.constants.iz izVar = com.ss.android.socialbase.downloader.constants.iz.MAIN;
        com.ss.android.socialbase.downloader.constants.iz izVar2 = com.ss.android.socialbase.downloader.constants.iz.SUB;
        if (i != izVar2.ordinal()) {
            izVar2 = com.ss.android.socialbase.downloader.constants.iz.NOTIFICATION;
            if (i != izVar2.ordinal()) {
                return izVar;
            }
        }
        return izVar2;
    }

    public static long nr(List<com.ss.android.socialbase.downloader.model.nr> list) {
        Iterator<com.ss.android.socialbase.downloader.model.nr> it = list.iterator();
        long jK = 0;
        while (it.hasNext()) {
            jK += it.next().k();
        }
        return jK;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0037  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean fx() {
        Boolean bool = t;
        if (bool != null) {
            return bool.booleanValue();
        }
        String strB = b(com.ss.android.socialbase.downloader.downloader.fx.oa());
        if (strB != null) {
            if (strB.equals(com.ss.android.socialbase.downloader.downloader.fx.oa().getPackageName() + ":downloader")) {
                t = Boolean.TRUE;
            } else {
                t = Boolean.FALSE;
            }
        }
        return t.booleanValue();
    }

    public static void nr(DownloadInfo downloadInfo) {
        com.ss.android.socialbase.downloader.n.u uVarU;
        JSONObject jSONObjectB;
        if (downloadInfo == null || (jSONObjectB = (uVarU = com.ss.android.socialbase.downloader.n.u.u(downloadInfo.getId())).b("download_dir")) == null) {
            return;
        }
        String strOptString = jSONObjectB.optString("ins_desc");
        if (!TextUtils.isEmpty(strOptString)) {
            fx(downloadInfo.getSavePath(), strOptString);
        }
        String title = downloadInfo.getTitle();
        if (TextUtils.isEmpty(title)) {
            title = downloadInfo.getName();
        }
        String strU = u(title, uVarU);
        String savePath = downloadInfo.getSavePath();
        if (TextUtils.isEmpty(strU) || TextUtils.isEmpty(savePath)) {
            return;
        }
        File file = new File(strU);
        for (File file2 = new File(savePath); file != null && file2 != null && file2.isDirectory() && TextUtils.equals(file.getName(), file2.getName()); file2 = file2.getParentFile()) {
            t(file2.getPath());
            file = file.getParentFile();
        }
    }

    public static long pn(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return -1L;
        }
        List<com.ss.android.socialbase.downloader.model.nr> listFx = com.ss.android.socialbase.downloader.downloader.fx.kj().fx(downloadInfo.getId());
        if (downloadInfo.getChunkCount() == 1) {
            return downloadInfo.getCurBytes();
        }
        if (listFx != null && listFx.size() > 1) {
            long jB = b(listFx);
            if (jB >= 0) {
                return jB;
            }
        }
        return 0L;
    }

    public static long u(com.ss.android.socialbase.downloader.network.x xVar) {
        if (xVar == null) {
            return -1L;
        }
        String strNr = nr(xVar, "Content-Length");
        if (TextUtils.isEmpty(strNr) && u.u(1)) {
            return nr(xVar);
        }
        try {
            return Long.parseLong(strNr);
        } catch (NumberFormatException unused) {
            return -1L;
        }
    }

    public static String u(com.ss.android.socialbase.downloader.network.x xVar, String str) {
        String strJk = jk(xVar.u(MIME.CONTENT_DISPOSITION));
        return TextUtils.isEmpty(strJk) ? pn(str) : strJk;
    }

    public static String pn() {
        return u(Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.fx.oa()).getGlobalSaveDir(), true);
    }

    public static boolean fx(Throwable th) {
        if (th == null) {
            return false;
        }
        String strJk = jk(th);
        return !TextUtils.isEmpty(strJk) && strJk.contains("network not available");
    }

    public static String pn(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String strPn = pn(str2);
        return (TextUtils.isEmpty(strPn) || str.contains(strPn)) ? str : new File(str, strPn).getAbsolutePath();
    }

    public static com.ss.android.socialbase.downloader.model.pn u(DownloadInfo downloadInfo, String str, String str2, int i) throws BaseException {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            File file = new File(str, str2);
            boolean zMkdirs = false;
            if (file.exists() && file.isDirectory()) {
                throw new BaseException(AnalyticsListener.EVENT_DRM_SESSION_RELEASED, new IOException(String.format("path is :%s, path is directory:%B:", str, Boolean.valueOf(file.isDirectory()))));
            }
            if (!file.exists()) {
                try {
                    File file2 = new File(str);
                    if (!file2.exists() || !file2.isDirectory()) {
                        if (!file2.exists()) {
                            if (!file2.mkdirs() && !file2.exists()) {
                                if (com.ss.android.socialbase.downloader.n.u.u(downloadInfo).u("opt_mkdir_failed", 0) != 1) {
                                    throw new BaseException(1030, "download savePath directory can not created:" + str);
                                }
                                int i2 = 0;
                                while (!zMkdirs) {
                                    int i3 = i2 + 1;
                                    if (i2 >= 3) {
                                        break;
                                    }
                                    try {
                                        Thread.sleep(10L);
                                        zMkdirs = file2.mkdirs();
                                        i2 = i3;
                                    } catch (InterruptedException unused) {
                                    }
                                }
                                if (!zMkdirs) {
                                    if (b(downloadInfo.getSavePath()) < 16384) {
                                        throw new BaseException(1006, "download savePath directory can not created:" + str);
                                    }
                                    throw new BaseException(1030, "download savePath directory can not created:" + str);
                                }
                            }
                        } else {
                            file2.delete();
                            if (!file2.mkdirs() && !file2.exists()) {
                                throw new BaseException(1031, "download savePath is not directory:path=" + str);
                            }
                            throw new BaseException(1031, "download savePath is not directory:" + str);
                        }
                    }
                    file.createNewFile();
                } catch (IOException e) {
                    throw new BaseException(AnalyticsListener.EVENT_PLAYER_RELEASED, e);
                }
            }
            return new com.ss.android.socialbase.downloader.model.pn(file, i);
        }
        throw new BaseException(1021, new IOException("path must be not empty"));
    }

    public static boolean b() {
        return Looper.getMainLooper() == Looper.myLooper();
    }

    public static boolean fx(BaseException baseException) {
        if (baseException == null) {
            return false;
        }
        if (baseException.getErrorCode() != 1011) {
            return baseException.getCause() != null && (baseException.getCause() instanceof SSLHandshakeException);
        }
        return true;
    }

    public static boolean b(Throwable th) {
        if (th == null) {
            return false;
        }
        String strJk = jk(th);
        return !TextUtils.isEmpty(strJk) && strJk.contains("Exception in connect");
    }

    private static void fx(Throwable th, String str) throws com.ss.android.socialbase.downloader.exception.x {
        com.ss.android.socialbase.downloader.exception.x xVarU = com.ss.android.socialbase.downloader.downloader.fx.xw().u(th, null);
        if (xVarU == null) {
            xVarU = com.ss.android.socialbase.downloader.downloader.fx.xw().u(th.getCause(), null);
        }
        if (xVarU == null) {
            return;
        }
        throw new com.ss.android.socialbase.downloader.exception.x(xVarU.getErrorCode(), nr(xVarU, str)).u(xVarU.u());
    }

    private static long b(List<com.ss.android.socialbase.downloader.model.nr> list) {
        if (list == null || list.isEmpty()) {
            return -1L;
        }
        long jS = -1;
        for (com.ss.android.socialbase.downloader.model.nr nrVar : list) {
            if (nrVar != null && (nrVar.s() <= nrVar.my() || nrVar.my() == 0)) {
                if (jS == -1 || jS > nrVar.s()) {
                    jS = nrVar.s();
                }
            }
        }
        return jS;
    }

    public static long fx(long j) {
        return System.currentTimeMillis() - j;
    }

    public static boolean fx(List<com.ss.android.socialbase.downloader.model.fx> list) {
        if (list == null || list.size() == 0) {
            return false;
        }
        for (com.ss.android.socialbase.downloader.model.fx fxVar : list) {
            if (fxVar != null && !TextUtils.isEmpty(fxVar.u()) && !TextUtils.isEmpty(fxVar.nr()) && "download-tc21-1-15".equals(fxVar.u()) && "download-tc21-1-15".equals(fxVar.nr())) {
                return true;
            }
        }
        return false;
    }

    public static int nr(String str, String str2, String str3) {
        return com.ss.android.u.fx.u(str3, new File(str, str2));
    }

    public static String nr(int i) {
        String str = "ttmd5 check code = " + i + ", ";
        if (i != 99) {
            switch (i) {
                case 0:
                    return str + "md5 match";
                case 1:
                    return str + "md5 not match";
                case 2:
                    return str + "md5 empty";
                case 3:
                    return str + "ttmd5 version not support";
                case 4:
                    return str + "ttmd5 tag parser error";
                case 5:
                    return str + "file not exist";
                case 6:
                    return str + "get file md5 error";
                default:
                    return str;
            }
        }
        return str + ErrorCode.ERROR_MSG_UNKNOWN_ERROR;
    }

    @TargetApi(19)
    private static void nr(File file, File file2, boolean z) throws IOException {
        if (file2.exists() && file2.isDirectory()) {
            throw new IOException("Destination '" + file2 + "' exists but is a directory");
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            FileChannel channel = fileInputStream.getChannel();
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file2);
                try {
                    FileChannel channel2 = fileOutputStream.getChannel();
                    try {
                        long size = channel.size();
                        long j = 0;
                        while (j < size) {
                            long j2 = size - j;
                            long jTransferFrom = channel2.transferFrom(channel, j, j2 > 31457280 ? 31457280L : j2);
                            if (jTransferFrom == 0) {
                                break;
                            } else {
                                j += jTransferFrom;
                            }
                        }
                        if (channel2 != null) {
                            channel2.close();
                        }
                        fileOutputStream.close();
                        channel.close();
                        fileInputStream.close();
                        long length = file.length();
                        long length2 = file2.length();
                        if (length == length2) {
                            if (z) {
                                file2.setLastModified(file.lastModified());
                                return;
                            }
                            return;
                        }
                        throw new IOException("Failed to copy full contents from '" + file + "' to '" + file2 + "' Expected length: " + length + " Actual: " + length2);
                    } finally {
                        try {
                        } finally {
                        }
                    }
                } finally {
                }
            } finally {
            }
        } finally {
        }
    }

    public static List<com.ss.android.socialbase.downloader.model.nr> u(List<com.ss.android.socialbase.downloader.model.nr> list) {
        SparseArray sparseArray = new SparseArray();
        SparseArray sparseArray2 = new SparseArray();
        for (com.ss.android.socialbase.downloader.model.nr nrVar : list) {
            if (nrVar != null) {
                if (nrVar.b()) {
                    sparseArray.put(nrVar.bg(), nrVar);
                    List<com.ss.android.socialbase.downloader.model.nr> list2 = (List) sparseArray2.get(nrVar.bg());
                    if (list2 != null) {
                        Iterator<com.ss.android.socialbase.downloader.model.nr> it = list2.iterator();
                        while (it.hasNext()) {
                            it.next().u(nrVar);
                        }
                        nrVar.u(list2);
                    }
                } else {
                    com.ss.android.socialbase.downloader.model.nr nrVar2 = (com.ss.android.socialbase.downloader.model.nr) sparseArray.get(nrVar.nr());
                    if (nrVar2 != null) {
                        List<com.ss.android.socialbase.downloader.model.nr> listX = nrVar2.x();
                        if (listX == null) {
                            listX = new ArrayList<>();
                            nrVar2.u(listX);
                        }
                        nrVar.u(nrVar2);
                        listX.add(nrVar);
                    } else {
                        List arrayList = (List) sparseArray2.get(nrVar.nr());
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                            sparseArray2.put(nrVar.nr(), arrayList);
                        }
                        arrayList.add(nrVar);
                    }
                }
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (int i = 0; i < sparseArray.size(); i++) {
            arrayList2.add(sparseArray.get(sparseArray.keyAt(i)));
        }
        return arrayList2.isEmpty() ? list : arrayList2;
    }

    public static boolean nr(File file, File file2) throws BaseException {
        String str = u;
        k.nr(str, "moveFile1: src:" + file.getPath() + " dest:" + file2.getPath());
        boolean zRenameTo = file.renameTo(file2);
        if (!zRenameTo) {
            zRenameTo = u(file, file2);
            try {
                k.nr(str, "moveFile2: src:" + file.getPath() + " dest:" + file2.getPath());
                file.delete();
            } catch (Throwable unused) {
            }
        }
        return zRenameTo;
    }

    public static boolean nr(Context context) {
        NetworkInfo activeNetworkInfo;
        try {
            ConnectivityManager connectivityManagerU = u(context);
            if (connectivityManagerU != null && (activeNetworkInfo = connectivityManagerU.getActiveNetworkInfo()) != null && activeNetworkInfo.isAvailable()) {
                if (1 == activeNetworkInfo.getType()) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public static String u(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        return String.format("%s%s%s", str, File.separator, str2);
    }

    public static String u(String str, String str2, String str3) {
        String strU;
        if ((TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) || TextUtils.isEmpty(str3)) {
            return null;
        }
        if (!TextUtils.isEmpty(str2)) {
            strU = u(str2, str3);
        } else {
            strU = u(str, str3);
        }
        if (TextUtils.isEmpty(strU)) {
            return null;
        }
        return String.format("%s.tp", strU);
    }

    public static boolean nr() {
        return !fx() && com.ss.android.socialbase.downloader.downloader.fx.fx() && l.u(true).x();
    }

    public static boolean nr(Throwable th) {
        if (th == null) {
            return false;
        }
        String strJk = jk(th);
        if (!(th instanceof com.ss.android.socialbase.downloader.exception.nr) || (((com.ss.android.socialbase.downloader.exception.nr) th).u() != 403 && (TextUtils.isEmpty(strJk) || !strJk.contains("403")))) {
            return !TextUtils.isEmpty(strJk) && strJk.contains("Forbidden");
        }
        return true;
    }

    public static void u(DownloadInfo downloadInfo) {
        u(downloadInfo, true);
    }

    public static boolean nr(BaseException baseException) {
        if (!(baseException instanceof com.ss.android.socialbase.downloader.exception.nr)) {
            return false;
        }
        com.ss.android.socialbase.downloader.exception.nr nrVar = (com.ss.android.socialbase.downloader.exception.nr) baseException;
        return nrVar.u() == 412 || nrVar.u() == 416;
    }

    public static void u(DownloadInfo downloadInfo, boolean z) {
        if (downloadInfo == null) {
            return;
        }
        if (z) {
            try {
                fx(downloadInfo.getSavePath(), downloadInfo.getName());
            } catch (Throwable unused) {
                return;
            }
        }
        fx(downloadInfo.getTempPath(), downloadInfo.getTempName());
        if (downloadInfo.isSavePathRedirected()) {
            nr(downloadInfo);
        }
        if (z) {
            String strPn = pn(downloadInfo.getUrl());
            if (TextUtils.isEmpty(strPn) || TextUtils.isEmpty(downloadInfo.getSavePath()) || !downloadInfo.getSavePath().contains(strPn)) {
                return;
            }
            t(downloadInfo.getSavePath());
        }
    }

    public static String nr(Throwable th, String str) {
        if (str == null) {
            return jk(th);
        }
        return str + "-" + jk(th);
    }

    public static void nr(List<com.ss.android.socialbase.downloader.model.fx> list, DownloadInfo downloadInfo) {
        long ttnetProtectTimeout = downloadInfo.getTtnetProtectTimeout();
        if (ttnetProtectTimeout > 300) {
            list.add(new com.ss.android.socialbase.downloader.model.fx("extra_ttnet_protect_timeout", String.valueOf(ttnetProtectTimeout)));
        }
    }

    public static String nr(com.ss.android.socialbase.downloader.network.x xVar, String str) {
        if (xVar == null || TextUtils.isEmpty(str)) {
            return null;
        }
        String strU = xVar.u(str);
        if (!com.ss.android.socialbase.downloader.n.u.fx().nr("fix_get_http_resp_head_ignore_case", true)) {
            return strU;
        }
        if (TextUtils.isEmpty(strU)) {
            strU = xVar.u(str.toLowerCase());
        }
        return TextUtils.isEmpty(strU) ? xVar.u(str.toUpperCase()) : strU;
    }

    public static boolean u(Context context, String str) {
        return (context == null || TextUtils.isEmpty(str) || context.checkCallingOrSelfPermission(str) != 0) ? false : true;
    }

    public static boolean u(DownloadInfo downloadInfo, boolean z, String str) {
        if (!z && !TextUtils.isEmpty(downloadInfo.getSavePath()) && !TextUtils.isEmpty(downloadInfo.getName())) {
            try {
                if (new File(downloadInfo.getSavePath(), downloadInfo.getName()).exists()) {
                    if (fx(downloadInfo.getSavePath(), downloadInfo.getName(), str)) {
                        return true;
                    }
                }
            } catch (OutOfMemoryError unused) {
            }
        }
        return false;
    }

    public static boolean nr(BaseException baseException, DownloadInfo downloadInfo) {
        return downloadInfo != null && downloadInfo.isOnlyWifi() && fx(com.ss.android.socialbase.downloader.downloader.fx.oa());
    }

    public static int u(File file, String str) {
        return com.ss.android.u.fx.u(str, file);
    }

    public static void u(DownloadInfo downloadInfo, qq qqVar, pb pbVar) {
        boolean z;
        BaseException baseException;
        boolean z2;
        String str = u;
        com.ss.android.socialbase.downloader.fx.u.nr(str, "saveFileAsTargetName targetName is " + downloadInfo.getTargetFilePath());
        try {
            synchronized (b) {
                Boolean bool = b.get(downloadInfo.getId());
                Boolean bool2 = Boolean.TRUE;
                if (bool == bool2) {
                    com.ss.android.socialbase.downloader.fx.u.nr(str, "has another same task is saving temp file");
                    if (pbVar != null) {
                        List<pb> arrayList = pn.get(downloadInfo.getId());
                        if (arrayList == null) {
                            arrayList = new ArrayList<>();
                            pn.put(downloadInfo.getId(), arrayList);
                        }
                        arrayList.add(pbVar);
                    }
                    return;
                }
                com.ss.android.socialbase.downloader.fx.u.nr(str, "saveTempFileStatusMap put id:" + downloadInfo.getId());
                b.put(downloadInfo.getId(), bool2);
                File file = new File(downloadInfo.getTempPath(), downloadInfo.getTempName());
                File file2 = new File(downloadInfo.getSavePath(), downloadInfo.getName());
                boolean zN = n(downloadInfo.getSavePath());
                if (file2.exists()) {
                    com.ss.android.socialbase.downloader.fx.u.nr(str, "targetFile exist");
                    int iU = u(file2, downloadInfo.getMd5());
                    if (u(iU)) {
                        com.ss.android.socialbase.downloader.fx.u.nr(str, "tempFile not exist , targetFile exists and md5 check valid");
                        downloadInfo.setTTMd5CheckStatus(iU);
                        if (pbVar != null) {
                            pbVar.u();
                        }
                        u(downloadInfo.getId(), true, (BaseException) null);
                    } else {
                        if (file.exists()) {
                            z = true;
                        } else {
                            BaseException baseException2 = new BaseException(1005, String.format("Can't save the temp downloaded file(%s/%s) to the target file(%s/%s) because tempFile is not exist and target file is exist but md5 verify invalid :%s", downloadInfo.getTempPath(), downloadInfo.getTempName(), downloadInfo.getSavePath(), downloadInfo.getName(), nr(iU)));
                            if (pbVar != null) {
                                pbVar.u(baseException2);
                            }
                            u(downloadInfo.getId(), false, baseException2);
                            z = false;
                        }
                        if (zN && !file2.delete()) {
                            if (z) {
                                BaseException baseException3 = new BaseException(AnalyticsListener.EVENT_VIDEO_STUCKED, "delete targetPath file existed with md5 check invalid status:" + nr(iU));
                                if (pbVar != null) {
                                    pbVar.u(baseException3);
                                }
                                u(downloadInfo.getId(), false, baseException3);
                            } else if (qqVar != null) {
                                com.ss.android.socialbase.downloader.b.u.u(qqVar, downloadInfo, new BaseException(1038, "tempFile is not exist and target file is exist but md5 verify invalid, delete target file failed"), downloadInfo.getStatus());
                            }
                        }
                    }
                    z = false;
                } else if (file.exists()) {
                    z = true;
                } else {
                    BaseException baseException4 = new BaseException(1005, String.format("Can't save the temp downloaded file(%s/%s) to the target file(%s/%s) because tempFile is not exist", downloadInfo.getTempPath(), downloadInfo.getTempName(), downloadInfo.getSavePath(), downloadInfo.getName()));
                    if (pbVar != null) {
                        pbVar.u(baseException4);
                    }
                    u(downloadInfo.getId(), false, baseException4);
                    z = false;
                }
                if (z) {
                    try {
                        int iU2 = com.ss.android.socialbase.downloader.n.u.u(downloadInfo.getId()).u("download_finish_check_ttmd5", 2);
                        if (iU2 > 0) {
                            int iU3 = u(file, downloadInfo.getMd5());
                            downloadInfo.setTTMd5CheckStatus(iU3);
                            if (iU2 >= 2 && !u(iU3)) {
                                BaseException baseException5 = new BaseException(1034, nr(iU3));
                                if (pbVar != null) {
                                    pbVar.u(baseException5);
                                }
                                u(downloadInfo.getId(), false, baseException5);
                                u(downloadInfo, zN);
                                return;
                            }
                        }
                        z2 = !nr(file, file2);
                        baseException = null;
                    } catch (BaseException e) {
                        if (com.ss.android.socialbase.downloader.n.u.u(downloadInfo.getId()).u("fix_file_rename_failed")) {
                            baseException = e;
                            z2 = true;
                        } else {
                            baseException = e;
                            z2 = false;
                        }
                    }
                    if (z2) {
                        if (baseException == null) {
                            baseException = new BaseException(1038, String.format("Can't save the temp downloaded file(%s/%s) to the target file(%s/%s)", downloadInfo.getTempPath(), downloadInfo.getTempName(), downloadInfo.getSavePath(), downloadInfo.getName()));
                        }
                        if (pbVar != null) {
                            pbVar.u(baseException);
                        }
                        u(downloadInfo.getId(), false, baseException);
                        return;
                    }
                    if (pbVar != null) {
                        pbVar.u();
                    }
                    u(downloadInfo.getId(), true, (BaseException) null);
                }
            }
        } catch (Throwable th) {
            com.ss.android.socialbase.downloader.fx.u.nr(u, "saveFileAsTargetName throwable " + th.getMessage());
            if (pbVar != null) {
                pbVar.u(new BaseException(1038, nr(th, "saveFileAsTargetName")));
            }
        }
    }

    private static void u(int i, boolean z, BaseException baseException) {
        synchronized (b) {
            List<pb> list = pn.get(i);
            if (list != null) {
                for (pb pbVar : list) {
                    if (pbVar != null) {
                        if (z) {
                            pbVar.u();
                        } else {
                            pbVar.u(baseException);
                        }
                    }
                }
            }
            com.ss.android.socialbase.downloader.fx.u.nr(u, "handleTempSaveCallback id:" + i);
            b.remove(i);
        }
    }

    public static void u(DownloadInfo downloadInfo, String str) throws BaseException {
        if (downloadInfo == null || TextUtils.isEmpty(str) || str.equals(downloadInfo.getName())) {
            return;
        }
        File file = new File(downloadInfo.getSavePath(), str);
        File file2 = new File(downloadInfo.getSavePath(), downloadInfo.getName());
        k.nr(u, "copyFileFromExistFileWithSameName: existFile:" + file.getPath() + " targetFile:" + file2.getPath());
        if (file2.exists() && !file2.canWrite()) {
            throw new BaseException(1001, "targetPath file exists but read-only");
        }
        if (!u(file, file2)) {
            throw new BaseException(1001, String.format("Can't copy the exist file(%s/%s) to the target file(%s/%s)", downloadInfo.getSavePath(), str, downloadInfo.getSavePath(), downloadInfo.getName()));
        }
    }

    public static boolean u(File file, File file2) throws BaseException {
        return u(file, file2, true);
    }

    public static boolean u(File file, File file2, boolean z) throws BaseException {
        if (file != null && file2 != null) {
            try {
                if (file.exists() && !file.isDirectory() && !file.getCanonicalPath().equals(file2.getCanonicalPath())) {
                    File parentFile = file2.getParentFile();
                    if (parentFile != null && !parentFile.mkdirs() && !parentFile.isDirectory()) {
                        throw new BaseException(FunDC.ID_AUTH_1053, "Destination '" + parentFile + "' directory cannot be created");
                    }
                    k.nr(u, "copyFile: srcFile:" + file.getPath() + " destFile:" + file2.getPath());
                    if (file2.exists() && !file2.canWrite()) {
                        throw new IOException("Destination '" + file2 + "' exists but is read-only");
                    }
                    nr(file, file2, z);
                    return true;
                }
            } catch (BaseException e) {
                throw e;
            } catch (Throwable th) {
                u(th, "CopyFile");
                return false;
            }
        }
        return false;
    }

    public static boolean u(int i, String str) {
        if (u.u(16777216)) {
            return i == 206 || i == 1;
        }
        if (i >= 400) {
            return false;
        }
        return i == 206 || i == 1 || "bytes".equals(str);
    }

    public static List<com.ss.android.socialbase.downloader.model.fx> u(List<com.ss.android.socialbase.downloader.model.fx> list, String str, com.ss.android.socialbase.downloader.model.nr nrVar) {
        return u(list, str, nrVar.mv(), nrVar.my());
    }

    public static List<com.ss.android.socialbase.downloader.model.fx> u(List<com.ss.android.socialbase.downloader.model.fx> list, String str, long j, long j2) {
        ArrayList arrayList = new ArrayList();
        if (list != null && list.size() > 0) {
            for (com.ss.android.socialbase.downloader.model.fx fxVar : list) {
                if (fxVar != null) {
                    arrayList.add(fxVar);
                }
            }
        }
        if (!TextUtils.isEmpty(str)) {
            arrayList.add(new com.ss.android.socialbase.downloader.model.fx(HttpHeaders.IF_MATCH, str));
        }
        arrayList.add(new com.ss.android.socialbase.downloader.model.fx(HttpHeaders.ACCEPT_ENCODING, HTTP.IDENTITY_CODING));
        String str2 = j2 <= 0 ? String.format("bytes=%s-", String.valueOf(j)) : String.format("bytes=%s-%s", String.valueOf(j), String.valueOf(j2));
        arrayList.add(new com.ss.android.socialbase.downloader.model.fx(HttpHeaders.RANGE, str2));
        com.ss.android.socialbase.downloader.fx.u.nr(u, " range CurrentOffset:" + j + " EndOffset:" + j2 + ", range = " + str2);
        return arrayList;
    }

    public static boolean u(int i, String str, String str2) {
        return i == -3 && !b(str, str2);
    }

    public static ConnectivityManager u(Context context) {
        ConnectivityManager connectivityManager = f10617a;
        if (connectivityManager != null) {
            return connectivityManager;
        }
        ConnectivityManager connectivityManager2 = (ConnectivityManager) context.getSystemService("connectivity");
        f10617a = connectivityManager2;
        return connectivityManager2;
    }

    public static boolean u() {
        Boolean bool = jk;
        if (bool != null) {
            return bool.booleanValue();
        }
        String strB = b(com.ss.android.socialbase.downloader.downloader.fx.oa());
        Boolean boolValueOf = Boolean.valueOf((strB == null || !strB.contains(":")) && strB != null && strB.equals(com.ss.android.socialbase.downloader.downloader.fx.oa().getPackageName()));
        jk = boolValueOf;
        return boolValueOf.booleanValue();
    }

    public static boolean u(Throwable th) {
        if (th == null) {
            return false;
        }
        String strJk = jk(th);
        if (th instanceof SocketTimeoutException) {
            return true;
        }
        return !TextUtils.isEmpty(strJk) && (strJk.contains("time out") || strJk.contains("Time-out"));
    }

    public static boolean u(BaseException baseException) {
        return baseException != null && baseException.getErrorCode() == 1051;
    }

    public static void u(Throwable th, String str) throws BaseException {
        String str2 = !TextUtils.isEmpty(str) ? str : "";
        if (!(th instanceof BaseException)) {
            if (!(th instanceof SSLHandshakeException)) {
                if (!u(th)) {
                    if (!pn(th)) {
                        if (!iz(th)) {
                            if (!nr(th)) {
                                if (!fx(th)) {
                                    if (!b(th)) {
                                        if (th instanceof IOException) {
                                            fx(th, str);
                                            u((IOException) th, str);
                                            return;
                                        }
                                        throw new BaseException(1000, nr(th, str2));
                                    }
                                    throw new BaseException(FunDC.ID_AUTH_1041, nr(th, str2));
                                }
                                throw new BaseException(FunDC.ID_AUTH_1049, nr(th, str2));
                            }
                            throw new BaseException(FunDC.ID_AUTH_1047, nr(th, str2));
                        }
                        throw new com.ss.android.socialbase.downloader.exception.nr(1004, 416, nr(th, str2));
                    }
                    throw new com.ss.android.socialbase.downloader.exception.nr(1004, 412, nr(th, str2));
                }
                throw new BaseException(FunDC.ID_AUTH_1048, nr(th, str2));
            }
            throw new BaseException(1011, nr(th, str2));
        }
        BaseException baseException = (BaseException) th;
        baseException.setErrorMsg(str2 + "-" + baseException.getErrorMessage());
        throw baseException;
    }

    public static void u(IOException iOException, String str) throws BaseException {
        if (str == null) {
            str = "";
        }
        String strNr = nr(iOException, str);
        if (!(iOException instanceof ConnectException)) {
            if (!(iOException instanceof UnknownHostException)) {
                if (!(iOException instanceof NoRouteToHostException)) {
                    if (!(iOException instanceof UnknownServiceException)) {
                        if (!(iOException instanceof PortUnreachableException)) {
                            if (!(iOException instanceof SocketTimeoutException)) {
                                if (!(iOException instanceof SocketException)) {
                                    if (!(iOException instanceof HttpRetryException)) {
                                        if (!(iOException instanceof ProtocolException)) {
                                            if (!(iOException instanceof MalformedURLException)) {
                                                if (!(iOException instanceof FileNotFoundException)) {
                                                    if (!(iOException instanceof InterruptedIOException)) {
                                                        if (!(iOException instanceof UnsupportedEncodingException)) {
                                                            if (!(iOException instanceof EOFException)) {
                                                                if (!(iOException instanceof StreamResetException)) {
                                                                    if (!(iOException instanceof SSLException)) {
                                                                        if (n(iOException)) {
                                                                            throw new BaseException(1006, strNr);
                                                                        }
                                                                        throw new BaseException(1023, strNr);
                                                                    }
                                                                    throw new BaseException(1011, strNr);
                                                                }
                                                                throw new BaseException(FunDC.ID_AUTH_1067, strNr);
                                                            }
                                                            throw new BaseException(FunDC.ID_AUTH_1066, strNr);
                                                        }
                                                        throw new BaseException(FunDC.ID_AUTH_1065, strNr);
                                                    }
                                                    throw new BaseException(FunDC.ID_AUTH_1064, strNr);
                                                }
                                                throw new BaseException(FunDC.ID_AUTH_1063, strNr);
                                            }
                                            throw new BaseException(FunDC.ID_AUTH_1062, strNr);
                                        }
                                        throw new BaseException(FunDC.ID_AUTH_1061, strNr);
                                    }
                                    throw new BaseException(FunDC.ID_AUTH_1060, strNr);
                                }
                                throw new BaseException(FunDC.ID_AUTH_1059, strNr);
                            }
                            throw new BaseException(FunDC.ID_AUTH_1048, strNr);
                        }
                        throw new BaseException(FunDC.ID_AUTH_1058, strNr);
                    }
                    throw new BaseException(FunDC.ID_AUTH_1057, strNr);
                }
                throw new BaseException(FunDC.ID_AUTH_1056, strNr);
            }
            throw new BaseException(FunDC.ID_AUTH_1055, strNr);
        }
        throw new BaseException(FunDC.ID_AUTH_1041, strNr);
    }

    public static boolean u(BaseException baseException, DownloadInfo downloadInfo) {
        if (baseException == null) {
            return false;
        }
        int errorCode = baseException.getErrorCode();
        if (errorCode == 1000 || errorCode == 1032 || errorCode == 1033 || errorCode == 1034 || errorCode == 1008 || errorCode == 1026 || errorCode == 1027 || errorCode == 1044 || errorCode == 1020) {
            return true;
        }
        return (errorCode == 1049 || errorCode == 1055 || errorCode == 1006 || downloadInfo == null || downloadInfo.getCurBytes() >= 8388608) ? false : true;
    }

    public static <K> HashMap<Integer, K> u(SparseArray<K> sparseArray) {
        if (sparseArray == null) {
            return null;
        }
        HashMap<Integer, K> map = new HashMap<>();
        int size = sparseArray.size();
        for (int i = 0; i < size; i++) {
            int iKeyAt = sparseArray.keyAt(i);
            map.put(Integer.valueOf(iKeyAt), sparseArray.valueAt(i));
        }
        return map;
    }

    public static <K> void u(SparseArray<K> sparseArray, Map<Integer, K> map) {
        if (map == null || sparseArray == null) {
            return;
        }
        for (Integer num : map.keySet()) {
            if (num != null) {
                sparseArray.put(num.intValue(), map.get(num));
            }
        }
    }

    public static boolean u(List<com.ss.android.socialbase.downloader.model.fx> list, List<com.ss.android.socialbase.downloader.model.fx> list2) {
        if (list == list2) {
            return true;
        }
        if (list == null || list2 == null || list.size() != list2.size()) {
            return false;
        }
        return new HashSet(list).equals(new HashSet(list2));
    }

    public static void u(Closeable... closeableArr) {
        if (closeableArr == null) {
            return;
        }
        for (Closeable closeable : closeableArr) {
            if (closeable != null) {
                try {
                    closeable.close();
                } catch (Throwable unused) {
                }
            }
        }
    }

    public static void u(Cursor... cursorArr) {
        if (cursorArr == null) {
            return;
        }
        for (Cursor cursor : cursorArr) {
            if (cursor != null) {
                try {
                    cursor.close();
                } catch (Throwable unused) {
                }
            }
        }
    }

    public static String u(String str, int i) {
        return i == 0 ? "" : (TextUtils.isEmpty(str) || str.length() <= i) ? str : str.substring(0, i);
    }

    public static String u(String str, com.ss.android.socialbase.downloader.n.u uVar) {
        JSONObject jSONObjectB;
        String str2;
        if (uVar == null || (jSONObjectB = uVar.b("download_dir")) == null) {
            return "";
        }
        String strOptString = jSONObjectB.optString("dir_name");
        if (!TextUtils.isEmpty(strOptString) && strOptString.startsWith("/")) {
            strOptString = strOptString.substring(1);
        }
        if (TextUtils.isEmpty(strOptString)) {
            return strOptString;
        }
        if (!strOptString.contains("%s")) {
            str2 = strOptString + str;
        } else {
            try {
                str2 = String.format(strOptString, str);
            } catch (Throwable unused) {
            }
        }
        strOptString = str2;
        return strOptString.length() > 255 ? strOptString.substring(strOptString.length() - 255) : strOptString;
    }

    private static String u(File file, boolean z) {
        Context contextOa = com.ss.android.socialbase.downloader.downloader.fx.oa();
        if (u(file)) {
            return file.getAbsolutePath();
        }
        int i = contextOa.getApplicationInfo().targetSdkVersion;
        if (Build.VERSION.SDK_INT >= 29 && ((i == 29 && !Environment.isExternalStorageLegacy()) || i > 29)) {
            if (com.ss.android.socialbase.downloader.n.u.fx().nr("fix_save_external_dir") <= 0) {
                File fileU = com.bytedance.sdk.openadsdk.api.plugin.nr.u(contextOa, Environment.DIRECTORY_DOWNLOADS);
                if (u(fileU)) {
                    return fileU.getAbsolutePath();
                }
            }
        } else {
            if (z) {
                File fileX = x();
                if (u(fileX)) {
                    return fileX.getAbsolutePath();
                }
            }
            if (com.ss.android.socialbase.downloader.n.u.fx().nr("fix_save_external_dir") <= 0) {
                File fileU2 = com.bytedance.sdk.openadsdk.api.plugin.nr.u(contextOa, Environment.DIRECTORY_DOWNLOADS);
                if (u(fileU2)) {
                    return fileU2.getAbsolutePath();
                }
            }
        }
        return com.bytedance.sdk.openadsdk.api.plugin.nr.u(contextOa).getAbsolutePath();
    }

    public static boolean u(File file) {
        if (file == null) {
            return false;
        }
        try {
            if (file.exists() || file.mkdirs()) {
                return file.isDirectory();
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public static void u(List<com.ss.android.socialbase.downloader.model.fx> list, DownloadInfo downloadInfo) {
        long throttleNetSpeed = downloadInfo.getThrottleNetSpeed();
        if (throttleNetSpeed > 0) {
            list.add(new com.ss.android.socialbase.downloader.model.fx("extra_throttle_net_speed", String.valueOf(throttleNetSpeed)));
        }
    }

    public static int u(Object obj, int i) {
        try {
            return ((Integer) obj).intValue();
        } catch (ClassCastException unused) {
            return i;
        }
    }

    public static String u(Object obj, String str) {
        try {
            return (String) obj;
        } catch (ClassCastException unused) {
            return str;
        }
    }

    public static boolean u(Object obj, boolean z) {
        try {
            return ((Boolean) obj).booleanValue();
        } catch (ClassCastException unused) {
            return z;
        }
    }
}
