package defpackage;

import android.content.Context;
import com.afollestad.materialdialogs.MaterialDialog;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.circle.bean.CircleApplyListItem;
import com.zenmen.palmchat.circle.bridge.http.BaseResponse;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import defpackage.pw4;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class qa0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static s03 f20210a;
    public static r03 b;
    public static volatile qa0 c;

    public qa0() {
        f20210a = new s03();
        b = new r03();
    }

    public static qa0 i() {
        if (c == null) {
            synchronized (qa0.class) {
                if (c == null) {
                    c = new qa0();
                }
            }
        }
        return c;
    }

    public void b(String str, List<String> list, wi0<BaseResponse> wi0Var) {
        f20210a.a(rj2.f20490a, new pw4.a().c("/room/v5/manager/create").a("roomId", str).a("memIds", list).b(), wi0Var);
    }

    public void c(String str, List<String> list, String str2, wi0<BaseResponse> wi0Var) {
        f20210a.a(rj2.f20490a, new pw4.a().c("/room/v5/apply/create").a("roomId", str).a("members", list).a("remark", str2).b(), wi0Var);
    }

    public void d(long j, int i, wi0<BaseResponse<CircleApplyListItem>> wi0Var) {
        f20210a.a(rj2.f20490a, new pw4.a().c("/room/v5/applyRecord/approval").a("id", Long.valueOf(j)).a("approvalStatus", Integer.valueOf(i)).a("versionFlag", 1).b(), wi0Var);
    }

    public void e(String str, wi0<BaseResponse> wi0Var) {
        f20210a.a(rj2.f20490a, new pw4.a().c("/room/v5/mute/cancel").a("roomId", str).b(), wi0Var);
    }

    public void f(String str, wi0<BaseResponse> wi0Var) {
        f20210a.a(rj2.f20490a, new pw4.a().c("/room/v5/mute/set").a("roomId", str).b(), wi0Var);
    }

    public void g(String str, int i, int i2, wi0<BaseResponse<List<CircleApplyListItem>>> wi0Var) {
        f20210a.a(rj2.f20490a, new pw4.a().c("/room/v5/applyRecord/list").a("roomId", str).a("pageNo", Integer.valueOf(i)).a("pageSize", Integer.valueOf(i2)).a("versionFlag", 1).b(), wi0Var);
    }

    public void h(String str, wi0<BaseResponse<List<ContactInfoItem>>> wi0Var) {
        f20210a.a(rj2.f20490a, new pw4.a().c("/room/v5/manager/list").a("roomId", str).b(), wi0Var);
    }

    public void k(String str, List<String> list, wi0<BaseResponse> wi0Var) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (String str2 : list) {
                HashMap map = new HashMap();
                map.put("memId", str2);
                map.put("durationType", "0");
                arrayList.add(map);
            }
        }
        f20210a.a(rj2.f20490a, new pw4.a().c("/room/v5/member/mute/set").a("roomId", str).a("memList", arrayList).b(), wi0Var);
    }

    public void l(String str, List<String> list, wi0<BaseResponse> wi0Var) {
        f20210a.a(rj2.f20490a, new pw4.a().c("/room/v5/manager/delete").a("roomId", str).a("memIds", list).b(), wi0Var);
    }

    public void m(String str, List<String> list, wi0<BaseResponse> wi0Var) {
        f20210a.a(rj2.f20490a, new pw4.a().c("/room/v5/member/mute/cancel").a("roomId", str).a("memIds", list).b(), wi0Var);
    }

    public void n(Context context, MaterialDialog.e eVar) {
        new sd3(context).k("本群已开启“入群验证”功能，申请入群需经过群主或管理员验证，描述原因更容易获得通过。").m(R.color.materia_content_text_color).O(R.string.send).B("说明申请理由（选填）", null, new MaterialDialog.f() { // from class: pa0
            @Override // com.afollestad.materialdialogs.MaterialDialog.f
            public final void a(MaterialDialog materialDialog, CharSequence charSequence) {
                qa0.j(materialDialog, charSequence);
            }
        }).f(eVar).a0(R.color.text_color_green).K(R.string.alert_dialog_cancel).e().show();
    }

    public void o(String str, boolean z, wi0<BaseResponse> wi0Var) {
        f20210a.a(rj2.f20490a, new pw4.a().c("/room/v5/setRoomAddFriendSwitch").a("roomId", str).a("addFriendSwitch", Integer.valueOf(z ? 1 : 0)).b(), wi0Var);
    }

    public void p(String str, boolean z, wi0<BaseResponse> wi0Var) {
        f20210a.a(rj2.f20490a, new pw4.a().c("/room/v5/newcommerMsgSwitch/set").a("roomId", str).a("showHisSwitch", Integer.valueOf(z ? 1 : 0)).b(), wi0Var);
    }

    public static /* synthetic */ void j(MaterialDialog materialDialog, CharSequence charSequence) {
    }
}
