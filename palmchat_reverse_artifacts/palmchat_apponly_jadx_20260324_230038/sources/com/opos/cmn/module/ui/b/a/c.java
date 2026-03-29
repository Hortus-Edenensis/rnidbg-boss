package com.opos.cmn.module.ui.b.a;

import android.content.Context;
import android.net.http.SslError;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.SslErrorHandler;
import android.widget.RelativeLayout;
import com.opos.cmn.biz.web.b.a.b;
import com.opos.cmn.module.ui.WebViewActivity;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class c implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.opos.cmn.biz.web.b.a.a f8052a;
    private Context b;
    private WebViewActivity.b c;

    public c(Context context, WebViewActivity.b bVar) {
        Context contextA = com.opos.mobad.service.a.a(context);
        this.b = contextA;
        this.c = bVar;
        this.f8052a = new com.opos.cmn.biz.web.b.a.a(contextA, new b.a().a((com.opos.cmn.biz.web.b.a.a.b) null).a((Map<String, Object>) null).a(false).a(new com.opos.cmn.biz.web.b.a.a.a() { // from class: com.opos.cmn.module.ui.b.a.c.1
            @Override // com.opos.cmn.biz.web.b.a.a.a
            public void a(final SslErrorHandler sslErrorHandler, SslError sslError) {
                com.opos.cmn.an.f.a.b("privacyTool", "onReceivedSslError");
                try {
                    com.opos.cmn.module.ui.b.c.c cVar = new com.opos.cmn.module.ui.b.c.c(c.this.b, 0.1f);
                    final View viewB = cVar.b();
                    cVar.a((CharSequence) "SSL证书验证错误，是否继续？");
                    cVar.b("取消");
                    cVar.a("继续");
                    cVar.a(new com.opos.cmn.module.ui.b.d.a() { // from class: com.opos.cmn.module.ui.b.a.c.1.1
                        @Override // com.opos.cmn.module.ui.b.d.a
                        public void a(View view, int[] iArr) {
                            ViewGroup viewGroup;
                            sslErrorHandler.cancel();
                            View viewB2 = c.this.f8052a.b();
                            if (viewB2 != null && (viewGroup = (ViewGroup) viewB2.getParent()) != null && viewGroup.indexOfChild(viewB) > 0) {
                                viewGroup.removeView(viewB);
                            }
                            if (c.this.c != null) {
                                c.this.c.a();
                            }
                        }

                        @Override // com.opos.cmn.module.ui.b.d.a
                        public void b(View view, int[] iArr) {
                            ViewGroup viewGroup;
                            sslErrorHandler.proceed();
                            View viewB2 = c.this.f8052a.b();
                            if (viewB2 == null || (viewGroup = (ViewGroup) viewB2.getParent()) == null || viewGroup.indexOfChild(viewB) <= 0) {
                                return;
                            }
                            viewGroup.removeView(viewB);
                        }
                    });
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.addRule(13);
                    ((ViewGroup) c.this.f8052a.b().getParent()).addView(viewB, layoutParams);
                } catch (Exception e) {
                    com.opos.cmn.an.f.a.c("ComplianceWebView", "", e);
                }
            }
        }).a());
    }

    @Override // com.opos.cmn.module.ui.b.a.a
    public int a() {
        return 0;
    }

    @Override // com.opos.cmn.module.ui.b.a.a
    public View b() {
        return this.f8052a.b();
    }

    @Override // com.opos.cmn.module.ui.b.a.a
    public void c() {
        this.f8052a.a();
    }

    @Override // com.opos.cmn.module.ui.b.a.a
    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f8052a.a(str);
    }
}
