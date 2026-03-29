package defpackage;

import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import com.zenmen.square.R$string;
import com.zenmen.square.comment.model.CommentViewModel;
import com.zenmen.square.comment.widget.RichTextView;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class si0 {
    public static boolean a(CharSequence charSequence) {
        if (charSequence != null && charSequence.length() > 0) {
            for (int i = 0; i < charSequence.length(); i++) {
                if (!Character.isWhitespace(charSequence.charAt(i))) {
                    return true;
                }
            }
        }
        return false;
    }

    public static String b(Context context) {
        String strB = vs0.a().b("square_comment_input_placeHolder");
        return TextUtils.isEmpty(strB) ? context.getString(R$string.square_comment_hint) : strB;
    }

    public static String c(Context context) {
        String strB = vs0.a().b("square_comment_empty_tip");
        return TextUtils.isEmpty(strB) ? context.getString(R$string.square_comment_list_empty) : strB;
    }

    public static boolean d() {
        return false;
    }

    public static boolean e(CommentViewModel commentViewModel) {
        return (commentViewModel == null || commentViewModel.getCommentReplyOperater() == null) ? false : true;
    }

    public static void f(Context context, RichTextView richTextView, int i) {
        SpannableString spannableString = new SpannableString(richTextView.getText().toString());
        spannableString.removeSpan(new v96(context, i));
        richTextView.setEmojiText(spannableString);
    }

    public static void g(Context context, RichTextView richTextView, int i, int i2) {
        SpannableString spannableString = new SpannableString(richTextView.getText().toString() + "    ");
        v96 v96Var = new v96(context, i);
        v96Var.a(i2);
        spannableString.setSpan(v96Var, r0.length() - 2, r0.length() - 1, 18);
        richTextView.setEmojiText(spannableString);
    }
}
