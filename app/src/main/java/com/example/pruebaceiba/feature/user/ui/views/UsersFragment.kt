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
import com.example.pruebaceiba.core.closeProgressDialog
import com.example.pruebaceiba.core.showDialog
import com.example.pruebaceiba.core.showProgressDialog
import com.example.pruebaceiba.core.visible
import com.example.pruebaceiba.feature.user.ui.adapters.UserAdapter
import com.example.pruebaceiba.databinding.FragmentUserBinding
import com.example.pruebaceiba.feature.user.ui.models.ItemUser
import com.example.pruebaceiba.feature.user.ui.models.UserViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UsersFragment : Fragment() {

    private var _binding: FragmentUserBinding? = null

    private val binding get() = _binding!!

    lateinit var adapter: UserAdapter

    val model: UserViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = DataBindingUtil.inflate(inflater, R.layout.fragment_user, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        model.fecthDataFromServer()
        binding.fragment = this


        adapter = UserAdapter(::goToPostWithUserId) {
            binding.textViewListEmpty.visible = it
        }

        binding.list.adapter = adapter


        model.result.observe(viewLifecycleOwner) {


                if (it!=null) {
                    if (it.isLoading) showProgressDialog() else closeProgressDialog()
                    if (it.showError) showDialog(
                        subTitle = "Ha ocurrido un error al descargar los datos.",
                        message = it.error,
                        iconDrawable = R.drawable.ic_error,
                        textBtnCancel = R.string.cerrar,
                        textBtnOK = R.string.reintentar
                    ) { model.fecthDataFromServer();closeProgressDialog() }
                    if (it.data.isNotEmpty()) adapter.setData(it.data)
                }else{
                    model.fecthDataFromServer()
                }
        }

    }


    fun textChange(s: CharSequence, i: Int, j: Int, k: Int) {
        adapter.setWordSearch(s.toString())

    }


    fun goToPostWithUserId(user: ItemUser) {
        findNavController()
            .navigate(UsersFragmentDirections.actionFirstFragmentToSecondFragment(user))
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}

