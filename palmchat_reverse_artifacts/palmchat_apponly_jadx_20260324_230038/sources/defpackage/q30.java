package defpackage;

import android.view.View;
import android.widget.TextView;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.widget.SocialPortraitView;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class q30 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ArrayList<View> f20163a;
    public ArrayList<SocialPortraitView> b;
    public ArrayList<TextView> c;
    public ArrayList<View> d;

    public static q30 a(View view) {
        q30 q30Var = new q30();
        ArrayList<View> arrayList = new ArrayList<>();
        q30Var.f20163a = arrayList;
        arrayList.add(view.findViewById(R.id.container));
        q30Var.f20163a.add(view.findViewById(R.id.container2));
        q30Var.f20163a.add(view.findViewById(R.id.container3));
        q30Var.f20163a.add(view.findViewById(R.id.container4));
        q30Var.f20163a.add(view.findViewById(R.id.container5));
        ArrayList<SocialPortraitView> arrayList2 = new ArrayList<>();
        q30Var.b = arrayList2;
        arrayList2.add((SocialPortraitView) view.findViewById(R.id.portrait));
        q30Var.b.add((SocialPortraitView) view.findViewById(R.id.portrait2));
        q30Var.b.add((SocialPortraitView) view.findViewById(R.id.portrait3));
        q30Var.b.add((SocialPortraitView) view.findViewById(R.id.portrait4));
        q30Var.b.add((SocialPortraitView) view.findViewById(R.id.portrait5));
        ArrayList<TextView> arrayList3 = new ArrayList<>();
        q30Var.c = arrayList3;
        arrayList3.add((TextView) view.findViewById(R.id.member_nick_name));
        q30Var.c.add((TextView) view.findViewById(R.id.member_nick_name2));
        q30Var.c.add((TextView) view.findViewById(R.id.member_nick_name3));
        q30Var.c.add((TextView) view.findViewById(R.id.member_nick_name4));
        q30Var.c.add((TextView) view.findViewById(R.id.member_nick_name5));
        ArrayList<View> arrayList4 = new ArrayList<>();
        q30Var.d = arrayList4;
        arrayList4.add(view.findViewById(R.id.del_member_btn));
        q30Var.d.add(view.findViewById(R.id.del_member_btn2));
        q30Var.d.add(view.findViewById(R.id.del_member_btn3));
        q30Var.d.add(view.findViewById(R.id.del_member_btn4));
        q30Var.d.add(view.findViewById(R.id.del_member_btn5));
        return q30Var;
    }
}
