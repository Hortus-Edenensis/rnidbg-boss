package defpackage;

import android.app.Activity;
import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.zenmen.palmchat.chat.ChatItem;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.location.LocationEx;
import com.zenmen.square.bean.SquareContactBean;
import com.zenmen.square.fragment.online.OnLineDetailData;
import com.zenmen.square.mvp.model.bean.SquareFeed;
import com.zenmen.square.tag.bean.SquareTagBean;
import com.zenmen.square.topic.bean.TopicListBean;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public interface ro2 {

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void onCancel();

        void onSuccess();
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface b {
        void a(ContactInfoItem contactInfoItem);

        void onError(String str);
    }

    void A(Activity activity, ArrayList<ContactInfoItem> arrayList, ArrayList<ContactInfoItem> arrayList2, int i);

    void B(Activity activity, ContactInfoItem contactInfoItem, String str);

    int C(int i);

    void D(Context context, LocationEx locationEx, SquareFeed squareFeed, int i);

    void E(int i, Context context, ContactInfoItem contactInfoItem);

    boolean F();

    void G(Activity activity);

    void H(Activity activity, JSONObject jSONObject, int i);

    void I(Activity activity, int i, int i2, int i3, long j);

    void J(String str, b bVar);

    void K(Context context, int i, SquareFeed squareFeed);

    String L();

    void M(FragmentActivity fragmentActivity);

    void N(Context context, i53 i53Var, LocationEx locationEx);

    void O(Context context, ContactInfoItem contactInfoItem);

    ContactInfoItem P(SquareContactBean squareContactBean);

    String Q(String str);

    boolean R();

    void S(int i);

    String T(String str, String str2);

    String U(int i);

    void V(Activity activity, int i, int i2);

    void W(Activity activity, String str, String str2);

    List<ContactInfoItem> X(ContactInfoItem contactInfoItem);

    boolean Y(String str);

    void Z(Context context, int i, int i2, long j, long j2, String str, String str2);

    boolean a();

    int a0(Context context, ChatItem chatItem);

    boolean b(Context context);

    String b0(String str);

    void c(Activity activity, String str, boolean z);

    void c0(Activity activity, int i, SquareTagBean squareTagBean, TopicListBean.Topic topic, TopicListBean.Ae ae, boolean z);

    void d(Context context, int i, a aVar);

    void d0(Activity activity, ArrayList<ContactInfoItem> arrayList, ContactInfoItem contactInfoItem, int i);

    boolean e(String str, String str2);

    void e0(Activity activity, int i);

    int f();

    void f0(Activity activity);

    void g(Activity activity, ContactInfoItem contactInfoItem, String str, int i);

    void g0(Context context, LocationEx locationEx, boolean z, boolean z2, int i);

    String h(long j);

    void h0(OnLineDetailData onLineDetailData);

    void i(Context context, LocationEx locationEx, boolean z, int i, int i2, boolean z2, int i3);

    void j(Activity activity, ContactInfoItem contactInfoItem, int i);

    boolean k();

    int l();

    boolean m();

    boolean n(String str, String str2);

    List<SquareContactBean> o();

    void p(SquareFeed squareFeed, ContactInfoItem contactInfoItem);

    void q(String str, b bVar);

    void r(Activity activity, ContactInfoItem contactInfoItem, String str);

    String s();

    boolean t();

    int u(int i);

    void v(Activity activity, int i, int i2);

    void w(boolean z);

    String x(Context context, String str, String str2, String str3, boolean z);

    String y(long j);

    void z(Context context, int i, String str, int i2, int i3);
}
