package com.xiaomi.push.service;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import com.wifi.ad.core.config.EventParams;
import com.xiaomi.push.C1401r;
import com.xiaomi.push.Cdo;
import com.xiaomi.push.cc;
import com.xiaomi.push.cf;
import com.xiaomi.push.cg;
import com.xiaomi.push.dp;
import com.xiaomi.push.ei;
import com.xiaomi.push.eo;
import com.xiaomi.push.ep;
import com.xiaomi.push.fa;
import com.xiaomi.push.fx;
import com.xiaomi.push.service.ax;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class ao extends ax.a implements cg.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f11727a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private XMPushService f945a;

    /* JADX INFO: compiled from: SearchBox */
    public static class a implements cg.b {
        @Override // com.xiaomi.push.cg.b
        public String a(String str) throws IOException {
            Uri.Builder builderBuildUpon = Uri.parse(str).buildUpon();
            builderBuildUpon.appendQueryParameter(EventParams.KEY_PARAM_SDKVER, String.valueOf(48));
            builderBuildUpon.appendQueryParameter("osver", String.valueOf(Build.VERSION.SDK_INT));
            builderBuildUpon.appendQueryParameter("os", fx.a(Build.VERSION.INCREMENTAL));
            builderBuildUpon.appendQueryParameter("mi", String.valueOf(C1401r.a()));
            String string = builderBuildUpon.toString();
            com.xiaomi.channel.commonutils.logger.b.c("fetch bucket from : " + string);
            URL url = new URL(string);
            int port = url.getPort() == -1 ? 80 : url.getPort();
            try {
                long jCurrentTimeMillis = System.currentTimeMillis();
                String strA = com.xiaomi.push.au.a(C1401r.m660a(), url);
                ep.a(url.getHost() + ":" + port, (int) (System.currentTimeMillis() - jCurrentTimeMillis), null);
                return strA;
            } catch (IOException e) {
                ep.a(url.getHost() + ":" + port, -1, e);
                throw e;
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class b extends cg {
        public b(Context context, cf cfVar, cg.b bVar, String str) {
            super(context, cfVar, bVar, str);
        }

        @Override // com.xiaomi.push.cg
        public String a(ArrayList<String> arrayList, String str, String str2, boolean z) throws IOException {
            try {
                if (eo.m406a().m411a()) {
                    str2 = ax.m729a();
                }
                return super.a(arrayList, str, str2, z);
            } catch (IOException e) {
                ep.a(0, ei.GSLB_ERR.a(), 1, null, com.xiaomi.push.au.b(cg.f11468a) ? 1 : 0);
                throw e;
            }
        }
    }

    public ao(XMPushService xMPushService) {
        this.f945a = xMPushService;
    }

    @Override // com.xiaomi.push.service.ax.a
    public void a(Cdo.a aVar) {
    }

    public static void a(XMPushService xMPushService) {
        ao aoVar = new ao(xMPushService);
        ax.a().a(aoVar);
        synchronized (cg.class) {
            cg.a(aoVar);
            cg.a(xMPushService, null, new a(), "0", "push", "2.2");
        }
    }

    @Override // com.xiaomi.push.service.ax.a
    public void a(dp.b bVar) {
        cc ccVarB;
        boolean z;
        if (bVar.m322b() && bVar.m321a() && System.currentTimeMillis() - this.f11727a > 3600000) {
            com.xiaomi.channel.commonutils.logger.b.m74a("fetch bucket :" + bVar.m321a());
            this.f11727a = System.currentTimeMillis();
            cg cgVarA = cg.a();
            cgVarA.m255a();
            cgVarA.m258b();
            fa faVarM684a = this.f945a.m684a();
            if (faVarM684a == null || (ccVarB = cgVarA.b(faVarM684a.m437a().c())) == null) {
                return;
            }
            ArrayList<String> arrayListM242a = ccVarB.m242a();
            Iterator<String> it = arrayListM242a.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = true;
                    break;
                } else if (it.next().equals(faVarM684a.mo438a())) {
                    z = false;
                    break;
                }
            }
            if (!z || arrayListM242a.isEmpty()) {
                return;
            }
            com.xiaomi.channel.commonutils.logger.b.m74a("bucket changed, force reconnect");
            this.f945a.a(0, (Exception) null);
            this.f945a.a(false);
        }
    }

    @Override // com.xiaomi.push.cg.a
    public cg a(Context context, cf cfVar, cg.b bVar, String str) {
        return new b(context, cfVar, bVar, str);
    }
}
