package cn.fly.verify;

import cn.fly.verify.dl;
import java.io.File;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.http.HttpHeaders;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class dj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final HashMap<String, Class<?>> f2179a = new HashMap<>();
    private final ArrayList<dl> b;
    private final ArrayList<Object> c;

    public dj(ArrayList<dl> arrayList, ArrayList<Object> arrayList2) {
        this.b = arrayList;
        this.c = arrayList2;
    }

    public ArrayList<dl> a() {
        return this.b;
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x001e, code lost:
    
        r0.d = true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(int i, int i2, df dfVar, List<Object> list) throws Throwable {
        String string;
        dl.a aVar = new dl.a();
        aVar.f2184a = i;
        aVar.b = dfVar;
        aVar.c = list;
        aVar.f = this.b;
        aVar.g = this.c;
        while (true) {
            try {
                if (aVar.f2184a >= i2) {
                    break;
                }
                if (dfVar.f()) {
                    break;
                }
                this.b.get(aVar.f2184a).a(aVar);
                if (aVar.e) {
                    break;
                } else {
                    aVar.f2184a++;
                }
            } catch (Throwable th) {
                th = th;
                if (th instanceof di) {
                    string = th.getMessage() == null ? th.getClass().getSimpleName() : th.getMessage();
                    th = th.getCause();
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Suba Runtime Error: ");
                    sb.append(th.getMessage() == null ? th.getClass().getSimpleName() : th.getMessage());
                    string = sb.toString();
                }
                throw new di(string + "\r\n\tat " + this.b.get(aVar.f2184a).b + " (" + this.b.get(aVar.f2184a).c + ")", th);
            }
        }
        if (aVar.d || dfVar.d() <= 0 || list == null) {
            return;
        }
        try {
            list.add(dfVar.a());
        } catch (Throwable unused) {
        }
    }

    private void a(df dfVar) {
        dfVar.a("Object", Object.class);
        dfVar.a("Class", Class.class);
        dfVar.a("Method", Method.class);
        dfVar.a("String", String.class);
        dfVar.a("Thread", Thread.class);
        dfVar.a(ec.b("0083fhcfMddc4edDfe"), Runnable.class);
        dfVar.a(ec.b("0061dicjegXheYce"), System.class);
        dfVar.a("File", File.class);
        dfVar.a("URL", URL.class);
        dfVar.a("Double", Double.class);
        dfVar.a("Float", Float.class);
        dfVar.a("Long", Long.class);
        dfVar.a("Integer", Integer.class);
        dfVar.a(ec.b("0059di.g-dcci;h"), Short.class);
        dfVar.a("Byte", Byte.class);
        dfVar.a("Number", Number.class);
        dfVar.a(ec.b("009Cfj!gc4ci,cbhe,ci"), Character.class);
        dfVar.a("Boolean", Boolean.class);
        dfVar.a(ec.b("006Fcbdccfed*fe"), Double.TYPE);
        dfVar.a(ec.b("0056de0fUdc5ch"), Float.TYPE);
        dfVar.a("long", Long.TYPE);
        dfVar.a(ec.b("003Vch%dh"), Integer.TYPE);
        dfVar.a("short", Short.TYPE);
        dfVar.a("byte", Byte.TYPE);
        dfVar.a(ec.b("004bgc<ci"), Character.TYPE);
        dfVar.a("boolean", Boolean.TYPE);
        dfVar.a("bigInt", BigInteger.class);
        dfVar.a("BigInteger", BigInteger.class);
        dfVar.a("bigDec", BigDecimal.class);
        dfVar.a("BigDecimal", BigDecimal.class);
        dfVar.a("List", List.class);
        dfVar.a("Map", Map.class);
        dfVar.a("Function", dm.class);
        dfVar.a("fun", dm.class);
        dfVar.a(HttpHeaders.RANGE, dn.class);
        dfVar.a("Array", Array.class);
        dfVar.a("Suba", dk.class);
        dfVar.a("VM", dk.class);
        for (Map.Entry<String, Class<?>> entry : f2179a.entrySet()) {
            dfVar.a(entry.getKey(), entry.getValue());
        }
    }

    public void a(HashMap<String, Object> map, dh dhVar) throws Throwable {
        df dfVar = new df(map, dhVar);
        a(dfVar);
        a(0, this.b.size(), dfVar, null);
    }
}
