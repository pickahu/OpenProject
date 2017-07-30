package pickahu.openproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import pickahu.openproject.ActivityShow.ShowStyleActivity;
import pickahu.openproject.Database.DbUtils.DbUtilsActivity;
import pickahu.openproject.Glide.GlideLocalActivity;
import pickahu.openproject.Glide.GlideNetActivity;
import pickahu.openproject.Recyclerview.RecyclerviewGridActivity;
import pickahu.openproject.Recyclerview.RecyclerviewListActivity;
import pickahu.openproject.Recyclerview.RecyclerviewPubuActivity;
import pickahu.openproject.UniversalImageLoader.LocalImageLoadActivity;
import pickahu.openproject.UniversalImageLoader.NetImageLoadActivity;
import pickahu.openproject.imagesSelect.ImageMainActivity;
import pickahu.openproject.retrofit2.Retrofit2Activity;

public class MainActivity extends BaseActivity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initData();

    }

    private void initView() {

        findViewById(R.id.btn_net_image).setOnClickListener(this);
        findViewById(R.id.btn_local_image).setOnClickListener(this);
        findViewById(R.id.btn_glide_local_image).setOnClickListener(this);
        findViewById(R.id.btn_glide_net_image).setOnClickListener(this);
        findViewById(R.id.btn_images_select).setOnClickListener(this);
        findViewById(R.id.btn_dbutils).setOnClickListener(this);
        findViewById(R.id.btn_recyclerview_list).setOnClickListener(this);
        findViewById(R.id.btn_recyclerview_grid).setOnClickListener(this);
        findViewById(R.id.btn_recyclerview_pubu).setOnClickListener(this);
        findViewById(R.id.btn_retrofit).setOnClickListener(this);
        findViewById(R.id.btn_activity_show).setOnClickListener(this);
    }

    private void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_net_image:
                startActivity(new Intent(MainActivity.this, NetImageLoadActivity.class));
                break;
            case R.id.btn_local_image:
                startActivity(new Intent(MainActivity.this, LocalImageLoadActivity.class));
                break;
            case R.id.btn_glide_local_image:
                startActivity(new Intent(MainActivity.this, GlideLocalActivity.class));
                break;
            case R.id.btn_glide_net_image:
                startActivity(new Intent(MainActivity.this, GlideNetActivity.class));
                break;
            case R.id.btn_images_select:
                startActivity(new Intent(MainActivity.this, ImageMainActivity.class));
                break;
            case R.id.btn_dbutils:


                startActivity(new Intent(MainActivity.this, DbUtilsActivity.class));
                break;

            case R.id.btn_recyclerview_list:
                startActivity(new Intent(MainActivity.this, RecyclerviewListActivity.class));
                break;

            case R.id.btn_recyclerview_grid:
                startActivity(new Intent(MainActivity.this, RecyclerviewGridActivity.class));
                break;

            case R.id.btn_recyclerview_pubu:
                startActivity(new Intent(MainActivity.this, RecyclerviewPubuActivity.class));
                break;

            case R.id.btn_retrofit:
                startActivity(new Intent(MainActivity.this, Retrofit2Activity.class));
                break;

            case R.id.btn_activity_show:
                startActivity(new Intent(MainActivity.this, ShowStyleActivity.class));
                break;


        }
    }
}
