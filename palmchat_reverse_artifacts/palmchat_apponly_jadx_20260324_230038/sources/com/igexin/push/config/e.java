package com.igexin.push.config;

import com.huawei.hms.framework.common.ContainerUtils;
import com.igexin.push.g.j;
import com.umeng.analytics.pro.dn;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f7127a = "FileConfig";

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0055 A[Catch: all -> 0x00d1, Exception -> 0x00e7, TryCatch #15 {Exception -> 0x00e7, all -> 0x00d1, blocks: (B:23:0x0048, B:25:0x0055, B:28:0x007f, B:29:0x0086, B:30:0x0087), top: B:101:0x0048 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00a0 A[Catch: all -> 0x00c1, Exception -> 0x00c6, TryCatch #18 {Exception -> 0x00c6, all -> 0x00c1, blocks: (B:32:0x009a, B:34:0x00a0, B:36:0x00a8), top: B:95:0x009a }] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00b0 A[EDGE_INSN: B:83:0x00b0->B:38:0x00b0 BREAK  A[LOOP:0: B:95:0x009a->B:104:0x009a], EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v19, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v20 */
    /* JADX WARN: Type inference failed for: r0v21 */
    /* JADX WARN: Type inference failed for: r0v22 */
    /* JADX WARN: Type inference failed for: r0v23 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r0v9, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r2v2, types: [android.content.res.AssetManager] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r3v10 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a() {
        ?? r0;
        FileInputStream fileInputStream;
        BufferedReader bufferedReader;
        String line;
        ?? Open = com.igexin.push.core.e.g + ".properties";
        ?? r3 = 0;
        bufferedReader = null;
        bufferedReader = null;
        BufferedReader bufferedReader2 = null;
        BufferedReader bufferedReader3 = null;
        try {
            try {
                Open = com.igexin.push.core.e.l.getResources().getAssets().open(Open);
            } catch (Exception e) {
                com.igexin.c.a.c.a.a(e);
            }
            try {
                a((InputStream) Open);
            } catch (Exception unused) {
                Open = Open;
                if (Open != 0) {
                    Open.close();
                    Open = Open;
                }
                if (!new File(j.f7366a).exists()) {
                }
                fileInputStream = new FileInputStream(j.f7366a);
                try {
                    bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream, "UTF-8"));
                    while (true) {
                        try {
                            line = bufferedReader.readLine();
                            if (line != null) {
                            }
                        } catch (Exception unused2) {
                            bufferedReader2 = bufferedReader;
                            r0 = fileInputStream;
                            if (bufferedReader2 != null) {
                                try {
                                    bufferedReader2.close();
                                } catch (IOException e2) {
                                    com.igexin.c.a.c.a.a(e2);
                                }
                            }
                            if (r0 != 0) {
                                try {
                                    r0.close();
                                    return;
                                } catch (Exception e3) {
                                    com.igexin.c.a.c.a.a(e3);
                                    return;
                                }
                            }
                            return;
                        } catch (Throwable th) {
                            bufferedReader3 = bufferedReader;
                            Open = fileInputStream;
                            th = th;
                            if (bufferedReader3 != null) {
                                try {
                                    bufferedReader3.close();
                                } catch (IOException e4) {
                                    com.igexin.c.a.c.a.a(e4);
                                }
                            }
                            if (Open == 0) {
                                throw th;
                            }
                            try {
                                Open.close();
                                throw th;
                            } catch (Exception e5) {
                                com.igexin.c.a.c.a.a(e5);
                                throw th;
                            }
                        }
                    }
                    bufferedReader.close();
                    try {
                        fileInputStream.close();
                    } catch (Exception e6) {
                        com.igexin.c.a.c.a.a(e6);
                        return;
                    }
                } catch (Exception unused3) {
                } catch (Throwable th2) {
                    th = th2;
                    Open = fileInputStream;
                }
            } catch (Throwable th3) {
                th = th3;
                r3 = Open;
                if (r3 != 0) {
                    try {
                        r3.close();
                    } catch (Exception e7) {
                        com.igexin.c.a.c.a.a(e7);
                    }
                }
                throw th;
            }
        } catch (Exception unused4) {
            Open = 0;
        } catch (Throwable th4) {
            th = th4;
        }
        if (Open != 0) {
            Open.close();
            Open = Open;
        }
        try {
            if (!new File(j.f7366a).exists()) {
                j.f7366a = j.b(com.igexin.push.core.e.l) + com.igexin.push.core.e.g + ".properties";
                if (!new File(j.f7366a).exists()) {
                    throw new RuntimeException("extraConfigPath no exists");
                }
            }
            fileInputStream = new FileInputStream(j.f7366a);
            bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream, "UTF-8"));
            while (true) {
                line = bufferedReader.readLine();
                if (line != null) {
                    try {
                        break;
                    } catch (IOException e8) {
                        com.igexin.c.a.c.a.a(e8);
                    }
                } else if (!line.startsWith("#")) {
                    int length = line.split(ContainerUtils.KEY_VALUE_DELIMITER).length;
                }
            }
            bufferedReader.close();
            fileInputStream.close();
        } catch (Exception unused5) {
            r0 = Open;
        } catch (Throwable th5) {
            th = th5;
        }
    }

    public static int b() {
        try {
            j.l();
            Boolean boolA = com.igexin.push.core.d.c.a().a(com.igexin.push.core.d.c.f7204a);
            int i = boolA == null ? -1 : boolA.booleanValue() ? 1 : 0;
            com.igexin.c.a.c.a.a(f7127a + "|getGuardMeFromFile gm= " + i, new Object[0]);
            return i;
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
            return -1;
        }
    }

    public static int c() {
        try {
            Boolean boolA = com.igexin.push.core.d.c.a().a(com.igexin.push.core.d.c.b);
            int i = boolA == null ? -1 : boolA.booleanValue() ? 1 : 0;
            com.igexin.c.a.c.a.a(f7127a + "|getGuardOthersFromFile gm= " + i, new Object[0]);
            return i;
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
            return -1;
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:70:0x010d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void a(InputStream inputStream) throws Throwable {
        BufferedReader bufferedReader = null;
        try {
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
                while (true) {
                    try {
                        String line = bufferedReader2.readLine();
                        if (line == null) {
                            try {
                                bufferedReader2.close();
                                return;
                            } catch (Exception e) {
                                com.igexin.c.a.c.a.a(e);
                                return;
                            }
                        }
                        if (!line.startsWith("#")) {
                            String[] strArrSplit = line.split(ContainerUtils.KEY_VALUE_DELIMITER);
                            byte b = 2;
                            if (strArrSplit.length >= 2) {
                                String strTrim = strArrSplit[0].trim();
                                String strTrim2 = strArrSplit[1].trim();
                                switch (strTrim.hashCode()) {
                                    case -1784363506:
                                        b = !strTrim.equals("sdk.readlocalcell.enable") ? (byte) -1 : (byte) 6;
                                        break;
                                    case -1734610495:
                                        if (strTrim.equals("sdk.enter.backup.detect.failed.cnt")) {
                                            b = dn.k;
                                            break;
                                        }
                                        break;
                                    case -1286040506:
                                        if (strTrim.equals("sdk.detect.ip.expired.time")) {
                                            b = 15;
                                            break;
                                        }
                                        break;
                                    case -1050591911:
                                        if (strTrim.equals("sdk.feature.setsilenttime.enable")) {
                                            b = 9;
                                            break;
                                        }
                                        break;
                                    case -1004501973:
                                        if (strTrim.equals("sdk.config_address")) {
                                            b = 1;
                                            break;
                                        }
                                        break;
                                    case -416668775:
                                        if (strTrim.equals("sdk.feature.setsockettimeout.enable")) {
                                            b = 11;
                                            break;
                                        }
                                        break;
                                    case -367623287:
                                        if (strTrim.equals("sdk.address.id")) {
                                            b = 18;
                                            break;
                                        }
                                        break;
                                    case -52474114:
                                        if (strTrim.equals("sdk.feature.sendmessage.enable")) {
                                            b = 7;
                                            break;
                                        }
                                        break;
                                    case 85426222:
                                        if (strTrim.equals("sdk.cm_address_backup")) {
                                            b = 4;
                                            break;
                                        }
                                        break;
                                    case 178406040:
                                        if (strTrim.equals("sdk.stay.backup.time")) {
                                            b = 12;
                                            break;
                                        }
                                        break;
                                    case 275980049:
                                        if (strTrim.equals("sdk.login.failed.cnt")) {
                                            b = dn.l;
                                            break;
                                        }
                                        break;
                                    case 352273926:
                                        if (strTrim.equals("sdk.feature.setheartbeatinterval.enable")) {
                                            b = 10;
                                            break;
                                        }
                                        break;
                                    case 914256432:
                                        if (strTrim.equals("sdk.bi_address")) {
                                            break;
                                        }
                                        break;
                                    case 1188929677:
                                        if (strTrim.equals("sdk.feature.settag.enable")) {
                                            b = 8;
                                            break;
                                        }
                                        break;
                                    case 1457933893:
                                        if (strTrim.equals("sdk.log_address")) {
                                            b = 3;
                                            break;
                                        }
                                        break;
                                    case 1488582065:
                                        if (strTrim.equals("sdk.address.key")) {
                                            b = 17;
                                            break;
                                        }
                                        break;
                                    case 1603576119:
                                        if (strTrim.equals("sdk.domainbackup.enable")) {
                                            b = 5;
                                            break;
                                        }
                                        break;
                                    case 1676315519:
                                        if (strTrim.equals("sdk.detect.interval.time")) {
                                            b = 16;
                                            break;
                                        }
                                        break;
                                    case 2077859667:
                                        if (strTrim.equals("sdk.cm_address")) {
                                            b = 0;
                                            break;
                                        }
                                        break;
                                    default:
                                        break;
                                }
                                switch (b) {
                                    case 0:
                                        SDKUrlConfig.setXfrAddressIps(strTrim2.split(","));
                                        break;
                                    case 1:
                                        SDKUrlConfig.CONFIG_ADDRESS_IPS = strTrim2.split(",");
                                        break;
                                    case 2:
                                        SDKUrlConfig.BI_ADDRESS_IPS = strTrim2.split(",");
                                        break;
                                    case 3:
                                        SDKUrlConfig.LOG_ADDRESS_IPS = strTrim2.split(",");
                                        break;
                                    case 4:
                                        SDKUrlConfig.XFR_ADDRESS_BAK = strTrim2.split(",");
                                        break;
                                    case 5:
                                        d.g = Boolean.parseBoolean(strTrim2);
                                        break;
                                    case 6:
                                        d.h = Boolean.parseBoolean(strTrim2);
                                        break;
                                    case 7:
                                        d.j = Boolean.parseBoolean(strTrim2);
                                        break;
                                    case 8:
                                        d.k = Boolean.parseBoolean(strTrim2);
                                        break;
                                    case 9:
                                        d.l = Boolean.parseBoolean(strTrim2);
                                        break;
                                    case 10:
                                        d.m = Boolean.parseBoolean(strTrim2);
                                        break;
                                    case 11:
                                        d.n = Boolean.parseBoolean(strTrim2);
                                        break;
                                    case 12:
                                        d.r = Long.parseLong(strTrim2) * 1000;
                                        break;
                                    case 13:
                                        d.s = Integer.parseInt(strTrim2);
                                        break;
                                    case 14:
                                        d.t = Integer.parseInt(strTrim2);
                                        break;
                                    case 15:
                                        d.u = Long.parseLong(strTrim2) * 1000;
                                        break;
                                    case 16:
                                        d.v = Long.parseLong(strTrim2) * 1000;
                                        break;
                                    case 17:
                                        com.igexin.push.g.g.f7362a = strTrim2;
                                        break;
                                    case 18:
                                        com.igexin.push.g.g.b = strTrim2;
                                        break;
                                }
                                com.igexin.c.a.c.a.a(f7127a, "loadConfigFromFile, config line:".concat(line));
                            }
                        }
                    } catch (Exception unused) {
                        bufferedReader = bufferedReader2;
                        com.igexin.c.a.c.a.a(f7127a + "｜no config file found.", new Object[0]);
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                                return;
                            } catch (Exception e2) {
                                com.igexin.c.a.c.a.a(e2);
                                return;
                            }
                        }
                        return;
                    } catch (Throwable th) {
                        th = th;
                        bufferedReader = bufferedReader2;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (Exception e3) {
                                com.igexin.c.a.c.a.a(e3);
                            }
                        }
                        throw th;
                    }
                }
            } catch (Exception unused2) {
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static void b(Boolean bool) throws Throwable {
        FileInputStream fileInputStream;
        BufferedReader bufferedReader = null;
        try {
            fileInputStream = new FileInputStream(j.e);
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(fileInputStream, "UTF-8"));
                try {
                    StringBuilder sb = new StringBuilder();
                    while (true) {
                        String line = bufferedReader2.readLine();
                        if (line == null) {
                            break;
                        }
                        if (line.startsWith("#")) {
                            sb.append(line);
                        } else {
                            String[] strArrSplit = line.split(ContainerUtils.KEY_VALUE_DELIMITER);
                            if (strArrSplit.length < 2) {
                                sb.append(line);
                            } else {
                                String strTrim = strArrSplit[0].trim();
                                strArrSplit[1].trim();
                                if (!strTrim.equals("sdk.debug")) {
                                    sb.append(line);
                                }
                            }
                        }
                        sb.append("\n");
                    }
                    sb.append("sdk.debug=".concat(String.valueOf(bool)));
                    byte[] bytes = sb.toString().getBytes();
                    if (bytes != null) {
                        j.a(bytes, j.e);
                    }
                    try {
                        bufferedReader2.close();
                    } catch (IOException e) {
                        com.igexin.c.a.c.a.a(e);
                    }
                    try {
                        fileInputStream.close();
                    } catch (Exception e2) {
                        com.igexin.c.a.c.a.a(e2);
                    }
                } catch (Exception unused) {
                    bufferedReader = bufferedReader2;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e3) {
                            com.igexin.c.a.c.a.a(e3);
                        }
                    }
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception e4) {
                            com.igexin.c.a.c.a.a(e4);
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    bufferedReader = bufferedReader2;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e5) {
                            com.igexin.c.a.c.a.a(e5);
                        }
                    }
                    if (fileInputStream == null) {
                        throw th;
                    }
                    try {
                        fileInputStream.close();
                        throw th;
                    } catch (Exception e6) {
                        com.igexin.c.a.c.a.a(e6);
                        throw th;
                    }
                }
            } catch (Exception unused2) {
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception unused3) {
            fileInputStream = null;
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
        }
    }

    public static void a(Boolean bool) {
        try {
            j.l();
            if (new File(j.e).exists()) {
                b(bool);
                return;
            }
            byte[] bytes = "sdk.debug=".concat(String.valueOf(bool)).getBytes();
            if (bytes != null) {
                j.a(bytes, j.e);
            }
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
    }

    public static void a(boolean z, boolean z2) {
        try {
            j.l();
            com.igexin.push.core.d.c.a().a(com.igexin.push.core.d.c.f7204a, Boolean.valueOf(z));
            com.igexin.push.core.d.c.a().a(com.igexin.push.core.d.c.b, Boolean.valueOf(z2));
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
    }
}
