package defpackage;

import com.apm.lite.AttachUserData;
import com.apm.lite.CrashType;
import com.apm.lite.ICrashFilter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class yu6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<CrashType, List<AttachUserData>> f22283a = new HashMap();
    public Map<CrashType, List<AttachUserData>> b = new HashMap();
    public Map<String, String> c = new HashMap();
    public ICrashFilter d = null;

    public List<AttachUserData> a(CrashType crashType) {
        return this.f22283a.get(crashType);
    }

    public Map<String, String> b() {
        return this.c;
    }

    public ICrashFilter c() {
        return this.d;
    }

    public List<AttachUserData> d(CrashType crashType) {
        return this.b.get(crashType);
    }
}
