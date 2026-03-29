package com.zenmen.palmchat.activity.search;

import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.TextView;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.Vo.MessageVo;
import com.zenmen.palmchat.activity.search.c;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.groupchat.GroupInfoItem;
import com.zenmen.palmchat.groupchat.GroupMemberInfoItem;
import com.zenmen.palmchat.widget.SocialPortraitView;
import defpackage.bo0;
import defpackage.bq6;
import defpackage.gr2;
import defpackage.il5;
import defpackage.m40;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class a extends BaseAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ArrayList<Object> f12378a;
    public LayoutInflater b;
    public Context c;
    public HashMap<String, GroupInfoItem> d;
    public Map<String, ArrayList<GroupMemberInfoItem>> e;
    public int f;
    public EditText g;
    public boolean h;
    public View.OnClickListener i;

    /* JADX INFO: renamed from: com.zenmen.palmchat.activity.search.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public class C0960a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public SocialPortraitView f12379a;
        public TextView b;
        public TextView c;
        public View d;
        public View e;
        public View f;
        public TextView g;
        public View h;
        public TextView i;

        public C0960a() {
        }
    }

    public a(Context context, ArrayList<Object> arrayList, EditText editText) {
        new ArrayList();
        this.h = false;
        this.f12378a = arrayList;
        this.c = context;
        this.b = LayoutInflater.from(context);
        this.d = null;
        this.f = 0;
        this.i = null;
        this.g = editText;
    }

    public int a(int i) {
        Object item = getItem(i);
        if (item instanceof ContactInfoItem) {
            return 0;
        }
        return item instanceof GroupInfoItem ? 1 : 2;
    }

    public void b(Map<String, ArrayList<GroupMemberInfoItem>> map) {
        this.e = map;
    }

    public final void c(int i, C0960a c0960a) {
        c0960a.h.setTag(Integer.valueOf(i));
        if (i == 0) {
            c0960a.i.setText(R.string.more_contacts);
        } else if (i == 1) {
            c0960a.i.setText(R.string.more_groups);
        } else {
            if (i != 2) {
                return;
            }
            c0960a.i.setText(R.string.more_messages);
        }
    }

    public final void e(int i, int i2, C0960a c0960a) {
        if (i == i2) {
            c0960a.e.setVisibility(8);
            c0960a.f.setVisibility(8);
            return;
        }
        c0960a.e.setVisibility(0);
        if (this.h) {
            c0960a.f.setVisibility(8);
        } else {
            c0960a.f.setVisibility(8);
        }
        if (i2 == 0) {
            c0960a.g.setText(R.string.title_contact);
        } else if (i2 == 1) {
            c0960a.g.setText(R.string.group_chat_title);
        } else {
            if (i2 != 2) {
                return;
            }
            c0960a.g.setText(R.string.search_item_message_title);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.f > 0) {
            int size = this.f12378a.size();
            int i = this.f;
            if (size > i) {
                return i;
            }
        }
        return this.f12378a.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.f12378a.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x00c3  */
    @Override // android.widget.Adapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0960a c0960a;
        String groupHeadImgUrl;
        String str;
        String strQ = il5.q(this.g.getText().toString());
        if (view == null) {
            view = this.b.inflate(R.layout.list_item_searct_contact, (ViewGroup) null, false);
            c0960a = new C0960a();
            c0960a.f12379a = (SocialPortraitView) view.findViewById(R.id.portrait);
            c0960a.b = (TextView) view.findViewById(R.id.name);
            c0960a.c = (TextView) view.findViewById(R.id.content);
            c0960a.d = view.findViewById(R.id.divider);
            c0960a.e = view.findViewById(R.id.categoryContainer);
            c0960a.f = view.findViewById(R.id.cat_divider);
            c0960a.g = (TextView) view.findViewById(R.id.category);
            View viewFindViewById = view.findViewById(R.id.more_container);
            c0960a.h = viewFindViewById;
            viewFindViewById.setOnClickListener(this.i);
            c0960a.i = (TextView) view.findViewById(R.id.more_text);
            c0960a.f12379a.changeShapeType(3);
            c0960a.f12379a.setDegreeForRoundRectangle(19, 19);
            view.setTag(c0960a);
        } else {
            c0960a = (C0960a) view.getTag();
        }
        Object obj = this.f12378a.get(i);
        if (this.f > 0) {
            int size = this.f12378a.size();
            int i2 = this.f;
            if (size <= i2 || i != i2 - 1) {
                c0960a.h.setVisibility(8);
                if (i == this.f12378a.size() - 1) {
                    c0960a.d.setVisibility(8);
                } else {
                    c0960a.d.setVisibility(0);
                }
            } else {
                c(a(i), c0960a);
                c0960a.h.setVisibility(0);
                c0960a.d.setVisibility(8);
            }
        }
        if (i == 0) {
            e(-1, a(i), c0960a);
        } else {
            e(a(i - 1), a(i), c0960a);
        }
        if (obj instanceof ContactInfoItem) {
            ContactInfoItem contactInfoItem = (ContactInfoItem) obj;
            if (TextUtils.isEmpty(contactInfoItem.getUid())) {
                String strG = c.g();
                gr2.j().e(R.drawable.icon_search_friends, c0960a.f12379a, bq6.s());
                c0960a.b.setText(il5.h(strG + strQ, strQ));
                c0960a.c.setVisibility(8);
            } else {
                String iconURL = contactInfoItem.getIconURL();
                String remarkName = contactInfoItem.getRemarkName();
                String str2 = this.c.getString(R.string.settings_account) + "：";
                SpannableString spannableStringG = il5.g(str2.length(), str2 + contactInfoItem.getAccount(), null, null, strQ);
                if (TextUtils.isEmpty(remarkName)) {
                    SpannableString spannableStringG2 = il5.g(0, contactInfoItem.getNickName(), contactInfoItem.getAllPinyin(), contactInfoItem.getFirstPinyin(), strQ);
                    c0960a.c.setVisibility(8);
                    if (spannableStringG2 != null) {
                        c0960a.b.setText(spannableStringG2);
                    } else {
                        c0960a.b.setText(contactInfoItem.getNickName());
                        if (spannableStringG != null) {
                            c0960a.c.setText(spannableStringG);
                            c0960a.c.setVisibility(0);
                        }
                    }
                } else {
                    SpannableString spannableStringG3 = il5.g(0, contactInfoItem.getRemarkName(), contactInfoItem.getRemarkAllPinyin(), contactInfoItem.getRemarkFirstPinyin(), strQ);
                    if (spannableStringG3 != null) {
                        c0960a.b.setText(spannableStringG3);
                        c0960a.c.setVisibility(8);
                    } else {
                        c0960a.b.setText(remarkName);
                        String str3 = this.c.getString(R.string.search_nick_name) + "：";
                        SpannableString spannableStringG4 = il5.g(str3.length(), str3 + contactInfoItem.getNickName(), contactInfoItem.getAllPinyin(), contactInfoItem.getFirstPinyin(), strQ);
                        if (spannableStringG4 != null) {
                            c0960a.c.setText(spannableStringG4);
                            c0960a.c.setVisibility(0);
                        } else if (spannableStringG != null) {
                            c0960a.c.setText(spannableStringG);
                            c0960a.c.setVisibility(0);
                        } else {
                            c0960a.c.setVisibility(8);
                        }
                    }
                }
                gr2.j().h(iconURL, c0960a.f12379a, bq6.s());
            }
        } else if (obj instanceof c.e) {
            c.e eVar = (c.e) obj;
            int iB = m40.b(eVar.b.contactRelate);
            MessageVo messageVo = eVar.b;
            String str4 = messageVo.text;
            String chatName = "";
            if (iB == 0) {
                ContactInfoItem contactInfoItemL = bo0.r().l(eVar.b.contactRelate);
                if (contactInfoItemL != null) {
                    String nameForShow = contactInfoItemL.getNameForShow();
                    chatName = contactInfoItemL.getIconURL();
                    str = nameForShow;
                } else {
                    str = "";
                }
                String str5 = chatName;
                chatName = str;
                groupHeadImgUrl = str5;
            } else {
                GroupInfoItem groupInfoItem = this.d.get(m40.d(messageVo.contactRelate));
                if (groupInfoItem != null) {
                    chatName = groupInfoItem.getChatName() != null ? groupInfoItem.getChatName() : groupInfoItem.getGroupLocalName();
                    groupHeadImgUrl = groupInfoItem.getGroupHeadImgUrl();
                } else {
                    groupHeadImgUrl = "";
                }
            }
            c0960a.b.setText(chatName);
            int i3 = eVar.f12390a;
            if (i3 == 1) {
                c0960a.c.setText(il5.h(str4, strQ));
            } else {
                c0960a.c.setText(this.c.getString(R.string.search_item_message_count, Integer.valueOf(i3)));
            }
            c0960a.c.setVisibility(0);
            gr2.j().h(groupHeadImgUrl, c0960a.f12379a, bq6.s());
        } else if (obj instanceof GroupInfoItem) {
            GroupInfoItem groupInfoItem2 = (GroupInfoItem) obj;
            String groupName = groupInfoItem2.getGroupName();
            if (TextUtils.isEmpty(groupName)) {
                c0960a.b.setText(groupInfoItem2.getGroupLocalName());
            } else {
                c0960a.b.setText(il5.h(groupName, strQ));
            }
            if (TextUtils.isEmpty(groupName) || !il5.c(groupName, strQ)) {
                Map<String, ArrayList<GroupMemberInfoItem>> map = this.e;
                if (map != null) {
                    ArrayList<GroupMemberInfoItem> arrayList = map.get(groupInfoItem2.getGroupId());
                    if (arrayList != null) {
                        c0960a.c.setVisibility(0);
                        c0960a.c.setText(il5.f(arrayList, strQ));
                    } else {
                        c0960a.c.setVisibility(8);
                    }
                }
            } else {
                c0960a.c.setVisibility(8);
            }
            gr2.j().h(groupInfoItem2.getGroupHeadImgUrl(), c0960a.f12379a, bq6.s());
        }
        return view;
    }

    public a(Context context, ArrayList<Object> arrayList, HashMap<String, GroupInfoItem> map, EditText editText) {
        this(context, arrayList, editText);
        this.d = map;
    }

    public a(Context context, int i, View.OnClickListener onClickListener, ArrayList<Object> arrayList, EditText editText, boolean z) {
        this(context, arrayList, null, editText);
        this.f = i;
        this.i = onClickListener;
        this.h = z;
    }

    public a(Context context, int i, View.OnClickListener onClickListener, ArrayList<Object> arrayList, HashMap<String, GroupInfoItem> map, EditText editText, boolean z) {
        this(context, arrayList, map, editText);
        this.f = i;
        this.i = onClickListener;
        this.h = z;
    }
}
