package pickahu.openproject.retrofit2;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import pickahu.openproject.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrator on 2017/7/30.
 */

public class Retrofit2Activity extends Activity {
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit2);
        tv = (TextView)findViewById(R.id.tv_retrofit);

        Call<Info> call = RetrofitUtils.getInstance().getData();
        call.enqueue(new Callback<Info>() {
            @Override
            public void onResponse(Call<Info> call, Response<Info> response) {
                tv.setText(response.body().result.data.get(0).content);
            }

            @Override
            public void onFailure(Call<Info> call, Throwable t) {

            }
        });

    }
}
