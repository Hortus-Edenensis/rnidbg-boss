package defpackage;

import com.zenmen.palmchat.contacts.bean.HomeTown;
import com.zenmen.palmchat.extinfo.model.ExtInfoData;
import com.zenmen.palmchat.extinfo.model.OccupationData;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class hs1 {
    public static hs1 b;
    public static js1 c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public tl0 f18040a;

    public hs1() {
        j();
    }

    public static hs1 e() {
        if (b == null) {
            synchronized (hs1.class) {
                if (b == null) {
                    b = new hs1();
                }
            }
        }
        return b;
    }

    public js1 a() {
        if (c == null) {
            c = js1.a(vs0.a().getConfig("user_extrainfo"));
        }
        return c;
    }

    public String b(HomeTown homeTown) {
        if (homeTown == null) {
            return null;
        }
        ArrayList<String> arrayListJ = ap3.a().J(homeTown);
        arrayListJ.get(0);
        return arrayListJ.get(1) + arrayListJ.get(2);
    }

    public List<ExtInfoData> c() {
        return this.f18040a.b();
    }

    public String d(int i) {
        return this.f18040a.a(i);
    }

    public String f(int i) {
        return this.f18040a.c(i);
    }

    public List<ExtInfoData> g() {
        return this.f18040a.d();
    }

    public String h(int i) {
        return this.f18040a.e(i);
    }

    public List<OccupationData> i() {
        return this.f18040a.f();
    }

    public final void j() {
        this.f18040a = new tl0();
    }
}
