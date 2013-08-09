package br.com.infoglobo.example.imagegallery;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

class BottomImagePagerAdapter extends BaseAdapter {

	private String[] images;
	private LayoutInflater inflater;
	private ImageLoader imageLoader = ImageLoader.getInstance();
	private DisplayImageOptions options;

	BottomImagePagerAdapter(Context context, String[] images,
			ImageLoader imageLoader) {
		this.images = images;
		this.inflater = LayoutInflater.from(context);
		this.imageLoader = imageLoader;

		options = new DisplayImageOptions.Builder()
				.showStubImage(R.drawable.ic_empty)
				.showImageForEmptyUri(R.drawable.ic_empty)
				.showImageOnFail(R.drawable.ic_error).cacheInMemory(true)
				.cacheOnDisc(true).bitmapConfig(Bitmap.Config.RGB_565).build();
	}

	@Override
	public int getCount() {
		return this.images.length;
	}

	@Override
	public Object getItem(int position) {
		return position;
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ImageView imageView = (ImageView) convertView;
		if (imageView == null) {
			imageView = (ImageView) inflater.inflate(
					R.layout.adapter_bottom_gallery_pager, parent, false);
		}
		imageLoader.displayImage(this.images[position], imageView, options);
		return imageView;
	}

}