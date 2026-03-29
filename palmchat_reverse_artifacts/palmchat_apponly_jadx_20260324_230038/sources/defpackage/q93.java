package defpackage;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import com.wifi.ad.core.config.DeviceInfoUtil;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.databinding.LovematchPopNewMsgBinding;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class q93 extends m93 {
    public LovematchPopNewMsgBinding e;
    public je1 f;
    public Activity g;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            q93.this.dismiss();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f20207a;

        public b(String str) {
            this.f20207a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            n93.f(this.f20207a);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f20208a;

        public c(String str) {
            this.f20208a = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            n93.c(this.f20208a);
            if (!TextUtils.isEmpty(this.f20208a)) {
                p93.p(q93.this.g, this.f20208a);
            }
            q93.this.dismiss();
        }
    }

    public q93(@NonNull Activity activity) {
        super(activity);
        this.f = null;
        Window window = getWindow();
        window.setBackgroundDrawable(new ColorDrawable(0));
        window.setFlags(32, 32);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -2;
        attributes.height = -2;
        attributes.gravity = 48;
        attributes.y = a46.b(activity, 34.0f);
        window.setAttributes(attributes);
        this.g = activity;
        LovematchPopNewMsgBinding lovematchPopNewMsgBindingB = LovematchPopNewMsgBinding.b(LayoutInflater.from(getContext()));
        this.e = lovematchPopNewMsgBindingB;
        setContentView(lovematchPopNewMsgBindingB.getRoot());
        this.e.b.setOnClickListener(new a());
    }

    public Activity e() {
        return this.g;
    }

    public void f(JSONObject jSONObject) {
        String strOptString = jSONObject.optString("nickname", "");
        this.e.g.setText("来自" + strOptString + "的心动匹配消息");
        String strOptString2 = jSONObject.optString("headIconUrl", "");
        if (this.f == null) {
            this.f = a46.i(R.drawable.default_portrait);
        }
        gr2.j().h(strOptString2, this.e.f13912a, this.f);
        int iOptInt = jSONObject.optInt("sex", -1);
        if (iOptInt == 0) {
            this.e.f.setVisibility(0);
            this.e.f.setImageResource(R.mipmap.lovematch_pop_generic_sex_man);
        } else if (iOptInt == 1) {
            this.e.f.setVisibility(0);
            this.e.f.setImageResource(R.mipmap.lovematch_pop_generic_sex_women);
        } else {
            this.e.f.setVisibility(8);
        }
        StringBuffer stringBuffer = new StringBuffer();
        int iOptInt2 = jSONObject.optInt("age", -1);
        if (iOptInt2 != -1) {
            stringBuffer.append(iOptInt2 + "岁");
        }
        String strOptString3 = jSONObject.optString("userExt", null);
        if (!TextUtils.isEmpty(strOptString3)) {
            try {
                JSONObject jSONObject2 = new JSONObject(strOptString3);
                int iOptInt3 = jSONObject2.optInt("occupation", -1);
                if (iOptInt3 != -1) {
                    String strH = hs1.e().h(iOptInt3);
                    if (!TextUtils.isEmpty(strH)) {
                        stringBuffer.append("·" + strH);
                    }
                }
                int iOptInt4 = jSONObject2.optInt("income", -1);
                if (iOptInt4 != -1) {
                    String strD = hs1.e().d(iOptInt4);
                    if (!TextUtils.isEmpty(strD)) {
                        stringBuffer.append("·" + strD);
                    }
                }
            } catch (Exception unused) {
            }
        }
        String string = stringBuffer.toString();
        if (string.startsWith("·")) {
            string = string.substring(1);
        }
        this.e.c.setText(string);
        this.e.d.setText(jSONObject.optString("text", ""));
        this.e.e.setText(jSONObject.optString("button", ""));
        String strOptString4 = jSONObject.optString(DeviceInfoUtil.UID_TAG, null);
        b(new b(strOptString4));
        this.e.e.setOnClickListener(new c(strOptString4));
    }
}
