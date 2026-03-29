package defpackage;

import android.text.SpannableString;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.groupchat.GroupChatInitActivity;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class wd2 extends BaseAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<ContactInfoItem> f21678a;
    public List<String> b;
    public HashMap<String, ContactInfoItem> c;
    public GroupChatInitActivity d;
    public ListView e;
    public LayoutInflater f;
    public boolean g = false;
    public EditText h;
    public int i;

    public wd2(GroupChatInitActivity groupChatInitActivity, ListView listView, EditText editText) {
        this.d = groupChatInitActivity;
        this.f = LayoutInflater.from(groupChatInitActivity);
        this.e = listView;
        this.h = editText;
    }

    public static char a(char c) {
        if (c == '?') {
            return c;
        }
        if (c > 'Z' || c < 'A') {
            return '#';
        }
        return c;
    }

    public void b(HashMap<String, ContactInfoItem> map) {
        this.c = map;
    }

    public void c(List<ContactInfoItem> list) {
        this.f21678a = list;
    }

    public void e(int i) {
        this.i = i;
    }

    public void f(List<String> list) {
        this.b = list;
    }

    public void g(boolean z) {
        this.g = z;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<ContactInfoItem> list = this.f21678a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        List<ContactInfoItem> list = this.f21678a;
        if (list == null) {
            return null;
        }
        return list.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        xd2 xd2VarA;
        View viewInflate;
        int i2;
        ContactInfoItem contactInfoItem;
        int i3;
        int i4;
        String string = this.h.getText().toString();
        if (view == null) {
            viewInflate = this.f.inflate(R.layout.list_item_group_chat_init, (ViewGroup) null, false);
            xd2VarA = xd2.a(viewInflate);
            viewInflate.setTag(xd2VarA);
        } else {
            xd2VarA = (xd2) view.getTag();
            viewInflate = view;
        }
        xd2VarA.f21933a.changeShapeType(3);
        String nameForShow = this.f21678a.get(i).getNameForShow();
        String remarkName = this.f21678a.get(i).getRemarkName();
        String mobile = this.f21678a.get(i).getMobile();
        String iconURL = this.f21678a.get(i).getIconURL();
        ContactInfoItem contactInfoItem2 = this.f21678a.get(i);
        int iG = fg6.g(contactInfoItem2.getExt());
        xd2VarA.c.setTextColor(fg6.n(this.d, iG));
        if (fg6.q(iG)) {
            xd2VarA.j.setVisibility(0);
            xd2VarA.j.setImageResource(fg6.c(iG));
        } else {
            xd2VarA.j.setVisibility(8);
        }
        if (TextUtils.isEmpty(nameForShow)) {
            xd2VarA.c.setText(mobile);
            xd2VarA.d.setVisibility(8);
        } else {
            String str = this.d.getString(R.string.settings_account) + "：";
            SpannableString spannableStringG = il5.g(str.length(), str + contactInfoItem2.getAccount(), null, null, string);
            if (TextUtils.isEmpty(remarkName)) {
                SpannableString spannableStringG2 = il5.g(0, contactInfoItem2.getNickName(), contactInfoItem2.getAllPinyin(), contactInfoItem2.getFirstPinyin(), string);
                xd2VarA.d.setVisibility(8);
                if (spannableStringG2 != null) {
                    xd2VarA.c.setText(spannableStringG2);
                } else {
                    xd2VarA.c.setText(contactInfoItem2.getNickName());
                    if (spannableStringG != null) {
                        xd2VarA.d.setText(spannableStringG);
                        xd2VarA.d.setVisibility(0);
                    }
                }
                if ("phone contact".equals(iconURL)) {
                    SpannableString spannableStringG3 = il5.g(0, contactInfoItem2.getMobile(), null, null, string);
                    if (spannableStringG3 != null) {
                        xd2VarA.d.setText(spannableStringG3);
                    } else {
                        xd2VarA.d.setText(contactInfoItem2.getMobile());
                    }
                    xd2VarA.d.setVisibility(0);
                }
            } else {
                SpannableString spannableStringG4 = il5.g(0, contactInfoItem2.getRemarkName(), contactInfoItem2.getRemarkAllPinyin(), contactInfoItem2.getRemarkFirstPinyin(), string);
                if (spannableStringG4 != null) {
                    xd2VarA.c.setText(spannableStringG4);
                    xd2VarA.d.setVisibility(8);
                } else {
                    xd2VarA.c.setText(remarkName);
                    String str2 = this.d.getString(R.string.nick_name) + "：";
                    SpannableString spannableStringG5 = il5.g(str2.length(), str2 + contactInfoItem2.getNickName(), contactInfoItem2.getAllPinyin(), contactInfoItem2.getFirstPinyin(), string);
                    if (spannableStringG5 != null) {
                        xd2VarA.d.setText(spannableStringG5);
                        xd2VarA.d.setVisibility(0);
                    } else if (spannableStringG != null) {
                        xd2VarA.d.setText(spannableStringG);
                        xd2VarA.d.setVisibility(0);
                    } else {
                        xd2VarA.d.setVisibility(8);
                    }
                }
            }
        }
        xd2VarA.f21933a.setVisibility(0);
        xd2VarA.f.setVisibility(0);
        if (!TextUtils.isEmpty(iconURL)) {
            if ("phone contact".equals(iconURL)) {
                xd2VarA.f21933a.setVisibility(8);
                xd2VarA.b.setVisibility(0);
                if (!TextUtils.isEmpty(contactInfoItem2.getNickName()) && contactInfoItem2.getNickName().trim().length() > 0) {
                    xd2VarA.b.setText(contactInfoItem2.getNickName().trim().substring(0, 1));
                }
                i2 = 8;
            } else {
                xd2VarA.f21933a.setVisibility(0);
                i2 = 8;
                xd2VarA.b.setVisibility(8);
                gr2.j().h(iconURL, xd2VarA.f21933a, bq6.s());
            }
            xd2VarA.g.setVisibility(i2);
        } else if (!TextUtils.isEmpty(mobile) && (mobile.equals(this.d.getString(R.string.group_chat_choose_group)) || mobile.equals(this.d.getString(R.string.group_upgrade_to_circle)))) {
            if (mobile.equals(this.d.getString(R.string.group_chat_choose_group))) {
                xd2VarA.f21933a.setVisibility(0);
                xd2VarA.f21933a.setImageResource(R.drawable.icon_circle_chat);
                xd2VarA.g.setVisibility(0);
                i4 = 8;
            } else {
                i4 = 8;
                xd2VarA.f21933a.setVisibility(8);
            }
            xd2VarA.f.setVisibility(i4);
        } else if (!TextUtils.isEmpty(mobile) && mobile.equals(this.d.getString(R.string.group_chat_init_face_to_face))) {
            xd2VarA.f21933a.setVisibility(8);
            xd2VarA.f.setVisibility(8);
        } else if ("all of person" == contactInfoItem2.getExid() && contactInfoItem2.getUid() == "-1") {
            xd2VarA.f21933a.setImageResource(R.drawable.circle_icon_all);
            xd2VarA.f.setVisibility(8);
        } else {
            xd2VarA.f21933a.setImageResource(R.drawable.default_portrait);
        }
        String uid = this.f21678a.get(i).getUid();
        String strP = AccountUtils.p(AppContext.getContext());
        List<String> list = this.b;
        if (list == null || !(list.contains(uid) || strP == null || strP.equals(uid))) {
            HashMap<String, ContactInfoItem> map = this.c;
            if (map != null) {
                if (map.get(uid) != null) {
                    xd2VarA.f.setBackgroundResource(R.drawable.invite_friend_selected);
                } else {
                    xd2VarA.f.setBackgroundResource(R.drawable.invite_friend_unselect);
                }
            }
        } else {
            xd2VarA.f.setBackgroundResource(R.drawable.ic_checkbox_gray_check);
        }
        if (this.g || (contactInfoItem = (ContactInfoItem) getItem(i)) == null) {
            xd2VarA.i.setVisibility(8);
        } else if (!TextUtils.isEmpty(mobile) && mobile.equals(this.d.getString(R.string.group_chat_choose_group)) && TextUtils.isEmpty(iconURL)) {
            xd2VarA.i.setVisibility(8);
        } else {
            char cA = a(contactInfoItem.getIndexPinyin(true).charAt(0));
            if (i == 0) {
                List<String> list2 = this.b;
                if ((list2 != null && list2.size() > 0) || (i3 = this.i) == 9 || i3 == 10) {
                    xd2VarA.i.setVisibility(0);
                    xd2VarA.e.setText(Character.toString(cA));
                } else {
                    xd2VarA.i.setVisibility(8);
                }
            } else if (a(((ContactInfoItem) getItem(i - 1)).getIndexPinyin(true).charAt(0)) == cA) {
                xd2VarA.i.setVisibility(8);
            } else {
                xd2VarA.i.setVisibility(0);
                xd2VarA.e.setText(Character.toString(cA));
            }
            if (i == getCount() - 1 || a(((ContactInfoItem) getItem(i + 1)).getIndexPinyin(true).charAt(0)) != cA) {
                xd2VarA.h.setVisibility(8);
            }
        }
        return viewInflate;
    }
}
