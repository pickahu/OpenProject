package pickahu.openproject.UniversalImageLoader.adapter;


import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.download.ImageDownloader;

import java.util.List;

import pickahu.openproject.R;
import pickahu.openproject.UniversalImageLoader.bean.Photo;

public class ImagesAdapter extends BaseAdapter {

	private Context context;
	private List<Photo> mData;
	private ImageLoader imageLoader;
	private DisplayImageOptions options;

	public List<Photo> getData() {
		return mData;
	}

	// 构造方法
	public ImagesAdapter(List<Photo> mData, Context context) {
		super();
		this.mData = mData;
		this.context = context;
		initImageLoader();
	}

	private void initImageLoader(){
		options = new DisplayImageOptions.Builder()
				.showImageOnLoading(R.drawable.image_default)
				.showImageOnFail(R.drawable.image_err)
				.cacheInMemory(true)
				.cacheOnDisk(true)
				.bitmapConfig(Bitmap.Config.RGB_565)
				.build();

		imageLoader = ImageLoader.getInstance();


	}

	// 设置数据
	public void setData(List<Photo> mData) {
		this.mData = mData;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mData.size();
	}

	@Override
	public Photo getItem(int position) {
		// TODO Auto-generated method stub
		return mData.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		ViewHodler hodler = null;
		if (convertView == null) {
			hodler = new ViewHodler();
			convertView = View.inflate(context, R.layout.item_show_gridview, null);
			hodler.ivImage = (ImageView) convertView
					.findViewById(R.id.iv_grid_image);
			
			convertView.setTag(hodler);
		} else {
			hodler = (ViewHodler) convertView.getTag();
		}
		hodler.ivImage
				.setImageResource(R.drawable.image_default);
		
		// TODO Auto-generated method stub

		String imagePath = getItem(position).getPath();
		String imageUrl = ImageDownloader.Scheme.FILE.wrap(imagePath);

		imageLoader.displayImage(imageUrl, hodler.ivImage, options);

		return convertView;
	}

	static class ViewHodler {
		ImageView ivImage;
	}

}
