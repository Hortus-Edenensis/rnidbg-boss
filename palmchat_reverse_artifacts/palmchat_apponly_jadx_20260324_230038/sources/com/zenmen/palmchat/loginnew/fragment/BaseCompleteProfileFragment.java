package com.zenmen.palmchat.loginnew.fragment;

import android.os.Bundle;
import android.text.TextUtils;
import com.lantern.auth.server.WkParams;
import com.litesuits.async.AsyncTask;
import com.wifi.ad.core.config.DeviceInfoUtil;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.messaging.CreateConnectionDelegate;
import com.zenmen.palmchat.messaging.MessagingService;
import com.zenmen.palmchat.messaging.smack.SessionInvalidException;
import defpackage.k86;
import java.io.UnsupportedEncodingException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class BaseCompleteProfileFragment extends BaseLoginFragment {
    public JSONObject h;
    public String i;
    public String j;
    public String k;
    public String l;
    public String m;
    public String n;
    public int o = -1;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends AsyncTask<Integer, Integer, Integer> {
        public final /* synthetic */ b m;

        public a(b bVar) {
            this.m = bVar;
        }

        @Override // com.litesuits.async.AsyncTask
        /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
        public Integer g(Integer... numArr) {
            int i;
            try {
                CreateConnectionDelegate createConnectionDelegate = new CreateConnectionDelegate();
                BaseCompleteProfileFragment baseCompleteProfileFragment = BaseCompleteProfileFragment.this;
                createConnectionDelegate.e(baseCompleteProfileFragment.i, baseCompleteProfileFragment.j, baseCompleteProfileFragment.k);
                if (AppContext.getSecretKey() == null && MessagingService.getSecretKeys() != null) {
                    AppContext.setContextSecretKey(MessagingService.getSecretKeys());
                }
                i = 0;
            } catch (SessionInvalidException unused) {
                i = -2;
            } catch (Exception unused2) {
                i = -1;
            }
            return Integer.valueOf(i);
        }

        @Override // com.litesuits.async.AsyncTask
        /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
        public void n(Integer num) {
            super.n(num);
            int iIntValue = num.intValue();
            if (iIntValue == -2) {
                this.m.b();
                return;
            }
            if (iIntValue == -1) {
                this.m.c();
            } else {
                if (iIntValue != 0) {
                    return;
                }
                if (AppContext.getSecretKey() != null) {
                    this.m.a();
                } else {
                    this.m.c();
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface b {
        void a();

        void b();

        void c();
    }

    public String Y(String str) {
        JSONObject jSONObject = this.h;
        if (jSONObject == null) {
            return str;
        }
        try {
            return k86.b0(str, jSONObject.optString(DeviceInfoUtil.UID_TAG), this.h.optString(WkParams.SESSIONID));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return str;
        }
    }

    public void Z(b bVar) {
        if (AppContext.getSecretKey() == null) {
            new a(bVar).h(new Integer[0]);
        } else {
            bVar.a();
        }
    }

    public void c0() {
        this.i = null;
        this.j = null;
        this.k = null;
    }

    public void e0(String str) {
        try {
            h0(new JSONObject(str));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void h0(JSONObject jSONObject) {
        this.h = jSONObject;
        if (jSONObject != null) {
            if (TextUtils.isEmpty(this.i) || TextUtils.isEmpty(this.j)) {
                this.i = jSONObject.optString(DeviceInfoUtil.UID_TAG);
                this.j = jSONObject.optString(WkParams.SESSIONID);
                this.k = jSONObject.optString("refreshKey");
                this.o = jSONObject.optInt("sex", -1);
                this.l = jSONObject.optString("birthday");
                this.n = jSONObject.optString("headIconUrl");
                this.m = jSONObject.optString("nickname");
            }
        }
    }

    @Override // com.zenmen.palmchat.loginnew.fragment.BaseLoginFragment, com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }
}
