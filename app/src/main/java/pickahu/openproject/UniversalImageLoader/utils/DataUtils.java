package pickahu.openproject.UniversalImageLoader.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.provider.MediaStore;

import pickahu.openproject.UniversalImageLoader.bean.Photo;


public class DataUtils {
	
	private Context context;
	public DataUtils(Context context) {
		super();
		this.context = context;
	}

	//获取所有图片路径
	public List<Photo> getImagesPath() {
			List<Photo> images = new ArrayList<Photo>();
			ContentResolver contentResolver = context.getContentResolver();
			Cursor cursor = contentResolver.query(
					MediaStore.Images.Media.EXTERNAL_CONTENT_URI, null, null, null,
					MediaStore.Images.Media.DATE_MODIFIED);
			if (cursor != null) 
			{
				while (cursor.moveToNext()) 
				{
					//图片路径
					String path = cursor.getString(1);
					//图片大小
					String size = cursor.getString(2);
					//图片名称
					String name = cursor.getString(3);
					//最后修改日期
					String date = cursor.getString(7);
					
					File file = new File(path);
					String dir = file.getParent();
					String[] split = dir.split(File.separator);
					//图片所在文件夹
					String dirName = split[split.length -1];
					
					Photo photo = new Photo(name, path, dirName, size, date);
					images.add(photo);
				}
			
		    }
			return images;
	 }
			
		
}
