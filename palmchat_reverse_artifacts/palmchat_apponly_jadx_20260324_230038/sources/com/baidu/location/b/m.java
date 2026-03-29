package com.baidu.location.b;

import android.location.Location;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.location.BDLocation;
import com.baidu.location.Jni;
import com.cdo.oaps.ad.wrapper.BaseWrapper;
import com.google.android.material.timepicker.TimeModel;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public abstract class m {
    public static String d;
    public a e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.baidu.location.c.k f3433a = null;
    public com.baidu.location.c.a b = null;
    public HashSet<String> c = null;
    private boolean g = true;
    private boolean h = true;
    private boolean i = false;
    private long j = 0;
    final Handler f = new b();
    private String k = null;
    private String l = null;
    private boolean m = false;
    private long n = 0;
    private int o = 0;

    /* JADX INFO: compiled from: SearchBox */
    public static class a extends com.baidu.location.e.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private long f3434a;
        private int b;

        public a() {
            this.el = new HashMap();
        }

        @Override // com.baidu.location.e.f
        public void a() {
            StringBuffer stringBuffer = new StringBuffer(256);
            stringBuffer.append("os=A");
            stringBuffer.append(Build.VERSION.SDK_INT);
            stringBuffer.append("&prod=");
            stringBuffer.append(com.baidu.location.e.b.e);
            stringBuffer.append("&resid=");
            stringBuffer.append(BaseWrapper.ENTER_ID_MARKET);
            String str = com.baidu.location.e.b.i;
            if (str == null) {
                str = "";
            }
            stringBuffer.append("&mapver=");
            stringBuffer.append(str);
            stringBuffer.append(com.baidu.location.e.h.e(com.baidu.location.f.getServiceContext()));
            stringBuffer.append("&cu=");
            stringBuffer.append(com.baidu.location.e.b.a().b());
            stringBuffer.append("&error=");
            stringBuffer.append(this.b);
            if (this.f3434a > 0) {
                stringBuffer.append("&tm=");
                stringBuffer.append(this.f3434a);
            }
            this.el.put("info", Jni.encodeTp4(stringBuffer.toString()));
            this.el.put("qt", "monitor");
        }

        @Override // com.baidu.location.e.f
        public void a(boolean z) {
            Map<String, Object> map = this.el;
            if (map != null) {
                map.clear();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends Handler {
        public b() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (com.baidu.location.f.isServing) {
                int i = message.what;
                if (i == 21) {
                    m.this.a(message);
                } else if (i == 62 || i == 63) {
                    m.this.a();
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends com.baidu.location.e.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f3436a = null;
        String b = null;
        long c = 0;
        long d = 0;
        long e = 0;

        public c() {
            this.el = new HashMap();
        }

        @Override // com.baidu.location.e.f
        public void a() {
            if ((com.baidu.location.e.h.g || com.baidu.location.e.h.i) && m.this.k != null && m.this.l != null) {
                this.b += String.format(Locale.CHINA, "&ki=%s&sn=%s", m.this.k, m.this.l);
            }
            if (n.a().b()) {
                this.b += "&enc=2";
            }
            String strQ = com.baidu.location.c.f.a().q();
            if (strQ != null) {
                this.er = Jni.encodeTp4(strQ);
            }
            String strEncodeTp4 = Jni.encodeTp4(this.b);
            this.b = null;
            if (this.f3436a == null) {
                this.f3436a = z.b();
            }
            this.el.put("bloc", strEncodeTp4);
            String str = this.f3436a;
            if (str != null) {
                this.el.put("up", str);
            }
            this.el.put("trtm", String.format(Locale.CHINA, TimeModel.NUMBER_FORMAT, Long.valueOf(System.currentTimeMillis())));
            this.es = 0L;
        }

        public void a(String str, long j) {
            this.b = str;
            this.d = System.currentTimeMillis();
            this.c = j;
            ExecutorService executorServiceB = x.a().b();
            if (com.baidu.location.e.h.b()) {
                a(executorServiceB, false, null);
            } else if (executorServiceB != null) {
                a(executorServiceB, com.baidu.location.e.d.e);
            } else {
                b(com.baidu.location.e.d.e);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:4:0x000c, code lost:
        
            r12 = r11.ej;
         */
        @Override // com.baidu.location.e.f
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void a(boolean z) {
            String strB;
            BDLocation bDLocation;
            Message messageObtainMessage;
            if (!z || strB == null) {
                Message messageObtainMessage2 = m.this.f.obtainMessage(63);
                messageObtainMessage2.obj = "HttpStatus error";
                messageObtainMessage2.sendToTarget();
            } else {
                try {
                    m.d = strB;
                    if (strB.contains("enc3")) {
                        strB = com.baidu.location.e.h.d(strB);
                    } else if (strB.contains("enc") && n.a().b()) {
                        try {
                            JSONObject jSONObject = new JSONObject(strB);
                            if (jSONObject.has("enc")) {
                                strB = n.a().b(jSONObject.getString("enc"));
                            }
                        } catch (Exception unused) {
                        }
                    }
                    int iOptInt = 1;
                    if (strB.contains("net_loc_save")) {
                        try {
                            JSONObject jSONObject2 = new JSONObject(strB);
                            JSONObject jSONObject3 = jSONObject2.has("content") ? jSONObject2.getJSONObject("content") : null;
                            if (jSONObject3 != null && jSONObject3.has("net_loc_save")) {
                                iOptInt = jSONObject3.optInt("net_loc_save", 1);
                            }
                        } catch (Exception unused2) {
                        }
                    }
                    try {
                        bDLocation = new BDLocation(strB);
                        bDLocation.getLocType();
                        if (com.baidu.location.e.h.h(com.baidu.location.f.getServiceContext()) && bDLocation.getLocType() == 161) {
                            bDLocation.setLocType(160);
                            bDLocation.setRadius(2000.0f);
                        }
                        if (bDLocation.getLocType() == 161) {
                            k.a().a(strB);
                        }
                        if (u.a().d()) {
                            bDLocation.setDirection(u.a().e());
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        bDLocation = new BDLocation();
                        bDLocation.setLocType(0);
                    }
                    this.f3436a = null;
                    if (bDLocation.getLocType() == 0 && bDLocation.getLatitude() == Double.MIN_VALUE && bDLocation.getLongitude() == Double.MIN_VALUE) {
                        messageObtainMessage = m.this.f.obtainMessage(63);
                        messageObtainMessage.obj = "HttpStatus error";
                    } else {
                        long jCurrentTimeMillis = (System.currentTimeMillis() - this.d) / 1000;
                        if (jCurrentTimeMillis < 0) {
                            jCurrentTimeMillis = 0;
                        }
                        if (this.c < 0) {
                            this.c = 0L;
                        }
                        bDLocation.setDelayTime(this.c + jCurrentTimeMillis);
                        messageObtainMessage = m.this.f.obtainMessage(21);
                        messageObtainMessage.obj = bDLocation;
                        messageObtainMessage.arg1 = iOptInt;
                    }
                    messageObtainMessage.sendToTarget();
                } catch (Exception unused3) {
                    Message messageObtainMessage22 = m.this.f.obtainMessage(63);
                    messageObtainMessage22.obj = "HttpStatus error";
                    messageObtainMessage22.sendToTarget();
                }
            }
            Map<String, Object> map = this.el;
            if (map != null) {
                map.clear();
            }
        }
    }

    public abstract void a();

    public abstract void a(Message message);

    public String b() {
        String strC = com.baidu.location.b.b.a().c();
        String str = com.baidu.location.c.f.a().l() ? "&cn=32" : String.format(Locale.CHINA, "&cn=%d", Integer.valueOf(com.baidu.location.c.f.a().g()));
        if (System.currentTimeMillis() - this.n > 60000) {
            this.n = System.currentTimeMillis();
            String strC2 = com.baidu.location.e.h.c();
            if (!TextUtils.isEmpty(strC2)) {
                str = str + "&qcip6c=" + strC2;
            }
        }
        if (this.g) {
            this.g = false;
        } else if (!this.i) {
            String strE = z.e();
            if (strE != null) {
                str = str + strE;
            }
            this.i = true;
        }
        return str + strC;
    }

    public String a(String str) {
        com.baidu.location.c.k kVar;
        String strO;
        if (this.k == null) {
            this.k = com.baidu.location.a.a.b(com.baidu.location.f.getServiceContext());
        }
        if (this.l == null) {
            this.l = com.baidu.location.a.a.c(com.baidu.location.f.getServiceContext());
        }
        com.baidu.location.c.a aVar = this.b;
        if (aVar == null || !aVar.a()) {
            this.b = com.baidu.location.c.f.a().f();
        }
        com.baidu.location.c.k kVar2 = this.f3433a;
        if (kVar2 == null || !kVar2.b()) {
            this.f3433a = com.baidu.location.c.f.a().r();
        }
        Location locationG = com.baidu.location.c.d.a().j() ? com.baidu.location.c.d.a().g() : null;
        com.baidu.location.c.a aVar2 = this.b;
        if ((aVar2 == null || aVar2.d() || this.b.c()) && (((kVar = this.f3433a) == null || kVar.a() == 0) && locationG == null)) {
            return null;
        }
        String strB = b();
        if (k.a().d() == -2) {
            strB = strB + "&imo=1";
        }
        int iB = com.baidu.location.e.h.b(com.baidu.location.f.getServiceContext());
        if (iB >= 0) {
            strB = strB + "&lmd=" + iB;
            if (Build.VERSION.SDK_INT >= 28 && !this.m) {
                this.m = true;
                try {
                    if (com.baidu.location.f.getServiceContext().getPackageManager().hasSystemFeature("android.hardware.wifi.rtt")) {
                        strB = strB + "&rtt=1";
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
        com.baidu.location.c.k kVar3 = this.f3433a;
        if ((kVar3 == null || kVar3.a() == 0) && (strO = com.baidu.location.c.f.a().o()) != null) {
            strB = strO + strB;
        }
        if (com.baidu.location.c.f.a().m()) {
            strB = strB + "&wf_freq=1";
        }
        String str2 = strB;
        if (!this.h) {
            return com.baidu.location.e.h.a(this.b, this.f3433a, locationG, str2, 0);
        }
        this.h = false;
        return com.baidu.location.e.h.a(this.b, this.f3433a, locationG, str2, 0, true);
    }
}
