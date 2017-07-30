package pickahu.openproject.Recyclerview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import pickahu.openproject.BaseActivity;
import pickahu.openproject.R;

/**
 * Created by Administrator on 2017/6/26.
 */

public class RecyclerviewPubuActivity extends BaseActivity {

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
        mRecView.setLayoutManager(new StaggeredGridLayoutManager(4,StaggeredGridLayoutManager.VERTICAL));
        mAdapter = new MyAdapter();
        mRecView.setAdapter(mAdapter);

        mAdapter.setOnItemClickLitener(new OnItemClickLitener() {
            @Override
            public void onItemClick(View view, int position) {
                showToast("单击"+position);
            }

            @Override
            public void onItemLongClick(View view, int position) {
                showToast("长按"+position);
            }
        });

    }

    private void initData() {

        mData = new ArrayList<>();
        for (int i = 'A'; i < 'Z'; i++) {
            mData.add((char)i+"");
        }
    }


    class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{

        private OnItemClickLitener mOnItemClickLitener;

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            MyViewHolder holder = new MyViewHolder(LayoutInflater.from(RecyclerviewPubuActivity.this).inflate(R.layout.item_rec, parent,false));
            return holder;
        }

        public void setOnItemClickLitener(OnItemClickLitener mOnItemClickLitener)
        {
            this.mOnItemClickLitener = mOnItemClickLitener;
        }

        @Override
        public void onBindViewHolder(final MyViewHolder holder, final int position) {
            
            ViewGroup.LayoutParams layoutParams = holder.tvTitle.getLayoutParams();
            layoutParams.height = produceRandom(200,400);
            holder.tvTitle.setLayoutParams(layoutParams);
            holder.tvTitle.setText(mData.get(position));

            if(mOnItemClickLitener != null)
            {
                holder.tvTitle.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        mOnItemClickLitener.onItemClick(holder.tvTitle,position);
                    }
                });

                holder.tvTitle.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View v) {
                        mOnItemClickLitener.onItemLongClick(holder.tvTitle,position);
                        return false;
                    }
                });
            }
        }

        private int produceRandom(int min,int max){
            Random random = new Random();
            return random.nextInt(max)%(max-min+1) + min;
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
