package a.a.a.a.b;

import a.a.a.a.a.a.i;
import com.tencent.matrix.trace.config.SharePluginInfo;
import java.util.Arrays;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f1065a;
    public String b;
    public String c;
    public String d;
    public JSONArray e;
    public int[] f;
    public i g;
    public final Lazy h;
    public final Lazy i;
    public final Lazy j;

    /* JADX INFO: compiled from: SearchBox */
    public static final class a extends Lambda implements Function0<HashMap<String, Object>> {
        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public HashMap<String, Object> invoke() {
            Pair[] pairArr = new Pair[7];
            pairArr[0] = TuplesKt.to("client_tun", b.this.f1065a);
            pairArr[1] = TuplesKt.to("disk", b.this.b);
            pairArr[2] = TuplesKt.to(SharePluginInfo.ISSUE_MEMORY, b.this.c);
            pairArr[3] = TuplesKt.to("boot_time_sec", b.this.d);
            i iVar = b.this.g;
            pairArr[4] = TuplesKt.to("u_t", iVar != null ? iVar.a() : new JSONObject());
            pairArr[5] = TuplesKt.to("pkg_info", b.this.e);
            pairArr[6] = TuplesKt.to("inode", b.this.f);
            return MapsKt__MapsKt.hashMapOf(pairArr);
        }
    }

    /* JADX INFO: renamed from: a.a.a.a.b.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static final class C0001b extends Lambda implements Function0<JSONObject> {
        public C0001b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public JSONObject invoke() throws JSONException {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("client_tun", b.this.f1065a);
            jSONObject.put("disk", b.this.b);
            jSONObject.put(SharePluginInfo.ISSUE_MEMORY, b.this.c);
            jSONObject.put("boot_time_sec", b.this.d);
            i iVar = b.this.g;
            jSONObject.put("u_t", iVar != null ? iVar.a() : null);
            jSONObject.put("pkg_info", b.this.e);
            String string = Arrays.toString(b.this.f);
            Intrinsics.checkNotNullExpressionValue(string, "java.util.Arrays.toString(this)");
            jSONObject.put("inode", string);
            return jSONObject;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class c extends Lambda implements Function0<HashMap<String, String>> {
        public c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public HashMap<String, String> invoke() {
            Pair[] pairArr = new Pair[7];
            pairArr[0] = TuplesKt.to("client_tun", b.this.f1065a);
            pairArr[1] = TuplesKt.to("disk", b.this.b);
            pairArr[2] = TuplesKt.to(SharePluginInfo.ISSUE_MEMORY, b.this.c);
            pairArr[3] = TuplesKt.to("boot_time_sec", b.this.d);
            i iVar = b.this.g;
            pairArr[4] = TuplesKt.to("u_t", String.valueOf(iVar != null ? iVar.a() : null));
            pairArr[5] = TuplesKt.to("pkg_info", b.this.e.toString());
            String string = Arrays.toString(b.this.f);
            Intrinsics.checkNotNullExpressionValue(string, "java.util.Arrays.toString(this)");
            pairArr[6] = TuplesKt.to("inode", string);
            return MapsKt__MapsKt.hashMapOf(pairArr);
        }
    }

    public b() {
        this.f1065a = "";
        this.b = "";
        this.c = "";
        this.d = "";
        this.e = new JSONArray();
        this.f = new int[0];
        this.h = LazyKt__LazyJVMKt.lazy(new C0001b());
        this.i = LazyKt__LazyJVMKt.lazy(new c());
        this.j = LazyKt__LazyJVMKt.lazy(new a());
    }

    public final void a(i iVar) {
        ((JSONObject) this.h.getValue()).put("u_t", iVar != null ? iVar.a() : null);
        ((HashMap) this.i.getValue()).put("u_t", String.valueOf(iVar != null ? iVar.a() : null));
        ((HashMap) this.j.getValue()).put("u_t", iVar != null ? iVar.a() : new JSONObject());
        this.g = iVar;
    }

    public b(b zDataModel) {
        Intrinsics.checkNotNullParameter(zDataModel, "zDataModel");
        this.f1065a = "";
        this.b = "";
        this.c = "";
        this.d = "";
        this.e = new JSONArray();
        this.f = new int[0];
        this.h = LazyKt__LazyJVMKt.lazy(new C0001b());
        this.i = LazyKt__LazyJVMKt.lazy(new c());
        this.j = LazyKt__LazyJVMKt.lazy(new a());
        this.f1065a = zDataModel.f1065a;
        this.b = zDataModel.b;
        this.c = zDataModel.c;
        this.d = zDataModel.d;
        this.e = zDataModel.e;
        this.f = zDataModel.f;
        a(this.g);
    }
}
