package pickahu.openproject.Gradle;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import jp.wasabeef.glide.transformations.GrayscaleTransformation;
import pickahu.openproject.R;


/**
 * Created by Administrator on 2017/4/18.
 */
public class GlideNetActivity extends Activity {


    private ImageView imageView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glide_net_image);
        initViews();
        initData();
    }

    private void initViews(){

        imageView = (ImageView) findViewById(R.id.glide_net_image);


    }

    private void initData(){

        Glide.with(this).load("http://image.hnol.net/c/2015-10/09/21/201510092139037971-1559530.jpg")
        .thumbnail(0.1f)   //用原图的1/10作为缩略图
        .bitmapTransform(new GrayscaleTransformation(this))//灰度处理
        .into(imageView);

    }
}
