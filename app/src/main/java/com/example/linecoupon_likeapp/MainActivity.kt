package com.example.linecoupon_likeapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date

class MainActivity : AppCompatActivity() {

    private var fragmentManager: FragmentManager = supportFragmentManager
    private var fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()

    var couponList = {
        Coupon(
            "夕焼け一番星 ドリンク無料",
            R.drawable.coupon_img_kawasaki,
            R.drawable.coupon_img_kawasaki_2,
            R.drawable.coupon_img_kawasaki_after,
            R.drawable.coupon_img_kawasaki_2_after
        )
        Coupon(
            "RAKU SPA鶴見 入場無料",
            R.drawable.coupon_img_rakuspa,
            R.drawable.coupon_img_rakuspa_2,
            R.drawable.coupon_img_rakuspa_after,
            R.drawable.coupon_img_rakuspa_2_after
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fragmentManager = supportFragmentManager
        fragmentTransaction = fragmentManager.beginTransaction()

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, TitleFragment.newInstance())
                .commitNow()
        }
    }

    // LinearLayoutのコンテナをfragment指定 + replaceする
    // 引数は 「new Fragmentを継承しているクラスのインスタンス()」
    fun replaceFragment(layout: Int, fragment: Fragment) {
        fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(
            layout,
            fragment
        ) // ここFragmentのインスタンスはsupport.v4のものであること！！
        fragmentTransaction.commit()
    }

    /**
     * 現在日時 + 4日後をyyyy/MM/dd 形式で取得
     */
    fun get4DaysLaterDate(): String? {
        val df: DateFormat = SimpleDateFormat("yyyy/MM/dd")
        val calendar = Calendar.getInstance()

        calendar.time = Date(System.currentTimeMillis())
        calendar.add(Calendar.DAY_OF_MONTH, 4)

        val date = calendar.time
        return df.format(date)
    }
}