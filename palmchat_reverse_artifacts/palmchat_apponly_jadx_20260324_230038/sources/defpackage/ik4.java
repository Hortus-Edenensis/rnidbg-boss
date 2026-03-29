package defpackage;

import com.wifi.ad.core.config.EventParams;
import com.zenmen.palmchat.contacts.userdetail.polish.PolishView;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class ik4 {
    public static boolean c = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public PolishView f18186a;
    public boolean b = false;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends HashMap<String, String> {
        public a() {
            put(EventParams.KEY_GROUP, gk4.b());
        }
    }

    public ik4(PolishView polishView) {
        this.f18186a = polishView;
    }

    public static void d(boolean z) {
        c = z;
    }

    public void a() {
        PolishView polishView;
        if (this.b && gk4.d() && (polishView = this.f18186a) != null && polishView.getVisibility() == 8) {
            e(false);
        }
    }

    public void b() {
        this.f18186a.setVisibility(8);
    }

    public void c() {
        this.b = true;
        e(true);
    }

    public void e(boolean z) {
        if (gk4.d()) {
            if (z) {
                zn6.h("sign_task", "view", new a());
            }
            this.f18186a.setVisibility(0);
            this.f18186a.update(c);
            c = false;
        }
    }
}
