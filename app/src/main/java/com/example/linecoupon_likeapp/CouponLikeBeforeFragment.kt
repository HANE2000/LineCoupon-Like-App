package com.example.linecoupon_likeapp

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import com.example.linecoupon_likeapp.databinding.FragmentCouponLikeBeforeBinding


/**
 * A simple [Fragment] subclass.
 * Use the [CouponLikeBeforeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CouponLikeBeforeFragment : Fragment(),
    CouponConfirmDialogFragment.CouponConfirmDialogListener {

    private lateinit var mainActivity: MainActivity

    private var _binding: FragmentCouponLikeBeforeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private var isCouponUsed = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mainActivity = activity as MainActivity
        _binding = FragmentCouponLikeBeforeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        // TODO: 期限をパターン設けて、設定画面で設定できるようにする

        /*
        // Androidのシステム時間の4日後を期限として表示 (一番星の)
        "${mainActivity.get4DaysLaterDate()} 23:59まで".also {
            binding.couponLimitText.text = it
        }

         */

        // Raku SPA 鶴見11月分の(突貫対応)
        binding.couponLimitText.text = "2024/03/31 23:59まで"


        binding.closeButton.setOnClickListener {
            mainActivity.replaceFragment(R.id.container, TitleFragment())
        }
        binding.showCouponButton.setOnClickListener {
            // 未使用の場合のみダイアログ開くようにする
            if (!isCouponUsed) {
                // showCouponUsedLayout()
                val dialogFragment: DialogFragment = CouponConfirmDialogFragment()
                dialogFragment.show(childFragmentManager, "my_dialog")
            }
        }
    }

    // コールバックされて実行される処理・・・⑤
    override fun onDialogPositiveClick(dialog: DialogFragment) {
        // ボタンに表示されている文字を変更
        showCouponUsedLayout()
        isCouponUsed = true
    }

    /** クーポン使用済みのレイアウトを表示
     *
     */
    private fun showCouponUsedLayout() {
        /*
        ToastはAndroid12以降で仕様が変わったため、良くない（表示が2行まで & アプリアイコンが一緒に表示されてしまう）
        val toast = Toast.makeText(activity, "　　　　　✔　　　　　\n\n️クーポンを使用しました", Toast.LENGTH_SHORT)
        toast.setGravity(Gravity.CENTER, 0, 0)
        toast.show()

         */
        binding.toastView.visibility = View.VISIBLE
        Handler(Looper.getMainLooper()).postDelayed({
            binding.toastView.visibility = View.GONE
        }, 2000)

        // TODO: 画像のセットを設定画面から自由に切り替えられるようにする
        //binding.couponImage.setImageResource(R.drawable.coupon_img_kawasaki_after)
        //binding.couponImage2.setImageResource(R.drawable.coupon_img_kawasaki_2_after)
        binding.couponImage.setImageResource(R.drawable.coupon_img_naito_after)
        binding.couponImage2.setImageResource(R.drawable.coupon_img_naito_2_after)

        binding.showCouponButton.setBackgroundResource(R.drawable.coupon_button_used_border)
        binding.showCouponButton.text = "|■ 使用済み"
    }
}