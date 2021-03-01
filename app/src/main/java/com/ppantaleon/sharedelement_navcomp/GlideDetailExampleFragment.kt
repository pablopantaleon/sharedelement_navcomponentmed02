package com.ppantaleon.sharedelement_navcomp

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.transition.TransitionInflater
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.ppantaleon.sharedelement_navcomp.databinding.FragmentGlideDetailBinding

/**
 * Created by Pablo Reyes [devpab@gmail.com] on 2/28/21.
 */
class GlideDetailExampleFragment : Fragment() {

    // view-binding stuff (you can ignore this)
    private var _binding: FragmentGlideDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentGlideDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // this line is required, this define what animation we want to play for transition
        sharedElementEnterTransition = TransitionInflater.from(context)
            .inflateTransition(R.transition.se_transition)

        // postpone transition until the image is already load
        postponeEnterTransition()

        // load images from network could take some time, that's why we're postponing the
        // transition, we need to be sure until the image is ready in order to play an smooth animation
        val imageUrl = arguments?.getString(GlideExampleFragment.ARG_IMAGE_URL) ?: ""
        Glide.with(this)
            .load(imageUrl)
            .dontAnimate()  // we don't want any glide animation, we're using our own animation
            .listener(object : RequestListener<Drawable> {
                // We define this lister to know when the image is already loaded, this is
                // because we want to wait until the image is ready to resume the transition
                // in order to show an smooth shared-element transition
                override fun onLoadFailed(
                    e: GlideException?,
                    model: Any?,
                    target: com.bumptech.glide.request.target.Target<Drawable>?,
                    isFirstResource: Boolean
                ): Boolean {
                    // resume transition
                    startPostponedEnterTransition()
                    return false
                }

                override fun onResourceReady(
                    resource: Drawable,
                    model: Any,
                    target: com.bumptech.glide.request.target.Target<Drawable>,
                    dataSource: DataSource,
                    isFirstResource: Boolean
                ): Boolean {
                    // resume transition
                    startPostponedEnterTransition()
                    return false
                }
            })
            .into(binding.imageViewSecond)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}