package defpackage;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.utils.log.LogUtil;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class u8 extends u10 {
    public ImageView r;
    public ImageView s;
    public TextView t;
    public TextView u;
    public TextView v;
    public ImageView w;
    public View x;

    public u8(View view) {
        super(view);
        LogUtil.d("AiChatPeopleManagerTag", "AiChatGuardViewHolder init start");
        this.x = view.findViewById(R.id.ai_msg_guard_layout);
        this.w = (ImageView) view.findViewById(R.id.avatar);
        this.r = (ImageView) view.findViewById(R.id.mine_avatar_img);
        this.s = (ImageView) view.findViewById(R.id.other_avatar_img);
        this.t = (TextView) view.findViewById(R.id.ai_name_title);
        this.u = (TextView) view.findViewById(R.id.ai_desc);
        this.v = (TextView) view.findViewById(R.id.ai_button);
    }

    @Override // defpackage.u10
    public boolean f() {
        return false;
    }
}
