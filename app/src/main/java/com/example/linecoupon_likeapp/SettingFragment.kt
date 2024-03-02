package com.example.linecoupon_likeapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import com.example.linecoupon_likeapp.databinding.FragmentSettingBinding


class SettingFragment : Fragment() {

    private var _binding: FragmentSettingBinding? = null
    private val binding get() = _binding!!

    var adapter: ArrayAdapter<String>? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSettingBinding.inflate(inflater, container, false)
        return binding.root
    }

    protected fun setAdapters() {
        context?.let {
            // TODO: List(今はMainActivityにベタ書きしてる)の内容をどうにかして渡す
            /*
            adapter = ArrayAdapter(it, R.layout.list_item)<String>(
                this,
                android.R.layout.simple_list_item_1,
                dataList
            )
            listView.setAdapter(adapter)

             */
        }
    }

}