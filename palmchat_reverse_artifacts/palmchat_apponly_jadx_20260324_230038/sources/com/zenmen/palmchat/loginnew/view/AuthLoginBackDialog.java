package com.zenmen.palmchat.loginnew.view;

import android.app.Activity;
import android.content.DialogInterface;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.widget.EffectiveShapeView;
import com.zenmen.palmchat.widget.LXBottomSheetDialog;
import defpackage.k86;
import defpackage.l50;
import defpackage.le1;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class AuthLoginBackDialog extends LXBottomSheetDialog {
    public d h;
    public Activity i;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (AuthLoginBackDialog.this.h != null) {
                AuthLoginBackDialog.this.h.b();
            }
            AuthLoginBackDialog.this.dismiss();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            if (AuthLoginBackDialog.this.h != null) {
                AuthLoginBackDialog.this.h.a();
            }
            AuthLoginBackDialog.this.dismiss();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements DialogInterface.OnCancelListener {
        public c() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            if (AuthLoginBackDialog.this.h != null) {
                AuthLoginBackDialog.this.h.onCancel();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface d {
        void a();

        void b();

        void onCancel();
    }

    public AuthLoginBackDialog(@NonNull Activity activity, d dVar) {
        super(activity);
        w(false);
        this.i = activity;
        this.h = dVar;
    }

    @Override // com.zenmen.palmchat.widget.LXBottomSheetDialog
    public View n() {
        View viewInflate = getLayoutInflater().inflate(R.layout.layout_dialog_auth_login_back, (ViewGroup) null);
        viewInflate.findViewById(R.id.btn_quit).setOnClickListener(new a());
        viewInflate.findViewById(R.id.btn_continue).setOnClickListener(new b());
        EffectiveShapeView effectiveShapeView = (EffectiveShapeView) viewInflate.findViewById(R.id.img_banner);
        int iZ = k86.z(this.i) - k86.e(this.i, 40.0f);
        int i = (iZ * 160) / MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_OPEN_RESULT;
        ViewGroup.LayoutParams layoutParams = effectiveShapeView.getLayoutParams();
        layoutParams.width = iZ;
        layoutParams.height = i;
        effectiveShapeView.setLayoutParams(layoutParams);
        t(le1.a(this.i, 205.0f) + i);
        setCanceledOnTouchOutside(false);
        setOnCancelListener(new c());
        return viewInflate;
    }
}
