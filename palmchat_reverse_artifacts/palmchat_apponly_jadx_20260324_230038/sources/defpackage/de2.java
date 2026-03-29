package defpackage;

import android.app.Activity;
import android.content.Intent;
import com.afollestad.materialdialogs.MaterialDialog;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.groupchat.GroupCateSelectActivity;
import com.zenmen.palmchat.groupchat.dao.GroupModifyResultVo;
import com.zenmen.palmchat.redpacket.pay.SPWalletUtils;
import com.zenmen.palmchat.settings.cert.a;
import com.zenmen.palmchat.utils.log.LogUtil;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class de2 {

    /* JADX INFO: compiled from: SearchBox */
    public class a implements al4 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f17029a;
        public final /* synthetic */ Activity b;
        public final /* synthetic */ SPWalletUtils.BindCardCallback c;

        /* JADX INFO: renamed from: de2$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class C1182a implements a.b {
            public C1182a() {
            }

            @Override // com.zenmen.palmchat.settings.cert.a.b
            public void onResult(boolean z) {
                if (z) {
                    a.this.c.onSuccess(0, null, null);
                } else {
                    a.this.c.onFail(-1, null, null);
                }
            }
        }

        public a(String str, Activity activity, SPWalletUtils.BindCardCallback bindCardCallback) {
            this.f17029a = str;
            this.b = activity;
            this.c = bindCardCallback;
        }

        @Override // defpackage.al4
        public void a(GroupModifyResultVo groupModifyResultVo) {
            LogUtil.uploadInfoImmediate("hgrz123", "1", "1", this.f17029a);
            com.zenmen.palmchat.settings.cert.a.a().d(this.b, new C1182a());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends MaterialDialog.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f17031a;

        public b(String str) {
            this.f17031a = str;
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            super.onPositive(materialDialog);
            LogUtil.uploadInfoImmediate("hgrz124", "1", "1", this.f17031a);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends MaterialDialog.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f17032a;
        public final /* synthetic */ String b;

        public c(Activity activity, String str) {
            this.f17032a = activity;
            this.b = str;
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onNegative(MaterialDialog materialDialog) {
            super.onNegative(materialDialog);
            LogUtil.uploadInfoImmediate("hgrz202", "1", "1", null);
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            super.onPositive(materialDialog);
            LogUtil.uploadInfoImmediate("hgrz203", "1", "1", null);
            Intent intent = new Intent();
            intent.setClass(this.f17032a, GroupCateSelectActivity.class);
            intent.putExtra("extra_groupid", this.b);
            intent.putExtra("extra_from", 1);
            this.f17032a.startActivity(intent);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:4:0x0008  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(Activity activity, GroupModifyResultVo groupModifyResultVo, String str, SPWalletUtils.BindCardCallback bindCardCallback) {
        int i;
        int i2 = groupModifyResultVo.resultCode;
        boolean z = false;
        int i3 = 1;
        if (i2 != 4026) {
            if (i2 == 4027) {
                z = true;
                i = 0;
            } else if (i2 == 4031) {
                z = true;
                i3 = 0;
                i = 1;
            } else {
                i = 2;
                if (i2 != 4033) {
                    if (i2 != 4034) {
                        i = 3;
                        if (i2 != 4029) {
                            if (i2 != 4030) {
                                if (i2 != 4035 && i2 != 4036) {
                                    z = true;
                                }
                                i3 = 0;
                                i = 0;
                            }
                        }
                        z = true;
                        i3 = 0;
                    }
                    z = true;
                } else {
                    z = true;
                    i3 = 0;
                }
            }
        }
        if (!z) {
            LogUtil.uploadInfoImmediate("hgrz201", "1", "1", null);
            new sd3(activity).k(groupModifyResultVo.errorMsg).K(R.string.realname_later).O(R.string.group_cate_update_now).f(new c(activity, str)).e().show();
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("from", i);
            jSONObject.put("type", i3);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        String string = jSONObject.toString();
        LogUtil.uploadInfoImmediate("hgrz121", "1", "1", string);
        if (i3 == 0) {
            w4.C(activity, groupModifyResultVo, new a(string, activity, bindCardCallback));
        } else {
            new sd3(activity).k(groupModifyResultVo.errorMsg).O(R.string.red_packet_timeout_know).f(new b(string)).e().show();
        }
    }
}
