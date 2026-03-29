package com.zm.fda.OOZ20;

import com.zm.fda.utils.EventLog;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class O022Z {
    public InterfaceC1163O022Z b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicBoolean f16635a = new AtomicBoolean(false);
    public final com.zm.fda.OOZ20.Z0225.OO22Z c = new OO22Z();

    /* JADX INFO: renamed from: com.zm.fda.OOZ20.O022Z$O022Z, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public interface InterfaceC1163O022Z {
        void a(String str, int i);
    }

    /* JADX INFO: compiled from: SearchBox */
    public class OO22Z implements com.zm.fda.OOZ20.Z0225.OO22Z {
        public OO22Z() {
        }

        @Override // com.zm.fda.OOZ20.Z0225.OO22Z
        public void a(int i, String str, Object obj) {
            if (i == 0 && (obj instanceof Integer) && O022Z.this.b != null) {
                O022Z.this.b.a(str, ((Integer) obj).intValue());
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class Z25O0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final O022Z f16636a = new O022Z();
    }

    /* JADX INFO: compiled from: SearchBox */
    public class ZZ00Z implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.zm.fda.Z0O00.Z0O00.Z25O0 f16637a;
        public final /* synthetic */ String b;
        public final /* synthetic */ com.zm.fda.OOZ20.Z0225.OO22Z c;

        public ZZ00Z(com.zm.fda.Z0O00.Z0O00.Z25O0 z25o0, String str, com.zm.fda.OOZ20.Z0225.OO22Z oo22z) {
            this.f16637a = z25o0;
            this.b = str;
            this.c = oo22z;
        }

        /* JADX WARN: Removed duplicated region for block: B:29:0x0065  */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            byte[] bArrC;
            int i;
            try {
                JSONObject jSONObjectB = this.f16637a.b();
                if (jSONObjectB != null) {
                    try {
                        if (EventLog.isDebugEnable()) {
                            EventLog.d("FdaRequestBodyJson", "requestBodyJson:" + jSONObjectB);
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                    bArrC = com.zm.fda.OOZ20.Z0225.O022Z.c(jSONObjectB.toString().getBytes());
                } else {
                    bArrC = null;
                }
                if (bArrC == null || bArrC.length <= 0) {
                    i = 0;
                } else {
                    byte[] bArrA = com.zm.fda.OOZ20.OO22Z.a(this.b, bArrC, O022Z.this.c);
                    if (bArrA == null || bArrA.length == 0) {
                        i = 10;
                    } else {
                        try {
                            com.zm.fda.Z0O00.O022Z o022zD = com.zm.fda.OOZ20.Z0225.O022Z.d(bArrA);
                            if (o022zD != null) {
                                if (o022zD.a()) {
                                    i = 1;
                                }
                            }
                        } catch (Exception unused) {
                            i = 30;
                        }
                    }
                }
                com.zm.fda.OOZ20.Z0225.OO22Z oo22z = this.c;
                if (oo22z != null) {
                    oo22z.a(i, "", this.f16637a.a());
                }
            } catch (Exception e) {
                EventLog.d("fob_fda", "exce: ", e.getMessage());
                com.zm.fda.OOZ20.Z0225.OO22Z oo22z2 = this.c;
                if (oo22z2 != null) {
                    oo22z2.a(0, e.toString(), null);
                }
            }
        }
    }

    public void c(String str, com.zm.fda.Z0O00.Z0O00.Z25O0 z25o0, com.zm.fda.OOZ20.Z0225.OO22Z oo22z) {
        com.zm.fda.OOZ20.Z25O0.b(a(str, z25o0, oo22z), oo22z);
    }

    public static O022Z a() {
        return Z25O0.f16636a;
    }

    public void b(String str, com.zm.fda.Z0O00.Z0O00.Z25O0 z25o0, com.zm.fda.OOZ20.Z0225.OO22Z oo22z) {
        com.zm.fda.OOZ20.Z25O0.a(a(str, z25o0, oo22z), oo22z);
    }

    private boolean b() {
        return this.f16635a.get();
    }

    public void a(InterfaceC1163O022Z interfaceC1163O022Z) {
        this.b = interfaceC1163O022Z;
    }

    public synchronized void a(String str, com.zm.fda.Z2500.Z0O00.OO22Z oo22z) {
        if (oo22z == null) {
            return;
        }
        if (b()) {
            EventLog.d("fob_fda", "crash uploading return");
            return;
        }
        a(true);
        File[] fileArrE = oo22z.e();
        if (fileArrE != null && fileArrE.length > 0) {
            EventLog.d("fob_fda", "crash/anr 上传数量：", Integer.valueOf(fileArrE.length));
            for (File file : fileArrE) {
                if (file != null && file.exists()) {
                    EventLog.d("fob_fda", "crash/anr 上传文件：", file.getAbsolutePath());
                    byte[] bArrB = com.zm.fda.O52OZ.Z25O0.b(file.getAbsolutePath());
                    if (bArrB == null) {
                        EventLog.d("fob_fda", "bytes is null continue");
                    } else {
                        byte[] bArrA = com.zm.fda.OOZ20.OO22Z.a(str, bArrB, this.c);
                        if (bArrA != null && bArrA.length != 0) {
                            try {
                                com.zm.fda.Z0O00.O022Z o022zD = com.zm.fda.OOZ20.Z0225.O022Z.d(bArrA);
                                if (o022zD != null && o022zD.a()) {
                                    EventLog.d("fob_fda", "fda crash/anr 上传文件成功，删除文件：", file.getAbsolutePath());
                                    oo22z.a(file);
                                }
                            } catch (Exception unused) {
                            }
                        }
                    }
                }
            }
        }
        a(false);
    }

    private Runnable a(String str, com.zm.fda.Z0O00.Z0O00.Z25O0 z25o0, com.zm.fda.OOZ20.Z0225.OO22Z oo22z) {
        return new ZZ00Z(z25o0, str, oo22z);
    }

    private void a(boolean z) {
        this.f16635a.set(z);
    }
}
