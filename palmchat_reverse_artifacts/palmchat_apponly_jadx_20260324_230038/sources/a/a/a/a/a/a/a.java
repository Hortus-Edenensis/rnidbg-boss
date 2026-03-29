package a.a.a.a.a.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Network;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f1051a;
    public i b;
    public final ArrayList<a.a.a.a.a.a.j.b> c;
    public final e d;

    public a(e config) {
        Intrinsics.checkNotNullParameter(config, "config");
        this.d = config;
        this.f1051a = config.a();
        this.b = new i("-11128");
        this.c = new ArrayList<>();
    }

    public abstract i a(Context context, Network network);

    public abstract String a();

    public final i b(Context context, Network network) {
        i iVarA = a(context, network);
        Intrinsics.checkNotNullParameter(iVarA, "<set-?>");
        this.b = iVarA;
        SharedPreferences sharedPreferences = context.getSharedPreferences("sp_name_bd_convert_uid_" + iVarA.e, 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "context.getSharedPrefere…}\", Context.MODE_PRIVATE)");
        sharedPreferences.edit().putString(a() + "uid_carrier", iVarA.c).putString(a() + "uid_vendor", iVarA.d).putString(a() + "uid_errCode", iVarA.b).putString(a() + "uid_token", iVarA.f1060a).putString(a() + "uid_province", iVarA.f).putLong(a() + "uid_time", System.currentTimeMillis()).apply();
        for (a.a.a.a.a.a.j.b bVar : this.c) {
            i iVar = this.b;
            bVar.a(iVar, Intrinsics.areEqual(iVar.b, "01128"));
        }
        return iVarA;
    }
}
