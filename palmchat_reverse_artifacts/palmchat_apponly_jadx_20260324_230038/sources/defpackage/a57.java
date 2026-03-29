package defpackage;

import android.os.Environment;
import android.text.TextUtils;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class a57 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f1158a;
    public static final String b;

    static {
        String str = Environment.getExternalStorageDirectory() + "/.android";
        f1158a = str;
        b = str + "/.system_sdk_udid.dt";
    }

    public static boolean a() {
        String externalStorageState = Environment.getExternalStorageState();
        return (TextUtils.isEmpty(externalStorageState) || !externalStorageState.equals("mounted") || Environment.getExternalStorageDirectory() == null) ? false : true;
    }
}
