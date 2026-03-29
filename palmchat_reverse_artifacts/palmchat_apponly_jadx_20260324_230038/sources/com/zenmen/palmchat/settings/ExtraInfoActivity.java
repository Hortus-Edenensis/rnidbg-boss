package com.zenmen.palmchat.settings;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import com.wifi.ad.core.WifiNestAd;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.database.DBUriManager;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.ac1;
import defpackage.az2;
import defpackage.dt5;
import defpackage.fn2;
import defpackage.jo6;
import defpackage.l50;
import defpackage.me1;
import defpackage.nl0;
import defpackage.r75;
import defpackage.rl0;
import defpackage.sy5;
import defpackage.t66;
import defpackage.u93;
import defpackage.xf5;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class ExtraInfoActivity extends BaseActionBarActivity implements View.OnClickListener {
    public TextView q;
    public View r;
    public TextView s;
    public TextView t;
    public Button u;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TextView f15178a;

        public a(TextView textView) {
            this.f15178a = textView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ViewGroup.LayoutParams layoutParams = this.f15178a.getLayoutParams();
            if (layoutParams.height == -2) {
                layoutParams.height = me1.b(ExtraInfoActivity.this.getApplicationContext(), 100);
            } else {
                layoutParams.height = -2;
            }
            this.f15178a.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TextView f15179a;

        public b(TextView textView) {
            this.f15179a = textView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ViewGroup.LayoutParams layoutParams = this.f15179a.getLayoutParams();
            if (layoutParams.height == -2) {
                layoutParams.height = me1.b(ExtraInfoActivity.this.getApplicationContext(), 100);
            } else {
                layoutParams.height = -2;
            }
            this.f15179a.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements Comparator<Pair<String, String>> {
        public c() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Pair<String, String> pair, Pair<String, String> pair2) {
            return ((String) pair.first).compareTo((String) pair2.first);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e extends HashMap<String, Object> {
        public e() {
            put("action", "send_message");
            put("status", "fail");
            put("detail", "AppSettingsReconnect");
        }
    }

    public final void A1() {
        try {
            xf5.a(AccountUtils.p(AppContext.getContext())).c();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final String B1() {
        return (TextUtils.isEmpty("20260309153514") ? "20260309153514" : "20260309153514".substring(10)) + "-release-5.29.2.0";
    }

    public final void C1() {
        Spinner spinner = (Spinner) findViewById(R.id.servertype);
        if (!ac1.E(this)) {
            spinner.setVisibility(8);
            return;
        }
        spinner.setVisibility(0);
        String[] stringArray = getResources().getStringArray(R.array.serverType);
        int i = 0;
        for (String str : stringArray) {
            if (nl0.c().equals(str)) {
                break;
            }
            i++;
        }
        spinner.setSelection(i);
        spinner.setOnItemSelectedListener(new d(stringArray));
    }

    public final void D1() {
        initToolbar(R.string.back_door_title);
        TextView textView = (TextView) findViewById(R.id.tv_channel);
        this.q = textView;
        textView.setText(String.valueOf(ac1.m));
        this.s = (TextView) findViewById(R.id.tv_build_time);
        View viewFindViewById = findViewById(R.id.msgCountLayout);
        View viewFindViewById2 = findViewById(R.id.tjLayout);
        View viewFindViewById3 = findViewById(R.id.UDLayout);
        Button button = (Button) findViewById(R.id.btn_pwd_mode);
        this.u = button;
        button.setOnClickListener(this);
        viewFindViewById.setVisibility(8);
        viewFindViewById2.setVisibility(8);
        viewFindViewById3.setVisibility(8);
        this.u.setVisibility(8);
        this.t = (TextView) findViewById(R.id.tv_msg_count);
        this.s.setText(B1());
        this.r = findViewById(R.id.build_layout);
        TextView textView2 = (TextView) findViewById(R.id.taichiconfig);
        String strC = jo6.c("all", com.igexin.push.core.b.m);
        textView2.setText(strC + "\n------sort------\n" + F1(strC));
        textView2.setOnClickListener(new a(textView2));
        TextView textView3 = (TextView) findViewById(R.id.UDconfig);
        String strD = t66.h().d();
        textView3.setText(strD + "\n------sort------\n" + F1(strD));
        textView3.setOnClickListener(new b(textView3));
        this.r.setVisibility(0);
        this.t.setText("common," + com.zenmen.palmchat.database.b.r(DBUriManager.MsgSaveType.COMMON));
        C1();
    }

    public final void E1() {
        String strC = az2.c(rl0.h().d().getConfigMap());
        String strC2 = jo6.c("all", com.igexin.push.core.b.m);
        LogUtil.uploadInfoImmediate("ClientConfigs_dy", null, null, strC);
        LogUtil.uploadInfoImmediate("ClientConfigs_taiji", null, null, strC2);
    }

    public final String F1(String str) {
        StringBuilder sb = new StringBuilder();
        ArrayList arrayList = new ArrayList();
        if (str != null) {
            try {
                for (String str2 : str.split("\n")) {
                    String[] strArrSplit = str2.split(",");
                    if (strArrSplit != null && strArrSplit.length > 0) {
                        arrayList.add(new Pair(strArrSplit[0], str2));
                    }
                }
                Collections.sort(arrayList, new c());
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            sb.append(((String) ((Pair) it.next()).second) + "\n");
        }
        return sb.toString();
    }

    public final void G1() {
        try {
            fn2 messagingServiceInterface = getMessagingServiceInterface();
            if (messagingServiceInterface != null && messagingServiceInterface.isConnected() && messagingServiceInterface.w()) {
                messagingServiceInterface.E();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            LogUtil.i(BaseActionBarActivity.TAG, 3, new e(), e2);
        }
        AppContext.getContext().logout(true, false);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.btn_pwd_mode && !l50.a()) {
            G1();
        }
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_back_door);
        D1();
        E1();
        A1();
        WifiNestAd.INSTANCE.setBackDoor(getApplicationContext(), true);
        dt5.b();
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        bindMessagingService();
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        unBindMessagingService();
        super.onStop();
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements AdapterView.OnItemSelectedListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String[] f15181a;

        /* JADX INFO: compiled from: SearchBox */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                System.exit(0);
            }
        }

        public d(String[] strArr) {
            this.f15181a = strArr;
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
            String str = this.f15181a[i];
            if (str.equals("reboot")) {
                AppContext.getContext().logout();
                u93.b(2000, new a());
                return;
            }
            r75.r(AppContext.getContext(), "sp_setting_servertype", str);
            sy5.f(ExtraInfoActivity.this, str + "选中reboot生效", 1).g();
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }
}
