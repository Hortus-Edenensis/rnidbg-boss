package com.bytedance.sdk.openadsdk.core.k.u.nr;

import android.content.Context;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.os.Build;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u {
    private final AudioManager nr;
    private int u = -1;
    private int fx = -1;
    private int b = -1;
    private final int pn = 15;
    private final int iz = 0;

    public u(Context context) {
        this.nr = (AudioManager) context.getApplicationContext().getSystemService("audio");
    }

    private boolean iz() {
        return this.nr.isWiredHeadsetOn() && this.nr.isBluetoothA2dpOn();
    }

    private boolean pn() {
        for (AudioDeviceInfo audioDeviceInfo : this.nr.getDevices(3)) {
            int type = audioDeviceInfo.getType();
            if (type == 3 || type == 4 || type == 8 || type == 7) {
                return true;
            }
        }
        return false;
    }

    public boolean b() {
        return Build.VERSION.SDK_INT < 31 ? iz() : pn();
    }

    public int fx() {
        try {
            AudioManager audioManager = this.nr;
            if (audioManager != null) {
                return audioManager.getStreamVolume(3);
            }
            return -1;
        } catch (Throwable unused) {
            return -1;
        }
    }

    public int nr() {
        try {
            int i = this.fx;
            if (i != -1) {
                return i;
            }
            AudioManager audioManager = this.nr;
            int streamMaxVolume = audioManager != null ? audioManager.getStreamMaxVolume(3) : 15;
            this.fx = streamMaxVolume;
            return streamMaxVolume;
        } catch (Throwable unused) {
            return 15;
        }
    }

    public int u() {
        try {
            int i = this.b;
            if (i != -1) {
                return i;
            }
            if (Build.VERSION.SDK_INT >= 28) {
                AudioManager audioManager = this.nr;
                this.b = audioManager != null ? audioManager.getStreamMinVolume(3) : 0;
            } else {
                this.b = 0;
            }
            return this.b;
        } catch (Throwable unused) {
            return 0;
        }
    }

    public int u(int i) {
        AudioManager audioManager = this.nr;
        if (audioManager == null) {
            return -1;
        }
        audioManager.setStreamVolume(3, i, 0);
        fx();
        return i;
    }
}
