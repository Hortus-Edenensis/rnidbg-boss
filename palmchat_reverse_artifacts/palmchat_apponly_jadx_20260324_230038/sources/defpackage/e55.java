package defpackage;

import android.app.Activity;
import android.content.ClipboardManager;
import android.view.View;
import android.view.animation.Animation;
import android.widget.TextView;
import com.bytedance.bpea.entry.common.DataType;
import com.zenmen.palmchat.c;
import com.zenmen.palmchat.friendcircle.R$id;
import com.zenmen.palmchat.friendcircle.R$layout;
import com.zenmen.palmchat.utils.log.LogUtil;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class e55 extends mr implements View.OnClickListener {
    public TextView A;
    public String B;
    public Long C;

    public e55(Activity activity) {
        super(activity, -2, -2);
        TextView textView = (TextView) p(R$id.copy);
        this.A = textView;
        K(this, textView);
    }

    public void Q(Long l) {
        this.C = l;
    }

    public void R(View view, String str, boolean z) {
        this.B = str;
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int iAbs = iArr[0] + Math.abs((view.getWidth() - w()) / 2);
        int iS = iArr[1] - (s() * 2);
        H(iAbs);
        I(iS);
        super.O(view, false);
    }

    @Override // defpackage.lr
    public View a() {
        return m(R$layout.popup_select_all);
    }

    @Override // defpackage.lr
    public View c() {
        return p(R$id.copy);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R$id.copy) {
            if (this.C != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("feed_id", this.C);
                    jSONObject.put("type", 2);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                LogUtil.uploadInfoImmediate("M33", "1", null, jSONObject.toString());
            }
            try {
                ((ClipboardManager) c.b().getSystemService(DataType.CLIPBOARD)).setText(this.B.trim());
                k36.a("已复制");
                n();
            } catch (SecurityException unused) {
            }
        }
    }

    @Override // defpackage.mr
    public View q() {
        return u();
    }

    @Override // defpackage.mr
    public Animation x() {
        return null;
    }

    @Override // defpackage.mr
    public Animation z() {
        return null;
    }
}
