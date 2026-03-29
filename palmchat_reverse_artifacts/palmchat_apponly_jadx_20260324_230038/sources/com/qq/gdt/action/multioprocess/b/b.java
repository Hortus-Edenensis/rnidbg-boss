package com.qq.gdt.action.multioprocess.b;

import com.qq.gdt.action.j.o;
import java.io.Serializable;
import kotlin.text.Typography;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public abstract class b implements Serializable {
    private String b;
    private int d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f10547a = getClass().getSimpleName();
    private int c = 0;

    /* JADX INFO: compiled from: SearchBox */
    public static class a extends b {
    }

    /* JADX INFO: renamed from: com.qq.gdt.action.multioprocess.b.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static class C0838b extends b {
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class c extends b {
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class d extends b {
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class e extends b {
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class f extends b {
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class g extends b {
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class h extends b {
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class i extends b {
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class j extends b {
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class k extends b {
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class l extends b {
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class m extends b {
    }

    public b() {
        this.d = 1;
        try {
            this.d = com.qq.gdt.action.b.a(com.qq.gdt.action.d.a().g()).p();
        } catch (Throwable th) {
            o.a("DeviceInfoItem fetchLimit e = " + th, new Object[0]);
        }
    }

    public String a() {
        return this.b;
    }

    public int b() {
        return this.c;
    }

    public int c() {
        return this.d;
    }

    public void d() {
        this.c++;
    }

    public String toString() {
        return "{\"type\":\"" + this.f10547a + Typography.quote + ",\"deviceValue\":\"" + this.b + Typography.quote + ",\"fetchTimes\":" + this.c + ",\"limitTimes\":" + this.d + '}';
    }

    public void a(String str) {
        this.b = str;
    }
}
