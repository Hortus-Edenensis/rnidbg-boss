package com.zenmen.palmchat.conversations.threadsnew.filter;

import android.R;
import android.content.AsyncQueryHandler;
import android.content.ContentResolver;
import android.content.res.ColorStateList;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.chat.ThreadChatItem;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.conversations.threadsnew.adapter.ConversationAdapter;
import com.zenmen.palmchat.conversations.threadsnew.filter.FilterConfig;
import com.zenmen.palmchat.database.DBUriManager;
import com.zenmen.palmchat.database.ThreadBizExtHelper;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.a65;
import defpackage.az2;
import defpackage.bo0;
import defpackage.ho3;
import defpackage.ir5;
import defpackage.me1;
import defpackage.pw5;
import defpackage.zn6;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public InterfaceC1040a f13820a;
    public ViewGroup b;
    public b g;
    public FilterType c = FilterType.ALL;
    public boolean d = false;
    public FilterConfig e = null;
    public final ConcurrentHashMap<String, Integer> f = new ConcurrentHashMap<>();
    public final ColorStateList h = new ColorStateList(new int[][]{new int[]{R.attr.state_selected}, new int[0]}, new int[]{Color.parseColor("#222222"), Color.parseColor("#999999")});

    /* JADX INFO: renamed from: com.zenmen.palmchat.conversations.threadsnew.filter.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public interface InterfaceC1040a {
        void b(FilterType filterType);

        void q();
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends AsyncQueryHandler {
        public b(ContentResolver contentResolver) {
            super(contentResolver);
        }

        public void a() {
            LogUtil.i("ThreadFilterHelper", "startQueryHotChat");
            if (a.this.e != null) {
                String[] strArr = {String.valueOf(ir5.b() - a.this.e.getHotChatInterval()), String.valueOf(10000)};
                startQuery(0, null, DBUriManager.d(ho3.class, DBUriManager.MsgSaveType.COMMON), new String[]{"contact_relate"}, "date>=? and msg_type !=?", strArr, null);
            }
        }

        @Override // android.content.AsyncQueryHandler
        public void onQueryComplete(int i, Object obj, Cursor cursor) {
            super.onQueryComplete(i, obj, cursor);
            LogUtil.i("ThreadFilterHelper", "onQueryComplete" + i);
            if (i != 0 || cursor == null) {
                return;
            }
            HashMap map = new HashMap();
            while (cursor.moveToNext()) {
                String string = cursor.getString(0);
                if (string != null) {
                    Integer num = (Integer) map.get(string);
                    if (num == null) {
                        map.put(string, 1);
                    } else {
                        map.put(string, Integer.valueOf(num.intValue() + 1));
                    }
                }
            }
            cursor.close();
            a.this.f.clear();
            a.this.f.putAll(map);
            LogUtil.i("ThreadFilterHelper", "onHotChatQueryComplete");
            if (a.this.f13820a != null) {
                a.this.f13820a.q();
            }
        }
    }

    public List<ConversationAdapter.c> d(List<ConversationAdapter.a> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            FilterType filterType = this.c;
            if (filterType == FilterType.ALL) {
                arrayList.addAll(list);
            } else if (filterType == FilterType.INTIMACY) {
                for (ConversationAdapter.a aVar : list) {
                    if (l(aVar.f13812a)) {
                        arrayList.add(aVar);
                    }
                }
            } else if (filterType == FilterType.HOT) {
                for (ConversationAdapter.a aVar2 : list) {
                    if (k(aVar2.f13812a)) {
                        arrayList.add(aVar2);
                    }
                }
            } else if (filterType == FilterType.NEW) {
                for (ConversationAdapter.a aVar3 : list) {
                    if (m(aVar3.f13812a)) {
                        arrayList.add(aVar3);
                    }
                }
            }
        }
        if (this.d) {
            int i = 0;
            if (list != null) {
                for (ConversationAdapter.a aVar4 : list) {
                    if (m(aVar4.f13812a)) {
                        i += aVar4.f13812a.unReadCount;
                    }
                }
            }
            r(i);
        }
        return arrayList;
    }

    public FilterType e() {
        return this.c;
    }

    public final b f() {
        if (this.g == null) {
            this.g = new b(AppContext.getContext().getContentResolver());
        }
        return this.g;
    }

    public final String g(int i) {
        if (i > 99) {
            return "(99+)";
        }
        if (i <= 0) {
            return "";
        }
        return "(" + i + ")";
    }

    public final float h(ThreadChatItem threadChatItem) {
        ContactInfoItem contactInfoItemL;
        if (threadChatItem.chatType != 0 || (contactInfoItemL = bo0.r().l(threadChatItem.getChatId())) == null || a65.e(contactInfoItemL)) {
            return 0.0f;
        }
        return contactInfoItemL.getIntimacyScore();
    }

    public View i(FilterConfig.Items items, int i) {
        TextView textView = new TextView(AppContext.getContext());
        textView.setText(items.name);
        textView.setTextSize(1, 14.0f);
        textView.setTextColor(this.h);
        textView.setTag(items);
        int iB = me1.b(AppContext.getContext(), 8);
        int iB2 = me1.b(AppContext.getContext(), 10);
        textView.setPadding(iB2, iB, iB2, iB);
        textView.setOnClickListener(this);
        return textView;
    }

    public void j(View view) {
        List<FilterConfig.Items> list;
        boolean zB = pw5.b();
        this.d = zB;
        if (zB) {
            this.e = pw5.a();
            LogUtil.i("ThreadFilterHelper", "init 1" + az2.c(this.e));
            FilterConfig filterConfig = this.e;
            if (filterConfig == null || (list = filterConfig.subtitles) == null || list.size() == 0) {
                return;
            }
            this.b = (ViewGroup) view.findViewById(com.zenmen.palmchat.R.id.filter_layout);
            for (int i = 0; i < this.e.subtitles.size(); i++) {
                this.b.addView(i(this.e.subtitles.get(i), i));
            }
            s();
        }
    }

    public final boolean k(ThreadChatItem threadChatItem) {
        Integer num;
        return threadChatItem.chatType == 0 && this.e != null && threadChatItem.bizType == 0 && h(threadChatItem) < this.e.intimacy && !a65.e(threadChatItem) && threadChatItem.getChatId() != null && (num = this.f.get(threadChatItem.getChatId())) != null && num.intValue() >= this.e.hotChatCount;
    }

    public final boolean l(ThreadChatItem threadChatItem) {
        return threadChatItem.chatType == 0 && this.e != null && threadChatItem.bizType == 0 && !a65.e(threadChatItem) && h(threadChatItem) >= this.e.intimacy;
    }

    public final boolean m(ThreadChatItem threadChatItem) {
        ThreadBizExtHelper.BizExt bizExt;
        if (threadChatItem.chatType == 0 && threadChatItem.bizType != 0 && !a65.e(threadChatItem) && this.e != null && Math.abs(ir5.b() - threadChatItem.lastMessageDate) < this.e.getNewMsgInterval()) {
            String str = threadChatItem.bizExtension;
            if (!TextUtils.isEmpty(str) && (bizExt = (ThreadBizExtHelper.BizExt) az2.a(str, ThreadBizExtHelper.BizExt.class)) != null && bizExt.replyState == 2) {
                return true;
            }
        }
        return false;
    }

    public void n(FilterType filterType) {
        if (!this.d || this.c == filterType) {
            return;
        }
        this.c = filterType;
        if (filterType == FilterType.HOT) {
            p();
        }
        s();
        HashMap map = new HashMap();
        map.put("type", String.valueOf(this.c.value));
        zn6.i("msgtab_subtitle", map);
        LogUtil.i("ThreadFilterHelper", "onChanged" + filterType);
        InterfaceC1040a interfaceC1040a = this.f13820a;
        if (interfaceC1040a != null) {
            interfaceC1040a.b(filterType);
        }
    }

    public void o(boolean z) {
        ViewGroup viewGroup = this.b;
        if (viewGroup != null) {
            viewGroup.setVisibility(z ? 0 : 8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        FilterType filterTypeFindFilterType;
        Object tag = view.getTag();
        if (!(tag instanceof FilterConfig.Items) || (filterTypeFindFilterType = FilterType.findFilterType(((FilterConfig.Items) tag).type)) == null) {
            return;
        }
        n(filterTypeFindFilterType);
    }

    public final void p() {
        f().a();
    }

    public void q(InterfaceC1040a interfaceC1040a) {
        this.f13820a = interfaceC1040a;
    }

    public final void r(int i) {
        if (!this.d || this.b == null) {
            return;
        }
        for (int i2 = 0; i2 < this.b.getChildCount(); i2++) {
            View childAt = this.b.getChildAt(i2);
            if (childAt instanceof TextView) {
                TextView textView = (TextView) childAt;
                Object tag = childAt.getTag();
                if (tag instanceof FilterConfig.Items) {
                    FilterConfig.Items items = (FilterConfig.Items) tag;
                    if (FilterType.findFilterType(items.type) == FilterType.NEW) {
                        textView.setText(items.name + g(i));
                    }
                }
            }
        }
    }

    public final void s() {
        if (!this.d || this.b == null) {
            return;
        }
        for (int i = 0; i < this.b.getChildCount(); i++) {
            View childAt = this.b.getChildAt(i);
            if (childAt instanceof TextView) {
                TextView textView = (TextView) childAt;
                Object tag = childAt.getTag();
                if (tag instanceof FilterConfig.Items) {
                    boolean z = FilterType.findFilterType(((FilterConfig.Items) tag).type) == this.c;
                    textView.setSelected(z);
                    textView.setTypeface(z ? Typeface.DEFAULT_BOLD : Typeface.DEFAULT);
                }
            }
        }
    }
}
