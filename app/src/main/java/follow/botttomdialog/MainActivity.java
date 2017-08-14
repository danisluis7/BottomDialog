package follow.botttomdialog;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import follow.botttomdialog.bean.Item;
import follow.botttomdialog.custom.BottomDialog;

public class MainActivity extends AppCompatActivity {

    private TextView bottomDialog;
    private BottomDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.bottomdialog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog = new BottomDialog(MainActivity.this);
                dialog.title(R.string.app_name);
                dialog.canceledOnTouchOutside(true);
                dialog.cancelable(true);
                dialog.inflateMenu(R.menu.menu_main);
                dialog.setOnItemSelectedListener(new BottomDialog.OnItemSelectedListener() {
                    @Override
                    public boolean onItemSelected(int id) {
                        switch (id) {
                            case R.id.action_social_share:
                                Intent s = new Intent(android.content.Intent.ACTION_SEND);
                                s.setType("text/plain");
                                s.putExtra(android.content.Intent.EXTRA_TEXT, "https://github.com/rebus007/BottomDialog/issues");
                                startActivity(Intent.createChooser(s, getResources().getText(R.string.action_social_share)));
                                return true;
                            case R.id.action_content_add:
                                Item item = new Item();
                                item.setTitle("New element");
                                item.setIcon(getResources().getDrawable(R.drawable.ic_action_action_bug_report));
                                item.setId(100);
                                dialog.addItem(item);
                                return false;
                            case R.id.action_delete:
                                finish();
                                return true;
                            case R.id.action_bug_report:
                                Intent i = new Intent(Intent.ACTION_VIEW);
                                i.setData(Uri.parse("https://github.com/rebus007/BottomDialog/issues"));
                                startActivity(i);
                                return true;
                            case R.id.ic_github:
                                Intent g = new Intent(Intent.ACTION_VIEW);
                                g.setData(Uri.parse("https://github.com/rebus007/BottomDialog"));
                                startActivity(g);
                                return true;
                            case 100:
                                Toast.makeText(MainActivity.this, "New element clicked!!!", Toast.LENGTH_SHORT).show();
                                return false;
                            default:
                                return false;
                        }
                    }
                });
                dialog.show();
            }
        });
    }
}
