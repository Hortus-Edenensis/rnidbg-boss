package defpackage;

import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class wn0 extends BaseAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<ContactInfoItem> f21756a;
    public HashMap<String, ContactInfoItem> b;
    public HashMap<String, ContactInfoItem> c;
    public Context d;
    public LayoutInflater e;
    public EditText g;
    public boolean f = false;
    public boolean h = false;

    public wn0(Context context, EditText editText) {
        this.d = context;
        this.e = LayoutInflater.from(context);
        this.g = editText;
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
        this.f21756a = list;
    }

    public void e(boolean z) {
        this.f = z;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<ContactInfoItem> list = this.f21756a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        List<ContactInfoItem> list = this.f21756a;
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
        String string = this.g.getText().toString();
        if (view == null) {
            view = this.e.inflate(R.layout.list_item_group_chat_init, (ViewGroup) null, false);
            xd2VarA = xd2.a(view);
            view.setTag(xd2VarA);
        } else {
            xd2VarA = (xd2) view.getTag();
        }
        String nameForShow = this.f21756a.get(i).getNameForShow();
        String remarkName = this.f21756a.get(i).getRemarkName();
        String iconURL = this.f21756a.get(i).getIconURL();
        ContactInfoItem contactInfoItem = this.f21756a.get(i);
        int iG = fg6.g(contactInfoItem.getExt());
        xd2VarA.c.setTextColor(fg6.n(this.d, iG));
        if (fg6.q(iG)) {
            xd2VarA.j.setVisibility(0);
            xd2VarA.j.setImageResource(fg6.c(iG));
        } else {
            xd2VarA.j.setVisibility(8);
        }
        if (TextUtils.isEmpty(nameForShow)) {
            xd2VarA.c.setText(this.f21756a.get(i).getMobile());
            xd2VarA.d.setVisibility(8);
        } else {
            String str = this.d.getString(R.string.settings_account) + "：";
            SpannableString spannableStringG = il5.g(str.length(), str + contactInfoItem.getAccount(), null, null, string);
            if (TextUtils.isEmpty(remarkName)) {
                SpannableString spannableStringG2 = il5.g(0, contactInfoItem.getNickName(), contactInfoItem.getAllPinyin(), contactInfoItem.getFirstPinyin(), string);
                xd2VarA.d.setVisibility(8);
                if (spannableStringG2 != null) {
                    xd2VarA.c.setText(spannableStringG2);
                } else {
                    xd2VarA.c.setText(contactInfoItem.getNickName());
                    if (spannableStringG != null) {
                        xd2VarA.d.setText(spannableStringG);
                        xd2VarA.d.setVisibility(0);
                    }
                }
            } else {
                SpannableString spannableStringG3 = il5.g(0, contactInfoItem.getRemarkName(), contactInfoItem.getRemarkAllPinyin(), contactInfoItem.getRemarkFirstPinyin(), string);
                if (spannableStringG3 != null) {
                    xd2VarA.c.setText(spannableStringG3);
                    xd2VarA.d.setVisibility(8);
                } else {
                    xd2VarA.c.setText(remarkName);
                    String str2 = this.d.getString(R.string.nick_name) + "：";
                    SpannableString spannableStringG4 = il5.g(str2.length(), str2 + contactInfoItem.getNickName(), contactInfoItem.getAllPinyin(), contactInfoItem.getFirstPinyin(), string);
                    if (spannableStringG4 != null) {
                        xd2VarA.d.setText(spannableStringG4);
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
        if (this.h) {
            xd2VarA.f.setVisibility(0);
        } else {
            xd2VarA.f.setVisibility(8);
        }
        gr2.j().h(iconURL, xd2VarA.f21933a, bq6.s());
        String uid = this.f21756a.get(i).getUid();
        HashMap<String, ContactInfoItem> map = this.b;
        if (map == null || map.get(uid) == null) {
            HashMap<String, ContactInfoItem> map2 = this.c;
            if (map2 != null) {
                if (map2.get(uid) != null) {
                    xd2VarA.f.setBackgroundResource(R.drawable.icon_green_check);
                } else {
                    xd2VarA.f.setBackgroundResource(R.drawable.icon_green_unchecked);
                }
            }
        } else {
            xd2VarA.f.setBackgroundResource(R.drawable.icon_gray_checked);
        }
        xd2VarA.i.setVisibility(0);
        if (!this.f) {
            ContactInfoItem contactInfoItem2 = (ContactInfoItem) getItem(i);
            if (contactInfoItem2 == null) {
                xd2VarA.h.setVisibility(0);
                xd2VarA.e.setVisibility(8);
                xd2VarA.i.setVisibility(8);
            } else {
                char cA = a(contactInfoItem2.getIndexPinyin(true).charAt(0));
                if (i != 0 && a(((ContactInfoItem) getItem(i - 1)).getIndexPinyin(true).charAt(0)) == cA) {
                    xd2VarA.e.setVisibility(8);
                    xd2VarA.i.setVisibility(8);
                } else {
                    xd2VarA.e.setVisibility(0);
                    xd2VarA.e.setText(Character.toString(cA));
                }
                if (i != getCount() - 1 && a(((ContactInfoItem) getItem(i + 1)).getIndexPinyin(true).charAt(0)) == cA) {
                    xd2VarA.h.setVisibility(0);
                } else {
                    xd2VarA.h.setVisibility(8);
                }
            }
        } else if (i == 0) {
            xd2VarA.h.setVisibility(0);
            xd2VarA.e.setText(R.string.title_contact);
            xd2VarA.e.setVisibility(0);
        } else {
            xd2VarA.h.setVisibility(0);
            xd2VarA.e.setVisibility(8);
            xd2VarA.i.setVisibility(8);
        }
        return view;
    }
}
