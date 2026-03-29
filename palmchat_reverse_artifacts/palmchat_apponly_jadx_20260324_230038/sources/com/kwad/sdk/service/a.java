package com.kwad.sdk.service;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.sdk.DownloadTask;
import com.kwad.sdk.api.proxy.app.DownloadService;
import j$.util.concurrent.ConcurrentHashMap;
import java.lang.ref.WeakReference;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class a extends com.kwad.sdk.m.a {
    private com.kwad.sdk.c bda;
    private Service bdc;
    private final Map<String, Integer> bdb = new ConcurrentHashMap();
    private final HandlerC0635a bdd = new HandlerC0635a(this);

    /* JADX INFO: renamed from: com.kwad.sdk.service.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static class HandlerC0635a extends Handler {
        final WeakReference<a> bde;

        public HandlerC0635a(a aVar) {
            this.bde = new WeakReference<>(aVar);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            a aVar = this.bde.get();
            if (aVar != null && message.what == 1) {
                if (aVar.bda == null || !aVar.bda.Ck()) {
                    sendEmptyMessageDelayed(1, 30000L);
                } else {
                    aVar.bdc.stopSelf();
                }
            }
        }
    }

    private void h(Intent intent) {
        if (intent == null) {
            return;
        }
        try {
            int intExtra = intent.getIntExtra("download_service_type_tag", 0);
            String stringExtra = intent.getStringExtra("download_service_id_tag");
            DownloadTask.DownloadRequest downloadRequest = (DownloadTask.DownloadRequest) intent.getSerializableExtra("download_service_args_tag");
            Integer num = TextUtils.isEmpty(stringExtra) ? null : this.bdb.get(stringExtra);
            int iIntValue = num != null ? num.intValue() : 0;
            if (intExtra == 1) {
                this.bdb.put(stringExtra, Integer.valueOf(this.bda.a(downloadRequest, (com.kwad.sdk.a) null)));
                return;
            }
            if (intExtra == 2) {
                this.bda.pause(iIntValue);
                return;
            }
            if (intExtra == 3) {
                this.bda.resume(iIntValue);
                return;
            }
            if (intExtra != 4) {
                return;
            }
            if (iIntValue != 0) {
                this.bda.cancel(iIntValue);
                return;
            }
            String stringExtra2 = intent.getStringExtra("download_service_path");
            if (stringExtra2 != null) {
                com.kwad.sdk.c.co(stringExtra2);
            }
        } catch (Exception unused) {
        }
    }

    @InvokeBy(invokerClass = c.class, methodId = "initComponentProxyForInvoker")
    public static void register() {
        c.putComponentProxy(DownloadService.class, a.class);
    }

    @Override // com.kwad.sdk.m.a, com.kwad.sdk.api.proxy.IServiceProxy
    public void onCreate(Service service) {
        if (service == null) {
            return;
        }
        this.bdc = service;
        this.bda = com.kwad.sdk.c.Ce();
        this.bdd.sendEmptyMessageDelayed(1, 30000L);
    }

    @Override // com.kwad.sdk.m.a, com.kwad.sdk.api.proxy.IServiceProxy
    public int onStartCommand(Service service, Intent intent, int i, int i2) {
        h(intent);
        return super.onStartCommand(service, intent, i, i2);
    }
}
