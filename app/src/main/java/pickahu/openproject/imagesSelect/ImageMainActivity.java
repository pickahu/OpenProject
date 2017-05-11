package pickahu.openproject.imagesSelect;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.List;

import cn.finalteam.galleryfinal.FunctionConfig;
import cn.finalteam.galleryfinal.GalleryFinal;
import cn.finalteam.galleryfinal.model.PhotoInfo;
import pickahu.openproject.R;

/**
 * Created by Administrator on 2017/5/11.
 */
public class ImageMainActivity extends Activity {

    private final int REQUEST_CODE_GALLERY = 1001;

    FunctionConfig.Builder functionConfigBuilder = new FunctionConfig.Builder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_main);

        functionConfigBuilder.setMutiSelectMaxSize(10);
        final FunctionConfig functionConfig = functionConfigBuilder.build();


        findViewById(R.id.btn_open_select).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                GalleryFinal.openGalleryMuti(REQUEST_CODE_GALLERY, functionConfig, mOnHanlderResultCallback);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

    }

    private GalleryFinal.OnHanlderResultCallback mOnHanlderResultCallback = new GalleryFinal.OnHanlderResultCallback() {
        @Override
        public void onHanlderSuccess(int reqeustCode, List<PhotoInfo> resultList) {
            if (resultList != null) {

                for (int i = 0; i < resultList.size(); i++) {
                    PhotoInfo photoInfo = resultList.get(i);
                    String path = photoInfo.getPhotoPath();
                    Log.e("onHanlderSuccess",path);
                }

            }
        }

        @Override
        public void onHanlderFailure(int requestCode, String errorMsg) {
            Toast.makeText(ImageMainActivity.this, errorMsg, Toast.LENGTH_SHORT).show();
        }
    };
}
