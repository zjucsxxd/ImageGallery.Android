package br.com.infoglobo.example.imagegallery.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import br.com.infoglobo.example.imagegallery.R;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

public class BottomImagePagerAdapter extends BaseAdapter {

	private String[] images;
	private LayoutInflater inflater;
	private ImageLoader imageLoader = ImageLoader.getInstance();
	private DisplayImageOptions options;
	
	public int selectedPosition;

	public BottomImagePagerAdapter(Context context, String[] images,
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
		View contentView = inflater.inflate(
				R.layout.adapter_bottom_gallery_pager, parent, false);

		ImageView image = (ImageView) contentView.findViewById(R.id.image);
		ImageView shadow = (ImageView) contentView.findViewById(R.id.shadow);

		int visibility = (this.selectedPosition == position) ? View.GONE
				: View.VISIBLE;
		shadow.setVisibility(visibility);

		imageLoader.displayImage(this.images[position], image, options);

		return contentView;
	}

}