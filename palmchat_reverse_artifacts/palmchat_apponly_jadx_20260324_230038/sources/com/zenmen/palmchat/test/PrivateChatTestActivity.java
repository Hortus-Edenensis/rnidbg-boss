package com.zenmen.palmchat.test;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.SwipeBackLayout.app.SwipeBackActivity;
import com.zenmen.palmchat.chat.ChatterActivity;
import com.zenmen.palmchat.chat.temporary.SquareTempChatActivity;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.az2;
import defpackage.dn0;
import defpackage.fo0;
import defpackage.fu5;
import defpackage.go0;
import defpackage.k86;
import defpackage.sy5;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class PrivateChatTestActivity extends SwipeBackActivity {

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ EditText f15443a;
        public final /* synthetic */ EditText b;

        public a(EditText editText, EditText editText2) {
            this.f15443a = editText;
            this.b = editText2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String strTrim = this.f15443a.getText().toString().trim();
            if (TextUtils.isEmpty(strTrim)) {
                sy5.f(PrivateChatTestActivity.this, "业务类型不能为空", 0).g();
                return;
            }
            int i = Integer.parseInt(strTrim) + 5000;
            String strTrim2 = this.b.getText().toString().trim();
            if (!fu5.q(i)) {
                sy5.f(PrivateChatTestActivity.this, "业务类型取值范围只能在1-1023", 0).g();
                return;
            }
            if (TextUtils.isEmpty(strTrim2)) {
                sy5.f(PrivateChatTestActivity.this, "UID不能为空", 0).g();
                return;
            }
            LogUtil.i("PrivateChatTestActivity", "bizType:" + i + " -- uid:" + strTrim2);
            PrivateChatTestActivity privateChatTestActivity = PrivateChatTestActivity.this;
            privateChatTestActivity.C1(privateChatTestActivity, strTrim2, i);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements fo0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f15444a;
        public final /* synthetic */ int b;

        public b(Activity activity, int i) {
            this.f15444a = activity;
            this.b = i;
        }

        @Override // defpackage.fo0
        public void onResponse(int i, String str) {
            if (i != 0) {
                sy5.f(this.f15444a, "获取用户信息失败", 0).g();
            } else {
                PrivateChatTestActivity.this.D1(this.f15444a, (ContactInfoItem) az2.a(str, ContactInfoItem.class), this.b);
            }
        }
    }

    public void C1(Activity activity, String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        ContactInfoItem contactInfoItemA = dn0.a(str);
        if (contactInfoItemA == null) {
            go0.h(str, null, new b(activity, i));
        } else {
            D1(activity, contactInfoItemA, i);
        }
    }

    public final void D1(Activity activity, ContactInfoItem contactInfoItem, int i) {
        if (contactInfoItem == null) {
            sy5.f(activity, "用户信息为空", 0).g();
            return;
        }
        if (contactInfoItem.getIsStranger()) {
            contactInfoItem.setBizType(i);
            SquareTempChatActivity.I1(activity, contactInfoItem, contactInfoItem.getBizType(), null);
            return;
        }
        contactInfoItem.setBizType(0);
        Intent intent = new Intent(AppContext.getContext(), (Class<?>) ChatterActivity.class);
        intent.putExtra("chat_item", contactInfoItem);
        intent.putExtra("thread_biz_type", contactInfoItem.getBizType());
        intent.putExtra("chat_need_back_to_main", false);
        intent.putExtra("chat_back_to_greet", false);
        k86.X(intent);
        activity.startActivity(intent);
    }

    @Override // com.zenmen.palmchat.SwipeBackLayout.app.SwipeBackActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_private_chat_test);
        ((Button) findViewById(R.id.send)).setOnClickListener(new a((EditText) findViewById(R.id.et_bizType), (EditText) findViewById(R.id.et_uid)));
    }
}
