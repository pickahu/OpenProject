package pickahu.openproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import pickahu.openproject.UniversalImageLoader.LocalImageLoadActivity;
import pickahu.openproject.UniversalImageLoader.NetImageLoadActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initData();

    }

    private void initView(){

        findViewById(R.id.btn_net_image).setOnClickListener(this);
        findViewById(R.id.btn_local_image).setOnClickListener(this);
    }

    private void initData(){

    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.btn_net_image:
                startActivity(new Intent(MainActivity.this, NetImageLoadActivity.class));
                break;
            case R.id.btn_local_image:
                startActivity(new Intent(MainActivity.this, LocalImageLoadActivity.class));
                break;
        }
    }
}
