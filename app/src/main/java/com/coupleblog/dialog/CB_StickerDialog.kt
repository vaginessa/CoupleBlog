package com.coupleblog.dialog

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import com.coupleblog.R
import com.coupleblog.singleton.CB_AppFunc
import com.coupleblog.singleton.CB_SingleSystemMgr
import com.coupleblog.singleton.CB_ViewModel

class CB_StickerDialog(context: Context) : Dialog(context)
{
    init
    {
        val binding: ImageBinding = DataBindingUtil.inflate(LayoutInflater.from(context),
            R.layout.dialog_cb_sticker, null, false)
        setContentView(binding.root)
        binding.viewModel = CB_ViewModel.Companion
        binding.dialog = this@CB_StickerDialog

        window!!.apply{
            setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        }

        setCanceledOnTouchOutside(false)
        CB_SingleSystemMgr.registerDialog(CB_SingleSystemMgr.DIALOG_TYPE.STICKER)
        show()
    }

    fun exitButton() = onBackPressed()

    override fun dismiss()
    {
        super.dismiss()
        CB_SingleSystemMgr.releaseDialog(CB_SingleSystemMgr.DIALOG_TYPE.STICKER)
    }
}