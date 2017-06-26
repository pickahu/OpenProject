package pickahu.openproject.Recyclerview;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import pickahu.openproject.R;

/**
 * Created by Administrator on 2017/6/26.
 */

public class RecyclerviewGridActivity extends Activity {

    private RecyclerView mRecView;
    private List<String> mData;
    private MyAdapter mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_rec);
        initData();
        initViews();

    }

    private void initViews() {
        mRecView = (RecyclerView) findViewById(R.id.id_recyclerview);
//        mRecView.setLayoutManager(new GridLayoutManager(this,4));
        mRecView.setLayoutManager(new StaggeredGridLayoutManager(4,StaggeredGridLayoutManager.HORIZONTAL));
        mAdapter = new MyAdapter();
        mRecView.setAdapter(mAdapter);

        mRecView.addItemDecoration(new DividerGridItemDecoration(this));
    }

    private void initData() {

        mData = new ArrayList<>();
        for (int i = 'A'; i < 'Z'; i++) {
            mData.add((char)i+"");
        }
    }


    class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            MyViewHolder holder = new MyViewHolder(LayoutInflater.from(RecyclerviewGridActivity.this).inflate(R.layout.item_rec, parent,false));
            return holder;
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {

            holder.tvTitle.setText(mData.get(position));
        }


        @Override
        public int getItemCount() {
            return mData.size();
        }

        class MyViewHolder extends RecyclerView.ViewHolder {
            TextView tvTitle;

            public MyViewHolder(View view) {
                super(view);
                tvTitle = (TextView) view.findViewById(R.id.item_tv_title);
            }
        }
    }


}
