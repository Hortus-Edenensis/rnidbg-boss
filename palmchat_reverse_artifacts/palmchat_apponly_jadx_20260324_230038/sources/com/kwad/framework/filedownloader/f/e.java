package com.kwad.framework.filedownloader.f;

import com.huawei.hms.ads.ex;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class e {
    public final int atM;
    public final long atN;
    public final boolean atO;
    public final boolean atP;
    public final int atQ;
    public final boolean atR;
    public final boolean atS;

    /* JADX INFO: compiled from: SearchBox */
    public static class a {
        private static final e atT = new e(0);
    }

    public /* synthetic */ e(byte b) {
        this();
    }

    public static e Bf() {
        return a.atT;
    }

    public static int cw(int i) {
        if (i > 12) {
            d.d(e.class, "require the count of network thread  is %d, what is more than the max valid count(%d), so adjust to %d auto", Integer.valueOf(i), 12, 12);
            return 12;
        }
        if (i > 0) {
            return i;
        }
        d.d(e.class, "require the count of network thread  is %d, what is less than the min valid count(%d), so adjust to %d auto", Integer.valueOf(i), 1, 1);
        return 1;
    }

    /* JADX WARN: Removed duplicated region for block: B:109:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x007d A[Catch: all -> 0x01cf, TryCatch #8 {all -> 0x01cf, blocks: (B:7:0x0033, B:8:0x003a, B:9:0x003e, B:10:0x0042, B:11:0x0046, B:12:0x004a, B:37:0x0079, B:39:0x007d, B:41:0x0081, B:42:0x0089), top: B:95:0x0033 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0089 A[Catch: all -> 0x01cf, TRY_LEAVE, TryCatch #8 {all -> 0x01cf, blocks: (B:7:0x0033, B:8:0x003a, B:9:0x003e, B:10:0x0042, B:11:0x0046, B:12:0x004a, B:37:0x0079, B:39:0x007d, B:41:0x0081, B:42:0x0089), top: B:95:0x0033 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x017a  */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8, types: [boolean] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private e() throws Throwable {
        InputStream inputStream;
        InputStream inputStreamOpen;
        String property;
        String property2;
        String property3;
        String property4;
        String property5;
        String str;
        String str2;
        String property6;
        Object obj;
        int i;
        Object obj2;
        long j;
        Object obj3;
        int i2;
        ?? r4;
        if (c.Bd() == null) {
            throw new IllegalStateException("Please invoke the 'FileDownloader#setup' before using FileDownloader. If you want to register some components on FileDownloader please invoke the 'FileDownloader#setupOnApplicationOnCreate' on the 'Application#onCreate' first.");
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        Properties properties = new Properties();
        try {
            inputStreamOpen = c.Bd().getAssets().open("filedownloader.properties");
            if (inputStreamOpen != null) {
                try {
                    try {
                        properties.load(inputStreamOpen);
                        property = properties.getProperty("http.lenient");
                    } catch (IOException e) {
                        e = e;
                        property = null;
                        property2 = null;
                        property3 = null;
                        property4 = null;
                        property5 = null;
                        if (e instanceof FileNotFoundException) {
                            e.printStackTrace();
                        } else if (d.atL) {
                            d.c(e.class, "not found filedownloader.properties", new Object[0]);
                        }
                        com.kwad.sdk.crash.utils.b.closeQuietly(inputStreamOpen);
                        str = property;
                        str2 = property5;
                        property6 = null;
                        if (str != null) {
                        }
                        this.atP = true;
                        if (property2 == null) {
                        }
                        if (property3 == null) {
                        }
                        if (property4 == null) {
                        }
                        if (str2 != null) {
                        }
                        if (property6 != null) {
                        }
                        if (d.atL) {
                        }
                    }
                    try {
                        property2 = properties.getProperty("download.min-progress-step");
                    } catch (IOException e2) {
                        e = e2;
                        property2 = null;
                        property3 = null;
                        property4 = null;
                        property5 = null;
                        if (e instanceof FileNotFoundException) {
                        }
                        com.kwad.sdk.crash.utils.b.closeQuietly(inputStreamOpen);
                        str = property;
                        str2 = property5;
                        property6 = null;
                        if (str != null) {
                        }
                        this.atP = true;
                        if (property2 == null) {
                        }
                        if (property3 == null) {
                        }
                        if (property4 == null) {
                        }
                        if (str2 != null) {
                        }
                        if (property6 != null) {
                        }
                        if (d.atL) {
                        }
                    }
                    try {
                        property3 = properties.getProperty("download.min-progress-time");
                    } catch (IOException e3) {
                        e = e3;
                        property3 = null;
                        property4 = null;
                        property5 = null;
                        if (e instanceof FileNotFoundException) {
                        }
                        com.kwad.sdk.crash.utils.b.closeQuietly(inputStreamOpen);
                        str = property;
                        str2 = property5;
                        property6 = null;
                        if (str != null) {
                        }
                        this.atP = true;
                        if (property2 == null) {
                        }
                        if (property3 == null) {
                        }
                        if (property4 == null) {
                        }
                        if (str2 != null) {
                        }
                        if (property6 != null) {
                        }
                        if (d.atL) {
                        }
                    }
                    try {
                        property4 = properties.getProperty("download.max-network-thread-count");
                    } catch (IOException e4) {
                        e = e4;
                        property4 = null;
                        property5 = null;
                        if (e instanceof FileNotFoundException) {
                        }
                        com.kwad.sdk.crash.utils.b.closeQuietly(inputStreamOpen);
                        str = property;
                        str2 = property5;
                        property6 = null;
                        if (str != null) {
                        }
                        this.atP = true;
                        if (property2 == null) {
                        }
                        if (property3 == null) {
                        }
                        if (property4 == null) {
                        }
                        if (str2 != null) {
                        }
                        if (property6 != null) {
                        }
                        if (d.atL) {
                        }
                    }
                    try {
                        property5 = properties.getProperty("file.non-pre-allocation");
                    } catch (IOException e5) {
                        e = e5;
                        property5 = null;
                        if (e instanceof FileNotFoundException) {
                        }
                        com.kwad.sdk.crash.utils.b.closeQuietly(inputStreamOpen);
                        str = property;
                        str2 = property5;
                        property6 = null;
                        if (str != null) {
                        }
                        this.atP = true;
                        if (property2 == null) {
                        }
                        if (property3 == null) {
                        }
                        if (property4 == null) {
                        }
                        if (str2 != null) {
                        }
                        if (property6 != null) {
                        }
                        if (d.atL) {
                        }
                    }
                    try {
                        property6 = properties.getProperty("broadcast.completed");
                        str = property;
                    } catch (IOException e6) {
                        e = e6;
                        if (e instanceof FileNotFoundException) {
                        }
                        com.kwad.sdk.crash.utils.b.closeQuietly(inputStreamOpen);
                        str = property;
                        str2 = property5;
                        property6 = null;
                    }
                } catch (Throwable th) {
                    th = th;
                    inputStream = inputStreamOpen;
                    com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
                    throw th;
                }
            } else {
                property6 = null;
                str = null;
                property2 = null;
                property3 = null;
                property4 = null;
                property5 = null;
            }
            com.kwad.sdk.crash.utils.b.closeQuietly(inputStreamOpen);
            str2 = property5;
        } catch (IOException e7) {
            e = e7;
            inputStreamOpen = null;
        } catch (Throwable th2) {
            th = th2;
            inputStream = null;
        }
        if (str != null) {
            obj = "download.max-network-thread-count";
            i = 0;
            this.atO = false;
        } else {
            if (!str.equals(ex.Code) && !str.equals(ex.V)) {
                throw new IllegalStateException(f.c("the value of '%s' must be '%s' or '%s'", "http.lenient", ex.Code, ex.V));
            }
            obj = "download.max-network-thread-count";
            i = 0;
            this.atO = str.equals(ex.Code);
        }
        this.atP = true;
        if (property2 == null) {
            this.atM = Math.max(i, Integer.valueOf(property2).intValue());
        } else {
            this.atM = 65536;
        }
        if (property3 == null) {
            obj2 = "download.min-progress-time";
            j = jCurrentTimeMillis;
            obj3 = "http.lenient";
            this.atN = Math.max(0L, Long.valueOf(property3).longValue());
        } else {
            obj2 = "download.min-progress-time";
            j = jCurrentTimeMillis;
            obj3 = "http.lenient";
            this.atN = 2000L;
        }
        if (property4 == null) {
            this.atQ = cw(Integer.valueOf(property4).intValue());
            i2 = 3;
        } else {
            i2 = 3;
            this.atQ = 3;
        }
        if (str2 != null) {
            r4 = 0;
            this.atR = false;
        } else {
            if (!str2.equals(ex.Code) && !str2.equals(ex.V)) {
                Object[] objArr = new Object[i2];
                objArr[0] = "file.non-pre-allocation";
                objArr[1] = ex.Code;
                objArr[2] = ex.V;
                throw new IllegalStateException(f.c("the value of '%s' must be '%s' or '%s'", objArr));
            }
            r4 = 0;
            this.atR = str2.equals(ex.Code);
        }
        if (property6 != null) {
            this.atS = r4;
        } else {
            if (!property6.equals(ex.Code) && !property6.equals(ex.V)) {
                Object[] objArr2 = new Object[3];
                objArr2[r4] = "broadcast.completed";
                objArr2[1] = ex.Code;
                objArr2[2] = ex.V;
                throw new IllegalStateException(f.c("the value of '%s' must be '%s' or '%s'", objArr2));
            }
            this.atS = property6.equals(ex.Code);
        }
        if (d.atL) {
            return;
        }
        Object[] objArr3 = new Object[11];
        objArr3[r4] = Long.valueOf(System.currentTimeMillis() - j);
        objArr3[1] = obj3;
        objArr3[2] = Boolean.valueOf(this.atO);
        objArr3[3] = "process.non-separate";
        objArr3[4] = true;
        objArr3[5] = "download.min-progress-step";
        objArr3[6] = Integer.valueOf(this.atM);
        objArr3[7] = obj2;
        objArr3[8] = Long.valueOf(this.atN);
        objArr3[9] = obj;
        objArr3[10] = Integer.valueOf(this.atQ);
        d.b(e.class, "init properties %d\n load properties: %s=%B; %s=%B; %s=%d; %s=%d; %s=%d", objArr3);
    }
}
