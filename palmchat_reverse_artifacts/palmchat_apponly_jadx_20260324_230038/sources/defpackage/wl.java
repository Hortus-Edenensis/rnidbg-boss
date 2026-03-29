package defpackage;

import com.ss.bytertc.audio.device.router.AudioRouteDeviceManager;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public final /* synthetic */ class wl implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AudioRouteDeviceManager f21743a;

    public /* synthetic */ wl(AudioRouteDeviceManager audioRouteDeviceManager) {
        this.f21743a = audioRouteDeviceManager;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f21743a.bluetoothScoConnectionCheck();
    }
}
