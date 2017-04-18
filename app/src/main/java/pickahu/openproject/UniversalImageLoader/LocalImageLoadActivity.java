package pickahu.openproject.UniversalImageLoader;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.GridView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.listener.PauseOnScrollListener;

import java.util.List;

import pickahu.openproject.R;
import pickahu.openproject.UniversalImageLoader.adapter.ImagesAdapter;
import pickahu.openproject.UniversalImageLoader.bean.Photo;
import pickahu.openproject.UniversalImageLoader.utils.DataUtils;

/**
 * Created by Administrator on 2017/4/18.
 */
public class LocalImageLoadActivity extends Activity {

    private GridView mGridView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_local_image);
        initViews();
        initData();
    }

    private void initViews(){
        mGridView = (GridView) findViewById(R.id.gv_image);

    }

    private void initData(){
        DataUtils dataUtils = new DataUtils(LocalImageLoadActivity.this);
        List<Photo> imagesPath = dataUtils.getImagesPath();
        ImagesAdapter adapter = new ImagesAdapter(imagesPath, LocalImageLoadActivity.this);

        mGridView.setOnScrollListener(new PauseOnScrollListener(ImageLoader.getInstance(),true,false));
        mGridView.setAdapter(adapter);
    }
}
