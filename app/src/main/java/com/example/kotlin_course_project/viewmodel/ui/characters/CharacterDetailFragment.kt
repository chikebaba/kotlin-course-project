package com.example.kotlin_course_project.viewmodel.ui.characters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlin_course_project.databinding.FragmentCharacterDetailBinding
import com.example.kotlin_course_project.viewmodel.ui.episodes.adapter.EpisodesAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CharacterDetailFragment : Fragment() {

    private var _binding: FragmentCharacterDetailBinding? = null
    private val binding get() = _binding!!
    private val characterArgument: CharacterDetailFragmentArgs by navArgs()
    private lateinit var viewModel: CharacterDetailViewModel
    private val adapter: EpisodesAdapter by lazy { EpisodesAdapter() }

    override
    fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentCharacterDetailBinding.inflate(layoutInflater, container, false)

        viewModel = ViewModelProvider(this)[CharacterDetailViewModel::class.java]

        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel

        val characterID = characterArgument.characterID

        viewModel.setCharacterId(characterID)
        viewModel.getCharacterInvoke()

binding.apply {
        recyclerViewEpisode.layoutManager = LinearLayoutManager(requireContext())
        recyclerViewEpisode.adapter = adapter

        locationGroup.setOnClickListener {
            val locationUrl = viewModel.getLocationUrl()

            locationUrl?.let {
                val locationId = (locationUrl.split("/"))[5].toInt()
                viewModel.setNavigateLocationId(locationId)

                if (viewModel.getNavigationLocationID() != null) {

                    navigateToLocationDetail(viewModel.getNavigationLocationID()!!)
                    viewModel.displayDetailComplete()
                }
            }
        }
        imageButton.setOnClickListener {
            findNavController().popBackStack()
        }
        return root
    }
    private fun navigateToLocationDetail(locationID: Int) {
        val action =
            CharacterDetailFragmentDirections.actionToLocationDetail(
                locationID,
                false
            )
        action.characterID = viewModel.getCharacterIDFromFragmentList()
        findNavController().navigate(action)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
