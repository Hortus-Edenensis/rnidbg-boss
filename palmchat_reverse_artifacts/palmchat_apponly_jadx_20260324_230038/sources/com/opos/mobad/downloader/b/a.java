package com.opos.mobad.downloader.b;

import com.opos.mobad.downloader.g;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f8777a;
    public final String b;
    public final String c;
    public final String d;
    public int f = 0;
    public int g = 0;
    public final Set<g> e = new HashSet();

    public a(String str, String str2, String str3, String str4) {
        this.f8777a = str2;
        this.b = str3;
        this.c = str4;
        this.d = str;
    }

    public void a(g gVar) {
        if (gVar != null) {
            if (this.e.size() > 0) {
                for (g gVar2 : this.e) {
                    if (gVar2 != null && (gVar2 == gVar || gVar2.hashCode() == gVar.hashCode())) {
                        return;
                    }
                }
            }
            this.e.add(gVar);
        }
    }

    public void b(g gVar) {
        if (gVar == null || this.e.size() <= 0) {
            return;
        }
        this.e.remove(gVar);
    }

    public String toString() {
        return "DownloadData{url='" + this.d + "', md5='" + this.c + "', appName='" + this.f8777a + "', pkgName='" + this.b + "'}";
    }
}
