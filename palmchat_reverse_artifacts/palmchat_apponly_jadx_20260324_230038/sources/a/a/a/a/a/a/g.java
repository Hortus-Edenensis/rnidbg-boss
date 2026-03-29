package a.a.a.a.a.a;

import a.a.a.a.a.a.k.c;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.Network;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public final class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f1056a;
    public final /* synthetic */ a.a.a.a.a.a.j.a b;

    /* JADX INFO: compiled from: SearchBox */
    public static final class a implements c.b {
        public final /* synthetic */ a.a.a.a.a.a.a b;

        public a(a.a.a.a.a.a.a aVar) {
            this.b = aVar;
        }

        @Override // a.a.a.a.a.a.k.c.b
        public final void a(Network network) {
            i iVarB;
            a.a.a.a.a.a.a aVar = this.b;
            Context context = g.this.f1056a;
            synchronized (aVar) {
                Intrinsics.checkNotNullParameter(context, "context");
                if (aVar.d.f1054a) {
                    if (Intrinsics.areEqual(aVar.b.b, "-11128")) {
                        SharedPreferences sharedPreferences = context.getSharedPreferences("sp_name_bd_convert_uid_0", 0);
                        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "context.getSharedPrefere…t\", Context.MODE_PRIVATE)");
                        long j = sharedPreferences.getLong(aVar.a() + "uid_time", 0L);
                        if (j != 0 && System.currentTimeMillis() - j < aVar.f1051a) {
                            String string = sharedPreferences.getString(aVar.a() + "uid_carrier", aVar.b.c);
                            String string2 = sharedPreferences.getString(aVar.a() + "uid_vendor", aVar.b.d);
                            String string3 = sharedPreferences.getString(aVar.a() + "uid_errCode", aVar.b.b);
                            String string4 = sharedPreferences.getString(aVar.a() + "uid_token", aVar.b.f1060a);
                            String string5 = sharedPreferences.getString(aVar.a() + "uid_province", aVar.b.f);
                            i iVar = aVar.b;
                            iVar.f1060a = string4;
                            iVar.b = string3;
                            iVar.d = string2;
                            iVar.c = string;
                            iVar.e = 0;
                            iVar.f = string5;
                            iVar.g = System.currentTimeMillis();
                        }
                    }
                    iVarB = (System.currentTimeMillis() - aVar.b.g <= aVar.f1051a && !TextUtils.isEmpty(aVar.b.f1060a)) ? aVar.b : aVar.b(context, network);
                } else {
                    iVarB = new i("101128");
                }
            }
            a.a.a.a.a.a.k.c cVarA = a.a.a.a.a.a.k.c.a(g.this.f1056a);
            synchronized (cVarA) {
                ConnectivityManager connectivityManager = cVarA.b;
                if (connectivityManager != null) {
                    try {
                        ConnectivityManager.NetworkCallback networkCallback = cVarA.d;
                        if (networkCallback != null) {
                            connectivityManager.unregisterNetworkCallback(networkCallback);
                            cVarA.d = null;
                            cVarA.c = null;
                        }
                    } catch (Exception unused) {
                    }
                }
            }
            a.a.a.a.a.a.j.a aVar2 = g.this.b;
            if (aVar2 != null) {
                aVar2.a(iVarB);
            }
        }
    }

    public g(Context context, a.a.a.a.a.a.j.a aVar) {
        this.f1056a = context;
        this.b = aVar;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0033  */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void run() {
        a.a.a.a.a.a.j.a aVar;
        i iVar;
        String str;
        try {
            String strA = h.a(h.c, this.f1056a);
            if (Intrinsics.areEqual(strA, "41128")) {
                TelephonyManager telephonyManager = (TelephonyManager) this.f1056a.getSystemService("phone");
                String simOperator = telephonyManager.getSimOperator();
                if (telephonyManager.getSimState() != 5) {
                    simOperator = "";
                }
                simOperator.hashCode();
                switch (simOperator) {
                    case "46000":
                    case "46002":
                    case "46004":
                    case "46007":
                    case "46008":
                        str = "1";
                        break;
                    case "46001":
                    case "46006":
                    case "46009":
                        str = "3";
                        break;
                    case "46003":
                    case "46005":
                    case "46011":
                        str = "2";
                        break;
                    default:
                        str = "0";
                        break;
                }
                a.a.a.a.a.a.a aVar2 = (a.a.a.a.a.a.a) ((Map) h.b.getValue()).get(str);
                if (aVar2 != null) {
                    if (Intrinsics.areEqual(aVar2.b.b, "-11128")) {
                        a.a.a.a.a.a.k.c.a(this.f1056a).a(new a(aVar2));
                        return;
                    }
                    a.a.a.a.a.a.j.a aVar3 = this.b;
                    if (aVar3 != null) {
                        aVar3.a(aVar2.b);
                        return;
                    }
                    return;
                }
                aVar = this.b;
                if (aVar == null) {
                    return;
                } else {
                    iVar = new i("11128");
                }
            } else {
                a.a.a.a.a.a.j.a aVar4 = this.b;
                if (aVar4 == null) {
                    return;
                }
                i iVar2 = new i(strA);
                aVar = aVar4;
                iVar = iVar2;
            }
            aVar.a(iVar);
        } catch (Exception e) {
            a.a.a.a.a.a.j.a aVar5 = this.b;
            if (aVar5 != null) {
                String message = e.getMessage();
                if (message == null) {
                    message = "unknow";
                }
                aVar5.a(new i(message));
            }
        }
    }
}
