package defpackage;

import android.content.Context;
import android.text.TextUtils;
import com.zenmen.palmchat.framework.FrameworkBaseActivity;
import com.zenmen.palmchat.gift.bean.GiftPanelConfigBean;
import com.zenmen.palmchat.peoplematch.bean.CommonResponse;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class ha3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static aa2 f17902a = new aa2();

    /* JADX INFO: compiled from: SearchBox */
    public class a extends uw4<CommonResponse<GiftPanelConfigBean>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f17903a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ Context e;

        public a(String str, String str2, String str3, String str4, Context context) {
            this.f17903a = str;
            this.b = str2;
            this.c = str3;
            this.d = str4;
            this.e = context;
        }

        @Override // defpackage.uw4
        public void a(CommonResponse<GiftPanelConfigBean> commonResponse) {
            if (commonResponse == null || commonResponse.getData() == null || TextUtils.isEmpty(commonResponse.getData().url)) {
                ry5.a("请求失败，请重试！");
                return;
            }
            String str = commonResponse.getData().url;
            HashMap map = new HashMap();
            map.put("panelId", this.f17903a);
            map.put("userId", this.b);
            map.put("userAvatar", this.c);
            map.put("userName", this.d);
            String strB = p86.b(str, map);
            if (ve.q((FrameworkBaseActivity) this.e, strB)) {
                return;
            }
            ve.s((FrameworkBaseActivity) this.e, strB, false);
        }

        @Override // defpackage.uw4
        public void b(int i, String str) {
            super.b(i, str);
            ry5.a("请求失败，请重试！");
        }
    }

    public static boolean a() {
        return true;
    }

    public static void b(Context context, String str, String str2, String str3, String str4) {
        f17902a.p(str, new a(str, str2, str3, str4, context));
    }
}
