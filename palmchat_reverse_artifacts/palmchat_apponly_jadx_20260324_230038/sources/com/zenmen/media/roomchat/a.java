package com.zenmen.media.roomchat;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class a {
    public static final BroadcastReceiver b = new C0934a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<b> f11969a = new ArrayList();

    /* JADX INFO: renamed from: com.zenmen.media.roomchat.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public class C0934a extends BroadcastReceiver {
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            try {
                c.f11970a.b(intent);
            } catch (ExceptionInInitializerError unused) {
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface b {
        void k0(Intent intent);
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f11970a = new a();
    }

    public a() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("INTENT_ACTION_FLOATVIEW_CLICK");
        intentFilter.addAction("INTENT_ACTION_OPEN_UI_ACTIVITY");
        intentFilter.addAction("INTENT_ACTION_UPDATE_CALLING_DURATION");
        intentFilter.addAction("INTENT_ACTION_GROUPLOAD_FINISH");
        intentFilter.addAction("INTENT_ACTION_GROUPLOAD_MEMBER_INACTIVE");
        intentFilter.addAction("INTENT_ACTION_USER_LIST_FOR_SELECTION_UPDATE");
        intentFilter.addAction("INTENT_ACTION_CALL_FINISH");
        c(intentFilter);
    }

    public static void d(b bVar) {
        if (bVar == null) {
            return;
        }
        try {
            if (c.f11970a.f11969a.contains(bVar)) {
                return;
            }
            c.f11970a.f11969a.add(bVar);
        } catch (ExceptionInInitializerError unused) {
        }
    }

    public static void e(Intent intent) {
        LocalBroadcastManager.getInstance(RTCParameters.c()).sendBroadcast(intent);
    }

    public static void f(b bVar) {
        if (bVar == null) {
            return;
        }
        try {
            if (c.f11970a.f11969a == null) {
                return;
            }
            c.f11970a.f11969a.remove(bVar);
        } catch (ExceptionInInitializerError unused) {
        }
    }

    public final void b(Intent intent) {
        try {
            Iterator<b> it = this.f11969a.iterator();
            while (it.hasNext()) {
                it.next().k0(intent);
            }
        } catch (Exception unused) {
        }
    }

    public void c(IntentFilter intentFilter) {
        LocalBroadcastManager.getInstance(RTCParameters.c()).registerReceiver(b, intentFilter);
    }

    public void finalize() throws Throwable {
        g();
        super.finalize();
    }

    public void g() {
        LocalBroadcastManager.getInstance(RTCParameters.c()).unregisterReceiver(b);
    }
}
