package com.zenmen.palmchat.opensdk.share;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.CheckBox;
import androidx.annotation.Nullable;
import com.huawei.hms.ads.ex;
import com.opos.acs.st.utils.ErrorContants;
import com.zenmen.openapi.share.OpenShare;
import com.zenmen.palmchat.R;
import defpackage.b94;
import defpackage.q84;
import defpackage.s84;
import defpackage.u84;
import defpackage.v84;
import defpackage.z84;
import java.io.File;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class LXTestShareActivity extends Activity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f14771a = Environment.getExternalStorageDirectory().getPath() + File.separator + "wifilog";

    public final void a() {
        boolean zIsChecked = ((CheckBox) findViewById(R.id.chk_image)).isChecked();
        File file = new File(f14771a, "ic_avatar1.png");
        File file2 = new File(f14771a, "ic_avatar2.png");
        File file3 = new File(f14771a, "ic_avatar3.png");
        q84 q84Var = new q84(file.getAbsolutePath());
        q84Var.f("https://palmchat.cdn.lianxinapp.com/static/resource/logo/wine/w6.png");
        q84Var.g("图片分享");
        q84Var.e("作者");
        q84Var.d("https://palmchat.cdn.lianxinapp.com/static/resource/logo/wine/w6.png");
        q84 q84Var2 = new q84(file2.getAbsolutePath());
        q84Var2.f("https://palmchat.cdn.lianxinapp.com/static/resource/logo/wine/w6.png");
        q84Var2.g("图片分享2");
        q84 q84Var3 = new q84(file3.getAbsolutePath());
        q84Var3.f("https://palmchat.cdn.lianxinapp.com/static/resource/logo/wine/w6.png");
        q84Var3.g("图片分享3");
        new OpenShare.a().g(this).f("111111").h(zIsChecked ? 1 : 0).n(q84Var, q84Var2, q84Var3).e().share();
    }

    public final void b() {
        boolean zIsChecked = ((CheckBox) findViewById(R.id.chk_miniapp)).isChecked();
        u84 u84Var = new u84();
        u84Var.q("小程序标题");
        u84Var.n("小程序副标题");
        u84Var.r("http://www.baidu.com");
        u84Var.o("https://uimg01.51y5.net/wk003/M00/07/AA/CgIagVzrJI2AR67dAAAWqMQl-x81.cache");
        u84Var.v("https://wine-avatar.cdn.lianxinapp.com/avatar/2021/3/22/d/z/2412587877318656-8-2-c446f56c083c4259afcce6ed86046e8a-qqd6qy.png");
        u84Var.w("掌上新闻");
        u84Var.f("https://palmchat.cdn.lianxinapp.com/static/resource/logo/wine/w6.png");
        u84Var.g("小程序分享");
        u84Var.e("作者");
        u84Var.p(Uri.parse("zenxin://webapp").buildUpon().appendQueryParameter("url", "https://www.jianshu.com/").toString());
        new OpenShare.a().f("121211111").g(this).h(zIsChecked ? 1 : 0).j(u84Var).e().share();
    }

    public final void c() {
        boolean zIsChecked = ((CheckBox) findViewById(R.id.chk_namecard)).isChecked();
        s84 s84Var = new s84();
        s84Var.q("名片标题");
        s84Var.n("名片副标题");
        s84Var.r("http://www.baidu.com");
        s84Var.o("https://uimg01.51y5.net/wk003/M00/07/AA/CgIagVzrJI2AR67dAAAWqMQl-x81.cache");
        s84Var.f("https://palmchat.cdn.lianxinapp.com/static/resource/logo/wine/w6.png");
        s84Var.g("名片分享");
        s84Var.e("作者");
        new OpenShare.a().f("12333").g(this).h(zIsChecked ? 1 : 0).i(s84Var).e().share();
    }

    public final void d() {
        boolean zIsChecked = ((CheckBox) findViewById(R.id.chk_video)).isChecked();
        String string = Uri.parse("zenxin://webapp").buildUpon().appendQueryParameter("url", "http://www.baidu.com").appendQueryParameter("web_url_origin", "http://www.baidu.com").appendQueryParameter("BackgroundColor", String.valueOf(-1)).appendQueryParameter("extra_key_from_uid", "4933753106186240").appendQueryParameter("from_source", "5").appendQueryParameter("web_show_right_menu", ex.Code).appendQueryParameter("extra_key_full_window", ex.V).appendQueryParameter("sourceType", ErrorContants.LOAD_STRATEGY_ERROR).appendQueryParameter("extra_key_biz_type", "0").appendQueryParameter("extra_key_mid", "tu5f1619591419468").appendQueryParameter("extra_key_from_ads", ex.V).toString();
        v84 v84Var = new v84();
        v84Var.p("https://wine-avatar.cdn.lianxinapp.com/avatar/2021/3/22/d/z/2412587877318656-8-2-c446f56c083c4259afcce6ed86046e8a-qqd6qy.png");
        v84Var.q("掌上新闻");
        v84Var.r("https://pre-vgw.ilxshow.com/alps/vbs/parse.do?pd=AG/AhztZJbzpBpMk4n7lQYaAIHH7NILWqDCdaU1TlZrKe1YFd8huNy6+7PsraaZuPnTCxNi13k8SQ/b5LJJ6CU3eUkgdNKXO4n0iKKJp97E7r0FRzYZ82qK8FrWshVRHNy7oZZHnJ75E47v4Iv4c2xQwPfB5sX2dDeHfT4+IVaQ=");
        v84Var.t("老婆，我扶你起来，干嘛打我");
        v84Var.u(string);
        v84Var.f("https://palmchat.cdn.lianxinapp.com/static/resource/logo/wine/w6.png");
        v84Var.g("视频号");
        v84Var.e("作者");
        v84Var.v("https://pre-vgw.ilxshow.com/alps/vbs/parse.do?pd=AG/AhztZJbzpBpMk4n7lQV7+xMi8muCdke0xNJZ+fNJccOQjP3qWOzIFBvZxKb5rPnTCxNi13k8SQ/b5LJJ6CWA5rsfLchof8vMCXU0fDIAxcaIYThQsiVEezfmniyzI7kyfGHz9Zb4+xoZcfLmJZRQwPfB5sX2dDeHfT4+IVaQ=");
        new OpenShare.a().g(this).f("111111").h(zIsChecked ? 1 : 0).k(v84Var).e().share();
    }

    public final void e() {
        boolean zIsChecked = ((CheckBox) findViewById(R.id.chk_txt)).isChecked();
        z84 z84Var = new z84("测试文本描述");
        z84Var.f("https://palmchat.cdn.lianxinapp.com/static/resource/logo/wine/w6.png");
        z84Var.g("文本分享");
        z84Var.e("作者");
        new OpenShare.a().f("12333").g(this).h(zIsChecked ? 1 : 0).l(z84Var).e().share();
    }

    public final void f() {
        boolean zIsChecked = ((CheckBox) findViewById(R.id.chk_web)).isChecked();
        b94 b94Var = new b94();
        b94Var.r("http://www.baidu.com");
        b94Var.q("主题描述");
        b94Var.n("介绍描述");
        b94Var.o("https://uimg01.51y5.net/wk003/M00/07/AA/CgIagVzrJI2AR67dAAAWqMQl-x81.cache");
        b94Var.f("https://palmchat.cdn.lianxinapp.com/static/resource/logo/wine/w6.png");
        b94Var.g("链接分享");
        b94Var.e("作者");
        new OpenShare.a().g(this).f("1234567890").h(zIsChecked ? 1 : 0).m(b94Var).e().share();
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_share_image /* 2131362623 */:
                a();
                break;
            case R.id.btn_share_miniapp /* 2131362624 */:
                b();
                break;
            case R.id.btn_share_namecard /* 2131362625 */:
                c();
                break;
            case R.id.btn_share_sm /* 2131362627 */:
                d();
                break;
            case R.id.btn_share_txt /* 2131362629 */:
                e();
                break;
            case R.id.btn_share_web /* 2131362630 */:
                f();
                break;
        }
    }

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_lx_test_share);
    }
}
