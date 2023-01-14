package com.example.kotlin_course_project.viewmodel.ui.episodes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import com.example.kotlin_course_project.databinding.FragmentEpisodeDetailBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class EpisodeDetailFragment : Fragment() {

    private var _binding: FragmentEpisodeDetailBinding? = null
    private val binding get() = _binding!!
    private val episodeDetailArgs: EpisodeDetailFragmentArgs by navArgs()
    private val viewModel: EpisodeDetailViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentEpisodeDetailBinding.inflate(layoutInflater, container, false)


        binding.lifecycleOwner = viewLifecycleOwner
        val episodeId = episodeDetailArgs.episodeId
        viewModel.setEpisodeId(episodeId)

        viewModel.getEpisodeDetail()

        binding.viewModel = viewModel

        prepareAdapter()

        binding.imageButton.setOnClickListener {
            findNavController().popBackStack()
        }

        return binding.root
    }


    private fun prepareAdapter() {
        val adapter = LocationDetailAdapter(
            ItemClickListener { characterId ->
                navigateToCharacterDetail(characterId)
            }
        )

        binding.recyclerView.adapter = adapter


        binding.recyclerView.layoutManager = GridLayoutManager(requireContext(), spanCount)

    }

    private fun navigateToCharacterDetail(characterId: Int) {
        val action = EpisodeDetailFragment.actionToCharacterDetailFragment(
            characterId
        )
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