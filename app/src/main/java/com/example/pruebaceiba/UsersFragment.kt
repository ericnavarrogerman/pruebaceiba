package com.example.pruebaceiba

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.pruebaceiba.databinding.FragmentUserBinding


class UsersFragment : Fragment() {

    private var _binding: FragmentUserBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentUserBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }


    fun goToPostWithUserId(userId:Int){
        findNavController()
            .navigate(UsersFragmentDirections.actionFirstFragmentToSecondFragment(userId))
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}