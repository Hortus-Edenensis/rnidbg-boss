package com.ss.android.socialbase.downloader.downloader;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.igexin.sdk.PushConsts;
import com.ss.android.socialbase.downloader.notification.DownloadNotificationService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class DownloadReceiver extends BroadcastReceiver {
    private static final String u = "DownloadReceiver";

    private void nr(final Context context, final String str) {
        fx.u(new Runnable() { // from class: com.ss.android.socialbase.downloader.downloader.DownloadReceiver.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Intent intent = new Intent(context, (Class<?>) DownloadNotificationService.class);
                    intent.setAction(str);
                    if (com.ss.android.socialbase.downloader.n.u.fx().nr("enable_target_34") > 0) {
                        com.ss.android.socialbase.downloader.x.u.u().u(intent);
                    } else {
                        context.startService(intent);
                    }
                } catch (Throwable unused) {
                }
            }
        });
    }

    private void u(final Context context, final String str) {
        if (fx.pb()) {
            fx.u(new Runnable() { // from class: com.ss.android.socialbase.downloader.downloader.DownloadReceiver.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        Intent intent = new Intent(context, (Class<?>) DownloadNotificationService.class);
                        intent.setAction(str);
                        if (com.ss.android.socialbase.downloader.n.u.fx().nr("enable_target_34") > 0) {
                            com.ss.android.socialbase.downloader.x.u.u().u(intent);
                        } else {
                            context.startService(intent);
                        }
                    } catch (Throwable unused) {
                    }
                }
            }, 2000L, TimeUnit.MILLISECONDS);
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (context == null || intent == null) {
            return;
        }
        String action = intent.getAction();
        if (TextUtils.isEmpty(action)) {
            return;
        }
        if (action.equals(PushConsts.ACTION_BROADCAST_NETWORK_CHANGE)) {
            if (com.ss.android.socialbase.downloader.fx.u.u()) {
                com.ss.android.socialbase.downloader.fx.u.u(u, "Received broadcast intent for android.net.conn.CONNECTIVITY_CHANGE");
            }
            u(context, action);
        } else if (action.equals("android.intent.action.MEDIA_UNMOUNTED") || action.equals("android.intent.action.MEDIA_REMOVED") || action.equals("android.intent.action.MEDIA_BAD_REMOVAL") || action.equals("android.intent.action.MEDIA_EJECT")) {
            nr(context, action);
        }
    }
}
