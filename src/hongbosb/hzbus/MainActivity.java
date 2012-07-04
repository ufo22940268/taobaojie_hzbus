package hongbosb.hzbus;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.util.Log;
import android.widget.Toast;
import android.widget.EditText;
import android.webkit.WebView;
import android.content.Intent;

public class MainActivity extends Activity implements View.OnClickListener
{
    static public final String TAG = "MainActivity";
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Button btn = (Button)findViewById(R.id.ok);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = getBusId();
        if (id == -1) {
            return; 
        } else {
            String url = composeUrl(id);
            //debug
            Log.d(TAG, "-----------------------------" + url + "-----------------------------" );
            Intent intent = new Intent();
            intent.setClass(this, WebActivity.class);
            startActivity(intent);
        }
    }

    private int getBusId() {
        String input = ((EditText)findViewById(R.id.bus_line)).getText().toString();
        if (Character.isLetter(input.charAt(0))) {
            input = input.substring(1);
        }

        try {
            int busId = Integer.parseInt(input);
            busId += 34;
            return busId;
        } catch (Exception e) {
            e.printStackTrace();

            Toast.makeText(this, "Malformed bus line", Toast.LENGTH_SHORT).show();
        }

        return -1;
    }

    private String composeUrl(int id) {
        return "http://wap.busditu.com/linedetails.aspx?lineid=" + id;
    }
}
