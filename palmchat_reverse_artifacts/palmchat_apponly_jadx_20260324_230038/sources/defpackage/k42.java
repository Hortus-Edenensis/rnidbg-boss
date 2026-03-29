package defpackage;

import com.zenmen.listui.list.BaseNetListBean;
import com.zenmen.palmchat.c;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.square.mvp.model.bean.SquareFeed;
import com.zenmen.square.mvp.model.bean.SquareFeedEvent;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class k42 extends au4 {
    public k42(String str, int i) {
        super(str, i);
    }

    @Override // defpackage.au4, defpackage.yt1
    public boolean E() {
        return true;
    }

    @Override // defpackage.au4, defpackage.yt1
    public String I() {
        return "friend";
    }

    @Override // defpackage.yt1
    public void M(int i, SquareFeed squareFeed) {
        List<SquareFeed> list = this.m;
        if (list != null && list.size() > 0 && this.m.get(0).feedType == 100000) {
            g(0, this.m.get(0));
        }
        super.M(i, squareFeed);
    }

    @Override // defpackage.au4, defpackage.yt1
    public BaseNetListBean<SquareFeed> O(JSONObject jSONObject, boolean z) {
        BaseNetListBean<SquareFeed> baseNetListBeanO = super.O(jSONObject, z);
        if (baseNetListBeanO.isSuccess() && z && ((List) baseNetListBeanO.data).size() > 0 && ((SquareFeed) ((List) baseNetListBeanO.data).get(0)).feedType == 10000) {
            ((List) baseNetListBeanO.data).add(0, W());
        }
        return baseNetListBeanO;
    }

    @Override // defpackage.au4
    public JSONObject T(boolean z) {
        JSONObject jSONObjectT = super.T(z);
        int i = 1;
        try {
            if (z) {
                jSONObjectT.put("version", 0);
                jSONObjectT.put("queryType", 1);
            } else {
                jSONObjectT.put("version", G());
                if (this.m.size() > 0) {
                    List<SquareFeed> list = this.m;
                    if (!list.get(list.size() - 1).ifFriend) {
                        i = 2;
                    }
                    jSONObjectT.put("queryType", i);
                } else {
                    jSONObjectT.put("queryType", 1);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObjectT;
    }

    public final SquareFeed W() {
        SquareFeed squareFeed = new SquareFeed();
        squareFeed.feedType = 100000;
        List<ContactInfoItem> listX = bj5.b().a().X(dn0.a(v4.e(c.b())));
        squareFeed.content = (listX == null || listX.size() <= 0) ? "结交好友，可以在这里查看好友的最新动态" : "暂无好友的动态内容";
        return squareFeed;
    }

    @Override // defpackage.yt1, xt1.a
    public void Y0(SquareFeedEvent squareFeedEvent) {
        List<SquareFeed> list;
        super.Y0(squareFeedEvent);
        if (squareFeedEvent.eventType == 3 && (list = this.m) != null && list.size() > 0 && this.m.get(0).feedType == 10000) {
            M(0, W());
        }
    }

    @Override // defpackage.au4, defpackage.br
    public boolean t() {
        return true;
    }

    @Override // defpackage.au4, defpackage.yt1, defpackage.br
    public boolean u() {
        return false;
    }
}
