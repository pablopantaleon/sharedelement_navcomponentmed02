package com.ppantaleon.sharedelement_navcomp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.ppantaleon.sharedelement_navcomp.databinding.FragmentAssetBinding
import com.ppantaleon.sharedelement_navcomp.databinding.FragmentGlideBinding

/**
 * Created by Pablo Reyes [devpab@gmail.com] on 2/28/21.
 */
class GlideExampleFragment : Fragment() {

    // view-binding stuff (you can ignore this)
    private var _binding: FragmentGlideBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentGlideBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.imageView.apply {
            // load image
            Glide.with(this)
                .load(IMAGE)
                .into(this)

            setOnClickListener {
                // tell to Fragment Navigator that we are sending a shared element
                // and it has the transition name=sharedElement (you can use any name)
                val extras = FragmentNavigatorExtras(this to "sharedElement")

                // this is not required; we're sending the image url to the detail screen
                // so it can load the same url
                val bundle = bundleOf(ARG_IMAGE_URL to IMAGE)

                // navigate to detail page
                findNavController().navigate(
                    R.id.action_glide_to_glideDetail, bundle, null, extras)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {
        const val IMAGE = "https://i.pinimg.com/originals/3c/9a/67/3c9a6725ee604c6057d8a65a02c005ac.jpg"
        const val ARG_IMAGE_URL = "arg.image_url"
    }
}