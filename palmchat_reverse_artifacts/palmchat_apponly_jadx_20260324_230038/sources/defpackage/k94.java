package defpackage;

import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import com.zenmen.palmchat.utils.MdidSdkConfigHelper;
import com.zenmen.palmchat.utils.log.LogUtil;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class k94 {

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f18602a;

        public a(Context context) {
            this.f18602a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            k94.b(this.f18602a);
        }
    }

    public static void a(Context context) {
        if ("oppo".equals(Build.MANUFACTURER.toLowerCase())) {
            new g13(new a(context)).start();
        }
    }

    public static void b(Context context) {
        if (TextUtils.isEmpty(SPUtil.f14322a.n(SPUtil.SCENE.APP_COMMON, "key_oppo_track_ref", ""))) {
            String strC = c(context);
            if (TextUtils.isEmpty(strC)) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("key_track_ref", strC);
                jSONObject.put("oaid", MdidSdkConfigHelper.getInstance().getOAID());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            LogUtil.uploadInfoImmediate("OPPO-gy-01", null, null, jSONObject.toString());
            SPUtil.f14322a.t(SPUtil.SCENE.APP_COMMON, "key_oppo_track_ref", strC);
        }
    }

    public static String c(Context context) {
        ContentProviderClient contentProviderClientAcquireUnstableContentProviderClient;
        String str;
        ContentProviderClient contentProviderClient = null;
        str = null;
        str = null;
        String str2 = null;
        string = null;
        String string = null;
        try {
            ContentResolver contentResolver = context.getContentResolver();
            if (contentResolver != null) {
                contentProviderClientAcquireUnstableContentProviderClient = contentResolver.acquireUnstableContentProviderClient(Uri.parse("content://com.heytap.market.TrackProvider"));
                if (contentProviderClientAcquireUnstableContentProviderClient != null) {
                    try {
                        Bundle bundleCall = contentProviderClientAcquireUnstableContentProviderClient.call("getTrackRef", null, null);
                        if (bundleCall != null) {
                            string = bundleCall.getString("key_track_ref");
                        }
                    } catch (Throwable th) {
                        th = th;
                        try {
                            th.printStackTrace();
                            if (contentProviderClientAcquireUnstableContentProviderClient != null) {
                                try {
                                    contentProviderClientAcquireUnstableContentProviderClient.release();
                                } catch (Throwable unused) {
                                }
                            }
                        } catch (Throwable th2) {
                            if (contentProviderClientAcquireUnstableContentProviderClient != null) {
                                try {
                                    contentProviderClientAcquireUnstableContentProviderClient.release();
                                } catch (Throwable unused2) {
                                }
                            }
                            throw th2;
                        }
                    }
                }
                String str3 = string;
                contentProviderClient = contentProviderClientAcquireUnstableContentProviderClient;
                str = str3;
            } else {
                str = null;
            }
            if (contentProviderClient != null) {
                try {
                    contentProviderClient.release();
                } catch (Throwable unused3) {
                }
            }
            str2 = str;
        } catch (Throwable th3) {
            th = th3;
            contentProviderClientAcquireUnstableContentProviderClient = null;
        }
        LogUtil.i("OppoInstallInfoOperator", "getTrackRef" + str2);
        return str2;
    }
}
