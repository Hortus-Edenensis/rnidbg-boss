package com.zenmen.palmchat.chat.gift;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import com.zenmen.palmchat.R;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class FirstSendGiftMessageSuccessDialog extends DialogFragment {

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FirstSendGiftMessageSuccessDialog.this.dismiss();
        }
    }

    public static FirstSendGiftMessageSuccessDialog D() {
        Bundle bundle = new Bundle();
        FirstSendGiftMessageSuccessDialog firstSendGiftMessageSuccessDialog = new FirstSendGiftMessageSuccessDialog();
        firstSendGiftMessageSuccessDialog.setArguments(bundle);
        return firstSendGiftMessageSuccessDialog;
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.dialog_first_send_gift_message_success, viewGroup, false);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        try {
            super.onStart();
            Window window = getDialog().getWindow();
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.gravity = 80;
            attributes.width = -1;
            attributes.height = -2;
            attributes.dimAmount = 0.7f;
            window.setAttributes(attributes);
            window.setBackgroundDrawable(new ColorDrawable(0));
            window.setWindowAnimations(R.style.DialogOutAndInStyle);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        ((TextView) view.findViewById(R.id.tv_gift_tips)).setText(GiftMessageHelper.M());
        view.findViewById(R.id.tv_i_known).setOnClickListener(new a());
    }
}
