package pickahu.openproject;

import android.app.Activity;
import android.widget.Toast;

/**
 * Created by Administrator on 2017/6/26.
 */

public class BaseActivity extends Activity {

    protected void showToast(String des){
        Toast.makeText(BaseActivity.this,des,Toast.LENGTH_SHORT).show();
    }
}
