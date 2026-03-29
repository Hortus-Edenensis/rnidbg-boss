package defpackage;

import com.huawei.openalliance.ad.constant.bq;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.Vo.MessageVo;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.circle.app.dragon.DragonConfirmItem;
import com.zenmen.palmchat.circle.app.dragon.DragonItem;
import com.zenmen.palmchat.circle.app.dragon.DragonListVO;
import com.zenmen.palmchat.circle.bridge.http.BaseResponse;
import defpackage.pw4;
import im.youni.iccs.iprotobuf.domain.MessageProto;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class lg1 {
    public static lg1 c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f18972a;
    public s03 b;

    public static synchronized lg1 c() {
        if (c == null) {
            lg1 lg1Var = new lg1();
            c = lg1Var;
            lg1Var.d();
        }
        return c;
    }

    public void a(String str, long j, wi0<BaseResponse> wi0Var) {
        this.b.a(rj2.b, new pw4.a().c("/ugmuc.jielong.delete.v1").a("rid", str).a("jlId", Long.valueOf(j)).b(), wi0Var);
    }

    public void b(String str, long j, long j2, wi0<BaseResponse> wi0Var) {
        this.b.a(rj2.b, new pw4.a().c("/ugmuc.jielong.delItem.v1").a("rid", str).a("jlId", Long.valueOf(j)).a("jlItemId", Long.valueOf(j2)).b(), wi0Var);
    }

    public final void d() {
        this.b = new s03();
        this.f18972a = AccountUtils.p(AppContext.getContext().getApplicationContext());
    }

    public void e(DragonItem dragonItem, String str, wi0<BaseResponse> wi0Var) {
        this.b.a(rj2.b, new pw4.a().c("/ugmuc.jielong.join.v1").a("rid", dragonItem.groupId).a("jlId", Long.valueOf(dragonItem.dragonId)).a("content", str).b(), wi0Var);
    }

    public void f(String str, long j, String str2, wi0<BaseResponse<Long>> wi0Var) {
        this.b.a(rj2.b, new pw4.a().c("/ugmuc.jielong.join.v1").a("rid", str).a("jlId", Long.valueOf(j)).a("content", str2).b(), wi0Var);
    }

    public void g(String str, boolean z, int i, wi0<BaseResponse<DragonListVO>> wi0Var) {
        this.b.a(rj2.b, new pw4.a().c("/ugmuc.jielong.query.v1").a("rid", str).a("pageNo", Integer.valueOf(i)).a("pageSize", 10).b(), wi0Var);
    }

    public JSONObject h(String str, String str2) {
        try {
            String strZ = k86.Z(rj2.b.a() + "/ugmuc.jielong.get.v1");
            HashMap map = new HashMap();
            map.put("rid", str);
            map.put("jlId", str2);
            return zw4.d(strZ, map);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void i(String str, long j, wi0<BaseResponse<DragonItem>> wi0Var) {
        this.b.a(rj2.b, new pw4.a().c("/ugmuc.jielong.get.v1").a("rid", str).a("jlId", Long.valueOf(j)).b(), wi0Var);
    }

    public String j(ArrayList<MessageProto.Message> arrayList) {
        l("");
        new DragonItem().isSelfJoin = false;
        new ArrayList();
        return "stamp";
    }

    public void k(DragonItem dragonItem, ArrayList<DragonConfirmItem> arrayList, wi0<BaseResponse<HashMap<String, Long>>> wi0Var) {
        this.b.a(rj2.b, new pw4.a().c("/ugmuc.jielong.create.v1").a("rid", dragonItem.groupId).a("descr", dragonItem.content).a("type", Integer.valueOf(dragonItem.type)).a("content", dragonItem.selfContent).a(bq.f.h, Long.valueOf(dragonItem.timeDeadLine)).b(), wi0Var);
    }

    public void m(MessageVo messageVo) {
        new ArrayList();
    }

    public void n(DragonItem dragonItem, boolean z, wi0<BaseResponse> wi0Var) {
        this.b.a(rj2.b, new pw4.a().c("/ugmuc.jielong.top.v1").a("rid", dragonItem.groupId).a("jlId", Long.valueOf(dragonItem.dragonId)).a("toTop", Integer.valueOf(z ? 1 : 0)).b(), wi0Var);
    }

    public final void l(String str) {
    }
}
