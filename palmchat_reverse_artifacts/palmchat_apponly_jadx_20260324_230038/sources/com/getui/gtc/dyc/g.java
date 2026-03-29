package com.getui.gtc.dyc;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.getui.gtc.base.GtcProvider;
import com.getui.gtc.base.http.Call;
import com.getui.gtc.base.http.Response;
import com.getui.gtc.base.util.CommonUtil;
import com.getui.gtc.dyc.b.b;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class g {

    /* JADX INFO: renamed from: com.getui.gtc.dyc.g$1, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public class AnonymousClass1 implements Call.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f5761a;
        final /* synthetic */ d c;
        final /* synthetic */ b d;

        @Override // com.getui.gtc.base.http.Call.Callback
        public void onFailure(Call call, Exception exc) {
            c cVar = this.f5761a;
            if (cVar != null) {
                cVar.a(exc);
            }
        }

        @Override // com.getui.gtc.base.http.Call.Callback
        public void onResponse(Call call, Response response) {
            try {
                h hVarA = this.c.a(this.d, response);
                c cVar = this.f5761a;
                if (cVar != null) {
                    cVar.a(hVarA);
                }
            } catch (Throwable th) {
                com.getui.gtc.dyc.a.a.a.c(th);
                c cVar2 = this.f5761a;
                if (cVar2 != null) {
                    cVar2.a(th);
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final g f5762a = new g(null);
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface c {
        void a(h hVar);

        void a(Throwable th);
    }

    private g() {
        a(GtcProvider.context());
    }

    public static g a() {
        return a.f5762a;
    }

    public /* synthetic */ g(AnonymousClass1 anonymousClass1) {
        this();
    }

    public h a(b bVar) throws Exception {
        return new d().a(bVar);
    }

    private void a(Context context) {
        try {
            Bundle bundle = CommonUtil.getAppInfoForSelf(context).metaData;
            if (bundle != null) {
                String string = bundle.getString("DYC_P");
                if (!TextUtils.isEmpty(string)) {
                    d.f5755a = string;
                }
                String string2 = bundle.getString("DYC_K");
                if (TextUtils.isEmpty(string2)) {
                    return;
                }
                d.c = string2;
            }
        } catch (Throwable th) {
            com.getui.gtc.dyc.a.a.a.c(th);
        }
    }
}
