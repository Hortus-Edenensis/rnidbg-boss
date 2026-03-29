package defpackage;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.chat.ChatItem;
import com.zenmen.palmchat.circle.ui.CircleRedPacketHistoryActivity;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class rc0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f20436a;
    public final View b;
    public ChatItem c;

    public rc0(final View view) {
        View viewFindViewById = view.findViewById(R.id.fl_circle_voucher_list_block);
        this.f20436a = viewFindViewById;
        this.b = view.findViewById(R.id.ic_circle_voucher_list_dot);
        viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: qc0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f20223a.b(view, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(View view, View view2) {
        Context context = view.getContext();
        if (context == null || this.c == null) {
            return;
        }
        context.startActivity(new Intent(context, (Class<?>) CircleRedPacketHistoryActivity.class).putExtra("intent_group_info", this.c));
    }

    public void c(ChatItem chatItem) {
        this.c = chatItem;
    }

    public void d(int i) {
        this.b.setVisibility(i);
    }

    public void e(boolean z) {
        this.f20436a.setVisibility(z ? 0 : 8);
    }
}
