package com.opos.mobad.provider.record;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.cdo.oaps.ad.OapsKey;
import com.opos.process.bridge.annotation.BridgeMethod;
import com.opos.process.bridge.annotation.IBridgeTargetIdentify;
import com.opos.process.bridge.provider.IBridgeHandler;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class SdKRecord implements IBridgeHandler {
    public static final IBridgeHandler.Factory FACTORY = new IBridgeHandler.Factory() { // from class: com.opos.mobad.provider.record.SdKRecord.1
        @Override // com.opos.process.bridge.provider.IBridgeHandler.Factory
        public SdKRecord getInstance(Context context, IBridgeTargetIdentify iBridgeTargetIdentify) {
            return SdKRecord.a(context.getApplicationContext());
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile SdKRecord f9173a;
    private Context b;
    private SharedPreferences c;
    private a d;

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void a();
    }

    private SdKRecord(Context context) {
        this.b = context;
        this.c = context.getSharedPreferences("mobad_sdk_record", 0);
    }

    @BridgeMethod(methodId = 2)
    public CacheEntity a() {
        return new CacheEntity(this.c.getInt("img_cache", 0), this.c.getInt("img_amount", 0));
    }

    @BridgeMethod(methodId = 4)
    public CacheEntity b() {
        return new CacheEntity(this.c.getInt("video_cache", 0), this.c.getInt("video_amount", 0));
    }

    @BridgeMethod(methodId = 5)
    public void c() {
        this.c.edit().remove("img_amount").remove("img_cache").remove("video_amount").remove("video_cache").commit();
    }

    @BridgeMethod(methodId = 6)
    public ControlEntity d() {
        return new ControlEntity(this.c.getBoolean("control_tt_enable", false), this.c.getBoolean("control_gdt_enable", false), this.c.getBoolean("control_cache_enable", false), this.c.getLong("control_refresh_time", 0L), this.c.getBoolean("control_ads_enable", false), this.c.getBoolean("control_ks_enable", false));
    }

    @BridgeMethod(methodId = 8)
    public long e() {
        return this.c.getLong("align_time", 0L);
    }

    @BridgeMethod(methodId = 10)
    public int f() {
        return this.c.getInt("cr_amount", 0);
    }

    @BridgeMethod(methodId = 11)
    public long g() {
        return this.c.getLong("cr_last_time", 0L);
    }

    @BridgeMethod(methodId = 12)
    public String h() {
        return this.c.getString("cr_info", "");
    }

    @BridgeMethod(methodId = 14)
    public String i() {
        return this.c.getString("cr_env_info", "");
    }

    @BridgeMethod(methodId = 16)
    public CookieData j() {
        return new CookieData(this.c.getString(OapsKey.KEY_CK, ""), this.c.getLong("ck_time", -1L));
    }

    @BridgeMethod(methodId = 18)
    public String k() {
        return this.c.getString("p_oid", "");
    }

    @BridgeMethod(methodId = 19)
    public String l() {
        return this.c.getString("p_did", "");
    }

    public static final SdKRecord a(Context context) {
        SdKRecord sdKRecord;
        if (f9173a != null) {
            return f9173a;
        }
        synchronized (SdKRecord.class) {
            if (f9173a == null) {
                f9173a = new SdKRecord(context);
            }
            sdKRecord = f9173a;
        }
        return sdKRecord;
    }

    @BridgeMethod(methodId = 3)
    public void b(CacheEntity cacheEntity) {
        int i = this.c.getInt("video_cache", 0) + cacheEntity.f9170a;
        this.c.edit().putInt("video_cache", i).putInt("video_amount", this.c.getInt("video_amount", 0) + cacheEntity.b).commit();
    }

    @BridgeMethod(methodId = 21)
    public void c(String str, String str2) {
        com.opos.cmn.an.f.a.b("SdKRecord", "saveStringData:key->" + str + ";value->" + str2);
        this.c.edit().putString(str, str2).commit();
    }

    @BridgeMethod(methodId = 1)
    public void a(CacheEntity cacheEntity) {
        int i = this.c.getInt("img_cache", 0) + cacheEntity.f9170a;
        this.c.edit().putInt("img_cache", i).putInt("img_amount", this.c.getInt("img_amount", 0) + cacheEntity.b).commit();
    }

    @BridgeMethod(methodId = 17)
    public void b(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = "";
        }
        this.c.edit().putString("p_oid", str).putString("p_did", str2).commit();
    }

    @BridgeMethod(methodId = 7)
    public void a(ControlEntity controlEntity) {
        this.c.edit().putBoolean("control_tt_enable", controlEntity.f9171a).putBoolean("control_gdt_enable", controlEntity.b).putBoolean("control_cache_enable", controlEntity.c).putLong("control_refresh_time", controlEntity.d).putBoolean("control_ads_enable", controlEntity.e).putBoolean("control_ks_enable", controlEntity.f).commit();
        a aVar = this.d;
        if (aVar != null) {
            aVar.a();
        }
    }

    @BridgeMethod(methodId = 15)
    public void a(CookieData cookieData) {
        if (cookieData == null) {
            return;
        }
        this.c.edit().putString(OapsKey.KEY_CK, cookieData.f9172a).putLong("ck_time", cookieData.b).commit();
    }

    @BridgeMethod(methodId = 9)
    public void a(String str) {
        SharedPreferences.Editor editorPutString;
        if (TextUtils.isEmpty(str)) {
            editorPutString = this.c.edit().remove("cr_amount").remove("cr_last_time").remove("cr_info");
        } else {
            editorPutString = this.c.edit().putInt("cr_amount", this.c.getInt("cr_amount", 0) + 1).putLong("cr_last_time", System.currentTimeMillis()).putString("cr_info", str);
        }
        editorPutString.commit();
    }

    @BridgeMethod(methodId = 13)
    public void a(String str, String str2) {
        SharedPreferences.Editor editorPutString;
        if (TextUtils.isEmpty(str)) {
            editorPutString = this.c.edit().remove("cr_amount").remove("cr_last_time").remove("cr_info").remove("cr_env_info");
        } else {
            editorPutString = this.c.edit().putInt("cr_amount", this.c.getInt("cr_amount", 0) + 1).putLong("cr_last_time", System.currentTimeMillis()).putString("cr_info", str).putString("cr_env_info", str2);
        }
        editorPutString.commit();
    }

    @BridgeMethod(methodId = 20)
    public String[] a(String str, boolean z) {
        com.opos.cmn.an.f.a.b("SdKRecord", "getDataStartWithKey:keyWord" + str + ";ifRemoveDataAfter:" + z);
        ArrayList arrayList = new ArrayList();
        SharedPreferences.Editor editorEdit = this.c.edit();
        for (String str2 : this.c.getAll().keySet()) {
            if (str2 != null && str2.startsWith(str)) {
                arrayList.add(this.c.getString(str2, ""));
                if (z) {
                    editorEdit = editorEdit.remove(str2);
                }
            }
        }
        editorEdit.commit();
        String[] strArr = new String[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            String str3 = (String) arrayList.get(i);
            com.opos.cmn.an.f.a.b("SdKRecord", "getDataStartWithKey:set" + str3);
            strArr[i] = str3;
        }
        return strArr;
    }
}
