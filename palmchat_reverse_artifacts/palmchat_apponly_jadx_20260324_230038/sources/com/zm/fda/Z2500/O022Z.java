package com.zm.fda.Z2500;

import android.text.TextUtils;
import com.lantern.auth.server.WkParams;
import com.zm.fda.utils.EventLog;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class O022Z implements Runnable {
    public static final String f = "fda_crash_CUP";
    public static final String g = "https://cr.51y5.net/dc/sec/fa.do";
    public static final String h = "https://wifi3a.51y5.net/buglyagent/dc/sec/fa.do";
    public static final String i = "https://cr.51y5.net/dc/sec/rna.do";
    public static final String j = "https://wifi3a.51y5.net/buglyagent/dc/sec/rna.do";
    public static final long k = 204800;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f16682a;
    public com.zm.fda.Z2500.Z0O00.OO22Z b;
    public File[] c;
    public AtomicBoolean d = new AtomicBoolean(false);
    public AtomicBoolean e = new AtomicBoolean(false);

    public O022Z(int i2, com.zm.fda.Z2500.Z0O00.OO22Z oo22z) {
        this.f16682a = i2;
        this.b = oo22z;
        if (oo22z != null) {
            if (i2 == 1) {
                this.c = oo22z.d();
            } else if (i2 == 2) {
                this.c = oo22z.c();
            }
        }
    }

    private String a() {
        int i2 = this.f16682a;
        return i2 == 1 ? EventLog.isDebugEnable() ? h : g : i2 == 2 ? EventLog.isDebugEnable() ? j : i : "";
    }

    private boolean b() {
        int i2 = this.f16682a;
        if (i2 == 1) {
            return this.d.get();
        }
        if (i2 == 2) {
            return this.e.get();
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00cc  */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() throws Throwable {
        String str;
        int i2;
        com.zm.fda.Z2500.Z0O00.OO22Z oo22z;
        File[] fileArr = this.c;
        if (fileArr == null) {
            EventLog.d(f, "mCrashFileList is null");
            return;
        }
        EventLog.d(f, "crashFileList length:", Integer.valueOf(fileArr.length), " type:", Integer.valueOf(this.f16682a));
        if (b()) {
            EventLog.d(f, "crash uploading return");
            return;
        }
        a(true);
        String strA = a();
        if (TextUtils.isEmpty(strA)) {
            EventLog.d(f, "crash url is empty return");
            return;
        }
        for (File file : this.c) {
            if (file != null) {
                String absolutePath = file.getAbsolutePath();
                EventLog.d(f, "filePath:", absolutePath);
                if (com.zm.fda.O52OZ.Z25O0.a(absolutePath) > k) {
                    com.zm.fda.Z2500.Z0O00.OO22Z oo22z2 = this.b;
                    if (oo22z2 != null) {
                        oo22z2.a(file);
                    }
                    EventLog.d(f, "file is too large delete continue");
                } else {
                    byte[] bArrB = com.zm.fda.O52OZ.Z25O0.b(file.getAbsolutePath());
                    if (bArrB == null) {
                        EventLog.d(f, "bytes is null continue");
                    } else {
                        try {
                            EventLog.d(f, "upload params:", new String(bArrB, "UTF-8"));
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                        byte[] bArrA = new com.zm.fda.OOZ20.OO22Z(strA, null).a(bArrB);
                        if (bArrA != null) {
                            try {
                                str = new String(bArrA, "UTF-8");
                            } catch (Throwable th2) {
                                th2.printStackTrace();
                                str = "";
                            }
                            if (TextUtils.isEmpty(str)) {
                                EventLog.d(f, "result:", str);
                                try {
                                    i2 = !TextUtils.equals(new JSONObject(str).optString(WkParams.RETCD), "0") ? -1 : 0;
                                } catch (Throwable th3) {
                                    th3.printStackTrace();
                                    i2 = -2;
                                }
                                EventLog.d(f, "taianping resultCode:", Integer.valueOf(i2));
                                if (i2 == 0 && (oo22z = this.b) != null) {
                                    oo22z.a(file);
                                }
                            } else {
                                EventLog.d(f, "http result is empty continue");
                            }
                        } else {
                            str = "";
                            if (TextUtils.isEmpty(str)) {
                            }
                        }
                    }
                }
            }
        }
        a(false);
    }

    private void a(boolean z) {
        int i2 = this.f16682a;
        if (i2 == 1) {
            this.d.set(z);
        } else if (i2 == 2) {
            this.e.set(z);
        }
    }
}
