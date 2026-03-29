package defpackage;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.circle.app.dragon.DragonConfirmItem;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class mg1 {

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c5 f19211a;
        public final /* synthetic */ DragonConfirmItem b;

        public a(c5 c5Var, DragonConfirmItem dragonConfirmItem) {
            this.f19211a = c5Var;
            this.b = dragonConfirmItem;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c5 c5Var = this.f19211a;
            if (c5Var != null) {
                c5Var.call(this.b);
            }
        }
    }

    public final void a(EditText editText) {
        editText.addTextChangedListener(new b(editText));
    }

    public EditText b(Context context, int i, LinearLayout linearLayout, DragonConfirmItem dragonConfirmItem, int i2, boolean z) {
        return c(context, i, linearLayout, dragonConfirmItem, i2, z, null);
    }

    public EditText c(Context context, int i, LinearLayout linearLayout, DragonConfirmItem dragonConfirmItem, int i2, boolean z, c5<DragonConfirmItem> c5Var) {
        String str;
        if (i == 1) {
            View viewInflate = LayoutInflater.from(context).inflate(R.layout.layout_circle_dragon_fellower, (ViewGroup) null);
            viewInflate.setTag(R.id.tag_data, dragonConfirmItem);
            linearLayout.addView(viewInflate);
            ((TextView) viewInflate.findViewById(R.id.circle_dragon_create_id)).setText((linearLayout.getChildCount() - 1) + ".");
            TextView textView = (TextView) viewInflate.findViewById(R.id.circle_dragon_create_nickname);
            if (dragonConfirmItem.uname.length() > 5) {
                str = dragonConfirmItem.uname.substring(0, 4) + "...";
            } else {
                str = dragonConfirmItem.uname;
            }
            textView.setText(str + ":");
            EditText editText = (EditText) viewInflate.findViewById(R.id.circle_dragon_create_publisher);
            editText.setText(dragonConfirmItem.content);
            editText.setEnabled(z);
            TextView textView2 = (TextView) viewInflate.findViewById(R.id.circle_dragon_create_publisher_tv);
            textView2.setText(dragonConfirmItem.content);
            editText.setVisibility(z ? 0 : 8);
            textView2.setVisibility(z ? 8 : 0);
            viewInflate.setOnClickListener(new a(c5Var, dragonConfirmItem));
            if (z) {
                return editText;
            }
            return null;
        }
        View viewInflate2 = LayoutInflater.from(context).inflate(R.layout.layout_circle_dragon_fellower_words, (ViewGroup) null);
        linearLayout.addView(viewInflate2);
        ((TextView) viewInflate2.findViewById(R.id.circle_dragon_create_id)).setText("" + i2 + ":");
        ((TextView) viewInflate2.findViewById(R.id.circle_dragon_create_nickname)).setText(dragonConfirmItem.uname + ":");
        ArrayList arrayList = new ArrayList();
        arrayList.add((TextView) viewInflate2.findViewById(R.id.circle_dragon_create_word1));
        arrayList.add((TextView) viewInflate2.findViewById(R.id.circle_dragon_create_word2));
        arrayList.add((TextView) viewInflate2.findViewById(R.id.circle_dragon_create_word3));
        arrayList.add((TextView) viewInflate2.findViewById(R.id.circle_dragon_create_word4));
        EditText editText2 = (EditText) viewInflate2.findViewById(R.id.circle_dragon_create_publisher);
        editText2.setText(dragonConfirmItem.content);
        editText2.setTag(arrayList);
        editText2.setEnabled(z);
        String str2 = dragonConfirmItem.content;
        if (str2 != null && !str2.isEmpty()) {
            String strSubstring = dragonConfirmItem.content.length() > 4 ? dragonConfirmItem.content.substring(0, 4) : dragonConfirmItem.content;
            while (i < strSubstring.length()) {
                int i3 = i + 1;
                ((TextView) arrayList.get(i)).setText(dragonConfirmItem.content.substring(i, i3));
                i = i3;
            }
        }
        a(editText2);
        if (z) {
            return editText2;
        }
        return null;
    }

    public void d(LinearLayout linearLayout) {
        if (linearLayout == null || linearLayout.getChildCount() <= 0) {
            return;
        }
        int i = 0;
        while (i < linearLayout.getChildCount()) {
            TextView textView = (TextView) linearLayout.getChildAt(i).findViewById(R.id.circle_dragon_create_id);
            StringBuilder sb = new StringBuilder();
            i++;
            sb.append(i);
            sb.append(":");
            textView.setText(sb.toString());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements TextWatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ EditText f19212a;

        public b(EditText editText) {
            this.f19212a = editText;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            String string = editable.toString();
            if (string == null) {
                string = "";
            }
            int i = 0;
            if (string.length() > 4) {
                string = string.substring(0, 4);
            }
            ArrayList arrayList = (ArrayList) this.f19212a.getTag();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((TextView) it.next()).setText("");
            }
            while (i < string.length()) {
                int i2 = i + 1;
                ((TextView) arrayList.get(i)).setText(string.substring(i, i2));
                i = i2;
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }
}
