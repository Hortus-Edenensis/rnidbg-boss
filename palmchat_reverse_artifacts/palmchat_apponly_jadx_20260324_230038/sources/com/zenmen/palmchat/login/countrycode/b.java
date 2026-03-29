package com.zenmen.palmchat.login.countrycode;

import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.R;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class b {
    public static volatile b c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ArrayList<a> f14463a = new ArrayList<>();
    public HashMap<String, String> b = new HashMap<>();

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f14464a;
        public String b;
        public String c;
        public String d;

        public String a() {
            return this.c;
        }
    }

    public b() {
        d();
    }

    public static b b() {
        if (c == null) {
            synchronized (b.class) {
                if (c == null) {
                    c = new b();
                }
            }
        }
        return c;
    }

    public ArrayList<a> a() {
        return this.f14463a;
    }

    public HashMap<String, String> c() {
        return this.b;
    }

    public final void d() {
        try {
            InputStream inputStreamOpenRawResource = AppContext.getContext().getResources().openRawResource(R.raw.countries);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStreamOpenRawResource, "UTF-8"));
            this.f14463a.clear();
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    inputStreamOpenRawResource.close();
                    return;
                }
                String[] strArrSplit = line.split("\\t");
                a aVar = new a();
                aVar.f14464a = strArrSplit[0];
                aVar.b = strArrSplit[1];
                aVar.c = strArrSplit[2];
                aVar.d = strArrSplit[3];
                if (AppContext.getContext().getResources().getConfiguration().locale.getCountry().equals("CN")) {
                    this.b.put(aVar.b, aVar.f14464a);
                } else {
                    this.b.put(aVar.b, aVar.c);
                }
                this.f14463a.add(aVar);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
