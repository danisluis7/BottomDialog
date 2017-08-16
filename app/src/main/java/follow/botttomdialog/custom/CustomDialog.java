package follow.botttomdialog.custom;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;

/**
 * Created by vuongluis on 8/15/2017.
 */

public class CustomDialog extends Dialog implements View.OnClickListener{

    /**
     * TAG
     * @param context
     * <> <> <>
     */
    private final String TAG = CustomDialog.class.getSimpleName();

    /**
     *
     * @param context
     * Yes there is a huge difference. I have never used SimpleName for (in) logger instance as it strips down(ignore) package name.
     * Apart from having problems when same class name exists in two difference packages. So lead to both classes getting the same
     * logger instance.
     * => Maybe you lost the ability to control logger inheritance.
     * => For example:
     * + Name => follow.bottomdialog.custom.CustomDialog
     * + SimpleName => CustomDialog
     */
    private final String otherTAG = CustomDialog.class.getName();

    /**
     *
     */
    private int padding;

    /**
     * Let me help you to distinguish the meaning of the padding and margin. It 's major problem for all people when is the first time, they
     * come to android developer. Let get to explore now!
     * You need to imagine. If you have a big coat. A lot of thick cotton padding.
     *
     * How about margin?
     * For example: "Hey, give me some margin!". It's empty space between me and you.
     *
     * To make it more clear
     * @param context
     *
     * => Applying
     * padding = getContext().getResources().getDimensionPixelSize(R.dimen.dimen_8_dp);
     */
    private int margin;

    /**
     *
     * @param context
     */
    private int icon;

    /**
     * Increase the dimension of icon
     * Sometime, we will use icon as abbreviation of dimension of icon
     * => Applying
     * icon = getContext().getResources().getDimensionPixelSize(R.dimen.dimen_32_dp);
     */
    private int dimen_icon;

    /**
     * NEW TECHNICAL <> <> <>
     * => Using for fragment: View = inflater.inflate(R.layout.article_view, container, false);
     * => Apply this now:
     * ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
     * container = new LinearLayout(getContext());
     * container.setLayoutParams(params);
     * container.setBackgroundColor(Color.WHITE);
     * container.setOrientation(LinearLayout.VERTICAL);
     * container.setPadding(0, padding, 0, padding);
     * container.
     */
    private LinearLayout container;

    /**
     * After declare interface internal and declare method to be used this interface
     * => Event is transferred
     * @param context
     */
    private OnItemSelectedListener onItemSelectedListener;



    public CustomDialog(@NonNull Context context) {
        super(context);
    }

    /**
     * Interface external
     * @param view
     */
    @Override
    public void onClick(View view) {

    }

    /**
     * Interface internal
     */
    public interface OnItemSelectedListener {
        boolean onItemSelected(int id);
    }
}
