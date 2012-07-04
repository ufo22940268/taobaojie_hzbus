package hongbosb.hzbus;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

public class WebActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.web);


        WebView wv = (WebView)findViewById(R.id.wv1);
        wv.loadUrl("http://wap.busditu.com/linedetails.aspx?lineid=42");
    }
    
}
