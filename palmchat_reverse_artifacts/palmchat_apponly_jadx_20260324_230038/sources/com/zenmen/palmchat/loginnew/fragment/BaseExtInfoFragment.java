package com.zenmen.palmchat.loginnew.fragment;

import android.os.Bundle;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.gq3;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public abstract class BaseExtInfoFragment extends BaseLoginFragment {
    public static final String i = "BaseExtInfoFragment";
    public gq3 h;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Response.Listener<JSONObject> {
        public a() {
        }

        @Override // com.android.volley.Response.Listener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(JSONObject jSONObject) {
            BaseExtInfoFragment.this.Y(jSONObject.optInt("resultCode", -1) == 0);
            BaseExtInfoFragment.this.G();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements Response.ErrorListener {
        public b() {
        }

        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            BaseExtInfoFragment.this.Y(false);
            BaseExtInfoFragment.this.G();
        }
    }

    public abstract void Y(boolean z);

    public void Z(HashMap<String, Object> map) {
        LogUtil.d(i, "updateExtInfo:" + map.toString());
        gq3 gq3Var = new gq3(new a(), new b());
        this.h = gq3Var;
        try {
            gq3Var.n(map);
            L();
        } catch (Exception e) {
            e.printStackTrace();
            G();
        }
    }

    @Override // com.zenmen.palmchat.loginnew.fragment.BaseLoginFragment, com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        gq3 gq3Var = this.h;
        if (gq3Var != null) {
            gq3Var.onCancel();
        }
    }
}
