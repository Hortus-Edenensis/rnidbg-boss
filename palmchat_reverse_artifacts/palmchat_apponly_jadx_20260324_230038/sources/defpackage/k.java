package defpackage;

import android.content.Context;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f18539a;
    public InputStream c;
    public h b = h.b;
    public final Map<String, String> d = new HashMap();
    public final List<z55> e = new ArrayList();

    public j a(Context context) {
        return new e17(context, this.f18539a, this.b, this.c, this.d, this.e, null);
    }

    public k b(InputStream inputStream) {
        this.c = inputStream;
        return this;
    }
}
