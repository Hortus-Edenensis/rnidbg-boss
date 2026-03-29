package defpackage;

import android.text.TextUtils;
import com.ss.android.ttvecamera.BuildConfig;
import com.wifi.ad.core.interactive.WkInteractiveManager;
import com.zenmen.palmchat.c;
import com.zenmen.square.R$string;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class yh5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f22201a;
    public String b;
    public String c;
    public double d;
    public String e;

    public String a() {
        return TextUtils.equals("discover_locationlimits", this.e) ? TextUtils.isEmpty(this.b) ? c.b().getString(R$string.square_bottom_guide_btn_grant) : this.b : TextUtils.equals("discover_locationfunction", this.e) ? TextUtils.isEmpty(this.b) ? c.b().getString(R$string.square_bottom_guide_btn_open) : this.b : "";
    }

    public String b() {
        return TextUtils.equals("discover_locationlimits", this.e) ? TextUtils.isEmpty(this.f22201a) ? c.b().getString(R$string.square_bottom_guide_info_permission) : this.f22201a : TextUtils.equals("discover_locationfunction", this.e) ? TextUtils.isEmpty(this.f22201a) ? c.b().getString(R$string.square_bottom_guide_info_open_location) : this.f22201a : "";
    }

    public long c() {
        if (this.d == 0.0d) {
            this.d = 24.0d;
        }
        return (long) (this.d * 60.0d * 60.0d * 1000.0d);
    }

    public void d(String str) {
        this.e = str;
    }

    public boolean e() {
        if (TextUtils.isEmpty(this.c)) {
            this.c = BuildConfig.USE_CLOUD_CONFIG;
        }
        return !TextUtils.equals(WkInteractiveManager.TimingTypeOff, this.c);
    }
}
