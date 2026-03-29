package defpackage;

import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.framework.square.bean.ShareSmsBean;
import com.zenmen.square.bean.ProfileInviteBean;
import com.zenmen.square.bean.SquareChatCheckBean;
import com.zenmen.square.bean.SquareDynamicLifeResponseBean;
import com.zenmen.square.bean.SquareShareFeedBean;
import com.zenmen.square.mvp.model.bean.SquareFeed;
import com.zenmen.square.tag.bean.CommonResponse;
import com.zenmen.square.tag.bean.SquareTagListBean;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public interface uo2 {
    void a(JSONArray jSONArray, boolean z, tw4<CommonResponse<String>> tw4Var);

    void b(ArrayList<Integer> arrayList, tw4<CommonResponse> tw4Var);

    void c(int i, String str, int i2, ContactInfoItem contactInfoItem, tw4<CommonResponse<SquareChatCheckBean>> tw4Var);

    void d(tw4<CommonResponse<List<Integer>>> tw4Var);

    void e(SquareShareFeedBean squareShareFeedBean, tw4<CommonResponse<SquareFeed>> tw4Var);

    void f(String str, String str2, String str3, long j, tw4<CommonResponse<SquareDynamicLifeResponseBean>> tw4Var);

    void g(tw4<CommonResponse<String>> tw4Var);

    void h(long j, List<String> list, tw4<CommonResponse<ShareSmsBean>> tw4Var);

    void i(tw4<CommonResponse<List<Integer>>> tw4Var);

    void j(int i, String str, String str2, tw4<CommonResponse<ProfileInviteBean>> tw4Var);

    void k(String str, String str2, int i, tw4<CommonResponse<SquareTagListBean>> tw4Var);

    void m(tw4<CommonResponse<List<Integer>>> tw4Var);
}
