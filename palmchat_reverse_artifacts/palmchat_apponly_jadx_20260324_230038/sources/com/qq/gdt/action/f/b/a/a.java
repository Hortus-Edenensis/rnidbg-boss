package com.qq.gdt.action.f.b.a;

import com.bykv.vk.component.ttvideo.LiveConfigKey;
import com.kuaishou.weapon.p0.t;
import com.qq.gdt.action.f.b.a.c;
import com.qq.gdt.action.f.b.i;
import com.qq.gdt.action.j.o;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class a implements c {
    @Override // com.qq.gdt.action.f.b.a.c
    public i a(c.a aVar) throws IOException {
        com.qq.gdt.action.f.b.g gVarA = aVar.a();
        Map<String, String> mapD = gVarA.d();
        if (mapD != null) {
            mapD.put("abs", String.valueOf(true));
        }
        i iVarA = aVar.a(gVarA);
        Map<String, List<String>> mapD2 = iVarA.d();
        if (mapD2 != null) {
            List<String> list = mapD2.get(t.u);
            if (list != null && list.size() > 0) {
                try {
                    com.qq.gdt.action.j.t.a(com.qq.gdt.action.d.a().g(), Long.parseLong(list.get(0)));
                } catch (NumberFormatException e) {
                    o.b("fail to parse SERVER_ACTIVATE_TIME !", e);
                }
            }
            List<String> list2 = mapD2.get("ai");
            if (list2 != null && list2.size() > 0) {
                try {
                    com.qq.gdt.action.j.t.a(com.qq.gdt.action.d.a().g(), Boolean.parseBoolean(list2.get(0)));
                } catch (Exception e2) {
                    o.b("fail to parse ACTIVATE_WITH_IMEI !", e2);
                }
            }
            List<String> list3 = mapD2.get(LiveConfigKey.AUDIO);
            if (list3 != null && list3.size() > 0) {
                try {
                    com.qq.gdt.action.j.t.b(com.qq.gdt.action.d.a().g(), Boolean.parseBoolean(list3.get(0)));
                } catch (Exception e3) {
                    o.b("fail to parse ACTIVATE_WITH_OAID !", e3);
                }
            }
        }
        return iVarA;
    }
}
