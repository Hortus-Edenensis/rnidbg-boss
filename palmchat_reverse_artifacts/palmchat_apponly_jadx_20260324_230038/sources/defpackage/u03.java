package defpackage;

import android.os.Bundle;
import android.util.Log;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class u03 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f21109a;
    public String b;
    public String c;
    public byte[] d;
    public an2 e;
    public String f;
    public String g;
    public String h;

    /* JADX INFO: compiled from: SearchBox */
    public static class a {
        public static u03 a(Bundle bundle) {
            u03 u03Var = new u03();
            u03Var.f21109a = bundle.getInt("_lxobject_sdkVer");
            u03Var.b = bundle.getString("_lxobject_title");
            u03Var.c = bundle.getString("_lxobject_description");
            u03Var.d = bundle.getByteArray("_lxobject_thumbdata");
            u03Var.f = bundle.getString("_lxobject_mediatagname");
            u03Var.g = bundle.getString("_lxobject_message_action");
            u03Var.h = bundle.getString("_lxobject_message_ext");
            String string = bundle.getString("_lxobject_identifier_");
            if (string != null && string.length() > 0) {
                try {
                    if (string.equals("com.zenmen.palmchat.opensdk.modelmsg.LXImageObject")) {
                        u03Var.e = (an2) t03.class.newInstance();
                    } else if (string.equals("com.zenmen.palmchat.opensdk.modelmsg.LXWebpageObject")) {
                        u03Var.e = (an2) i13.class.newInstance();
                    } else if (string.equals("com.zenmen.palmchat.opensdk.modelmsg.LXTextObject")) {
                        u03Var.e = (an2) f13.class.newInstance();
                    }
                    u03Var.e.unserialize(bundle);
                    return u03Var;
                } catch (Exception e) {
                    Log.e("opensdk.LXMediaMessage", "get media object from bundle failed: unknown ident " + string + ", ex = " + e.getMessage());
                }
            }
            return u03Var;
        }
    }

    public u03() {
        this(null);
    }

    public final int a() {
        an2 an2Var = this.e;
        if (an2Var == null) {
            return 0;
        }
        return an2Var.type();
    }

    public u03(an2 an2Var) {
        this.e = an2Var;
    }
}
