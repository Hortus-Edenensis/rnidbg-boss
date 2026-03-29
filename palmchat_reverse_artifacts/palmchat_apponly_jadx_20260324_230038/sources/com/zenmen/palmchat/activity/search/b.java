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
import com.zenmen.palmchat.chat.ThreadChatItem;
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
public class b extends BaseAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ArrayList<Object> f12380a;
    public LayoutInflater b;
    public Context c;
    public HashMap<String, GroupInfoItem> d;
    public Map<String, ArrayList<GroupMemberInfoItem>> e;
    public EditText f;

    /* JADX INFO: compiled from: SearchBox */
    public class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public SocialPortraitView f12381a;
        public TextView b;
        public TextView c;
        public View d;
        public TextView e;

        public a() {
        }
    }

    public b(Context context, ArrayList<Object> arrayList, HashMap<String, GroupInfoItem> map, EditText editText) {
        new ArrayList();
        this.f12380a = arrayList;
        this.c = context;
        this.b = LayoutInflater.from(context);
        this.d = map;
        this.f = editText;
    }

    public int a(int i) {
        Object item = getItem(i);
        if (item instanceof ContactInfoItem) {
            return 0;
        }
        if (item instanceof GroupInfoItem) {
            return 1;
        }
        if (item instanceof c.e) {
            return 2;
        }
        return item instanceof ThreadChatItem ? 3 : 0;
    }

    public void b(Map<String, ArrayList<GroupMemberInfoItem>> map) {
        this.e = map;
    }

    public final void c(int i, int i2, a aVar) {
        if (i == i2) {
            aVar.e.setVisibility(8);
            return;
        }
        aVar.e.setVisibility(0);
        if (i2 == 0) {
            aVar.e.setText(R.string.title_contact);
            return;
        }
        if (i2 == 1) {
            aVar.e.setText(R.string.group_chat_title);
            return;
        }
        if (i2 == 2) {
            aVar.e.setText(R.string.search_item_message_title);
        } else if (i2 != 3) {
            return;
        }
        aVar.e.setText(R.string.latest_threads);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f12380a.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.f12380a.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        String groupHeadImgUrl;
        String str;
        String strQ = il5.q(this.f.getText().toString());
        if (view == null) {
            view = this.b.inflate(R.layout.list_item_forward_theads, (ViewGroup) null, false);
            aVar = new a();
            SocialPortraitView socialPortraitView = (SocialPortraitView) view.findViewById(R.id.portrait);
            aVar.f12381a = socialPortraitView;
            socialPortraitView.changeShapeType(3);
            aVar.f12381a.setDegreeForRoundRectangle(10, 10);
            aVar.b = (TextView) view.findViewById(R.id.name);
            aVar.c = (TextView) view.findViewById(R.id.content);
            aVar.d = view.findViewById(R.id.divider);
            aVar.e = (TextView) view.findViewById(R.id.category);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        Object obj = this.f12380a.get(i);
        if (i == 0) {
            c(-1, a(i), aVar);
        } else {
            c(a(i - 1), a(i), aVar);
        }
        if (obj instanceof ContactInfoItem) {
            ContactInfoItem contactInfoItem = (ContactInfoItem) obj;
            if (TextUtils.isEmpty(contactInfoItem.getUid())) {
                String string = this.c.getResources().getString(R.string.search_phone);
                aVar.f12381a.setImageResource(R.drawable.icon_search_friends);
                aVar.b.setText(il5.h(string + strQ, strQ));
                aVar.c.setVisibility(8);
            } else {
                String iconURL = contactInfoItem.getIconURL();
                String remarkName = contactInfoItem.getRemarkName();
                String str2 = this.c.getString(R.string.settings_account) + "：";
                SpannableString spannableStringG = il5.g(str2.length(), str2 + contactInfoItem.getAccount(), null, null, strQ);
                if (TextUtils.isEmpty(remarkName)) {
                    SpannableString spannableStringG2 = il5.g(0, contactInfoItem.getNickName(), contactInfoItem.getAllPinyin(), contactInfoItem.getFirstPinyin(), strQ);
                    aVar.c.setVisibility(8);
                    if (spannableStringG2 != null) {
                        aVar.b.setText(spannableStringG2);
                    } else {
                        aVar.b.setText(contactInfoItem.getNickName());
                        if (spannableStringG != null) {
                            aVar.c.setText(spannableStringG);
                            aVar.c.setVisibility(0);
                        }
                    }
                } else {
                    SpannableString spannableStringG3 = il5.g(0, contactInfoItem.getRemarkName(), contactInfoItem.getRemarkAllPinyin(), contactInfoItem.getRemarkFirstPinyin(), strQ);
                    if (spannableStringG3 != null) {
                        aVar.b.setText(spannableStringG3);
                        aVar.c.setVisibility(8);
                    } else {
                        aVar.b.setText(remarkName);
                        String str3 = this.c.getString(R.string.nick_name) + "：";
                        SpannableString spannableStringG4 = il5.g(str3.length(), str3 + contactInfoItem.getNickName(), contactInfoItem.getAllPinyin(), contactInfoItem.getFirstPinyin(), strQ);
                        if (spannableStringG4 != null) {
                            aVar.c.setText(spannableStringG4);
                            aVar.c.setVisibility(0);
                        } else if (spannableStringG != null) {
                            aVar.c.setText(spannableStringG);
                            aVar.c.setVisibility(0);
                        } else {
                            aVar.c.setVisibility(8);
                        }
                    }
                }
                gr2.j().h(iconURL, aVar.f12381a, bq6.s());
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
            aVar.b.setText(chatName);
            int i2 = eVar.f12390a;
            if (i2 == 1) {
                aVar.c.setText(il5.h(str4, strQ));
            } else {
                aVar.c.setText(this.c.getString(R.string.search_item_message_count, Integer.valueOf(i2)));
            }
            aVar.c.setVisibility(0);
            gr2.j().h(groupHeadImgUrl, aVar.f12381a, bq6.s());
        } else if (obj instanceof GroupInfoItem) {
            GroupInfoItem groupInfoItem2 = (GroupInfoItem) obj;
            String groupName = groupInfoItem2.getGroupName();
            if (TextUtils.isEmpty(groupName)) {
                aVar.b.setText(groupInfoItem2.getGroupLocalName());
            } else {
                aVar.b.setText(il5.h(groupName, strQ));
            }
            if (TextUtils.isEmpty(groupName) || !il5.c(groupName, strQ)) {
                Map<String, ArrayList<GroupMemberInfoItem>> map = this.e;
                if (map != null) {
                    ArrayList<GroupMemberInfoItem> arrayList = map.get(groupInfoItem2.getGroupId());
                    if (arrayList != null) {
                        aVar.c.setVisibility(0);
                        aVar.c.setText(il5.f(arrayList, strQ));
                    } else {
                        aVar.c.setVisibility(8);
                    }
                }
            } else {
                aVar.c.setVisibility(8);
            }
            gr2.j().h(groupInfoItem2.getGroupHeadImgUrl(), aVar.f12381a, bq6.s());
        } else if (obj instanceof ThreadChatItem) {
            ThreadChatItem threadChatItem = (ThreadChatItem) obj;
            gr2.j().h(threadChatItem.iconUrl, aVar.f12381a, bq6.s());
            aVar.b.setText(threadChatItem.title);
            aVar.c.setVisibility(8);
        }
        return view;
    }
}
