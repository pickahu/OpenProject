package pickahu.openproject.ActivityShow;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.transition.Explode;
import android.view.Window;

import pickahu.openproject.R;

/**
 * Created by Administrator on 2017/7/30.
 */

public class SecondActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        getWindow().setEnterTransition( new Explode() );
        getWindow().setExitTransition( new Explode() );
        setContentView(R.layout.activity_show_style_second_activity);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finishAfterTransition();
    }
}
