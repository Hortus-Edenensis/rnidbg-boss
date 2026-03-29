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
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class k70 extends BaseAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<ContactInfoItem> f18589a;
    public List<ContactInfoItem> b;
    public Context c;
    public LayoutInflater d;
    public EditText f;
    public boolean e = false;
    public boolean g = false;

    public k70(Context context, EditText editText) {
        this.c = context;
        this.d = LayoutInflater.from(context);
        this.f = editText;
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

    public final boolean b(String str) {
        if (this.b == null) {
            return false;
        }
        for (int i = 0; i < this.b.size(); i++) {
            if (this.b.get(i).getUid().equals(str)) {
                return true;
            }
        }
        return false;
    }

    public void c(List<ContactInfoItem> list) {
        this.f18589a = list;
    }

    public void e(boolean z) {
        this.e = z;
        notifyDataSetChanged();
    }

    public void f(List<ContactInfoItem> list) {
        this.b = list;
    }

    public void g(boolean z) {
        this.g = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<ContactInfoItem> list = this.f18589a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        List<ContactInfoItem> list = this.f18589a;
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
        String string = this.f.getText().toString();
        if (view == null) {
            view = this.d.inflate(R.layout.list_item_circle_member_init, (ViewGroup) null, false);
            xd2VarA = xd2.a(view);
            view.setTag(xd2VarA);
        } else {
            xd2VarA = (xd2) view.getTag();
        }
        String nameForShow = this.f18589a.get(i).getNameForShow();
        String remarkName = this.f18589a.get(i).getRemarkName();
        String iconURL = this.f18589a.get(i).getIconURL();
        ContactInfoItem contactInfoItem = this.f18589a.get(i);
        if (TextUtils.isEmpty(nameForShow)) {
            xd2VarA.c.setText(this.f18589a.get(i).getMobile());
            xd2VarA.d.setVisibility(8);
        } else {
            String str = this.c.getString(R.string.settings_account) + "：";
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
                    String str2 = this.c.getString(R.string.nick_name) + "：";
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
        if (this.g) {
            xd2VarA.f.setVisibility(0);
        } else {
            xd2VarA.f.setVisibility(8);
        }
        gr2.j().h(iconURL, xd2VarA.f21933a, bq6.s());
        if (b(this.f18589a.get(i).getUid())) {
            xd2VarA.f.setBackgroundResource(R.drawable.invite_friend_selected);
        } else {
            xd2VarA.f.setBackgroundResource(R.drawable.invite_friend_unselect);
        }
        if (!this.e) {
            ContactInfoItem contactInfoItem2 = (ContactInfoItem) getItem(i);
            if (contactInfoItem2 == null) {
                xd2VarA.h.setVisibility(0);
                xd2VarA.e.setVisibility(8);
            } else {
                char cA = a(contactInfoItem2.getIndexPinyin(true).charAt(0));
                if (i != 0 && a(((ContactInfoItem) getItem(i - 1)).getIndexPinyin(true).charAt(0)) == cA) {
                    xd2VarA.e.setVisibility(8);
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
        }
        return view;
    }
}
