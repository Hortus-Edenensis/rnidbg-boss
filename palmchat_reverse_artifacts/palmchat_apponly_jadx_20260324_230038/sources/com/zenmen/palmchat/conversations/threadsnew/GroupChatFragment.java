package com.zenmen.palmchat.conversations.threadsnew;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.loader.content.CursorLoader;
import androidx.loader.content.Loader;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.conversations.threadsnew.adapter.ConversationAdapter;
import com.zenmen.palmchat.groupchat.GroupChatInitActivity;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.ch;
import defpackage.dd6;
import defpackage.dx5;
import defpackage.oc0;
import defpackage.uw5;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class GroupChatFragment extends MessageFragment {
    public View B;
    public ImageView C;
    public TextView E;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Intent intent = new Intent(AppContext.getContext(), (Class<?>) GroupChatInitActivity.class);
            intent.putExtra("from_type", 2);
            GroupChatFragment.this.startActivity(intent);
            LogUtil.uploadInfoImmediate(AccountUtils.p(AppContext.getContext()), "15q3", "1", null, null);
            oc0.g("lx_group_create4_click");
        }
    }

    @Override // com.zenmen.palmchat.conversations.threadsnew.MessageFragment
    public int A0() {
        return ch.s().C();
    }

    @Override // com.zenmen.palmchat.conversations.threadsnew.MessageFragment, defpackage.pm2
    /* JADX INFO: renamed from: L0 */
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
        super.onLoadFinished(loader, cursor);
        Z0();
    }

    public final void Z0() {
        ConversationAdapter conversationAdapter;
        if (!isAdded() || (conversationAdapter = this.j) == null || this.B == null) {
            return;
        }
        if (conversationAdapter.getItemCount() != 0) {
            this.B.setVisibility(8);
            return;
        }
        this.B.setVisibility(0);
        int iC = uw5.c();
        if (iC != 0) {
            this.C.setVisibility(8);
        }
        if (iC == 1) {
            this.E.setText(R.string.group_circle_chat_empty_tips);
        }
    }

    @Override // com.zenmen.palmchat.conversations.threadsnew.MessageFragment, defpackage.pm2
    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        LogUtil.i("GroupChatFragment", "onCreateLoader " + i);
        if (i != y0()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        ArrayList arrayList = new ArrayList();
        sb.append("thread_active");
        sb.append("=? and ");
        arrayList.add(String.valueOf(1));
        sb.append("chat_type");
        sb.append("=? and ");
        arrayList.add(String.valueOf(1));
        sb.append("contact_relate");
        sb.append(" !=? and ");
        arrayList.add("88888003");
        if (dd6.b()) {
            sb.append("contact_relate");
            sb.append(" !=? and ");
            arrayList.add("88888027");
        }
        if (dd6.a()) {
            sb.append("contact_relate");
            sb.append(" !=? and ");
            arrayList.add("88888010");
        }
        sb.append("thread_blacklist");
        sb.append("=? and  (( ");
        arrayList.add(String.valueOf(0));
        sb.append("thread_contact_ready");
        sb.append("=? and (");
        arrayList.add(String.valueOf(1));
        sb.append("thread_biz_type");
        sb.append("=? or ");
        arrayList.add(String.valueOf(0));
        sb.append("thread_biz_type");
        sb.append("=?)) or (");
        arrayList.add(String.valueOf(13));
        sb.append("thread_contact_ready");
        sb.append(" =? and ");
        arrayList.add(String.valueOf(0));
        sb.append("thread_biz_type");
        sb.append(" =? ))");
        arrayList.add(String.valueOf(22));
        return new CursorLoader(getActivity(), dx5.f17178a, null, sb.toString(), (String[]) arrayList.toArray(new String[arrayList.size()]), "thread_priority DESC , thread_draft_time DESC , latest_message_time_stamp DESC");
    }

    @Override // com.zenmen.palmchat.conversations.threadsnew.MessageFragment, com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewOnCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        this.B = viewOnCreateView.findViewById(R.id.empty);
        this.C = (ImageView) viewOnCreateView.findViewById(R.id.iv_empty_arrow);
        this.E = (TextView) viewOnCreateView.findViewById(R.id.tv_empty_tip);
        this.B.setOnClickListener(new a());
        return viewOnCreateView;
    }

    @Override // com.zenmen.palmchat.conversations.threadsnew.MessageFragment, defpackage.pm2
    public void onLoaderReset(Loader<Cursor> loader) {
        super.onLoaderReset(loader);
        Z0();
    }

    @Override // com.zenmen.palmchat.conversations.threadsnew.MessageFragment
    public int x0() {
        return R.layout.layout_fragment_group_chat;
    }

    @Override // com.zenmen.palmchat.conversations.threadsnew.MessageFragment
    public int y0() {
        return 2;
    }
}
