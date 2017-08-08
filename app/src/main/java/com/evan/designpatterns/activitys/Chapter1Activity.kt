package com.evan.designpatterns.activitys

import android.Manifest
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ImageView
import android.widget.Toast
import com.evan.designpatterns.R
import com.evan.designpatterns.chapter1.DoubleCache
import com.evan.designpatterns.chapter1.ImageLoader
import com.tbruyelle.rxpermissions.RxPermissions

class Chapter1Activity : AppCompatActivity() {

    var rxPermissions: RxPermissions? = null

    private lateinit var  imageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_capter1)

        imageView = findViewById(R.id.iv_) as ImageView


        rxPermissions = RxPermissions(this)
        rxPermissions!!.request(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                .subscribe{if(it) loadImage() else {
                    Toast.makeText(this, "请打开文件读写权限！", Toast.LENGTH_SHORT).show()
                }
                }

    }

    private fun loadImage(){

        ImageLoader.imageLoader.setImageCache(DoubleCache())
//        https://ws1.sinaimg.cn/large/610dc034gy1fi678xgq1ij20pa0vlgo4.jpg
        ImageLoader.imageLoader.displayImageView(imageView,"https://wwws.sinaimg.cn/dy/slidenews/1_img/2017_29/88490_1334396_633374.jpg")
    }

}
