package com.example.kevin.myapplication.activity

import android.content.Context
import android.support.v4.view.PagerAdapter
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.kevin.myapplication.R
import com.example.kevin.myapplication.model.Photo


class FlickerPagerAdapter(val context: Context) : PagerAdapter() {

    private var photos: MutableList<Photo> = arrayListOf()

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val inflater = LayoutInflater.from(context)
        val layout = inflater.inflate(R.layout.flicker_photo, container, false) as ViewGroup
        val image: ImageView = layout.findViewById(R.id.flicker_image);
        val photo: Photo = photos.get(position)
        loadImage(photo.url_l, image)
        Log.e("Url", photo.toString())
        container.addView(layout)
        return layout
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

    override fun getCount(): Int {
        return photos.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }

    fun addPhotos(photos: List<Photo>){
        this.photos.addAll(photos)
        notifyDataSetChanged()
    }

    private fun loadImage(url: String?, image: ImageView){
        Glide.with(context)
                .load(url)
                .placeholder(R.drawable.placeholder)
                .centerCrop()
                .dontAnimate()
                .into(image)
    }

}