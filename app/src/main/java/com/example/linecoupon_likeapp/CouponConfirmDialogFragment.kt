package com.example.linecoupon_likeapp

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.annotation.Nullable
import androidx.fragment.app.DialogFragment
import com.example.linecoupon_likeapp.databinding.FragmentCouponConfirmDialogBinding


class CouponConfirmDialogFragment : DialogFragment() {

    // クリックイベント発火を伝えるために使用するインターフェースインスタンスを定義
    private lateinit var listener: CouponConfirmDialogListener

    private var _binding: FragmentCouponConfirmDialogBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    // イベントのコールバックを受け取るためのインターフェースを実装
    interface CouponConfirmDialogListener {
        fun onDialogPositiveClick(dialog: DialogFragment)
    }

    /*
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCouponConfirmDialogBinding.inflate(inflater, container, false)
        return binding.root
    }

     */

    override fun onAttach(context: Context) {
        super.onAttach(context)
        // Verify that the host activity implements the callback interface
        try {
            // Instantiate the NoticeDialogListener so we can send events to the host
            listener = parentFragment as CouponConfirmDialogListener
        } catch (e: ClassCastException) {
            // The activity doesn't implement the interface, throw exception
            throw ClassCastException(
                (context.toString() +
                        " must implement CouponConfirmDialogListener")
            )
        }
    }

    override fun onCreateDialog(@Nullable savedInstanceState: Bundle?): Dialog {
        /*
        val builder: AlertDialog.Builder = AlertDialog.Builder(activity)
        builder
            .setTitle("クーポンを使用済みにしますか？")
            .setMessage("この操作は取り消せません。店舗スタッフに[使用済みにする]をタップしてもらってください。店舗の指示がある場合は、ご自身で使用済みにしてください。")
            .setPositiveButton("使用済みにする", DialogInterface.OnClickListener { _, _ ->
                // このボタンを押した時の処理を書きます。
                // 処理を親のフラグメントにコールバックする・・・④
                listener.onDialogPositiveClick(this)
            })
            .setNegativeButton("キャンセル", null)
        return builder.create()

         */
        val dialog = Dialog(requireActivity())
        /*
        // タイトル非表示
        dialog.window!!.requestFeature(Window.FEATURE_NO_TITLE)
        // フルスクリーン
        dialog.window!!.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN
        )

         */
        dialog.setContentView(R.layout.fragment_coupon_confirm_dialog)
        // 背景を透明にする
        //dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        // OK ボタンのリスナ
        dialog.findViewById<View>(R.id.positiveButton)
            .setOnClickListener() {
                listener.onDialogPositiveClick(this)
                dismiss()
            }
        // Close ボタンのリスナ
        dialog.findViewById<View>(R.id.negativeButton).setOnClickListener() {
            dismiss()
        }

        return dialog
    }
}