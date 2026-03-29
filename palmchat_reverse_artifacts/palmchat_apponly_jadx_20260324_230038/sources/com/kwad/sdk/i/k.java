package com.kwad.sdk.i;

import androidx.annotation.NonNull;
import java.util.Iterator;
import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
final class k implements b {
    public JSONObject aYb = new JSONObject();
    public String actionId = UUID.randomUUID().toString();

    public k(String str, String str2, i iVar) {
        JSONObject jSONObjectOO = h.OS().OW().OO();
        Iterator<String> itKeys = jSONObjectOO.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            c.a(jSONObjectOO, next, jSONObjectOO.opt(next));
        }
        c.putValue(this.aYb, "customKey", str);
        c.putValue(this.aYb, "customValue", str2);
        c.putValue(this.aYb, "timestamp", iVar.aXY);
        c.putValue(this.aYb, "actionId", this.actionId);
    }

    @Override // com.kwad.sdk.i.b
    public final JSONObject toJson() {
        return this.aYb;
    }

    @NonNull
    public final String toString() {
        return this.aYb.toString();
    }
}
