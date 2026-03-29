package com.zenmen.openapi.test;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.annotation.Nullable;
import com.alipay.sdk.m.x.d;
import com.huawei.openalliance.ad.constant.bq;
import com.zenmen.openapi.R$id;
import com.zenmen.openapi.R$layout;
import defpackage.ah;
import defpackage.e84;
import defpackage.f84;
import defpackage.n75;
import defpackage.om;
import defpackage.sy5;
import defpackage.ua3;
import defpackage.wa3;
import java.util.Random;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class OpenApiTestAct extends Activity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Button f12028a;
    public String[] b = {bq.b.V, "click", "open", d.z};

    /* JADX INFO: compiled from: SearchBox */
    public class a implements e84 {
        public a() {
        }

        @Override // defpackage.e84
        public void onCallback(int i, String str, Object obj) {
            AlertDialog.Builder builder = new AlertDialog.Builder(OpenApiTestAct.this);
            builder.setMessage("msg:" + str + " " + obj);
            builder.create().show();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements e84 {
        public b() {
        }

        @Override // defpackage.e84
        public void onCallback(int i, String str, Object obj) {
            new AlertDialog.Builder(OpenApiTestAct.this).setMessage(i + " " + str).create().show();
        }
    }

    public final void a() {
        wa3.a("lxed7e31ca58cc4def", "d4b35bdd8b5543278d0bf92d6522b55d", new a());
    }

    public final void b() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appId", "lxed7e31ca58cc4def");
            jSONObject.put("url", "http://demo.yxptfs.com/webapp-test/index.html");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        wa3.d(this, jSONObject);
    }

    public final void c() {
        n75 n75Var = new n75("lxed7e31ca58cc4def");
        n75Var.g = "https://wine-avatar.cdn.lianxinapp.com/avatar/2021/3/22/d/z/2412587877318656-8-2-c446f56c083c4259afcce6ed86046e8a-qqd6qy.png";
        n75Var.h = "有信念的Miles";
        n75Var.c = "http://118.24.72.19/webapp-demo/";
        n75Var.b = "zenxin://webapp?url=http%3A%2F%2F118.24.72.19%2Fwebapp-demo%2F&appId=lxed7e31ca58cc4def";
        n75Var.d = "更多好友等着你";
        n75Var.e = "这是WebApp的desc";
        n75Var.f = "http://file.market.xiaomi.com/thumbnail/jpeg/l395/AppStore/074c2e5e646c547520a507fda76c4c8726b5624a4";
        com.zenmen.openapi.share.a.b(this, n75Var);
    }

    public final void d(int i) {
        n75 n75Var = new n75("lxed7e31ca58cc4def");
        n75Var.k = i;
        n75Var.b = "https://lianxinapp.com";
        n75Var.d = "连信";
        n75Var.e = "连信，快速遇到心仪的Ta";
        n75Var.f = "https://lianxinapp.com/img/logo.png";
        com.zenmen.openapi.share.a.d(this, n75Var);
    }

    public final void e(int i) {
        n75 n75Var = new n75("lxed7e31ca58cc4def");
        n75Var.k = i;
        n75Var.g = "https://wine-avatar.cdn.lianxinapp.com/avatar/2021/3/22/d/z/2412587877318656-8-2-c446f56c083c4259afcce6ed86046e8a-qqd6qy.png";
        n75Var.h = "有信念的Miles";
        n75Var.b = "https://pre-vgw.ilxshow.com/alps/vbs/view.do?contentId=33~oXgZ8LtSQzZErW79_6PxW6nX-Ts%2E&ucode=&appId=ZX0001&lang=CN&ts=2021042114&scene=videotab&env=wx'";
        n75Var.d = "这是小视频subject";
        n75Var.i = "https://pre-vgw.ilxshow.com/alps/vbs/parse.do?pd=AG/AhztZJbzpBpMk4n7lQYaAIHH7NILWqDCdaU1TlZrKe1YFd8huNy6+7PsraaZuPnTCxNi13k8SQ/b5LJJ6CU3eUkgdNKXO4n0iKKJp97E7r0FRzYZ82qK8FrWshVRHNy7oZZHnJ75E47v4Iv4c2xQwPfB5sX2dDeHfT4+IVaQ=";
        n75Var.j = "https://pre-vgw.ilxshow.com/alps/vbs/parse.do?pd=AG/AhztZJbzpBpMk4n7lQV7+xMi8muCdke0xNJZ+fNJccOQjP3qWOzIFBvZxKb5rPnTCxNi13k8SQ/b5LJJ6CWA5rsfLchof8vMCXU0fDIAxcaIYThQsiVEezfmniyzI7kyfGHz9Zb4+xoZcfLmJZRQwPfB5sX2dDeHfT4+IVaQ=";
        com.zenmen.openapi.share.a.e(this, n75Var);
    }

    public final void f(int i) {
        com.zenmen.openapi.share.a.f(this, "lxed7e31ca58cc4def", "这是一段测试分享文本", i);
    }

    public final void g() {
        n75 n75Var = new n75("lxed7e31ca58cc4def");
        n75Var.g = "https://wine-avatar.cdn.lianxinapp.com/avatar/2021/3/22/d/z/2412587877318656-8-2-c446f56c083c4259afcce6ed86046e8a-qqd6qy.png";
        n75Var.h = "有信念的Miles";
        n75Var.b = "http://118.24.72.19/webapp-demo/";
        n75Var.d = "更多好友等着你";
        n75Var.e = "这是WebApp的desc";
        n75Var.f = "http://file.market.xiaomi.com/thumbnail/jpeg/l395/AppStore/074c2e5e646c547520a507fda76c4c8726b5624a4";
        com.zenmen.openapi.share.a.h(this, n75Var);
    }

    public final void h(int i) {
        n75 n75Var = new n75("lxed7e31ca58cc4def");
        n75Var.k = i;
        n75Var.b = "https://lianxinapp.com";
        n75Var.d = "连信";
        n75Var.e = "连信，快速遇到心仪的Ta";
        n75Var.f = "https://lianxinapp.com/img/logo.png";
        com.zenmen.openapi.share.a.g(this, n75Var);
    }

    public final void i() {
        ah ahVarC = ah.c("TestActivity", "testBtn");
        String str = this.b[new Random().nextInt(4)];
        f84.e(ahVarC, str);
        sy5.f(this, str, 1).g();
    }

    public final void j(String str) {
        ua3 ua3Var = new ua3(this, new b());
        om omVar = new om();
        omVar.f19789a = "O0001";
        omVar.d = "7ffa40fadfb340439fb5deb92f131939";
        omVar.b = str;
        omVar.c = "testOpenApi";
        ua3Var.n(omVar);
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R$id.btn2 || id == R$id.btn_yxd || id == R$id.btn_zf || id == R$id.btn3) {
            return;
        }
        if (id == R$id.btn4) {
            i();
            return;
        }
        if (id == R$id.btn5) {
            j("BASE");
            return;
        }
        if (id == R$id.btn6) {
            j("MOBILE");
            return;
        }
        if (id == R$id.btn9) {
            b();
            return;
        }
        if (id == R$id.btn10) {
            a();
            return;
        }
        if (id == R$id.btn11) {
            f(0);
            return;
        }
        if (id == R$id.btn12) {
            f(1);
            return;
        }
        if (id == R$id.btn13) {
            h(0);
            return;
        }
        if (id == R$id.btn14) {
            h(1);
            return;
        }
        if (id == R$id.btn15) {
            d(0);
            return;
        }
        if (id == R$id.btn16) {
            d(1);
            return;
        }
        if (id == R$id.btn17) {
            e(0);
            return;
        }
        if (id == R$id.btn18) {
            e(1);
        } else if (id == R$id.btn19) {
            g();
        } else if (id == R$id.btn20) {
            c();
        }
    }

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.layout_act_openapi_test);
        this.f12028a = (Button) findViewById(R$id.btn1);
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }
}
