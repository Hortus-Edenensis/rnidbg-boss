package defpackage;

import com.zenmen.square.dynamiclife.PersonalDynamicLifeFragment;
import com.zenmen.square.moments.PersonalMomentsFragment;
import com.zenmen.square.ui.widget.NestDynamicLifeTabHeaderView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class hj5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static List<NestDynamicLifeTabHeaderView.b> f17978a = new ArrayList();
    public static Map<String, Class> b;

    static {
        NestDynamicLifeTabHeaderView.b bVar = new NestDynamicLifeTabHeaderView.b();
        bVar.b = "生活动态";
        bVar.c = PersonalDynamicLifeFragment.class.getName();
        bVar.f16541a = 1;
        f17978a.add(bVar);
        NestDynamicLifeTabHeaderView.b bVar2 = new NestDynamicLifeTabHeaderView.b();
        bVar2.b = "好友分享";
        bVar2.c = PersonalMomentsFragment.class.getName();
        bVar2.f16541a = 2;
        f17978a.add(bVar2);
        HashMap map = new HashMap();
        b = map;
        map.put("dynamicLifeTitle", PersonalDynamicLifeFragment.class);
        b.put("momentsTitle", PersonalMomentsFragment.class);
    }

    public static List<NestDynamicLifeTabHeaderView.b> a() {
        ArrayList arrayList = new ArrayList();
        JSONObject config = vs0.a().getConfig("personalSquareTabs");
        if (config == null || config.length() <= 0) {
            return f17978a;
        }
        if (config.length() > 0) {
            Iterator<String> itKeys = config.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                Class cls = b.get(next);
                JSONObject jSONObjectOptJSONObject = config.optJSONObject(next);
                if (cls != null && jSONObjectOptJSONObject != null) {
                    try {
                        int i = jSONObjectOptJSONObject.getInt("order");
                        String string = jSONObjectOptJSONObject.getString("name");
                        NestDynamicLifeTabHeaderView.b bVar = new NestDynamicLifeTabHeaderView.b();
                        bVar.b = string;
                        bVar.c = cls.getName();
                        bVar.f16541a = i;
                        arrayList.add(bVar);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            Collections.sort(arrayList);
        }
        return arrayList.size() == 0 ? f17978a : arrayList;
    }
}
