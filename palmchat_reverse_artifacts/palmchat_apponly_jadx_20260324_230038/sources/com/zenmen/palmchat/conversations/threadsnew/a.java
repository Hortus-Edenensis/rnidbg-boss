package com.zenmen.palmchat.conversations.threadsnew;

import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f13810a;
    public List<String> b;
    public List<C1037a> c;
    public long d;

    /* JADX INFO: renamed from: com.zenmen.palmchat.conversations.threadsnew.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static class C1037a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f13811a;

        public static C1037a a(JSONObject jSONObject) {
            C1037a c1037a = new C1037a();
            c1037a.f13811a = jSONObject.optString("avatar", "");
            return c1037a;
        }
    }
}
