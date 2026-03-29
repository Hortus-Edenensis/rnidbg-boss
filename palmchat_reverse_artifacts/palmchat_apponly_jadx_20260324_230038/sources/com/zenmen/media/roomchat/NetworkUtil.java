package com.zenmen.media.roomchat;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import androidx.annotation.RequiresPermission;
import com.afollestad.materialdialogs.MaterialDialog;
import com.afollestad.materialdialogs.Theme;
import com.kuaishou.weapon.p0.g;
import com.oplus.tblplayer.misc.MediaInfo;
import com.zenmen.palmchat.R;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class NetworkUtil {

    /* JADX INFO: compiled from: SearchBox */
    public enum NetworkType {
        NETWORK_WIFI("WiFi"),
        NETWORK_4G("4G"),
        NETWORK_2G("2G"),
        NETWORK_3G("3G"),
        NETWORK_UNKNOWN(MediaInfo.RENDERER_TYPE_UNKNOWN),
        NETWORK_NO("No network");

        private String desc;

        NetworkType(String str) {
            this.desc = str;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.desc;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a extends MaterialDialog.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f11959a;

        public a(c cVar) {
            this.f11959a = cVar;
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onNegative(MaterialDialog materialDialog) {
            super.onNegative(materialDialog);
            c cVar = this.f11959a;
            if (cVar != null) {
                cVar.onStop();
            }
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            super.onPositive(materialDialog);
            c cVar = this.f11959a;
            if (cVar != null) {
                cVar.a();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends MaterialDialog.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f11960a;

        public b(c cVar) {
            this.f11960a = cVar;
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onNegative(MaterialDialog materialDialog) {
            super.onNegative(materialDialog);
            c cVar = this.f11960a;
            if (cVar != null) {
                cVar.onStop();
            }
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            super.onPositive(materialDialog);
            c cVar = this.f11960a;
            if (cVar != null) {
                cVar.a();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface c {
        void a();

        void onStop();
    }

    public static boolean a() {
        return e(RTCParameters.c()) != NetworkType.NETWORK_NO;
    }

    public static void b(Context context, c cVar) {
        if (!a()) {
            new MaterialDialog.d(context).S(Theme.LIGHT).d(R.color.manychats_materialdialog_background_color).m(R.color.manychats_materialdialog_content_color).N(R.color.manychats_materialdialog_positive_color).J(R.color.manychats_materialdialog_negative_color).W(R.color.manychats_materialdialog_title_color).t(R.color.manychats_materialdialog_vivider_color).T(R.string.manychats_dialog_note).j(R.string.manychats_video_call_group_network_disconnect).O(R.string.manychats_alert_dialog_ok).f(new b(cVar)).h(false).e().show();
        } else if (cVar != null) {
            cVar.a();
        }
    }

    public static void c(Context context, c cVar) {
        if (e(RTCParameters.c()) != NetworkType.NETWORK_WIFI) {
            new MaterialDialog.d(context).S(Theme.LIGHT).d(R.color.manychats_materialdialog_background_color).m(R.color.manychats_materialdialog_content_color).N(R.color.manychats_materialdialog_positive_color).J(R.color.manychats_materialdialog_negative_color).W(R.color.manychats_materialdialog_title_color).t(R.color.manychats_materialdialog_vivider_color).T(R.string.manychats_dialog_note).j(R.string.manychats_dialog_video_call_network).K(R.string.manychats_alert_dialog_cancel).O(R.string.manychats_alert_dialog_ok).f(new a(cVar)).h(false).e().show();
        } else if (cVar != null) {
            cVar.a();
        }
    }

    @RequiresPermission(g.b)
    public static NetworkInfo d(Context context) {
        if (context != null) {
            return ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        }
        return null;
    }

    @RequiresPermission(g.b)
    public static NetworkType e(Context context) {
        NetworkType networkType;
        NetworkType networkType2 = NetworkType.NETWORK_NO;
        NetworkInfo networkInfoD = d(context);
        if (networkInfoD == null || !networkInfoD.isAvailable()) {
            return networkType2;
        }
        if (networkInfoD.getType() == 1) {
            return NetworkType.NETWORK_WIFI;
        }
        if (networkInfoD.getType() != 0) {
            return NetworkType.NETWORK_UNKNOWN;
        }
        switch (networkInfoD.getSubtype()) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
            case 16:
                networkType = NetworkType.NETWORK_2G;
                break;
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
            case 17:
                networkType = NetworkType.NETWORK_3G;
                break;
            case 13:
            case 18:
                networkType = NetworkType.NETWORK_4G;
                break;
            default:
                String subtypeName = networkInfoD.getSubtypeName();
                networkType = (!subtypeName.equalsIgnoreCase("TD-SCDMA") && !subtypeName.equalsIgnoreCase("WCDMA") && !subtypeName.equalsIgnoreCase("CDMA2000")) ? NetworkType.NETWORK_UNKNOWN : NetworkType.NETWORK_3G;
                break;
        }
        return networkType;
    }
}
