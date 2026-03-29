package com.zenmen.palmchat.paidservices.superexpose.msgtab.ui.recycler;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.paidservices.superexpose.msgtab.SuperExposeNumItem;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.bj5;
import defpackage.fk2;
import defpackage.hs3;
import defpackage.n5;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class SuperExposeTabRecyclerItemLayout extends FrameLayout {
    private SuperExposeNumItem mItem;

    public SuperExposeTabRecyclerItemLayout(@NonNull Context context) {
        super(context);
        this.mItem = null;
    }

    public void onItemClick() {
        SuperExposeNumItem superExposeNumItem = this.mItem;
        if (superExposeNumItem != null) {
            String str = superExposeNumItem.uid;
            LogUtil.d("", "MsgTabTaijiModelManager onItemClick uid " + str);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            ContactInfoItem contactInfoItem = new ContactInfoItem();
            Bundle bundle = new Bundle();
            fk2.a aVar = new fk2.a();
            contactInfoItem.setUid(this.mItem.uid);
            contactInfoItem.setIconURL(this.mItem.avatar);
            contactInfoItem.setNickName(this.mItem.nickname);
            contactInfoItem.setSourceType(60);
            contactInfoItem.setBizType(bj5.b().a().u(this.mItem.getChatBizType(1)));
            bundle.putInt("from", 79);
            bundle.putParcelable("user_item_info", contactInfoItem);
            aVar.b(bundle);
            Intent intentA = n5.a(getContext(), aVar);
            intentA.putExtra("superExposeMsgTabItem", 1);
            if (!(getContext() instanceof Activity)) {
                intentA.addFlags(268435456);
            }
            getContext().startActivity(intentA);
            hs3.g(str, this.mItem.position);
        }
    }

    public void setItemData(SuperExposeNumItem superExposeNumItem) {
        this.mItem = superExposeNumItem;
    }

    public SuperExposeTabRecyclerItemLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mItem = null;
    }

    public SuperExposeTabRecyclerItemLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mItem = null;
    }
}
