package cn.fly.verify;

import android.text.TextUtils;
import cn.fly.verify.fq;
import cn.fly.verify.gj;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeMap;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class bs extends bh {
    public bs() {
        super(bq.a("002Sggej"), 0L, bq.a("005<ggejff[ek"), 3600L, bh.a(bq.a("002Sggej"), (Long) 0L));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        fq.a(ax.g()).G().H().a(new fq.a() { // from class: cn.fly.verify.bs.2
            @Override // cn.fly.verify.fq.a
            public void a(fq.b bVar) {
                HashMap<String, Object> map = new HashMap<>();
                HashMap<String, Object> mapF = bVar.F();
                if (mapF == null) {
                    return;
                }
                String str = (String) mapF.get("bsmt");
                String str2 = (String) mapF.get("ssmt");
                if (!TextUtils.isEmpty(str)) {
                    ArrayList<HashMap<String, Object>> arrayListG = bVar.G();
                    if (arrayListG != null && !arrayListG.isEmpty()) {
                        Iterator<HashMap<String, Object>> it = arrayListG.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            HashMap<String, Object> next = it.next();
                            Object obj = next.get(bq.a("005^gjfkfkfjgl"));
                            if (obj != null && String.valueOf(obj).equals(str)) {
                                map.putAll(next);
                                break;
                            }
                        }
                        map.remove(bq.a("005Dgjfkfkfjgl"));
                        map.remove(bq.a("004Pfkfkfjgl"));
                    }
                } else if (TextUtils.isEmpty(str2) || bq.a("014EjfehLfHemXf.fegg.f0jggigiejedjh").equalsIgnoreCase(str2)) {
                    return;
                }
                map.putAll(mapF);
                map.put("ssmt", str2);
                map.put("bsmt", str);
                bs.this.a("WIMT", map, true);
                TreeMap treeMap = new TreeMap();
                treeMap.put("ssmt", str2);
                treeMap.put("bsmt", str);
                bv.a().a(bv.i, fr.b(new JSONObject(treeMap).toString()));
            }
        });
    }

    @Override // cn.fly.verify.bh
    public void a() {
        m();
    }

    @Override // cn.fly.verify.bh
    public void c() {
        gj.a().a(getClass().getName(), new gj.a() { // from class: cn.fly.verify.bs.1
            @Override // cn.fly.verify.gj.a
            public void a() {
                if (bs.this.e()) {
                    bs.this.m();
                }
            }
        });
    }
}
