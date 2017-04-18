package pickahu.openproject.UniversalImageLoader;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.ImageSize;

import pickahu.openproject.R;

/**
 * Created by Administrator on 2017/4/18.
 */
public class NetImageLoadActivity extends Activity {
    private ImageView mImageView;
    private String imageUrl = "https://lh6.googleusercontent.com/-55osAWw3x0Q/URquUtcFr5I/AAAAAAAAAbs/rWlj1RUKrYI/s1024/A%252520Photographer.jpg";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net_image);
        initView();
        initData();

    }

    private void initView(){

        mImageView = (ImageView) findViewById(R.id.image);
    }

    private void initData(){

        ImageSize mImageSize = new ImageSize(100, 100);

        //显示图片的配置
        DisplayImageOptions options = new DisplayImageOptions.Builder()
                .cacheInMemory(true)
                .showImageOnLoading(R.drawable.image_default)
                .showImageOnFail(R.drawable.image_err)
                .cacheOnDisk(true)
                .bitmapConfig(Bitmap.Config.RGB_565)
                .build();
//        ImageLoader.getInstance().loadImage(imageUrl, mImageSize, options, new SimpleImageLoadingListener(){
//
//            @Override
//            public void onLoadingComplete(String imageUri, View view,
//                                          Bitmap loadedImage) {
//                super.onLoadingComplete(imageUri, view, loadedImage);
//                mImageView.setImageBitmap(loadedImage);
//            }
//
//        });
        ImageLoader.getInstance().displayImage(imageUrl, mImageView, options);

    }

}
