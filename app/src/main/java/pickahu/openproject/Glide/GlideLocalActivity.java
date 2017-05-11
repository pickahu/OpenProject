package pickahu.openproject.Glide;

import android.app.Activity;
import android.os.Bundle;
import android.widget.GridView;


import java.util.List;

import pickahu.openproject.R;
import pickahu.openproject.Glide.adapter.ImagesAdapter;
import pickahu.openproject.UniversalImageLoader.bean.Photo;
import pickahu.openproject.UniversalImageLoader.utils.DataUtils;

/**
 * Created by Administrator on 2017/4/18.
 */
public class GlideLocalActivity extends Activity {

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
        DataUtils dataUtils = new DataUtils(GlideLocalActivity.this);
        List<Photo> imagesPath = dataUtils.getImagesPath();
        ImagesAdapter adapter = new ImagesAdapter(imagesPath, GlideLocalActivity.this);
        mGridView.setAdapter(adapter);
    }
}
