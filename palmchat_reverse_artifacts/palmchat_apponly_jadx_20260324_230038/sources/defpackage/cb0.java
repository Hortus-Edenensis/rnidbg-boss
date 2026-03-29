package defpackage;

import android.text.TextUtils;
import com.zenmen.palmchat.circle.bean.CircleNoticeItem;
import com.zenmen.palmchat.circle.bean.CircleNoticeList;
import com.zenmen.palmchat.circle.bridge.http.BaseResponse;
import defpackage.pw4;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class cb0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static s03 f1939a;
    public static volatile cb0 b;

    public cb0() {
        f1939a = new s03();
    }

    public static cb0 c() {
        if (b == null) {
            synchronized (qa0.class) {
                if (b == null) {
                    b = new cb0();
                }
            }
        }
        return b;
    }

    public void a(String str, String str2, int i, String str3, int i2, int i3, int i4, wi0<BaseResponse<Long>> wi0Var) {
        pw4.a aVarA = new pw4.a().c("/ugmuc.notice.create.v1").a("rid", str).a("content", str2).a("confirm", Integer.valueOf(i2)).a("toTop", Integer.valueOf(i3)).a("topChatWindow", Integer.valueOf(i4));
        if (!TextUtils.isEmpty(str3)) {
            aVarA.a("mediaType", Integer.valueOf(i));
            aVarA.a("mediaUrl", str3);
        }
        f1939a.a(rj2.b, aVarA.b(), wi0Var);
    }

    public void b(String str, long j, wi0<BaseResponse> wi0Var) {
        f1939a.a(rj2.b, new pw4.a().c("/ugmuc.notice.del.v1").a("noticeId", Long.valueOf(j)).a("rid", str).b(), wi0Var);
    }

    public void d(String str, long j, wi0<BaseResponse<CircleNoticeItem>> wi0Var) {
        f1939a.a(rj2.b, new pw4.a().c("/ugmuc.notice.get.v1").a("rid", str).a("noticeId", Long.valueOf(j)).b(), wi0Var);
    }

    public void e(String str, int i, int i2, wi0<BaseResponse<CircleNoticeList>> wi0Var) {
        f1939a.a(rj2.b, new pw4.a().c("/ugmuc.notice.query.v1").a("rid", str).a("pageNo", Integer.valueOf(i)).a("pageSize", Integer.valueOf(i2)).b(), wi0Var);
    }
}
