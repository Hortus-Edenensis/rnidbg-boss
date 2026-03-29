package com.qq.gdt.action.f.b.a;

import com.qq.gdt.action.f.b.a.c;
import com.qq.gdt.action.f.b.i;
import com.qq.gdt.action.j.o;
import com.qq.gdt.action.j.w;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class g implements c {
    @Override // com.qq.gdt.action.f.b.a.c
    public i a(c.a aVar) throws IOException {
        List<String> list;
        com.qq.gdt.action.f.b.g gVarA = aVar.a();
        Map<String, String> mapD = gVarA.d();
        if (mapD != null) {
            mapD.put("Client-Time", String.valueOf(System.currentTimeMillis()));
        }
        i iVarA = aVar.a(gVarA);
        Map<String, List<String>> mapD2 = iVarA.d();
        if (mapD2 != null && (list = mapD2.get("Server-Time")) != null && list.size() > 0) {
            try {
                w.a(Long.parseLong(list.get(0)));
            } catch (NumberFormatException e) {
                o.b("fail to parse server time !", e);
            }
        }
        return iVarA;
    }
}
