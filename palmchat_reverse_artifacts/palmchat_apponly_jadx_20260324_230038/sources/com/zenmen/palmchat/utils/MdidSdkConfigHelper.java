package com.zenmen.palmchat.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.alipay.sdk.m.x.d;
import com.bun.miitmdid.core.MdidSdkHelper;
import com.bun.miitmdid.interfaces.IIdentifierListener;
import com.bun.miitmdid.interfaces.IdSupplier;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.wifi.ad.core.config.DeviceInfoUtil;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.c;
import com.zenmen.palmchat.sync.dynamic.DynamicConfig;
import com.zenmen.palmchat.sync.dynamic.DynamicItem;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zm.fda.Z200O.ZZ00Z;
import defpackage.ac1;
import defpackage.dt0;
import defpackage.il2;
import defpackage.nl0;
import defpackage.rb3;
import defpackage.rl0;
import defpackage.v4;
import defpackage.yw4;
import defpackage.yy2;
import defpackage.z53;
import defpackage.zn6;
import defpackage.zw4;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class MdidSdkConfigHelper implements IIdentifierListener {
    public static final String ASSET_FILE_NAME_CERT = "com.zenmen.palmchat.cert.pem";
    private static final String OAID_PEM_MD5_KEY = "oaid_pem_md5_key";
    private static final String OAID_PEM_MD5_NAME = "oaid_pem_md5_spname";
    private static final String OAID_PEM_TIME_KEY = "oaid_pem_time_key";
    public static String TAG = "MdidSdkConfigHelper";
    private static final String def_pem_file_md5 = "5bacac6f6c11ac1d57cc23b158fb9280";
    private static final String def_pem_file_md5_jisu = "cc5d966e6d726eef94dd1a52fd82489b";
    private static AtomicBoolean isInit = new AtomicBoolean(false);
    public static final String msaoaidsec = "msaoaidsec";
    public static final String oaidConfigKey = "oaid_sdk";
    public static final String oaidConfigSpName = "oaid_sdk_init_sp_name";
    private static MdidSdkConfigHelper sInstance;
    private boolean isSDKLogOn;
    private String mChannelId;
    private Context mContext;
    private int oaidErrorCode;
    private String mOAID = null;
    private boolean isRequesting = false;
    private boolean isCertInit = false;
    private boolean isArchSupport = false;
    private InputStream serverPemIs = null;
    private boolean configDone = false;
    private boolean hasCheckBack = false;
    private boolean hasCheckMain = false;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends yw4 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f15709a;

        public a(String str) {
            this.f15709a = str;
        }

        @Override // defpackage.yw4
        public void onFail(Exception exc) {
            LogUtil.d(MdidSdkConfigHelper.TAG, "DDT requestPemFileUrl Exception error " + exc);
        }

        @Override // defpackage.yw4
        public void onSuccess(JSONObject jSONObject, yy2 yy2Var) {
            LogUtil.d(MdidSdkConfigHelper.TAG, "DDT requestPemFileUrl oriData " + jSONObject);
            if (jSONObject == null) {
                onFail(new Exception("data is null"));
                return;
            }
            if (yy2Var == null) {
                onFail(new Exception("response is null"));
                return;
            }
            if (yy2Var.b != 0) {
                onFail(new Exception("resultCode is error"));
                return;
            }
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("data");
            if (jSONObjectOptJSONObject == null) {
                onFail(new Exception("data is null"));
            } else {
                LogUtil.d(MdidSdkConfigHelper.TAG, "DDT2 requestPemFileUrl onSuccess");
                MdidSdkConfigHelper.this.parOaidConfig(jSONObjectOptJSONObject, this.f15709a);
            }
        }
    }

    public MdidSdkConfigHelper() {
        this.isSDKLogOn = true;
        if (nl0.c().equals("release")) {
            this.isSDKLogOn = false;
        } else {
            this.isSDKLogOn = true;
        }
        loadLibrary(msaoaidsec);
        z53.a(TAG, "OAID_DONE_2 MdidSdkConfigHelper isSDKLogOn " + this.isSDKLogOn);
    }

    private int CallFromReflect(Context context) {
        return MdidSdkHelper.InitSdk(context, true, this);
    }

    private boolean allowOaidSdkInit() {
        int i = this.mContext.getSharedPreferences(oaidConfigSpName, 0).getInt(oaidConfigKey, 0);
        z53.a(TAG, "allowOaidSdkInit config result " + i);
        return i != -1;
    }

    private void checkOaid(boolean z) {
        String str = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("checkOaid start scene = ");
        sb.append(z ? d.n : "onMainTab");
        LogUtil.d(str, sb.toString());
        if (TextUtils.isEmpty(getOAID())) {
            LogUtil.d(TAG, "checkOaid retry ");
            getOaidImp();
            SmidHelper.n();
        }
    }

    private void fetchChannelId(Context context) {
        this.mChannelId = "zx_default";
        try {
            if (context.getResources() != null) {
                InputStreamReader inputStreamReader = new InputStreamReader(context.getResources().getAssets().open("channel"), "utf-8");
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String line = bufferedReader.readLine();
                if (!TextUtils.isEmpty(line)) {
                    this.mChannelId = line;
                }
                bufferedReader.close();
                inputStreamReader.close();
            }
        } catch (IOException e) {
            z53.d("fetchChannelId", e.toString());
        }
    }

    public static MdidSdkConfigHelper getInstance() {
        if (sInstance == null) {
            synchronized (MdidSdkConfigHelper.class) {
                if (sInstance == null) {
                    sInstance = new MdidSdkConfigHelper();
                }
            }
        }
        return sInstance;
    }

    private void getOaidImp() {
        if (this.mContext == null || this.isRequesting || !allowOaidSdkInit()) {
            return;
        }
        fetchChannelId(this.mContext);
        String lowerCase = Build.MANUFACTURER.toLowerCase();
        String str = this.mChannelId;
        boolean z = str != null && str.startsWith("SAMS");
        z53.a(TAG, "manufacture = " + lowerCase + ",channelId = " + this.mChannelId);
        if (z || lowerCase.contains("samsung")) {
            z53.a(TAG, "not init oaid sdk");
            return;
        }
        this.isRequesting = true;
        if (!this.isCertInit) {
            try {
                InputStream fileInputStream = this.serverPemIs;
                if (fileInputStream == null) {
                    File file = new File(getOaidSaveFolder(this.mContext) + File.separator + ASSET_FILE_NAME_CERT);
                    fileInputStream = file.exists() ? new FileInputStream(file) : this.mContext.getAssets().open(ASSET_FILE_NAME_CERT);
                }
                Context context = this.mContext;
                this.isCertInit = MdidSdkHelper.InitCert(context, loadPemFromAssetFile(context, fileInputStream));
                MdidSdkHelper.setGlobalTimeout(5000L);
                z53.a(TAG, "OAID_DONE_3 MdidSdkConfigHelper isCertInit " + this.isCertInit);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        try {
            int iInitSdk = MdidSdkHelper.InitSdk(this.mContext, true, true, false, false, this);
            if (iInitSdk != 1008612 && iInitSdk == 1008613) {
            }
            this.oaidErrorCode = iInitSdk;
            z53.a(TAG, "OAID_DONE_4 InitSDk return value: " + iInitSdk);
        } catch (Throwable th2) {
            z53.d(TAG, "InitSDk Throwable: " + th2.toString());
        }
    }

    public static String getOaidSaveFolder(Context context) {
        if (context == null) {
            return null;
        }
        return context.getFilesDir().getAbsolutePath() + File.separator + "OAIDPEM";
    }

    private String loadLibrary(String str) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            if (((String) cls.getMethod("get", String.class, String.class).invoke(cls, "ro.product.cpu.abi", "")).contains("x86")) {
                this.isArchSupport = false;
            } else {
                this.isArchSupport = true;
                System.loadLibrary(str);
            }
        } catch (Throwable unused) {
        }
        return !this.isArchSupport ? "Arch: x86\n" : "Arch: Not x86";
    }

    private static String loadPemFromAssetFile(Context context, InputStream inputStream) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder sb = new StringBuilder();
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    return sb.toString();
                }
                sb.append(line);
                sb.append('\n');
            }
        } catch (IOException unused) {
            Log.e(TAG, "loadPemFromAssetFile failed");
            return "";
        }
    }

    private void onEvent(boolean z, String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("result", z);
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put(MediationConstant.KEY_ERROR_MSG, str);
            }
            if (!TextUtils.isEmpty(str2)) {
                jSONObject.put("oaid", str2);
            }
            jSONObject.put("infoCode", this.oaidErrorCode);
            jSONObject.put(DeviceInfoUtil.UID_TAG, v4.e(AppContext.getContext()));
            jSONObject.put("deviceId", ac1.h);
            jSONObject.put(com.umeng.ccg.a.x, "XTY");
            LogUtil.d(TAG, "onEvent oaidGetResult jsonObject " + jSONObject);
            zn6.d("oaidGetResult", null, jSONObject.toString());
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void parOaidConfig(JSONObject jSONObject, String str) {
        if (jSONObject != null) {
            String strOptString = jSONObject.optString("url");
            String strOptString2 = jSONObject.optString("md5");
            String strOptString3 = jSONObject.optString("time");
            if (TextUtils.isEmpty(strOptString) || TextUtils.isEmpty(strOptString2) || strOptString2.equals(str)) {
                return;
            }
            dt0.k(this.mContext).e(strOptString, getOaidSaveFolder(c.b()), ASSET_FILE_NAME_CERT, new b(strOptString2, strOptString3));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetOaId(File file) {
        isInit.set(false);
        this.isCertInit = false;
        this.mOAID = null;
        try {
            this.serverPemIs = new FileInputStream(file);
            initSdk(this.mContext);
        } catch (Exception unused) {
        }
    }

    private void updateOaidSp(String str) {
        Context context = this.mContext;
        if (context != null) {
            SharedPreferences.Editor editorEdit = context.getSharedPreferences("sp_palmchat_AD", 0).edit();
            editorEdit.putString(ZZ00Z.j, str);
            editorEdit.apply();
            z53.a(TAG, "saveOaid prefrence = " + str);
        }
    }

    public void checkOaidOnBack() {
        if (this.hasCheckBack) {
            return;
        }
        this.hasCheckBack = true;
        checkOaid(true);
    }

    public void checkOaidOnMainTab() {
        if (this.hasCheckMain) {
            return;
        }
        this.hasCheckMain = true;
        checkOaid(false);
    }

    public String getOAID() {
        Context context;
        z53.a(TAG, "getOAID OAID = " + this.mOAID);
        if (this.mOAID == null && (context = this.mContext) != null) {
            this.mOAID = context.getSharedPreferences("sp_palmchat_AD", 0).getString(ZZ00Z.j, "");
            z53.a(TAG, "getOAID prefrence = " + this.mOAID);
        }
        String strJ = SmidHelper.j(this.mOAID);
        if (strJ != null && !strJ.equals(this.mOAID)) {
            this.mOAID = strJ;
            updateOaidSp(strJ);
            z53.a(TAG, "getOAID fixwith SM = " + this.mOAID);
        }
        return strJ;
    }

    public void initConfig() {
        JSONArray jSONArrayOptJSONArray;
        if (this.configDone) {
            return;
        }
        DynamicItem dynamicConfig = rl0.h().d().getDynamicConfig(DynamicConfig.Type.OAID_SDK_INIT_CONFIG);
        z53.a(TAG, "allowOaidSdkInit config item " + dynamicConfig);
        if (dynamicConfig == null || dynamicConfig.getExtra() == null) {
            return;
        }
        try {
            if (TextUtils.isEmpty(dynamicConfig.getExtra())) {
                return;
            }
            JSONObject jSONObject = new JSONObject(dynamicConfig.getExtra());
            String strOptString = jSONObject.optString("manufacturer");
            if (TextUtils.isEmpty(strOptString) || TextUtils.isEmpty(ac1.f1194a)) {
                return;
            }
            if ((strOptString.contains(ac1.f1194a) || strOptString.contains("all")) && (jSONArrayOptJSONArray = jSONObject.optJSONArray("sdkConfig")) != null && jSONArrayOptJSONArray.length() > 0) {
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                    String strOptString2 = jSONObjectOptJSONObject.optString(com.umeng.ccg.a.x);
                    if (!TextUtils.isEmpty(strOptString2) && strOptString2.equals("XTY") && jSONObjectOptJSONObject.optInt("initTime") == -1) {
                        z53.a(TAG, "allowOaidSdkInit config not allow ");
                        AppContext.getContext().getSharedPreferences(oaidConfigSpName, 0).edit().putInt(oaidConfigKey, -1).apply();
                    }
                }
            }
        } catch (Exception e) {
            z53.a(TAG, "allowOaidSdkInit config Exception " + e.toString());
        }
    }

    public void initSdk(Context context) {
        z53.a(TAG, "initSdk start");
        if (isInit.getAndSet(true)) {
            return;
        }
        z53.a(TAG, "initSdk");
        this.mContext = context;
        getOaidImp();
    }

    @Override // com.bun.miitmdid.interfaces.IIdentifierListener
    public void onSupport(IdSupplier idSupplier) {
        boolean z = false;
        this.isRequesting = false;
        if (idSupplier == null || !idSupplier.isSupported()) {
            z53.d(TAG, "idSupplier not supported");
            onEvent(false, "idSupplier not supported", "");
            return;
        }
        String oaid = idSupplier.getOAID();
        if (oaid != null && !oaid.equals(this.mOAID)) {
            this.mOAID = oaid;
            z = true;
        }
        onEvent(true, "", oaid);
        z53.a(TAG, "XTY OnSupport OAID = " + this.mOAID);
        if (z && SmidHelper.t(this.mOAID)) {
            updateOaidSp(this.mOAID);
        }
    }

    public void requestPemFileUrl() {
        try {
            JSONObject jSONObject = new JSONObject();
            SharedPreferences sharedPreferences = this.mContext.getSharedPreferences(OAID_PEM_MD5_NAME, 0);
            String string = sharedPreferences.getString(OAID_PEM_TIME_KEY, "");
            if (!TextUtils.isEmpty(string)) {
                try {
                    long time = new SimpleDateFormat("yyyy-MM-dd").parse(string).getTime();
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    LogUtil.d(TAG, "DDT requestTimeCheck lastTime " + time + " curTime " + jCurrentTimeMillis);
                    if (jCurrentTimeMillis < time) {
                        return;
                    }
                } catch (Exception unused) {
                }
            }
            String str = def_pem_file_md5;
            String str2 = com.umeng.ccg.a.x;
            if ("com.zenmen.lxjisu".equals(AppContext.getContext().getPackageName())) {
                str2 = "sdk_jisu";
                str = def_pem_file_md5_jisu;
            }
            String string2 = sharedPreferences.getString(OAID_PEM_MD5_KEY, str);
            jSONObject.put("type", str2);
            jSONObject.put("resName", string2);
            LogUtil.d(TAG, "DDT requestPemFileUrl OAID_GET_PEM_URL " + nl0.B + " params " + jSONObject);
            zw4.j(nl0.B, 1, jSONObject, new a(string2), true, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements il2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f15710a;
        public final /* synthetic */ String b;

        public b(String str, String str2) {
            this.f15710a = str;
            this.b = str2;
        }

        @Override // defpackage.il2
        public void onFinish(File file) throws Throwable {
            if (file != null) {
                if (this.f15710a.equals(rb3.b(file))) {
                    return;
                }
                MdidSdkConfigHelper.this.resetOaId(file);
                SharedPreferences sharedPreferences = MdidSdkConfigHelper.this.mContext.getSharedPreferences(MdidSdkConfigHelper.OAID_PEM_MD5_NAME, 0);
                sharedPreferences.edit().putString(MdidSdkConfigHelper.OAID_PEM_MD5_KEY, this.f15710a).apply();
                if (TextUtils.isEmpty(this.b)) {
                    return;
                }
                sharedPreferences.edit().putString(MdidSdkConfigHelper.OAID_PEM_TIME_KEY, this.b).apply();
            }
        }

        @Override // defpackage.il2
        public void onProgress(int i) {
        }

        @Override // defpackage.il2
        public void onStop(int i) {
        }

        @Override // defpackage.il2
        public void onPrepare() {
        }

        @Override // defpackage.il2
        public void onError(int i, String str) {
        }

        @Override // defpackage.il2
        public void onStart(String str, String str2, int i) {
        }
    }
}
