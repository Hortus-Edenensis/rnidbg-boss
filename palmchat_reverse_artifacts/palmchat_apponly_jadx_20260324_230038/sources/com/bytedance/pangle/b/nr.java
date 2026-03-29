package com.bytedance.pangle.b;

import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.api.iz;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class nr {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f5066a = "load_finish";
    public static String b = "install_start";
    public static String fx = "download_finish";
    public static String iz = "7z_unzip_start";
    public static String jk = "rm_entry_finish";
    public static String n = "load_start";
    public static String nr = "download_start";
    public static String pn = "install_finish";
    private static volatile nr t = null;
    public static String u = "request_finish";
    public static String x = "7z_unzip_finish";
    private final List<com.bytedance.pangle.b.u> l = new ArrayList();

    /* JADX INFO: compiled from: SearchBox */
    public static class u {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static int f5067a = 12004;
        public static int b = -2;
        public static int bf = 42000;
        public static int bg = 31000;
        public static int bq = 32000;
        public static int c = 32002;
        public static int d = 32008;
        public static int dw = 32001;
        public static int fx = -1;
        public static int gi = 32007;
        public static int h = 32999;
        public static int iz = 12001;
        public static int ja = 41000;
        public static int jk = 20000;
        public static int k = 22001;
        public static int kj = 32005;
        public static int l = 21001;
        public static int mv = 21002;
        public static int my = 22002;
        public static int n = 12003;
        public static int nr = 2;
        public static int o = 22999;
        public static int pb = 50004;
        public static int pn = 12000;
        public static int q = 32003;
        public static int qq = 32004;
        public static int rh = 40000;
        public static int s = 22000;
        public static int sx = 30000;
        public static int t = 21000;
        public static int u = 1;
        public static int wq = 50000;
        public static int x = 12002;
        public static int z = 32006;
    }

    private nr() {
    }

    public static nr u() {
        if (t == null) {
            synchronized (nr.class) {
                t = new nr();
            }
        }
        return t;
    }

    public void u(@NonNull com.bytedance.pangle.b.u uVar) {
        synchronized (this.l) {
            this.l.add(uVar);
        }
    }

    public void u(String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        synchronized (this.l) {
            Iterator<com.bytedance.pangle.b.u> it = this.l.iterator();
            while (it.hasNext()) {
                try {
                    it.next().u(str, jSONObject, jSONObject2, jSONObject3);
                } catch (Throwable th) {
                    iz.u(th);
                }
            }
        }
    }
}
