package com.ppantaleon.sharedelement_navcomp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import com.ppantaleon.sharedelement_navcomp.databinding.FragmentAssetBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class AssetExampleFragment : Fragment() {

    // view-binding stuff (you can ignore this)
    private var _binding: FragmentAssetBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentAssetBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.imageView.setOnClickListener {
            // tell to Fragment Navigator that we are sending a shared element
            // and it has the transition name=sharedElement (you can use any name)
            val extras = FragmentNavigatorExtras(
                binding.imageView to "sharedElement"
            )

            // navigate to detail page
            findNavController().navigate(
                R.id.action_asset_to_assetDetail, null, null, extras)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}