package defpackage;

import android.content.Context;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.Vo.PhoneContactVo;
import com.zenmen.palmchat.widget.SocialPortraitView;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class e45 extends BaseAdapter {
    public LayoutInflater b;
    public Context c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<PhoneContactVo> f17212a = new ArrayList();
    public String d = null;

    /* JADX INFO: compiled from: SearchBox */
    public class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public SocialPortraitView f17213a;
        public TextView b;
        public TextView c;

        public a() {
        }
    }

    public e45(Context context) {
        this.c = context;
        this.b = LayoutInflater.from(context);
    }

    public void a(String str) {
        this.d = str;
    }

    public void b(ArrayList<PhoneContactVo> arrayList) {
        this.f17212a.clear();
        if (arrayList != null) {
            this.f17212a.addAll(arrayList);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f17212a.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.f17212a.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = this.b.inflate(R.layout.list_item_search_user, (ViewGroup) null);
            aVar = new a();
            aVar.f17213a = (SocialPortraitView) view.findViewById(R.id.portrait);
            aVar.b = (TextView) view.findViewById(R.id.nick_name);
            aVar.c = (TextView) view.findViewById(R.id.recommend);
            aVar.f17213a.changeShapeType(3);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        PhoneContactVo phoneContactVo = this.f17212a.get(i);
        String iconURL = phoneContactVo.getIconURL();
        if (TextUtils.isEmpty(iconURL)) {
            gr2.j().c(aVar.f17213a);
            aVar.f17213a.setImageResource(R.drawable.default_portrait);
        } else {
            gr2.j().h(iconURL, aVar.f17213a, bq6.s());
        }
        aVar.b.setText(phoneContactVo.getLocalName());
        StringBuilder sb = new StringBuilder();
        sb.append("手机号：");
        sb.append(phoneContactVo.getLocalPhone() != null ? phoneContactVo.getLocalPhone().replaceAll("-", "").replaceAll(" ", "") : "");
        SpannableString spannableString = new SpannableString(sb.toString());
        if (!TextUtils.isEmpty(this.d)) {
            Matcher matcher = Pattern.compile(this.d).matcher(spannableString);
            while (matcher.find()) {
                spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#00ac9a")), matcher.start(), matcher.end(), 33);
            }
        }
        aVar.c.setText(spannableString);
        return view;
    }
}
