package pickahu.openproject.ActivityShow;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.transition.Explode;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

import pickahu.openproject.R;

/**
 * Created by Administrator on 2017/7/30.
 */

public class ShowStyleActivity extends Activity implements View.OnClickListener {

    private ImageView mImageIcon;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        getWindow().setExitTransition( new Explode() );
        setContentView(R.layout.activity_show_style);

        findViewById(R.id.btn_makeCustomAnimation).setOnClickListener(this);
        findViewById(R.id.btn_makeScaleUpAnimation).setOnClickListener(this);
        findViewById(R.id.btn_makeSceneTransitionAnimation).setOnClickListener(this);

        mImageIcon = (ImageView) findViewById(R.id.image_icon);
        mImageIcon.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_makeCustomAnimation:

                startStyle1();
                break;
            case R.id.btn_makeScaleUpAnimation:
                startStyle2();
                break;
            case R.id.btn_makeSceneTransitionAnimation:
                startStyle3(mImageIcon);
                break;

            case R.id.image_icon:
                scaleUpAnimation(mImageIcon);
                break;
        }
    }

    private void startStyle1() {

        ActivityOptionsCompat options = ActivityOptionsCompat.makeCustomAnimation(this, R.anim.slide_in_bottom,
                R.anim.slide_out_bottom);
        Intent intent = new Intent(this, SecondActivity.class);
        ActivityCompat.startActivity(this,intent,options.toBundle());

    }

    private void startStyle2() {
        Intent intent = new Intent( this, SecondActivity.class );
        startActivity( intent );
    }

    private void scaleUpAnimation(View view) {
        //让新的Activity从一个小的范围扩大到全屏
        ActivityOptionsCompat options =
                ActivityOptionsCompat.makeScaleUpAnimation(view, //The View that the new activity is animating from
                        (int)view.getWidth()/2, (int)view.getHeight()/2, //拉伸开始的坐标
                        0, 0);//拉伸开始的区域大小，这里用（0，0）表示从无到全屏
        Intent intent = new Intent(this,SecondActivity.class);
        ActivityCompat.startActivity(this, intent, options.toBundle());
    }

    private void startStyle3(View view) {
        ActivityOptionsCompat compat =
                ActivityOptionsCompat.makeSceneTransitionAnimation(this,
                        view, "tran_image");
        Intent intent = new Intent(this,SecondActivity.class);
        ActivityCompat.startActivity(this,intent,compat.toBundle());

    }
}
