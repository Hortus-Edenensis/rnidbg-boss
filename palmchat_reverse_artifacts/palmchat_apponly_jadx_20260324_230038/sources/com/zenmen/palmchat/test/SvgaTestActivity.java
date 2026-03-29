package com.zenmen.palmchat.test;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.SwipeBackLayout.app.SwipeBackActivity;
import com.zenmen.palmchat.giftkit.GiftBizType;
import com.zenmen.palmchat.giftkit.play.GiftPlayVo;
import defpackage.ey1;
import defpackage.ov;
import defpackage.wb2;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class SvgaTestActivity extends SwipeBackActivity {
    public wb2 r;
    public long s = 0;
    public long t = 0;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SvgaTestActivity.this.r.K(SvgaTestActivity.this.D1(10001L, "aaa", "跑车", "http://xxxxxx", "http://static3.lx-qa.com/static/resource/files/10001.svga", 1, "f99349399h9", "大金链子", "https://static3.lx-qa.com/avatar/u/c/2022/4/24/p/e/1lvj2fsz08w-1-2-783c6bd122104348ac94fff686e0b2ae-rau22v_small.png", "fgfefwf", "灭霸1号", "", 1, 0L));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SvgaTestActivity.this.r.K(SvgaTestActivity.this.D1(10002L, "bbb", "天使", "http://xxxxxx", "http://xxxxxx", 1, "f99349399h9", "小萝卜头", "https://static3.lx-qa.com/avatar/u/c/2022/3/25/a/x/1lz0bf3qsxs-1-2-7d8455062f454b98ad7869c53eb45fed-r9aolu_small.png", "htjsts", "灭霸2号", "", 0, 22L));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SvgaTestActivity.this.r.K(SvgaTestActivity.this.D1(10003L, "ccc", "玫瑰花", "http://xxxxxx", "http://xxxxxx", 512, "f99349399h9", "如花飘飘", "https://uimg01.51y5.net/wk003/M00/9A/47/CgIagWKpbFaAS3hJAAAbuFJ0oio5.cache", "hjweiofhvgiewhfi", "灭霸3号", "", 0, 0L));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TextView f15481a;

        public d(TextView textView) {
            this.f15481a = textView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SvgaTestActivity svgaTestActivity = SvgaTestActivity.this;
            long j = svgaTestActivity.s + 1;
            svgaTestActivity.s = j;
            GiftPlayVo giftPlayVoD1 = svgaTestActivity.D1(10004L, "ddd", "圣诞礼物", "http://xxxxxx", "http://xxxxxx", 1, "f99349399h9", "风一样的男人", "https://static3.lx-qa.com/avatar/u/c/2022/4/24/p/e/1lvj2fsz08w-1-2-783c6bd122104348ac94fff686e0b2ae-rau22v_small.png", "aifgheiwgagv", "灭霸4号", "", 0, j);
            this.f15481a.setText("x" + SvgaTestActivity.this.s);
            SvgaTestActivity.this.r.K(giftPlayVoD1);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TextView f15482a;

        public e(TextView textView) {
            this.f15482a = textView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SvgaTestActivity svgaTestActivity = SvgaTestActivity.this;
            long j = svgaTestActivity.t + 1;
            svgaTestActivity.t = j;
            GiftPlayVo giftPlayVoD1 = svgaTestActivity.D1(10005L, "eee", "女神", "http://xxxxxx", "http://xxxxxx", 1, "f99349399h9", "键盘侠", "https://uimg01.51y5.net/wk003/M00/9A/47/CgIagWKpbFaAS3hJAAAbuFJ0oio5.cache", "lgeiogawbfwfwf", "灭霸5号", "", 0, j);
            this.f15482a.setText("x" + SvgaTestActivity.this.t);
            SvgaTestActivity.this.r.K(giftPlayVoD1);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SvgaTestActivity.this.r.K(SvgaTestActivity.this.D1(520L, "fff", "我爱你", "http://static3.lx-qa.com/static/resource/imgs/20110i.png", "http://static3.lx-qa.com/static/resource/files/20110.svga", 520, "f99349399h9", "嘻嘻公主", "https://uimg01.51y5.net/wk003/M00/9A/47/CgIagWKpbFaAS3hJAAAbuFJ0oio5.cache", "afiewfgb3n2sb", "灭霸6号", "", 2, 0L));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TextView f15484a;

        public g(TextView textView) {
            this.f15484a = textView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SvgaTestActivity.this.s = 0L;
            this.f15484a.setText("x0");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TextView f15485a;

        public h(TextView textView) {
            this.f15485a = textView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SvgaTestActivity.this.t = 0L;
            this.f15485a.setText("x0");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class i implements View.OnClickListener {

        /* JADX INFO: compiled from: SearchBox */
        public class a implements ey1<String, String> {
            public a() {
            }

            @Override // defpackage.ey1
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void b(String str) {
                Toast.makeText(SvgaTestActivity.this, "下载失败:" + str, 0).show();
            }

            @Override // defpackage.ey1
            /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
            public void a(String str) {
                Toast.makeText(SvgaTestActivity.this, "下载成功：" + str, 0).show();
            }
        }

        public i() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ov.a(1L, "http://static3.lx-qa.com/static/resource/files/20110.svga", new a());
        }
    }

    @NonNull
    public final GiftPlayVo D1(long j, String str, String str2, String str3, String str4, int i2, String str5, String str6, String str7, String str8, String str9, String str10, int i3, long j2) {
        GiftPlayVo giftPlayVo = new GiftPlayVo();
        giftPlayVo.itemId = j;
        giftPlayVo.relatedId = str;
        giftPlayVo.itemName = str2;
        giftPlayVo.iconUrl = str3;
        giftPlayVo.showIconUrl = str4;
        giftPlayVo.itemCount = i2;
        giftPlayVo.fromUserId = str5;
        giftPlayVo.fromUserName = str6;
        giftPlayVo.fromUserAvatarUrl = str7;
        giftPlayVo.toUserId = str8;
        giftPlayVo.toUserName = str9;
        giftPlayVo.toUserAvatarUrl = str10;
        giftPlayVo.priceLevel = i3;
        giftPlayVo.comboNumber = j2;
        return giftPlayVo;
    }

    @Override // com.zenmen.palmchat.SwipeBackLayout.app.SwipeBackActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_test_svga);
        this.r = new wb2(this, GiftBizType.VoiceRoom, (FrameLayout) findViewById(R.id.large_gift_container), (FrameLayout) findViewById(R.id.small_gift_container));
        Button button = (Button) findViewById(R.id.btn_gift_car);
        Button button2 = (Button) findViewById(R.id.btn_gift_angel);
        Button button3 = (Button) findViewById(R.id.btn_gift_rose);
        Button button4 = (Button) findViewById(R.id.btn_gift_merry_christmas);
        TextView textView = (TextView) findViewById(R.id.tv_gift_merry_christmas_comb_number);
        Button button5 = (Button) findViewById(R.id.btn_gift_merry_christmas_comb_clear);
        Button button6 = (Button) findViewById(R.id.btn_gift_godless);
        TextView textView2 = (TextView) findViewById(R.id.tv_gift_godless_comb_number);
        Button button7 = (Button) findViewById(R.id.btn_gift_godless_comb_clear);
        Button button8 = (Button) findViewById(R.id.btn_gift_i_love_you);
        Button button9 = (Button) findViewById(R.id.btn_download);
        button.setOnClickListener(new a());
        button2.setOnClickListener(new b());
        button3.setOnClickListener(new c());
        button4.setOnClickListener(new d(textView));
        button6.setOnClickListener(new e(textView2));
        button8.setOnClickListener(new f());
        button5.setOnClickListener(new g(textView));
        button7.setOnClickListener(new h(textView2));
        button9.setOnClickListener(new i());
    }
}
