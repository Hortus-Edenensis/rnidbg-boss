package com.zenmen.palmchat.opensdk;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.lantern.auth.stub.WkSDKFeature;
import com.litesuits.async.AsyncTask;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.MainTabsActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.activity.webview.CordovaWebActivity;
import com.zenmen.palmchat.chat.SendMessageActivity;
import com.zenmen.palmchat.framework.mediapick.MediaItem;
import com.zenmen.palmchat.messaging.CreateConnectionDelegate;
import com.zenmen.palmchat.messaging.MessagingService;
import com.zenmen.palmchat.publish.PublishActivity;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.an2;
import defpackage.bo0;
import defpackage.f13;
import defpackage.i13;
import defpackage.k86;
import defpackage.nl0;
import defpackage.pu1;
import defpackage.q55;
import defpackage.sy5;
import defpackage.t03;
import defpackage.tj2;
import defpackage.u03;
import defpackage.y63;
import defpackage.yw4;
import defpackage.yy2;
import defpackage.zw4;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class LXEntryActivity extends CordovaWebActivity {
    public static String V0 = "LXEntryActivity";
    public static final String W0 = nl0.b + "/share/v1/app.json";
    public q55 Q0;
    public u03 R0 = null;
    public int S0 = -1;
    public String T0 = null;
    public boolean U0 = false;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends yw4 {
        public a() {
        }

        @Override // defpackage.yw4
        public void onFail(Exception exc) {
            LogUtil.i(LXEntryActivity.V0, "checkAppInfo onFail, error = " + exc.toString());
            LXEntryActivity lXEntryActivity = LXEntryActivity.this;
            sy5.f(lXEntryActivity, lXEntryActivity.getResources().getString(R.string.ly_share_fail_reason), 0).g();
            LXEntryActivity lXEntryActivity2 = LXEntryActivity.this;
            lXEntryActivity2.k3(lXEntryActivity2.getResources().getString(R.string.ly_share_fail_reason));
            LogUtil.uploadInfoImmediate("wblx2", null, "2", null);
            LXEntryActivity.this.n3(10);
        }

        @Override // defpackage.yw4
        public void onSuccess(JSONObject jSONObject, yy2 yy2Var) {
            LogUtil.i(LXEntryActivity.V0, "checkAppInfo onSuccess, response = " + jSONObject.toString());
            c cVar = new c();
            int iOptInt = jSONObject.optInt("resultCode");
            cVar.f14770a = iOptInt;
            if (iOptInt == 0) {
                LXEntryActivity.this.j3(jSONObject.optJSONObject("data").toString());
                LogUtil.uploadInfoImmediate("wblx2", null, "1", null);
                return;
            }
            if (iOptInt == -1) {
                LXEntryActivity.this.n3(10);
            } else if (iOptInt == 1) {
                LXEntryActivity.this.n3(6);
            } else if (iOptInt == 2) {
                LXEntryActivity.this.n3(7);
            } else if (iOptInt == 3) {
                LXEntryActivity.this.n3(8);
            } else if (iOptInt == 4) {
                LXEntryActivity.this.n3(9);
            }
            LXEntryActivity lXEntryActivity = LXEntryActivity.this;
            lXEntryActivity.k3(lXEntryActivity.getResources().getString(R.string.ly_share_fail_reason));
            LogUtil.uploadInfoImmediate("wblx2", null, "2", null);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends AsyncTask<Integer, Integer, Integer> {
        public final /* synthetic */ String m;
        public final /* synthetic */ int n;
        public final /* synthetic */ int o;
        public final /* synthetic */ yw4 p;

        public b(String str, int i, int i2, yw4 yw4Var) {
            this.m = str;
            this.n = i;
            this.o = i2;
            this.p = yw4Var;
        }

        @Override // com.litesuits.async.AsyncTask
        /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
        public Integer g(Integer... numArr) {
            int i;
            try {
                new CreateConnectionDelegate().e(AccountUtils.p(AppContext.getContext()), AccountUtils.o(AppContext.getContext()), AccountUtils.m(AppContext.getContext()));
                if (AppContext.getSecretKey() == null && MessagingService.getSecretKeys() != null) {
                    AppContext.setContextSecretKey(MessagingService.getSecretKeys());
                }
                i = 0;
            } catch (Exception unused) {
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
                LXEntryActivity.this.n3(3);
                LXEntryActivity lXEntryActivity = LXEntryActivity.this;
                lXEntryActivity.k3(lXEntryActivity.getResources().getString(R.string.ly_share_fail_reason));
                LogUtil.i(LXEntryActivity.V0, "getskey: RESULT_SESSION_INVALIDATE");
                return;
            }
            if (iIntValue == -1) {
                LXEntryActivity lXEntryActivity2 = LXEntryActivity.this;
                lXEntryActivity2.k3(lXEntryActivity2.getResources().getString(R.string.ly_share_fail_reason));
                LXEntryActivity.this.n3(3);
                LogUtil.i(LXEntryActivity.V0, "getskey: RESULT_GET_SK_FAILED");
                return;
            }
            if (iIntValue != 0) {
                return;
            }
            LogUtil.i(LXEntryActivity.V0, "getskey: RESULT_SUCCESS");
            if (AppContext.getSecretKey() != null) {
                LXEntryActivity.this.m3(this.m, this.n, this.o, this.p);
                return;
            }
            LXEntryActivity.this.n3(3);
            LXEntryActivity lXEntryActivity3 = LXEntryActivity.this;
            lXEntryActivity3.k3(lXEntryActivity3.getResources().getString(R.string.ly_share_fail_reason));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f14770a;
    }

    public final void d3(String str) {
        if (this.R0 != null) {
            Intent intent = new Intent(this, (Class<?>) PublishActivity.class);
            intent.putExtra("key_from", 6);
            intent.putExtra("key_change_scence", this.U0);
            intent.putExtra("key_source", str);
            intent.putExtra("sdk_share_appid", this.T0);
            if (this.R0.a() == 1) {
                intent.putExtra("key_publish_type", 1);
                intent.putExtra("key_publish_text", ((f13) this.R0.e).f17410a);
            } else if (this.R0.a() == 2) {
                intent.putExtra("key_publish_type", 4);
                intent.putExtra("key_publish_subject", this.R0.b);
                byte[] bArr = this.R0.d;
                if (bArr != null && bArr.length != 0) {
                    Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
                    if (bitmapDecodeByteArray != null) {
                        String strInsertImage = MediaStore.Images.Media.insertImage(getContentResolver(), bitmapDecodeByteArray, (String) null, (String) null);
                        if (strInsertImage != null) {
                            String strI3 = i3(Uri.parse(strInsertImage), null);
                            intent.putExtra("key_publish_shortcut_icon", strI3);
                            LogUtil.i(V0, "shareLink path is " + strI3);
                        } else {
                            LogUtil.i(V0, "shareLink iconUrl is null");
                        }
                    } else {
                        LogUtil.i(V0, "shareLink thumbdata bitmap is null");
                    }
                }
                intent.putExtra("key_publish_url", ((i13) this.R0.e).f18083a);
                if (TextUtils.isEmpty(((i13) this.R0.e).f18083a)) {
                    LogUtil.i(V0, "shareLink url is null");
                    n3(5);
                    k3(getResources().getString(R.string.ly_share_fail_reason_empty));
                    return;
                }
            } else if (this.R0.a() == 3) {
                intent.putExtra("key_publish_type", 2);
                an2 an2Var = this.R0.e;
                String str2 = ((t03) an2Var).b;
                byte[] bArr2 = ((t03) an2Var).f20882a;
                ArrayList arrayList = new ArrayList();
                MediaItem mediaItem = new MediaItem();
                if (str2 != null) {
                    mediaItem.fileFullPath = str2;
                    if (pu1.g(str2) != 1) {
                        LogUtil.i(V0, "shareImage filepath is null or file not exist");
                        k3(getResources().getString(R.string.ly_share_fail_reason_empty));
                        n3(4);
                        return;
                    }
                } else {
                    if (bArr2 == null || bArr2.length == 0) {
                        LogUtil.i(V0, "shareImage filepath is null or file not exist");
                        k3(getResources().getString(R.string.ly_share_fail_reason_empty));
                        n3(4);
                        return;
                    }
                    String strI32 = i3(Uri.parse(MediaStore.Images.Media.insertImage(getContentResolver(), BitmapFactory.decodeByteArray(bArr2, 0, bArr2.length), (String) null, (String) null)), null);
                    mediaItem.fileFullPath = strI32;
                    if (strI32 == null) {
                        LogUtil.i(V0, "shareImage filepath is null or file not exist");
                        k3(getResources().getString(R.string.ly_share_fail_reason_empty));
                        n3(4);
                        return;
                    }
                }
                LogUtil.i(V0, "shareImage filepath = " + mediaItem.fileFullPath);
                arrayList.add(mediaItem);
                intent.putExtra("key_publish_pictures", arrayList);
            }
            startActivity(intent);
            finish();
        }
    }

    public final void e3(String str) {
        Uri uriFromFile;
        if (this.R0 != null) {
            Intent intent = new Intent(this, (Class<?>) SendMessageActivity.class);
            intent.putExtra("extra_share_mode", 3);
            intent.putExtra("extra_share_source", str);
            intent.putExtra("sdk_share_appid", this.T0);
            if (this.R0.a() == 1) {
                intent.putExtra("extra_share_type", (byte) 1);
                intent.putExtra("android.intent.extra.TEXT", ((f13) this.R0.e).f17410a);
            } else if (this.R0.a() == 2) {
                intent.putExtra("extra_share_type", (byte) 2);
                intent.putExtra("android.intent.extra.SUBJECT", this.R0.b);
                intent.putExtra("android.intent.extra.TEXT", this.R0.c);
                byte[] bArr = this.R0.d;
                if (bArr == null || bArr.length == 0) {
                    LogUtil.i(V0, "shareLink thumbdata is null");
                    k3(getResources().getString(R.string.ly_share_fail_reason_empty));
                    n3(11);
                    return;
                }
                Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
                String str2 = pu1.f + File.separator + "sdk_share_chat_icon.jpj";
                File file = new File(str2);
                if (file.exists()) {
                    file.delete();
                }
                try {
                    BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
                    bitmapDecodeByteArray.compress(Bitmap.CompressFormat.JPEG, 100, bufferedOutputStream);
                    intent.putExtra("android.intent.extra.shortcut.ICON", str2);
                    bufferedOutputStream.flush();
                    bufferedOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                intent.putExtra("extra_url", ((i13) this.R0.e).f18083a);
                if (TextUtils.isEmpty(((i13) this.R0.e).f18083a)) {
                    LogUtil.i(V0, "shareLink url is null");
                    k3(getResources().getString(R.string.ly_share_fail_reason_empty));
                    n3(5);
                    return;
                }
            } else if (this.R0.a() == 3) {
                intent.putExtra("extra_share_type", (byte) 3);
                an2 an2Var = this.R0.e;
                String str3 = ((t03) an2Var).b;
                byte[] bArr2 = ((t03) an2Var).f20882a;
                if (str3 != null) {
                    uriFromFile = Uri.fromFile(new File(str3));
                    if (pu1.g(str3) != 1) {
                        LogUtil.i(V0, "shareImage file not exist");
                        k3(getResources().getString(R.string.ly_share_fail_reason_empty));
                        n3(4);
                        return;
                    }
                } else if (bArr2 == null || bArr2.length == 0) {
                    uriFromFile = null;
                } else {
                    uriFromFile = Uri.parse(MediaStore.Images.Media.insertImage(getContentResolver(), BitmapFactory.decodeByteArray(bArr2, 0, bArr2.length), (String) null, (String) null));
                }
                if (uriFromFile == null) {
                    LogUtil.i(V0, "shareImage url is null");
                    k3(getResources().getString(R.string.ly_share_fail_reason_empty));
                    n3(4);
                    return;
                }
                intent.putExtra("android.intent.extra.STREAM", uriFromFile);
            }
            startActivity(intent);
            finish();
        }
    }

    public final void f3() {
        a aVar = new a();
        if (this.T0 == null || this.R0 == null) {
            n3(1);
            LogUtil.i(V0, "mAppid or mLxMediaMessage is null ");
            k3(getResources().getString(R.string.ly_share_fail_reason));
            return;
        }
        int iJ = bo0.r().j();
        LogUtil.i(V0, "getContactCount = " + iJ);
        if (this.S0 == 0 && iJ == 0) {
            this.S0 = 1;
            this.U0 = true;
        }
        h3(this.T0, this.R0.a(), this.S0, aVar);
    }

    public final int g3() {
        int i = !AccountUtils.r(this) ? 0 : y63.n(this) ? 2 : 1;
        LogUtil.i(V0, "getAccountState = " + i);
        return i;
    }

    public final void h3(String str, int i, int i2, yw4 yw4Var) {
        if (AppContext.getSecretKey() == null) {
            new b(str, i, i2, yw4Var).h(new Integer[0]);
        } else {
            m3(str, i, i2, yw4Var);
        }
    }

    public final String i3(Uri uri, String str) {
        Cursor cursorQuery = getContentResolver().query(uri, null, str, null, null);
        if (cursorQuery != null) {
            string = cursorQuery.moveToFirst() ? cursorQuery.getString(cursorQuery.getColumnIndex("_data")) : null;
            cursorQuery.close();
        }
        return string;
    }

    public final void j3(String str) {
        if (this.Q0 != null) {
            int i = this.S0;
            if (i == 0) {
                e3(str);
            } else if (i == 1) {
                d3(str);
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("towblx", this.S0);
                String str2 = this.T0;
                if (str2 == null) {
                    jSONObject.put("appid", "");
                } else {
                    jSONObject.put("appid", str2);
                }
                jSONObject.put(WkSDKFeature.WHAT_LOGIN, g3());
                LogUtil.uploadInfoImmediate("wblx5", null, null, jSONObject.toString());
            } catch (JSONException unused) {
            }
        }
    }

    public final void k3(String str) {
        sy5.f(this, str, 0).g();
        Intent intent = new Intent();
        intent.setClass(this, MainTabsActivity.class);
        k86.Y(intent);
        startActivity(intent);
        finish();
    }

    public final void l3() {
        Intent intent = getIntent();
        if (intent != null) {
            try {
                Bundle extras = intent.getExtras();
                q55 q55Var = new q55();
                this.Q0 = q55Var;
                q55Var.a(extras);
                q55 q55Var2 = this.Q0;
                this.R0 = q55Var2.f20183a;
                this.S0 = q55Var2.b;
                this.T0 = extras.getString("_lxapi_appid");
            } catch (Exception e) {
                e.printStackTrace();
                finish();
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("fromwblx", this.S0);
                String str = this.T0;
                if (str == null) {
                    jSONObject.put("appid", "");
                } else {
                    jSONObject.put("appid", str);
                }
                jSONObject.put(WkSDKFeature.WHAT_LOGIN, g3());
                LogUtil.uploadInfoImmediate("wblx1", null, null, jSONObject.toString());
            } catch (JSONException unused) {
            }
        }
    }

    public final void m3(String str, int i, int i2, yw4 yw4Var) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("appId", str);
            jSONObject.put("contentType", i);
            jSONObject.put("shareScene", i2);
            LogUtil.i(V0, "getAppInfo = " + jSONObject.toString());
            zw4.f(W0, 1, jSONObject, yw4Var);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public final void n3(int i) {
        Intent intent = new Intent();
        int i2 = this.S0;
        if (i2 == 0) {
            intent.setAction("com.zenmen.palmchat.openapi.Intent.ACTION_SEND_MESSAGE_STATUS");
        } else if (i2 == 1) {
            intent.setAction("com.zenmen.palmchat.openapi.Intent.ACTION_PUBLISH_MOMENT_STATUS");
        }
        intent.putExtra("_lxapi_errorcode", i);
        sendBroadcast(intent);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("fromwblx", i);
            String str = this.T0;
            if (str == null) {
                jSONObject.put("appid", "");
            } else {
                jSONObject.put("appid", str);
            }
            LogUtil.uploadInfoImmediate("wblx_F", null, null, jSONObject.toString());
        } catch (JSONException unused) {
        }
    }

    @Override // com.zenmen.palmchat.activity.webview.CordovaWebActivity, com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        l3();
        String strT = tj2.t();
        this.r0 = strT;
        E2(strT);
    }

    @Override // com.zenmen.palmchat.activity.webview.CordovaWebActivity, com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (AccountUtils.r(this)) {
            f3();
        } else {
            LogUtil.i(V0, "account not exist");
        }
    }
}
