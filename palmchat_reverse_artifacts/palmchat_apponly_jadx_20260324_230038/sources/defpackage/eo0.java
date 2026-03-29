package defpackage;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.Vo.PhoneContactItem;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.contacts.d;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class eo0 extends BaseAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<ContactInfoItem> f17322a;
    public List<ContactInfoItem> b;
    public Context c;
    public LayoutInflater d;

    public eo0(Context context) {
        this.c = context;
        this.d = LayoutInflater.from(context);
    }

    public static char a(char c) {
        if (c == 8593) {
            return c;
        }
        if (c > 'Z' || c < 'A') {
            return '#';
        }
        return c;
    }

    public final String b(int i) {
        return i < 100 ? String.valueOf(i) : "...";
    }

    @Deprecated
    public void c(List<ContactInfoItem> list) {
        this.b = list;
    }

    public void e(List<ContactInfoItem> list) {
        this.f17322a = list;
    }

    public final void f(ContactInfoItem contactInfoItem, char c, mn0 mn0Var) {
        if (contactInfoItem.showAsSpecialAttention()) {
            mn0Var.h.setVisibility(8);
            mn0Var.i.setVisibility(0);
        } else {
            mn0Var.h.setText(Character.toString(c));
            mn0Var.h.setVisibility(0);
            mn0Var.i.setVisibility(8);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<ContactInfoItem> list = this.f17322a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        List<ContactInfoItem> list = this.f17322a;
        if (list == null) {
            return null;
        }
        return list.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return (i == 0 || i == 1) ? 2 : 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x011a  */
    @Override // android.widget.Adapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public View getView(int i, View view, ViewGroup viewGroup) {
        mn0 mn0VarA;
        int i2;
        ImageView imageView;
        if (view == null) {
            view = getItemViewType(i) != 1 ? this.d.inflate(R.layout.list_item_contacts, (ViewGroup) null, false) : this.d.inflate(R.layout.list_item_new_friend_request, (ViewGroup) null, false);
            mn0VarA = mn0.a(view);
            view.setTag(mn0VarA);
        } else {
            mn0VarA = (mn0) view.getTag();
        }
        if (getItemViewType(i) == 1) {
            mn0VarA.c.setText(String.valueOf(b(tn0.i().q())));
            if (this.b.size() == 1) {
                mn0VarA.l.setVisibility(0);
                mn0VarA.m.setVisibility(8);
                ContactInfoItem contactInfoItem = this.b.get(0);
                String nickName = contactInfoItem.getNickName();
                int requestType = contactInfoItem.getRequestType();
                if (requestType < 200 && requestType >= 100) {
                    PhoneContactItem phoneContactItem = d.j().m().get(contactInfoItem.getIdentifyCode());
                    if (phoneContactItem != null && !TextUtils.isEmpty(phoneContactItem.m())) {
                        nickName = nickName + " (" + phoneContactItem.m() + ")";
                    }
                }
                mn0VarA.b.setVisibility(8);
                mn0VarA.d.setText(nickName);
                if (TextUtils.isEmpty(contactInfoItem.getDescription())) {
                    int sourceType = contactInfoItem.getSourceType();
                    if (sourceType == 2) {
                        mn0VarA.g.setText(R.string.notification_add_contact_request_group);
                    } else if (sourceType == 3) {
                        mn0VarA.g.setText(R.string.notification_add_contact_request_contact);
                    } else if (sourceType == 7) {
                        mn0VarA.g.setText(R.string.notification_add_contact_request_auto);
                    } else if (sourceType == 10) {
                        mn0VarA.g.setText(R.string.notification_add_contact_request_active);
                    } else if (sourceType != 20) {
                        if (sourceType == 22) {
                            mn0VarA.g.setText(R.string.notification_add_contact_request_sec);
                        } else if (sourceType != 17) {
                            if (sourceType != 18) {
                                mn0VarA.g.setText(R.string.notification_add_contact_request_content_new);
                            } else {
                                mn0VarA.g.setText(R.string.notification_add_contact_request_accurate);
                            }
                        }
                    }
                } else {
                    mn0VarA.g.setText(contactInfoItem.getDescription());
                }
                mn0VarA.f19276a.setAvatarView(contactInfoItem.getIconURL(), contactInfoItem.getAmulet());
            } else {
                mn0VarA.l.setVisibility(8);
                mn0VarA.m.setVisibility(0);
                int childCount = mn0VarA.m.getChildCount();
                int i3 = 0;
                while (i3 < this.b.size()) {
                    ContactInfoItem contactInfoItem2 = this.b.get(i3);
                    if (i3 >= childCount) {
                        this.d.inflate(R.layout.portrait_item, mn0VarA.m);
                        i2 = childCount + 1;
                        imageView = (ImageView) mn0VarA.m.getChildAt(childCount);
                    } else {
                        ImageView imageView2 = (ImageView) mn0VarA.m.getChildAt(i3);
                        imageView2.setVisibility(0);
                        i2 = childCount;
                        imageView = imageView2;
                    }
                    if (TextUtils.isEmpty(contactInfoItem2.getIconURL())) {
                        imageView.setImageResource(R.drawable.default_portrait);
                    } else {
                        gr2.j().h(contactInfoItem2.getIconURL(), imageView, bq6.s());
                    }
                    i3++;
                    childCount = i2;
                }
                if (childCount > this.b.size()) {
                    for (int size = this.b.size(); size < childCount - 1; size++) {
                        mn0VarA.m.getChildAt(size).setVisibility(8);
                    }
                }
            }
        } else {
            ContactInfoItem contactInfoItem3 = (ContactInfoItem) getItem(i);
            String nameForShow = this.f17322a.get(i).getNameForShow();
            String iconURL = this.f17322a.get(i).getIconURL();
            if (TextUtils.isEmpty(nameForShow)) {
                mn0VarA.d.setText(this.f17322a.get(i).getMobile());
            } else {
                mn0VarA.d.setText(nameForShow);
            }
            if (i == 0 || i == 1) {
                mn0VarA.d.setTextColor(this.c.getResources().getColor(R.color.text_color_black));
            } else {
                mn0VarA.d.setTextColor(this.c.getResources().getColor(R.color.text_color_black2));
            }
            if (mn0VarA.e != null) {
                if (contactInfoItem3 == null || !contactInfoItem3.isOfficialAccount()) {
                    mn0VarA.e.setVisibility(8);
                } else {
                    mn0VarA.e.setVisibility(0);
                }
            }
            ImageView imageView3 = mn0VarA.f;
            if (imageView3 != null) {
                if (contactInfoItem3 != null) {
                    int iG = fg6.g(contactInfoItem3.getExt());
                    if (fg6.q(iG)) {
                        mn0VarA.f.setImageResource(fg6.c(iG));
                        mn0VarA.f.setVisibility(0);
                    } else {
                        mn0VarA.f.setVisibility(8);
                    }
                } else {
                    imageView3.setVisibility(8);
                }
            }
            if (mn0VarA.n != null) {
                if (contactInfoItem3 == null || a65.e(contactInfoItem3) || contactInfoItem3.isSelf() || !gu2.f() || contactInfoItem3.getIntimacyScore() < gu2.a().msglist_value) {
                    mn0VarA.n.setVisibility(8);
                } else {
                    mn0VarA.n.setVisibility(0);
                    mn0VarA.n.setText(gu2.b(contactInfoItem3.getIntimacyScore(), true));
                }
            }
            if (contactInfoItem3 != null) {
                if (contactInfoItem3.isOfficialAccount()) {
                    mn0VarA.d.setTextColor(this.c.getResources().getColor(R.color.Gg));
                } else {
                    mn0VarA.d.setTextColor(fg6.n(this.c, fg6.g(contactInfoItem3.getExt())));
                }
            }
            mn0VarA.f19276a.setAvatarView(iconURL, contactInfoItem3.getAmulet());
            char cA = a(contactInfoItem3.getIndexPinyin(true).charAt(0));
            if (contactInfoItem3.showAsSpecialAttention()) {
                cA = 8593;
            }
            if (i == 0) {
                mn0VarA.j.setVisibility(0);
                f(contactInfoItem3, cA, mn0VarA);
            } else {
                ContactInfoItem contactInfoItem4 = (ContactInfoItem) getItem(i - 1);
                if ((contactInfoItem4.showAsSpecialAttention() ? (char) 8593 : a(contactInfoItem4.getIndexPinyin(true).charAt(0))) == cA) {
                    mn0VarA.j.setVisibility(8);
                } else {
                    mn0VarA.j.setVisibility(0);
                    f(contactInfoItem3, cA, mn0VarA);
                }
            }
            if (i == getCount() - 1 || a(((ContactInfoItem) getItem(i + 1)).getIndexPinyin(true).charAt(0)) != cA) {
                mn0VarA.k.setVisibility(8);
            }
        }
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 3;
    }
}
