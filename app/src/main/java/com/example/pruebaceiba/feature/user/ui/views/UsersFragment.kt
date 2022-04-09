package com.example.pruebaceiba.feature.user.ui.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.pruebaceiba.R
import com.example.pruebaceiba.core.visible
import com.example.pruebaceiba.feature.user.ui.adapters.UserAdapter
import com.example.pruebaceiba.databinding.FragmentUserBinding
import com.example.pruebaceiba.feature.user.ui.models.ItemUser
import com.example.pruebaceiba.feature.user.ui.models.UserViewModel

class UsersFragment : Fragment() {

    private var _binding: FragmentUserBinding? = null

    private val binding get() = _binding!!

    lateinit var adapter: UserAdapter

    val model: UserViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = DataBindingUtil.inflate(inflater, R.layout.fragment_user,container,false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.fragment = this

        var list:List<ItemUser> = arrayListOf(
            ItemUser("eric","3104113735", "eric@gmail.com",1),
            ItemUser("arelis","3104113735", "eric@gmail.com",2),
            ItemUser("libardo","3104113735", "eric@gmail.com",3),
            ItemUser("rosmira","3104113735", "eric@gmail.com",4),
            ItemUser("german","3104113735", "eric@gmail.com",5),
            ItemUser("karina","3104113735", "eric@gmail.com",6),
            ItemUser("andrea","3104113735", "eric@gmail.com",7),
            ItemUser("marcelo","3104113735", "eric@gmail.com",8)
            )

        adapter = UserAdapter(::goToPostWithUserId) {
            binding.textViewListEmpty.visible(it)
        }.apply {
                setData(list)
            }
        binding.list.adapter = adapter



    }


    fun textChange(s:CharSequence,i:Int,j:Int,k:Int){
            adapter.setWordSearch(s.toString())
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

