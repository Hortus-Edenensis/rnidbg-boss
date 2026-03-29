package com.opos.cmn.biz.web.a.a;

import android.content.Context;
import android.webkit.MimeTypeMap;
import android.webkit.WebResourceResponse;
import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class b implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f7890a;
    private volatile boolean b = false;
    private com.opos.cmn.biz.web.a.b.b c;
    private ThreadPoolExecutor d;

    private void b(List<com.opos.cmn.biz.web.a.b.a> list) {
        com.opos.cmn.biz.web.a.a.a.a.a().a(list);
    }

    @Override // com.opos.cmn.biz.web.a.a.a
    public WebResourceResponse a(String str) {
        if (!this.b) {
            return null;
        }
        try {
            File file = new File(com.opos.cmn.biz.web.a.a.a.a.a(this.f7890a, str));
            if (!file.exists()) {
                return null;
            }
            return new WebResourceResponse(MimeTypeMap.getSingleton().getMimeTypeFromExtension(MimeTypeMap.getFileExtensionFromUrl(str)), "", new FileInputStream(file));
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("WebViewCacheImpl", "loadResourceFormLocalCache url:" + str, e);
            return null;
        }
    }

    @Override // com.opos.cmn.biz.web.a.a.a
    public void a(Context context, com.opos.cmn.biz.web.a.b.b bVar) {
        if (this.b) {
            return;
        }
        this.f7890a = context.getApplicationContext();
        this.c = bVar;
        int i = this.c.b;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i, i, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new com.opos.cmn.biz.web.a.a.b.b("web_cache"), new ThreadPoolExecutor.DiscardPolicy());
        this.d = threadPoolExecutor;
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        com.opos.cmn.biz.web.a.a.a.a.a().a(this.f7890a, this.c.f7895a);
        this.b = true;
    }

    @Override // com.opos.cmn.biz.web.a.a.a
    public void a(List<com.opos.cmn.biz.web.a.b.a> list) {
        if (!this.b) {
            com.opos.cmn.an.f.a.c("WebViewCacheImpl", "please call init first");
        } else {
            if (this.f7890a == null || list == null || list.size() <= 0) {
                return;
            }
            b(list);
        }
    }
}
