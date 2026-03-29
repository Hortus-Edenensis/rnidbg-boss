package defpackage;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.afollestad.materialdialogs.MaterialDialog;
import com.afollestad.materialdialogs.Theme;
import com.zenmen.palmchat.framework.R$color;
import com.zenmen.palmchat.framework.R$dimen;
import com.zenmen.palmchat.framework.R$id;
import com.zenmen.palmchat.framework.R$layout;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class sd5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public MaterialDialog f20719a;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements DialogInterface.OnCancelListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f20720a;

        public a(c cVar) {
            this.f20720a = cVar;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            this.f20720a.getClass();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements MaterialDialog.g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f20721a;

        public b(c cVar) {
            this.f20721a = cVar;
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.g
        public void a(MaterialDialog materialDialog, View view, int i, CharSequence charSequence) {
            materialDialog.cancel();
            e eVar = this.f20721a.d;
            if (eVar != null) {
                eVar.a(sd5.this, i, charSequence);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Context f20722a;
        public String[] b;
        public int[] c;
        public e d;

        public c(Context context) {
            this.f20722a = context;
        }

        public sd5 a() {
            return new sd5(this.f20722a, this);
        }

        public c b(int[] iArr) {
            this.c = iArr;
            return this;
        }

        public c c(String[] strArr) {
            this.b = strArr;
            return this;
        }

        public c d(e eVar) {
            this.d = eVar;
            return this;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d extends BaseAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Context f20723a;
        public String[] b;
        public int[] c;

        /* JADX INFO: compiled from: SearchBox */
        public final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public TextView f20724a;

            public a() {
            }
        }

        public d(Context context, String[] strArr, int[] iArr) {
            this.f20723a = context;
            this.b = strArr;
            this.c = iArr;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            String[] strArr = this.b;
            if (strArr != null) {
                return strArr.length;
            }
            return 0;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            String[] strArr = this.b;
            if (strArr == null || i < 0 || i >= strArr.length) {
                return null;
            }
            return strArr[i];
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            View viewInflate;
            a aVar;
            if (view == null) {
                aVar = new a();
                viewInflate = LayoutInflater.from(this.f20723a).inflate(R$layout.single_material_menu_item, (ViewGroup) null);
                aVar.f20724a = (TextView) viewInflate.findViewById(R$id.text);
                viewInflate.setTag(aVar);
            } else {
                viewInflate = view;
                aVar = (a) view.getTag();
            }
            aVar.f20724a.setText(this.b[i]);
            int[] iArr = this.c;
            aVar.f20724a.setCompoundDrawablesWithIntrinsicBounds((iArr == null || i >= iArr.length) ? 0 : iArr[i], 0, 0, 0);
            aVar.f20724a.setHeight(k86.e(this.f20723a, 48.0f));
            return viewInflate;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface e {
        void a(sd5 sd5Var, int i, CharSequence charSequence);
    }

    public sd5(Context context, c cVar) {
        this.f20719a = new MaterialDialog.d(context).S(Theme.LIGHT).F(cVar.b).d(R$color.white).E(R$color.black).a(new d(context, cVar.b, cVar.c), new b(cVar)).h(true).g(new a(cVar)).e();
        int[] iArr = cVar.c;
        if (iArr == null || iArr.length <= 0) {
            return;
        }
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R$dimen.material_single_icon_menu_list_padding);
        this.f20719a.m().setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
    }

    public void a() {
        this.f20719a.show();
    }
}
