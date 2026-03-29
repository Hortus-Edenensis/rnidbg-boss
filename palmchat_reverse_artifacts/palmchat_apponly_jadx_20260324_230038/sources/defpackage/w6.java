package defpackage;

import android.content.Context;
import com.wifi.ad.core.listener.IAdSensitiveTaker;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class w6 implements IAdSensitiveTaker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f21628a;

    public w6(Context context) {
        this.f21628a = context;
    }

    @Override // com.wifi.ad.core.listener.IAdSensitiveTaker
    public String getAppId() {
        return eb4.b();
    }

    @Override // com.wifi.ad.core.listener.IAdSensitiveTaker
    public String getChanId() {
        return ac1.m;
    }

    @Override // com.wifi.ad.core.listener.IAdSensitiveTaker
    public String getDhid() {
        return ac1.h;
    }

    @Override // com.wifi.ad.core.listener.IAdSensitiveTaker
    public String getMediaId() {
        return "ZX0001";
    }
}
