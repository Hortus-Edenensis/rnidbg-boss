package com.huawei.hms.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class he {
    public static final float Code = -1.0f;
    private static final String I = "android.media.VOLUME_CHANGED_ACTION";
    private static final String V = "VolumeChangeObserver";
    private static final String Z = "android.media.EXTRA_VOLUME_STREAM_TYPE";
    private b B;
    private a C;
    private boolean D = false;
    private AudioManager F;
    private Context S;

    /* JADX INFO: compiled from: SearchBox */
    public static class a extends BroadcastReceiver {
        private WeakReference<he> Code;

        public a(he heVar) {
            this.Code = new WeakReference<>(heVar);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            he heVar;
            b bVarI;
            try {
                if (!(("android.media.VOLUME_CHANGED_ACTION".equals(intent.getAction()) && intent.getIntExtra(he.Z, 0) == 3) || intent.getIntExtra(he.Z, 0) == 1) || (heVar = this.Code.get()) == null || (bVarI = heVar.I()) == null) {
                    return;
                }
                bVarI.Code();
            } catch (Throwable th) {
                fh.I(he.V, "onReceive error:" + th.getClass().getSimpleName());
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface b {
        void Code();
    }

    public he(Context context) {
        this.S = context;
        this.F = (AudioManager) context.getApplicationContext().getSystemService("audio");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public b I() {
        return this.B;
    }

    public float Code(boolean z) {
        AudioManager audioManager = this.F;
        if (audioManager != null) {
            return hf.Code(audioManager, z);
        }
        return 0.0f;
    }

    public void V() {
        if (this.D) {
            try {
                this.S.unregisterReceiver(this.C);
            } catch (Exception e) {
                fh.V(V, "unregisterReceiver, " + e.getClass().getSimpleName());
            }
            this.B = null;
            this.D = false;
        }
    }

    public void Code() {
        if (this.C == null) {
            this.C = new a(this);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.media.VOLUME_CHANGED_ACTION");
            try {
                com.huawei.openalliance.ad.utils.z.Code(this.S, this.C, intentFilter);
            } catch (Exception e) {
                fh.V(V, "registerReceiver, " + e.getClass().getSimpleName());
            }
            this.D = true;
        }
    }

    public void Code(b bVar) {
        this.B = bVar;
    }
}
