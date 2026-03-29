package defpackage;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class bx6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<String> f1848a;
    public static final String[] b;

    static {
        ArrayList arrayList = new ArrayList();
        f1848a = arrayList;
        arrayList.add("com.snda.wifilocating");
        arrayList.add("com.snda.lantern.wifilocating");
        b = new String[]{".wft.caller.Trans", ".wft.caller.Empty", ".wft.caller.Enh"};
    }

    public static String a(Context context) {
        return (context == null || na7.j(context.getApplicationContext())) ? "http://wifi3a.51y5.net/config/fa.sec" : "https://appinvoke.51y5.net/alps/fa.sec";
    }
}
