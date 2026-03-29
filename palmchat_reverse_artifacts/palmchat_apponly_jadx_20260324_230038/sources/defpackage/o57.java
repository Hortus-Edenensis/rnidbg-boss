package defpackage;

import android.net.Uri;
import com.umeng.analytics.pro.f;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class o57 {
    public static o57 w;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Uri f19698a;
    public final Uri b;
    public final Uri c;
    public final Uri d;
    public final Uri e;
    public final Uri f;
    public final Uri g;
    public final Uri h;
    public final Uri i;
    public final Uri j;
    public final Uri k;
    public final Uri l;
    public final Uri m;
    public final Uri n;
    public final Uri o;
    public final Uri p;
    public final Uri q;
    public final Uri r;
    public final Uri s;
    public final Uri t;
    public final Uri u;
    public final Uri v;

    public o57(String str) {
        this.f19698a = Uri.parse("content://" + str + ".ZMCdaDataContentProvider/" + f.ax);
        this.b = Uri.parse("content://" + str + ".ZMCdaDataContentProvider/activity_started_count");
        this.c = Uri.parse("content://" + str + ".ZMCdaDataContentProvider/app_start_time");
        this.d = Uri.parse("content://" + str + ".ZMCdaDataContentProvider/app_end_time");
        this.e = Uri.parse("content://" + str + ".ZMCdaDataContentProvider/app_first_start");
        this.f = Uri.parse("content://" + str + ".ZMCdaDataContentProvider/app_end_data");
        this.g = Uri.parse("content://" + str + ".ZMCdaDataContentProvider/sub_process_flush_data");
        this.h = Uri.parse("content://" + str + ".ZMCdaDataContentProvider/zm_data_imei");
        this.i = Uri.parse("content://" + str + ".ZMCdaDataContentProvider/zm_data_imsi");
        this.j = Uri.parse("content://" + str + ".ZMCdaDataContentProvider/zm_data_meid");
        this.k = Uri.parse("content://" + str + ".ZMCdaDataContentProvider/zm_data_iccid");
        this.l = Uri.parse("content://" + str + ".ZMCdaDataContentProvider/zm_data_mac");
        this.m = Uri.parse("content://" + str + ".ZMCdaDataContentProvider/zm_data_sn");
        this.n = Uri.parse("content://" + str + ".ZMCdaDataContentProvider/zm_data_androidid");
        this.o = Uri.parse("content://" + str + ".ZMCdaDataContentProvider/zm_data_oaid");
        this.p = Uri.parse("content://" + str + ".ZMCdaDataContentProvider/zm_data_lat");
        this.q = Uri.parse("content://" + str + ".ZMCdaDataContentProvider/zm_data_lon");
        this.r = Uri.parse("content://" + str + ".ZMCdaDataContentProvider/zm_data_carrier");
        this.s = Uri.parse("content://" + str + ".ZMCdaDataContentProvider/zm_data_nettype");
        Uri.parse("content://" + str + ".ZMCdaDataContentProvider/zm_data_installApp");
        Uri.parse("content://" + str + ".ZMCdaDataContentProvider/zm_data_loginid");
        this.t = Uri.parse("content://" + str + ".ZMCdaDataContentProvider/zm_data_thirdid");
        this.u = Uri.parse("content://" + str + ".ZMCdaDataContentProvider/zm_data_sessionid");
        Uri.parse("content://" + str + ".ZMCdaDataContentProvider/zm_data_pubinfomd5");
        this.v = Uri.parse("content://" + str + ".ZMCdaDataContentProvider/zm_data_remote_config");
    }

    public static o57 a() {
        o57 o57Var = w;
        if (o57Var != null) {
            return o57Var;
        }
        throw new IllegalStateException("The static method getInstance(String packageName) should be called before calling getInstance()");
    }

    public static o57 b(String str) {
        if (w == null) {
            w = new o57(str);
        }
        return w;
    }
}
