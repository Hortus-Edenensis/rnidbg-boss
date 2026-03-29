package com.zenmen.palmchat.test;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.ComponentName;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.RequestFuture;
import com.baidu.platform.comapi.bmsdk.BmLocated;
import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;
import com.tencent.matrix.trace.config.SharePluginInfo;
import com.umeng.umcrash.UMCrash;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.MainTabsActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.Vo.MessageVo;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.activity.webview.CordovaWebActivity;
import com.zenmen.palmchat.activity.webview.TransparentCordovaWebActivity;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.contacts.ContactsService;
import com.zenmen.palmchat.database.DBUriManager;
import com.zenmen.palmchat.framework.FrameworkBaseActivity;
import com.zenmen.palmchat.framework.network.LXBaseNetBean;
import com.zenmen.palmchat.giftkit.GiftPanel;
import com.zenmen.palmchat.giftkit.bean.VoiceRoomSelectMemberItem;
import com.zenmen.palmchat.giftkit.widgit.VoiceRoomSelectMemberView;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import com.zenmen.palmchat.network.VolleyNetwork;
import com.zenmen.palmchat.opensdk.share.LXTestShareActivity;
import com.zenmen.palmchat.settings.cert.a;
import com.zenmen.palmchat.teenagersmode.TeenagersModeManager;
import com.zenmen.palmchat.test.TestActivity;
import com.zenmen.palmchat.utils.captcha.CaptchaManager;
import com.zenmen.palmchat.utils.captcha.CaptchaResult;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.palmchat.wallet.WalletActivity;
import com.zenmen.palmchat.webplatform.WebModuleActivity;
import com.zenmen.palmchat.widget.LXBottomSheetDialog;
import com.zenmen.square.show.ShowMainActivity;
import defpackage.ad1;
import defpackage.ap4;
import defpackage.az2;
import defpackage.bo0;
import defpackage.dt5;
import defpackage.fn2;
import defpackage.g13;
import defpackage.go2;
import defpackage.ha3;
import defpackage.hs;
import defpackage.iq5;
import defpackage.ir5;
import defpackage.it0;
import defpackage.jo6;
import defpackage.k86;
import defpackage.l50;
import defpackage.lh6;
import defpackage.nb3;
import defpackage.nl0;
import defpackage.nn4;
import defpackage.r75;
import defpackage.rb3;
import defpackage.ry5;
import defpackage.st2;
import defpackage.sw4;
import defpackage.sy5;
import defpackage.tj2;
import defpackage.to;
import defpackage.u93;
import defpackage.uy5;
import defpackage.v4;
import defpackage.xn3;
import defpackage.xp3;
import defpackage.y63;
import defpackage.zw4;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class TestActivity extends BaseActionBarActivity {
    public VoiceRoomSelectMemberView B;
    public GiftPanel C;
    public GiftPanel E;
    public Button q;
    public Button r;
    public Button s;
    public Button t;
    public Button u;
    public Button v;
    public Button w;
    public Button x;
    public Button y;
    public EditText z = null;
    public List<byte[]> A = new ArrayList(4096);
    public ServiceConnection F = new n1();

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            TestActivity.this.b2();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a0 implements View.OnClickListener {
        public a0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                fn2 messagingServiceInterface = TestActivity.this.getMessagingServiceInterface();
                if (messagingServiceInterface != null && messagingServiceInterface.isConnected() && messagingServiceInterface.w()) {
                    messagingServiceInterface.E();
                }
            } catch (RemoteException e) {
                e.printStackTrace();
            }
            AppContext.getContext().logout();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            hs.d(null, null);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b0 implements View.OnClickListener {
        public b0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TestActivity.this.sendLocalBroadcast(new Intent(FrameworkBaseActivity.INTENT_ACTION_KICKOUT));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b1 implements View.OnClickListener {
        public b1() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TestActivity.this.startActivity(new Intent(TestActivity.this, (Class<?>) LXTestShareActivity.class));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TestActivity.this.startActivity(new Intent(TestActivity.this, (Class<?>) SvgaTestActivity.class));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c0 implements View.OnClickListener {
        public c0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) throws Throwable {
            TestActivity.this.U1();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c1 implements a.b {
        public c1() {
        }

        @Override // com.zenmen.palmchat.settings.cert.a.b
        public void onResult(boolean z) {
            LogUtil.i("CertManager", "testRealName=" + z);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            TestActivity.this.e2();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d0 implements View.OnClickListener {
        public d0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TestActivity.this.startActivity(new Intent(TestActivity.this.getApplicationContext().getApplicationContext(), (Class<?>) SwipeTestActivity.class));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d1 implements View.OnClickListener {
        public d1() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            to.d(AppContext.getContext(), 11);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            TestActivity.this.startActivity(new Intent(TestActivity.this, (Class<?>) SxActivity.class));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e0 implements View.OnClickListener {

        /* JADX INFO: compiled from: SearchBox */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                y63.x();
            }
        }

        public e0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            new g13(new a()).start();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e1 implements View.OnClickListener {
        public e1() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            throw null;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            TestActivity.this.c2();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f0 implements View.OnClickListener {
        public f0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            iq5.j(false, new String[0]);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g implements View.OnClickListener {
        public g() {
        }

        public static /* synthetic */ void b() {
            try {
                ContactInfoItem contactInfoItemL = bo0.r().l("5916382898751488");
                if (contactInfoItemL == null) {
                    return;
                }
                contactInfoItemL.setBizType(64);
                MessageVo messageVoG = defpackage.u0.g(contactInfoItemL);
                messageVoG.isRead = false;
                messageVoG.isSend = false;
                messageVoG.mimeType = 35;
                messageVoG.data1 = String.valueOf(1);
                messageVoG.data2 = String.valueOf(1);
                messageVoG.status = 2;
                messageVoG.bizType = contactInfoItemL.getBizType();
                messageVoG.extention = "{\n    \"headIconUrl\":\"\",\n    \"nickname\":\"\",\n    \"exid\":\"\",\n    \"giftMsg\":{\n        \"title\":\"送你1份礼物\",\n        \"subTitle\":\"心动的信号(会员专享)\",\n        \"action\":\"回礼给TA\",\n        \"itemId\":111,\n        \"itemName\":\"心动的信号\",\n        \"iconUrl\":\"http://static3.lx-qa.com/static/resource/imgs/20110i.png\",\n        \"showIconUrl\":\"http://static3.lx-qa.com/static/resource/files/10001.svga\",\n        \"itemCount\":1,\n        \"comboNumber\":1,\n        \"priceLevel\":1,\n        \"relatedId\":111,\n        \"itemType\":1\n    }\n}";
                com.zenmen.palmchat.database.b.t(messageVoG);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            new g13(new Runnable() { // from class: hu5
                @Override // java.lang.Runnable
                public final void run() {
                    TestActivity.g.b();
                }
            }).start();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g0 extends LXBottomSheetDialog {
        public g0(Context context) {
            super(context);
        }

        @Override // com.zenmen.palmchat.widget.LXBottomSheetDialog
        public View n() {
            return (ViewGroup) LayoutInflater.from(getContext()).inflate(R.layout.activity_main, (ViewGroup) null);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g1 implements View.OnClickListener {
        public g1() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            UMCrash.generateCustomLog("this is custom error", "CUSTOM_ERROR_TYPE");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h implements View.OnClickListener {
        public h() {
        }

        public static /* synthetic */ void b() {
            try {
                ContactInfoItem contactInfoItemL = bo0.r().l("5916382898751488");
                if (contactInfoItemL == null) {
                    return;
                }
                contactInfoItemL.setBizType(64);
                MessageVo messageVoG = defpackage.u0.g(contactInfoItemL);
                messageVoG.mimeType = 35;
                messageVoG.data1 = String.valueOf(1);
                messageVoG.data2 = String.valueOf(1);
                messageVoG.status = 2;
                messageVoG.bizType = contactInfoItemL.getBizType();
                messageVoG.extention = "{\n    \"headIconUrl\":\"\",\n    \"nickname\":\"\",\n    \"exid\":\"\",\n    \"giftMsg\":{\n        \"title\":\"送你1份礼物\",\n        \"subTitle\":\"心动的信号(会员专享)\",\n        \"action\":\"继续赠送\",\n        \"itemId\":111,\n        \"itemName\":\"心动的信号\",\n        \"iconUrl\":\"http://static3.lx-qa.com/static/resource/imgs/20110i.png\",\n        \"showIconUrl\":\"http://static3.lx-qa.com/static/resource/files/10001.svga\",\n        \"itemCount\":1,\n        \"comboNumber\":1,\n        \"priceLevel\":1,\n        \"relatedId\":111,\n        \"itemType\":1\n    }\n}";
                com.zenmen.palmchat.database.b.t(messageVoG);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            new g13(new Runnable() { // from class: iu5
                @Override // java.lang.Runnable
                public final void run() {
                    TestActivity.h.b();
                }
            }).start();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h0 implements View.OnClickListener {
        public h0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                TestActivity.this.getMessagingServiceInterface().j();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
            throw null;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h1 implements View.OnClickListener {

        /* JADX INFO: compiled from: SearchBox */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                TestActivity.this.X1();
            }
        }

        public h1() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            new g13(new a()).start();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class i implements View.OnClickListener {
        public i() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            ha3.b(TestActivity.this, "102", "5600613748933632", "https://storage0.lx-qa.com/mdc/res/v5/1/1jf4bdymadc-6-2-cd0d4b33162c43fe8ccf50939f01f65a-qzxlwc", "测试昵称");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class i0 implements View.OnClickListener {

        /* JADX INFO: compiled from: SearchBox */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                new AlertDialog.Builder(TestActivity.this).setTitle("test").create().show();
            }
        }

        public i0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TestActivity.this.finish();
            u93.b(2000, new a());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class i1 implements View.OnClickListener {
        public i1() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            while (true) {
                try {
                    Thread.sleep(1L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class j implements View.OnClickListener {
        public j() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ry5.a("功能已下线");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class j0 implements View.OnClickListener {
        public j0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TestActivity.this.h2();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class j1 implements View.OnClickListener {
        public j1() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                Thread.sleep(3000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class k extends go2<LXBaseNetBean<Object>> {
        public k() {
        }

        @Override // defpackage.ho2
        public sw4 getRequestArgs() {
            HashMap map = new HashMap();
            map.put("fexid", "Kfm6BjmoVLdr8vYSFwAEWG-1-1-DOBui");
            map.put("fuid", "");
            map.put("reqId", xn3.a());
            return sw4.b(1, nl0.z + "/userem.getUserDetail.v4", map);
        }

        @Override // defpackage.io2
        public void onResult(boolean z, LXBaseNetBean<Object> lXBaseNetBean, Exception exc) {
            Log.e("performRequestAsync", "onResult=" + az2.c(lXBaseNetBean));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class k0 implements View.OnClickListener {
        public k0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            r75.m(TestActivity.this);
            r75.a(TestActivity.this);
            SPUtil.f14322a.w();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class k1 implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Button f15524a;

        public k1(Button button) {
            this.f15524a = button;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (jo6.K()) {
                jo6.L();
                uy5.a("已输出日志日志!!");
            } else {
                jo6.N(true);
                this.f15524a.setText("打印太极读取次数（10次+）");
                uy5.a("已开启!!");
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class l implements View.OnClickListener {
        public l() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ry5.a("功能已下线");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class l0 implements View.OnClickListener {

        /* JADX INFO: compiled from: SearchBox */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                String[] stringArray = AppContext.getContext().getResources().getStringArray(R.array.contacts_resources);
                for (int i = 0; i < stringArray.length; i++) {
                    for (int i2 = 0; i2 < 10; i2++) {
                        TestActivity.this.W1("测试" + stringArray[i] + i2, "126001" + Integer.valueOf((i * 100) + i2));
                    }
                }
            }
        }

        public l0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            new g13(new a()).start();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class l1 extends HashMap<String, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f15528a;
        public final /* synthetic */ int b;
        public final /* synthetic */ long c;
        public final /* synthetic */ long d;
        public final /* synthetic */ long e;

        public l1(String str, int i, long j, long j2, long j3) {
            this.f15528a = str;
            this.b = i;
            this.c = j;
            this.d = j2;
            this.e = j3;
            put("url", str);
            put("type", Integer.valueOf(i));
            put(SharePluginInfo.ISSUE_COST, Long.valueOf(j - j2));
            put("tag", "testAccessDispatchServer");
            put(com.umeng.analytics.pro.f.p, Long.valueOf(j3));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class m implements View.OnClickListener {
        public m() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            Intent intent = new Intent();
            intent.putExtra("url", "file:///android_asset/test_wallet_web.html");
            intent.setClass(TestActivity.this, WalletActivity.class);
            TestActivity.this.startActivity(intent);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class m0 implements View.OnClickListener {
        public m0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TestActivity.this.startActivity(new Intent(TestActivity.this, (Class<?>) SqliteTestActivity.class));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class m1 implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ EditText f15531a;
        public final /* synthetic */ TextView b;

        public m1(EditText editText, TextView textView) {
            this.f15531a = editText;
            this.b = textView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String string = TestActivity.this.z.getText().toString();
            String string2 = this.f15531a.getText().toString();
            if (TextUtils.isEmpty(string) || TextUtils.isEmpty(string2)) {
                sy5.f(TestActivity.this, "invalidate params", 1).g();
                return;
            }
            try {
                PhoneNumberUtil phoneNumberUtil = PhoneNumberUtil.getInstance();
                Phonenumber.PhoneNumber phoneNumber = phoneNumberUtil.parse(string, string2);
                this.b.setText("countryCode:" + phoneNumber.getCountryCode() + ",num:" + phoneNumber.getNationalNumber() + ",type:" + phoneNumberUtil.getNumberType(phoneNumber) + ",ex:" + phoneNumberUtil.getExampleNumber(string2) + ",isValid:" + phoneNumberUtil.isValidNumber(phoneNumber) + ",regionCode:" + phoneNumberUtil.getRegionCodeForCountryCode(phoneNumber.getCountryCode()) + ",toString:" + phoneNumber.toString());
                sy5.f(TestActivity.this, "success ", 1).g();
            } catch (NumberParseException e) {
                e.printStackTrace();
                sy5.f(TestActivity.this, "fail ", 1).g();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class n implements View.OnClickListener {
        public n() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            nb3.j(TestActivity.this);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class n0 implements View.OnClickListener {

        /* JADX INFO: compiled from: SearchBox */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                for (int i = 0; i < 50; i++) {
                    long jB = ir5.b();
                    TestActivity.this.f2(true, null, 0, jB);
                    TestActivity.this.f2(false, "http://210.51.31.54:10000/dispatch", 1, jB);
                    TestActivity.this.f2(false, "http://114.80.135.128:10000/dispatch", 2, jB);
                    TestActivity.this.f2(false, "http://221.130.195.11:10000/dispatch", 3, jB);
                }
            }
        }

        public n0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            new g13(new a()).start();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class n1 implements ServiceConnection {
        public n1() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            LogUtil.e("ServiceConnection", "onServiceConnected");
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            TestActivity.this.T1();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class o implements View.OnClickListener {
        public o() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            l50.a();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class o0 implements View.OnClickListener {
        public o0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TestActivity.this.getContentResolver().delete(ContactsContract.RawContacts.CONTENT_URI, null, null);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class p0 implements View.OnClickListener {
        public p0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TestActivity.this.g2();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class p1 extends Thread {

        /* JADX INFO: compiled from: SearchBox */
        public class a extends Thread {
            public a(String str) {
                super(str);
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                super.run();
                while (true) {
                    try {
                        Thread.sleep(3000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        public p1(String str) {
            super(str);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            super.run();
            int i = 0;
            while (true) {
                StringBuilder sb = new StringBuilder();
                sb.append("TestOomOfCreateThread-");
                i++;
                sb.append(i);
                new a(sb.toString()).start();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class q implements View.OnClickListener {
        public q() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            l50.a();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class q0 implements View.OnClickListener {
        public q0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TestActivity.this.startActivity(new Intent(TestActivity.this, (Class<?>) VideoTestActivity.class));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class q1 implements View.OnClickListener {
        public q1() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ShowMainActivity.E1(100, TestActivity.this);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class r implements View.OnClickListener {
        public r() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TestActivity.this.T1();
            TestActivity.this.startActivity(new Intent(TestActivity.this, (Class<?>) AdPlayActivity.class));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class r0 implements DialogInterface.OnDismissListener {
        public r0() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            Log.e(BaseActionBarActivity.TAG, "onDismiss");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class r1 implements View.OnClickListener {
        public r1() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TestActivity.this.j2();
            TestActivity.this.k2();
            TestActivity.this.l2();
            ap4.v();
            TestActivity.this.i2();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class s implements View.OnClickListener {
        public s() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            rb3.c(String.valueOf(System.currentTimeMillis()));
            TestActivity.this.a2("测试一句很长的话");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class s0 implements View.OnClickListener {
        public s0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TestActivity.this.Z1("file:///android_asset/test.html");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class s1 implements View.OnClickListener {
        public s1() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TestActivity.this.startActivity(new Intent(TestActivity.this, (Class<?>) PrivateChatTestActivity.class));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class t0 implements View.OnClickListener {
        public t0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TestActivity.this.Y1("file:///android_asset/test.html");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class u implements View.OnClickListener {
        public u() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Intent intent = new Intent(TestActivity.this.getApplicationContext().getApplicationContext(), (Class<?>) ContactsService.class);
            intent.setAction("action_get_friend_list");
            TestActivity.this.getApplicationContext().startService(intent);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class u0 implements View.OnClickListener {
        public u0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TestActivity.this.Z1("file:///android_asset/generic_test.html");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class v implements GiftPanel.i {
        public v() {
        }

        @Override // com.zenmen.palmchat.giftkit.GiftPanel.i
        public boolean a() {
            return false;
        }

        @Override // com.zenmen.palmchat.giftkit.GiftPanel.i
        public List<String> b() {
            ArrayList arrayList = new ArrayList();
            Set<VoiceRoomSelectMemberItem> selectedData = TestActivity.this.B.getSelectedData();
            if (selectedData != null) {
                Iterator<VoiceRoomSelectMemberItem> it = selectedData.iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next().userId);
                }
            }
            return arrayList;
        }

        @Override // com.zenmen.palmchat.giftkit.GiftPanel.i
        public int getHeight() {
            return k86.e(TestActivity.this, 70.0f);
        }

        @Override // com.zenmen.palmchat.giftkit.GiftPanel.i
        public View getView() {
            ViewGroup viewGroup = (ViewGroup) TestActivity.this.B.getParent();
            if (viewGroup != null) {
                viewGroup.removeAllViews();
            }
            return TestActivity.this.B;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class v0 implements View.OnClickListener {
        public v0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TestActivity.this.Y1("file:///android_asset/generic_test.html");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class x implements View.OnClickListener {
        public x() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TestActivity.this.startActivity(new Intent(TestActivity.this.getApplicationContext().getApplicationContext(), (Class<?>) MainTabsActivity.class));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class x0 implements View.OnClickListener {
        public x0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TestActivity.this.S1();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class y implements View.OnClickListener {
        public y() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            iq5.j(false, "3");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class y0 implements View.OnClickListener {
        public y0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Intent intent = new Intent();
            intent.setClass(TestActivity.this, CordovaWebActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("web_url", tj2.z());
            bundle.putBoolean("web_show_right_menu", false);
            bundle.putInt("BackgroundColor", -1);
            intent.putExtras(bundle);
            TestActivity.this.startActivity(intent);
            TestActivity.this.overridePendingTransition(R.anim.activity_translate_in, R.anim.scale_exit_out);
            sy5.f(TestActivity.this, tj2.z(), 1).g();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class z implements View.OnClickListener {
        public z() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            iq5.j(false, "2");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class z0 implements View.OnClickListener {
        public z0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TestActivity testActivity = TestActivity.this;
            testActivity.startActivity(st2.j(testActivity, tj2.r()));
            sy5.f(TestActivity.this, tj2.r(), 1).g();
        }
    }

    public final void S1() {
        try {
            Thread.sleep(30000L);
        } catch (InterruptedException unused) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0054 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void U1() throws Throwable {
        Throwable th;
        BufferedReader bufferedReader;
        IOException e2;
        BufferedReader bufferedReader2 = null;
        try {
            try {
                try {
                    bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("am instrument -w com.zenmen.palmchat.test/android.support.test.runner.AndroidJUnitRunner ").getInputStream()));
                    while (true) {
                        try {
                            String line = bufferedReader.readLine();
                            if (line == null) {
                                break;
                            }
                            Log.e("executeTest", "ExcuteTest: " + line);
                        } catch (IOException e3) {
                            e2 = e3;
                            e2.printStackTrace();
                            if (bufferedReader == null) {
                                return;
                            } else {
                                bufferedReader.close();
                            }
                        }
                    }
                    bufferedReader.close();
                } catch (Throwable th2) {
                    th = th2;
                    if (0 != 0) {
                        try {
                            bufferedReader2.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (IOException e5) {
                bufferedReader = null;
                e2 = e5;
            } catch (Throwable th3) {
                th = th3;
                if (0 != 0) {
                }
                throw th;
            }
        } catch (IOException e6) {
            e6.printStackTrace();
        }
    }

    public void V1() {
        this.z = (EditText) findViewById(R.id.phone_input);
        EditText editText = (EditText) findViewById(R.id.countrycode_input);
        TextView textView = (TextView) findViewById(R.id.parse_number);
        textView.setOnClickListener(new m1(editText, textView));
    }

    public boolean W1(String str, String str2) {
        try {
            ContentValues contentValues = new ContentValues();
            long id = ContentUris.parseId(getContentResolver().insert(ContactsContract.RawContacts.CONTENT_URI, contentValues));
            if (str != "") {
                contentValues.clear();
                contentValues.put("raw_contact_id", Long.valueOf(id));
                contentValues.put("mimetype", "vnd.android.cursor.item/name");
                contentValues.put("data2", str);
                getContentResolver().insert(ContactsContract.Data.CONTENT_URI, contentValues);
            }
            if (str2 != "") {
                contentValues.clear();
                contentValues.put("raw_contact_id", Long.valueOf(id));
                contentValues.put("mimetype", "vnd.android.cursor.item/phone_v2");
                contentValues.put("data1", str2);
                contentValues.put("data2", (Integer) 2);
                getContentResolver().insert(ContactsContract.Data.CONTENT_URI, contentValues);
            }
            contentValues.put("raw_contact_id", Long.valueOf(id));
            contentValues.put("mimetype", "vnd.android.cursor.item/photo");
            getContentResolver().insert(ContactsContract.Data.CONTENT_URI, contentValues);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public final void X1() {
        int i2 = 0;
        while (true) {
            byte[] bArr = new byte[BmLocated.ALIGN_RIGHT_BOTTOM];
            for (int i3 = 1; i3 < 10485760; i3 += 4096) {
                bArr[i3] = (byte) i3;
            }
            this.A.add(bArr);
            i2 += BmLocated.ALIGN_RIGHT_BOTTOM;
            Log.w("javaOOMCrash", String.format(Locale.US, "= Total %d bytes", Integer.valueOf(i2)));
        }
    }

    public final void Y1(String str) {
        WebView.setWebContentsDebuggingEnabled(true);
        Intent intent = new Intent();
        intent.setClass(this, WebModuleActivity.class);
        Bundle bundle = new Bundle();
        if (!TextUtils.isEmpty(this.z.getText().toString())) {
            str = this.z.getText().toString();
        }
        bundle.putString("web_url", str);
        bundle.putBoolean("extra_hide_menu", true);
        intent.putExtra("extra_status_bar_color", getResources().getColor(R.color.status_bar_color));
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public final void Z1(String str) {
        WebView.setWebContentsDebuggingEnabled(true);
        Intent intent = new Intent(this, (Class<?>) CordovaWebActivity.class);
        if (!TextUtils.isEmpty(this.z.getText().toString())) {
            str = this.z.getText().toString();
        }
        intent.putExtra("web_url", str);
        intent.putExtra("web_show_right_menu", false);
        startActivity(intent);
    }

    public final void b2() {
        g0 g0Var = new g0(this);
        g0Var.setOnDismissListener(new r0());
        g0Var.show();
    }

    public final void c2() {
        if (this.E == null) {
            GiftPanel giftPanel = new GiftPanel();
            this.E = giftPanel;
            giftPanel.l1(301, "userId");
        }
        this.E.s1(getSupportFragmentManager(), 0);
    }

    public final void d2() {
        sy5.f(this, "消息数" + com.zenmen.palmchat.database.b.r(DBUriManager.MsgSaveType.COMMON), 1).g();
    }

    public final void e2() {
        if (this.C == null) {
            GiftPanel giftPanel = new GiftPanel();
            this.C = giftPanel;
            giftPanel.l1(201, "roomId");
        }
        if (this.B == null) {
            VoiceRoomSelectMemberView voiceRoomSelectMemberView = new VoiceRoomSelectMemberView(this);
            this.B = voiceRoomSelectMemberView;
            voiceRoomSelectMemberView.addVoiceRoomMember(new VoiceRoomSelectMemberItem(v4.e(AppContext.getContext()), "房主", "https://static3.lx-qa.com/avatar/u/c/2022/4/24/p/e/1lvj2fsz08w-1-2-783c6bd122104348ac94fff686e0b2ae-rau22v_small.png", 0, true, false));
            for (int i2 = 0; i2 < 8; i2++) {
                String str = i2 % 2 == 0 ? "https://static3.lx-qa.com/avatar/u/c/2022/3/25/a/x/1lz0bf3qsxs-1-2-7d8455062f454b98ad7869c53eb45fed-r9aolu_small.png" : "https://static3.lx-qa.com/avatar/u/c/2022/4/24/p/e/1lvj2fsz08w-1-2-783c6bd122104348ac94fff686e0b2ae-rau22v_small.png";
                this.B.addVoiceRoomMember(new VoiceRoomSelectMemberItem("00" + i2, "用户" + i2, str, 0, false, false));
            }
        }
        this.C.i1("语音房Biz");
        this.C.r1("5955969370784768");
        this.C.K0(new v());
        this.C.s1(getSupportFragmentManager(), 0);
    }

    @SuppressLint({"LongLogTag"})
    public final void f2(boolean z2, String str, int i2, long j2) {
        String str2;
        if (z2) {
            str2 = "http://short.youni.im/dispatch?username=" + AccountUtils.p(AppContext.getContext());
        } else {
            str2 = str + "?username=" + AccountUtils.p(AppContext.getContext());
        }
        RequestQueue normalRequestQueue = VolleyNetwork.getNormalRequestQueue();
        RequestFuture requestFutureNewFuture = RequestFuture.newFuture();
        long jB = ir5.b();
        normalRequestQueue.add(new JsonObjectRequest(0, str2, null, requestFutureNewFuture, requestFutureNewFuture));
        try {
            JSONObject jSONObject = (JSONObject) requestFutureNewFuture.get(50L, TimeUnit.SECONDS);
            if (jSONObject != null) {
                jSONObject.getBoolean("success");
            }
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        } catch (ExecutionException e3) {
            e3.printStackTrace();
        } catch (TimeoutException e4) {
            e4.printStackTrace();
        } catch (JSONException e5) {
            e5.printStackTrace();
        }
        LogUtil.i("testAccessDispatchServer", 1, new l1(str2, i2, ir5.b(), jB, j2), (Throwable) null);
    }

    public final void h2() {
        Toast.makeText(this, "开始循环创建线程，请稍等!", 0).show();
        new p1("TestOomOfCreateThread-ROOT").start();
    }

    public final void i2() {
        com.zenmen.palmchat.settings.cert.a.a().d(this, new c1());
    }

    public final void initActionBar() {
        initToolbar(0);
    }

    public final void j2() {
        long jB = ir5.b();
        SharedPreferences sharedPreferences = getSharedPreferences(xn3.a(), 0);
        long jE = ir5.e(jB);
        long jB2 = ir5.b();
        sharedPreferences.getAll();
        LogUtil.i("MmkvSpWrapper", "create time =" + jE + "readtime=" + ir5.e(jB2));
    }

    public void jump2NewProfileEdit(View view) {
        startActivity(nn4.a(this, 10));
    }

    public final void l2() {
        xp3 xp3VarC = xp3.c("wifi_social_new_config");
        long jB = ir5.b();
        SharedPreferences sharedPreferences = getSharedPreferences("wifi_social_new_config", 0);
        sharedPreferences.getAll();
        long jE = ir5.e(jB);
        long jB2 = ir5.b();
        xp3VarC.d(sharedPreferences);
        LogUtil.i("MmkvSpWrapper", "mmkv im time =" + jE + "import=" + ir5.e(jB2));
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_main);
        initActionBar();
        findViewById(R.id.veRtc).setOnClickListener(new q1());
        findViewById(R.id.versionSet).setOnClickListener(new r1());
        findViewById(R.id.btn_private_chat_test).setOnClickListener(new s1());
        findViewById(R.id.btnbottom).setOnClickListener(new a());
        findViewById(R.id.voice_room).setOnClickListener(new b());
        findViewById(R.id.svga_test).setOnClickListener(new c());
        findViewById(R.id.btn_voiceroom_gift).setOnClickListener(new d());
        findViewById(R.id.btn_sx_test).setOnClickListener(new e());
        findViewById(R.id.btn_chat_gift).setOnClickListener(new f());
        findViewById(R.id.btn_insert_receive_gift_msg).setOnClickListener(new g());
        findViewById(R.id.btn_insert_send_gift_msg).setOnClickListener(new h());
        findViewById(R.id.btn_gift_panel).setOnClickListener(new i());
        Button button = (Button) findViewById(R.id.btn0);
        this.q = button;
        button.setOnClickListener(new j());
        Button button2 = (Button) findViewById(R.id.btn);
        this.r = button2;
        button2.setOnClickListener(new l());
        findViewById(R.id.btn004).setOnClickListener(new m());
        findViewById(R.id.btn005).setOnClickListener(new n());
        findViewById(R.id.btn006).setOnClickListener(new o());
        findViewById(R.id.btn007).setOnClickListener(new p());
        findViewById(R.id.btn008).setOnClickListener(new q());
        Button button3 = (Button) findViewById(R.id.btn1);
        this.s = button3;
        button3.setOnClickListener(new r());
        ((Button) findViewById(R.id.btn2)).setOnClickListener(new s());
        Button button4 = (Button) findViewById(R.id.btn3);
        this.t = button4;
        button4.setOnClickListener(new t());
        Button button5 = (Button) findViewById(R.id.btn4);
        this.u = button5;
        button5.setOnClickListener(new u());
        Button button6 = (Button) findViewById(R.id.btn5);
        this.v = button6;
        button6.setOnClickListener(new w());
        Button button7 = (Button) findViewById(R.id.btn6);
        this.w = button7;
        button7.setOnClickListener(new x());
        Button button8 = (Button) findViewById(R.id.btn7);
        this.x = button8;
        button8.setOnClickListener(new y());
        Button button9 = (Button) findViewById(R.id.btn8);
        this.y = button9;
        button9.setOnClickListener(new z());
        ((Button) findViewById(R.id.btn9)).setOnClickListener(new a0());
        ((Button) findViewById(R.id.btn10)).setOnClickListener(new b0());
        ((Button) findViewById(R.id.btn11)).setOnClickListener(new c0());
        ((Button) findViewById(R.id.btn12)).setOnClickListener(new d0());
        findViewById(R.id.test_sign_up).setOnClickListener(new e0());
        findViewById(R.id.test_sync).setOnClickListener(new f0());
        findViewById(R.id.test_crash).setOnClickListener(new h0());
        findViewById(R.id.test_crash_dialog).setOnClickListener(new i0());
        findViewById(R.id.test_oom_create_thread).setOnClickListener(new j0());
        findViewById(R.id.test_clear_sp).setOnClickListener(new k0());
        ((Button) findViewById(R.id.btn13)).setOnClickListener(new l0());
        ((Button) findViewById(R.id.btn15)).setOnClickListener(new m0());
        findViewById(R.id.btn16).setOnClickListener(new n0());
        ((Button) findViewById(R.id.btn14)).setOnClickListener(new o0());
        ((Button) findViewById(R.id.btn17)).setOnClickListener(new p0());
        ((Button) findViewById(R.id.btn18)).setOnClickListener(new q0());
        ((Button) findViewById(R.id.btn19)).setOnClickListener(new s0());
        ((Button) findViewById(R.id.btn191)).setOnClickListener(new t0());
        findViewById(R.id.generic_normal).setOnClickListener(new u0());
        findViewById(R.id.generic_inner).setOnClickListener(new v0());
        findViewById(R.id.btn192).setOnClickListener(new w0());
        ((Button) findViewById(R.id.btn20)).setOnClickListener(new x0());
        findViewById(R.id.btn21).setOnClickListener(new y0());
        findViewById(R.id.btn22).setOnClickListener(new z0());
        findViewById(R.id.btn23).setOnClickListener(new a1());
        findViewById(R.id.btn_share).setOnClickListener(new b1());
        findViewById(R.id.btn_badge).setOnClickListener(new d1());
        findViewById(R.id.btn_umeng_crash_java).setOnClickListener(new e1());
        findViewById(R.id.btn_umeng_crash_native).setOnClickListener(new f1());
        findViewById(R.id.btn_umeng_crash_custom).setOnClickListener(new g1());
        findViewById(R.id.btn_umeng_crash_oom).setOnClickListener(new h1());
        findViewById(R.id.btn_umeng_crash_anr).setOnClickListener(new i1());
        findViewById(R.id.btn_umeng_crash_kd).setOnClickListener(new j1());
        Button button10 = (Button) findViewById(R.id.btn_taichi_test);
        if (jo6.K()) {
            button10.setText("打印太极读取次数（10次+）");
        } else {
            button10.setText("开启记录太极读取次数");
        }
        button10.setOnClickListener(new k1(button10));
        V1();
        LogUtil.onEvent("test_comp", "1", "1", "2");
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        d2();
        dt5.b();
        jo6.a.b();
        zw4.e(new k());
        LogUtil.log4ClientError("test", new RuntimeException("test"));
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        super.bindMessagingService();
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        super.unBindMessagingService();
    }

    public void setPWD(View view) {
        TeenagersModeManager.a().c().g("1234");
        setResult(-1, new Intent());
        finish();
    }

    public void showCaptcha(View view) {
        CaptchaManager.c(this, null, new o1());
    }

    public void testHttpDnsWithPre(View view) {
        it0.l = true;
    }

    public void testLocationTimeout(View view) {
        com.zenmen.palmchat.location.d.l = true;
    }

    public void testWebBaiduError(View view) {
        Intent intent = new Intent();
        intent.setClass(this, TransparentCordovaWebActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("web_url", "https://www.baidu.com/");
        bundle.putString("page_index", ad1.d);
        bundle.putBoolean("extra_key_full_window", true);
        bundle.putBoolean("hide_progressbar", true);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void testWebGoogleError(View view) {
        Intent intent = new Intent();
        intent.setClass(this, TransparentCordovaWebActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("web_url", "https://www.google.com/");
        bundle.putString("page_index", ad1.d);
        bundle.putBoolean("extra_key_full_window", true);
        bundle.putBoolean("hide_progressbar", true);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void verifyPWD(View view) {
        setResult(-1, new Intent());
        finish();
    }

    public void voiceMatch(View view) {
        lh6.V().i0(this, 0, 1);
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a1 implements View.OnClickListener {
        public a1() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f1 implements View.OnClickListener {
        public f1() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class t implements View.OnClickListener {
        public t() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class w0 implements View.OnClickListener {
        public w0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    public final void a2(String str) {
    }

    public void jump2PeopleMatchRegPhotoActivity(View view) {
    }

    public void showAiPlayer(View view) {
    }

    /* JADX INFO: compiled from: SearchBox */
    public class w implements View.OnClickListener {
        public w() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            new g13(new a()).start();
        }

        /* JADX INFO: compiled from: SearchBox */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
            }
        }
    }

    public final void T1() {
    }

    public final void g2() {
    }

    public final void k2() {
    }

    /* JADX INFO: compiled from: SearchBox */
    public class o1 implements CaptchaManager.a {
        public o1() {
        }

        @Override // com.zenmen.palmchat.utils.captcha.CaptchaManager.a
        public void a(int i, CaptchaResult captchaResult) {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class p implements View.OnClickListener {
        public p() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            nb3.l(TestActivity.this, 100, new a());
        }

        /* JADX INFO: compiled from: SearchBox */
        public class a implements nb3.c {
            public a() {
            }

            @Override // nb3.c
            public void a(int i, String str, Object obj) {
            }
        }
    }
}
