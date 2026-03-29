package com.zenmen.palmchat.videocall;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.PowerManager;
import android.text.TextUtils;
import com.afollestad.materialdialogs.MaterialDialog;
import com.zenmen.media.rtc.ZMRtcMediaType;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.hx3;
import defpackage.jp2;
import defpackage.pa6;
import defpackage.rb1;
import defpackage.sd3;
import defpackage.sy5;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class c implements SensorEventListener {
    public static c f = new c();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SensorManager f15861a;
    public PowerManager b = null;
    public PowerManager.WakeLock c = null;
    public BroadcastReceiver d = null;
    public e e;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements DialogInterface.OnCancelListener {
        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            LogUtil.onClickEvent("79", null, null);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends MaterialDialog.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f15862a;

        public b(d dVar) {
            this.f15862a = dVar;
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onNegative(MaterialDialog materialDialog) {
            super.onNegative(materialDialog);
            LogUtil.onClickEvent("79", null, null);
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            super.onPositive(materialDialog);
            d dVar = this.f15862a;
            if (dVar != null) {
                dVar.a();
            }
        }
    }

    /* JADX INFO: renamed from: com.zenmen.palmchat.videocall.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public class C1130c extends BroadcastReceiver {
        public C1130c() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (!action.equals("android.intent.action.SCREEN_OFF") && action.equals("android.intent.action.SCREEN_ON") && c.this.c.isHeld()) {
                c.this.c.release();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface d {
        void a();
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface e {
        void a(int i);
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class f implements jp2 {
    }

    public static void b(Context context, int i, d dVar) {
        if (!hx3.m(context)) {
            new sd3(context).T(R.string.dialog_note).j(R.string.dialog_video_call_network_not_exist).O(R.string.alert_dialog_ok).e().show();
            return;
        }
        if (!hx3.n() && i == 0) {
            new sd3(context).T(R.string.dialog_note).j(R.string.dialog_video_call_network).K(R.string.alert_dialog_cancel).O(R.string.alert_dialog_ok).f(new b(dVar)).g(new a()).e().show();
        } else if (dVar != null) {
            dVar.a();
        }
    }

    public static c c() {
        return f;
    }

    public static boolean e() {
        return true;
    }

    public static boolean f() {
        return h(true);
    }

    public static boolean g(Context context, String str) {
        boolean z = pa6.p().z();
        boolean zA0 = com.zenmen.media.roomchatdemo.videocallgroup.d.P().a0("isWorking-2");
        boolean z2 = z || zA0;
        if (zA0) {
            sy5.b();
            sy5.f(AppContext.getContext(), AppContext.getContext().getResources().getString(R.string.toast_call_voice_can_not_created), 0).g();
        } else if (z) {
            if (TextUtils.isEmpty(str) || !str.equals(pa6.p().l())) {
                sy5.b();
                if (ZMRtcMediaType.RtcMedia_Video == pa6.p().m()) {
                    sy5.f(AppContext.getContext(), AppContext.getContext().getResources().getString(R.string.toast_call_video_can_not_created), 0).g();
                } else if (ZMRtcMediaType.RtcMedia_Audio == pa6.p().m()) {
                    sy5.f(AppContext.getContext(), AppContext.getContext().getResources().getString(R.string.toast_call_voice_can_not_created), 0).g();
                } else {
                    sy5.f(AppContext.getContext(), AppContext.getContext().getResources().getString(R.string.toast_call_other), 0).g();
                }
            } else {
                Intent intent = new Intent(context, (Class<?>) VideoCallActivity.class);
                intent.addFlags(268435456);
                context.startActivity(intent);
            }
        }
        return z2;
    }

    public static boolean h(boolean z) {
        boolean z2 = pa6.p().z();
        boolean zA0 = com.zenmen.media.roomchatdemo.videocallgroup.d.P().a0("isWorking-1");
        boolean z3 = z2 || zA0;
        if (z) {
            if (zA0) {
                sy5.b();
                sy5.f(AppContext.getContext(), AppContext.getContext().getResources().getString(R.string.manychats_voice_call_isworking), 0).g();
            } else if (z2) {
                sy5.b();
                if (ZMRtcMediaType.RtcMedia_Video == pa6.p().m()) {
                    sy5.f(AppContext.getContext(), AppContext.getContext().getResources().getString(R.string.toast_call_video), 0).g();
                } else if (ZMRtcMediaType.RtcMedia_Audio == pa6.p().m()) {
                    sy5.f(AppContext.getContext(), AppContext.getContext().getResources().getString(R.string.toast_call_voice), 0).g();
                } else {
                    sy5.f(AppContext.getContext(), AppContext.getContext().getResources().getString(R.string.toast_call_other), 0).g();
                }
            }
        }
        return z3;
    }

    public static boolean i() {
        return pa6.p().z();
    }

    public static boolean j() {
        return com.zenmen.media.roomchatdemo.videocallgroup.d.P().a0("isWorking2");
    }

    public void d(e eVar) {
        this.f15861a = (SensorManager) AppContext.getContext().getSystemService("sensor");
        PowerManager powerManager = (PowerManager) AppContext.getContext().getSystemService("power");
        this.b = powerManager;
        PowerManager.WakeLock wakeLockNewWakeLock = powerManager.newWakeLock(32, "lianxin:VideoCallUtils");
        this.c = wakeLockNewWakeLock;
        wakeLockNewWakeLock.setReferenceCounted(false);
        this.e = eVar;
        if (this.d == null) {
            try {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.intent.action.SCREEN_OFF");
                intentFilter.addAction("android.intent.action.SCREEN_ON");
                this.d = new C1130c();
                if (AppContext.getContext() != null) {
                    AppContext.getContext().registerReceiver(this.d, intentFilter);
                }
            } catch (Exception unused) {
            }
        }
    }

    public void k() {
        SensorManager sensorManager = this.f15861a;
        sensorManager.registerListener(this, sensorManager.getDefaultSensor(8), 3);
    }

    public void l() {
        if (this.d != null) {
            try {
                if (AppContext.getContext() != null) {
                    AppContext.getContext().unregisterReceiver(this.d);
                }
                this.d = null;
            } catch (Exception unused) {
            }
        }
    }

    public void m() {
        if (this.f15861a != null) {
            this.c.release();
            this.f15861a.unregisterListener(this);
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.values == null || sensorEvent.sensor.getType() != 8) {
            return;
        }
        if (r0[0] != 0.0d) {
            e eVar = this.e;
            if (eVar != null) {
                eVar.a(0);
            }
            if (this.c.isHeld()) {
                return;
            }
            this.c.release();
            return;
        }
        if (rb1.a(AppContext.getContext())) {
            return;
        }
        e eVar2 = this.e;
        if (eVar2 != null) {
            eVar2.a(1);
        }
        if (this.c.isHeld()) {
            return;
        }
        this.c.acquire();
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }
}
