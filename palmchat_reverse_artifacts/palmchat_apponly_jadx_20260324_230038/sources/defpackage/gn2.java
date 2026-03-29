package defpackage;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Pair;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.contacts.bean.HomeTown;
import com.zenmen.palmchat.framework.FrameworkBaseActivity;
import com.zenmen.palmchat.rtc.bean.RoomUserInfo;
import java.util.ArrayList;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public interface gn2 {

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void onFinish();
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface b {
        void onFinish(int i);
    }

    boolean A();

    void B(Context context, String str);

    boolean C();

    String D();

    void E();

    boolean F();

    void G(FrameworkBaseActivity frameworkBaseActivity, String str);

    void H(Activity activity, String str, String str2, int i, String str3, String str4);

    void I(Context context, String str);

    ArrayList<String> J(HomeTown homeTown);

    void K(a aVar);

    long L(String str);

    boolean M();

    Object N(Object obj);

    boolean O(String str);

    void P(Activity activity, String str, int i, String str2);

    yl2 Q();

    boolean R(Context context, String str);

    void S();

    np2 T();

    String U();

    void V(Context context, String str, String str2, boolean z);

    String W();

    void X(uk5 uk5Var);

    Pair<Integer, String> Y(Exception exc);

    void Z(String str);

    boolean a();

    void a0(FrameworkBaseActivity frameworkBaseActivity, String str);

    int b(Context context);

    ik2 b0();

    void c(Activity activity, ArrayList<RoomUserInfo> arrayList);

    void d(Context context, String str, String str2);

    boolean e(Throwable th);

    void f(Context context, String str, String str2, String str3);

    boolean g(Context context, String str);

    void h(Activity activity, String str, String str2, int i);

    boolean i();

    JSONObject j();

    void k();

    void l(Activity activity, Bundle bundle);

    void m(Activity activity, ContactInfoItem contactInfoItem, int i);

    String n(String str, String str2);

    String o();

    boolean p(Context context, String str, long j, int i);

    void q(b bVar);

    void r(Context context, String str);

    String s(ContactInfoItem contactInfoItem);

    xk3 t();

    boolean u();

    void v(int i);

    void w(Context context, String str, String str2);

    lo2 x();

    void y(Activity activity, int i, int i2, boolean z, int i3);

    void z(Context context, int i, int i2, String str, int i3, int i4, yo3 yo3Var);
}
