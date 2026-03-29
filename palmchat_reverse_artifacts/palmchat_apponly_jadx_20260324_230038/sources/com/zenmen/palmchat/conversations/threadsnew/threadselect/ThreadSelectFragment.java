package com.zenmen.palmchat.conversations.threadsnew.threadselect;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.loader.content.CursorLoader;
import androidx.loader.content.Loader;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.BaseFragment;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.chat.ThreadChatItem;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.palmchat.voiceroom.adapter.RcyHolder;
import com.zenmen.palmchat.voiceroom.adapter.RcySAdapter;
import com.zenmen.palmchat.widget.SocialPortraitView;
import defpackage.UI;
import defpackage.a46;
import defpackage.a65;
import defpackage.dd6;
import defpackage.dx5;
import defpackage.fu5;
import defpackage.l50;
import defpackage.pm2;
import defpackage.v4;
import defpackage.v8;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class ThreadSelectFragment extends BaseFragment implements pm2<Cursor> {
    public RecyclerView f;
    public View g;
    public LinearLayoutManager h;
    public RcySAdapter<ThreadChatItem, RcyHolder> i = null;
    public b j;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends RcySAdapter<ThreadChatItem, RcyHolder> {
        public a(Context context, int i) {
            super(context, i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void k(ThreadChatItem threadChatItem, View view) {
            if (ThreadSelectFragment.this.j == null || l50.a()) {
                return;
            }
            ThreadSelectFragment.this.j.a(threadChatItem);
        }

        @Override // com.zenmen.palmchat.voiceroom.adapter.RcySAdapter
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public void h(RcyHolder rcyHolder, final ThreadChatItem threadChatItem, int i) {
            ((TextView) rcyHolder.l(R.id.text)).setText(threadChatItem.getChatName());
            SocialPortraitView socialPortraitView = (SocialPortraitView) rcyHolder.l(R.id.icon);
            socialPortraitView.changeShapeType(1);
            a46.u(threadChatItem.iconUrl, socialPortraitView, R.drawable.ic_default_portrait);
            rcyHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: zw5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f22535a.k(threadChatItem, view);
                }
            });
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface b {
        void a(ThreadChatItem threadChatItem);
    }

    public final boolean T() {
        return true;
    }

    @Override // defpackage.pm2
    /* JADX INFO: renamed from: V, reason: merged with bridge method [inline-methods] */
    public void onLoadFinished(@NonNull Loader<Cursor> loader, @Nullable Cursor cursor) {
        if (cursor == null) {
            this.g.setVisibility(8);
            return;
        }
        LogUtil.i("ThreadSelectFragment", "onLoadFinished" + cursor.getCount());
        ArrayList arrayList = new ArrayList();
        cursor.moveToPosition(-1);
        String strE = v4.e(AppContext.getContext());
        while (cursor.moveToNext()) {
            ThreadChatItem cursor2 = ThreadChatItem.parseCursor(cursor);
            if (strE == null || !strE.equals(cursor2.getChatId())) {
                if (cursor2.getChatId() == null || !v8.B.contains(cursor2.getChatId())) {
                    if (!T() || !a65.f(cursor2.getChatId())) {
                        arrayList.add(cursor2);
                    }
                }
            }
        }
        this.i.g(arrayList, true);
        if (arrayList.size() > 0) {
            this.g.setVisibility(8);
        } else {
            this.g.setVisibility(0);
        }
    }

    public void W(b bVar) {
        this.j = bVar;
    }

    @Override // defpackage.pm2
    @Nullable
    public Loader<Cursor> onCreateLoader(int i, @Nullable Bundle bundle) {
        StringBuilder sb = new StringBuilder();
        ArrayList arrayList = new ArrayList();
        sb.append("thread_active");
        sb.append("=? and ");
        arrayList.add(String.valueOf(1));
        sb.append("chat_type");
        sb.append("=? and ");
        arrayList.add(String.valueOf(0));
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
        fu5.b(sb, arrayList, true, false);
        sb.append("thread_biz_type");
        sb.append("=?)) or (");
        arrayList.add(String.valueOf(13));
        sb.append("thread_contact_ready");
        sb.append(" =? and ");
        arrayList.add(String.valueOf(0));
        sb.append("thread_biz_type");
        sb.append(" =? ))");
        arrayList.add(String.valueOf(22));
        String string = sb.toString();
        String[] strArr = (String[]) arrayList.toArray(new String[arrayList.size()]);
        LogUtil.i("ThreadSelectFragment", "onCreateLoader selection" + string);
        return new CursorLoader(getActivity(), dx5.f17178a, null, string, strArr, "thread_priority DESC , pin_gift_message DESC , is_super_greetings DESC , thread_draft_time DESC , latest_message_time_stamp DESC");
    }

    @Override // com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_fragment_thread_select, viewGroup, false);
        this.f = (RecyclerView) viewInflate.findViewById(R.id.recycler_view);
        this.g = viewInflate.findViewById(R.id.emptyView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        this.h = linearLayoutManager;
        this.f.setLayoutManager(linearLayoutManager);
        this.f.setItemAnimator(null);
        a aVar = new a(getContext(), R.layout.item_thread_select);
        this.i = aVar;
        this.f.setAdapter(aVar);
        UI.c(getActivity(), 100, null, this);
        return viewInflate;
    }

    @Override // defpackage.pm2
    public void onLoaderReset(@NonNull Loader<Cursor> loader) {
        LogUtil.i("ThreadSelectFragment", "onLoaderReset");
    }
}
