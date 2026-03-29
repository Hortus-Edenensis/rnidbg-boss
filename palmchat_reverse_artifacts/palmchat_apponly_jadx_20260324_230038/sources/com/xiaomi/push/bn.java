package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.xiaomi.push.ae;
import com.xiaomi.push.bw;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class bn {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile bn f11445a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Context f155a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private bx f157a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private by f158a;
    private String e;
    private String f;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private final String f159a = "push_stat_sp";

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    private final String f160b = "upload_time";

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    private final String f161c = "delete_time";
    private final String d = "check_time";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private ae.a f156a = new ae.a() { // from class: com.xiaomi.push.bn.1
        @Override // com.xiaomi.push.ae.a
        /* JADX INFO: renamed from: a */
        public String mo207a() {
            return "10052";
        }

        @Override // java.lang.Runnable
        public void run() {
            com.xiaomi.channel.commonutils.logger.b.c("exec== mUploadJob");
            if (bn.this.f158a != null) {
                bn.this.f158a.a(bn.this.f155a);
                bn.this.b("upload_time");
            }
        }
    };
    private ae.a b = new ae.a() { // from class: com.xiaomi.push.bn.2
        @Override // com.xiaomi.push.ae.a
        /* JADX INFO: renamed from: a */
        public String mo207a() {
            return "10054";
        }

        @Override // java.lang.Runnable
        public void run() {
            com.xiaomi.channel.commonutils.logger.b.c("exec== DbSizeControlJob");
            bw.a(bn.this.f155a).a(new bp(bn.this.c(), new WeakReference(bn.this.f155a)));
            bn.this.b("check_time");
        }
    };
    private ae.a c = new ae.a() { // from class: com.xiaomi.push.bn.3
        @Override // com.xiaomi.push.ae.a
        /* JADX INFO: renamed from: a */
        public String mo207a() {
            return "10053";
        }

        @Override // java.lang.Runnable
        public void run() {
            if (bn.this.f158a != null) {
                bn.this.f158a.b(bn.this.f155a);
                bn.this.b("delete_time");
            }
        }
    };

    private bn(Context context) {
        this.f155a = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        SharedPreferences.Editor editorEdit = this.f155a.getSharedPreferences("push_stat_sp", 0).edit();
        editorEdit.putLong(str, System.currentTimeMillis());
        p.a(editorEdit);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String c() {
        return this.f155a.getDatabasePath(bo.f163a).getAbsolutePath();
    }

    public static bn a(Context context) {
        if (f11445a == null) {
            synchronized (bn.class) {
                if (f11445a == null) {
                    f11445a = new bn(context);
                }
            }
        }
        return f11445a;
    }

    public String b() {
        return this.f;
    }

    private boolean a() {
        return com.xiaomi.push.service.ah.a(this.f155a).a(gk.StatDataSwitch.a(), true);
    }

    public void a(bw.a aVar) {
        bw.a(this.f155a).a(aVar);
    }

    public void a(String str, String str2, Boolean bool) {
        if (this.f157a != null) {
            if (bool.booleanValue()) {
                this.f157a.a(this.f155a, str2, str);
            } else {
                this.f157a.b(this.f155a, str2, str);
            }
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public String m215a() {
        return this.e;
    }

    public void a(String str) {
        if (a() && !TextUtils.isEmpty(str)) {
            a(bz.a(this.f155a, str));
        }
    }

    public void a(gj gjVar) {
        if (a() && com.xiaomi.push.service.az.a(gjVar.e())) {
            a(bt.a(this.f155a, c(), gjVar));
        }
    }
}
